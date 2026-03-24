package es.cide.programacion;

//Francisco Javier Rodriguez

public class Vehicle implements Manteniment{
    //atributos
    private String propietari;
    private String numBastidor;
    //constructor
    public Vehicle(String propietari,String numBastidor){

    }
    //getters y settes
    public String getPropietari(){
        return propietari;
    }

    public String getNumBastidor(){
        return numBastidor;
    }
    //metodos
    @Override
    public void finalitzarManteniment() {}

    @Override
    public void revisarVehicle() {}

    @Override
    public boolean estaLlest() {
        return false;
    }
}
