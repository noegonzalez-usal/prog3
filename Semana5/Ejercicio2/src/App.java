import java.util.Arrays;
import es.usal.progiii.tools.Esdia;

public class App {
    public static void main(String[] args) throws Exception {
        int MAX = 5;
        String[] lista= new String[MAX];
        for(int i=0;i<MAX;i++){
            lista[i]=Esdia.readString("Introduzca un String: ");
        }
        Arrays.sort(lista);
        System.out.printf("Los String ordenados con Arrays.sort() son:\n");
        for(int i=0;i<MAX;i++){
            System.out.printf("%d) %s\n", i+1, lista[i]);
        }

    }
}
