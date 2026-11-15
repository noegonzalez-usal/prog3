package Controlador;

import Modelo.Modelo;
import Vista.Vista;
import java.util.ArrayList;
import java.util.Iterator;

public class Controlador {
    
    private Modelo cM;
    private Vista cV;

    public Controlador(Modelo m, Vista v){
        this.cM = m;
        this.cV = v;
    }

    public void iniciar(){
        char opcion;
        do{
            opcion=cV.menu();
            switch(opcion){
                case '1':{
                    leerVentas();
                    break;
                }
                case '2':{
                    leerPrecios();
                    break;
                }
                case '3':{
                    ingresos();
                    break;
                }
                case '4':{
                    resultados();
                    break;
                }
                case 'q':{
                    break;
                }
                default:{
                    System.out.printf("Opcion no valida, intentelo de nuevo.\n\n");
                }
            }
        }while(opcion!='q');
    }

    public void leerVentas(){
        ArrayList<Integer[]> i=cV.leerVentas();
        cM.setVentas(i);
        cM.reset();
    }

    public void leerPrecios(){
        double[] i=cV.leerPrecios();
        cM.setPrecios(i);
        cM.reset();
    }

    public void ingresos(){
        if (cM.getVentas().isEmpty()||(cM.getPrecios()[0] == 0 && cM.getPrecios()[1] == 0)){
            cV.error1();
        }else{
            double[] precios=cM.getPrecios();
            Iterator<Integer[]> iterator=cM.getVentas().iterator();
            double ingreso=0;
            int j=0;
            while(iterator.hasNext()){
                Integer[] i=iterator.next();
                cM.setIndividual(j,precios[0]*i[0]+precios[1]*i[1]);
                j++;
                ingreso+=precios[0]*i[0]+precios[1]*i[1];
            }
            cM.setResultado(ingreso);
        }

    }

    public void resultados(){
         if (cM.getVentas().isEmpty()||(cM.getPrecios()[0] == 0 && cM.getPrecios()[1] == 0)){
            cV.error1();
        }else{
            if (cM.getResultado() == null) {
                cV.error2();
                }else cV.resultado(cM.getIndividuales(),cM.getResultado());
        }
    }
}
