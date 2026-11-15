import Modelo.Partido;
import java.util.ArrayList;

public class Vista {

    private Controlador vC;

    public void setControlador(Controlador c){
        this.vC=c;
    }

    public void imprimirPartidos(ArrayList<String> equipos, int MAX1, int MAX2){
        System.out.printf("/".repeat(5+MAX1+MAX2));
        for(int i=0;i<15;i++){
            System.out.printf("/ "+ String.format("%-" + MAX1+"s", equipos.get(2*i+1))+"/ " + String.format("%-" + MAX2+"s", equipos.get(2*i+2))+"/");
        }
        System.out.printf("/".repeat(5+MAX1+MAX2));
    }
}
