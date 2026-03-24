package es.cide.programacio.examen;

import java.awt.*;
import java.util.Random;

import javax.swing.ImageIcon;

//Francisco Javier Rodriguez

class Asteroide {
    private int x, y; // Posició de l'asteroide
    private int radi = 20; // Radi de l'asteroide
    private int velocitat; // Velocitat de l'asteroide
    private ImageIcon imagenOriginal;
    private Image imgAsteroide;

    public Asteroide(int amplePanell, int numAleatorio) {
        Random aleatori = new Random();
        x = aleatori.nextInt(amplePanell - radi * 2) + radi; // Posició x aleatòria (asteroide)
        y = 0; // Comença a la part superior del panell
        velocitat = aleatori.nextInt(5) + 2; // Velocitat aleatòria entre 1 i 3

        imagenOriginal = new ImageIcon(getClass().getResource("/tie.png")); // recoje la img de recursos
        imgAsteroide= imagenOriginal.getImage(); //Y aqui recoje la img para usarla

        //Dependiendo del numero aleatorio 0,1 o 2 cambia el radio, es decir el tamaño
        if (numAleatorio==2) {
            radi=30;
        }
        else if (numAleatorio==1) {
            radi=25;
        }
        else{
            radi=20;
        }
    }

    public void moure() {
        y += velocitat; // Mou l'asteroide cap avall
    }

    public void dibuixar(Graphics g) {
        g.setColor(Color.RED); // Color de l'asteroide
        g.drawImage(imgAsteroide,x - radi, y - radi, 2 * radi, 2 * radi,null); //dibuja el asteroide con la img tie
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getRadi() {
        return radi;
    }
}
