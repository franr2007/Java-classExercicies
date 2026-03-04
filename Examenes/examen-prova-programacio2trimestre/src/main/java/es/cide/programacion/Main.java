package es.cide.programacion;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Vehicle v=new Vehicle(null, null);

        System.out.println("Rellena lo siguiente para reparar el coche-->");
        System.out.println("\nNombre del propietario:");
        String nomP=sc.nextLine();
        System.out.println("\nNumero del Bastidor:");
        String numB=sc.nextLine();
        System.out.println("Tu coche es electrico? pon -true- para -si- o pon -false- para -no-");
        boolean electrico=sc.nextBoolean();
        Cotxe c=new Cotxe(nomP, numB, electrico);
                    
                
        System.out.println("Rellena lo siguiente para reparar la moto-->");
        System.out.println("\nNombre del propietario:");
        nomP=sc.next();
        System.out.println("\nNumero del Bastidor:");
        numB=sc.next();
        Moto m=new Moto(nomP, numB);
        v.revisarVehicle();
        System.out.println("\nReparando...\n");
        boolean cocheReparado=false;
        boolean motoReparada=false;
        while (!cocheReparado && !motoReparada) {
            if (c.estaLlest() && !cocheReparado) {
                System.out.println("El coche esta listo");
                cocheReparado=true;
            }

            if (m.estaLlest() && !motoReparada) {
                System.out.println("La moto esta lista");
            }
        }
        System.out.println("\n");
        if (electrico) {
            
        }
        c.finalitzarManteniment();
        m.finalitzarManteniment();

    }
}