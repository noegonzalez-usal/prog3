public class Usuario {
    private String nombre;
    private float altura;
    private float peso;

    public Usuario(String n, float p, float a){
        this.nombre = n;
        this.altura = a;
        this.peso = p;
    }
    public String getNombre(){
        return this.nombre;
    }
    public float getAltura(){
        return this.altura;
    }
    public float getPeso(){
        return this.peso;
    }

    public void setNombre(String S){
        this.nombre = S;
    }
    public void setAltura(float A){
        this.altura=A;
    }
    public void setPeso(float P){
        this.peso=P;
    }

    public float IMC(){
        return this.peso*10000/(this.altura*this.altura);
    }

    public static Usuario nuevo(String[] args){
    try{
        Usuario U= new Usuario(args[0],Float.parseFloat(args[1]),Float.parseFloat(args[2]));
        return U;    
    } catch(Exception e){
            System.err.printf("Valores no válidos");
            return null;
    }
    }
 
}
