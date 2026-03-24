package es.cide.programacion14;

import java.util.Random;
import java.util.Scanner;

//Francisco Javier Rodriguez

public class Main {
    public static void main(String[] args) {
        // Explicacion del juego
        System.out.println("Bienvenido a batalla de insultos piratas\n");
        System.out.println(
                "El juego consiste hundir al enemigo que te ha insultado con un insulto aun mayor para ganar,");
        System.out.println(
                "se te daran 3 opciones donde podras insultar al enemigo de varias formas pero solo una de esas 3");
        System.out.println(
                "te servirá para ganar al rival (+2), si pierdes se te restara 1 punto (-1), consigue la mayor puntuacion que puedas");
        // Abro un scaner para poder preguntar al usuario
        Scanner sc = new Scanner(System.in);
        // Declaro variables
        int finJuego = 0;
        int numeroRondas = 0;
        char elegirFin;
        int r = 0;
        // Abro los arrays necesarios para guardar los insultos
        String[] arrayInsultoPirata = { "Mi lengua es más hábil que cualquier espada.",
                "¡ Ordeñaré hasta la última gota de sangre de tu cuerpo !",
                "¡No hay palabras para describir lo asqueroso que eres!",
                "¡He hablado con simios más educados que tu! ", "¡ Eres como un dolor en la parte baja de la espalda !",
                "¡Mi pañuelo limpiará tu sangre!", "¡Ha llegado tu HORA, palurdo de ocho patas!",
                "¿Has dejado ya de usar pañales?", "¡Una vez tuve un perro más listo que tu!",
                "¡Nadie me ha sacado sangre jamás, y nadie lo hará!",
                "Si tu hermano es como tú, mejor casarse con un cerdo.", "¡Tienes los modales de un mendigo!",
                "Mi espada es famosa en todo el Caribe i mi nombre es temido en cada sucio rincón de esta isla !",
                "Veo gente como tú arrastrándose por el suelo de los bares.",
                "¡ Tengo el coraje y la técnica de un maestro !" };
        String[] arrayRespuestasBuenas = { "Primero deberías dejar de usarla como un plumero",
                "Qué apropiado, tú peleas como una vaca.", "Sí que las hay, sólo que nunca las has aprendido.",
                "Me alegra que asistieras a tu reunión familiar diaria.",
                "Ya te están fastidiando otra vez las almorranas, ¿Eh?",
                "Ah, ¿Ya has obtenido ese trabajo de barrendero?", "Y yo tengo un SALUDO para ti, ¿Te enteras?",
                "¿Por qué? ¿Acaso querías pedir uno prestado?", "Te habrá enseñado todo lo que sabes.",
                "¿TAN rápido corres?", "Me haces pensar que alguien ya lo ha hecho.",
                "Quería asegurarme de que estuvieras a gusto conmigo.",
                "Qué pena me da que nadie haya oído hablar de ti", "¿Incluso antes de que huelan tu aliento?",
                "Estaría acabado si la usases alguna vez." };
        String[] arrayRespuestasMalas = { "Tu espada debe estar rota, ¿verdad?",
                "Eso fue… algo, supongo.",
                "Nunca vi un loro tan callado como tú.",
                "¿Seguro que eres un pirata?",
                "Tu sombrero es feo.",
                "Eres más lento que un barco sin viento.",
                "¿Eso es todo lo que sabes decir?",
                "Mi loro es más aterrador que tú.",
                "Tu parche de ojo está sucio.",
                "Eres un desastre navegando.",
                "Tus botas huelen raro.",
                "No sabes diferenciar una espada de un plátano.",
                "Me dormí escuchándote hablar.",
                "Ese no fue un insulto.",
                "Tu barco parece un bote de papel." };
        String[] arrayRespuestasMalas2 = { "Tu barba parece un nido de gaviotas.",
                "Ni un mono te respetaría.",
                "Tus canciones son peores que un mapa sin tesoro.",
                "Eres más inútil que un cañón de juguete.",
                "Tus pantalones están sucios.",
                "Ni siquiera tu loro te escucha.",
                "Tu bote se hundiría en un charco.",
                "Eres más lento que una tortuga con resaca.",
                "Tu parche de ojo parece de cartón.",
                "No asustas ni a un pez.",
                "Tu espada está doblada.",
                "Tus historias son más aburridas que el océano sin olas.",
                "No sabes hacer un nudo.",
                "Pareces un pirata de mentira.",
                "Tu mapa del tesoro es una hoja en blanco." };
        while (finJuego == 0) {// Bucle juego entero hasta que se declare el fin
            r = 0;
            numeroRondas = 0;
            System.out.println("\n¿Cuantas batallas quieres jugar?");
            numeroRondas = sc.nextInt(); // Selecciona la cantidad de rondas que quiere jugar
            int puntaje = 0;
            int elegir = 0;
            int contadorRepetidor=0;
            int repetidos=0;
            int[] arrayReptidos=new int[15];
            while (r < 1) {// Bucle para que el usuario elija un nombre de rondas dentro del limite
                if (numeroRondas < 1 || numeroRondas > 15) {
                    System.out.println("El limite maximo son 15 rondas y el minimo es 1, vuelve a elegir");
                    numeroRondas = sc.nextInt();
                } else {
                    r++;
                }
            }
            // Hago un bucle con la cantidad de rondas seleccionadas
            for (int i = 0; i < numeroRondas; i++) {// bucle principal, se acaba cuando llegue a las rondas indicadas
                Random numeroAleatorio = new Random(); // Abro un random para que seleccione aleatoriamente los insultos
                                                       // de
                                                       // los contricantes
                int numeroRandom = numeroAleatorio.nextInt(15);// Este random se declara para que el numero que salga
                                                               // sea el insulto/respuestas en esa posicion del array
                int posicionBuena = numeroAleatorio.nextInt(3) + 1;// Este random genera la posicion donde estara la
                                                                   // respuesta buena
                contadorRepetidor=0;
                while (contadorRepetidor<1) {
                    repetidos=0;
                    for(int cr=0;cr<14;cr++){
                        if (arrayReptidos[cr]==numeroRandom) {
                            repetidos++;
                        }
                        if (repetidos>0) {
                            
                        }
                    }
                }

                System.out.println("\nRonda numero: " + i + "\n");
                int a = 0;
                while (a < 1) {// Este while coloca la estructura del juego y el puntaje
                    System.out.println("Enemigo Pirata: " + arrayInsultoPirata[numeroRandom]);
                    int b = 0;
                    for (int j = 1; j < 4; j++) {// Este for varia las respuestas dependiendo el random 'posicionBuena'
                        if (j == posicionBuena) {
                            System.out.println(j + ". " + arrayRespuestasBuenas[numeroRandom]);
                        } else if (b == 0) {
                            System.out.println(j + ". " + arrayRespuestasMalas[numeroRandom]);
                            b++;
                        } else {
                            System.out.println(j + ". " + arrayRespuestasMalas2[numeroRandom]);
                        }
                    }
                    System.out.println("\n--> Pulsa el numero 0 para salir <--");
                    System.out.println("\nSelecciona una opcion: ");
                    elegir = sc.nextInt();
                    int c = 0;
                    while (c < 0) {// While que fuerza al usuario a elegir el numero bien
                        if (elegir < 0 || elegir > 3) {
                            System.out.println("Escribe de nuevo el numero, te has equivocado");
                            elegir = sc.nextInt();
                        } else {
                            c++;
                        }
                    }
                    if (elegir == posicionBuena) {// Estos if puntuan segun si la respuesta es buena o mala, si
                                                  // respondes 0 sale.
                        System.out.println("Te has defendido bien (+2p)");
                        puntaje += 2;
                    } else if (elegir == 0) {
                        System.out.println("Saliendo...");
                        System.exit(0);
                    } else {
                        System.out.println("meh (-1p)");
                        puntaje -= 1;
                    }
                    a++;
                }
            }
            //sistema puntaje
            System.out.println("\nTu puntaje es: " + puntaje);
            if (puntaje >= 10) {//Segun tu puntaje te dice algo
                System.out.println("Eres un crack!");
            } else if (puntaje <= 3) {
                System.out.println("Se puede mejorar...");
            } else {
                System.out.println("Te has defendido como un buen pirata!");
            }
            do {//bucle para obligar al usuario elegir entre si seguir jugando o no
                System.out.println("\n¿Deseas volver a jugar?");
                System.out.println("S/N");
                elegirFin = sc.next().toLowerCase().charAt(0);

                if (elegirFin != 'n' && elegirFin != 's') {//Suelta un mensaje en caso de equivocacion
                    System.out.println("Elije el caracter correctamente, S para seguir jugando o N para salir");
                }
            } while (elegirFin != 'n' && elegirFin != 's');//Este bucle seguira ejecutando lo que este en el do hasta que sea s o n
            if (elegirFin == 'n') {//If para terminar el juego segun la respuesta del jugador
                System.out.println("Saliendo...");
                finJuego++;
            }
        }
        sc.close();
    }
}