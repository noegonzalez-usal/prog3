package Modelo;

import java.util.Random;
import java.util.HashSet;

public class DatosPersonales{

    private String nombre;
    private String apellidos;
    private int edad;
    private String nif;
    private static Random random=new Random();
    private static HashSet<String> nifs=new HashSet<>();

    private DatosPersonales(String n, String a, int e, String nif){
        nombre=n;
        apellidos=a;
        edad=e;
        this.nif=nif;
    }

    public static DatosPersonales crearDatosPersonales(){
        String nombre = generarNombre();
        String apellidos = generarApellidos();
        int edad = generarEdad();
        String nif = generarNIF();

        return new DatosPersonales(nombre, apellidos, edad, nif);
    }

    private static String generarNombre() {
        String[] nombres = {
            "Carlos", "Lucía", "Javier", "María", "Alejandro",
            "Laura", "Daniel", "Sofía", "Pablo", "Carmen"
        };

        return nombres[random.nextInt(nombres.length)];
    }

    private static String generarApellidos() {
        String[] apellidos = {
            "García", "Martínez", "López", "Sánchez", "Pérez",
            "Gómez", "Fernández", "Díaz", "Romero", "Torres"
        };

        return apellidos[random.nextInt(apellidos.length)];
    }

    private static int generarEdad() {
        return random.nextInt(4) + 12;
    }

    private static String generarNIF() {
        boolean repetido=true;
        String nif;
        String[] letras = {"A", "B", "C", "D", "E", "F", "G", "H", "J", "K", "L", "M", "N", "P", "Q", "R", "S", "T", "V", "W", "X", "Y", "Z"};
        do{
            int numero = random.nextInt(100_000_000) + 1;
            String letra=letras[random.nextInt(letras.length)];
            nif=String.format("%08d%s",numero,letra);
            if(!nifs.contains(nif)) {
                repetido=false;
                nifs.add(nif);
            }
        }while(repetido==true);
        return nif;
    }

    public static void resetNifs(){
        nifs=new HashSet<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public String getNif() {
        return nif;
    }

    public int[] getLongitudes(){
        return new int[]{
            nombre.length(),
            apellidos.length(),
        };
    }
}