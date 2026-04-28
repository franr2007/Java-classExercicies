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
            conexion = DriverManager.getConnection("jdbc:sqlite:miDataBase.db");
        } catch (SQLException e) {
            System.err.println("==ERROR BASE DE DATOS");
            System.err.println("Mensaje: " + e.getMessage());
            System.err.println("Estado SQL: " + e.getSQLState());

            SQLException proximoErr = e.getNextException();

            while (proximoErr != null) {
                System.err.println("Error extra: " + proximoErr.getMessage());
                proximoErr = e.getNextException();
            }
        }
    }

    // getters y setters

    // metodos
    public static Connection getConnection() throws SQLException {
        if (conexion == null || conexion.isClosed()) {
            conexion = DriverManager.getConnection("jdbc:sqlite:miDataBase.db");
        }
        return conexion;
    }

    public void crearTablas() {
        try (Statement statement = getConnection().createStatement()) {
            statement.executeQuery("""
                    CREATE TABLE IF NOT EXISTS TIPUS_PLAZA(
                        NOM TEXT PRIMATY KEY,
                        FUNCIO TEXT NOT NULL
                    )
                    """);

            statement.executeQuery("""
                    CREATE TABLE IF NOT EXISTS PLAZA(
                        CODI INTEGER PRIMARY KEY AUTOINCREMENT,
                        NOM TEXT NOT NULL,
                        SALARI REAL NOT NULL,
                        INFORME_SUPERVISIO TEXT,
                        CODI_PLAZA_SUPERVISORA INTEGER,
                        NOM_TIPUS_PLAZA TEXT NOT NULL,
                        FOREIGN KEY (CODI_PLAZA_SUPERVISORA) REFERENCE PLAZA(CODI),
                        FOREIGN KEY (NOM_TIPUS_PLAZA) REFERENCE TIPUS_PLAZA(NOM)
                    )
                    """);

            statement.executeQuery("""
                    CREATE TABLE IF NOT EXISTS EMPLEADO(
                        ID INTEGER PRIMARY KEY AUTOINCREMENT,
                        NSS NUMBER,
                        NOM TEXT NOT NULL,
                        APELLIDOS TEXT NOT NULL,
                        EMAIL TEXT,
                        IBAN TEXT UNIQUE NOT NULL
                    )
                    """);

            statement.executeQuery("""
                    CREATE TABLE IF NOT EXISTS OCUPA (
                        NSS_EMPLEADO INTEGER NOT NULL,
                        CODI_PLAZA INTEGER NOT NULL,
                        DATA_INICI TEXT NOT NULL,
                        DATA_FI TEXT,
                        PRIMARY KEY (NSS_EMPLEADO, CODI_PLAZA),
                        FOREIGN KEY (NSS_EMPLEADO) REFERENCES EMPLEADO(NSS),
                        FOREIGN KEY (CODI_PLAZA) REFERENCES PLAZA(CODI)
                    )
                    """);

            statement.executeUpdate("""
                    CREATE TABLE IF NOT EXISTS NOMINA (
                        ID_NOMINA INTEGER PRIMARY KEY AUTOINCREMENT,
                        IBAN_PAGAMENT TEXT NOT NULL,
                        IMPORT REAL NOT NULL,
                        NSS_EMPLEADO INTEGER NOT NULL,
                        CODI_PLAZA INTEGER NOT NULL,
                        FOREIGN KEY (NSS_EMPLEADO) REFERENCES EMPLEADO(NSS),
                        FOREIGN KEY (CODI_PLAZA) REFERENCES PLAZA(CODI)
                    )
                    """);
        } catch (Exception e) {
            System.err.println("ERROR AL HACER LA BASE DE DATOS");
        }
    }
}
