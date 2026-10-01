import es.usal.progiii.tools.Esdia;
public class App {
    public static void main(String[] args) throws Exception {
        int N;
        do{
            N=Esdia.readInt("Introduzca la cantidad de numeros:");
        }while(N<=0);
        float media=0;
        for(int i=0;i<N;i++){
            float num=Esdia.readFloat("Introduzca el numero "+(i+1)+": ");
            media+=num;
        }
        media/=N;
        System.out.println("La media es: "+media);

    }
}
