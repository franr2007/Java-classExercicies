package es.programacion.cide;

import es.programacion.cide.db.DataBaseManager;
import es.programacion.cide.view.VentanaPrincipal;

public class Main {
    public static void main(String[] args) {
        DataBaseManager bdd = new DataBaseManager();
        bdd.crearTablas();
        
        VentanaPrincipal programa= new VentanaPrincipal();
        programa.setVisible(true);
    }
}