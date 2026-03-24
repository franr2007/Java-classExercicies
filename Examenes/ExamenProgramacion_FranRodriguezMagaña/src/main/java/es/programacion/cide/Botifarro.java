package es.programacion.cide;

import java.util.Random;

//Francisco Javier Rodriguez

public class Botifarro extends Torrada {//Subclase de torrada, Botifarro
    //atributos
    private Random rm=new Random();
    private boolean coent;
    //constructor
    public Botifarro(String festivitat, String any){
        super(festivitat, any);
        int aleatorio=rm.nextInt(2); //numero del 0 al 1
        if (aleatorio==0) { // si sale 0
            coent=false; //no es coent
        }
        else{
            coent=true; //Si sale 1 si es coent
        }
    }
    //getters y setters
    public void setCoent(boolean coent){
        this.coent=coent;
    }

    public boolean getCoent(){
        return coent;
    }
    //metodos
    @Override
    public boolean estaFet() {
        int aleatorio=rm.nextInt(11)+1; //Numero del 1 al 10
        if (aleatorio<=7) { //si el numero es por debajo o igual que 7, es decir el 70% de las veces
            return false; //no estara hecho
        }
        else{ //Si sale un numero por encima del 7
            return true; //estara hecho
        }
    }

    @Override
    public void posarCarnAGraella() {
        System.out.println("S'ha posat el butifarro a la graella ");
    }

    @Override
    public void llevarCarnDeGraella() {
        System.out.println("S'ha llevat el butifarro de la graella");
    }

    @Override
    public void assaborir() {
        System.out.print("Estic assaborint el butifarro");
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
