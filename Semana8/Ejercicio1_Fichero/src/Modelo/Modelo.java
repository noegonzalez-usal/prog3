package Modelo;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

//import java.util.Iterator;

public class Modelo {

    private ArrayList<Partido> partidos= new ArrayList<>();
    private Path ruta = Paths.get("data","equipos.txt");

    public void iniciarPartidosFichero(){
        String delimitador="-";
        try {
            List<String> lineas = Files.readAllLines(this.ruta);
            for(String linea:lineas){
                String[] equipos = linea.split(delimitador); 
                partidos.add(new Partido(equipos[0],equipos[1]));
            }
        } catch (IOException ex) {
        System.out.println("Error:" + ex.getMessage());
        }
    }
   
    public void addPartido(String e1, String e2){
        this.partidos.add(new Partido(e1, e2));
    }
    
    public void setGoles(int i, int g1, int g2){
        this.partidos.get(i).setGoles(g1, g2);
    }

    public void reset(){
        this.partidos=new ArrayList<>();
    }

    public int[] getEquiposLongitud(){
        int i=0, j=0;
        for(Partido partido : this.partidos){
            if(i<partido.getEquiposLongitud()[0]){
                i=partido.getEquiposLongitud()[0];
            }
            if(j<partido.getEquiposLongitud()[1]){
                j=partido.getEquiposLongitud()[1];
            }
        }
        return new int[]{i,j};
    }

    public ArrayList<String[]> getEquipos(){
        ArrayList<String[]> equipos= new ArrayList<>();
        for(Partido partido : this.partidos){
            equipos.add(partido.getEquipos());
        }
        return equipos;
    }

    public ArrayList<String[]> getPartidos(){
        ArrayList<String[]> equipos= new ArrayList<>();
        for(Partido partido : this.partidos){
            equipos.add(partido.getPartido());
        }
        return equipos;
    }
}
