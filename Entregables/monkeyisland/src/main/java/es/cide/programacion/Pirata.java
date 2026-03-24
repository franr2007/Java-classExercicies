package es.cide.programacion;

import java.util.Random;

//Francisco Javier Rodriguez

public class Pirata {
    // atributos
    private Random aleatorio = new Random();
    private int vida = aleatorio.nextInt(3) + 1;
    private String insultos[];
    private int insultoAleatorio;
    private boolean correcto;
    private String nomPirata;
    private String insultosPirata[];
    private int insultoAleatorioPirata;
    private boolean nuevoPirata = true;

    // constructor
    public Pirata(String insultos[], String nomPirata) {
        this.insultos = insultos;
        this.nomPirata = nomPirata;
        insultosPirata=new String[3];
    }

    // Getters y setters
    public int getVida() {
        return vida;
    }

    public boolean getCorrecto() {
        return correcto;
    }

    // Metodos
    public void insultar() { //
        while (nuevoPirata) {
            for (int i = 0; i < 3; i++) {
                insultoAleatorio = aleatorio.nextInt(insultos.length);
                insultosPirata[i] = insultos[insultoAleatorio];
            }
            nuevoPirata = false;
        }

        insultoAleatorioPirata = aleatorio.nextInt(3);

        System.out.println("\n" + vida + " vida/s " + nomPirata + ": " + insultosPirata[insultoAleatorioPirata] + "\n");
    }

    public void replica(String comprobarCorrecto) {// El metodo replica coje un valor tipo String
        correcto = false; // Cambio el valor a false al inicio para que se pueda volver a utilizar luego
        if (comprobarCorrecto.equals(insultosPirata[insultoAleatorioPirata])) {// Aqui ese valor String se compara si es
                                                                               // la respuesta correcta de insulto
            correcto = true; // Devuelvo un booleano para luego comprobarlo y utilizarlo en vida
        }
    }

    public int vida() { // Muestra y resta si se le ha quitado vida al pirata
        if (correcto == true) { // Compara el valor anterior y si es correcto
            this.vida = vida - 1; // Le quita 1 vida al pirata
            System.out.println("\nLe has quitado una vida al pirata, sigue asi!");
        } else { // Si no no hace nada
            System.out.println("\nNo le has hecho daño al pirata");
        }
        if (this.vida > 0) {
            System.out.println("El pirata sigue vivo le quedan: " + vida + " vida/s");
        } else if (vida == 0) {
            System.out.println("El pirata esta muerto");
            nuevoPirata=true;
        }
        return vida;
    }
}
