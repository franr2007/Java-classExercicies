package es.cide.programacion2;

import java.util.Scanner;

//41663903R
//Francisco Javier Rodriguez

public class Main {
    public static void main(String[] args) {

        // Ejercicio 6 "Adivinar caracter"
        // Declara una variable char letra

        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce una letra");
        char letra = sc.next().charAt(0);

        switch (letra) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                System.out.println("Es una vocal");
                break;
            default:
                System.out.println("Es una consonante");
                break;
        }
        sc.close();
    }
}