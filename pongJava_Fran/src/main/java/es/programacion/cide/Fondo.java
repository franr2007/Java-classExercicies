package es.programacion.cide;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Fondo{
    //Atributos
    private ImageIcon imagenFondOriginal;
    private Image imgFondo;
    private VentanaPrincipal vp;

    //constructor
    Fondo(VentanaPrincipal vp){
        this.vp=vp;
        imagenFondOriginal= new ImageIcon(getClass().getResource("/fondo.png"));
        imgFondo= imagenFondOriginal.getImage();
    }
    //getters y setters

    //metodos

    protected void pintarFondo(Graphics2D g){
        if (imgFondo != null) {
            g.drawImage(imgFondo,0, 0, vp.getAnchoVentana(), vp.getAltoVentana(), null);
        } else {
            g.setColor(Color.BLUE);
            System.out.println("La imagen del fondo no se encuentra");
        }
    }
}
