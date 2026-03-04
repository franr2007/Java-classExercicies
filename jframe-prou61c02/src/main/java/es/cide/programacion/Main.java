package es.cide.programacion;

import javax.swing.*;
import java.awt.*;

//41663903R
//Francisco Javier Rodriguez
//21-01-26

public class Main {
    public static void main(String[] args) {
        // VENTANA
        JFrame serverAdminPanel = new JFrame();
        serverAdminPanel.setTitle("Tauler d'Administració - fran"); // Titulo de la ventana
        serverAdminPanel.setSize(800, 600);// Tamaño ventana
        serverAdminPanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// La ventana se cierra al clicar la x
        serverAdminPanel.setLocationRelativeTo(null);// Direccion donde se abre la ventana

        serverAdminPanel.setLayout(new GridLayout(2, 2, 15, 15));

        // NUEVO PANEL, panelSistema
        JPanel panelSistema = new JPanel();
        panelSistema.setBorder(BorderFactory.createTitledBorder("Estat del Sistema"));// Borde para el panel entero con
                                                                                      // el nombre
        panelSistema.setLayout(new BoxLayout(panelSistema, BoxLayout.Y_AXIS)); // BoxLayout para organizar los label

        JLabel cpuLabel = new JLabel("CPU: 15%");
        JLabel ramLabel = new JLabel("RAM: 4GB / 16GB");

        Font fuente = new Font("Arial", Font.BOLD, 20); // Fuente para los label
        cpuLabel.setFont(fuente);
        ramLabel.setFont(fuente);

        // Aqui se centran los label horizontalmente
        cpuLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        ramLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Y aqui los label se centran verticalmente, y tambien se define la separacion
        panelSistema.add(Box.createVerticalGlue());// Deja un margen, este especificamente arriba
        panelSistema.add(cpuLabel);
        panelSistema.add(Box.createVerticalStrut(5));// Distancia separado
        panelSistema.add(ramLabel);
        panelSistema.add(Box.createVerticalGlue());// Deja un margen, este especificamente abajo

        // Se añade el panel a la ventana
        serverAdminPanel.add(panelSistema);

        // NUEVO PANEL, panelAcciones
        JPanel panelAcciones = new JPanel();
        panelAcciones.setBorder(BorderFactory.createTitledBorder("Accions Ràpides"));// Titulo del panel con borde
        panelAcciones.setLayout(new BoxLayout(panelAcciones, BoxLayout.Y_AXIS));// Organiza los label de forma vertical

        // Creacion de botones
        JButton botonIniciar = new JButton("▶ Iniciar Servei");
        JButton botonParar = new JButton("■ Aturar Servei");
        JButton botonReiniciar = new JButton("↻ Reiniciar");

        // Dimension de los botones
        Dimension tamañoBotones = new Dimension(150, 30);

        botonIniciar.setPreferredSize(tamañoBotones);// Ajusta el tamaño que se quiere
        botonIniciar.setMaximumSize(tamañoBotones);// Ajusta el tamaño maximo
        botonIniciar.setMinimumSize(tamañoBotones);// Ajusta el tamaño minimo

        botonParar.setPreferredSize(tamañoBotones);
        botonParar.setMaximumSize(tamañoBotones);
        botonReiniciar.setMinimumSize(tamañoBotones);

        botonReiniciar.setPreferredSize(tamañoBotones);
        botonReiniciar.setMaximumSize(tamañoBotones);
        botonReiniciar.setMinimumSize(tamañoBotones);

        // Centra los botones horizontalmente
        botonIniciar.setAlignmentX(Component.CENTER_ALIGNMENT);
        botonParar.setAlignmentX(Component.CENTER_ALIGNMENT);
        botonReiniciar.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Se añade todo el margen vertical hasta ponerlo en medio y añade los botones
        panelAcciones.add(Box.createVerticalGlue());// Deja un margen, este especificamente arriba
        panelAcciones.add(botonIniciar);
        panelAcciones.add(Box.createVerticalStrut(5));// Distancia separado
        panelAcciones.add(botonParar);
        panelAcciones.add(Box.createVerticalStrut(5));// Distancia separado
        panelAcciones.add(botonReiniciar);
        panelAcciones.add(Box.createVerticalGlue());// Deja un margen, este especificamente abajo

        serverAdminPanel.add(panelAcciones);// Se agrega el panel a la ventana

        // NUEVO PANEL, panelCarrega
        JPanel panelCarrega = new JPanel();
        panelCarrega.setBorder(BorderFactory.createTitledBorder("Paràmetres de Càrraga"));// Titulo con borde al panel
        panelCarrega.setLayout(new GridLayout(4, 1));// Se ordena en 4 filas

        panelCarrega.add(new JLabel("Limit de Connexions (0-500):"));

        JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 500, 250);// Slider horizontal de 0-500 y marca 250 al
                                                                      // principio
        slider.setPaintTicks(true);// Añade las barras al slider
        slider.setPaintLabels(true);// Añade visualmente numeros
        slider.setMajorTickSpacing(100);// Añade los numeros de 100 en 100 hasta 500
        slider.setMinorTickSpacing(25); // Añade sticks pequeños de 25 en 25
        panelCarrega.add(slider);// Se agrega el slider al panel

        panelCarrega.add(new JLabel("Timeout (segons):"));
        panelCarrega.add(new JTextField("60"));

        serverAdminPanel.add(panelCarrega);// Se agrega el panel a la ventana

        // NUEVO PANEL, panelRegistros
        JPanel panelRegistros = new JPanel();
        panelRegistros.setBorder(BorderFactory.createTitledBorder("Logs del Servidor en Viu"));// Borde con titulo
        panelRegistros.setLayout(new GridLayout(1, 1));// Una fila y una columna, ocupa todo el panel

        // Creo el textarea
        JTextArea textArea = new JTextArea("[Info] Servei iniciat... \n" +
                "[Warning] Connexió lenta IP 192... \n" +
                " ...\n" + "holaasssssssssssfasssssssssssssssssssssssssssssssssssssssssssssssssssssss\n"
                + "Adiossssssssasdfsssssssssssssssssssssssssssssssssssssssssssssssssssss\n" + "a\n" + "b\n" + "c\n"
                + "d\n" + "e\n" + "f\n" + "g\n" + "h\n" + "i\n" + "j\n" + "k\n" + "l\n" + "m\n");
        textArea.setEditable(false);// El textarea no sera editable
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 12));// Esta es la fuente de la letra que contendra el
                                                                 // textarea

        // Creo un scrollPane
        JScrollPane scroll = new JScrollPane(textArea);// Y le añado el textarea para que ahora se pueda scrollear
        panelRegistros.add(scroll);//Añado el scroll al panel

        serverAdminPanel.add(panelRegistros);//Añado el panel a la ventana

        serverAdminPanel.setVisible(true);//La ventana es visible
    }
}