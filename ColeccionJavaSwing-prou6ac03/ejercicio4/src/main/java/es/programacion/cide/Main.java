package es.programacion.cide;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

//41663903R
//Francisco Javier Rodriguez Magaña
//30-01-26

public class Main {
    public static void main(String[] args) {
        JFrame ventana = new JFrame();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLayout(new FlowLayout());
        ventana.setSize(800, 800);

        JButton boton = new JButton("Habilitame porfa");
        boton.setSize(20, 10);
        boton.setEnabled(false);

        JCheckBox checker = new JCheckBox("Habilitar Boton?");
        checker.setSize(20, 10);
        checker.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {

                if (e.getStateChange() == ItemEvent.SELECTED) { // Este if coge el estado actual del checker y comprueba
                                                                // si esta seleccionado o no
                    boton.setEnabled(true); //Si esta se activara
                }
                else{
                    boton.setEnabled(false);//Si no se desactivara
                }
            }
        });

        ventana.add(boton);
        ventana.add(checker);
        ventana.setVisible(true);

    }
}