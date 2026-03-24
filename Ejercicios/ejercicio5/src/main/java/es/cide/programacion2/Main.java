package es.cide.programacion2;

import java.util.Scanner;

//Francisco Javier Rodriguez

public class Main {
   public static void main(String[] args) {

      // Ejercicio 4 "Dia de la semana"
      // Declara una variable entera dia (1 al 7)

      Scanner sc = new Scanner(System.in);
      System.out.println("Introduce un numero entre el 1 al 7");
      int dia = sc.nextInt();

      switch (dia) { //La funcion del switch es la misma que el if, pero se utiliza para mas tener mas condiciones
         case 1:
            System.out.println("Lunes");
            break;
         case 2:
            System.out.println("Martes");
            break;
         case 3:
            System.out.println("Miercoles");
            break;
         case 4:
            System.out.println("Jueves");
            break;
         case 5:
            System.out.println("Viernes");
            break;
         case 6:
            System.out.println("sabado");
            break;
         case 7:
            System.out.println("Domingo");
            break;
         default:
            System.out.println("Dia no valido");
            break;
      }
      sc.close();
   }
}