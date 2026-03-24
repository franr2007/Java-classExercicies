package es.cide.programacion;

import java.util.Scanner;

//Francisco Javier Rodriguez

public class Main {
    public static void main(String[] args) {
        // Atributos
        Scanner sc = new Scanner(System.in);
        String respuestas[] = new String[] { "Primero deberías dejar de usarla como un plumero.",
                "Qué apropiado, tú peleas como una vaca.",
                "Sí que las hay, sólo que nunca las has aprendido.",
                "Me alegra que asistieras a tu reunión familiar diaria.",
                "Ya te están fastidiando otra vez las almorranas, ¿Eh?",
                "Ah, ¿Ya has obtenido ese trabajo de barrendero?",
                "Y yo tengo un SALUDO para ti, ¿Te enteras?",
                "¿Por qué? ¿Acaso querías pedir uno prestado?", "Te habrá enseñado todo lo que sabes.",
                "¿TAN rápido corres?", "Y yo he visto babosas con más dignidad que tú.",
                "Tu cerebro está en huelga y aun así no me preocupa.",
                "Ni los buitres perderían su tiempo contigo.",
                "El Caribe te vomita de vergüenza.",
                "Mi espada tiembla de risa por tu incompetencia.",
                "Ni la muerte quiere cargar contigo, y yo menos." };
        String insultos[] = new String[] { "Mi lengua es más hábil que cualquier espada.",
                "¡ Ordeñaré hasta la última gota de sangre de tu cuerpo !",
                "¡No hay palabras para describir lo asqueroso que eres!",
                "¡He hablado con simios más educados que tu! ",
                "¡ Eres como un dolor en la parte baja de la espalda !",
                "¡Mi pañuelo limpiará tu sangre!", "¡Ha llegado tu HORA, palurdo de ocho patas!",
                "¿Has dejado ya de usar pañales?", "¡Una vez tuve un perro más listo que tu!",
                "¡Nadie me ha sacado sangre jamás, y nadie lo hará!", };
        String contraRespuesta[] = new String[] { respuestas[0], respuestas[1], respuestas[2], respuestas[3],
                respuestas[4], respuestas[5], respuestas[6], respuestas[7], respuestas[8], respuestas[9] };
        String insultosLechunk[] = new String[] { "He visto babosas marinas con más valentía que tú, gusano.",
                "Tu cerebro debe estar en huelga desde que naciste.",
                "Cuando acabe contigo, ni los buitres te querrán.",
                "Eres el pirata más patético que haya pisado el Caribe.",
                "Tu espada tiembla… igual que tus piernas.",
                "Te mandaré al más allá sin billete de vuelta." };
        String contraRespuestaLeChunk[] = new String[] { respuestas[10], respuestas[11], respuestas[12], respuestas[13],
                respuestas[14], respuestas[15] };
        String nombrePiratas[] = new String[] { "Barbanegra el Despeinado", "Capitán Tuertón McMueca",
                "Madame Calamidad",
                "Huesos Bill", "Clemente Rumbaugh", "El Temible Ernesto del Pantano", "Capitán Cuchillín de Azúcar" };
        String arrayNomsIlla[] = new String[] { "Cuba", "La Española", "Jamaica", "Puerto Rico", "Barbados", "Trinidad",
                "Granada" };
        int numeroPirata = 0;
        boolean fin = false;
        Heroi jugador = new Guybrush(null, 10, respuestas);
        Pirata p;
        int rondas;
        String listaNueva[] = jugador.getListaNueva();
        boolean victoria = true;

        System.out.println("=== Cómo jugar ===\n" +
                "Te enfrentarás a varios piratas en duelos de insultos.\n" +
                "En cada ronda, el pirata te insultará y deberás elegir la mejor réplica.\n" +
                "Si eliges la respuesta correcta, el pirata pierde una vida.\n" +
                "Si fallas, pierdes tú una vida.(Solo con Elaine)\n" +
                "O\n" +
                "Si fallas, pierdes tú 2 vidas. (Solo con Guybrush)\n" +
                "Gana quien deje al otro sin vidas.\n" +
                "Derrota a todos los piratas para ganar la partida.\n" +
                "¡Buena suerte!\n");

        while (!fin) { // Eleccion personaje
            System.out.println(
                    "Seleccion de personaje: pulsa 0 para escoger a -Elaine- o cualquier otro numero para escoger a -Guybrush-");
            System.out.println("--> Elaine");
            System.out.println("--> Guybrush\n");
            if (sc.hasNextInt()) { // Si el Scanner siguiente contiene un numero pasara a la seleccion del
                                   // personaje
                int elegirPersonaje = sc.nextInt();
                if (elegirPersonaje == 0) { // 0 para elegir a Elaine
                    jugador = new Elaine("Elaine", 10, respuestas);
                    jugador.sayHello();// pirata saluda
                    fin = true;// se acaba el bucle
                } else { // cualquier otro numero para elegir a Guybrush
                    jugador = new Guybrush("Guybrush", 10, respuestas);
                    jugador.sayHello();// pirata saluda
                    fin = true;// se acaba el bucle
                }
                fin = true;
            } else { // Si el Scanner no es un numero, saltara este error hasta que se ponga un
                     // numero
                System.out.println("eso no es un numero prueba otra vez");
                sc.next();
            }
        }
        System.out.println("Tienes " + jugador.getVida() + " vida(s)\n");

        // juego
        Illa illa = new Illa(insultos, contraRespuesta, insultosLechunk, contraRespuestaLeChunk, nombrePiratas,
                arrayNomsIlla);

        rondas = illa.getNumPiratas();// Las rondas es el numero maximo de piratas en la partida
        System.out.println("Bienvenido a " + illa.getNomIlla() + " aqui tendras que luchar contra " + rondas + "\n");
        fin = false;
        while (!fin && numeroPirata < rondas) { // bucle del juego, se acaba si una de las dos condiciones se cumple
            System.out.println("\nRonda numero: " + numeroPirata + "\n");
            p = illa.vullUnPirata(numeroPirata);// Recogo un pirata, numeroPirata sirve como contador para moverse entre
                                                // los distintos piratas
            p.sayHello(); // Pirata saluda
            while (p.getVida() != 0 && jugador.getVida() != 0) { // bucle Ronda, se acaba hasta que el pirata o el
                                                                 // jugador pierda
                p.insultar();// Pirata insulta
                jugador.defensar();// Muestra la lista de insultos contra los piratas
                int respuestaJ = jugador.getResponder();// se recoje la respuesta del jugador
                listaNueva = jugador.getListaNueva();// y como las lista especialmente la de Guybrush es aleatoria hay
                                                     // que actualizarla para que el orden sea el correcto
                if (p.replica(listaNueva[respuestaJ])) {// Si replica devuelve true (Acierto), se le resta vida al
                                                        // pirata
                    if (p.vida()) {// si la vida del pirata es igual a 0
                        p.sayGoodBye();// pirata se despide
                    }
                } else {
                    if (!jugador.vida()) {// si el metodo vida es igual a 0 y devuelve false (el jugador muere)
                        fin = true;// fin del bucle
                        victoria = false;// No hay victoria
                    }
                }
                System.out.println("Te quedan " + jugador.getVida() + " vida(s)\n");// despues de cada respuesta se
                                                                                    // muestra la vida que te queda
            }
            numeroPirata++;// se cambia al siguiente pirata
        }
        if (victoria) { // Si victoria sigue siendo true (Ganas)
            System.out.println("Has ganado. Nadie resultó herido… salvo el orgullo de tus enemigos.");
        } else {// si no, no
            System.out.println("\nHas sido derrotado...");
            jugador.sayGoodBye();// jugador se despide
        }
        sc.close();// Scanner se cierra
    }
}