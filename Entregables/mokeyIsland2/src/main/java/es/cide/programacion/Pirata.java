package es.cide.programacion;

import java.util.Random;

//41663903R
//Francisco Javier Rodriguez

public class Pirata extends Personatge implements Fight, Speak {
    // Atributos
    private Random aleatorio = new Random();
    protected String insultos[];
    protected int insultoAleatorio;
    protected String insultosPirata[];
    protected boolean nuevoPirata;
    protected String contraRespuesta[];

    // Constructor
    public Pirata(String nom, int vida, String insultos[], String contraRespuesta[]) {
        super(nom, vida);
        this.insultos = insultos;
        this.contraRespuesta = contraRespuesta;
        insultosPirata = new String[3]; // Rueda de 3 insultos que tendra el pirata
        nuevoPirata = true; // Siempre al inicio de la partida el pirata siempre sera nuevo
            for (int i = 0; i < 3; i++) { // Se selecciona aleatoriamente los 3 insultos que tendra
                insultoAleatorio = aleatorio.nextInt(insultos.length);// Se selecciona un numero aleatorio para
                                                                      // assignarle a la siguiente posicion del array
                insultosPirata[i] = insultos[insultoAleatorio]; // Array de 3 insultos del pirata
            }
    }

    // Getters y setters
    public int getVida() {
        return vida;
    }

    public void setNuevoPirata(boolean nuevoPirata) {
        this.nuevoPirata = nuevoPirata;
    }

    // Metodos
    @Override
    public boolean vida() {
        vida--; // Le quita 1 vida al pirata
        if (vida == 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void insultar() {
        insultoAleatorio = aleatorio.nextInt(insultosPirata.length); // Este random genera de 0-2 y se mueve en el array
                                                                     // del insulto
        // de pirata

        System.out.println("\n" + vida + " vida/s " + nom + ": " + insultosPirata[insultoAleatorio] + "\n"); // Muestra
                                                                                                             // el
                                                                                                             // insulto
    };

    public boolean replica(String respuesta) {
        boolean fin = false;
        int contador = 0;
        while (!fin) {// bucle para encontrar la respuesta correcta
            if (insultos[contador].equals(insultosPirata[insultoAleatorio])) {// se busca el mismo insulto que se ha
                                                                              // proyectado
                fin = true;// Si se encuentra sale del bucle
            } else {
                contador++;// suma al contador para recorrer los insultos
            }
        }
        if (respuesta.equals(contraRespuesta[contador])) {// se compara la respuesta del jugador con la respuesta que es
                                                          // correcta
            return true;// si es (correcta) se devuelve true
        } else {
            return false;// si es false es (incorrecta)
        }

    }

    @Override
    public void defensar() { // Pirata no se defiende
    };

    @Override
    public void sayHello() {// presentacion breve de pirata
        System.out.println("\n" + nom + ": ¡Ahoy, rata de cubierta!\n");
    };

    @Override
    public void sayGoodBye() {// despedida breve de pirata
        System.out.println("\n" + nom + ": ¡Que los tiburones te lleven bien lejos!\n");
    };
}
