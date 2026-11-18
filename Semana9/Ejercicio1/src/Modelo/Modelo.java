package Modelo;

import es.usal.progiii.tools.Rutas;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
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
        Path ruta=Paths.get("data","libros.csv");
        Files.createDirectories(ruta.getParent());
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

    public HashMap<Integer, Libro> getLibros(){
        return libros;
    }
}