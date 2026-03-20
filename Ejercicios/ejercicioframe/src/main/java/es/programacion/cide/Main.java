package es.programacion.cide;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;;

//41663903R
//Francisco Javier Rodriguez

public class Main {
    public static void main(String[] args) {
        //JFRAME pricipal
        JFrame frame= new JFrame("ventana");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//cierra completamente la ventana
        frame.setSize(400,200);
        frame.setLayout(new FlowLayout());

        //JLABEL
        JLabel label=new JLabel("hola mundo");
        frame.getContentPane().add(label);//decirle a frame que añada label
        frame.pack();//para que coloques los objetos donde quieras
        frame.setLocationRelativeTo(null);//el tamño de la ventana
        frame.setVisible(true);//hace que sea visible

        //JBUTTON
        JButton button=new JButton("Abrir dialogo");
        frame.add(button);

        //Agregamo un listener para abrir el JDialog
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                mostrarDialogo(frame);
            }
        });


    }

    public static void mostrarDialogo(JFrame parent) {
        //Creamos el dialogo modal (bloquea la ventana principal hasta que se cierre)
        JDialog dialogo=new JDialog(parent,"Missatge Important", true);
        dialogo.setSize(300,150);
        dialogo.setLayout(new BorderLayout());

        //Ponemos un mensaje
        JLabel etiqueta=new JLabel("Esto es un dialogo",JLabel.CENTER);
        dialogo.add(etiqueta,BorderLayout.CENTER);

        //Boton para cerrar el dialogo
        JButton botonCerrar=new JButton("De acuerdo");
        botonCerrar.addActionListener(e -> dialogo.dispose());
        dialogo.add(botonCerrar,BorderLayout.SOUTH);

        //Hacemos visible el dialogo
        dialogo.setLocationRelativeTo(parent);
        dialogo.setVisible(true);
    }
}