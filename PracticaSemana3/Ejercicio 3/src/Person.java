public class Person{
    private String nombre;
    private float altura;
    private float peso;

    public Person(String n, float a, float p){
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
        return this.peso*10000 /((this.altura)*(this.altura));
    }

}