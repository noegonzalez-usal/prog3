package modelo;

import app.App;

import java.util.ArrayList;
import java.util.Iterator;

public class Refugio {
    
    private Animal an;
    private ArrayList<Animal> animales=new ArrayList<>();
    private double precioT, pesoT;
    private int[] tLista;

    public void newAnimal(){
        an = new Animal();
        an.Nuevo();
        animales.add(an);
        reset();
    }

    public void removeAnimal(String nombre){
        boolean encontrado=false;
        Iterator<Animal> iterator=animales.iterator();
        while(iterator.hasNext()){
            Animal a=iterator.next();
            if(a.AnName().equals(nombre)){
                iterator.remove();
                encontrado = true;
                break;
            }
        } 
        if(encontrado){
            System.out.printf("Animal eliminado correctamente del refugio.");
            reset();
        }
        else{
            System.out.printf("Animal no encontrado");
        }
    }

    public void modifyAnimal(String nombre){
        boolean encontrado=false;
        Iterator<Animal> iterator=animales.iterator();
        while(iterator.hasNext()){
            Animal a=iterator.next();
            if(a.AnName().equals(nombre)){
                a.Nuevo();
                encontrado = true;
                break;
            }
        } 
        if(encontrado){
            System.out.printf("Animal editado correctamente del refugio.");
            reset();
        }
        else{
            System.out.printf("Animal no encontrado");
        }
    }

    public ArrayList<Animal> getAnimales(){
        return this.animales;
    }

    public void reset(){
        this.tLista=new int[]{82,6,7,8,9};
        Iterator<Animal> iterator = animales.iterator();
        this.precioT=0;
        this.pesoT=0;
        while(iterator.hasNext()){
            Animal a=iterator.next();
            if(this.tLista[3]<a.AnCui()) this.tLista[3] = a.AnCui();
            if(this.tLista[1]<a.AnN()) this.tLista[1] = a.AnN();
            if(this.tLista[2]<a.AnE()) this.tLista[2] = a.AnE();
            if(this.tLista[4]<a.AnP()) this.tLista[4] = a.AnP();
            this.precioT+=a.AnConsumo()*App.precio;
            this.pesoT+=a.AnPeso();
        }
        this.tLista[0]=52+this.tLista[1]+this.tLista[2]+this.tLista[3]+this.tLista[4];
    }
        //this.precioT=0;
        //this.total=0;
        //this.pesoT=0;


    public int[] getTamañosLista(){
        return this.tLista;
    }

    public double getPrecioTotal(){
        return this.precioT;
    }

    public double getPesoMedio(){
        return this.pesoT/(this.animales.size());
    }
}
