import es.usal.progiii.tools.Esdia;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.printf("// Bienvenido a la frutería, tendero! //\n");
        double m=Esdia.readDouble("Por favor, introduce precio de hoy de las manzanas: ");
        double p=Esdia.readDouble("Introduce el precio de hoy de las peras: ");
        Producto manzana = new Producto(m); 
        Producto pera = new Producto(p);
        int opcion, nCliente=1;
        do{
            opcion=Esdia.readInt("1. Nuevo cliente \n2. Cerrar frutería y ver factura\n");
            switch(opcion){
                case 1:{
                    double cantidadManzana=Esdia.readDouble("Cantidad de manzanas en kg: ");
                    double cantidadPera=Esdia.readDouble("Cantidad de peras en kg: ");
                    factura(nCliente++,cantidadManzana,cantidadPera, manzana.getPrecio(), pera.getPrecio());
                    break;
                }
                case 2:{
                    break;
                }
                default:{
                    System.out.printf("Valor no válido");
                }
            }
        }while(opcion!=2);
        
    }

    public static void factura(int i, double j, double k, double precioM, double precioP){
        System.out.printf("|--------------------------------------------------------------|\n");
        System.out.printf("|"+String.format("%-58s", " Cliente")+"| %d |\n", i);
        System.out.printf("|--------------------------------------------------------------|\n");
        System.out.printf("| Manzanas | %-7.2f kg | precio Kg con IVA %7.2f | %8.2f |\n", j, precioM, j*precioM);
        System.out.printf("| Peras    | %-7.2f kg | precio Kg con IVA %7.2f | %8.2f |\n", k, precioP, k*precioP);
        System.out.printf("|--------------------------------------------------------------|\n");
        System.out.printf("| Total con IVA: %-45.2f |\n", j*precioM+k*precioP);
        System.out.printf("|--------------------------------------------------------------|\n");
    }
}
