package app;

import modelo.Refugio;
import modelo.Animal;
import java.util.ArrayList;
import java.util.Iterator;

import es.usal.progiii.tools.Esdia;

public class App {

    public static int tamaño;
    public static Refugio ref=new Refugio();
    public static double precio=3;

    public static void menu(){
        System.out.printf("\n|---------------------------------------------------|\r\n" + //
        "| GESTIÓN DEL REFUGIO                               |\r\n" + //
        "|---------------------------------------------------|\r\n" + //
        "| 1) Configurar el precio del alimento por kg       |\r\n" + //
        "| 2) Añadir un nuevo animal al refugio              |\r\n" + //
        "| 3) Eliminar un animal del refugio                 |\r\n" + //
        "| 4) Modificar información de un animal             |\r\n" + //
        "| 5) Mostrar información de los animales            |\r\n" + //
        "| 6) Salir (se borrará toda la información)         |\r\n" + //
        "|---------------------------------------------------|\r\n\n");
    }


    public static void main(String[] args) throws Exception {
        int opcion=0;
        do{
            menu();
            opcion = Esdia.readInt("Seleccione una opción (1-5): ");
            switch(opcion){
                case 1:{
                    nuevoPrecio();
                    break;
                }
                case 2:{
                    ref.newAnimal();
                    break;
                }
                case 3:{
                    ref.removeAnimal(Esdia.readString("Introduce el nombre del animal a retirar: "));
                    break;
                }
                case 4:{
                    ref.modifyAnimal(Esdia.readString("Introduce el nombre del animal a modificar: "));
                    break;
                }
                case 5:{
                    info();
                    break;
                }
                case 6:{
                    break;
                }
                default:{
                    System.out.printf("Error: El valor introducido no es un número entero válido. Inténtelo de nuevo. \n\n");
                }
            }
        }while(opcion!=6);
    }

    public static void nuevoPrecio(){
        do{
            precio=Esdia.readDouble("Introduce el precio de la comida en EUR/kg: ");
            if(precio<=0) System.out.printf("Valor no válido");
        }while(precio<=0);
        ref.reset();
    }

    public static void info(){
        int[] tamLista= ref.getTamañosLista();
        ArrayList<Animal> animales=ref.getAnimales();
        if(animales.isEmpty()) {
            System.out.printf("Crea al menos un animal\n");
            return;
        }
        Iterator<Animal> iterator= animales.iterator();
        System.out.printf("|"+"-".repeat(tamLista[0])+"|\r\n" + 
                        "| "+String.format("%-"+(tamLista[0]-2)+"s", "ANIMALES DEL REFUGIO")+" |\r\n" + 
                        "|"+"-".repeat(tamLista[0])+"|\r\n" + 
                        "| "+ String.format("%-"+tamLista[1]+"s", "Nombre"  )+
                        " | "+String.format("%-"+tamLista[2]+"s", "Especie"  )+
                        " | "+String.format("%-"+tamLista[3]+"s", "Cuidador"  )+
                        " | Formación" +
                        " | "+String.format("%-"+tamLista[4]+"s", "Peso (kg)"  )+
                        " | Consumo (kg) | Coste (EUR) |\r\n" + 
                        "|"+"-".repeat(tamLista[0])+"|\r\n");
        while(iterator.hasNext()){
            Animal a=iterator.next();
            System.out.printf("| "+ String.format("%-"+tamLista[1]+"s", a.AnName())+
                        " | "+String.format("%-"+tamLista[2]+"s", a.AnEspecie()  )+
                        " | "+String.format("%-"+tamLista[3]+"s", a.AnCuiN())+
                        " | "+String.format("%-9s", a.AnForm() ? "Sí" : "No")+
                        " | "+String.format("%-"+tamLista[4]+".2f", a.AnPeso()  )+
                        " | "+String.format("%-12.2f", a.AnConsumo()  )+
                        " | "+String.format("%-11.2f", a.AnConsumo()*App.precio  )+
                        " |\r\n"); 
            };                   
        System.out.printf(  "|"+"-".repeat(tamLista[0])+"|\r\n" + 
                        "| "+String.format("%-"+(tamLista[0]-2)+"s", String.format("Coste diario total de alimentación: %.2f EUR", ref.getPrecioTotal())) +" |\r\n"+ 
                        "| "+String.format("%-"+(tamLista[0]-2)+"s", String.format("Peso medio de los animales: %.2f kg", ref.getPesoMedio()))+" |\r\n" + 
                        "|"+"-".repeat(tamLista[0])+"|\r\n");
    }
}

