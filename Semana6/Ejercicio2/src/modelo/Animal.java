package modelo;

import es.usal.progiii.tools.Esdia;

public class Animal {
    private Cuidador cuidador= new Cuidador();
    private String nombre;
    private String especie;
    private float peso;
    private float consumo;
    
    public void Nuevo(){
        this.cuidador.newC();
        this.nombre=Esdia.readString("Nombre del animal: ");
        this.especie=Esdia.readString("Especie: ");
        this.peso=Esdia.readFloat("Peso del animal: ");
        do{
            if(this.peso<=0){
                this.peso=Esdia.readFloat("Peso no válido. Introduzca de nuevo el peso: ");
            }
        }while(this.peso<=0);
        this.consumo=Esdia.readFloat("Consumo diario del animal: ");
        do{
            if(this.consumo<=0){
                this.consumo=Esdia.readFloat("Consumo no válido. Introduzca de nuevo el consumo en kg: ");
            }
        }while(this.consumo<=0);
    }

    public int AnCui(){
        return this.cuidador.CuiN();
    }

    public String AnCuiN(){
        return this.cuidador.CuiName();
    }

    public boolean AnForm(){
        return this.cuidador.Form();
    }

    public int AnN(){
        return this.nombre.length();
    }

    public String AnName(){
        return this.nombre;
    }

    public int AnE(){
        return this.especie.length();
    }

    public String AnEspecie(){
        return this.especie;
    }

    public int AnP(){
        return String.valueOf(this.peso).length();
    }

    public float AnPeso(){
        return this.peso;
    }

    public float AnConsumo(){
        return this.consumo;
    }
}
