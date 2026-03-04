package es.programacion.cide;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        // Look and feel
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            
        }

        JFrame ventana = new JFrame("ficha de película");
        ventana.setSize(400, 400);

        // Panel global
        JPanel panelgeneral = new JPanel();
        panelgeneral.setLayout(new GridBagLayout());

        // Configuracion Global GridBagLayout
        GridBagConstraints g = new GridBagConstraints();
        g.fill = GridBagConstraints.HORIZONTAL;
        g.weightx = 1.0;
        g.insets = new Insets(4, 10, 4, 10);

        // Titulo pelicula
        JLabel labelTituloPelicula = new JLabel("Titulo de la pelicula: ");
        JTextField textoPelicula = new JTextField(20);

        // Genero
        JLabel labelTipoGenero = new JLabel("Genero: ");
        JComboBox<String> generos = new JComboBox<>();
        generos.addItem("Accion");
        generos.addItem("Terror");
        generos.addItem("Comedia");
        generos.addItem("Drama");
        generos.addItem("Ciencia Ficción");
        generos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                if (generos.getSelectedItem() == "Terror") {
                    JOptionPane p = new JOptionPane();
                    p.showMessageDialog(null, "Cuidado este apartado es para mayores de 16+ años", "Cuidado", 1);
                }
            }
        });

        // Año seleccionado
        JLabel labelAnoSeleccionado = new JLabel("Año seleccionado: ");
        JLabel anoElegido = new JLabel("");

        // Año de estreno
        JLabel labelEstreno = new JLabel("Año de estreno: ");
        JSlider sliderEstreno = new JSlider();
        sliderEstreno.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int i = sliderEstreno.getValue();
                String s = Integer.toString(i);
                anoElegido.setText(s);
            }
        });
        ;
        sliderEstreno.setMinimum(1900);
        sliderEstreno.setMaximum(2025);
        sliderEstreno.setPaintLabels(true);
        sliderEstreno.setPaintTicks(true);
        sliderEstreno.setMinorTickSpacing(5);
        sliderEstreno.setMajorTickSpacing(25);

        // Resumen eleccion pelicula
        JLabel resumenPelicula = new JLabel("Pelicula:");

        // Boton Submit ficha
        JButton botonMostrarFicha = new JButton("Mostrar Ficha");
        botonMostrarFicha.setSize(100, 10);
        botonMostrarFicha.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resumenPelicula.setText("Pelicula: " + textoPelicula.getText() + " | " + generos.getSelectedItem()
                        + " | Año: " + anoElegido.getText());
            }
        });

        // Vocales
        JLabel labelVocales = new JLabel("Selecciona una vocal: ");
        JTextField textoVocales = new JTextField(20);
        JLabel labelNumeroVocales = new JLabel("Numero de Vocales: ");
        JLabel textoNumeroVocales = new JLabel("");
        JButton botonVocales = new JButton("Contar Vocales");
        botonVocales.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = textoPelicula.getText();
                int n = 0;
                for (int i = 0; i < s.length(); i++) {
                    switch (s.charAt(i)) {
                        case 'a':
                            n++;
                            break;
                        case 'e':
                            n++;
                            break;
                        case 'i':
                            n++;
                            break;
                        case 'o':
                            n++;
                            break;
                        case 'u':
                            n++;
                            break;

                        default:
                            new JOptionPane("Esto no es una vocal");
                            break;
                    }
                }
                s = Integer.toString(n);
                textoNumeroVocales.setText(s);
            }
        });

        // Añadir al panel general
        // Pelicula
        g.gridx = 0;
        g.gridy = 0;
        panelgeneral.add(labelTituloPelicula, g);
        g.gridx = 1;
        g.gridy = 0;
        panelgeneral.add(textoPelicula, g);
        // genero
        g.gridx = 0;
        g.gridy = 1;
        panelgeneral.add(labelTipoGenero, g);
        g.gridx = 1;
        g.gridy = 1;
        panelgeneral.add(generos, g);
        // Estreno
        g.gridx = 0;
        g.gridy = 2;
        panelgeneral.add(labelEstreno, g);
        g.gridx = 1;
        g.gridy = 2;
        panelgeneral.add(sliderEstreno, g);
        // año seleccionado
        g.gridx = 0;
        g.gridy = 3;
        panelgeneral.add(labelAnoSeleccionado, g);
        g.gridx = 1;
        g.gridy = 3;
        panelgeneral.add(anoElegido, g);
        // boton ficha
        g.gridx = 0;
        g.gridy = 4;
        g.gridwidth = 2;
        g.fill = GridBagConstraints.HORIZONTAL;
        panelgeneral.add(botonMostrarFicha, g);
        // resumen
        g.gridx = 0;
        g.gridy = 5;
        g.gridwidth = 2;
        g.fill = GridBagConstraints.HORIZONTAL;
        panelgeneral.add(resumenPelicula, g);
        // vocales
        g.gridx = 0;
        g.gridy = 6;
        panelgeneral.add(labelVocales, g);
        g.gridx = 1;
        g.gridy = 6;
        panelgeneral.add(textoVocales, g);
        // boton vocales
        g.gridx = 0;
        g.gridy = 7;
        g.gridwidth = 2;
        g.fill = GridBagConstraints.HORIZONTAL;
        panelgeneral.add(botonVocales, g);
        // Contador de vocales
        g.gridx = 0;
        g.gridy = 8;
        panelgeneral.add(labelNumeroVocales, g);
        g.gridx = 1;
        g.gridy = 8;
        panelgeneral.add(textoNumeroVocales, g);

        // Añadir a la ventana
        ventana.add(panelgeneral);
        ventana.setVisible(true);
    }
}