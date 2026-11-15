package Modelo;

import java.util.ArrayList;
import java.util.Iterator;

public class Modelo {
    
    private ArrayList<Persona> personas = new ArrayList<>();

    public void agregar(String nombre, int edad, double altura){
        personas.add(new Persona(nombre, edad, altura));
    }

    public boolean eliminar(String nombre){
        Iterator<Persona> iterator = this.personas.iterator();
        while (iterator.hasNext()) {
            Persona persona = iterator.next();
            if (persona.getNombre().equals(nombre)) {
                iterator.remove();
                return true;  
            }
        }
        return false;
    }
    
    public boolean comprobar(String nombre){
        Iterator<Persona> iterator = this.personas.iterator();
        while (iterator.hasNext()) {
            Persona persona = iterator.next();
            if (persona.getNombre().equals(nombre)) {
                return true;  
            }
        }
        return false;
    }

    public void modificar(String nombre, String nNombre, int nEdad, double nAltura){
        Iterator<Persona> iterator = this.personas.iterator();
        while (iterator.hasNext()) {
            Persona persona = iterator.next();
            if (persona.getNombre().equals(nombre)) {
                persona.setNombre(nNombre);
                persona.setEdad(nEdad);
                persona.setAltura(nAltura); 
                break;
            }
        }
    }

    public ArrayList<String> getPersonas(){
        ArrayList<String> personasString = new ArrayList<>();
        for(Persona persona:personas){
            personasString.add(persona.getEstadoComoString());
        }
        return personasString;
    }

}
