package es.programacion.cide.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseManager {
    // atributos
    static Connection conexion;

    // constructor
    public DataBaseManager() {
        try {
            //intenta establecer conexion con la base de datos
            conexion = DriverManager.getConnection("jdbc:sqlite:miDataBase.db");
        } catch (SQLException e) {
            //si da error
            //se recoje los errores principales
            System.err.println("==ERROR BASE DE DATOS==");
            System.err.println("Mensaje: " + e.getMessage());
            System.err.println("Estado SQL: " + e.getSQLState());
        }
    }

    // getters y setters

    // metodos

    //metodo que devuelve la conexion de la base de datos
    public static Connection getConex() throws SQLException {
        //si no existe o esta cerrada
        if (conexion == null || conexion.isClosed()) {
            //la vuelve a crear
            conexion = DriverManager.getConnection("jdbc:sqlite:miDataBase.db");
        }
        return conexion;
    }

    //metodo para crear las tablas de la base de datos
    public void crearTablas() {
        //intenta cojer la conexion de la base de datos
        try (Statement statement = getConex().createStatement()) {
            //si funciona se crean las tablas

            //tabla tipusPlaza
            statement.executeUpdate("""
                    CREATE TABLE IF NOT EXISTS TIPUS_PLAZA(
                        ID INTEGER PRIMARY KEY AUTOINCREMENT,
                        NOM TEXT NOT NULL,
                        FUNCIO TEXT NOT NULL
                    )
                    """);

            //tabla Plaza
            statement.executeUpdate("""
                    CREATE TABLE IF NOT EXISTS PLAZA(
                        CODI INTEGER PRIMARY KEY,
                        NOM TEXT NOT NULL,
                        SALARI REAL NOT NULL,
                        INFORME_SUPERVISIO TEXT,
                        CODI_PLAZA_SUPERVISORA INTEGER,
                        NOM_TIPUS_PLAZA TEXT NOT NULL,
                        FOREIGN KEY (CODI_PLAZA_SUPERVISORA) REFERENCES PLAZA(CODI),
                        FOREIGN KEY (NOM_TIPUS_PLAZA) REFERENCES TIPUS_PLAZA(NOM)
                    )
                    """);
            
            //tabla empleado        
            statement.executeUpdate("""
                    CREATE TABLE IF NOT EXISTS EMPLEADO(
                        ID INTEGER PRIMARY KEY AUTOINCREMENT,
                        NSS INTEGER NOT NULL,
                        NOM TEXT NOT NULL,
                        APELLIDOS TEXT NOT NULL,
                        EMAIL TEXT,
                        IBAN TEXT UNIQUE NOT NULL
                    )
                    """);

            //tabla ocupa
            statement.executeUpdate("""
                    CREATE TABLE IF NOT EXISTS OCUPA(
                        ID INTEGER PRIMARY KEY AUTOINCREMENT,
                        NSS_EMPLEADO INTEGER NOT NULL,
                        CODI_PLAZA INTEGER NOT NULL,
                        DATA_INICI TEXT NOT NULL,
                        DATA_FI TEXT,
                        FOREIGN KEY (NSS_EMPLEADO) REFERENCES EMPLEADO(NSS),
                        FOREIGN KEY (CODI_PLAZA) REFERENCES PLAZA(CODI)
                    )
                    """);

            //tabla nomina
            statement.executeUpdate("""
                    CREATE TABLE IF NOT EXISTS NOMINA(
                        ID INTEGER PRIMARY KEY AUTOINCREMENT,
                        IBAN_PAGAMENT TEXT NOT NULL,
                        IMPORT_REAL REAL NOT NULL,
                        NSS_EMPLEADO INTEGER NOT NULL,
                        CODI_PLAZA INTEGER NOT NULL,
                        FOREIGN KEY (NSS_EMPLEADO) REFERENCES EMPLEADO(NSS),
                        FOREIGN KEY (CODI_PLAZA) REFERENCES PLAZA(CODI)
                    )
                    """);
        } catch (Exception e) {
            //si no se ha podido crear las tablas devuelve error
            System.err.println("ERROR AL HACER LA BASE DE DATOS");
        }
    }
}
