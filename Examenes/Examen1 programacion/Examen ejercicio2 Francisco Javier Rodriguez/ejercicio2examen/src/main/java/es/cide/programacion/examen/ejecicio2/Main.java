package es.cide.programacion.examen.ejecicio2;

import java.util.Random;
import java.util.Scanner;

//Francisco Javier Rodriguez
//41663903R

public class Main {
    public static void main(String[] args) {
        Random aleatorio= new Random();//Abro un random
        Scanner sc= new Scanner(System.in);//Abro un escaner
        //Seccion de variables
        int finJuego=1;
        int numero=0;
        int i=0;
        String volverJugar;
        int a=0;//bucle si/no
        int b=0;//bucle programa entero
        while (b<1) {//Este bucle repite el programa si el usuario dice que quiere volver a jugar si dice no se cierra todo
            int numeroAleatorio= aleatorio.nextInt(200)+1;//Especifico el rango entre que quiero que eliga el numero -->esta variable se declara aqui<--
        for(i=0; i<finJuego;i++){//Este es el bucle principal, es decir el juego, este bucle repite hasta que se acierte el numero
            System.out.println("Escribe un numero entre el 1 y el 200");
            numero=sc.nextInt(); //Numero del usuario
            while (numero>200 || numero<1) { //Este bucle es para que el usuario no se salga del rango de juego
                System.out.println("El numero debe de estar entre el 1 y el 200, escribelo otra vez");
                numero=sc.nextInt();
            }
            if (numero==numeroAleatorio) { //Primer if, declara el fin del bucle principal y afirma que has acertado el numero
                System.out.println("Has Acertado");
                finJuego--;//Termina el bucle principal
            }
            else if (numero>numeroAleatorio) { //Los siguientes else if declaran si el numero esta mas arriba o abajo
                System.out.println("el numero es mas bajo\n");
            }
            else if (numero<numeroAleatorio) {
                System.out.println("El numero es mas alto\n");
            }
            if (numero+20<numeroAleatorio) { //Los siguientes declaran si es frio o caliente mediante un rango
                System.out.println("frio\n");
            }
            else if (numero-20>numeroAleatorio) {
                System.out.println("frio\n");
            }
            else if (numero+2<numeroAleatorio) {
                System.out.println("caliente\n");
            }
            else if (numero-2>numeroAleatorio) {
                System.out.println("caliente\n");
            }

            finJuego++;//Sumo a esta variable 1, para que se siga repitiendo el bucle principal en caso de que no se haya acertado el numero
        }
        //Resumen de la partida
        System.out.println("Has hecho "+i+" intentos");
        if (i==1) {//Los siguientes if declaran dependiendo de los intentos que hayas hecho te muestra una respuesta
            System.out.println("Eres un Crack\n");
        }
        else if (i>2 && i<10) {
            System.out.println("No esta mal\n");
        }
        else{
            System.out.println("Se puede mejorar\n");
        }
        //Menu final
        System.out.println("-->¿Quieres volver a jugar<--");
        System.out.println("¿si o no?");
        while (a<1) {//Este while es para que el usuario decida si volver a jugar o no
            volverJugar=sc.next().toString();
            if (volverJugar.equals("si")) {//Si el usuario dice de volver a jugar se reinician los valores y se cierra el while "a"
                i=0;
                finJuego=1;
                a++;
            }
            else if (volverJugar.equals("no")) {//Si el usuario niega jugar otra vez se cierran los bucles restantes
                a++;
                b++;
            }
            else{
                System.out.println("Introduce una respuesta correcta si/no");//Respuesta automatica si no es correcto la respuesta
            }
            
        }
        a--;//Reinicia el valor de a, en caso de que se quiera volver a jugar se repita el bucle del menu
        }
    }
}