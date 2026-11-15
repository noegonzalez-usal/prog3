package Modelo;
import java.util.ArrayList;
//import java.util.Iterator;

public class Modelo {

    private ArrayList<Partido> partidos= new ArrayList<>();
   
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
