package es.cide.programacion;

import java.util.Scanner;

//Francisco Javier Rodriguez

public class Main {
        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                // Atributos + arrays principales
                String insultos[] = { "Mi lengua es más hábil que cualquier espada.",
                                "¡ Ordeñaré hasta la última gota de sangre de tu cuerpo !",
                                "¡No hay palabras para describir lo asqueroso que eres!",
                                "¡He hablado con simios más educados que tu! ",
                                "¡ Eres como un dolor en la parte baja de la espalda !",
                                "¡Mi pañuelo limpiará tu sangre!", "¡Ha llegado tu HORA, palurdo de ocho patas!",
                                "¿Has dejado ya de usar pañales?", "¡Una vez tuve un perro más listo que tu!",
                                "¡Nadie me ha sacado sangre jamás, y nadie lo hará!", };
                String respuestas[] = { "Primero deberías dejar de usarla como un plumero.",
                                "Qué apropiado, tú peleas como una vaca.",
                                "Sí que las hay, sólo que nunca las has aprendido.",
                                "Me alegra que asistieras a tu reunión familiar diaria.",
                                "Ya te están fastidiando otra vez las almorranas, ¿Eh?",
                                "Ah, ¿Ya has obtenido ese trabajo de barrendero?",
                                "Y yo tengo un SALUDO para ti, ¿Te enteras?",
                                "¿Por qué? ¿Acaso querías pedir uno prestado?", "Te habrá enseñado todo lo que sabes.",
                                "¿TAN rápido corres?" };
                String numeroCorrecto;
                Pirata pirata;// Clase del constructor Pirata
                boolean nuevoPirata;
                boolean correcto;

                // Explicacion juego
                System.out.println(
                                "En este juego te enfrentarás a entre 3 y 7 piratas que intentarán hundirte con insultos.");
                System.out.println(
                                "Cada pirata te lanzará una frase ofensiva, y tú deberás responder con el insulto correcto de tu lista.\n");
                System.out.println("Si aciertas la respuesta, el pirata perderá 1 vida.");
                System.out.println("Si fallas, tú perderás 1 vida.\n");
                System.out.println(
                                "El combate continúa hasta que todos los piratas hayan sido derrotados o hasta que tú te quedes sin vidas.\n");

                // Se Muesrtan, se construyen y se declaran las variables principales
                System.out.print("Cual es tu nombre pirata?");
                Heroi heroe = new Heroi(sc.next(), 10, respuestas); // Clase del constructor Heroe

                System.out.print("Bienvenido " + heroe.getNom() + "\n");

                Illa illa = new Illa(insultos); // Clase del constructor Isla

                System.out.println("\nTu nombre es: " + heroe.getNom() + ", tienes " + heroe.getVida() + " vidas\n");

                System.out.println(
                                "Bienvenido a " + illa.getNomIlla() + " aqui te enfrentaras a " + illa.getRondaPirates()
                                                + " temibles piratas, buena suerte " + heroe.getNom() + "\n");

                // JUEGO
                for (int i = 0; i < illa.getRondaPirates(); i++) { // For que se repite la cantidad de piratas que haya
                                                                   // en la isla
                        pirata = illa.vullUnPirata(i);// Genera un pirata cada ronda
                        while (pirata.getVida() != 0 && heroe.getVida() != 0) { // While que se repite hasta que heroe o
                                                                                // pirata se mueran
                                pirata.insultar();// Metodo de pirata que insulta

                                heroe.defensar(sc);// Metodo que genera toda la lista de respuestas a los insultos

                                numeroCorrecto = insultos[heroe.getResponder()];// Cojo el número de la respuesta del
                                                                                // pirata, saco el insulto que le toca y
                                                                                // lo comparo con el de réplica.

                                correcto = pirata.replica(numeroCorrecto); // Variable que recoje y hace el metodo

                                if (correcto == true) { // si es correcto
                                        pirata.vida(); // se le resta vida al pirata
                                        System.out.println("\nLe has quitado una vida al pirata, sigue asi!");
                                } else { // Si no no hace nada
                                        System.out.println("\nNo le has hecho daño al pirata");
                                }
                                if (pirata.getVida() > 0) { // si la vida de pirata es mayor que 0
                                        System.out.println("El pirata sigue vivo le quedan: " + pirata.getVida()
                                                        + " vida/s"); // muestra cuanta vida le queda al pirata

                                } else if (pirata.getVida() == 0) { // y si es 0
                                        System.out.println("El pirata esta muerto");// muestra que esta muerto
                                        pirata.setNuevoPirata(true);// y cambia el valor de esta variable a true
                                                                    // dentro hace que genere 3 insultos nuevos para el
                                                                    // siguiente pirata
                                }

                                heroe.setCorrecto(pirata.replica(numeroCorrecto));// Recoje una variable tipo-b que
                                                                                  // indica si es correcta la respuesta
                                                                                  // o no

                                nuevoPirata = heroe.vida(); // Variable que recoje y hace el metodo

                                if (nuevoPirata == true) { // Comparo la variable anterior si es true
                                        System.out.println("estas muerto"); // significa que esta muerto
                                } else if (heroe.getCorrecto() == false) { // si el metodo replica devuelve false
                                        System.out.println("\nEl pirata te ha quitado vida (-1), te queda: "
                                                        + heroe.getVida() + " vida/s\n"); // si la respuesta es incorrecta, muestra lo anterior
                                } else {
                                        System.out.println("\nEl pirata no te ha quitado vida, aun tienes: "
                                                        + heroe.getVida() + " vida/s\n"); // Si la respuesta es correcta, muestra lo anterior
                                }

                        }
                        if (heroe.getVida() == 0) { // si la vida del heroe es 0 
                                i = illa.getRondaPirates(); // i sera igual a las rondas y terminara el juego
                        }
                }
                if (heroe.getVida() != 0) {// si el pirata sigue con vida y ha terminado el juego muestra lo siguente
                        System.out.println("¡Has ganado " + heroe.getNom()
                                        + " enhorabuena! has vencido a todos los piratas de "
                                        + illa.getNomIlla() + " y te has hecho con ella");
                } else { //si no Game over
                        System.out.println("GAME OVER...(Resetea el programa para volver a jugar)");
                }
                sc.close(); //se cierra el scanner
        }

}