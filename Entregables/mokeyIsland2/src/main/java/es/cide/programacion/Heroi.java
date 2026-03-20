package es.cide.programacion;

import java.util.Scanner;

//41663903R
//Francisco Javier Rodriguez

public abstract class Heroi extends Personatge implements Fight, Speak { //Clase padre de Guybrush y elaine
    // atributos
    protected Scanner sc = new Scanner(System.in);
    protected String respuestas[];

    // Constructor
    public Heroi(String nom, int vida, String respuestas[]) {
        super(nom, vida);
        this.respuestas = respuestas;
    }

    // Getters y setters
    public int getVida() {
        return vida;
    };

    public int getResponder() {
        return 0;
    }

    public String getNomHeroi() {
        return nom;
    }

    public String[] getListaNueva() {
        return respuestas;
    }

    // metodos
    @Override
    public void insultar() {
    };

    @Override
    public void defensar() {
    };

    @Override
    public void sayHello() {
    };

    @Override
    public void sayGoodBye() {
    };
}
