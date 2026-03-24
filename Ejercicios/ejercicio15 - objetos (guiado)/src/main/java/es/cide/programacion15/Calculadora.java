package es.cide.programacion15;

//Francisco Javier Rodriguez

public class Calculadora {
    // atributos
    double operando1;
    double operando2;

    // constructor
    public Calculadora(double operando11, double operando22) {
        this.operando1 = operando11;
        this.operando2 = operando22;
    }

    // getter y setters
    public void setoperando1(double operando11) {
        this.operando1 = operando11;
    }

    public double getoperando1() {
        return this.operando1;
    }

    public void setoperando2(double operando22) {
        this.operando2 = operando22;
    }

    public double getoperando2() {
        return this.operando2;
    }

    // metodos
    public double sumar() {
        double resultadoSuma = operando1 + operando2;
        return operando1 + operando2;
    }

    public double restar() {
        double resultadoResta = operando1 - operando2;
        return operando1 - operando2;
    }

    public double dividir() {
        double resultadoDivision = operando1 / operando2;
        return operando1 / operando2;
    }

    public double multiplicar() {
        double resultadoMultiplicar = operando1 * operando2;
        return operando1 * operando2;
    }

}
