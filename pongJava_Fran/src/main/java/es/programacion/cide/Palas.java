package es.programacion.cide;

import java.awt.*;

public class Palas {
    // atributos
    private int x, y;
    private int alto;
    private int ancho;
    private int velocidad;

    // constructor
    public Palas(int x, int y) {
        this.x = x;
        this.y = y;
        ancho = 20;
        alto = 60;
        velocidad = 5;
    }

    // getters y setters
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getAncho() {
        return ancho;
    }

    public int getAlto() {
        return alto;
    }

    // metodos
    public void moverArriba() {
        y -= velocidad;
    }

    public void moverAbajo() {
        y += velocidad;
    }

    protected void pintarPalas(Graphics2D g, Image img) {

        if (img != null) {
            g.drawImage(img, x, y, ancho, alto, null);
        } else {
            g.setColor(Color.BLACK);
            g.fillRect(x, y, ancho, alto);
        }
    }
}
