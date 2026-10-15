package paquete2;
import paquete1.Clase1;
import paquete1.Clase2; // no es visible, tiene por defecto package-private

public class App {
    public static void main(String[] args) throws Exception {
        Clase1 C=new Clase1();
        System.out.println(C.A);
        System.out.println(C.B);
        System.out.println(C.C);
        System.out.println(C.D);
         //no puede acceder a todo lo que no es publico
        C.f1();
        C.f2(); 
        C.f3();
        C.f4(); 
        // estos 3 ultimos metodos no son accesibles y no funcionan
    }

    // el modificador public hace que se pueda acceder desde cualquier parte del proyecto
    // el protected hace que se pueda acceder a ello desde el mismo paquete y otras subclases de la clase
    // el private hace que solo se pueda acceder desde la misma clase
    // sin modificador solo deja acceder desde el paquete

    // Ejemplos:
    // public se utiliza para funciones de una clase para que se puedan acceder desde el archivo principal
    // private se utiliza para atributos de una clase
    // protected se puede utilizar para crear metodos que se usen solo dentro de subclases
    // sin modificador podria usarse para funciones auxiliares dentro de un paquete o clase que no se va a necesitar fuera

}
