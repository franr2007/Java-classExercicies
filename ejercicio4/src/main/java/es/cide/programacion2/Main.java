package es.cide.programacion2;

import java.util.Scanner;

//41663903R
//Francisco Javier Rodriguez

public class Main {
    public static void main(String[] args) {
        
//Ejercicio 3 "Par o impar"
    //Declara una variable entera numero

    Scanner sc= new Scanner(System.in);
    System.out.println("Introduce un numero:"); //Le pide una respuesta al usuario
    int numero= sc.nextInt(); //Variable que metera el usuario

    if (numero%2==0) { //Declaramos una condicion para dar una respuesta
        System.out.println("El numero es par"); //Da la respuesta al usuario segun la condicion
    }
    else{
        System.out.println("El numero es impar"); //Da la respuesta al usuario segun la condicion
    }
    sc.close();//Se cierra el scanner
    }
}