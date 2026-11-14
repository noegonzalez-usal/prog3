package modelo;

import es.usal.progiii.tools.Esdia; 

public class Cuidador {

    private String nombre;
    private String apellidos;
    private boolean formacion;
    private String respuesta;

        public void newC(){
            this.nombre = Esdia.readString("Introduce el nombre del cuidador: ");
            this.apellidos = Esdia.readString("Introduce los apellidos del cuidador: ");
            do{
                this.respuesta=Esdia.readString("¿Posee el cuidador formación? (Responda con Si o No): ");
                if(!this.respuesta.equalsIgnoreCase("si")&&!this.respuesta.equalsIgnoreCase("no")) System.out.printf("Respuesta no válida, intentelo de nuevo.\n");
            }while(!this.respuesta.equalsIgnoreCase("si")&&!this.respuesta.equalsIgnoreCase("no"));
            this.formacion=this.respuesta.equalsIgnoreCase("si");
        }

     public int CuiN(){
        return (this.nombre.length() + this.apellidos.length() +1);
    }

    public String CuiName(){
        return String.format("%s %s", this.nombre, this.apellidos);
    }

    public boolean Form(){
        return this.formacion;
    }
}
