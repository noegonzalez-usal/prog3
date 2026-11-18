package Vista;

import Modelo.DatosDeAlumno;

import java.util.ArrayList;
import es.usal.progiii.tools.Esdia;
import java.io.IOException;

public class Vista{

    public char menu(){
        System.out.println("\n1. Volver a crear la lista de alumnos");
        System.out.println("2. Mostrar tabla de alumnos");
        System.out.println("3. Exportar datos personales (CSV)");
        System.out.println("4. Exportar direcciones (CSV)");
        System.out.println("q. Salir");
        return Esdia.readString("Ingrese una opción: ").charAt(0);
    }

    public void imprimir(String s){
        System.out.println(s);
    }

    public void imprimir (IOException e){
        System.err.printf("Error al exportar: "+e);
    }

    public void imprimirAlumnos(ArrayList<DatosDeAlumno> alumnos, int[] longitudes){
        System.out.println("");
        for(DatosDeAlumno alumno:alumnos){
            System.out.println(
                "| "+String.format("%-"+longitudes[0]+"s",alumno.getDatosPersonales().getNombre())+
                " | "+String.format("%-"+longitudes[1]+"s",alumno.getDatosPersonales().getApellidos())+
                " | "+String.format("%-3d",alumno.getDatosPersonales().getEdad())+
                " | "+String.format("%-9s",alumno.getDatosPersonales().getNif())+
                " | "+String.format("%-"+longitudes[2]+"s",alumno.getDireccion().getDireccionComoString())+" |"

            );
        }
    }

}