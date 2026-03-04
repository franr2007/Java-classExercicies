package es.cide.programacion;

//41663903R
//Francisco Javier Rodriguez

public abstract class Personatge {//Clase padre de heroi y pirata
    protected String nom;
    protected int vida;

    public Personatge(String nom, int vida) {
        this.nom = nom;
        this.vida = vida;
    }

    public abstract boolean vida();
}
