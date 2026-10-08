public class App {
    public static void main(String[] args) throws Exception {
        try{
            if(args.length!=2){
                System.err.printf("Cantidad incorrecta de argumentos");
            }else{
                float A=Float.parseFloat(args[0]);
                float B=Float.parseFloat(args[1]);
                System.out.printf("La suma es %.2f",A+B);
            };
        } catch(Exception e){
            System.err.printf("Valores no válidos");
        }
    }
}
