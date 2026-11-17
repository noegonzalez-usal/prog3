package Vista;

import Modelo.Factura;
import java.io.IOException;

import es.usal.progiii.tools.Esdia;
import java.util.ArrayList;

public class Vista{

    public int menu(){
        System.out.println("1. Facturas por encima de un valor");
        System.out.println("2. Imprimir facturas");
        System.out.println("3. Exportar facturas en formato html");
        System.out.println("4. Exportar facturas en formato csv");
        return Esdia.readInt("Ingrese una opción: ");
    }

    public double leerMinimo(){
        return Esdia.readDouble("Introduce el minimo: ");
    }

    public void imprimirFacturasMin(ArrayList<Factura> facturas, double min){
        System.out.printf("\nEstos son los clientes con un importe mayor a %.2f EUR\n", min);
        for(Factura factura:facturas){
            System.out.println(factura.getNombre());
        }
        System.out.printf("\n\n");
    }

    public void imprimirFacturas(ArrayList<Factura> facturas, int[] longitudes){
        int lMax=55+longitudes[0]+longitudes[1]+longitudes[2]+longitudes[3];
        System.out.println("\n|"+"-".repeat(lMax)+"|");
        System.out.println("| "+
                            String.format("%-"+longitudes[0]+"s","Concepto")+
                            " | Descuento | Fecha      | "+
                            String.format("%-"+longitudes[1]+"s","Importe")+
                            " | NIF       | "+
                            String.format("%-"+longitudes[2]+"s","Nombre")+" | "+
                            String.format("%-"+longitudes[3]+"s","Dirección")+" | "+
                            "IVA  |");
        System.out.println("|"+"-".repeat(lMax)+"|");
        for(Factura factura:facturas){
            System.out.println("| "+
                                String.format("%-"+longitudes[0]+"s",factura.getConcepto())+
                                " | "+String.format("%-9.2f",factura.getDescuento())+
                                " | "+String.format("%s",factura.getFecha())+
                                " | "+String.format("%-"+longitudes[1]+".2f",factura.getImporte())+
                                " | "+String.format("%s",factura.getNif())+
                                " | "+String.format("%-"+longitudes[2]+"s",factura.getNombre())+
                                " | "+String.format("%-"+longitudes[3]+"s",factura.getDireccion())+
                                " | "+String.format("%.2f",factura.getIva())+
                                " |"

            );
        }
        System.out.println("|"+"-".repeat(lMax)+"|\n\n");
        
    }
    
    public void imprimirError(IOException e){
        System.err.println("Error: "+e);
    }  

    public void imprimir(String s){
        System.out.println(s);
    }
}
