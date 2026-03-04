package es.programacion.cide;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//41663903R
//Francisco Javier Rodriguez
//16-02-26

public class PanelJuego extends JPanel implements ActionListener {
    // atributos
    private CirculoRebotante circulo;
    private Palas palaIzq;
    private Palas palaDer;
    private Image imgPalaIzq;
    private Image imgPalaDer;
    private Fondo fondo;
    private int x, y;
    private int dx, dy;
    private Timer timer;
    private final int DELAY = 10;
    private VentanaPrincipal vp;

    // constructor
    public PanelJuego(VentanaPrincipal vp) {
        setLayout(null);

        this.vp=vp;
        x = 750;
        y = 500;
        dx = 4;
        dy = 4;

        fondo = new Fondo(vp);

        circulo = new CirculoRebotante(x, y, dx, dy);
        timer = new Timer(DELAY, this);
        timer.start();

        palaIzq = new Palas(50, vp.getAltoVentana() / 2);
        palaDer = new Palas(vp.getAnchoVentana() - 50, vp.getAltoVentana() / 2);
    }

    // getters y setters

    // metodos
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        fondo.pintarFondo(g2d);

        circulo.pintarPelota(g2d);

        palaIzq.pintarPalas(g2d, imgPalaIzq);
        palaDer.pintarPalas(g2d, imgPalaDer);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        circulo.moverPelota(vp.getAnchoVentana(), vp.getAltoVentana());

        repaint();
    }

    
}
