package Vista;

import es.usal.progiii.tools.Esdia;
import java.util.ArrayList;

public class Vista {

    public char menu(){
        System.out.printf("\n1.- Leer tabla de ventas\n");
        System.out.printf("2.- Leer tabla de precios\n");
        System.out.printf("3.- Calcular ingresos totales\n");
        System.out.printf("4.- Mostrar resultados\n");
        System.out.printf("q.- Salir\n");

        return Esdia.readString("Introduzca la opcion deseada: ").charAt(0);
    }

    public ArrayList<Integer[]> leerVentas(){
        ArrayList<Integer[]> ventas=new ArrayList<>();
        for(int i=0;i<5;i++){
            int j,k;
            do{
            j=Esdia.readInt(String.format("Introduce el numero de ventas del primer producto en el almacen numero %d: ", i+1));
            if(j<0) System.out.printf("Valor no válido.\n");
            }while(j<0);
            do{
            k=Esdia.readInt(String.format("Introduce el numero de ventas del segundo producto en el almacen numero %d: ", i+1));
            if(k<0) System.out.printf("Valor no válido.\n");
            }while(k<0);
            ventas.add(new Integer[]{j,k});
        }
        return ventas;
    }

    public double[] leerPrecios(){
        double[] precios=new double[2];
        do{
        precios[0]=Esdia.readDouble("Introduzca el precio del primer prodcuto: ");
        if(precios[0]<=0) System.out.printf("Precio introducido no válido\n");
        }while(precios[0]<=0);
         do{
        precios[1]=Esdia.readDouble("Introduzca el precio del segundo prodcuto: ");
        if(precios[1]<=0) System.out.printf("Precio introducido no válido\n");
        }while(precios[1]<=0);;
        return precios;
    }

    public void resultado(double[] individuales, double total ){
        for(int i=0; i<5; i++){
            System.out.printf("\nDinero recaudado por el almacen numero %d: %.2f", i, individuales[i]);
        }
        System.out.printf("\n\nDinero total recaudado: %.2f\n", total);
    }

    public void error1(){
        System.out.printf("Faltan datos para realizar la operacion\n");
    }

    public void error2(){
        System.out.printf("Ingresos no calculados aún\n");
    }
}
