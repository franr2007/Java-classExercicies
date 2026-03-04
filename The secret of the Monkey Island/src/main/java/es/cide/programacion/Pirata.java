package es.cide.programacion;

import java.util.Random;

//41663903R
//Francisco Javier Rodriguez

public class Pirata {
    // atributos
    private Random aleatorio = new Random();
    private int vida;
    private String insultos[];
    private int insultoAleatorio;
    private String nomPirata;
    private String insultosPirata[];
    private int insultoAleatorioPirata;
    private boolean nuevoPirata;

    // constructor
    public Pirata(String insultos[], String nomPirata) {
        this.insultos = insultos;
        this.nomPirata = nomPirata;
        insultosPirata = new String[3]; // Rueda de 3 insultos que tendra el pirata
        vida = aleatorio.nextInt(3) + 1; // Random de la vida del pirata
        nuevoPirata = true; // Siempre al inicio de la partida el pirata siempre sera nuevo
    }

    // Getters y setters
    public int getVida() {
        return vida;
    }

    public void setNuevoPirata(boolean nuevoPirata) {
        this.nuevoPirata = nuevoPirata;
    }

    // Metodos
    public void insultar() { // Randomiza y Muestra los insultos de el pirata
        while (nuevoPirata) { // Mientras el pirata sea nuevo = (true)
            for (int i = 0; i < 3; i++) { // Se selecciona aleatoriamente los 3 insultos que tendra
                insultoAleatorio = aleatorio.nextInt(insultos.length);// Se selecciona un numero aleatorio para
                                                                      // assignarle a la siguiente posicion del array
                insultosPirata[i] = insultos[insultoAleatorio]; // Array de 3 insultos del pirata
            }
            nuevoPirata = false; // Luego se cierra el bucle ya que no sera un pirata nuevo hasta que no muera
        }

        insultoAleatorioPirata = aleatorio.nextInt(3); // Este random genera de 0-2 y se mueve en el array del insulto
                                                       // de pirata

        System.out.println("\n" + vida + " vida/s " + nomPirata + ": " + insultosPirata[insultoAleatorioPirata] + "\n"); //Muestra el insulto
    }

    public boolean replica(String comprobarCorrecto) {// El metodo replica coje un valor tipo String y devuelve un valor
                                                      // tipo booleano
        if (comprobarCorrecto.equals(insultosPirata[insultoAleatorioPirata])) {// Aqui ese valor String se compara si es
                                                                               // la respuesta correcta de insulto
            return true; // Si es correcto se devuelve true
        } else {
            return false; // si no devuelve false
        }
    }

    public void vida() { // resta la vida del pirata
        vida--; // Le quita 1 vida al pirata
        if (vida == 0) {
            nuevoPirata = true; // Si muere esta variable, representa que se ha de hacer un nuevo pirata
        } else {
            nuevoPirata = false; // Si no esta muerto, sigue en false;
        }
    }
}
