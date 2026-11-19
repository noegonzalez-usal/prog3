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
        deserializar();
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
        int j;
        try{
            j=cM.exportarCsv();
        }catch(IOException e){
            cV.imprimirError(e);
            return;
        }
        if(j==1) cV.imprimirError("No hay libros");
        if(j==2) cV.imprimir("Datos exportados correctamente al escritorio");
    }

    public void exportarJson() {
        int j;
        try{
            j=cM.exportarJson();
        }catch(IOException e){
            cV.imprimirError(e);
            return;
        }
        if(j==1) cV.imprimirError("No hay libros");
        if(j==2) cV.imprimir("Datos exportados correctamente al escritorio");
    }

    public void exportarXml() {
        int j;
        try{
            j=cM.exportarXml();
        }catch(IOException e){
            cV.imprimirError(e);
            return;
        }
        if(j==1) cV.imprimirError("No hay libros");
        if(j==2) cV.imprimir("Datos exportados correctamente al escritorio"); 
    }

    public void importarJson() {
        int j;
        try{
            j=cM.importarJson();
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
                cV.imprimirError("El archivo JSON esta vacío");
                break;
            }
            case 3:{
                cV.imprimir("Datos importados correctamente");
                break;
            }
        }
    }

    public void importarXml() {
        int j;
        try{
            j=cM.importarXml();
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
                cV.imprimirError("El archivo XML esta vacío");
                break;
            }
            case 3:{
                cV.imprimir("Datos importados correctamente");
                break;
            }
        }
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
                cV.imprimirError("El archivo CSV esta vacío");
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
        int j=0;
        try{
            j=cM.serializar();
        }catch(IOException e){
            cV.imprimirError(e);
        }
        switch(j){
            case 1:{
                cV.imprimir("Datos guardados en el escritorio. Hasta luego!");
                break;
            }
            case 0:{
                cV.imprimirError("Error al exportar los datos");
                break;
            }
        }
    }

    public void deserializar(){
        int j=0;
        try{
            j=cM.deserializar();
        }catch(IOException | ClassNotFoundException e){
            cV.imprimirError(e);
        }
        switch(j){
            case 0: {
                cV.imprimir("Error al importar la base de datos");
                break;
            }
            case 1: {
                cV.imprimir("Base de datos importada con exito");
                break;
            }
            case 2:{
                cV.imprimirError("No existe libros.bin para importar");
                break;
            }
        }
    }

}