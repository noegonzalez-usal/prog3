import es.usal.progiii.tools.Esdia;
public class App {
    public static void main(String[] args) throws Exception {
        do{
            int nacimiento = Esdia.readInt("Intoduzca su año de nacimiento :");
            int ano = Esdia.readInt("Intoduzca el año actual :");
        } while (nacimiento > ano);
        int edad ={ano - nacimiento};
        System.out.printf("Tu edad es %d", edad);
    }
}
