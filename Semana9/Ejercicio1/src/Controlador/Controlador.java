package Controlador;

import Vista.Vista;
import Modelo.Modelo;
//import Modelo.Libro;
//import java.util.HashMap;

import java.io.IOException;

public class Controlador{

    private Vista cV;
    private Modelo cM;

    public Controlador(Vista v, Modelo m){
        this.cV=v;
        this.cM=m;
    }

    public void iniciar(){
        int opcion;
        do{
            opcion=cV.menu();
            switch(opcion){
                case 1:{
                    mostrarLibros();
                    break;
                }
                case 2:{
                    añadirLibro();
                    break;
                }
                case 3:{
                    eliminarLibro();
                    break;
                }
                case 4:{
                    modificarLibro();
                    break;
                }
                case 5:{
                    exportarCsv();
                    break;
                }
                case 6:{
                    exportarJson();
                    break;
                }
                case 7:{
                    exportarXml();
                    break;
                }
                case 8:{
                    importarJson();
                    break;
                }
                case 9:{
                    importarXml();
                    break;
                }
                case 10:{
                    importarCsv();
                    break;
                }
                case 11:{
                    salir();
                    break;
                }                
            }
        }while(opcion!=11);
    }

    public void mostrarLibros() {
        if(cM.getLibros()==null||cM.getLibros().isEmpty()){
            cV.imprimir("La biblioteca está vacía");
            return;
        }
        cV.imprimirLista(cM.getLibros(),cM.getLongitudes());
    }

    public void añadirLibro() {
        String titulo=cV.leerTitulo();
        String autor=cV.leerAutor();
        int isbn=cV.leerISBN();
        boolean agregado=cM.añadirLibro(titulo, autor, isbn);
        if(agregado){
            cV.imprimir("Libro añadido con éxito a la biblioteca.");
        }else{
            cV.imprimirError("Ya existe un libro con este ISBN");
        }
    }

    public void eliminarLibro() {
        if(cM.getLibros()==null||cM.getLibros().isEmpty()){
            cV.imprimir("La biblioteca está vacía");
            return;
        }
        cV.imprimirLibros(cM.getLibros());
        int isbn=cV.leerISBN();
        boolean eliminado=cM.eliminarLibro(isbn);
        if(eliminado){
            cV.imprimir("Libro eliminado con éxito de la biblioteca.");
        }else{
            cV.imprimirError("No existe un libro con este ISBN");
        }
    }

    public void modificarLibro() {
        if(cM.getLibros()==null||cM.getLibros().isEmpty()){
            cV.imprimir("La biblioteca está vacía");
            return;
        }
        cV.imprimirLibros(cM.getLibros());
        int isbn=cV.leerISBN();
        boolean encontrado=cM.buscarLibro(isbn);
        if(encontrado){
            String titulo=cV.leerTitulo();
            String autor=cV.leerAutor();
            cM.modificarLibro(titulo, autor, isbn);
            cV.imprimir("Libro modificado con éxito de la biblioteca.");
        }else{
            cV.imprimirError("No existe un libro con este ISBN");
        }
    }

    public void exportarCsv() {

    }

    public void exportarJson() {

    }

    public void exportarXml() {

    }

    public void importarJson() {

    }

    public void importarXml() {

    }

    public void importarCsv() {
        int j;
        try{
            j=cM.importarCsv();
        }catch(IOException e){
            cV.imprimirError(e);
            return;
        }
        switch(j){
            case 1:{
                cV.imprimirError("El archivo \"libros.csv\"  no existe o no se encuentra en el escritorio");
                break;
            }
            case 2:{
                cV.imprimirError("El archivo esta vacío");
                break;
            }
            case 3:{
                cV.imprimirError("El archivo no contiene la cabecera adecuada");
                break;
            }
            case 4:{
                cV.imprimirError("El archivo no contiene el formato requerido");
                break;
            }
            case 5:{
                cV.imprimir("Datos importados correctamente");
                break;
            }
        }
    }

    public void salir() {

    }

}