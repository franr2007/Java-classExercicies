package es.cide.programacion;

import java.util.Random;

public class Cotxe extends Vehicle implements Energia {
    //atributos
    private Random rm=new Random();
    private boolean esTesla;
    private int bateria;
    //constructor
    public Cotxe(String propietari, String numBastidor, boolean esTesla){
        super(propietari, numBastidor);
        this.esTesla=esTesla;
        bateria=rm.nextInt(35)+10;
    }

    //getters y setters
    public int getBateria(){
        return bateria;
    }

    public boolean getEsTesla(){
        return esTesla;
    }


    //metodos
    @Override
    public void revisarVehicle() {
        System.out.println("Se esta revisando el vehiculo");
    }

    @Override
    public void finalitzarManteniment() {
        System.out.println("El coche ha sido reparado");
    }

    @Override
    public boolean estaLlest() {
        int probabilidad=rm.nextInt(9)+1;
        if (probabilidad<=8) {
            return false;
        }else{
            return true;
        }
    }

    @Override
    public void carrregarBateria() {
        bateria=100;
        System.out.println("La bateria del coche esta al 100%");
    }

    @Override
    public boolean teCorrent() {
        int probabilidad=rm.nextInt(9)+1;
        if (probabilidad<=5) {
            return false;
        }
        else{
            return true;
        }
    }
}
