package Modelo;

import java.util.ArrayList;
import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;

public class Modelo{

    private ArrayList<DatosDeAlumno> alumnos=new ArrayList<>();

    public void crearListaAlumnos(){
        alumnos=new ArrayList<>();
        DatosPersonales.resetNifs();
        for(int i=0;i<20;i++){
            alumnos.add(new DatosDeAlumno(Direccion.crearDireccion(), DatosPersonales.crearDatosPersonales()));
        }
    }

    public ArrayList<DatosDeAlumno> getAlumnos(){
        return alumnos;
    }

    public int[] getLongitudes(){
        int[] longitudes=new int[]{0,0,0};
        for(DatosDeAlumno alumno:alumnos){
            int[]l=alumno.getLongitudes();
            for(int i=0;i<3;i++){
                longitudes[i]=Math.max(longitudes[i],l[i]);
            }
        }
        return longitudes;
    }

    public void exportarDirecciones() throws IOException{
        String ruta="data"+File.separator+"direcciones.csv";
        File archivo=new File(ruta);
        PrintWriter writer=new PrintWriter(archivo);
        writer.println("calle,numero,piso,letra");
        for(DatosDeAlumno alumno:alumnos){
            String[] strings=new String[]{alumno.getDireccion().getCalle(),alumno.getDireccion().getLetra()};
            int[] numeros=new int[]{alumno.getDireccion().getNumero(),alumno.getDireccion().getPiso()};
            writer.printf("%s,%d,%d,%s\n",strings[0],numeros[0],numeros[1],strings[1]);
        }
        writer.close();
    }

    public void exportarDatos() throws IOException{
        String ruta="data"+File.separator+"datos_alumnos.csv";
        File archivo=new File(ruta);
        PrintWriter writer=new PrintWriter(archivo);
        writer.println("nombre,apellidos,edad,NIF");
        for(DatosDeAlumno alumno:alumnos){
            String[] strings=new String[]{alumno.getDatosPersonales().getNombre(),alumno.getDatosPersonales().getApellidos(),alumno.getDatosPersonales().getNif()};
            int edad= alumno.getDatosPersonales().getEdad();
            writer.printf("%s,%s,%d,%s\n",strings[0],strings[1],edad,strings[2]);
        }
        writer.close();
    }

}