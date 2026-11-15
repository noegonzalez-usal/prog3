import java.util.ArrayList;
import es.usal.progiii.tools.Esdia;

public class Vista {

    private Controlador vC;
    private int MAX=2;

    public void setControlador(Controlador c){
        this.vC=c;
    }

    public int menu(){
        System.out.printf("1. Introducir partidos\n");
        System.out.printf("2. Introducir resultados\n");
        System.out.printf("3. Mostrar quiniela\n");
        System.out.printf("4. Salir\n");
        return Esdia.readInt("Seleccione una opcion: ",1,4);
    }

    public void leerPartidos(){
        for(int i=1; i<=this.MAX;i++){
            String e1,e2;
            do{
                e1= Esdia.readString(String.format("\nIngresa el nombre del primer equipo para el partido %d: ",i));
                if(e1.equals("")) System.out.printf("Campo vacío\n");
            }while(e1.equals(""));
            do{
                e2=Esdia.readString(String.format("Ingresa el nombre del segundo equipo para el partido %d: ",i));
                if(e2.equals("")) System.out.printf("Campo vacío\n");
            }while(e2.equals(""));
            vC.añadirPartido(e1, e2);
        }
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
