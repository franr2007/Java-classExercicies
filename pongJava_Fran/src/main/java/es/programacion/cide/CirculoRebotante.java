package es.programacion.cide;

import java.awt.*;
import javax.swing.ImageIcon;

public class CirculoRebotante {
    // atributos
    private int x, y;
    private int dx, dy;
    private final int RADI = 50;
    private ImageIcon imgPelotaOriginal;
    private Image imgPelota;

    // constructor
    public CirculoRebotante(int x, int y, int dx, int dy) {
        this.x = x;
        this.y = y;
        this.dx = dx;
        this.dy = dy;
        imgPelotaOriginal = new ImageIcon(getClass().getResource("/pelota_voley.jpg"));
        imgPelota = imgPelotaOriginal.getImage();
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
    protected void pintarPelota(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(imgPelota, x, y, RADI * 2, RADI * 2, null);
    }

    public void moverPelota(int ancho, int alto) {
        if (x + 2 * RADI >= ancho || x <= 0) {
            dx = -dx;
        }

        if (y + 2 * RADI >= alto || y <= 0) {
            dy = -dy;
        }

        x += dx;
        y += dy;
    }

}
