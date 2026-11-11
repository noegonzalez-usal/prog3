import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        try(Scanner sc = new Scanner(System.in)){
        System.out.println("Introduce un número: ");
        float i = sc.nextFloat();
        System.out.println("Introduce otro número: ");
        float j = sc.nextFloat();
        System.out.printf("La suma de ambos números es: %.2f\n", i+j);
        }catch(Exception e){
            System.err.printf("Error");
        };
    }
}
