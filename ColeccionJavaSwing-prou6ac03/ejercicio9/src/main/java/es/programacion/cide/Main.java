package es.programacion.cide;

import javax.swing.*;
import java.awt.*;

//Francisco Javier Rodriguez

public class Main {
    public static void main(String[] args) {
        JFrame ventana = new JFrame();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(2040, 1080);
        ventana.setLayout(new FlowLayout());

        JComboBox<String> boxCortesia = new JComboBox<>(); // Jcombo es una caja donde puedes seleccionar diferentes
                                                           // atributos,objetos,cosas,etc.
        // Estos son los tres componentes que compone este JComboBox
        boxCortesia.addItem("Sr.");
        boxCortesia.addItem("Sra.");
        boxCortesia.addItem("Dr.");

        JTextArea texto = new JTextArea();
        texto.setColumns(10);

        // Preparo el boton, para que cuando se accione abra una pequeña ventana de
        // informacion y muestre el mensaje
        // Tip: El codigo puede ser mucho mas legible con variables que objtengan el
        // valor de los objetos antes
        JButton botonSaludar = new JButton("Saludar");
        botonSaludar.addActionListener(e -> new JOptionPane().showMessageDialog(ventana,
                "Saludos " + boxCortesia.getSelectedItem() + " " + texto.getText(), "Saludo",
                JOptionPane.INFORMATION_MESSAGE));

        ventana.add(boxCortesia);
        ventana.add(texto);
        ventana.add(botonSaludar);
        ventana.setVisible(true);
    }
}