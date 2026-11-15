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
        cM.agregar(cV.leerDNI(),cV.leerNombre(), cV.leerEdad(), cV.leerAltura());
    }

    public void eliminarPersona(){
        String dni=cV.eliminarDNI();
        boolean eliminado=cM.eliminar(dni);
        cV.eliminado(eliminado);
    }

    public void modificarPersona(){
        String dni=cV.modificarDNI();
        boolean existe=cM.comprobar(dni);
        cV.existe(existe, dni); 
    }

    public void existe(String dni){
        cM.agregar(dni, cV.leerNombre(), cV.leerEdad(), cV.leerAltura());
    }

    public void listarPersonas(){
        cV.lista(cM.getPersonas());
    }

}
