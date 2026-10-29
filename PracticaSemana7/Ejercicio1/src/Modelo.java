public class Modelo {
    private float[] numeros;
    private float suma;

    public void setNumeros(float[] i){
        this.numeros=i;
    }

    public float[] getNumeros(){
        return this.numeros;
    }

    public void calcularSuma(){
        this.suma=this.numeros[0]+this.numeros[1];
    }

    public float getSuma (){
        return this.suma;
    }
}
