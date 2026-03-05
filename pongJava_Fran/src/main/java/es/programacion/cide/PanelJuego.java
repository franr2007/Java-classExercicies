package es.programacion.cide;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//41663903R
//Francisco Javier Rodriguez
//16-02-26

public class PanelJuego extends JPanel implements ActionListener, KeyListener {
    // atributos
    private CirculoRebotante pelota;
    private Palas palaIzq;
    private Palas palaDer;
    private ImageIcon imgPalaIzqOriginal;
    private Image imgPalaIzq;
    private ImageIcon imgPalaDerOriginal;
    private Image imgPalaDer;
    private Fondo fondo;
    private final int x, y; // variables de pelota
    private final int dx, dy; // variables de pelota
    private Timer timer;
    private final int DELAY = 10;
    private VentanaPrincipal vp;
    private final int anchoPala = 150;
    private final int altoPala = 250;
    private boolean usandoW;
    private boolean usandoS;
    private boolean usandoArriba;
    private boolean usandoAbajo;
    private int nuevaVelocidadX;
    private int nuevaVelocidadY;

    // constructor
    public PanelJuego(VentanaPrincipal ventanaPrincipal) {
        setLayout(null);
        setFocusable(true);
        addKeyListener(this);

        usandoAbajo = false;
        usandoArriba = false;
        usandoS = false;
        usandoW = false;

        this.vp = ventanaPrincipal;
        x = vp.getAnchoVentana()/2;
        y = vp.getAltoVentana()/2;
        dx = 6;
        dy = 6;

        imgPalaDerOriginal = new ImageIcon(getClass().getResource("/imgPalaDer.png"));
        imgPalaDer = imgPalaDerOriginal.getImage();

        imgPalaIzqOriginal = new ImageIcon(getClass().getResource("/imgPalaIzq.png"));
        imgPalaIzq = imgPalaIzqOriginal.getImage();

        fondo = new Fondo(vp);

        pelota = new CirculoRebotante(x, y, dx, dy);
        timer = new Timer(DELAY, this);
        timer.start();

        palaIzq = new Palas(20, vp.getAltoVentana() / 2, anchoPala, altoPala, vp);
        palaDer = new Palas(vp.getAnchoVentana() - anchoPala, vp.getAltoVentana() / 2, anchoPala, altoPala, vp);
    }

    // getters y setters

    // metodos
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        fondo.pintarFondo(g2d);

        pelota.pintarPelota(g2d);

        palaIzq.pintarPalas(g2d, imgPalaIzq);
        palaDer.pintarPalas(g2d, imgPalaDer);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (usandoW) {
            palaIzq.moverArriba();
        }
        if (usandoS) {
            palaIzq.moverAbajo();
        }
        if (usandoArriba) {
            palaDer.moverArriba();
        }
        if (usandoAbajo) {
            palaDer.moverAbajo();
        }

        pelota.moverPelota(vp.getAnchoVentana(), vp.getAltoVentana());

        comprobarChoque();

        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                usandoW = true;
                break;
            case KeyEvent.VK_S:
                usandoS = true;
                break;
            case KeyEvent.VK_UP:
                usandoArriba = true;
                break;
            case KeyEvent.VK_DOWN:
                usandoAbajo = true;
                break;

            default:
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                usandoW = false;
                break;
            case KeyEvent.VK_S:
                usandoS = false;
                break;
            case KeyEvent.VK_UP:
                usandoArriba = false;
                break;
            case KeyEvent.VK_DOWN:
                usandoAbajo = false;
                break;

            default:
                break;
        }
    }

    public void keyTyped(KeyEvent e) {
    }// no lo utilizo, pero necesita ser implementado

    protected void comprobarChoque() {
        if (pelota.getX() < palaIzq.getX() + palaIzq.getAncho() &&
                pelota.getX() + pelota.getAncho() > palaIzq.getX() &&
                pelota.getY() < palaIzq.getY() + palaIzq.getAlto() &&
                pelota.getY() + pelota.getAlto() > palaIzq.getY()) {

            nuevaVelocidadX = pelota.getDX();

            if (nuevaVelocidadX < 0) {
                nuevaVelocidadX = nuevaVelocidadX * -1;
            }

            cambioVY();

            pelota.setDY(nuevaVelocidadY);
            pelota.setDX(nuevaVelocidadX+1); // esto hace que la pelota rebote
            pelota.setX(palaIzq.getX() + palaIzq.getAncho() + 1); // esto hace que la pelota no se quede pegada en la
                                                                  // pala
        }

        if (pelota.getX() < palaDer.getX() + palaDer.getAncho() &&
                pelota.getX() + pelota.getAncho() > palaDer.getX() &&
                pelota.getY() < palaDer.getY() + palaDer.getAlto() &&
                pelota.getY() + pelota.getAlto() > palaDer.getY()) {

            nuevaVelocidadX = pelota.getDX();

            if (nuevaVelocidadX > 0) {
                nuevaVelocidadX = nuevaVelocidadX * -1;
            }

            cambioVY();

            pelota.setDY(nuevaVelocidadY);
            pelota.setDX(nuevaVelocidadX-1); // esto hace que la pelota rebote
            pelota.setX(palaDer.getX() - pelota.getAncho() - 1); // esto hace que la pelota no se quede pegada en la
                                                                 // pala
        }
    }

    protected void cambioVY() {
        nuevaVelocidadY = pelota.getDY();

        if (nuevaVelocidadY < 0) {
                pelota.setDY(nuevaVelocidadY - 1);
        } else if (nuevaVelocidadY > 0) {
                pelota.setDY(nuevaVelocidadY + 1);
        }
    }
}
