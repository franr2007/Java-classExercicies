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
            statement.executeUpdate("""
                    CREATE TABLE IF NOT EXISTS TIPUS_PLAZA(
                        ID INTEGER PRIMARY KEY AUTOINCREMENT,
                        NOM TEXT,
                        FUNCIO TEXT NOT NULL
                    )
                    """);

            statement.executeUpdate("""
                    CREATE TABLE IF NOT EXISTS PLAZA(
                        CODI INTEGER PRIMARY KEY AUTOINCREMENT,
                        NOM TEXT NOT NULL,
                        SALARI REAL NOT NULL,
                        INFORME_SUPERVISIO TEXT,
                        CODI_PLAZA_SUPERVISORA INTEGER,
                        NOM_TIPUS_PLAZA TEXT NOT NULL,
                        FOREIGN KEY (CODI_PLAZA_SUPERVISORA) REFERENCES PLAZA(CODI),
                        FOREIGN KEY (NOM_TIPUS_PLAZA) REFERENCES TIPUS_PLAZA(NOM)
                    )
                    """);

            statement.executeUpdate("""
                    CREATE TABLE IF NOT EXISTS EMPLEADO(
                        ID INTEGER PRIMARY KEY AUTOINCREMENT,
                        NSS INTEGER,
                        NOM TEXT NOT NULL,
                        APELLIDOS TEXT NOT NULL,
                        EMAIL TEXT,
                        IBAN TEXT UNIQUE NOT NULL
                    )
                    """);

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
            System.err.println("ERROR AL HACER LA BASE DE DATOS");
        }
    }
}
