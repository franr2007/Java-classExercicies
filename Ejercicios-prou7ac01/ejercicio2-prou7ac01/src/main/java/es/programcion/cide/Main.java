package es.programcion.cide;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

//41663903R
//Francisco Javier Rodriguez Magaña
//17-03-26

public class Main {
    public static void main(String[] args) {
        Scanner sc;
        File directorio;
        String ruta;

        sc = new Scanner(System.in);
        ruta = sc.nextLine();
        directorio = new File(ruta);

        try {
            if (!directorio.exists()) {
                directorio.mkdirs();
                File archivo = new File(directorio, "hola.txt");
                archivo.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("La ruta no existe o no es un directorio");
        }
        sc.close();
    }
}