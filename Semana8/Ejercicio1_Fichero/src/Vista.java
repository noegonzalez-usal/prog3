import java.util.ArrayList;
import es.usal.progiii.tools.Esdia;

public class Vista {

    private Controlador vC;

    public void setControlador(Controlador c){
        this.vC=c;
    }

    public int menu(){
        System.out.printf("1. Introducir resultados\n");
        System.out.printf("2. Mostrar quiniela\n");
        System.out.printf("3. Salir\n");
        return Esdia.readInt("Seleccione una opcion: ",1,3);
    }

    public void leerGoles(ArrayList<String[]> equipos){
        int i=0;
        for(String[]equipo:equipos){
            System.out.printf("\nPartido numero %d: "+equipo[0]+" vs "+equipo[1]+"\n", i+1);
            int g1= Esdia.readInt(String.format("Goles de "+ equipo[0]+": "),0,99);
            int g2= Esdia.readInt(String.format("Goles de "+ equipo[1]+": "),0,99);
            vC.añadirGoles(i, g1, g2);
            i++;
        } 
    }

    public void imprimirPartidos(ArrayList<String[]> equipos, int[] MAX){
        System.out.printf("|"+"-".repeat(9+MAX[0]+MAX[1])+"|\n");
        System.out.printf("|"+" ".repeat((1+MAX[0]+MAX[1])/2)+"QUINIELA"+" ".repeat(1+MAX[0]+MAX[1]-(1+MAX[0]+MAX[1])/2)+"|\n");
        System.out.printf("|"+"-".repeat(9+MAX[0]+MAX[1])+"|\n");
        for(String[]equipo:equipos){
            System.out.printf("| "+ String.format("%-" + MAX[0] +"s", equipo[0])+" | " + String.format("%-" + MAX[1] + "s", equipo[1])+" | "+equipo[2]+" |\n");
        }
        System.out.printf("|"+"-".repeat(9+MAX[0]+MAX[1])+"|\n");
    }

    public void noEquipos(){
        System.out.printf("Introduce primero los partidos.\n"); 
    }

    public void noGoles(){
        System.out.printf("Introduce los goles antes de pedir la quiniela\n");
    }
}
