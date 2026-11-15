package Modelo;

import java.util.ArrayList;
import java.util.HashSet;

public class Modelo {
    
    private HashSet<Persona> personas = new HashSet<>();

    public boolean agregar(String nombre, int edad, double altura){
        Persona nuevaPersona = new Persona(nombre, edad, altura);
        return personas.add(nuevaPersona);
    }

    public boolean eliminar(String nombre){
        Persona personaAEliminar = new Persona(nombre, 0, 0);
        return personas.remove(personaAEliminar);
    }
    
    public boolean comprobar(String nombre){
        Persona personaAModificar = new Persona(nombre, 0, 0);
        return personas.remove(personaAModificar);
    }

    public void modificar(String nombre, String nNombre, int nEdad, double nAltura){
        Persona personaAModificar = new Persona(nombre, 0, 0);
        personas.remove(personaAModificar);
        personas.add(new Persona(nNombre, nEdad, nAltura));
        }

    public ArrayList<String> getPersonas(){
        ArrayList<String> personasString = new ArrayList<>();
        for(Persona persona:personas){
            personasString.add(String.format("HashCode:%10d - %s",persona.hashCode(), persona.getEstadoComoString()));
        }
        return personasString;
    }

}
