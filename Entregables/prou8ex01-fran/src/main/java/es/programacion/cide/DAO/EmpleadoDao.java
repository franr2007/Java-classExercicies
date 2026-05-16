package es.programacion.cide.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import es.programacion.cide.db.DataBaseManager;
import es.programacion.cide.model.Empleado;

public class EmpleadoDao implements Dao<Empleado, Integer> {

    @Override
    public void insertar(Empleado empleado) {
        // este es el comando en sqlite para insertar valores a la base de datos
        String comando = "INSERT INTO Empleado (NSS,NOM,APELLIDOS,EMAIL,IBAN) VALUES(?,?,?,?,?)";
        // aqui se prepara la base de datos junto a su conexion y le pasamos el comando
        try (PreparedStatement statement = DataBaseManager.getConnection().prepareStatement(comando)) {
            // por cada interrogante dentro de values recojemos los datos del empleado y se pone en values
            statement.setLong(1, empleado.getNss());
            statement.setString(2, empleado.getNom());
            statement.setString(3, empleado.getApellidos());
            statement.setString(4, empleado.getEmail());
            statement.setString(5, empleado.getIban());
            statement.executeUpdate(); // CORRECCIÓN: faltaba ejecutar el comando, sin esto no se guardaba nada
        } catch (SQLException e) {
            // en caso de error al preparar la conexion, se imprime el mensaje del error
            System.err.println("Err insert empleado: " + e.getMessage());
        }
    }

    @Override
    public Empleado recojerPorId(Integer id) {
        // este es el comando que servira para recojer a un empleado por id
        String comando = "SELECT * FROM EMPLEADO WHERE ID=?";
        // aqui se prepara la base de datos junto a su conexion y le pasamos el comando
        try (PreparedStatement statement = DataBaseManager.getConnection().prepareStatement(comando)) {
            statement.setInt(1, id); // CORRECCIÓN: el parametro debe ponerse antes de ejecutar la query
            ResultSet resultado = statement.executeQuery(); // CORRECCIÓN: executeQuery va despues de setear los parametros
            // este bucle lista a los empleados que contenga el numero de id
            while (resultado.next()) {
                Empleado empleado = new Empleado();
                empleado.setId(resultado.getInt("ID")); // CORRECCIÓN: faltaba recojer el ID
                empleado.setNss(resultado.getLong("NSS"));
                empleado.setNom(resultado.getString("NOM"));
                empleado.setApellidos(resultado.getString("APELLIDOS"));
                empleado.setEmail(resultado.getString("EMAIL"));
                empleado.setIban(resultado.getString("IBAN"));
                return empleado;
            }
        } catch (SQLException e) {
            // si el try devuelve error, se imprimira el mensaje
            System.err.println("Err recojer empleado: " + e.getMessage());
        }
        // en caso de no haber nadie con ese id, no devuelve nada
        return null;
    }

    @Override
    public List<Empleado> listarTodos() {
        // comando que se usara para listar todos los empleados
        String comando = "SELECT * FROM EMPLEADO";
        // arrayList para poder guardar todos los empleados listados
        List<Empleado> listaEmp = new ArrayList<>();
        // aqui se prepara la base de datos junto a su conexion y le pasamos el comando,
        // ademas usamos resulset para ejecutar el comando
        try (PreparedStatement statement = DataBaseManager.getConnection().prepareStatement(comando);
                ResultSet resultado = statement.executeQuery()) {
            // bucle que listara al empleado segun la cantidad de resultados del comando
            while (resultado.next()) {
                Empleado empleado = new Empleado();
                empleado.setId(resultado.getInt("ID")); // CORRECCIÓN: faltaba recojer el ID
                empleado.setNss(resultado.getLong("NSS"));
                empleado.setNom(resultado.getString("NOM"));
                empleado.setApellidos(resultado.getString("APELLIDOS"));
                empleado.setEmail(resultado.getString("EMAIL"));
                empleado.setIban(resultado.getString("IBAN"));
                listaEmp.add(empleado); // se añade a la lista
            }
        } catch (SQLException e) {
            // si el try devuelve error, se imprimira el mensaje
            System.err.println("Err listar empleado: " + e.getMessage());
        }
        return listaEmp;
    }

    @Override
    public void editar(Empleado empleado) {
        // este es el comando que se utilizara para hacer update al empleado
        String comando = "UPDATE EMPLEADO SET NSS=?, NOM=?, APELLIDOS=?, EMAIL=?, IBAN=? WHERE ID=?"; // CORRECCIÓN: APELLIDO estaba mal escrito, es APELLIDOS
        // aqui se prepara la base de datos junto a su conexion y le pasamos el comando
        try (PreparedStatement statement = DataBaseManager.getConnection().prepareStatement(comando)) {
            // por cada interrogante se sustituira por el valor en orden del empleado
            statement.setLong(1, empleado.getNss());
            statement.setString(2, empleado.getNom());
            statement.setString(3, empleado.getApellidos());
            statement.setString(4, empleado.getEmail());
            statement.setString(5, empleado.getIban());
            statement.setInt(6, empleado.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            // si el try devuelve error, se imprimira el mensaje
            System.err.println("Err editar empleado: " + e.getMessage());
        }
    }

    @Override
    public void eliminarPorId(Integer id) {
        // comando para eliminar empleados por id
        String comando = "DELETE FROM EMPLEADO WHERE ID=?"; // CORRECCIÓN: DELETE no lleva * en SQL
        // aqui se prepara la base de datos junto a su conexion y le pasamos el comando
        try (PreparedStatement statement = DataBaseManager.getConnection().prepareStatement(comando)) {
            statement.setInt(1, id);
            statement.executeUpdate(); // CORRECCIÓN: DELETE usa executeUpdate, no ResultSet
        } catch (SQLException e) {
            // si el try devuelve error, se imprimira el mensaje
            System.err.println("Err eliminar empleado: " + e.getMessage());
        }
    }
}