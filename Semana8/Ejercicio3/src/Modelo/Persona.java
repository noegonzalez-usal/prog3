package Modelo;

public class Persona{

    private String nombre;
    private String tfno;
    private double peso;

    public Persona(String n, String t, double p){
        nombre=n;
        tfno=t;
        peso=p;
    }

    public String getNombre(){
        return nombre;
    }

    public String getTfno(){
        return tfno;
    }

    public double getPeso(){
        return peso;
    }   

    public int getLongitud(){
        return nombre.length();
    }

}
