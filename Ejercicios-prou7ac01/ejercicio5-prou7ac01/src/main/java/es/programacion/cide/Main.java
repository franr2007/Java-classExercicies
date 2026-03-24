package es.programacion.cide;

import java.io.File;
import java.util.Scanner;

//Francisco Javier Rodriguez

public class Main {
    public static void main(String[] args) {
        Scanner sc;
        String ruta;
        File archivo;

        sc=new Scanner(System.in);
        System.out.println("pon una ruta");
        ruta= sc.nextLine();
        archivo= new File(ruta);

        if (!archivo.exists()) {
            System.out.println("La ruta no existe");
        }
        else{
            if (archivo.isDirectory()) {
                System.out.println("Es un directorio");
            }
            else{
                System.out.println("Es un archivo");
            }
            if (archivo.canRead()) {
                System.out.println("Tienes permisos de lectura");
            }
            else{
                System.out.println("No tienes permisos de lectura");
            }
            if (archivo.canWrite()) {
                System.out.println("Tienes permisos de escritura");
            }
            else{
                System.out.println("No tienes permisos de escritura");
            }
            System.out.println(archivo.getAbsolutePath());
        }

        sc.close();
    }
}