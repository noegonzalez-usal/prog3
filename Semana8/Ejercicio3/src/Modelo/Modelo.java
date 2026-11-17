package Modelo;

import es.usal.progiii.tools.Rutas;
import java.util.ArrayList;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;

public class Modelo{

    private ArrayList<Persona> personas=new ArrayList<>();
    
    public void importarDatosTxt() throws IOException{
        Path ruta=Rutas.pathToFileOnDesktop("datos.txt");
        List<String> lineas = Files.readAllLines(ruta);
        String delimitador="\t";
        for(String linea:lineas){
            String[] info=linea.split(delimitador);
            personas.add(new Persona(info[0],info[1],Double.parseDouble(info[2])));
        }
    }

    public void importarDatosTsv(Path ruta) throws IOException{
        personas=new ArrayList<>();
        List<String> lineas = Files.readAllLines(ruta);
        String delimitador="\t";
        for(String linea:lineas){
            String[] info=linea.split(delimitador);
            personas.add(new Persona(info[0],info[1],Double.parseDouble(info[2])));
        }
    }

    public int getLongitud(){
        int longitud=0;
        for(Persona persona:personas){
                longitud=Math.max(longitud,persona.getLongitud());
            }
        return longitud;
        }

    public ArrayList<Persona> getPersonas(){
        return personas;
    }

}