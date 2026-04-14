package es.programacion.cide;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelInicio extends JPanel {
    // Atributos
    private GridBagConstraints g;
    private JPanel panelTitulo;
    private JPanel panelLogIn;
    private Border borde;
    private GridBagConstraints gt;
    private Font fuenteTxt;
    private JLabel titulo;
    private JLabel textoEmail;
    private JTextField fieldEmail;
    private JLabel textoPassword;
    private JTextField fieldPassword;
    private JButton btnLogIn;
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

        // constantes grid para el panel
        g = new GridBagConstraints();
        g.fill = GridBagConstraints.HORIZONTAL;

        // panelTitulo
        panelTitulo = new JPanel();
        panelTitulo.setSize(400, 200);
        panelTitulo.setOpaque(false);

        // panelLogIn
        panelLogIn = new JPanel();
        panelLogIn.setSize(400, 600);
        panelLogIn.setLayout(new GridBagLayout());
        panelLogIn.setOpaque(false);

        // borde estetico
        borde = BorderFactory.createLineBorder(Color.white, 2);

        // constantes grid para panelLogIn
        gt = new GridBagConstraints();
        gt.insets = new Insets(20, 0, 20, 0);

        // fuente para los textos
        fuenteTxt = new Font("Courier New", 1, 20);

        // titulo
        titulo = new JLabel("· Gestionador de datos ·");

        // entrada para que el jugador1 ponga su nombre
        textoEmail = new JLabel("Email: ");
        textoEmail.setBorder(borde);
        fieldEmail = new JTextField(40);

        // entrada para que ponga la contraseña el usuario
        textoPassword = new JLabel("Contraseña: ");
        textoPassword.setBorder(borde);
        fieldPassword = new JTextField(40);

        // boton para Logearse
        btnLogIn = new JButton("Iniciar Sesion");
        btnLogIn.setPreferredSize(new Dimension(450, 60));
        btnLogIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { // cuando aprieta el boton
                PanelBDD panelJuego = new PanelBDD(); // se crea el panel juego
                ventanaPrincipal.cambiarPanel(panelJuego);// y utilizo el metodo para cambiar de panel
                panelJuego.requestFocus(); // pide focus para el paneljuego ya que lo necesita para su interaccion
            }
        });

        // se añaden los botones a esta variable, para luego asignarle los estilos de
        // manera mas sencilla
        arrayButtons = new JButton[] { btnLogIn };

        // añadir al panel
        definirEstilos();
        panelTitulo.add(titulo);

        gt.gridx = 0;
        gt.gridy = 0;
        gt.anchor = GridBagConstraints.LINE_END;
        gt.fill = GridBagConstraints.NONE;
        panelLogIn.add(textoEmail, gt);
        gt.gridx = 1;
        gt.gridy = 0;
        gt.anchor = GridBagConstraints.LINE_START;
        gt.fill = GridBagConstraints.HORIZONTAL;
        gt.weightx = 1;
        panelLogIn.add(fieldEmail, gt);
        gt.gridx = 0;
        gt.gridy = 1;
        gt.anchor = GridBagConstraints.LINE_END;
        gt.fill = GridBagConstraints.NONE;
        gt.weightx = 0;
        panelLogIn.add(textoPassword, gt);
        gt.gridx = 1;
        gt.gridy = 1;
        gt.anchor = GridBagConstraints.LINE_START;
        gt.fill = GridBagConstraints.HORIZONTAL;
        gt.weightx = 1;
        panelLogIn.add(fieldPassword, gt);

        g.gridx = 0;
        g.gridy = 0;
        g.gridwidth = 2;
        g.anchor = GridBagConstraints.CENTER;
        g.insets = new Insets(0, 10, 10, 10);
        add(panelTitulo, g);
        g.gridx = 0;
        g.gridy = 1;
        g.gridwidth = 2;
        g.anchor = GridBagConstraints.CENTER;
        g.insets = new Insets(10, 10, 10, 10);
        add(panelLogIn, g);
        g.gridx = 0;
        g.gridy = 2;
        g.gridwidth = 2;
        g.anchor = GridBagConstraints.CENTER;
        g.fill = GridBagConstraints.NONE;

        add(btnLogIn, g);
    }

    // getters y setters
    public String getEmail() {
        return fieldEmail.getText();
    }

    public String getPassword() {
        return fieldPassword.getText();
    }

    // metodos

    // metodo para definir estilos
    protected void definirEstilos() {
        for (int i = 0; i < arrayButtons.length; i++) { // este for, recorre todo el array botones y les assigna los
                                                        // estilos siguientes
            arrayButtons[i].setFont(fuenteTxt);
            arrayButtons[i].setBorder(borde);
            arrayButtons[i].setForeground(Color.white);
            arrayButtons[i].setBackground(Color.red);
        }

        // estilos textos
        textoEmail.setFont(fuenteTxt);
        textoEmail.setForeground(Color.white);
        textoPassword.setFont(fuenteTxt);
        textoPassword.setForeground(Color.white);

        // estilo titulo
        fuenteTxt = new Font("Monospace", 1, 100);
        titulo.setFont(fuenteTxt);
        titulo.setForeground(Color.white);
    }

    // pinta el fondo
    @Override
    protected void paintComponent(Graphics g) { // pinta el fondo
        super.paintComponent(g);
        if (fondo == null) {
            setBackground(Color.white);
        } else {
            // imagen de fondo del panel
            imagenOriginal = new ImageIcon(getClass().getResource("/fondo_pong.jpg"));
            fondo = imagenOriginal.getImage();
            g.drawImage(fondo, 0, 0, vp.getAnchoVentana() + 100, vp.getAltoVentana() + 100, null);
        }
    }
}
