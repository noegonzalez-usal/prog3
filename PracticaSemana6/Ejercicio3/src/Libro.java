public class Libro {
    
    private String nombre;
    private String autor;
    private boolean disponible;

    public Libro(String n, String a, boolean d){
        this.nombre=n;
        this.autor=a;
        this.disponible=d;
    }

    public void setNombre(String n){
        this.nombre=n;
    }

    public void setAutor(String a){
        this.autor=a;
    }

    public void setDisponible(boolean d){
        this.disponible=d;
    }

    public String getNombre(){
        return this.nombre;
    }

    public String getAutor(){
        return this.autor;
    }

    public boolean getDisponible(){
        return this.disponible;
    }
}
