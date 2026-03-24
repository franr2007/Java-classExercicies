package es.cide.programacion;

import java.util.Scanner;

//Francisco Javier Rodriguez

public class Heroi {
    // Atributos
    private String nom;
    private int vida;
    private String respuestas[];
    private int responder;
    private boolean correcto;

    // Constructor
    public Heroi(String nom, int vida, String respuestas[]) {
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

    // metodos
    public void defensar(Scanner sc) { // Muestra todas la lista de respuestas en orden al array y devuelve la
                                       // respuesta del usuario
        for (int i = 0; i <= respuestas.length - 1; i++) {// Recorre el array de respuestas 1 x 1
            System.out.println(i + ". " + respuestas[i]);
        }
        boolean fueraLimites = false;
        while (fueraLimites == false) {
            if (sc.hasNextInt()) {
                responder = sc.nextInt(); // El usuario da su respuesta

                if (responder < 0 || responder > 9) { // Si se pasa de los limites le hace volver a escribir
                    System.out.println("\nFuera de los limites, vuelve a escribir el numero\n");
                    responder = sc.nextInt();
                } else {
                    fueraLimites = true;
                }
            }
            else {
                System.out.println("\nEso no es un numero!\n");
                sc.next();
            }

        }
    }

    public int vida() { // Muestra y resta cunta vida tiene el heroe
        if (vida == 0) { // Si tiene 0 vidas muere
            System.out.println("Estas muerto");
        } else if (correcto == false) { // Si la respuesta es correcto no se le restara vida si es al contrario si.
            vida -= 1;
            System.out.println("\nEl pirata te ha quitado vida (-1), te queda: " + vida + " vida/s\n");
        } else {
            System.out.println("\nEl pirata no te ha quitado vida, aun tienes: " + vida + " vida/s\n");
        }
        return vida;
    }
}
