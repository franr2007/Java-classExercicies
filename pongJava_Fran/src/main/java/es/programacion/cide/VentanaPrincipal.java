package es.programacion.cide;

import javax.swing.*;
import java.awt.*;

//41663903R
//Francisco Javier Rodriguez
//16-02-26

public class VentanaPrincipal extends JFrame {
    // Atributos
    private JPanel contenedorPaneles;
    private PanelInicio panelInicio;
    private GraphicsDevice gd;
    private Rectangle r;
    private int ancho;
    private int alto;

    // constructor
    public VentanaPrincipal() {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel"); // Look and feel Nimbus
        } catch (Exception e) {
        }

        //variable para recojer la panalla completa de la pantalla
        gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        r= gd.getDefaultConfiguration().getBounds();
        ancho= r.width;
        alto= r.height;

        // Parametros ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setSize(800, 400);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH); //Ventana Maximizada

        contenedorPaneles = new JPanel(new CardLayout()); // Contenedor de paneles tipo layout

        panelInicio = new PanelInicio(this); // Menu principal y le añado esta ventana, para luego pasarle el metodo
        contenedorPaneles.add(panelInicio);// se proyecta el panel anterior

        add(contenedorPaneles, BorderLayout.CENTER);// Se añade el contenedor de paneles a la ventana y lo proyecta
    }
    // getters y setters
    public Rectangle getTamañoVentana(){
        return r;
    }

    public int getAnchoVentana(){
        return ancho;
    }

    public int getAltoVentana(){
        return alto;
    }

    // metodos
    protected void cambiarPanel(JPanel panelActual) { // Metodo para cambiar de panel
        contenedorPaneles.removeAll(); // Quita cualquier panel que hubiera en el contenedor
        contenedorPaneles.add(panelActual); // añade el nuevo panel
        contenedorPaneles.revalidate(); // Revalida el panel (adapta el layout al nuevo panel)
        contenedorPaneles.repaint(); // Redibuja el panel para mostrarlo
    }
}
