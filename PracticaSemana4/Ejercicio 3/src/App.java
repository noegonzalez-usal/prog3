import es.usal.progiii.tools.Esdia;

public class App {
    public static void main(String[] args) throws Exception {
        float m=Esdia.readFloat("Introduce precio de las manzanas");
        float p=Esdia.readFloat("Introduce precio de las peras");
        Producto manzana = Producto(m);
        Producto pera = Producto(p);
        
    }
}
