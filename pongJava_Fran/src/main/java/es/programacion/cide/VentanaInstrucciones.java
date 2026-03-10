package es.programacion.cide;

import java.awt.*;

import javax.swing.*;

public class VentanaInstrucciones extends JFrame{
    // atributos
    private JPanel panelGeneral;
    private GridBagConstraints g;
    private JTextArea texto;

    // constructor
    public VentanaInstrucciones() {
        setTitle("INSTRUCCIONES");
        setSize(400, 400);
        setLayout(new GridBagLayout());
        getContentPane().setBackground(new Color(100, 35, 35));

        //constantes grid
        g = new GridBagConstraints();

        //texto instrucciones
        texto = new JTextArea( 
                "INSTRUCCIONES\n\n" +
                        "Dos jugadores se enfrentan controlando cada uno una pala\n" +
                        "para evitar que la pelota salga por su lado.\n\n" +
                        "CONTROLES:\n" +
                        "Jugador 1 (izquierda) — W para subir, S para bajar\n" +
                        "Jugador 2 (derecha)   — ↑ para subir, ↓ para bajar\n\n" +
                        "PUNTUACIÓN:\n" +
                        "Cada vez que la pelota salga por el lado de tu rival\n" +
                        "consigues un punto. El primero en llegar a 10 gana.\n\n" +
                        "OBJETIVO:\n" +
                        "Golpea la pelota con tu pala y evita que pase por tu lado.\n\n" +
                        "¡Buena suerte!");
        texto.setEditable(false);//no es editable el txt
        texto.setFocusable(false);//no puede haber focus en el txt
        texto.setFont(new Font("Monospace", Font.PLAIN, 11)); //fuente del txt
        
        //panel para integrar el txt
        panelGeneral = new JPanel();
        panelGeneral.setSize(100, 100);
        panelGeneral.setBackground(Color.gray);
        panelGeneral.add(texto);
        
        //añadir a la ventana
        g.gridx = 0;
        g.gridy = 0;
        add(panelGeneral);
        
        //la pone visible
        setVisible(true);
    }
}
