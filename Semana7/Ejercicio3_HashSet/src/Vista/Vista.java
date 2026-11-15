package Vista;

import static es.usal.progiii.tools.Esdia.*;

import Controlador.Controlador;
import java.util.ArrayList;

public class Vista{

    private Controlador vC;

    public void setControlador(Controlador c){
        this.vC=c;
    }

    public int menu(){
        System.out.println("\n--- MENU CRUD ---");
        System.out.println("1. Agregar persona");
        System.out.println("2. Eliminar persona");
        System.out.println("3. Modificar persona");
        System.out.println("4. Listar personas");
        System.out.println("5. Salir");
        return readInt("Ingrese una opción: ");
    }

    public String leerNombre(){
        return readString("Ingrese el nombre de la persona: ");
    }

    public int leerEdad(){
        return readInt("Ingrese la edad de la persona: ", 1, 150);
    }

    public double leerAltura(){
        return readDouble("Ingrese la altura de la persona (ej. 1.75): ", 0, 3);
    }

    public void agregada(boolean agregada){
        if(agregada){
            System.out.printf("Persona agregada con éxito");
        }else{
            System.out.println("Persona con ese nombre ya existe.");
        }
    }

    public String eliminarNombre(){
        return readString_ne("Ingrese el nombre de la persona a eliminar: ");
    }

    public void eliminado(boolean eliminado){
        if (eliminado) {
            System.out.println("Persona eliminada.");
        } else {
            System.out.println("Persona no encontrada.");
        }
    }

    public String modificarNombre(){
        return readString_ne("Ingrese el nombre de la persona a modificar: ");
    }

    public void existe(boolean modificado, String nombre){
        if (modificado) {
            vC.existe(nombre);
            System.out.printf("Persona modificada con éxito");
        } else {
            System.out.println("Persona no encontrada.");
        }
    }

    public void lista(ArrayList<String> personas){
        if (personas.isEmpty()) {
            System.out.println("No hay personas en la lista.");
            return;
        }else{
            for(String string:personas){
                System.out.printf(string + "\n");
            }
        }
    }

    public void finalizar(){
        System.out.println("¡Hasta luego!");
    }

    public void errorMenu(){
        System.out.println("Opción no válida.");
    }


}