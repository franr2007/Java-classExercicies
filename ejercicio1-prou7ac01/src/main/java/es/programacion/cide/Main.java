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
        ruta = sc.nextLine();
        directorio= new File(ruta);

        if (directorio.exists() && directorio.isDirectory()) {
            String[] contenido = directorio.list();
            for(String archivo:contenido){
                System.out.println(archivo);
            }
        }
        else{
            System.out.println("La ruta no existe o no es un directorio");
        }
        
        sc.close();
    }
}