import java.util.Scanner;

public class Controlador {
    private Scanner sc = new Scanner(System.in);
    private Modelo controladorModelo;
    private Vista controladorVista; 
    private boolean ejecucion=true;
    private char opcion;

    public Controlador(Modelo m, Vista v){
            this.controladorModelo=m;
            this.controladorVista=v;
    }

    public void iniciar(){
        do{
            this.opcion=controladorVista.menu();
            switch(this.opcion){
            case '1':{
                controladorModelo.setNumeros(controladorVista.leerNumeros());
                break;
            }
            case '2':{
                controladorModelo.calcularSuma();
                break;
            }
            case '3':{
                controladorVista.imprimirSuma(controladorModelo.getSuma());
                break;
            }
            case 'q':{
                cerrar();
                break;
            }
            default:{
                System.out.printf("Valor introducido no válido\n");
            }
        };
        }while(this.ejecucion!=false);
        
    }

    public char setOpcion(){
        return sc.next().charAt(0);
    }

    public void calcularSuma(){

    }

    public void mostrarResultado(){

    }

    public void cerrar(){
        ejecucion=false;
    }
}
