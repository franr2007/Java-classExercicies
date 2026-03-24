package es.programacion.cide;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

//Francisco Javier Rodriguez

public class Main {
    public static void main(String[] args) {
        int alto=10;

        JFrame ventana=new JFrame();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLayout(new BorderLayout());
        ventana.setSize(800, 800);

        JPanel panelTexto=new JPanel();
        JLabel texto=new JLabel("Hola, este texto cambiara de tamaño dependiendo del valor del slider");
        texto.setSize(10, alto);

        JPanel panelSlider=new JPanel();
        JSlider slider=new JSlider(10,50);
        slider.setPaintTicks(true);//Muestra palitos
        slider.setPaintLabels(true);//Muestra numeros
        slider.setMajorTickSpacing(10);//Marca de 10 en 10 los numeros hasta llegar al valor maximo
        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int v=slider.getValue();//Obtengo el valor actual del slider
                texto.setSize(v*8, alto);//aumento el valor a v por 8 para que el cambio del ancho sea mas estetico
            }
        });

        panelTexto.add(texto);
        panelSlider.add(slider);

        ventana.add(panelSlider, BorderLayout.NORTH);
        ventana.add(panelTexto, BorderLayout.CENTER);

        ventana.setVisible(true);
    }
}