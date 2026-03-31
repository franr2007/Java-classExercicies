package es.programacion.cide;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

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
        JButton btnGurdar = new JButton("Desar");
        JLabel textoR2;

        // Requisito: Dos áreas de texto con scroll
        JPanel panelVisualizador;
        JLabel txtSeguras;
        JTextArea areaSeguras;
        JLabel noTxtSeguras;
        JTextArea areaNoSegures;
        JScrollPane scrollSeguras;
        JScrollPane scrollNoSeguras;

        JFrame ventana = new JFrame("Filtre de Seguretat");
        ventana.setSize(800, 600);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setResizable(false); // La ventana no debe ser redimensionable
        ventana.setLayout(new GridLayout(2, 1));

        // Panel visualizador
        panelVisualizador = new JPanel();
        panelVisualizador.setLayout(new GridLayout(2, 2)); // Para poner las dos áreas lado a lado

        txtSeguras = new JLabel("Contraseñas seguras");
        areaSeguras = new JTextArea();
        noTxtSeguras = new JLabel("Contraseñas no seguras");
        areaNoSegures = new JTextArea();
        scrollSeguras = new JScrollPane(areaSeguras);
        scrollNoSeguras = new JScrollPane(areaNoSegures);

        panelVisualizador.add(txtSeguras);
        panelVisualizador.add(scrollSeguras);
        panelVisualizador.add(noTxtSeguras);
        panelVisualizador.add(scrollNoSeguras);

        // panel 1
        R1 = new JPanel();
        R1.setLayout(new GridBagLayout());
        g = new GridBagConstraints();

        textoR1 = new JLabel("Camí d'origen");
        entradaR1 = new JTextField();
        entradaR1.setColumns(20);
        btnAnalizar = new JButton("Analitzar");

        btnAnalizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                // En vez de File, usamos Path para la librería NIO
                java.nio.file.Path ruta = java.nio.file.Paths.get(entradaR1.getText());

                if (!java.nio.file.Files.exists(ruta)) {
                    JOptionPane.showMessageDialog(ventana, "El fitxer no existeix", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try {
                    // Este es el método moderno: lee todo el archivo a un String directamente
                    String contenido = java.nio.file.Files.readString(ruta);
                    String[] linias = contenido.split("\n");

                    areaSeguras.setText("");
                    areaNoSegures.setText("");

                    for (String linia : linias) {
                        linia = linia.trim();
                        if (esSegura(linia)) {
                            areaSeguras.append(linia + "\n");
                        } else {
                            areaNoSegures.append(linia + "\n");
                        }
                    }

                    btnGurdar.setEnabled(true);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        //FileInputStream
        /*btnAnalizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                File ruta = new File(entradaR1.getText());

                // Si el fitxer no existeix, mostra un error amb JOptionPane
                if (!ruta.exists()) {
                    JOptionPane.showMessageDialog(ventana, "El fitxer no existeix", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try {
                    FileInputStream archivo = new FileInputStream(ruta);
                    byte[] bytes = archivo.readAllBytes(); // lee todos los bytes del archivo de golpe

                    String contenido = new String(bytes); // convierte los bytes a texto legible
                    String[] linias = contenido.split("\n"); // separa el texto en líneas, cada una es una contraseña

                    areaSeguras.setText("");
                    areaNoSegures.setText("");

                    for (String linia : linias) { // recorre cada contraseña
                        linia = linia.trim(); // limpieza de espacios/saltos
                        if (esSegura(linia)) { // comprueba si cumple los requisitos
                            areaSeguras.append(linia + "\n"); // si es segura, la añade al área de seguras
                        } else {
                            areaNoSegures.append(linia + "\n"); // si no, al área de no seguras
                        }
                    }

                    archivo.close();
                    btnGurdar.setEnabled(true); // Activa el botón de guardar tras el análisis
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }); */

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

        textoR2 = new JLabel("Camí de destí");
        entradaR2 = new JTextField();
        entradaR2.setColumns(20);
        btnGurdar.setEnabled(false); // El botón empieza inactivo

        // manera mas eficiente, printwriter
        btnGurdar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try (PrintWriter writer = new PrintWriter(new FileWriter(entradaR2.getText()))) {
                    writer.print(areaSeguras.getText());
                    JOptionPane.showMessageDialog(ventana, "Fitxer desat amb èxit");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        // FileOutputStream
        /*
         * btnGurdar.addActionListener(new ActionListener() {
         * 
         * @Override
         * public void actionPerformed(ActionEvent e) {
         * try (FileOutputStream fos = new FileOutputStream(entradaR2.getText())) {
         * String contenido = areaSeguras.getText();
         * fos.write(contenido.getBytes());
         * JOptionPane.showMessageDialog(ventana, "Fitxer desat amb èxit");
         * } catch (IOException ex) {
         * ex.printStackTrace();
         * }
         * }
         * });
         */

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