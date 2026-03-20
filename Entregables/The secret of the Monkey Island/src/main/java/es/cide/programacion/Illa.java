package es.cide.programacion;

import java.util.Random;

//41663903R
//Francisco Javier Rodriguez

public class Illa {
    // atributos
    private Random aleatorio = new Random();
    private int seleccioPirates;
    private int rondaPirates; //Esto va en el main
    private Pirata[] arrayPirates;
    private String[] arrrayIlla;//Esto va en el main
    private String nomIlla;
    private String nomPirata;
    private boolean[] usado;
    private String[] nomPirates;//Esto va en el main
    private String insultos[];//Esto va en el main
    private int nombreAleatorio;

    // Constructor
    public Illa(String insultos[]) {
        arrrayIlla = new String[] { "Cuba", "La Española", "Jamaica", "Puerto Rico", "Barbados", "Trinidad",
                "Granada" }; // Nombres que puede tener la isla

        nomPirates = new String[] { "Barbanegra el Despeinado", "Capitán Tuertón McMueca", "Madame Calamidad",
                "Huesos Bill", "Clemente Rumbaugh", "El Temible Ernesto del Pantano", "Capitán Cuchillín de Azúcar" }; //Nombre de los piratas

        this.insultos=insultos; //Insultos de los piratas

        seleccioPirates = aleatorio.nextInt(6) + 1;// Random del 1-7 que elige que nombre del pirata va a salir
        arrayPirates = new Pirata[seleccioPirates];

        nomIlla = arrrayIlla[seleccioPirates]; // El nombre de la isla se genera segun el numero que salga en
                                               // seleccionPirates
        usado = new boolean[arrayPirates.length]; // Array de booleanos que hacen que no se repitan los piratas

        
        for (int i = 0; i < seleccioPirates; i++) {
            do {
                nombreAleatorio = aleatorio.nextInt(nomPirates.length);
            } while (usado[seleccioPirates]); // Elije el nombre del pirata aleatoriamente y que no sea repetido
            nomPirata = nomPirates[nombreAleatorio];
            usado[seleccioPirates] = true; // El pirta que salga se mostrara como usado = (True)
            arrayPirates[i] = new Pirata(insultos, nomPirata);
        }
    }

    // getters y setters

    public String getNomPirata() {
        return nomPirata;
    }

    public int getRondaPirates() {
        return rondaPirates;
    }

    public String getNomIlla() {
        return nomIlla;
    }

    // metodos
    public Pirata vullUnPirata(int rondaPiratas) { // Recoge un pirata

        return arrayPirates[rondaPiratas]; // Devuelve el nuevo pirata
    }

}
