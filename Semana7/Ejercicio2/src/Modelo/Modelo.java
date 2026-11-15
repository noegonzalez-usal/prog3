package Modelo;

import java.util.ArrayList;

public class Modelo {
    
    private ArrayList<Integer[]> almacenes= new ArrayList<>();
    private double precio1;
    private double precio2;
    private double[] individuales= new double[5];
    private Double resultado;

    public void setPrecios(double[] d){
        this.precio1=d[0];
        this.precio2=d[1];
    }

    public void setVentas(ArrayList<Integer[]> a){
        this.almacenes=a;
    }

    public void setResultado(double r){
        this.resultado=r;
    }

    public void setIndividual(int i, double d){
        this.individuales[i]=d;
    }

    public double[] getPrecios(){
        return new double[]{this.precio1,this.precio2};
    } 

    public ArrayList<Integer[]> getVentas(){
        return almacenes;
    }

    public Double getResultado(){
        return this.resultado;
    }

    public double[] getIndividuales(){
        return individuales;
    }

    public void reset(){
        this.individuales = new double[5];
        this.resultado= null;
    }
}
