package es.programacion.cide;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // atributos
        JPanel panelFicheros;
        GridBagConstraints g;

        JPanel R1;
        JTextField entradaR1;
        JButton btnAnalizar;
        JLabel textoR1;

        JPanel R2;
        JTextField entradaR2;
        JButton btnGurdar;
        JLabel textoR2;

        JPanel panelVisualizador;
        JLabel textoVisualizador;
        JTextArea areaVisualizador;
        JScrollPane visualizador;

        JFrame ventana = new JFrame();
        ventana.setSize(800, 600);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLayout(new GridLayout(2, 1));

        // Panel visualizador
        panelVisualizador = new JPanel();
        panelVisualizador.setLayout(new GridBagLayout());
        textoVisualizador = new JLabel("Visualizador");
        areaVisualizador = new JTextArea(10, 40);
        visualizador = new JScrollPane(areaVisualizador);

        g = new GridBagConstraints();

        g.gridx = 0;
        g.gridy = 0;
        panelVisualizador.add(textoVisualizador, g);
        g.gridy = 1;
        panelVisualizador.add(visualizador, g);

        // panel 1
        R1 = new JPanel();
        R1.setLayout(new GridBagLayout());

        textoR1 = new JLabel("Camí d'origen");
        entradaR1 = new JTextField();
        entradaR1.setColumns(20);
        btnAnalizar = new JButton("Analitzar");
        btnAnalizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                try {
                    File ruta = new File(entradaR1.getText());

                    FileInputStream archivo = new FileInputStream(ruta);

                    byte[] bytes = archivo.readAllBytes(); // lee todos los bytes del archivo de golpe

                    String contenido = new String(bytes); // convierte los bytes a texto legible
                    String[] linias = contenido.split("\n"); // separa el texto en líneas, cada una es una contraseña

                    for (String linia : linias) { // recorre cada contraseña
                        if (esSegura(linia)) { // comprueba si cumple los requisitos
                            areaVisualizador.setText(linia + " (es segura)"); // si es segura, la añade al área de
                                                                              // seguras
                        } else {
                            areaVisualizador.setText(linia + " (no es segura)"); // si no, al área de no seguras
                        }
                    }

                    archivo.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });

        g.gridx = 0;
        g.gridy = 0;
        R1.add(textoR1, g);

        g.gridy = 1;
        R1.add(entradaR1, g);

        g.gridx = 1;
        R1.add(btnAnalizar, g);

        // panel 2
        R2 = new JPanel();
        R2.setLayout(new GridBagLayout());

        textoR2 = new JLabel("Camí d'origen");
        entradaR2 = new JTextField();
        entradaR2.setColumns(20);
        btnGurdar = new JButton("Desar");

        g.gridx = 0;
        g.gridy = 0;
        R2.add(textoR2, g);

        g.gridy = 1;
        R2.add(entradaR2, g);

        g.gridx = 1;
        R2.add(btnGurdar, g);

        // Junto paneles ficheros
        panelFicheros = new JPanel();
        panelFicheros.setLayout(new GridLayout(2, 1));

        panelFicheros.add(R1);
        panelFicheros.add(R2);

        // Añado a la ventana
        ventana.add(panelFicheros);
        ventana.add(panelVisualizador);

        ventana.setVisible(true);
    }

    public static boolean esSegura(String contraseña) {
        if (contraseña.length() < 8)
            return false; // comprueba que tenga mínimo 8 caracteres

        boolean num = false;
        boolean mayus = false;

        for (int i = 0; i < contraseña.length(); i++) { // recorre cada carácter
            char c = contraseña.charAt(i); // obtiene el carácter en la posición i

            if (c >= '0' && c <= '9')
                num = true; // comprueba si es un número
            if (c >= 'A' && c <= 'Z')
                mayus = true; // comprueba si es mayúscula
        }

        return num && mayus; // solo es segura si cumple los dos requisitos
    }
}