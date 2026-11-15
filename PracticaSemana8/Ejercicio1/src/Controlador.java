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
        int opcion=0;
        do{
            opcion=cV.menu();
            switch(opcion){
                case 1:{
                    leerEquipos();
                    break;
                }
                case 2:{
                    leerGoles();
                    break;
                }
                case 3:{
                    imprimirQuiniela();
                    break;
                }
                case 4:{
                    break;
                }
            }
        }while(opcion!=4);
    }

    public void añadirPartido(String e1, String e2){
        cM.addPartido(e1, e2);
    }

    public void añadirGoles(int i, int g1, int g2){
        cM.setGoles(i,g1,g2);
    }

    public void leerEquipos(){
        cM.reset();
        cV.leerPartidos();
    }

    public void leerGoles(){
        ArrayList<String[]> equipos=cM.getEquipos();
        if(equipos.isEmpty()){
            cV.noEquipos();
        }else cV.leerGoles(equipos);
    }

    public void imprimirQuiniela(){
        ArrayList<String[]> partidos=cM.getPartidos();
        if(partidos.isEmpty()){
            cV.noEquipos();
        }else{
            if(partidos.get(0)[2].equals("")){
                cV.noGoles();;
            }else{
                cV.imprimirPartidos(partidos, cM.getEquiposLongitud());
            }
        }
    }
}
