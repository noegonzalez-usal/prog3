import java.io.Console;
public class App {
    public static void main(String[] args) throws Exception {
        Console refConsole = System.console();
        int nacint, actint;
        do{
            System.out.println("Introduzca su año de nacimiento: ");
            String nac = refConsole.readLine();
            System.out.println("Introduzca el año actual: ");
            String act = refConsole.readLine();
            nacint=Integer.parseInt(nac);
            actint=Integer.parseInt(act);
        }while (nacint > actint);
        int edad =actint - nacint;
        System.out.printf("Su edad es %d", edad);
    }
}
