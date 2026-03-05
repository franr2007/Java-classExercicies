package es.programacion.cide;

import java.awt.*;

public class Palas {
    // atributos
    private int x, y;
    private int alto;
    private int ancho;
    private int velocidad;
    private VentanaPrincipal vp;

    // constructor
    public Palas(int x, int y, int ancho,int alto, VentanaPrincipal ventanaPrincipal) {
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.alto = alto;
        this.vp=ventanaPrincipal;
        velocidad = 10;
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
        if (y >0) {
            y -= velocidad;
        }
        else{y=0;}
    }

    public void moverAbajo() {
        if (y+alto <vp.getAltoVentana()) {
            y += velocidad;
        }
        else{y=vp.getAltoVentana()-alto;}
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
