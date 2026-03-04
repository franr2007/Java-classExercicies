package es.cide.programacion;

import java.util.Random;

//41663903R
//Francisco Javier Rodriguez

public class Guybrush extends Heroi {
    // atributos
    private Random rm = new Random();
    private int responder;
    private String[] listaNueva;

    // constructor
    public Guybrush(String nom, int vida, String respuestas[]) {
        super(nom, vida, respuestas);
        listaNueva = new String[respuestas.length / 2]; //La lista de Guybrush es la mitad de la lista entera de respuestas
    }

    // getters y setters
    @Override
    public int getVida() {
        return super.getVida();
    }

    @Override
    public int getResponder() {
        return responder;
    }

    @Override
    public String getNomHeroi() {
        return super.getNomHeroi();
    }

    public String[] getListaNueva() {
        return listaNueva;
    }

    // metodos
    @Override
    public boolean vida() {//metodo vida
        vida -= 2;//vida resta 2
        if (vida == 0) { //vida igual 0 = (muerto)
            return false;
        } else { //si no sigue (vivo)
            return true;
        }
    }


    @Override
    public void defensar() {//metodo defensar
        boolean listaFin = false;
        int contador = 0;
        boolean arrayBooleanos[] = new boolean[respuestas.length]; //array boleanos para que no se repitan las respuestas en la lista
        while (!listaFin) {//bucle para crear la lista
            int listaAleatoria;
            do {
                listaAleatoria = rm.nextInt(respuestas.length);//se creara un numero aleatorio entre toda la lista
            } while (arrayBooleanos[listaAleatoria]);//si el numero aleatorio que ha tocado se repite se vuelve a hacer el aleatorio de antes
            arrayBooleanos[listaAleatoria] = true;//si no ha tocado, se marca como utilizado
            System.out.println(contador + ". " + respuestas[listaAleatoria]);//se va imprimiendo a medida que tocan
            listaNueva[contador] = respuestas[listaAleatoria];//creo una lista a parte a medida que las respuestas son seleccionadas
            contador++;// el contador suma 1 por cada respuesta
            if (contador == respuestas.length / 2) {//si el contador llega a la mitad de la lista de respuestas
                listaFin = true;//fin del bucle
            }
        }
        boolean fueraLimites = false; // Declaro esta variable para comprobar si escribe algo incorrectamente a la
                                      // hora de jugar
        while (!fueraLimites) {// este while hace que el usuario responda y comprueba esa respuesta dentro

            if (sc.hasNextInt()) { // este if lee el siguiente scanner y devuelve true si es un numero y si no es
                                   // false
                responder = sc.nextInt(); // El usuario da su respuesta
                if (responder < 0 || responder >= respuestas.length) { // se comprueba si esta dentro de los
                                                                       // limites si no muestra lo
                    // siguente
                    System.out.println("\nFuera de los limites, vuelve a escribir el numero\n");
                } else { // Si todo esta bien sale del bucle
                    fueraLimites = true;
                }
            } else { // Si es otra cosa que no
                System.out.println("\nEso no es un numero!\n");
                sc.next(); // hace que no se genere un bucle infinito y que pase
                           // a pedir otra vez el numero
            }

        }

    };

    @Override
    public void sayHello() {//presentacion breve del personaje
        System.out.println(
                "\nGuybrush: ¡Soy el pirata más temido de estas aguas, así que afila tu espada y tu valor, porque mi ingenio corta más que el acero!");
    };

    @Override
    public void sayGoodBye() {//despedida breve del personaje
        System.out.println(
                "Guybrush: La pelea terminó, pero mi leyenda continúa… intenta no contar la historia llorando en la taberna.");
    };
}
