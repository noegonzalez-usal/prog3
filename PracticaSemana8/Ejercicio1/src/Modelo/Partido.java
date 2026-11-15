package Modelo;
public class Partido {
    private String equipo1, equipo2;
    private int predi;
    private int goles1, goles2;

    public Partido(String a, String b){
        this.equipo1=a;
        this.equipo2=b;
    }

    public void setGoles(int i, int j){
        this.goles1=i;
        this.goles2=j;
    }

    public void setPredi(int i){
        this.predi=i;
    }



    public String[] getPartidos(){
        String[] equipos= new String[2];
        equipos[0]=this.equipo1;
        equipos[1]=this.equipo2;
        return equipos;
    } 
}
