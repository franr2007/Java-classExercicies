package es.programacion.cide;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

//41663903R
//Francisco Javier Rodriguez Magaña
//03-02-26

public class Main {
    public static void main(String[] args) {
        JFrame ventana = new JFrame();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLayout(new BorderLayout());

        JLabel texto = new JLabel("Posicion del raton -> X:0 Y:0");

        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setSize(400, 400);
        panelPrincipal.addMouseMotionListener(new MouseMotionListener() { // Esta funcion detecta el movimiento del
                                                                          // raton
            @Override
            public void mouseMoved(MouseEvent e) {
                int x = e.getX();// Si el raton se mueve, cogera la posicion x del raton
                int y = e.getY();// Si el raton se mueve, cogera la posicion y del raton

                texto.setText("Posicion del raton -> X:" + x + " Y:" + y);// Aqui se actualiza el label para mostrar los
                                                                          // datos actuales
            }

            @Override
            public void mouseDragged(MouseEvent e) { // No se utiliza pero el metodo es heredado entonces se ha de poner
            }
        });

        ventana.add(texto, BorderLayout.NORTH);
        ventana.add(panelPrincipal, BorderLayout.CENTER);
        ventana.setVisible(true);
    }
}