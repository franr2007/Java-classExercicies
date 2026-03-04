package es.cide.programacion;

import java.util.Random;

public class Obstacle {
    // atributos
    private Random aleatorio = new Random();
    private String tipus;
    private int dificultad;

    // constructor
    public Obstacle(String tipus) {
        this.tipus = tipus;
        this.dificultad = aleatorio.nextInt(10) + 1; // Aleatorio del 1-10
    }

    // getters y setters

    public String getTipus() {
        return tipus;
    }

    public int getDificultad() {
        return dificultad;
    }

    // Metodos

    public void informacion() { // Metodo que muestra informacion del tipo de obstaculo y su dificultad
        System.out.println("Tipo de obstaculo: " + tipus + " dificultad " + dificultad + "\n");
    }
}
