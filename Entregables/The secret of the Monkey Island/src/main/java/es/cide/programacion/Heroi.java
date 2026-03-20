package es.cide.programacion;

import java.util.Scanner;

//41663903R
//Francisco Javier Rodriguez

public class Heroi {
    // Atributos
    private String nom;
    private int vida;
    private String respuestas[];
    private int responder;
    private boolean correcto;

    // Constructor
    public Heroi(String nom, int vida, String respuestas[]) { // En este constructor igualo las variables al mismo valor
                                                              // introducido desde fuera
        this.nom = nom;
        this.vida = vida;
        this.respuestas = respuestas;
    }

    // getters y setters

    public String getNom() {
        return nom;
    }

    public int getVida() {
        return vida;
    }

    public int getResponder() {
        return responder;
    }

    public void setCorrecto(boolean correcto) {
        this.correcto = correcto;
    }

    public boolean getCorrecto() {
        return correcto;
    }

    // metodos
    public void defensar(Scanner sc) { // Muestra todas la lista de respuestas en orden al array y devuelve la
                                       // respuesta del usuario
        for (int i = 0; i <= respuestas.length - 1; i++) {// Recorre el array de respuestas 1 x 1
            System.out.println(i + ". " + respuestas[i]); // Imprime la respuesta
        }
        boolean fueraLimites = false; // Declaro esta variable para comprobar si escribe algo incorrectamente a la
                                      // hora de jugar
        while (fueraLimites == false) {// este while hace que el usuario responda y comprueba esa respuesta dentro

            if (sc.hasNextInt()) { // este if lee el siguiente scanner y devuelve true si es un numero y si no es
                                   // false
                responder = sc.nextInt(); // El usuario da su respuesta
                if (responder < 0 || responder > 9) { // se comprueba si esta dentro de los limites si no muestra lo
                                                      // siguente
                    System.out.println("\nFuera de los limites, vuelve a escribir el numero\n");
                } else { // Si todo esta bien sale del bucle
                    fueraLimites = true;
                }
            } else { // Si es otra cosa que no
                System.out.println("\nEso no es un numero!\n");
                sc.next(); // lee, descarta la palabra, hace que no se genere un bucle infinito y hace que
                           // luego pida otra vez el numero
            }

        }
    }

    public boolean vida() { //Resta cunta vida tiene el heroe y devuleve un booleano
        if (vida == 0) { // Si tiene 0 vidas muere
            return true; //devuelve true si ha muerto
        } else if (correcto == false) { // Si la respuesta es correcta no se le restara vida si es al contrario si.
            vida -= 1; //Se le resta una vida
            return false; //devuelve false porque no ha muerto
        } else {
            return false; //devuelve false porque no ha muerto
        }
    }
}
