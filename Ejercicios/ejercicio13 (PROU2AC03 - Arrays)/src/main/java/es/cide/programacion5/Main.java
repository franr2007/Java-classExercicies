package es.cide.programacion5;

import java.util.Scanner;

//Francisco Javier Rodriguez

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int[] numerosArrays=new int[8];
        int contador=0;
        int numero;
        String salir;
        int i=0;
        while (contador<8) {
            System.out.println("Llena la posicion ["+contador+"] del array");
            numerosArrays[contador]=sc.nextInt();
            contador++;
        }
        contador=0;
        while (i<1) {
            System.out.println("Pon un numero para saber si esta en el array o no. Escribe salir, para salir");
            numero=sc.nextInt();
            if (numero==numerosArrays[contador]) {
                System.out.println("El numero se encuentra en el array\n");
                System.out.println("Quieres salir del programa? si/no");
                salir=sc.next().toString();
            }
            else{
                System.out.println("El numero no se encuentra en el array\n");
                System.out.println("Quieres salir del programa? si/no");
                salir=sc.next().toString();
            };
            if (salir.equals("si")) {
                i++;
            }
            
        }
        sc.close();
    }
}