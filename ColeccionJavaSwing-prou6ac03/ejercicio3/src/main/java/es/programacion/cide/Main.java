package es.programacion.cide;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//Francisco Javier Rodriguez

public class Main {
    public static void main(String[] args) {
        JFrame ventana = new JFrame();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLayout(new BorderLayout());
        ventana.setSize(800, 1080);

        JPanel panelColor = new JPanel();

        JPanel panelBotones = new JPanel();
        Dimension dimensionBotones=new Dimension(20,10);
        JButton botonRojo = new JButton("Rojo");
        botonRojo.setSize(dimensionBotones);
        botonRojo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelColor.setBackground(Color.red);
            }
        });
        JButton botonAzul = new JButton("Azul");
        botonAzul.setSize(dimensionBotones);
        botonAzul.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelColor.setBackground(Color.blue);
            }
        });
        JButton botonVerde = new JButton("Verde");
        botonVerde.setSize(dimensionBotones);
        botonVerde.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelColor.setBackground(Color.green);
            }
        });

        panelBotones.add(botonRojo);
        panelBotones.add(botonAzul);
        panelBotones.add(botonVerde);

        ventana.add(panelBotones,BorderLayout.NORTH);
        ventana.add(panelColor,BorderLayout.CENTER);

        ventana.setVisible(true);

    }
}