package es.cide.programacion;

//Francisco Javier Rodriguez

abstract public class Cotxe extends Vehicle {
    // variables
    protected int plaçes;
    protected int velocitatmax;

    public Cotxe(String matricula, String marca, int plaçes, int velocitatmax) {
        super(matricula, marca);
        this.plaçes = plaçes;
        this.velocitatmax = velocitatmax;
    }

    // getters y setters
    public int getVelocitatMax() {
        return velocitatmax;
    }
}
