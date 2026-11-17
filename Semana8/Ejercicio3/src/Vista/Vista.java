package Vista;

import Modelo.Persona;

import java.util.ArrayList;
import es.usal.progiii.tools.Esdia;
import java.io.IOException;


public class Vista{

    public int menu(){
        System.out.println("\n\n1. Cargar nueva base de datos desde el escritorio (tsv)");
        System.out.println("2. Mostrar datos");
        System.out.println("3. Salir");
        return Esdia.readInt("Ingrese una opción",1,3);
    }

    public void imprimir(String s){
        System.out.println(s);
    }

    public String pedirFichero(){
        return Esdia.readString("Introduce el nombre del fichero tsv del escritorio (no incluyas .tsv): ");
    }

    public void imprimirDatos(ArrayList<Persona> personas, int longitud){
        System.out.println("\n\n"+String.format("%-"+Math.max(6,longitud)+"s","Nombre")+
                            "   Telefono   Peso");
        System.out.println("-".repeat(20+longitud));
        for(Persona persona:personas){
            System.out.println(""+String.format("%-"+Math.max(6,longitud)+"s",persona.getNombre())+
                            String.format("   %s   %.2f",persona.getTfno(),persona.getPeso()));
        }           

    }

    public void noDatos(IOException e){
        System.out.println("La base de datos no se ha encontrado en el escritorio.");
    }

    public String finalizar(){
        return Esdia.readString("¿Esta seguro de que quiere abandonar la sesión? (Ingrese \"si\" para salir)\n");
    }

}