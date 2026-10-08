public class App {
        public static void main(String[] args) throws Exception {
         try{
            if(args.length!=3){
                System.err.printf("Cantidad incorrecta de argumentos");
            }else{
            Usuario user = Usuario.nuevo(args);
            System.out.printf("%s %.2f %.2f %.2f", user.getNombre(), user.getPeso(),user.getAltura(),user.IMC());
            };
        } catch(Exception e){
            System.err.printf("Valores no válidos");
        }
    }
}

