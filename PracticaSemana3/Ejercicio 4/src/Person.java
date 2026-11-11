public class Person{
    private String nombre=Nombre();
    private float altura=0;
    private float peso=0;

    public Person(String n, float a, float p){  
        this.nombre = n;
        this.altura = a;
        this.peso = p;
    }

    public String Nombre(){
        return "nombre";
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

}