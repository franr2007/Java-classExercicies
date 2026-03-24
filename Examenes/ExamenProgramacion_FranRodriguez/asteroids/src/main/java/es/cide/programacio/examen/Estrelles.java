package es.cide.programacio.examen;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

//Francisco Javier Rodriguez

public class Estrelles {
    private int x, y; // Posició de l'estrella
    private final int ancho = 2; // Radi de l'estrella
    private final int alto = 20; // Radi de l'estrella
    private final int velocitat = 30; // Velocitat de l'estrella

    public Estrelles(int amplePanell) {
        Random aleatori = new Random();
        x = aleatori.nextInt(amplePanell - ancho) + ancho; // Posició x aleatòria (estrella)
        y = 0; // Comença a la part superior del panell
    }

    public void moure() {
        y += velocitat; // Mou l'estrella cap avall
    }

    public void dibuixar(Graphics g) {
        g.setColor(Color.white); //color de l'estrella
        
        g.fillRect(x-ancho, y-alto, ancho, alto);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getAncho() {
        return ancho;
    }

    public int getAlto() {
        return alto;
    }
}
