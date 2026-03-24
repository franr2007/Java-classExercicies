package es.cide.programacion2;

import java.util.Scanner;

//Francisco Javier Rodriguez

public class Main {
    public static void main(String[] args) {
        
//Ejercicio2 "Mayor de edad"
    //Declara una variable entera edad
    Scanner sc = new Scanner(System.in);

        // Pedir la edad al usuario
        System.out.print("Introduce tu edad: ");
        int edad = sc.nextInt();

        // Comprobar si es mayor o menor de edad
        if (edad >= 18) {
            System.out.println("Mayor de edad");
        } else {
            System.out.println("Menor de edad");
        }

        sc.close();        
    }
}