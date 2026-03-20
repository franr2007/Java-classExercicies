package es.programacion.cide;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Botones extends JPanel {
    // atributos
    private GridBagConstraints g;
    private JButton botonCrear;
    private JButton botonAbrir;
    private JButton botonGuardar;
    private JButton botonGuardarComo;
    private int altoBtn;
    private int anchobtn;
    private Font fuente;

    // constructor
    public Botones() {
        setLayout(new GridBagLayout());

        altoBtn = 50;
        anchobtn = 180;

        g = new GridBagConstraints();
        g.insets = new Insets(5, 7, 5, 7);

        botonCrear = new JButton("NUEVO 📄");
        botonCrear.setPreferredSize(new Dimension(anchobtn, altoBtn));

        botonAbrir = new JButton("ABRIR 📂");
        botonAbrir.setPreferredSize(new Dimension(anchobtn, altoBtn));

        botonGuardar = new JButton("GUARDAR 💾");
        botonGuardar.setPreferredSize(new Dimension(anchobtn, altoBtn));

        botonGuardarComo = new JButton("GUARDAR COMO 💾+");
        botonGuardarComo.setPreferredSize(new Dimension(anchobtn, altoBtn));

        definirEstilos(fuente);

        g.gridx = 0;
        g.gridy = 0;
        add(botonCrear, g);
        g.gridx = 1;
        add(botonAbrir, g);
        g.gridx = 2;
        add(botonGuardar, g);
        g.gridx = 3;
        add(botonGuardarComo, g);
    }

    // getters y setters
    public int getAnchoBtn() {
        return anchobtn;
    }

    public int getAltoBtn() {
        return anchobtn;
    }

    // metodos
    public void definirEstilos(Font fuente) {
        fuente = new Font("MonoSpace", 0, 20);
        botonAbrir.setForeground(new Color(58, 110, 165));
        botonAbrir.setBackground(new Color(210, 225, 245));
        botonCrear.setForeground(new Color(58, 110, 165));
        botonCrear.setBackground(new Color(210, 225, 245));
        botonGuardar.setForeground(new Color(58, 110, 165));
        botonGuardar.setBackground(new Color(210, 225, 245));
        botonGuardarComo.setForeground(new Color(58, 110, 165));
        botonGuardarComo.setBackground(new Color(210, 225, 245));
    }
}
