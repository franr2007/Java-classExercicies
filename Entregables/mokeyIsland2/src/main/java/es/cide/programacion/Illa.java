package es.cide.programacion;

import java.util.Random;

//Francisco Javier Rodriguez

public class Illa {
    // atributos
    private Random rm = new Random();
    private int nombreIllaAleatorio;
    private int numPiratas;
    private Pirata[] arrayPiratas;
    private String[] arrayIllaNoms;
    private String nomIlla;
    private int nombreAleatorio;
    private String[] nomPirates;
    private String[] insultos;
    private String[] insultosLC;
    private boolean[] arrayBoleanos;
    private String[] contraRespuestas;
    private String[] contraRespuestasLC;

    // Constructor
    public Illa(String insultos[], String contraRespuestas[], String insultosLC[], String contraRespuestasLC[],
            String nomPirates[], String arrayIllaNoms[]) {
        this.insultos = insultos;
        this.insultosLC = insultosLC;
        this.nomPirates = nomPirates;
        this.arrayIllaNoms = arrayIllaNoms;
        this.contraRespuestas = contraRespuestas;
        this.contraRespuestasLC = contraRespuestasLC;
        numPiratas = rm.nextInt(5) + 3;// Aleatorio entre 3 y 7, utilizado para generar el largo del array de piratas
        nombreIllaAleatorio = rm.nextInt(arrayIllaNoms.length);// numero aleatorio para seleccionar el nombre de la isla
        nomIlla = arrayIllaNoms[nombreIllaAleatorio];// A partir del numero anterior se escoje el nombre de la isla
        arrayBoleanos = new boolean[nomPirates.length];// Array de booleanos para que no se repita el nombre de los
                                                       // piratas
        arrayPiratas = new Pirata[numPiratas];// Array principal donde estan todos los piratas
        for (int i = 0; i < numPiratas - 1; i++) {// bucle para hacer el array de piratas, dejo un espacio para lechunk
            do {
                nombreAleatorio = rm.nextInt(nomPirates.length);// numero aleatorio para el nombre del pirata
            } while (arrayBoleanos[nombreAleatorio] == true);// Si ya se ha utilizado el nombre se vuelve a hacer el
                                                             // bucle
            arrayBoleanos[nombreAleatorio] = true;// si no se ha utilizado se marca ahora como que si

            arrayPiratas[i] = new Pirata(nomPirates[nombreAleatorio], rm.nextInt(3) + 1, insultos, contraRespuestas);//ha medida que progresa el bucle se hace el array, añadiendo un pirata a cada posicion del array
        }
        arrayPiratas[numPiratas - 1] = new LeChunk("LeChunk", rm.nextInt(4) + 3, insultos, contraRespuestas, insultosLC,
                contraRespuestasLC);//El ultimo hueco se rellena con Lechunk siempre
    }

    // getters y setters
    public String getNomIlla() {
        return nomIlla;
    }

    public int getNumPiratas() {
        return numPiratas;
    }

    // Metodos
    public Pirata vullUnPirata(int rondaIsla) {//metodo vullUnPirata

        return arrayPiratas[rondaIsla];//este metodo devuelve un pirata segun la ronda en el main
    }
}
