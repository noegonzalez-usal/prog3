import es.usal.progiii.tools.Esdia;
public class App {
    public static void main(String[] args) throws Exception {
        int nacimiento;
        int ano;
        do{
            nacimiento = Esdia.readInt("Intoduzca su año de nacimiento :");
            ano = Esdia.readInt("Intoduzca el año actual :");
            if(nacimiento > ano){
                System.out.println("El año de nacimiento no puede ser mayor que el año actual");
            }
        } while (nacimiento > ano);
        int edad =ano - nacimiento;
        System.out.printf("Su edad es %d", edad);
    }
}
