
public class Coche{
    private String marca, modelo, matricula;
    private int año;
    private double precio;

    @Override
    public String toString(){
        return "Marca: " + this.marca +
               " | Modelo: " + this.modelo +
               " | Matricula: " + this.matricula +
               " | Año: " + this.año +
               " | Precio: " + this.precio + " EUR\n";
               
    }

    public void setMarca(String s){
        this.marca=s;
    }

    public void setModelo(String s){
        this.modelo=s;
    }

    public void setMatricula(String s){
        this.matricula=s;
    }

    public void setAño(int i){
        this.año=i;
    }

    public void setPrecio(double d){
        this.precio=d;
    }

    public String getMarca(){
        return this.marca;
    }

    public String getModelo(){
        return this.modelo;
    }

    public String getMatricula(){
        return this.matricula;
    }

    public int getAño(){
        return this.año;
    }

    public double getPrecio(){
        return this.precio;
    }

}