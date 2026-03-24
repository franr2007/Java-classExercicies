package es.cide.programacion2;

import java.util.Scanner;

//Francisco Javier Rodriguez

public class Main {
    public static void main(String[] args) {

        // Ejercicio 7 "Calculadora basica"
        // Declara dos enteros a , b y un char operador que puede ser '+','-','*'...

        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el primer numero:");
        int a = sc.nextInt();
        System.out.println("Introduce el segundo numero:");
        int b = sc.nextInt();
        System.out.println("Introduce el operador con cual quieres operar,'+','-','*'...:");
        char operador = sc.next().charAt(0);

        switch (operador) {
            case '+':
                System.out.println(a + b);
                break;
            case '-':
                System.out.println(a - b);
                break;
            case '*':
                System.out.println(a * b);
                break;
            case '/':
                System.out.println(a / b);
                break;

            default:
                System.out.println("El operador es incorrecto");
                break;
        }
        sc.close();
    }
}