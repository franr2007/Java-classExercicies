package es.cide.programacion;

import java.util.Random;

//Francisco Javier Rodriguez

public class LeChunk extends Pirata {

    // Atributos
    private Random aleatorio = new Random();
    private String[] insultosLeChunk;
    private String[] contraRespuestaLC;

    // constructor
    public LeChunk(String nom, int vida, String insultos[], String contraRespuesta[], String insultosLeChunk[],
            String contraRespuestaLC[]) {
        super(nom, vida, insultos, contraRespuesta);
        this.insultosLeChunk = insultosLeChunk;
        this.contraRespuestaLC = contraRespuestaLC;
        insultosPirata = new String[4]; // Rueda de 4 insultos que tendra el pirata
        nuevoPirata = true; // Siempre al inicio de la partida el pirata siempre sera nuevo
        for (int i = 0; i < insultosPirata.length; i++) { // Se selecciona aleatoriamente los 3 insultos que
                                                          // tendra
            insultoAleatorio = aleatorio.nextInt(insultos.length);// Se selecciona un numero aleatorio para
                                                                  // assignarle a la siguiente posicion del array
            insultosPirata[i] = insultos[insultoAleatorio]; // Array de 4 insultos del pirata
        }
        insultoAleatorio = aleatorio.nextInt(insultosLeChunk.length);// se genera un numero aleatorio del largo de la
                                                                     // lista de insultos de lechunk
        insultosPirata[insultosPirata.length - 1] = insultosLeChunk[insultoAleatorio];// Y se añade a la ultima posicion
                                                                                      // un insulto especial de los de
                                                                                      // lechunk

    }

    // getters y setters

    // Metodos
    @Override
    public boolean vida() {
        return super.vida();
    }

    @Override
    public void insultar() {// metodo insultar

        insultoAleatorio = aleatorio.nextInt(insultosPirata.length); // Este random genera de 0-3 y se mueve en el array
                                                                     // del insulto de pirata

        System.out.println("\n" + vida + " vida/s " + nom + ": " + insultosPirata[insultoAleatorio] + "\n"); // Muestra
                                                                                                             // el
                                                                                                             // insulto
    }

    @Override
    public boolean replica(String respuesta) {// metodo replica
        String respuestaCorrecta = "";
        for (int i = 0; i < insultos.length; i++) {// bucle para encontrar el insulto
            if (insultos[i].equals(insultosPirata[insultoAleatorio])) {// se busca el mismo insulto que se ha proyectado
                respuestaCorrecta = contraRespuesta[i];// si se encuentra se copia la respuesta correcta de ese insulto
            }
        }
        for (int j = 0; j < insultosLeChunk.length; j++) {// bucle para encontrar el insulto de Lechunk, es lo mismo
                                                          // pero con los insultos de lechunk
            if (insultosLeChunk[j].equals(insultosPirata[insultoAleatorio])) {
                respuestaCorrecta = contraRespuestaLC[j];
            }
        }
        if (respuesta.equals(respuestaCorrecta)) {// se compara la respuesta del jugador con la respuesta que es
                                                  // correcta
            return true;// si es (correcta) se devuelve true
        } else {
            return false;// si es false es (incorrecta)
        }
    }

    @Override
    public void defensar() {// pirata no usa este metodo
    }

    @Override
    public void sayHello() {// presentacion breve de lechunk
        System.out.println("\nLeChunk: ¡Ja ja ja! ¡Salud, miserable humano, antes de tu perdición!\n");
    }

    @Override
    public void sayGoodBye() {// despedida breve de lechunk
        System.out.println("\nLeChunk: ¡Adiós, cobarde! ¡Nos encontraremos en las profundidades del Caribe!\n");
    }
}
