package es.cide.ejemplofor.programacion;

import java.util.Scanner;

//Francisco Javier Rodriguez

public class Main {
        // Taula de multiplicar

        public static void main(String[] args) {

                Scanner lector = new Scanner(System.in);

                System.out.print("Quina taula de multiplicar vols? ");

                int taula = lector.nextInt();

                // El comptador servirà per fer càlculs.

                // En lloc de 'i++' també es podria escriure 'i = i + 1'.

                for (int i = 0; i <= 10; i++) {

                        int resultat = taula * i;

                        System.out.println(taula + " * " + i + " = " + resultat);
                        
                }
                lector.close();
        }
}