package es.cide.programacion;

//41663903R
//Francisco Javier Rodriguez

public class CotxeElectric extends Cotxe implements Recargable {
    // atributos
    protected int bateria;

    public CotxeElectric(String matricula, String marca, int plaçes, int velocitatmax, int bateria) {
        super(matricula, marca, plaçes, velocitatmax);
        this.bateria = bateria;
    }

    // Getters y setters
    public int getNivellBateria() {
        return this.bateria;
    }

    // metodos
    @Override
    public double calcularPreuLloguer(int dies) {
        return dies * 11;
    }

    public void carregarBateria() {
        this.bateria=100;
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
    }
}
