package es.programacion.cide;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//Francisco Javier Rodriguez

public class Main {
    public static void main(String[] args) {
        double[] numero1 = { 0 };
        double[] numero2 = { 0 };

        JFrame ventana = new JFrame();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLayout(new BorderLayout());
        ventana.setSize(800, 800);

        JPanel panelResultado = new JPanel();
        JLabel textoResultado = new JLabel();

        JPanel panelSuma = new JPanel();
        JLabel texto1=new JLabel("Numero 1");
        JTextField campoNumero1 = new JTextField();
        campoNumero1.setColumns(20);
        JLabel texto2=new JLabel("Numero 2");
        JTextField campoNumero2 = new JTextField();
        campoNumero2.setColumns(20);

        JButton botonSumar = new JButton("Sumar");
        botonSumar.setSize(20, 10);
        botonSumar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    numero1[0] = Integer.parseInt(campoNumero1.getText());
                    numero2[0] = Integer.parseInt(campoNumero2.getText());
                    double suma = numero1[0] + numero2[0];
                    textoResultado.setText("El resultado de tu suma es: " + suma);
                } catch (NumberFormatException f) {
                    JOptionPane alerta = new JOptionPane();
                    alerta.showMessageDialog(null, "LAS LETRAS NO SE SUMAN PALURDO", "Error", 0);
                }
            }
        });

        panelResultado.add(textoResultado);

        panelSuma.add(texto1);
        panelSuma.add(campoNumero1);
        panelSuma.add(texto2);
        panelSuma.add(campoNumero2);
        panelSuma.add(botonSumar);

        ventana.add(panelSuma, BorderLayout.CENTER);
        ventana.add(panelResultado, BorderLayout.NORTH);
        ventana.setVisible(true);
    }
}