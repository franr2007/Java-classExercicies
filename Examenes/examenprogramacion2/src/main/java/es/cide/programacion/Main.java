package es.cide.programacion;

import java.util.Random;
import java.util.Scanner;

//Francisco Javier Rodriguez

public class Main {
    public static void main(String[] args) {
        // Atributos
        Scanner sc = new Scanner(System.in);
        Random rm = new Random();

        int numObstacles = rm.nextInt(2) + 5;// Aleatorio entre 5-7 para ver cuantos obstaculos salta
        Obstacle[] arrayObstacles = new Obstacle[numObstacles]; // Array de obstaculos el largo de pende de numObstacles

        boolean superado = false;

        System.out.println("Ponle un nombre al pony: ");
        Pony pony = new Pony(sc.nextLine(), 10); // constructor pony, el nombre se lo da el usuario la energia es 10
                                                 // siempre
        System.out.println("\nEl pony se llama " + pony.getNom() + " tiene " + pony.getEnergia()
                + " de energia y tiene " + pony.getForça() + " de fuerza.");

        for (int i = 0; i < arrayObstacles.length; i++) { // Bucle para ir saltando obstaculos
            Obstacle obstacle = new Obstacle(); // Creo un obstaculo
            arrayObstacles[i] = obstacle; // Y lo añado a esa posicion del array
            System.out.println("\nEl obstaculo es: " + arrayObstacles[i].getTipus() + " dificultad: "
                    + arrayObstacles[i].getDificultad());
            if (!pony.superarObstacle(arrayObstacles[i])) { // si el metodo devuelve false, es decir si energia = 0 o
                                                            // fuerza en menor que la dificultad
                i = arrayObstacles.length; // sale del bucle
                superado = false;
                System.out.println("Al pony no le quedan fuerzas al pony");
            } else {// sino sigue para el siguiente obstaculo
                if (pony.getEnergia() < 0) {
                    pony.setEnergia(0);
                }
                System.out.println("Al pony le queda " + pony.getEnergia() + " de energia");
                superado = true;
            }
        }
        if (superado) { //Mensaje final
            System.out.println("\nEl pony ha superado todos los obstaculos, lo puedes llevar a competir!");
        } else {
            System.out.println("\nEl pony no ha conseguido superar la prueba, solo sirve para hacer hamburgesas");
        }
        sc.close();
    }
}