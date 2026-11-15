public class Controlador {
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
                calcularSuma();
                break;
            }
            case '3':{
                mostrarResultado();
                break;
            }
            case 'q':{
                cerrar();
                break;
            }
            default:{
                controladorVista.noOpcion();
            }
        };
        }while(this.ejecucion!=false);
        
    }

    public void calcularSuma(){
        if(controladorModelo.getNumeros()==null){
            controladorVista.noNumeros();
        }else{
            controladorModelo.calcularSuma();
        }
    }

    public void mostrarResultado(){
        if(controladorModelo.getSuma()==null){
            controladorVista.noSuma();
        }else{
        controladorVista.imprimirSuma(controladorModelo.getSuma());
        }
    }

    public void cerrar(){
        ejecucion=false;
    }
}
