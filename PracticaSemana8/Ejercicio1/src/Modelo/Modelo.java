package Modelo;
import Modelo.Partido;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Modelo {

    private ArrayList<Partido> partidos= new ArrayList<>();
    private ArrayList<String> equipos = new ArrayList<>(Arrays.asList(
            "Real Sociedad",
            "Real Madrid",
            "Cádiz CF",
            "Athletic Club",
            "Málaga CF",
            "FC Barcelona",
            "Getafe CF",
            "Sporting de Gijón",
            "Atlético de Madrid",
            "Girona FC",
            "Sevilla FC",
            "Deportivo de La Coruña",
            "Valencia CF",
            "Granada CF",
            "Villarreal CF",
            "RCD Mallorca",
            "Racing de Santander",
            "Real Betis",
            "CD Tenerife",
            "Celta de Vigo",
            "Levante UD",
            "Osasuna",
            "Real Valladolid",
            "Rayo Vallecano",
            "Elche CF",
            "UD Almería",
            "Espanyol",
            "Deportivo Alavés",
            "UD Las Palmas",
            "Real Oviedo"
        ));



    public void setEquipos(){
        for(int i=0;i<30;i++){
            partidos.add(new Partido(equipos.get(i), equipos.get(i+1)));
        }
    }

    public ArrayList<String>     getEquipos(){
        return equipos;
    }
}
