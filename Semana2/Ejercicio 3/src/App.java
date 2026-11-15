import es.usal.progiii.tools.Esdia;
public class App {
    public static void main(String[] args) throws Exception {
        try{
            float med=0, num=0;
            int N=Esdia.readInt("Introduzca la cantidad de números: ");
            for(int i=0; i<N; i++){
                num=Esdia.readFloat("Introduzca un número: ");
                med=med+num;
            }
            med=med/N;
            System.out.printf("La media es: %.2f", med);
        }catch (Exception e){
            System.err.println("Se ha cometido un error: ");
        }
    }
}
