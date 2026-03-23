package es.programacion.cide;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        // atributos
        JFrame ventana;
        EditorTxt panelBotones;
        

        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }

        ventana = new JFrame("Editor de texto");
        ventana.setLayout(new BorderLayout());
        ventana.setSize(new Dimension(800, 700));
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLocationRelativeTo(null);
        ventana.setResizable(false);
        ;

        panelBotones = new EditorTxt();
        panelBotones.setBackground(new Color(180, 205, 235));

        ventana.add(panelBotones, BorderLayout.CENTER);

        ventana.setVisible(true);
    }

}