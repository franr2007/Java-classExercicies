package es.programacion.cide;

import es.programacion.cide.db.DataBaseManager;
import es.programacion.cide.view.VentanaPrincipal;

public class Main {
    public static void main(String[] args) {
        //crea la base de datos
        DataBaseManager bdd = new DataBaseManager();
        //llama a la funcion crear tablas
        bdd.crearTablas();
        
        //crea la ventana principal del programa
        VentanaPrincipal programa= new VentanaPrincipal();
        //la hace visible
        programa.setVisible(true);
    }
}