package Vista;

import Modelo.Libro;

import es.usal.progiii.tools.Esdia;
import java.util.HashMap;
import java.util.Map;
import java.io.IOException;
import com.google.gson.JsonParseException;

public class Vista{

    public int menu(){
        System.out.println("\n1. Mostrar el listado de libros en formato tabla.");
        System.out.println("2. Añadir nuevo libro al modelo");
        System.out.println("3. Eliminar libro de una lista de libros disponibles");
        System.out.println("4. Modificar libro de una lista de libros disponibles");
        System.out.println("5. Exportar libros en formato delimitado por comas CSV.");
        System.out.println("6. Exportar libros en formato JSON");
        System.out.println("7. Exportar libros en formato XML");
        System.out.println("8. Importar libros de un fichero JSON");
        System.out.println("9. Importar libros de un fichero XML");
        System.out.println("10. Importar libros de un fichero en formato delimitado por comas CSV");
        System.out.println("11. Salir del programa.\n");
        return Esdia.readInt("Ingrese una opción: ",1,11);
    }

    public String leerTitulo(){
        return Esdia.readString("Introduzca el titulo del libro: ");
    }
    
    public String leerAutor(){
        return Esdia.readString("Introduzca el autor/a del libro: ");
    }
    
    public int leerISBN(){
        return Esdia.readInt("Introduzca el ISBN del libro: ");
    }

    public void imprimirLibros(HashMap<Integer, Libro> libros){
        System.out.println("\nLista de libros disponibles: ");
        for(Map.Entry<Integer, Libro> libro:libros.entrySet()){
            System.out.println(libro.getValue().getLibroComoString()+" | ISBN: "+libro.getKey());
        }
    }

    public void imprimirLista(HashMap<Integer, Libro> libros, int[] longitudes){
        System.out.println(String.format("\n%-"+Math.max(longitudes[0],6)+"s  %-"+Math.max(5,longitudes[1])+"s  ISBN","Titulo","Autor"));
        System.out.println("-".repeat(Math.max(longitudes[0],6)+Math.max(5,longitudes[1])+10));
        for(Map.Entry<Integer, Libro> libro:libros.entrySet()){
            System.out.println(String.format("%-"+Math.max(longitudes[0],6)+"s  %-"+Math.max(5,longitudes[1])+"s  %d",libro.getValue().getTitulo(),libro.getValue().getAutor(),libro.getKey()));
        }
    }


    public void imprimir(String mensaje){
        System.out.println(mensaje);
    }

    public void imprimirError(String error){
        System.err.println("Error: "+ error);
    }

    public void imprimirError(IOException error){
        System.err.println("Error: "+ error);
    }

    public void imprimirError(JsonParseException error){
        System.err.println("Error: "+ error);
    }

    public void imprimirError(Exception error){
        System.err.println("Error: "+ error);
    }
}