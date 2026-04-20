package es.programacion.cide.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dataBaseManager {
    //atributos

    //constructor
    public dataBaseManager(){
        try {
            Connection conexion= DriverManager.getConnection("jdbc:sqlite:miDataBase.db");
        } catch (SQLException e) {
            System.err.println("==ERROR BASE DE DATOS");
            System.err.println("Mensaje: "+e.getMessage());
            System.err.println("Estado SQL: "+ e.getSQLState());

            SQLException proximoErr= e.getNextException();

            while (proximoErr != null) {
                System.err.println("Error extra: "+proximoErr.getMessage());
                proximoErr= e.getNextException();
            }
        }
    }
    //getters y setters

    //metodos
}
