public class Producto {
    
    private double precio;
    private double IVA= 0.04;

    public Producto(double n){
        this.precio=n;
    }

    public double getPrecio(){
        return this.precio*(1+IVA);
    }
    
}
