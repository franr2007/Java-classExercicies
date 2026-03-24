package es.cide.programacion2;

import java.util.Scanner;

//Francisco Javier Rodriguez

public class Main {
    public static void main(String[] args) {
        
//Ejercicio 1 "Numero positivo o negativo"
        //Declara una variable entera numero

        Scanner sc = new Scanner(System.in);
        //Aqui le preguntamos al usuario por un numero entero
        System.out.print("Introduce un numero entero:");
        //Declaramos la variable
        int numero= sc.nextInt();

        //Y aqui ponemos las condiciones
        if (numero>=0){
            System.out.println("El numero es positivo"); //Imprime en pantalla la respuesta
        }
        else if (numero<0){
            System.out.println("El numero es negativo");
        }
        sc.close(); //Cierra el escaner
    }
}