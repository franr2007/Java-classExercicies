package es.programacion.cide;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

//francisco javier rodriguez
//41663903R
//31-03-26

public class Main {
    public static void main(String[] args) {
        // atributos
        JTextField areafile;
        JButton btnAnalizar;
        TextArea areaPalindrom;
        JScrollPane scrollPalindrom;
        JLabel txtPalindrom;
        TextArea areaNoPalindrom;
        JScrollPane scrollNoPalindrom;
        JLabel txtNoPalindrom;
        JTextField areaGuardar;
        JButton btnGuardar;

        JFrame ventana = new JFrame();
        ventana.setLayout(new GridBagLayout());
        ventana.setSize(800, 600);
        ventana.setResizable(false);// la ventana no se puede redimensionar
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // el programa se cierra al cerrar la ventana

        GridBagConstraints g = new GridBagConstraints();
        g.fill = GridBagConstraints.HORIZONTAL;

        // area palindrom
        areaPalindrom = new TextArea();
        scrollPalindrom = new JScrollPane(areaPalindrom);
        txtPalindrom = new JLabel("Palindrom");

        // area noPalindrom
        areaNoPalindrom = new TextArea();
        scrollNoPalindrom = new JScrollPane(areaNoPalindrom);
        txtNoPalindrom = new JLabel("NO Palindrom");

        // area file
        areafile = new JTextField();
        areafile.setColumns(20);

        // Guardar
        areaGuardar = new JTextField();
        areaGuardar.setColumns(20);
        btnGuardar = new JButton("Desar");
        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    File archivo = new File(areaGuardar.getText());
                    FileOutputStream escribirArchivo = new FileOutputStream(archivo);// creo esta var, que coje el
                                                                                     // archivo y lo abre
                    escribirArchivo.write(areaPalindrom.getText().getBytes());// aqui escribe lo que hay en area
                                                                              // palindrom
                    escribirArchivo.close();// cierra el archivo
                } catch (IOException i) {
                    i.printStackTrace();
                }
            }
        });
        btnGuardar.setEnabled(false);

        // btn Leer archivo
        btnAnalizar = new JButton("LLegir");
        btnAnalizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                java.nio.file.Path ruta = java.nio.file.Paths.get(areafile.getText());

                if (!java.nio.file.Files.exists(ruta)) {
                    JOptionPane mensajError = new JOptionPane();
                    mensajError.showMessageDialog(null, "Error el archivo no existe", "ERROR",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    try {
                        // Este es el método moderno: lee todo el archivo a un String directamente
                        String contenido = java.nio.file.Files.readString(ruta);
                        String[] linias = contenido.split("\n");

                        areaPalindrom.setText("");
                        areaNoPalindrom.setText("");

                        for (String linea : linias) { // Recorre el array lineas por linea
                            linea.trim().toLowerCase();
                            if (esPalindrom(linea)) { // Si la linea es palindroma
                                areaPalindrom.append(linea + "\n"); // Se añadira al text area palindorma
                            } else {
                                areaNoPalindrom.append(linea + "\n");// si no al text area noPalindroma
                            }
                        }
                        btnGuardar.setEnabled(true);
                        
                    } catch (IOException i) {
                        i.printStackTrace();
                    }
                }
            }
        });

        // fila 1
        g.gridx = 0;
        g.gridy = 0;
        ventana.add(areafile, g);
        g.gridx = 1;
        ventana.add(btnAnalizar, g);

        // fila 2
        g.gridx = 0;
        g.gridy = 1;
        ventana.add(scrollPalindrom, g);
        g.gridx = 1;
        ventana.add(txtPalindrom, g);

        // fila3
        g.gridx = 0;
        g.gridy = 2;
        ventana.add(scrollNoPalindrom, g);
        g.gridx = 1;
        ventana.add(txtNoPalindrom, g);

        // fila 4
        g.gridx = 0;
        g.gridy = 3;
        ventana.add(areaGuardar, g);
        g.gridx = 1;
        ventana.add(btnGuardar, g);

        ventana.setVisible(true);
    }

    public static boolean esPalindrom(String linea) {
        String lineaInversa = "";
        String nuevaLinea = "";

        for (int i = 0; i < linea.length(); i++) {// for que reestructura la frase pero sin espacio
            char letra = linea.charAt(i); // Recoje la letra de la posicion i de la linea
            if (letra != ' ') { // Si no es un espacio
                nuevaLinea = nuevaLinea + letra;// la añade a la nuevaLinea
            }
        }

        for (int i = nuevaLinea.length()-1; i >= 0; i--) { // Bucle que recorre la linea en reversa
            char letra = nuevaLinea.charAt(i);// Recoje la letra de la posicion i de la linea
            lineaInversa = lineaInversa + letra;// recoje la lineaNueva pero al reves
        }
        if (nuevaLinea.equals(lineaInversa)) { // Si la linea es igual, es decir palindroma
            return true; // devulve true
        } else
            return false; // si no false
    }
}