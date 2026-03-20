package es.cide.programacion;

//41663903R
//Francisco Javier Rodriguez

public class CotxeCombustio extends Cotxe {
    // Atributos
    protected int capacitatDiposit;

    // constructor
    public CotxeCombustio(String matricula, String marca, int plaçes, int velocitatmax, int capacitatDiposit) {
        super(matricula, marca, plaçes, velocitatmax);
        this.capacitatDiposit = capacitatDiposit;
    }

    @Override
    public double calcularPreuLloguer(int dies) {
        return dies * 22;
    }
}
