package es.cide.programacion;

//41663903R
//Francisco Javier Rodriguez

public class Elaine extends Heroi {
    // atributos
    private int responder;

    // Constructor
    public Elaine(String nom, int vida, String respuestas[]) {
        super(nom, vida, respuestas);
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

    @Override
    public String[] getListaNueva() {
        return respuestas;
    }

    // metodos
    @Override
    public boolean vida() { //metodo vida
        vida--; //cada vez que se use restara una vida al pirata
        if (vida == 0) { //si vida es 0
            return false;//devuelve falase (muerto)
        } else {
            return true;//Si no devuelve true (vivo)
        }
    }

    @Override
    public void defensar() {// Muestra todas la lista de respuestas en orden al array y devuelve la
                            // respuesta del usuario
        int contador = 0;
        for (int i = 0; i < respuestas.length; i++) {// Recorre el array de respuestas 1 x 1
            System.out.println(contador + ". " + respuestas[i]); // Imprime la respuesta
            contador++;
        }
        boolean fueraLimites = false; // Declaro esta variable para comprobar si escribe algo incorrectamente a la
                                      // hora de jugar
        while (fueraLimites == false) {// este while hace que el usuario responda y comprueba esa respuesta dentro

            if (sc.hasNextInt()) { // este if lee el siguiente scanner y devuelve true si es un numero y si no es
                                   // false
                responder = sc.nextInt(); // El usuario da su respuesta
                if (responder < 0 || responder >= respuestas.length) { // se comprueba si esta dentro de los limites si
                                                                       // no muestra lo
                    // siguente
                    System.out.println("\nFuera de los limites, vuelve a escribir el numero\n");
                } else { // Si todo esta bien sale del bucle
                    fueraLimites = true;
                }
            } else { // Si es otra cosa que no
                System.out.println("\nEso no es un numero!\n");
                sc.next(); // lee, descarta la palabra, hace que no se genere un bucle infinito y hace que
                           // luego pida otra vez el numero
            }

        }
    }

    @Override
    public void sayHello() { //presentacion breve del personaje
        System.out.println(
                "\nElaine: Bienvenido pirata. Confío en que sabrás comportarte mientras estés en mi jurisdicción.");
    }

    @Override
    public void sayGoodBye() {//despedida breve del personaje
        System.out.println(
                "Elaine: Que tengas un buen viaje, pirata. Y recuerda: la ley sigue vigente en cada rincón de estas islas.");
    }

}
