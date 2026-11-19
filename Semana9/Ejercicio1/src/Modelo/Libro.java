package Modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;

public class Libro implements Serializable{
    
    private String titulo;
    private String autor;

    public Libro(){

    }

    public Libro(String t, String a){
        titulo=t;
        autor=a;
    }

    @JsonIgnore
    public String getLibroComoString(){
        return String.format("\"%s\" - %s",titulo,autor);
    }

    @JsonIgnore
    public int[] getLongitudes(){
        return new int[]{
            titulo.length(),
            autor.length()
        };
    }


    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }
}
