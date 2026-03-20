package es.programacion.cide;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//41663903R
//Francisco Javier Rodriguez
//16-02-26

public class PanelInicio extends JPanel {
    // Atributos
    private GridBagConstraints g;
    private JPanel panelTitulo;
    private JPanel panelJugadores;
    private Border borde;
    private GridBagConstraints gj;
    private Font fuenteTxt;
    private JLabel titulo;
    private JLabel textoJugador1;
    private JTextField fieldJugador1;
    private JLabel textoJugador2;
    private JTextField fieldJugador2;
    private JButton btnComenzar;
    private JButton btnInstrucciones;
    private JButton[] arrayButtons;
    private VentanaPrincipal vp;
    private ImageIcon imagenOriginal;
    private Image fondo;

    // constructor
    public PanelInicio(VentanaPrincipal ventanaPrincipal) {
        // especificaciones de la clase panelInicio
        setLayout(new GridBagLayout());
        setSize(600, 800);
        setOpaque(false);

        this.vp = ventanaPrincipal;

        // imagen de fondo del panel
        imagenOriginal = new ImageIcon(getClass().getResource("/fondo_pong.jpg"));
        fondo = imagenOriginal.getImage();

        // constantes grid para el panel
        g = new GridBagConstraints();
        g.insets = new Insets(0, 0, 0, 20);
        g.fill = GridBagConstraints.HORIZONTAL;

        // panelTitulo
        panelTitulo = new JPanel();
        panelTitulo.setSize(400, 200);
        panelTitulo.setOpaque(false);

        // panelJugadores
        panelJugadores = new JPanel();
        panelJugadores.setSize(400, 600);
        panelJugadores.setLayout(new GridBagLayout());
        panelJugadores.setOpaque(false);

        // borde estetico
        borde = BorderFactory.createLineBorder(Color.white, 2);

        // constantes grid para panelJugadores
        gj = new GridBagConstraints();
        gj.insets = new Insets(100, 0, 100, 100);

        // fuente para los textos
        fuenteTxt = new Font("Courier New", 1, 20);

        // titulo
        titulo = new JLabel("¡PONG!");

        // entrada para que el jugador1 ponga su nombre
        textoJugador1 = new JLabel("Jugador1");
        textoJugador1.setBorder(borde);
        fieldJugador1 = new JTextField(40);

        // entrada para que el jugador2 ponga su nombre
        textoJugador2 = new JLabel("Jugador2");
        textoJugador2.setBorder(borde);
        fieldJugador2 = new JTextField(40);

        // boton para comenzar el juego
        btnComenzar = new JButton("Comenzar");
        btnComenzar.setPreferredSize(new Dimension(450, 60));
        btnComenzar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { // cuando aprieta el boton
                PanelJuego panelJuego = new PanelJuego(ventanaPrincipal, PanelInicio.this); // se crea el panel juego
                ventanaPrincipal.cambiarPanel(panelJuego);// y utilizo el metodo para cambiar de panel
                panelJuego.requestFocus(); // pide focus para el paneljuego ya que lo necesita para su interaccion
            }
        });

        // boton para las instrucciones
        btnInstrucciones = new JButton("Instrucciones");
        btnInstrucciones.setPreferredSize(new Dimension(0, 60));
        btnInstrucciones.addActionListener(e -> new VentanaInstrucciones()); // si se aprieta el boton, se abre una
                                                                             // nueva ventana con las instrucciones

        // se añaden los botones a esta variable, para luego asignarle los estilos de
        // manera mas sencilla
        arrayButtons = new JButton[] { btnComenzar, btnInstrucciones };

        // añadir al panel
        definirEstilos();
        panelTitulo.add(titulo);

        gj.gridx = 0;
        gj.gridy = 0;
        panelJugadores.add(textoJugador1, gj);
        gj.gridx = 1;
        gj.gridy = 0;
        panelJugadores.add(fieldJugador1, gj);
        gj.gridx = 0;
        gj.gridy = 1;
        panelJugadores.add(textoJugador2, gj);
        gj.gridx = 1;
        gj.gridy = 1;
        panelJugadores.add(fieldJugador2, gj);

        g.gridx = 0;
        g.gridy = 0;
        g.gridwidth = 2;
        add(panelTitulo, g);
        g.gridx = 0;
        g.gridy = 1;
        g.gridwidth = 2;
        add(panelJugadores, g);
        g.gridwidth = 1;
        g.gridx = 0;
        g.gridy = 2;
        add(btnComenzar, g);
        g.gridx = 1;
        g.gridy = 2;
        add(btnInstrucciones, g);
    }

    // getters y setters
    public String getNombreJugador1() {
        return fieldJugador1.getText();
    }

    public String getNombreJugador2() {
        return fieldJugador2.getText();
    }

    // metodos

    //metodo para definir estilos
    protected void definirEstilos() {
        for (int i = 0; i < arrayButtons.length; i++) { // este for, recorre todo el array botones y les assigna los
                                                        // estilos siguientes
            arrayButtons[i].setFont(fuenteTxt);
            arrayButtons[i].setBorder(borde);
            arrayButtons[i].setForeground(Color.white);
            arrayButtons[i].setBackground(Color.red);
        }

        //estilos texto j1, j2
        textoJugador1.setFont(fuenteTxt);
        textoJugador1.setForeground(Color.white);
        textoJugador2.setFont(fuenteTxt);
        textoJugador2.setForeground(Color.white);

        //estilo titulo
        fuenteTxt = new Font("Monospace", 1, 100);
        titulo.setFont(fuenteTxt);
        titulo.setForeground(Color.white);
    }

    //pinta el fondo
    @Override
    protected void paintComponent(Graphics g) { // pinta el fondo
        super.paintComponent(g);
        g.drawImage(fondo, 0, 0, vp.getAnchoVentana() + 100, vp.getAltoVentana() + 100, null);
    }
}
