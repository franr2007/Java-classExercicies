package es.cide.programacion2;

import java.util.Scanner;

//41663903R
//Francisco Javier Rodriguez

public class Main {
    public static void main(String[] args) {
        

    //Ejercicio 8 "Contraseña"
    //Declara una variable String clave

    Scanner sc= new Scanner(System.in);
    System.out.println("Introduce la contraseña:");
    String clave= sc.nextLine();

    if (clave.compareTo("java123")==0){
        System.out.println("Acceso permitido");
    }
    else {
        System.out.println("Acceso denegado");
    }
    sc.close();
    }
}