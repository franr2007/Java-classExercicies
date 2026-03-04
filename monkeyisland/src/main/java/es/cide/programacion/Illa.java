package es.cide.programacion;

import java.util.Random;

//41663903R
//Francisco Javier Rodriguez

public class Illa {
    // atributos
    private Random aleatorio = new Random();
    private int seleccioPirates;
    private int rondaPirates;
    private String[] arrayPirates;
    private String[] arrrayIlla;
    private String nomIlla;
    private String nomPirata;
    private boolean[] usado;

    // Constructor
    public Illa() {
        arrrayIlla = new String[] { "Cuba", "La Española", "Jamaica", "Puerto Rico", "Barbados", "Trinidad",
                "Granada" };
        this.arrayPirates = new String[] { "Barbanegra el Despeinado", "Capitán Tuertón McMueca", "Madame Calamidad",
                "Huesos Bill",
                "Clemente Rumbaugh", "El Temible Ernesto del Pantano", "Capitán Cuchillín de Azúcar" };
        nomIlla = arrrayIlla[seleccioPirates];
        nomPirata = arrayPirates[seleccioPirates];
        usado = new boolean[arrayPirates.length];
        rondaPirates = aleatorio.nextInt(4) + 3;// Random que selecciona cuantos piratas van a jugar, es decir el nuermo
                                                // de rondas 3-7
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
    public Pirata vullUnPirata(String[] insultosPirata) {
        do {
            seleccioPirates = aleatorio.nextInt(7);// Random del 0-6 que elige que nombre del pirata va a salir
        } while (usado[seleccioPirates]);

        usado[seleccioPirates] = true;

        System.out.println("Pirata: " + arrayPirates[seleccioPirates]);
        nomPirata = arrayPirates[seleccioPirates];
        Pirata pirata = new Pirata(insultosPirata, nomPirata);
        
        return pirata;
    }

}
