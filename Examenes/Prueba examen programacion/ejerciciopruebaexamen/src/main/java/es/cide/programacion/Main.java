package es.cide.programacion;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Atributos
        Scanner sc = new Scanner(System.in);
        String arrayObstaculos[] = { "Pedra", "Forat", "Mur", "Barranc", "Rampa" }; // array de obstaculos
        System.out.print("Ponle nombre al robot: ");
        Robot robot = new Robot(sc.nextLine(), 60, 5); // Constructor clase robot, se le pregunta el nombre del robot al
                                                       // usuario

        System.out.println(
                "Tu robot: " + robot.getNom() + " energia: " + robot.getEenergia() + " fuerza: " + robot.getForça()); // informacion

        for (int i = 0; i < arrayObstaculos.length; i++) { // Bucle para hacer todos los obstaculos
            Obstacle obstacle = new Obstacle(arrayObstaculos[i]); // Constructor clase obstacle, se recorre el array a
                                                                  // medida que se hace el for
            obstacle.informacion();// Metodo que da informacion del obstaculo
            if (!robot.superarObstaculo(obstacle)) { // se hace el metodo superarObstaculo y mira si devuelve true o
                                                     // false, el if se ejecuta si es false

                i = arrayObstaculos.length; // Sale del bucle igualando en numero de obstaculos en el array
                System.out.println("El robot no ha podido superar la prueba...");
            }
            System.out.println("El robot le queda: " + robot.getEenergia());
        }
        if (robot.getEenergia() > 0) { // Si el robot sigue teniendo energia ha superado la prueba
            System.out.println("El robot ha superado todas las pruebas!");
        }

        sc.close();// Cierro el Scanner
    }
}