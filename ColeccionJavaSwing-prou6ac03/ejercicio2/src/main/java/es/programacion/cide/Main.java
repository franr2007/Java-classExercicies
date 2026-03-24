package es.programacion.cide;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;

//Francisco Javier Rodriguez

public class Main {
    public static void main(String[] args) {
        JFrame ventana=new JFrame();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(1080, 1080);
        ventana.setLayout(new GridLayout(1,2));

        JLabel espejo=new JLabel("hola, escribe algo esto se actualizara a medida que escribas");
        

        JTextField texto=new JTextField();
        texto.getDocument().addDocumentListener(new DocumentListener() {
            public void actualizarTexto(){
                espejo.setText(texto.getText());
            }

            @Override
            public void insertUpdate(DocumentEvent e){
                actualizarTexto();
            }

            @Override
            public void changedUpdate(DocumentEvent e){
                actualizarTexto();
            }

            @Override
            public void removeUpdate(DocumentEvent e){
                actualizarTexto();
            }
        });



        ventana.add(texto);
        ventana.add(espejo);
        ventana.setVisible(true);
    }
}