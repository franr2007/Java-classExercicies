package es.programacion.cide;

import java.util.Random;

//DNI 41663903R
//Francisco Javier Rodriguez Magaña
//13-01-26

public class Sobrassada extends Torrada { //Subclase de torrada, Sobrassada
    //atributos
    private Random rm=new Random();
    //constructor
    public Sobrassada(String festivitat, String any){
        super(festivitat, any);
    }
    //getters y setters

    //metodos
    @Override
    public boolean estaFet() {
        int aleatorio=rm.nextInt(2); //Numero del 0 al 1
        if (aleatorio==0) { //si el numero es por debajo o igual que 0, es decir el 50% de las veces
            return false; //no estara hecho
        }
        else{ //Si sale un numero por encima del 1
            return true; //estara hecho
        }
    }

    @Override
    public void posarCarnAGraella() {
        System.out.println("S'ha posat la sobrassada a la graella ");
    }

    @Override
    public void llevarCarnDeGraella() {
        System.out.println("S'ha llevat la sobrassada de la graella");
    }

    @Override
    public void assaborir() {
        System.out.println("Estic assaborint la sobrassada");
    }

    @Override
    public boolean crema() {
        int aleatorio=rm.nextInt(2); //numero del 0 al 1
        if (aleatorio==0) { //Si sale un 0 no quemara
            return false; 
        }
        else{ //Si sale un 1 quemara
            return true;
        }
    }
}
