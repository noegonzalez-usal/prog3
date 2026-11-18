package Modelo;

public class Libro {
    
    private String titulo;
    private String autor;

    public Libro(String t, String a){
        titulo=t;
        autor=a;
    }

    public String getLibroComoString(){
        return String.format("\"%s\" - %s",titulo,autor);
    }

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
