package Controlador;

import Vista.Vista;
import Modelo.Modelo;

import java.io.IOException;

public class Controlador{

    private Vista cV;
    private Modelo cM;

    public Controlador(Vista v, Modelo m){
        this.cV=v;
        this.cM=m;
    }

    public void iniciar(){
        cM.crearListaAlumnos();
        char opcion;
        do{
            opcion=cV.menu();
            switch(opcion){
                case '1':{
                    generarAlumnos();
                    break;
                }
                case '2':{
                    imprimirAlumnos();
                    break;
                }
                case'3':{
                    exportarPersonales();
                    break;
                }
                case '4':{
                    exportarDirecciones();
                    break;
                }
                case 'q':{
                    break;
                }
            }
        }while(opcion!='q');
    }

    public void generarAlumnos(){
        cM.crearListaAlumnos();
        cV.imprimir("Nueva lista creada con éxito!");
    }

    public void imprimirAlumnos(){
        cV.imprimirAlumnos(cM.getAlumnos(),cM.getLongitudes());
    }

    public void exportarPersonales(){
        try{
            cM.exportarDatos();
            cV.imprimir("Archivo exportado con éxito");
        }catch(IOException e){
            cV.imprimir(e);
        }
    }

    public void exportarDirecciones(){
        try{
            cM.exportarDirecciones();
            cV.imprimir("Archivo exportado con éxito");
        }catch(IOException e){
            cV.imprimir(e);
        }
    }
}