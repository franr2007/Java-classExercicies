package es.programacion.cide;

import java.io.FileOutputStream;
import java.io.IOException;

//Francisco Javier Rodriguez

public class Main {
    public static void main(String[] args) {
        String texto;
        FileOutputStream archivo;

        archivo= null;

        try {
            texto = "Hola, estic aprenent Java!";
            archivo = new FileOutputStream("datos.txt");
            for (char c : texto.toCharArray()) { // Eso hace que el for recorra cada caracter del texto
                archivo.write(c); //esto escribre el caracter en el archivo datos.txt
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (archivo != null) {
                try {
                    archivo.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}