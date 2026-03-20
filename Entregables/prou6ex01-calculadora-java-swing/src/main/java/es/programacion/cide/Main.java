package es.programacion.cide;

import java.awt.*;
import javax.swing.*;

//41663903R
//Francisco Javier Rodriguez Magaña
//04-02-2026

public class Main {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel"); //look and feel
        } catch (Exception e){};

        JFrame ventana=new JFrame(); 
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //se cierra el programa al cerrar la ventana
        ventana.setSize(400, 400);
        ventana.setLayout(new GridLayout(1,1));
        ventana.setLocationRelativeTo(null); //se pone en el centro

        CalculadoraVisual panelCalculadora=new CalculadoraVisual(); //añado la calculadora
        panelCalculadora.setSize(ventana.getSize());

        ventana.add(panelCalculadora);

        ventana.setVisible(true);
    }
}