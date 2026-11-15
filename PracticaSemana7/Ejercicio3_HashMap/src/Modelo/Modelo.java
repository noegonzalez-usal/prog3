package Modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Modelo {
    
    private HashMap<String, Persona> personas = new HashMap<>();

    public void agregar(String dni, String nombre, int edad, double altura){
        personas.put(nombre, new Persona(nombre, edad, altura));
    }

    public boolean eliminar(String dni){
        if (personas.containsKey(dni)) {
            personas.remove(dni);
            System.out.println("Persona eliminada.");
            return true;
        } else {
            System.out.println("Persona no encontrada.");
            return false;
        }
    }
    
    public boolean comprobar(String dni){
        if (personas.containsKey(dni)) {
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<String> getPersonas(){
        ArrayList<String> personasString= new ArrayList<>();
        for (Map.Entry<String, Persona> entry : personas.entrySet()) {
            String dni = entry.getKey();
            Persona value = entry.getValue();
            personasString.add(String.format("DNI:%9s - %s",dni,value.getEstadoComoString()));
        }
        return personasString;
    }

}
