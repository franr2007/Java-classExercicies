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

public class PanelJuego extends JPanel implements ActionListener,KeyListener {
    // atributos
    private CirculoRebotante circulo;
    private Palas palaIzq;
    private Palas palaDer;
    private ImageIcon imgPalaIzqOriginal;
    private Image imgPalaIzq;
    private ImageIcon imgPalaDerOriginal;
    private Image imgPalaDer;
    private Fondo fondo;
    private int x, y;
    private int dx, dy;
    private Timer timer;
    private final int DELAY = 10;
    private VentanaPrincipal vp;
    private final int anchoPala = 150;
    private final int altoPala = 250;
    private boolean usandoW;
    private boolean usandoS;
    private boolean usandoArriba;
    private boolean usandoAbajo;

    // constructor
    public PanelJuego(VentanaPrincipal ventanaPrincipal) {
        setLayout(null);
        setFocusable(true);
        addKeyListener(this); 

        usandoAbajo=false;
        usandoArriba=false;
        usandoS=false;
        usandoW=false;

        this.vp=ventanaPrincipal;
        x = 750;
        y = 500;
        dx = 4;
        dy = 4;

        imgPalaDerOriginal= new ImageIcon(getClass().getResource("/imgPalaDer.png"));
        imgPalaDer= imgPalaDerOriginal.getImage();

        imgPalaIzqOriginal= new ImageIcon(getClass().getResource("/imgPalaIzq.png"));
        imgPalaIzq= imgPalaIzqOriginal.getImage();

        fondo = new Fondo(vp);

        circulo = new CirculoRebotante(x, y, dx, dy);
        timer = new Timer(DELAY, this);
        timer.start();

        palaIzq = new Palas(20, vp.getAltoVentana() / 2,anchoPala,altoPala,vp);
        palaDer = new Palas(vp.getAnchoVentana() - anchoPala, vp.getAltoVentana() / 2,anchoPala,altoPala,vp);
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

        circulo.moverPelota(vp.getAnchoVentana(), vp.getAltoVentana());

        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                usandoW=true;
                break;
            case KeyEvent.VK_S:
                usandoS=true;
                break;
            case KeyEvent.VK_UP:
                usandoArriba=true;
                break;
            case KeyEvent.VK_DOWN:
                usandoAbajo=true;
                break;
        
            default:
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                usandoW=false;
                break;
            case KeyEvent.VK_S:
                usandoS=false;
                break;
            case KeyEvent.VK_UP:
                usandoArriba=false;
                break;
            case KeyEvent.VK_DOWN:
                usandoAbajo=false;
                break;
        
            default:
                break;
        }
    }

    public void keyTyped(KeyEvent e) {}//no lo utilizo, pero necesita ser implementado
    
}
