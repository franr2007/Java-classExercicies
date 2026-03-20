package es.programacion.cide;

import java.io.File;
import java.util.Scanner;

//41663903R
//Francisco Javier Rodriguez Magaña
//17-03/26

public class Main {
    public static void main(String[] args) {
        // atributos
        Scanner sc;
        String ruta;
        File directorio;

        sc = new Scanner(System.in);
        System.out.println("Pun una ruta (assegurese que sus directorios no tengan accento)");
        ruta = sc.nextLine();
        directorio= new File(ruta);

        try {
            if (directorio.exists() && directorio.isDirectory()) {
            String[] contenido = directorio.list();
            for(String archivo:contenido){
                System.out.println(archivo);
            }
        }
        } catch (Exception e) {
            System.out.println("La ruta no existe o no es un directorio");
        }
        
        sc.close();
    }
}