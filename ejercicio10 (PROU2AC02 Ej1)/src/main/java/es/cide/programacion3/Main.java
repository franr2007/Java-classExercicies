package es.cide.programacion3;

import java.util.Scanner;

//41663903R
//Francisco Javier Rodriguez

public class Main {
    public static void main(String[] args) {
        // Ejercicio 1
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce un numero entero positivo");
        int numero = sc.nextInt();
        int i = 1;
        int suma = 0;
        while (i <= numero) {
            if (i % 2 == 0) {
                System.out.println(i);
                suma = suma + i;
            }
            i = i + 1;
        }
        System.out.println(suma);
        sc.close();
    }
}