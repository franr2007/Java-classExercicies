package es.programacion.cide;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

//Francisco Javier Rodriguez

public class Main {
    public static void main(String[] args) {
        Scanner sc;
        String txtArchivo;
        FileInputStream archivo;
        int leerByte;
        int contadorBytes;

        sc = new Scanner(System.in);
        txtArchivo = sc.nextLine();
        contadorBytes=0;

        try {
            archivo = new FileInputStream(txtArchivo);

            while ((leerByte = archivo.read()) != -1) {
                System.out.print((char) leerByte);
                contadorBytes++;
            }

            System.out.println("\nNumero de bytes totales: "+contadorBytes);

            archivo.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        sc.close();
    }
}