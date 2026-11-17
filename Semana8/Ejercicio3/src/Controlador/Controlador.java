package Controlador;

import Vista.Vista;
import Modelo.Modelo;
import java.nio.file.Path;
import es.usal.progiii.tools.Rutas;
import java.io.IOException;

public class Controlador{

    private Vista cV;
    private Modelo cM;

    public Controlador(Vista v, Modelo m){
        this.cV=v;
        this.cM=m;
    }

    public void iniciar(){
        importarTxt();
        int opcion;
        do{
            opcion=cV.menu();
            switch(opcion){
                case 1:{
                    importarTsv();
                    break;
                }
                case 2:{
                    imprimirDatos();
                    break;
                }
                case 3:{
                    opcion=finalizar();
                    break;
                }
            }
            
        }while(opcion!=3);
    }

    public void importarTxt(){
        try{
            cM.importarDatosTxt();
        }catch(IOException e){
            cV.noDatos(e);
            return;
        }
        cV.imprimir("Datos importados correctamente desde el escritorio.");
    }

    public void importarTsv(){
        String nombreFichero=cV.pedirFichero();
        Path ruta=Rutas.pathToFileOnDesktop(nombreFichero+".tsv");
        try{
            cM.importarDatosTsv(ruta);  
        }catch(IOException e){
            cV.noDatos(e);
            return;
        }
        cV.imprimir("Datos importados correctamente desde el escritorio.");
    }

    public void imprimirDatos(){
        if(cM.getPersonas()==null){
            cV.imprimir("Base de datos vacía");
        }
        cV.imprimirDatos(cM.getPersonas(),cM.getLongitud());

    }

    public int finalizar(){
        String respuesta=cV.finalizar();
        if(respuesta.equalsIgnoreCase("si")) return 3;
        else return 0;
        
    }
}