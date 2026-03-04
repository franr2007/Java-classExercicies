package es.programacion.cide;

import javax.swing.*;
import java.awt.*;

//41663903R
//Francisco Javier Rodriguez Magaña
//02-02-26

public class Main {
    public static void main(String[] args) {
        JFrame ventana=new JFrame();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLayout(new FlowLayout());
        ventana.setSize(2040, 1080);

        JLabel imagen=new JLabel();
        ImageIcon imagenWin=new ImageIcon(Main.class.getResource("/winLogo.png")); //Añade la ruta de la imagen
        ImageIcon imagenWinScaled=new ImageIcon(imagenWin.getImage().getScaledInstance(800, 800, 0)); //Escala la imagen anterior
        
        //Igual que lo anterior
        ImageIcon imagenLin=new ImageIcon(Main.class.getResource("/linuxLogo.png"));
        ImageIcon imagenLinScaled=new ImageIcon(imagenLin.getImage().getScaledInstance(800, 800, 0));

        ImageIcon imagenMac=new ImageIcon(Main.class.getResource("/macOsLogo.png"));
        ImageIcon imagenMacScaled=new ImageIcon(imagenMac.getImage().getScaledInstance(800, 800, 0));

        //Radio buttons
        JRadioButton botonW=new JRadioButton("Windows");
        botonW.addActionListener(e -> imagen.setIcon(imagenWinScaled));//Si se selecciona el radio button, cambia la imagen

        //Igual que lo anterior
        JRadioButton botonL=new JRadioButton("Linux");
        botonL.addActionListener(e -> imagen.setIcon(imagenLinScaled));

        JRadioButton botonM=new JRadioButton("MacOS");
        botonM.addActionListener(e -> imagen.setIcon(imagenMacScaled));

        //Grupo de botones
        ButtonGroup grupoBotones=new ButtonGroup();//Agrupa los radio buttons y hace que solo se pueda seleccionar
        grupoBotones.add(botonM);
        grupoBotones.add(botonW);
        grupoBotones.add(botonL);
        
        ventana.add(botonW);
        ventana.add(botonL);
        ventana.add(botonM);
        ventana.add(imagen);
        ventana.setVisible(true);
    }
}