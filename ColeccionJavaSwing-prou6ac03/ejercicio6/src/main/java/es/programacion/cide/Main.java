package es.programacion.cide;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Francisco Javier Rodriguez

public class Main {
    public static void main(String[] args) {
        JFrame ventana = new JFrame();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLayout(new BorderLayout());
        ventana.setSize(800, 800);

        JPanel panelLista = new JPanel();
        DefaultListModel modeloLista = new DefaultListModel<>(); // Es un modelo default para una lista
        JList<String> lista = new JList<>(modeloLista); // Creo la lista y le añado el modelo

        JPanel panelAgregar = new JPanel();
        JTextField campoAgregar = new JTextField();
        campoAgregar.setColumns(10);
        JButton botonAgregar = new JButton("Agregar al carrito");
        botonAgregar.setSize(30, 10);
        botonAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modeloLista.addElement(campoAgregar.getText());// le añado el elemento al modelo de la lista y luego se
                                                               // ve reflejado
                campoAgregar.setText(null);// cambio el valor del texto del Jtextfield(campoAgregar) a nulo para despues
                                           // no se vea
            }
        });

        panelLista.add(lista);

        panelAgregar.add(campoAgregar);
        panelAgregar.add(botonAgregar);

        ventana.add(panelLista, BorderLayout.CENTER);
        ventana.add(panelAgregar, BorderLayout.NORTH);

        ventana.setVisible(true);
    }
}