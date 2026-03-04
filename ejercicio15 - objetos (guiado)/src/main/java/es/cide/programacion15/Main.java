package es.cide.programacion15;

import java.util.Scanner;

//41663903R
//Francisco Javier Rodriguez

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("numero1");
        double num1 = sc.nextDouble();
        System.out.println("numero2");
        double num2 = sc.nextDouble();
        System.out.println("Pon un operador 1=sumar, 2=restar, 3=dividir, 4=multiplicar");
        int operador = sc.nextInt();
        double resultado;
        Calculadora miCasio = new Calculadora(num1, num2);
        switch (operador) {
            case 1:
                resultado = miCasio.sumar();
                System.out.println("El resultado es " + resultado);
                break;
            case 2:
                resultado = miCasio.restar();
                System.out.println("El resultado es " + resultado);
                break;
            case 3:
                resultado = miCasio.dividir();
                System.out.println("El resultado es " + resultado);
                break;
            case 4:
                resultado = miCasio.multiplicar();
                System.out.println("El resultado es " + resultado);
                break;

            default:
                System.out.println("Has puesto el operador mal, saliendo...");
                break;
        }

        /*
         * resultado=miCasio.sumar();
         * System.out.println(resultado);
         * miCasio.setoperando1(200);
         * resultado=miCasio.sumar();
         * System.out.println(resultado);
         */
        sc.close();
    }
}