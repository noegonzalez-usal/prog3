package Modelo;

import java.util.Random;

public class Direccion {
    
    private String calle;
    private int numero;
    private int piso;
    private String letra;
    private static Random random=new Random();

    private Direccion(String c, int n, int p, String l){
        calle=c;
        numero=n;
        piso=p;
        letra=l;
    }

    public static Direccion crearDireccion(){
        String calle=generarCalle();
        int numero=generarNumero();
        int piso=generarPiso();
        String letra=generarLetra();
        return new Direccion(calle,numero,piso,letra);
    }

    private static String generarCalle(){
        String[] calles=new String[]{
            "Calle de Alcalá",
            "Calle de Atocha",
            "Calle de Serrano",
            "Avenida de América",
            "Avenida de la Albufera",
            "Avenida de Portugal"
        };
        return calles[random.nextInt(calles.length)];
    }

    private static int generarNumero(){
        int numeroRandom = random.nextInt(50)+1;
        return numeroRandom;
    }

    private static int generarPiso(){
        int numeroRandom = random.nextInt(5);
        return numeroRandom;
    }

    private static String generarLetra(){
        String[] letras=new String[]{
            "A","B","C","D"
        };
        return letras[random.nextInt(letras.length)];
    }

    public String getDireccionComoString(){
        if(piso==0) return String.format(calle+" "+numero+", Bajo "+letra);
        else return String.format(calle+" "+numero+", "+piso+"º"+letra);
    }

    public int getLongitudString(){
        if(piso==0) return String.format(calle+" "+numero+", Bajo "+letra).length();
        else return String.format(calle+" "+numero+", "+piso+"º"+letra).length();
    }

    public String getCalle() {
        return calle;
    }

    public int getNumero() {
        return numero;
    }

    public int getPiso() {
        return piso;
    }

    public String getLetra() {
        return letra;
    }

}
