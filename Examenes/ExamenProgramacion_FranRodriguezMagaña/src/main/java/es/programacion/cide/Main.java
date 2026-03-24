package es.programacion.cide;

//Francisco Javier Rodriguez

public class Main {
    public static void main(String[] args) {
        // atributos
        Torrada torrada = new Torrada("Sant Sebastià", "2025");
        Botifarro botifarro = new Botifarro("Sant Sebastià", "2025");
        Sobrassada sobrassada = new Sobrassada("Sant Sebastià", "2025");
        boolean botifarroLlest;
        boolean sobrassadaLlest;

        // Programa Principal
        System.out.println("Benvinguts a la torrada de " + torrada.getFestivitat() + " " + torrada.getAny() + ".");
        System.out.println("He comprat un botifarró.");
        System.out.println("He comprat una sobrassada.");

        botifarro.posarCarnAGraella();
        sobrassada.posarCarnAGraella();

        botifarroLlest = botifarro.estaFet();// hago estas variables para no inicalizar el metodo cada vez que compare
        sobrassadaLlest = sobrassada.estaFet();
        System.out.println("Vaig a mirar si estan fests:");
        while (!botifarroLlest || !sobrassadaLlest) { // bucle, termina cuando las piezas esten listas
            if (!sobrassadaLlest) { // si sobrassada no esta hecha
                sobrassadaLlest = sobrassada.estaFet(); // se vuelve a hacer el metodo para que haya probabilidad de que
                                                        // se haga la pieza
            }
            if (!botifarroLlest) { // lo mismo con este
                botifarroLlest = botifarro.estaFet();
            }

            if (sobrassadaLlest && botifarroLlest) { // Por cada variante que pueda haber se ha hecho un print
                System.out.println("El botifarró està fet i la sobrassada està fet. Ja puc anar a sopar.");
            } else if (sobrassadaLlest && !botifarroLlest) {
                System.out.println("El botifarró està cru i la sobrassada està fet. He d’esperar.");
            } else if (botifarroLlest && !sobrassadaLlest) {
                System.out.println("El botifarró està fet i la sobrassada està cru. He d’esperar.");
            } else {
                System.out.println("El botifarró està cru i la sobrassada està cru. He d’esperar.");
            }
        }

        if (botifarro.getCoent()) { // botifarro puede ser coent o no coent, estonces hay dos print diferentes para
                                    // cada uno
            botifarro.assaborir();
            System.out.println(" y es coent"); //aqui se le añade esto si es coent
        } else {
            botifarro.assaborir();
            System.out.println(""); //Si no es coent no se le añade nada, se utiliza como \n
        }
        if (botifarro.crema()) {//Las piezas pueden quemar, si quema
            System.out.println("El botifarro crema!!");//Se imprime esto
        }

        sobrassada.assaborir();//Sobrassada no tiene diferentes variantes

        if (sobrassada.crema()) {//If para saber si la sobrassada quema
            System.out.println("La sobrassada crema!!");
        }
        System.out.println("Au, ja està tot fet! Visca " + torrada.getFestivitat() + "!");
    }
}