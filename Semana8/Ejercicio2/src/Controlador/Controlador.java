package Controlador;

import Vista.Vista;
import Modelo.Modelo;
import Modelo.Factura;

import java.util.ArrayList;
import java.io.IOException;


public class Controlador{

    private Vista cV;
    private Modelo cM;

    public Controlador(Vista v, Modelo m){
        this.cV=v;
        this.cM=m;
    }

    public void iniciar(){
        cM.importarFacturas();
        int opcion;
        do{
            opcion=cV.menu();
            switch(opcion){
                case 1:{
                    facturaMin();
                    break;
                }
                case 2:{
                    imprimirFacturas();
                    break;
                }
                case 3:{
                    exportarHTML();
                    break;
                }
                case 4:{
                    exportarCSV();
                    break;
                }
                case 5:{
                    finalizar();
                    break;
                }
            }
        }while(opcion!=5);
    }

    private void facturaMin(){
        double min=cV.leerMinimo();
        ArrayList<Factura> facturas=cM.getFacturasMin(min);
        cV.imprimirFacturasMin(facturas, min);
    }

    private void imprimirFacturas(){
        ArrayList<Factura> facturas=cM.getFacturas();
        cV.imprimirFacturas(facturas, cM.getLongitudes());
    } 

    private void exportarHTML(){
        try{
            cM.exportarHtml();
            cV.imprimir("Documento exportado");
        }catch(IOException e){
            cV.imprimirError(e);
        }
    }

    private void exportarCSV(){
        try{
            cM.exportarCsv();
            cV.imprimir("Documento exportado");
        }catch(IOException e){
            cV.imprimirError(e);
        }
    }

    private void finalizar(){
        cV.imprimir("Hasta nunca");
    }
}