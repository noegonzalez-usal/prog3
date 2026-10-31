import es.usal.progiii.tools.Esdia;
import java.util.ArrayList;
import java.util.Iterator;

public class EjColecciones {
    static ArrayList<Coche> coches = new ArrayList<>();
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
            String marca=Esdia.readString("Introduce la marca del coche: ");
            String modelo = Esdia.readString("Introduce el modelo del coche: ");
            String matricula = Esdia.readString("Introduce la matricula del coche: ");
            int año=Esdia.readInt("Introduce el año del coche: ");
            double precio=Esdia.readDouble("Introduce el precio del coche: ");
            coches.add(new Coche(marca, modelo, matricula, año, precio));
    }

    public static void eliminarCoche(){
        String s=Esdia.readString("Introduzca la matrícula del coche a eliminar: ");
        boolean encontrado=false;
        Iterator<Coche> iterator=coches.iterator();
        while(iterator.hasNext()){
            Coche c=iterator.next();
            if (c.getMatricula().equalsIgnoreCase(s)){
                iterator.remove();
                encontrado=true;
                break;
            }
        }

        if(encontrado){System.out.printf("Coche eliminado correctamente");
        }else{System.out.printf("Coche no encontrado");}
    }

    public static void modificarCoche(){
        String s=Esdia.readString("Introduzca la matrícula del coche a modificar: ");
        boolean encontrado=false;
        Iterator<Coche> iterator=coches.iterator();
        while(iterator.hasNext()){
            Coche c=iterator.next();
            if (c.getMatricula().equalsIgnoreCase(s)){
                c.setMarca(Esdia.readString("Introduce la marca del coche: "));
                c.setModelo(Esdia.readString("Introduce el modelo del coche: "));
                c.setMatricula(Esdia.readString("Introduce la matricula del coche: "));
                c.setAño(Esdia.readInt("Introduce el año del coche: "));
                c.setPrecio(Esdia.readDouble("Introduce el precio del coche: "));
                encontrado=true;
                break;
            }
        }
        if(encontrado==false) System.out.printf("Matricula no encontrada");
        
    }

    public static void listaCoche(){
        if(coches.isEmpty()){
            System.out.printf("No hay coches");
        }else{
            Iterator<Coche> iterator=coches.iterator();
            while(iterator.hasNext()){
                Coche c=iterator.next();
                System.out.printf(c.getCocheString());
            }
        }

    }
}
