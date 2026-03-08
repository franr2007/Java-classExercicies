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
    public Palas(int x, int y, int ancho, int alto, VentanaPrincipal ventanaPrincipal) {
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.alto = alto;
        this.vp = ventanaPrincipal;
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
        if (y > 0) {
            y -= velocidad;
        } else {
            y = 0;
        }
    }

    public void moverAbajo() {
        if (y + alto < vp.getAltoVentana()) {
            y += velocidad;
        } else {
            y = vp.getAltoVentana() - alto;
        }
    }

    protected void pintarPalas(Graphics2D g, Color color) {
        g.setColor(new Color(color.getRed(), color.getGreen(), color.getBlue(), 255)); // Esta es la pala coloreada
                                                                                       // principal
        g.fillRoundRect(x, y, ancho, alto, 20, 20);// esto dibuja las palas con un borde redondo de 20px

        // las siguientes 2 hacen lo mismo pero con distinta opacidad, altura y anchura
        // para darle intensidad a las palas
        g.setColor(new Color(color.getRed(), color.getGreen(), color.getBlue(), 30));
        g.fillRoundRect(x - 6, y - 6, ancho + 12, alto + 12, 20, 20);

        g.setColor(new Color(color.getRed(), color.getGreen(), color.getBlue(), 60));
        g.fillRoundRect(x - 3, y - 3, ancho + 6, alto + 6, 20, 20);

    }
}
