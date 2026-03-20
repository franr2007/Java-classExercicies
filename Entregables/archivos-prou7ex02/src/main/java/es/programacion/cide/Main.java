package es.programacion.cide;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        // atributos
        JFrame ventana;
        Botones panelBotones;
        TextArea editorTxt;

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

        panelBotones = new Botones();
        panelBotones.setBackground(new Color(180, 205, 235));

        editorTxt = new TextArea();
        editorTxt.setBackground(new Color(240, 245, 252));
        editorTxt.setForeground(new Color(26, 46, 80));
        editorTxt.setFont(new Font("MonoSpace", 0, 18));

        ventana.add(panelBotones, BorderLayout.NORTH);
        ventana.add(editorTxt, BorderLayout.CENTER);

        ventana.setVisible(true);
    }

}