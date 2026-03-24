package es.cide.programacion;

//Francisco Javier Rodriguez

public class Main {
    public static void main(String[] args) {
        CotxeCombustio cotxeCombustio = new CotxeCombustio("MDF1234", "BMW", 2, 200, 20);
        double preciollogerC = cotxeCombustio.calcularPreuLloguer(10);
        cotxeCombustio.mostrarInfo();
        System.out.println("PRECIO: "+preciollogerC);
        
        CotxeElectric ce = new CotxeElectric("DFG09876", "Tesla", 5, 250, 50);
        double preciollogerE = ce.calcularPreuLloguer(10);
        ce.mostrarInfo();
        System.out.println("PRECIO: "+preciollogerE);

        Patinete p=new Patinete("JK900", "realme", 70);
        p.mostrarInfo();
    }
}