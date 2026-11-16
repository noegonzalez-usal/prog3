package Modelo;
public class Partido {
    private String equipo1, equipo2;
    private String resultado;
    private int goles1, goles2;

    public Partido(String e1, String e2){
        this.equipo1=e1;
        this.equipo2=e2;
        this.resultado="";
    }

    public void setGoles(int i, int j){
        this.goles1=i;
        this.goles2=j;
        if(this.goles1>this.goles2) this.resultado ="1";
        if(this.goles1<this.goles2) this.resultado ="2";
        if(this.goles1==this.goles2) this.resultado ="X";
    }

    public String[] getEquipos(){
        return new String[]{this.equipo1, this.equipo2};
    } 

    public int[] getEquiposLongitud(){
        return new int[]{this.equipo1.length(),this.equipo2.length()};
    } 

    public String[] getPartido(){
        return new String[]{this.equipo1,this.equipo2,this.resultado};
    }
}
