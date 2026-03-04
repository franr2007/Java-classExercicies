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

    // constructor
    public PanelInicio(VentanaPrincipal ventanaPrincipal) {
        setLayout(new GridBagLayout());
        setSize(600, 800);

        GridBagConstraints g = new GridBagConstraints();

        JPanel panelJugadores = new JPanel();
        panelJugadores.setSize(400, 600);
        panelJugadores.setLayout(new GridBagLayout());

        Border borde = BorderFactory.createLineBorder(Color.black, 2);
        g.insets = new Insets(200, 0, 0, 0);
        g.fill = GridBagConstraints.HORIZONTAL;

        GridBagConstraints gj = new GridBagConstraints();
        gj.insets = new Insets(20, 0, 0, 100);

        JLabel textoJugador1 = new JLabel("Jugador1");
        textoJugador1.setBorder(borde);
        JTextField fieldJugador1 = new JTextField(40);
        nombreJugador1 = fieldJugador1.getText();

        JLabel textoJugador2 = new JLabel("Jugador2");
        textoJugador2.setBorder(borde);
        JTextField fieldJugador2 = new JTextField(40);
        nombreJugador2 = fieldJugador2.getText();

        JButton btnComenzar = new JButton("Comenzar");
        btnComenzar.setPreferredSize(new Dimension(400, 80));
        btnComenzar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaPrincipal.cambiarPanel(new PanelJuego(ventanaPrincipal));
            }
        });

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
        add(panelJugadores, g);
        g.gridx = 0;
        g.gridy = 1;
        add(btnComenzar, g);
    }

    // getters y setters
    public String getNombreJugador1() {
        return nombreJugador1;
    }

    public String getNombreJugador2() {
        return nombreJugador2;
    }
    // metodos
}
