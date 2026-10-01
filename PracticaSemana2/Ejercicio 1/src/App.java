import es.usal20.progiii.tools.Esdia;
public class App {
    public static void main(String[] args) throws Exception {
        int nac;
        int ano;
        do{
            nac = Esdia.readInt("Intoduzca su año de nacimiento :");
            ano = Esdia.readInt("Intoduzca el año actual :");
            if(nac > ano){
                System.out.println("El año de nacimiento no puede ser mayor que el año actual");
            }
        } while (nac > ano);
        int edad =ano - nac;
        System.out.printf("Su edad es %d", edad);
    }
}
