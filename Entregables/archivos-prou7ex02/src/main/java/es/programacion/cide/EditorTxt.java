package es.programacion.cide;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.TextArea;
import java.io.File;
import java.io.FileWriter;
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
    private JFileChooser selector;
    private File archivoActual;

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
        botonGuardar.addActionListener(e -> guardar());

        botonGuardarComo = new JButton("GUARDAR COMO 💾+");
        botonGuardarComo.setPreferredSize(new Dimension(anchobtn, altoBtn));
        botonGuardarComo.addActionListener(e -> guardarComo());

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
        area.setText("");// limpia el txt
        archivoActual = null;// no hay ningun archivo seleccionado
    }

    public void abrir() {
        selector = new JFileChooser(); // Crea la var para explorador de archvos
        // showOpenDialog abre el win explorer y devuelve un valor segun la eleccion del
        // usuario
        if (selector.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) { // y si a seleccionado un archivo entonces
                                                                            // hace lo siguiente:
            try {
                archivoActual = selector.getSelectedFile();
                String contenido = Files.readString(selector.getSelectedFile().toPath());// esto coje el contenido del
                                                                                         // texto
                area.setText(contenido);// mete el contenido anterior en el area
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void guardar() {
        if (archivoActual != null) {// Si ya se ha abierto un archivo, hace la funcion de guardar
            try {
                FileWriter escribirArchivo = new FileWriter(selector.getSelectedFile());// creo esta var, que coje el
                                                                                        // archivo y lo abre
                escribirArchivo.write(area.getText());// aqui escribre en el archivo lo que hay en el txtarea
                escribirArchivo.close();// cierra el archivo
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else { // si no llama a la funcion guardar como
            guardarComo();
        }
    }

    public void guardarComo() {
        selector = new JFileChooser();
        if (selector.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) { // abre el win explorer pero con la opcion
                                                                            // de guardar el archivo
            archivoActual = selector.getSelectedFile(); // coge el archivo seleccionado
            if (!archivoActual.getName().endsWith(".txt")) {// si el archivo no tiene .txt
                archivoActual = new File(archivoActual.getAbsolutePath() + ".txt");// se le añade .txt al final del
                                                                                   // nombre dado
            }
            try {
                // guarda lo que haya en el txtarea el archivo
                FileWriter escribirArchivo = new FileWriter(archivoActual);
                escribirArchivo.write(area.getText());
                escribirArchivo.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
