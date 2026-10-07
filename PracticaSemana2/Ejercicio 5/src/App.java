import es.usal.progiii.tools.Esdia;
public class App {
    public static void main(String[] args) throws Exception {
        String n=Esdia.readString("Introduzca su nombre: ");
        String a=Esdia.readString("Introduzca sus apellidos: ");
        int N=n.length();
        int A=a.length();
        int T=Math.max(N,6)+Math.max(A,9)+7;

        for(int i=0; i<T; i++){
            System.out.printf("*");
        }

        System.out.printf("\n* Nombre ");

         for(int i=0; i<Math.max(0,N-6); i++){
            System.out.printf(" ");
        }
        System.out.printf("* Apellidos ");
        for(int i=0; i<Math.max(0,A-9); i++){
            System.out.printf(" ");
        }
        System.out.printf("*\n");

        for(int i=0; i<T; i++){
            System.out.printf("*");
        }

        System.out.printf("\n* %s", n);
        for(int i=0; i<Math.max(0,6-N); i++){
            System.out.printf(" ");
        }
        System.out.printf(" * %s ", a);
        for(int i=0; i<Math.max(0,9-A); i++){
            System.out.printf(" ");
        }
        System.out.printf("*\n");
        for(int i=0; i<T; i++){
            System.out.printf("*");
        }
    }
}