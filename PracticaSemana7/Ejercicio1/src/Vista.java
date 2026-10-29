import java.util.Scanner;

public class Vista {
    private Controlador vistaControlador;
    private Scanner sc = new Scanner(System.in);

        
    public char menu(){
        System.out.printf("\n///////////////////////////\n1.- Leer los números\r\n" + //
                    "2.- Calcular la suma\r\n" + //
                    "3.- Mostrar el resultado\r\n" + //
                    "q.- Salir\r\n///////////////////////////");
        return sc.next().charAt(0);
    }
    

    public void setVistaModelo(Controlador c){
        this.vistaControlador=c;
    }

    public float[] leerNumeros(){
        float i[]=new float[2];
        System.out.printf("Introduzca el valor del primer numero: ");
        i[0]=sc.nextFloat();
        System.out.printf("Introduzca el valor del segundo numero: 1");
        i[1]=sc.nextFloat();
        return i;

    }

    public void cerrar(){
        vistaControlador.cerrar();
    }

    public void imprimirSuma(float f){
        System.out.printf("La suma es %.2f", f);
    }
}
