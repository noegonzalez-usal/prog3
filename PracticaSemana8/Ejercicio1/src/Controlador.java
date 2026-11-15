import Modelo.Modelo;
import java.util.ArrayList;


public class Controlador {
    private Vista cV;
    private Modelo cM;

    public Controlador(Vista v, Modelo m){
        this.cV=v;
        this.cM=m;
    }

    public void iniciar(){
        cM.setEquipos();
    }

    public ArrayList<String> getPartidos(ArrayList<String> partidos){
        return partidos;
    }

    public void imprimirPartidos(){

        cV.imprimirPartidos(cM.getEquipos(), );
    }
}
