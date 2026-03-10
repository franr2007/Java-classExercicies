package es.programacion.cide;

import java.awt.*;

public class CirculoRebotante {
    // atributos
    private int x, y;
    private int dx, dy;
    private final int RADI = 20;

    // constructor
    public CirculoRebotante(int x, int y, int dx, int dy) {
        this.x = x;
        this.y = y;
        this.dx = dx;
        this.dy = dy;
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
        return RADI*2;
    }

    public int getAlto() {
        return RADI*2;
    }

    public int getDX() {
        return dx;
    }

    public void setDX(int dx) {
        this.dx = dx;
    }

    public int getDY() {
        return dy;
    }

    public void setDY(int dy) {
        this.dy = dy;
    }
    // metodos

    //metodo para pintar la pelota
    protected void pintarPelota(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g.setColor(Color.white); //asigna el color a la pelota
        g2d.fillOval(x, y, RADI * 2, RADI * 2); // pinta un circulo
    }

    //metodo para mover la pelota
    public void moverPelota(int ancho, int alto) {
        if (x + 2 * RADI >= ancho || x <= 0) { //si la pelota toca el borde horizontal de la pantalla cambia la direccion
            dx = -dx;
        }

        if (y + 2 * RADI >= alto || y <= 0) { //si la pelota toca el borde vertical de la pantalla cambia la direccion
            dy = -dy;
        }

        //si no sigue 
        x += dx;
        y += dy;
    }

}
