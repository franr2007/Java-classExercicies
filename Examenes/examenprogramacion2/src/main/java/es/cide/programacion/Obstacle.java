package es.cide.programacion;

import java.util.Random;

public class Obstacle {
    //atributos
    private Random rm=new Random();
    private String[] arrayObstacles; //en este array guardo los tipos de obstaculo
    private String tipus;
    private int dificultad;

    //constructor
    public Obstacle(){
        arrayObstacles=new String[] {"Seto","Barra","Valla"}; //lo inicializo
        tipus=arrayObstacles[rm.nextInt(arrayObstacles.length-1)]; //aqui elije aleatoriamente el tipo de obstaculo
        dificultad=rm.nextInt(6)+1; //Y aqui su dificultad
    }

    //getters y setters
    public String getTipus(){
        return tipus;
    }

    public int getDificultad(){
        return dificultad;
    }
}
