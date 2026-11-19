package paquete2;
import paquete1.Clase1;
//import paquete1.Clase2; 
// App no esta en el mismo paquete que App2, luego por package-private no puedo acceder a el

public class App {
    public static void main(String[] args) throws Exception {
        Clase1 C=new Clase1();
        System.out.println(C.A);
        //System.out.println(C.B);
        //System.out.println(C.C);
        //System.out.println(C.D);

// Solamente el atributo A es publico, los otros restringen el acceso al paquete, paquete y subclases,
// y a la misma clase respectivamente, luego solo puedo acceder al atributo publico. 

        C.f1();
        //C.f2(); 
        //C.f3();
        //C.f4(); 

// Ocurre lo mismo que con los atributos, tienen los mismos modificadores de acceso.
    }

// El modificador public hace que se pueda acceder desde cualquier parte del proyecto (tanto clases como atributos y
// metodos), util para cualquier clase de la que debamos usar metodos desde el main por ejemplo.
// El modificador private permite acceso unicamente a elementos del mismo paquete y a subclases, util para atributos y
//  metodos que hereden las subclases.
// El default/package-private permite acceso unicamente a elementos del mismo paquete. Util para clases auxiliares, que
// solo se necesiten dentro del paquete.
// El modificador private permite acceso a solamente la clase donde esta. Util para separar responsabilidades y evitar
// cambios hechos desde fuera, restringiendo el acceso a getters y setters.

}
