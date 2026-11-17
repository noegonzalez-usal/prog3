package Modelo;
public class Factura {
    private String concepto;
    private double descuento;
    private String fecha;
    private double importe;
    private String nif;
    private String nombre;
    private String direccion;
    private double iva;

    public Factura(String concepto, String descuento, String fecha, String importe, String nif, String nombre, String direccion, String iva){
        this.concepto=concepto;
        this.descuento=Double.parseDouble(descuento);
        this.fecha=fecha;
        this.importe=Double.parseDouble(importe);
        this.nif=nif;
        this.nombre=nombre;
        this.direccion=direccion;
        this.iva=Double.parseDouble(iva);
    }

    public double getValorMinimo(){
        return this.importe*(1-descuento)*(1+iva);
    }

    public int[] getLongitudes() {
        return new int[] {
            this.concepto.length(),
            String.format("%.2f",importe).length(),
            this.nombre.length(),
            this.direccion.length()
        };
    }

    public String getConcepto(){
        return concepto;
    }

    public double getDescuento() {
        return descuento;
    }

    public String getFecha() {
        return fecha;
    }

    public double getImporte() {
        return importe;
    }

    public String getNif() {
        return nif;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public double getIva() {
        return iva;
    }

}
