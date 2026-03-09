package es.programacion.cide;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//41663903R
//Francisco Javier Rodriguez
//16-02-26

public class PanelInicio extends JPanel {
    // Atributos
    private String nombreJugador1;
    private String nombreJugador2;
    private GridBagConstraints g;
    private JPanel panelTitulo;
    private JPanel panelJugadores;
    private Border borde;
    private GridBagConstraints gj;
    private Font fuenteTitulo;
    private Font fuenteTxt;
    private JLabel titulo;
    private JLabel textoJugador1;
    private JTextField fieldJugador1;
    private JLabel textoJugador2;
    private JTextField fieldJugador2;
    private JButton btnComenzar;
    private JButton btnInstrucciones;
    private JButton[] arrayButtons;

    // constructor
    public PanelInicio(VentanaPrincipal ventanaPrincipal) {
        setLayout(new GridBagLayout());
        setSize(600, 800);

        g = new GridBagConstraints();
        g.insets = new Insets(0, 0, 0, 20);
        g.fill = GridBagConstraints.HORIZONTAL;

        panelTitulo = new JPanel();
        panelTitulo.setSize(400, 200);

        panelJugadores = new JPanel();
        panelJugadores.setSize(400, 600);
        panelJugadores.setLayout(new GridBagLayout());

        borde = BorderFactory.createLineBorder(Color.black, 2);

        gj = new GridBagConstraints();
        gj.insets = new Insets(100, 0, 100, 100);

        fuenteTitulo = new Font("Comic Sans", 40, 1);

        fuenteTxt = new Font("Comic Sans", 20, 0);

        titulo = new JLabel("PONG!");

        textoJugador1 = new JLabel("Jugador1");
        textoJugador1.setBorder(borde);
        fieldJugador1 = new JTextField(40);

        textoJugador2 = new JLabel("Jugador2");
        textoJugador2.setBorder(borde);
        fieldJugador2 = new JTextField(40);

        btnComenzar = new JButton("Comenzar");
        btnComenzar.setPreferredSize(new Dimension(450,60));
        btnComenzar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nombreJugador2 = fieldJugador2.getText();
                nombreJugador1 = fieldJugador1.getText();
                PanelJuego panelJuego = new PanelJuego(ventanaPrincipal, PanelInicio.this);
                ventanaPrincipal.cambiarPanel(panelJuego);
                panelJuego.requestFocus();
            }
        });

        btnInstrucciones = new JButton("Instrucciones");
        btnInstrucciones.setPreferredSize(new Dimension(0,60));
        btnInstrucciones.addActionListener(e -> new VentanaInstrucciones());

        //añadir al panel
        panelTitulo.add(titulo);

        gj.gridx = 0;
        gj.gridy = 0;
        panelJugadores.add(textoJugador1, gj);
        gj.gridx = 1;
        gj.gridy = 0;
        panelJugadores.add(fieldJugador1, gj);
        gj.gridx = 0;
        gj.gridy = 1;
        panelJugadores.add(textoJugador2, gj);
        gj.gridx = 1;
        gj.gridy = 1;
        panelJugadores.add(fieldJugador2, gj);

        g.gridx = 0;
        g.gridy = 0;
        g.gridwidth=2;
        add(panelTitulo, g);
        g.gridx = 0;
        g.gridy = 1;
        g.gridwidth=2;
        add(panelJugadores, g);
        g.gridwidth=1;
        g.gridx = 0;
        g.gridy = 2;
        add(btnComenzar, g);
        g.gridx = 1;
        g.gridy = 2;
        add(btnInstrucciones, g);
    }

    // getters y setters
    public String getNombreJugador1() {
        return nombreJugador1;
    }

    public String getNombreJugador2() {
        return nombreJugador2;
    }

    // metodos
    protected void definirEstilos() {

    }
}
