package Modelo;

import es.usal.progiii.tools.Rutas;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.lang.reflect.Type;
import java.io.IOException;
import java.nio.file.*;
import java.nio.charset.StandardCharsets;


public class Modelo{

    private HashMap<Integer,Libro> libros=new HashMap<>();

    public boolean añadirLibro(String titulo, String autor, int isbn){
        boolean encontrado=buscarLibro(isbn);
        if(encontrado){
            return false;
        }else{
            libros.put(isbn,new Libro(titulo, autor));
            return true;
        }
    }

    public boolean eliminarLibro(int isbn){
        boolean encontrado=buscarLibro(isbn);
        if(!encontrado){
            return false;
        }else{
            libros.remove(isbn);
            return true;
        }
    }

    public void modificarLibro(String titulo, String autor, int isbn){
        libros.put(isbn,new Libro(titulo, autor));
    }

    public boolean buscarLibro(int isbn){
        if(libros.containsKey(isbn)) return true;
        else return false;
    }

    public int[] getLongitudes(){
        int[] longitudes= new int[]{0,0};
        for(Libro libro:libros.values()){
            for(int i=0;i<2;i++){
                int[] longitudesLibro=libro.getLongitudes();
                longitudes[i]=Math.max(longitudes[i],longitudesLibro[i]);
            }
        }
        return longitudes;
    }

    public int exportarCsv() throws IOException{
        if(libros==null||libros.isEmpty()){
            return 1;
        }
        Path ruta=Rutas.pathToFileOnDesktop("libros.csv");
        ArrayList<String> contenido=new ArrayList<>();
        contenido.add("Titulo,Autor,ISBN");
        for(Map.Entry<Integer, Libro> libro:libros.entrySet()){
            contenido.add(String.format("%s,%s,%d",libro.getValue().getTitulo(),libro.getValue().getAutor(),libro.getKey()));
        }
        Files.write(ruta, contenido, StandardCharsets.UTF_8);
        return 2;
    }

    public int importarCsv() throws IOException{
        Path ruta=Rutas.pathToFileOnDesktop("libros.csv");
        if(!Files.exists(ruta)){
                return 1;
        }
        List<String> lineas=Files.readAllLines(ruta);
        if(lineas.isEmpty()){
            return 2;
        }
        if(!lineas.get(0).equals("Titulo,Autor,ISBN")){
            return 3;
        }
        for(int i=1;i<lineas.size();i++){
            if(lineas.get(i).split(",").length!=3){
                return 4;
            }
            String[] linea=lineas.get(i).split(",");
            try{
                int isbn=Integer.parseInt(linea[2]);
                libros.put(isbn,new Libro(linea[0],linea[1]));     
            }catch(NumberFormatException e){
                return 4;
            }       
        }
        return 5;
    }

    public int exportarJson() throws IOException{
        if(libros==null||libros.isEmpty()){
            return 1;
        }
        Path ruta=Rutas.pathToFileOnDesktop("libros.json");
        Gson gson=new Gson();
        String json=gson.toJson(libros);
        Files.write(ruta, json.getBytes(StandardCharsets.UTF_8));
        return 2;
    }

    public int importarJson() throws IOException{
        Path ruta=Rutas.pathToFileOnDesktop("libros.json");
        if(!Files.exists(ruta)){
                return 1;
        }
        Gson gson=new Gson();
        String json=new String(Files.readAllBytes(ruta),StandardCharsets.UTF_8);
        Type tipoMapa;
        HashMap<Integer, Libro> librosImportados;
        tipoMapa=new TypeToken<HashMap<Integer,Libro>>() {}.getType();
        librosImportados=gson.fromJson(json,tipoMapa);
        if (librosImportados==null||librosImportados.isEmpty()){
            return 2;
        }
        libros=librosImportados;
        return 3;   
    }

    public int exportarXml() throws IOException{
        if(libros==null||libros.isEmpty()){
            return 1;
        }
        HashMap<String, Libro> aux=new HashMap<>();
        for(Map.Entry<Integer, Libro> libro:libros.entrySet()){
            aux.put(String.format("isbn_%d",libro.getKey()),libro.getValue());
        }
        XmlMapper xmlMapper=new XmlMapper();
        Path ruta=Rutas.pathToFileOnDesktop("libros.xml");
        String xml=xmlMapper.writeValueAsString(aux);
        Files.write(ruta,xml.getBytes(StandardCharsets.UTF_8));
        return 2;
    }

    public int importarXml() throws IOException{
        Path ruta=Rutas.pathToFileOnDesktop("libros.xml");
        if(!Files.exists(ruta)){
                return 1;
        }
        XmlMapper mapper=new XmlMapper();
        String xml=new String(Files.readAllBytes(ruta),StandardCharsets.UTF_8);
        HashMap<String, Libro> aux=mapper.readValue(xml,mapper.getTypeFactory().constructMapType(HashMap.class,String.class,Libro.class));
        if (aux==null||aux.isEmpty()){
            return 2;
        }
        HashMap<Integer, Libro> librosImportados=new HashMap<>();
        for (Map.Entry<String, Libro> entrada : aux.entrySet()) {
            int isbn = Integer.parseInt(entrada.getKey().substring(5));
            librosImportados.put(isbn, entrada.getValue());
        }
        libros=librosImportados;
        return 3;
    }
       
    public int serializar() throws IOException{
        Path ruta=Rutas.pathToFileOnDesktop("libros.bin");
        File f = ruta.toFile();
        ObjectOutputStream oos=null;
        oos=new ObjectOutputStream(new FileOutputStream(f));
        oos.writeObject(libros);
        oos.close();
        return 1;
    }

    public int deserializar() throws IOException,ClassNotFoundException{
        Path ruta=Rutas.pathToFileOnDesktop("libros.bin");
        if(!Files.exists(ruta)){
                return 2;
        }
        File f = ruta.toFile();
        ObjectInputStream ois=null;
        ois=new ObjectInputStream(new FileInputStream(f));
        libros=(HashMap<Integer, Libro>) ois.readObject();  
        ois.close();
        return 1;
    }

    public HashMap<Integer, Libro> getLibros(){
        return libros;
    }

}