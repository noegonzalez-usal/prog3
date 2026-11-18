package Modelo;
public class DatosDeAlumno {
    
    private Direccion direccion;
    private DatosPersonales datosPersonales;

    public DatosDeAlumno(Direccion a, DatosPersonales b){
        direccion=a;
        datosPersonales=b;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public DatosPersonales getDatosPersonales() {
        return datosPersonales;
    }

    public int[] getLongitudes(){
        int[] longitudes=new int[3];
        longitudes[0]=datosPersonales.getLongitudes()[0];
        longitudes[1]=datosPersonales.getLongitudes()[1];
        longitudes[2]=direccion.getLongitudString();
        return longitudes;
    }

}
