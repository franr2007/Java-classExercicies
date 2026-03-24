package es.cide.programacion;

//Francisco Javier Rodriguez

public class Patinete extends Vehicle implements Recargable {

    private int bateria;

    public Patinete(String matricula, String marca, int bateria) {
        super(matricula, marca);
        this.bateria = bateria;
    }

    @Override
    public int getNivellBateria() {
        return this.bateria;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("--- FITXA Patinet ---");
        System.out.println("Marca patinet: " + marca);
        System.out.println("Matrícula patinet: " + matricula);
    }

    @Override
    public double calcularPreuLloguer(int dies) {
        return dies*5;
    }

    @Override
    public void carregarBateria() {
        this.bateria=100;
    }

}
