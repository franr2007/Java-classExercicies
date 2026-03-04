package es.cide.programacion2;

import java.util.Scanner;

//41663903R
//Francisco Javier Rodriguez

public class Main {
    public static void main(String[] args) {

        // Ejercicio 5 "Mes del año"
        // Declara una variable entera mes (1 a 12)

        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce un numero del 1 al 12");
        int mes = sc.nextInt();

        switch (mes) { // Declaro las condiciones que le van a responder al numero del usuario
            case 1:
                System.out.println("Enero");
                break;
            case 2:
                System.out.println("Febrero");
                break;
            case 3:
                System.out.println("Marzo");
                break;
            case 4:
                System.out.println("Abril");
                break;
            case 5:
                System.out.println("Mayo");
                break;
            case 6:
                System.out.println("Junio");
                break;
            case 7:
                System.out.println("Julio");
                break;
            case 8:
                System.out.println("Agosto");
                break;
            case 9:
                System.out.println("Septiembre");
                break;
            case 10:
                System.out.println("Octubre");
                break;
            case 11:
                System.out.println("Noviembre");
                break;
            case 12:
                System.out.println("Dicembre");
                break;

            default:
                System.out.println("Mes no valido");
                break;
        }
        sc.close();
    }
}