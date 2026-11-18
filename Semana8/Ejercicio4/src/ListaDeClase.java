import Modelo.Modelo;
import Controlador.Controlador;
import Vista.Vista;


public class ListaDeClase {
    
    public static void main(String[] args) throws Exception {
        Vista vista=new Vista();
        Modelo modelo=new Modelo();
        Controlador controlador=new Controlador(vista, modelo);
        controlador.iniciar();
    }
}
