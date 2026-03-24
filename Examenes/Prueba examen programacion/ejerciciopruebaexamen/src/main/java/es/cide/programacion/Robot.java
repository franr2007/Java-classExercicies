package es.cide.programacion;

//Francisco Javier Rodriguez

public class Robot {
    // Atributos
    private String nom;
    private int energia;
    private int força;

    // Constructor
    public Robot(String nom, int energia, int força) {
        this.nom = nom;
        this.energia = energia;
        this.força = força;
    }

    // Getters y setters
    public String getNom() {
        return nom;
    }

    public int getEenergia() {
        return energia;
    }

    public int getForça() {
        return força;
    }

    // Metodos

    public boolean superarObstaculo(Obstacle o) { // Metodo que coje una variable tipo objeto
        energia -= o.getDificultad() * 2; // Le resta a energia un *2 de la dificultad

        if (energia > 0) {// devuelve true o false dependiendo de la energia
            return true;
        } else {
            return false;
        }
    }
}
