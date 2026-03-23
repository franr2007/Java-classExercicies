package es.programacion.cide;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.TextArea;
import java.io.IOException;
import java.nio.file.Files;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;

public class EditorTxt extends JPanel {
    // atributos
    private GridBagConstraints g;
    private JButton botonCrear;
    private JButton botonAbrir;
    private JButton botonGuardar;
    private JButton botonGuardarComo;
    private int altoBtn;
    private int anchobtn;
    private Font fuente;
    private TextArea area;
    private JPanel panelBotones;

    // constructor
    public EditorTxt() {
        setLayout(new BorderLayout());

        panelBotones = new JPanel();
        panelBotones.setLayout(new GridBagLayout());

        altoBtn = 50;
        anchobtn = 180;

        g = new GridBagConstraints();
        g.insets = new Insets(5, 7, 5, 7);

        botonCrear = new JButton("NUEVO 📄");
        botonCrear.setPreferredSize(new Dimension(anchobtn, altoBtn));
        botonCrear.addActionListener(e -> nuevo());

        botonAbrir = new JButton("ABRIR 📂");
        botonAbrir.setPreferredSize(new Dimension(anchobtn, altoBtn));
        botonAbrir.addActionListener(e -> abrir());

        botonGuardar = new JButton("GUARDAR 💾");
        botonGuardar.setPreferredSize(new Dimension(anchobtn, altoBtn));

        botonGuardarComo = new JButton("GUARDAR COMO 💾+");
        botonGuardarComo.setPreferredSize(new Dimension(anchobtn, altoBtn));

        area = new TextArea();

        definirEstilos(fuente);

        g.gridx = 0;
        g.gridy = 0;
        panelBotones.add(botonCrear, g);
        g.gridx = 1;
        panelBotones.add(botonAbrir, g);
        g.gridx = 2;
        panelBotones.add(botonGuardar, g);
        g.gridx = 3;
        panelBotones.add(botonGuardarComo, g);

        add(panelBotones, BorderLayout.NORTH);
        add(area, BorderLayout.CENTER);
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
        panelBotones.setBackground(new Color(210, 225, 245));
        area.setBackground(new Color(240, 245, 252));
        area.setForeground(new Color(26, 46, 80));
        area.setFont(new Font("MonoSpace", 0, 18));
    }

    public void nuevo() {
        area.setText("");
    }

    public void abrir() {
        JFileChooser selector = new JFileChooser(); //abre el explorador de archivos
        if (selector.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) { //mira si se ha elegido algun archivo
            try {
                String contenido = Files.readString(selector.getSelectedFile().toPath());//esto coje el contenido del texto
                area.setText(contenido);//mete el contenido anterior en el area
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void guardar() {

    }

    public void guardarComo() {

    }

}
