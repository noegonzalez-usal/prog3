import es.usal.progiii.tools.Esdia;
import java.util.HashMap;
import java.util.Map;

public class App {

    public static HashMap<Integer,Libro> libros = new HashMap<>();

    public static void main(String[] args) throws Exception {
        int opcion;
        do {
            System.out.println("\n--- MENU CRUD ---");
            System.out.println("1. Agregar libro");
            System.out.println("2. Eliminar libro");
            System.out.println("3. Modificar libro");
            System.out.println("4. Listar libros");
            System.out.println("5. Salir");
            opcion = Esdia.readInt("Ingrese una opción: ");

            switch (opcion) {
                case 1:
                    agregarLibro();
                    break;
                case 2:
                    eliminarLibro();
                    break;
                case 3:
                    modificarLibro();
                    break;
                case 4:
                    listarLibros();
                    break;
                case 5:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 5);
    }

    public static void agregarLibro(){
        String n=Esdia.readString("Introduce el nombre del libro: ");
        String a=Esdia.readString("Introduce el autor del libro: ");
        int isbn=Esdia.readInt("Introduce el ISBN del libro: ");
        String respuesta;
        boolean d=false;
        do{
            respuesta=Esdia.readString("¿Posee el cuidador formación? (Responda con Si o No): ");
            if(!respuesta.equalsIgnoreCase("si")&&!respuesta.equalsIgnoreCase("no")) System.out.printf("Respuesta no válida, intentelo de nuevo.\n");
            }while(!respuesta.equalsIgnoreCase("si")&&!respuesta.equalsIgnoreCase("no"));
            d=respuesta.equalsIgnoreCase("si");
        libros.put(isbn, new Libro(n,a,d));
    }
    
    public static void eliminarLibro(){
        int isbn=Esdia.readInt("Introduce el ISBN del libro a eliminar: ");
        if(libros.containsKey(isbn)){
            libros.remove(isbn);
            System.out.printf("Libro eliminado con éxito");
        }
        else System.out.printf("Libro no encontrado");
    }

    public static void modificarLibro(){
        int isbn=Esdia.readInt("Introduce el ISBN del libro a modificar");
        if(libros.containsKey(isbn)){
            String n=Esdia.readString("Introduce el nombre del libro");
        String a=Esdia.readString("Introduce el autor del libro");
        String respuesta;
        boolean d=false;
        do{
            respuesta=Esdia.readString("¿Posee el cuidador formación? (Responda con Si o No): ");
            if(!respuesta.equalsIgnoreCase("si")&&!respuesta.equalsIgnoreCase("no")) System.out.printf("Respuesta no válida, intentelo de nuevo.\n");
            }while(!respuesta.equalsIgnoreCase("si")&&!respuesta.equalsIgnoreCase("no"));
            d=respuesta.equalsIgnoreCase("si");
        libros.put(isbn, new Libro(n,a,d));
            System.out.printf("Libro modificado con éxito");
        }
        else System.out.printf("Libro no encontrado");
    }

    public static void listarLibros(){
        if(libros.isEmpty()){
            System.out.printf("No hay libros en la biblioteca");
        }

        else{
            System.out.printf("Estos son los libros disponibles:\n");
            for(Map.Entry<Integer, Libro> entry : libros.entrySet()){
                int isbn=entry.getKey();
                String d;
                if(entry.getValue().getDisponible()) {
                    d = new String("Si");
                } 
                else {
                    d = new String("No");
                }
                System.out.printf("| Libro: \"%s\" | Autor: %s | ISBN: %d | Disponible: %s\n", entry.getValue().getNombre(), entry.getValue().getAutor(),isbn,d);
            }
        }
    }
}
