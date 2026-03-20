package es.programacion.cide;

import javax.swing.*;
import java.awt.*;

//41663903R
//Francisco Javier Rodriguez

public class Main {
    public static void main(String[] args) {
        JFrame finestra =new JFrame("Exemple layoutManager");
        finestra.setSize(500,300);
        finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        finestra.setLayout(new BorderLayout());

        JPanel panellSuperior=new JPanel();
        panellSuperior.setLayout(new FlowLayout());
        panellSuperior.add(new JButton("Boto 1"));
        panellSuperior.add(new JButton("Boto 2"));
        panellSuperior.add(new JButton("Boto 3"));

        JPanel panellCentral=new JPanel();
        panellCentral.setLayout(new GridLayout(2,2));
        panellCentral.add(new JLabel("Etiqueta 1"));
        panellCentral.add(new JTextField("Text 1"));
        panellCentral.add(new JLabel("Etiqueta 2"));
        panellCentral.add(new JTextField("Text 2"));

        finestra.add(panellSuperior,BorderLayout.NORTH);
        finestra.add(panellCentral,BorderLayout.CENTER);

        try{
            UIManager.setLookAndFeel("");
        }catch (Exception e){
            e.printStackTrace();
        }

        finestra.setVisible(true);
    }
}