package es.cide.programacio.examen;

import java.awt.*;

import javax.swing.ImageIcon;

//Francisco Javier Rodriguez

class NauEspacial {
    private int x, y; // Posició de la nau espacial
    private final int ample = 40; // Ample de la nau espacial
    private final int alt = 40; // Alt de la nau espacial
    private ImageIcon imagenOriginal;
    private Image imgNauEspacial;

    public NauEspacial(int x, int y) {
        this.x = x;
        this.y = y;
        imagenOriginal = new ImageIcon(getClass().getResource("/mf.png"));// recoje la img de recursos
        imgNauEspacial = imagenOriginal.getImage();//Y aqui recoje la img para usarla
    }

    public void moureEsquerra() {
        x -= 7; // Mou la nau cap a l'esquerra
    }

    public void moureDreta() {
        x += 7; // Mou la nau cap a la dreta
    }

    public void moureAlt() {
        y -= 7; // Mou la nau cap a la dreta
    }

    public void moureBaix() {
        y += 7; // Mou la nau cap a la dreta
    }

    public void dibuixar(Graphics g) {
        g.setColor(Color.GREEN); // Color de la nau espacial
        g.drawImage(imgNauEspacial, x, y, ample, alt, null);//dibuja la nave con la img mf
        //g.fillRect(x, y, ample, alt); // Dibuixa la nau com un rectangle
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getAmple() {
        return ample;
    }

    public int getAlt() {
        return alt;
    }
}