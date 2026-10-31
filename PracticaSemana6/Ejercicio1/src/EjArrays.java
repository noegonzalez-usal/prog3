import es.usal.progiii.tools.Esdia;
import java.util.Arrays;

public class EjArrays {
    static int max=10;
    static Coche[] coches = new Coche[max];
    static int count;
    public static void main(String[] args) throws Exception {
        

        int opcion;

        do {
            System.out.println("\n--- MENU CRUD ---");
            System.out.println("1. Agregar coche");
            System.out.println("2. Eliminar coche");
            System.out.println("3. Modificar coche");
            System.out.println("4. Lista de coches");
            System.out.println("5. Salir");
            opcion = Esdia.readInt("Ingrese una opción: ");
            
            switch (opcion) {
                case 1: agregarCoche(); break;
                case 2: eliminarCoche(); break;
                case 3: modificarCoche(); break;
                case 4: listaCoche(); break;
                case 5: System.out.println("¡Hasta luego!"); break;
                default: System.out.println("Opción no válida.");
            }
        } while (opcion != 5);
    }

    public static void agregarCoche(){
        if(count<max){
            coches[count]=new Coche();
            coches[count].setMarca(Esdia.readString("Introduce la marca del coche: "));
            coches[count].setModelo(Esdia.readString("Introduce el modelo del coche: "));
            coches[count].setMatricula(Esdia.readString("Introduce la matricula del coche: "));
            coches[count].setAño(Esdia.readInt("Introduce el año del coche: "));
            coches[count].setPrecio(Esdia.readDouble("Introduce el precio del coche: "));
            count++;
        }else{System.out.printf("Array lleno");}
    }

    public static void eliminarCoche(){
        String s=Esdia.readString("Introduzca la matrícula del coche a eliminar: ");
        boolean encontrado=false;
        for(int i=0;i<count;i++){
            if(coches[i].getMatricula().equalsIgnoreCase(s)){
                for(int j=i;j<count-1;j++){
                    coches[j]=coches[j+1];
                }
                encontrado = true;
                count--;
                System.out.printf("Coche eliminado correctamente");
                break;
            }
        }
        if(encontrado==false) System.out.printf("Matricula no encontrada");
    }

    public static void modificarCoche(){
        String s=Esdia.readString("Introduzca la matrícula del coche a modificar: ");
        boolean encontrado=false;
        for(int i=0;i<count;i++){
            if(coches[i].getMatricula().equalsIgnoreCase(s)){
                coches[i].setMarca(Esdia.readString("Introduce la marca del coche: "));
                coches[i].setModelo(Esdia.readString("Introduce el modelo del coche: "));
                coches[i].setMatricula(Esdia.readString("Introduce la matricula del coche: "));
                coches[i].setAño(Esdia.readInt("Introduce el año del coche: "));
                coches[i].setPrecio(Esdia.readDouble("Introduce el precio del coche: "));
                encontrado=true;
            }
        }
        if(encontrado==false) System.out.printf("Matricula no encontrada");
        
    }

    public static void listaCoche(){
        Coche[]temp=Arrays.copyOf(coches, count);
        System.out.printf(Arrays.toString(temp));

    }
}
