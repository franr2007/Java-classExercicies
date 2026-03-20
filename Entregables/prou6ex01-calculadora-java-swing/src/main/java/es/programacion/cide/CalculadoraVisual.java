package es.programacion.cide;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//41663903R
//Francisco Javier Rodriguez Magaña
//04-02-2026

public class CalculadoraVisual extends JPanel {
    // Atributos
    private JPanel panelNumeros;
    private JPanel panelBotones;
    private JTextField textoNumeros;
    private JTextField textoHistorial;
    private String[] arraybotones = { "7", "8", "9", "C", "4", "5", "6", "+", "1", "2", "3", "-", "x", "0",
            "/", "=" };
    private int fila;
    private int columna;
    private double nHistorial;
    private double nActual;
    private String operador;
    private boolean usandoOperador;

    // Constructor
    public CalculadoraVisual() {
        setLayout(new GridLayout(2, 1));
        setSize(400, 400);

        // Panel que involucra, historial y numeros
        panelNumeros = new JPanel();
        panelNumeros.setLayout(new GridLayout(2, 1, 5, 5));

        // historial
        textoHistorial = new JTextField("", 20);
        textoHistorial.setEditable(false);
        textoHistorial.setHorizontalAlignment(JTextField.RIGHT);// el texto del textfield se pone a la derecha
        textoHistorial.setFocusable(false); // en este textfield no puedes hacer clic

        // Numeros
        textoNumeros = new JTextField("", 20);
        textoNumeros.setHorizontalAlignment(JTextField.RIGHT); // el texto del textfield se pone a la derecha
        textoNumeros.addKeyListener(new KeyAdapter() { // oye si se pulsa alguna letra
            @Override
            public void keyTyped(KeyEvent e) {
                char texto = e.getKeyChar();
                char comando = ' ';
                switch (texto) { // dependiendo de la tecla que se use
                    case '+', '-', '/', 'x', '*': // si es un operador
                        comando = texto; // la var comando sera igual que la tecla pulsada
                        break;

                    case '=', '\n': // Aqui si es igual o le das al enter
                        comando = '='; // se identificara como que es un igual
                        break;

                    default:
                        break;
                }

                if (comando != ' ') { // Si comando no esta vacio
                    funcionalidades(String.valueOf(comando)); // se coje el metodo y se le pasa la var comando
                                                              // (String.valueOf, pasa cualquier valor a string)
                    e.consume(); // luego se borra del textfield lo que hayas escrito
                } else if (!Character.isDigit(texto)) {// si lo que se escribe no es un numero
                    e.consume(); // se borra inmediatamente
                }
            }
        });

        panelBotones = new JPanel();
        panelBotones.setLayout(new GridBagLayout());

        GridBagConstraints g = new GridBagConstraints(); // Constantes de gridBagLayout generales
        g.fill = GridBagConstraints.HORIZONTAL;
        g.weightx = 1.0;
        g.insets = new Insets(4, 10, 4, 10);

        fila = 0;
        columna = 0;
        usandoOperador = false;
        for (int i = 0; i < arraybotones.length; i++) { // un bucle para generar los botones

            JButton boton = new JButton(arraybotones[i]); // se crea un boton con el texto del array
            boton.setFont(new Font("Arial", Font.BOLD, 20));
            boton.setBackground(new Color(220, 220, 220));
            boton.setFocusable(false);
            boton.addActionListener(new ActionListener() { // si lo pulsas
                @Override
                public void actionPerformed(ActionEvent e) {
                    String f = ((JButton) e.getSource()).getText();// la variable f coje el texto del boton pulsado
                    funcionalidades(f); // y se utiliza el metodo dandole la variable f
                }
            });

            g.gridx = columna; // se le assigna la posicion de la columna
            g.gridy = fila; // se le assigna la posicion de la fila
            panelBotones.add(boton, g); // se añade el boton al panel

            columna++; // se mueve de posicion horizontal
            if (columna == 4) { // si columna pasa de la 4 posicion
                fila++; // se baja de fila
                columna = 0;
            }
        }

        // al panel para los textfields se les añade los textfields
        panelNumeros.add(textoHistorial);
        panelNumeros.add(textoNumeros);

        // y al panel general se les añade los 2 paneles
        add(panelNumeros);
        add(panelBotones);
    }

    // getters y setters
    public double getNumeroActual() {
        return nActual;
    }

    public double getNumeroHistorial() {
        return nHistorial;
    }

    public String getOperador() {
        return operador;
    }

    public boolean getUsandoOperador() {
        return usandoOperador;
    }

    // Metodos
    public void funcionalidades(String f) { // metodo para que cada cosa sepa que hacer
        if (f.matches("\\d")) { // si el caracter es un numero
            textoNumeros.setText(textoNumeros.getText() + f);// se pone el numero en el panel correspondiente

            // si no es un numero, pero es alguno de los operadores siguientes
        } else if (f.equals("+") || f.equals("-") || f.equals("/") || f.equals("x") || f.equals("=") || f.equals("*")) {

            if (!textoNumeros.getText().isEmpty()) { // si hay numeros antes de un operador
                if (usandoOperador) { // y si hay un operador ya asignado
                    try {
                        nActual = Double.parseDouble(textoNumeros.getText()); // se recoje el texto del panel numero y
                                                                              // se pasa a numero
                        switch (operador) { // dependiendo del operador se hace la operacion respectiva
                            case "+":
                                nHistorial = sumar(nHistorial, nActual); // el resultado de las operaciones pasa a ser
                                                                         // el valor del historial
                                break;
                            case "-":
                                nHistorial = restar(nHistorial, nActual);
                                break;
                            case "/":
                                if (nActual == 0) { // si se intenta dividir por 0
                                    JOptionPane errorDivision = new JOptionPane(); // muestra un pantallazo de error
                                    errorDivision.showMessageDialog(null, "No puedes hacer una division por 0", "ERROR",
                                            JOptionPane.ERROR_MESSAGE);
                                }

                                nHistorial = dividir(nHistorial, nActual);
                                break;
                            case "x", "*":
                                nHistorial = multiplicar(nHistorial, nActual);
                                break;
                        }
                    } catch (NumberFormatException q) { // en caso que no sea un numero, mas en motivo al keyListener
                        System.out.println("no es un operador ni un numero"); // se imprime esto en consola
                        textoNumeros.setText("");// y se borra el texto
                    }
                } else { // si no hay operador, es decir que seria la primera vez que pones un numero
                    nHistorial = Double.parseDouble(textoNumeros.getText());//el texto del panel se pasa a numero y se pasa al historial
                }
            }

            if (f.equals("=")) {//si el boton o la tecla es un igual
                textoHistorial.setText(String.valueOf(nHistorial)); //se pone el resultado en los 2 textfields, para que luego se pueda seguir usando
                textoNumeros.setText(String.valueOf(nHistorial));
                usandoOperador = false;//pasa a false porque se ha terminado 
            } else {//si no es un igual, no se ha terminado la operacion
                operador = f; //se actualiza el operador
                usandoOperador = true; //se marca true porque se sigue usando un operador
                textoHistorial.setText(nHistorial + " " + operador); //se actualiza el historial
                textoNumeros.setText(""); //y se borra el texto del panel numeros
            }

        } else if (f.equals("C")) {//si es una c, se borra todo y se pone todo en default
            nHistorial = 0;
            nActual = 0;
            operador = "";
            textoNumeros.setText("");
            textoHistorial.setText("");
            usandoOperador = false;
        }
    }

    //operaciones
    public double sumar(double a, double b) {
        return a + b; //suma
    }

    public double restar(double a, double b) {
        return a - b; //resta
    }

    public double multiplicar(double a, double b) {
        return a * b; //multiplica
    }

    public double dividir(double a, double b) {
        return a / b; //division 
    }
}
