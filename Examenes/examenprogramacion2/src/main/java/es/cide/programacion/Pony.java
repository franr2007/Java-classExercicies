package es.cide.programacion;

import java.util.Random;

public class Pony {
    // atributos
    private Random rm = new Random();
    private String nom;
    private int energia;
    private int força;

    // constructor
    public Pony(String nom, int energia) { // Aqui inicializo las variables
        this.nom = nom;
        this.energia = energia;
        this.força = rm.nextInt(4) + 1; // elije la fuerza entre 1-5
    }

    // getters y setters

    public String getNom() {
        return nom;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }

    public int getEnergia() {
        return energia;
    }

    public int getForça() {
        return força;
    }

    // Metodos
    public boolean superarObstacle(Obstacle o) { // Metodo para que el pony salte los obstaculos
        if (força >= o.getDificultad()) { // si la fuerza es > o = que la dificultad de el objeto hara lo siguiente
            if (energia > 0) { // si la energia del pony es > que 0
                energia -= o.getDificultad() / 2; // Se le resta a energia la mitad de la dificultad
                return true; // Y devuelve true, diciendo que el pony tiene energia aun
            } else {// Si la energia del pony es 0 o <
                return false; // Devuelve falso
            }
        } else { // Si la fuerza es < que la dificultad fallará
            return false;
        }
    }
}
