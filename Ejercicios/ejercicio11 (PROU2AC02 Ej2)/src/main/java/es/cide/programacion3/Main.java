package es.cide.programacion3;

import java.util.Scanner;

//41663903R
//Francisco Javier Rodriguez

public class Main {
    public static void main(String[] args) {
        // Ejercicio 2
        Scanner sc2 = new Scanner(System.in);
        int[] arraysNota = {11,11,11,11,11,11};
        int contador = 0;
        int aprobados=0;
        int suspendidos=0;
        while (contador < 6) {
            System.out.println("Introduce una nota");
            arraysNota[contador]= sc2.nextInt();
            while (arraysNota[contador]>=11||arraysNota[contador]<=-1) {
                System.out.println("Introduce una nota correcta");
                arraysNota[contador]= sc2.nextInt();
            }
            contador++;

        }
        contador=0;
        while (contador<6) {
        if (arraysNota[contador]>=5) {
            aprobados++;   
        }else{
            suspendidos++;
        }
        contador++;
        }
        System.out.println("Aprobados "+aprobados);
        System.out.println("Suspendidos "+suspendidos);
        sc2.close();
    }
}