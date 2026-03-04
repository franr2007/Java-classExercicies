package es.cide.programacion;

import java.util.Random;

public class Moto extends Vehicle implements Energia {
    // atributos
    private Random rm = new Random();

    // constructor
    public Moto(String propietari, String numBastidor) {
        super(propietari, numBastidor);
    }
    //getters y setters

    // metodos

    @Override
    public void revisarVehicle() {
        System.out.println("Se esta revisando el vehiculo");
    }

    @Override
    public void finalitzarManteniment() {
        System.out.println("La moto ha sido reparado");
    }

    @Override
    public boolean estaLlest() {
        int probabilidad = rm.nextInt(9) + 1;
        if (probabilidad <= 4) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void carrregarBateria() {};

    @Override
    public boolean teCorrent() {return false;};

}
