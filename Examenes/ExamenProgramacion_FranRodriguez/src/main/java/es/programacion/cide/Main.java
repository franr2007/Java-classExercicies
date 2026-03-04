package es.programacion.cide;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Main {
    public static void main(String[] args) {
        // Look and feel
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
        }

        // ventana principal
        JFrame ventana = new JFrame();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(600, 400);

        // Panel global
        JPanel panelgeneral = new JPanel();
        panelgeneral.setLayout(new GridBagLayout());

        // Configuracion Global GridBagLayout
        GridBagConstraints g = new GridBagConstraints();
        g.fill = GridBagConstraints.HORIZONTAL;
        g.weightx = 1;// Cada fila solo puede tener un componente
        g.weighty = 1;// Cada columna solo puede tener un componente
        g.insets = new Insets(2, 10, 2, 10);// padding de cada elemento de gridBagLayout

        // Nombre de la reserva del hotel
        JLabel labelNombreReserva = new JLabel("Nombre: ");
        JTextField fieldNombreReserva = new JTextField(20);

        // DNI
        JLabel labelDNI = new JLabel("DNI: ");
        JLabel correctoDNI = new JLabel(" ");
        JTextField fieldDNI = new JTextField(1);
        fieldDNI.addKeyListener(new KeyListener() { // Cada vez que se introduce una tecla oye:
            @Override
            public void keyPressed(KeyEvent e) {
                if (validarDNI(labelDNI.getText())) { // Si el metodo devuelve true
                    correctoDNI.setText("OK"); // Se cambia el texto de correctoDNI
                    ;
                } else
                    correctoDNI.setText("ERROR");// Si no muestra error
            }

            // Lo mismo para los siguientes metodos
            @Override
            public void keyReleased(KeyEvent e) {
                if (validarDNI(labelDNI.getText())) {
                    correctoDNI.setText("OK");
                } else
                    correctoDNI.setText("ERROR");
            }

            @Override
            public void keyTyped(KeyEvent e) {
                if (validarDNI(labelDNI.getText())) {
                    correctoDNI.setText("OK");
                } else
                    correctoDNI.setText("ERROR");
            }
        });

        // Fecha check-in
        JLabel labelData = new JLabel("Fecha Check-in: (dd/MM/yyyy) ");
        JTextField fieldData = new JTextField(20);
        fieldData.addFocusListener(new FocusListener() {
        JOptionPane ventanaEmergente = new JOptionPane();

            public void focusGained(FocusEvent e) {

            }

            @Override
            public void focusLost(FocusEvent e) { // Cuando el metodo pierde el foco mostrara lo siguiente
                if (!esDataAnterior(fieldData.getText())) { // Si el metodo devuelve falso es que la fecha tiene un
                                                            // formato invalido
                    ventanaEmergente.showMessageDialog(null, "El formato de fecha es invalido", "Error", 0);
                } else if (fieldData.getText().equals("")) {// Si el textfield esta vacio dara error
                    ventanaEmergente.showMessageDialog(null, "El campo de la fecha no puede estar vacio", "Error", 0);
                }
            }
        });

        // Noches en el hotel
        JSlider sliderNoches = new JSlider();
        sliderNoches.setMinimum(1);
        sliderNoches.setMaximum(15);
        sliderNoches.setPaintLabels(true);
        sliderNoches.setPaintTicks(true);
        sliderNoches.setMajorTickSpacing(1);
        sliderNoches.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (sliderNoches.getValue() == sliderNoches.getMaximum()) {
                    JOptionPane ventanaEmergente = new JOptionPane();
                    ventanaEmergente.showMessageDialog(null, "Instancia maxima del hotel", "Alerta", 1);
                }
            }
        });

        // Seleccion Hotel
        JLabel labelHotel = new JLabel("Hotel: ");
        JComboBox<String> comboHotel = new JComboBox<>();
        comboHotel.addItem("Hotel illa");
        comboHotel.addItem("Hotel Blau");
        comboHotel.addItem("Hotel Vall");
        comboHotel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                if (comboHotel.getSelectedItem() == "Hotel illa") {
                    sliderNoches.setMaximum(10);
                } else if (comboHotel.getSelectedItem() == "Hotel Blau") {
                    sliderNoches.setMaximum(3);
                } else {
                    sliderNoches.setMaximum(60);
                    sliderNoches.setMajorTickSpacing(10);
                }
                ;
            }
        });

        // Resumen reserva
        JLabel labelResumen = new JLabel("Reserva: ");

        // Boton guardar reserva
        JButton botonReserva = new JButton("Guardar reserva");
        botonReserva.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                labelResumen.setText("Reserva: " + fieldNombreReserva.getText() + ", " + fieldDNI.getText() + ", "
                        + comboHotel.getSelectedItem() + ", " + sliderNoches.getValue() + " nits");
            }
        });

        // Panelgeneral add's
        // fila 0 --> Nombre Reserva
        g.gridx = 0;
        g.gridy = 0;
        panelgeneral.add(labelNombreReserva, g);
        g.gridx = 1;
        g.gridy = 0;
        g.gridwidth = 2;
        panelgeneral.add(fieldNombreReserva, g);

        // fila 1 --> DNI
        g.gridx = 0;
        g.gridy = 1;
        panelgeneral.add(labelDNI, g);
        g.gridx = 1;
        g.gridy = 1;
        panelgeneral.add(fieldDNI, g);
        g.gridx = 2;
        g.gridy = 1;
        panelgeneral.add(correctoDNI, g);

        // fila 2 --> fecha
        g.gridx = 0;
        g.gridy = 2;
        panelgeneral.add(labelData, g);
        g.gridx = 1;
        g.gridy = 2;
        g.gridwidth = 2;
        panelgeneral.add(fieldData, g);

        // fila 3 --> comboBox hotel
        g.gridx = 0;
        g.gridy = 3;
        panelgeneral.add(labelHotel, g);
        g.gridx = 1;
        g.gridy = 3;
        g.gridwidth = 2;
        panelgeneral.add(comboHotel, g);

        // fila 4 --> slider noches
        g.gridx = 0;
        g.gridy = 4;
        g.gridwidth = 3;
        panelgeneral.add(sliderNoches, g);

        // fila 5 --> boton
        g.gridx = 0;
        g.gridy = 5;
        g.gridwidth = 3;
        panelgeneral.add(botonReserva, g);

        // fila 5 --> resumen reserva
        g.gridx = 0;
        g.gridy = 6;
        g.gridwidth = 3;
        panelgeneral.add(labelResumen, g);

        // Ventana add's
        ventana.add(panelgeneral);
        ventana.setVisible(true);
    }

    public static boolean validarDNI(String dni) {
        // Comprova si el format del DNI és correcte:
        // - Ha de tenir exactament 8 dígits seguits d'una lletra (majúscula o
        // minúscula).
        if (!dni.matches("\\d{8}[A-HJ-NP-TV-Za-hj-np-tv-z]"))
            return false;

        // Conjunt de lletres possibles per a la validació del DNI.
        String lletres = "TRWAGMYFPDXBNJZSQVHLCKE";

        // Converteix els primers 8 caràcters (els dígits) a un número enter.
        int numero = Integer.parseInt(dni.substring(0, 8));

        // Converteix la lletra proporcionada a majúscula per evitar errors de
        // comparació.
        char lletraDNI = Character.toUpperCase(dni.charAt(8));

        // Comprova si la lletra calculada a partir del número coincideix amb la lletra
        // proporcionada.
        return lletres.charAt(numero % 23) == lletraDNI;
    }

    public static boolean esDataAnterior(String dataString) {
        try {
            // Defineix el format de la data esperada
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            // Converteix el String a un objecte LocalDate
            LocalDate dataEntrada = LocalDate.parse(dataString, formatter);

            // Obté la data actual
            LocalDate dataActual = LocalDate.now();

            // Compara si la data entrada és anterior a la data actual
            return dataEntrada.isBefore(dataActual);
        } catch (DateTimeParseException e) {
            // Retorna fals en cas d'error en el format de la data
            System.out.println("Error: Format de data invàlid. Utilitza dd/MM/aaaa.");
            return false;
        }
    }
}