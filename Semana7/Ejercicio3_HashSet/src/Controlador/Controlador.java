package Controlador;

import Modelo.Modelo;
import Vista.Vista;

public class Controlador {
    
    private Modelo cM;
    private Vista cV;

    public Controlador(Vista v, Modelo m){
        this.cM=m;
        this.cV=v;
    }

    public void inicio(){
        int opcion=0;
        do{
            opcion=cV.menu();
            switch (opcion) {
                case 1:
                    agregarPersona();
                    break;
                case 2:
                    eliminarPersona();
                    //eliminarPersonaConIterator();
                    break;
                case 3:
                    modificarPersona();
                    break;
                case 4:
                    listarPersonas();
                    break;
                case 5:
                    cV.finalizar();
                    break;
                default:
                    cV.errorMenu();
            }
        } while (opcion != 5);        
    }

    public void agregarPersona(){
        boolean agregada=cM.agregar(cV.leerNombre(), cV.leerEdad(), cV.leerAltura());
        cV.agregada(agregada);
    }

    public void eliminarPersona(){
        String nombre=cV.eliminarNombre();
        boolean eliminado=cM.eliminar(nombre);
        cV.eliminado(eliminado);
    }

    public void modificarPersona(){
        String nombre=cV.modificarNombre();
        boolean existe=cM.comprobar(nombre);
        cV.existe(existe, nombre); 
    }

    public void existe(String nombre){
        cM.modificar(nombre, cV.leerNombre(), cV.leerEdad(), cV.leerAltura());
    }

    public void listarPersonas(){
        cV.lista(cM.getPersonas());
    }

}
