package es.programacion.cide;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        //atributos
        JFrame ventana;
        JPanel panelGeneral;
        GridBagConstraints g;
        JButton botonCrear;
        JButton botonAbrir;
        JButton botonGuardar;
        JButton botonGuardarComo;
        int altoBtn;
        int anchobtn;

        ventana=new JFrame("Editor de texto");
        ventana.setLayout(new BorderLayout());
        ventana.setExtendedState(JFrame.MAXIMIZED_BOTH);

        panelGeneral=new JPanel();
        panelGeneral.setLayout(new GridBagLayout());

        altoBtn=100;
        anchobtn=500;

        g=new GridBagConstraints();
        g.insets=new Insets(25,25, 25, 25);

        botonCrear=new JButton("Nuevo");
        botonCrear.setPreferredSize(new Dimension(anchobtn,altoBtn));

        botonAbrir=new JButton("Abrir");
        botonAbrir.setPreferredSize(new Dimension(anchobtn,altoBtn));

        botonGuardar=new JButton("Guardar");
        botonGuardar.setPreferredSize(new Dimension(anchobtn,altoBtn));

        botonGuardarComo=new JButton("Guardar como");
        botonGuardarComo.setPreferredSize(new Dimension(anchobtn,altoBtn));

        g.gridx=0;
        g.gridy=0;
        panelGeneral.add(botonCrear,g);
        g.gridx=1;
        g.gridy=0;
        panelGeneral.add(botonAbrir,g);
        g.gridx=0;
        g.gridy=1;
        panelGeneral.add(botonGuardar,g);
        g.gridx=1;
        g.gridy=1;
        panelGeneral.add(botonGuardarComo,g);
        
        ventana.add(panelGeneral, BorderLayout.CENTER);

        ventana.setVisible(true);
    }
}