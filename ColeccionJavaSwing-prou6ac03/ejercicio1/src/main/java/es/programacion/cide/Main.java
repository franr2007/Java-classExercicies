package es.programacion.cide;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Francisco Javier Rodriguez

public class Main {
    public static void main(String[] args) {  
        int[] numero={0};
           
        JFrame ventana=new JFrame();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLayout(new GridLayout(1,1));
        ventana.setSize(1020,800);
        JPanel panel=new JPanel();
        JLabel label=new JLabel("Pulsa el boton para");
        JButton boton=new JButton("1+");
        JLabel contador=new JLabel("Contador: "+0);
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                numero[0]++;
                contador.setText("Contador:" +numero[0]);
            }
        });

        panel.add(label);
        panel.add(boton);
        panel.add(contador);
        ventana.add(panel);

        ventana.setVisible(true);
    }
}