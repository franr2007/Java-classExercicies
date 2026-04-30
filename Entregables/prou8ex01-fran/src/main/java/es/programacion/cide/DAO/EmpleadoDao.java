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
            // por cada interrogante dentro de values recojemos los datos del empleado y se
            // pone en values
            statement.setInt(1, empleado.getNss());
            statement.setString(2, empleado.getNom());
            statement.setString(3, empleado.getApellidos());
            statement.setString(4, empleado.getEmail());
            statement.setString(5, empleado.getIban());
        } catch (SQLException e) {
            // en caso de error al preparar la conexion, se imprime el mensaje del error
            System.err.println("Err insert empelado: " + e.getMessage());
        }
    }

    @Override
    public Empleado recojerPorId(Integer id) {
        // este es el comando que servira para recojer a un empleado por id
        String comando = "SELECT * FROM EMPLEADO WHERE ID=?";
        // aqui se prepara la base de datos junto a su conexion y le pasamos el comando,
        // ademas usamos resulset para ejecutar el comando
        try (PreparedStatement statement = DataBaseManager.getConnection().prepareStatement(comando);
                ResultSet resultado = statement.executeQuery()) {
            // se le pasa el valor del interogante, con el id que se busca
            statement.setInt(1, id);

            // este bucle lista a los empleados que contenga el numero de id
            while (resultado.next()) {
                Empleado empleado = new Empleado();
                empleado.setNss(resultado.getInt("NSS"));
                empleado.setNom(resultado.getString("NOM"));
                empleado.setApellidos(resultado.getString("APELLIDOS"));
                empleado.setEmail(resultado.getString("EMAIL"));
                empleado.setIban(resultado.getString("IBAN"));
                return empleado;
            }
        } catch (SQLException e) {
            // si el try devuelve error, se imprimira el mensaje
            System.err.println("Err Recojer Empleado: " + e.getMessage());
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
            
            //bucle que listara al empleado segun la cantidad de resultados del comando
            while (resultado.next()) {
                Empleado empleado = new Empleado();
                empleado.setNss(resultado.getInt("NSS"));
                empleado.setNom(resultado.getString("NOM"));
                empleado.setApellidos(resultado.getString("APELLIDOS"));
                empleado.setEmail(resultado.getString("EMAIL"));
                empleado.setIban(resultado.getString("IBAN"));
                listaEmp.add(empleado);//se añade a la lista
            }
        } catch (SQLException e) {
            // si el try devuelve error, se imprimira el mensaje
            System.err.println("Err listar Empleado: " + e.getMessage());
        }

        return listaEmp;
    }

    @Override
    public void editar(Empleado empleado) {
        //este es el comando que se utilizara para hacer update al empleado
        String comando = "UPDATE EMPLEADO SET NSS=?, NOM=?, APELLIDO=?, EMAIL=?, IBAN=? WHERE ID=?";

        //aqui se prepara la base de datos junto a su conexion y le pasamos el comando
        try (PreparedStatement statement = DataBaseManager.getConnection().prepareStatement(comando)) {
            // por cada interrogante se sustituira por el valor en orden del empleado
            statement.setInt(1, empleado.getNss());
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
        //comando para eliminar empleados por id
        String comando = "DELETE * FROM EMPLEADO WHERE ID=?";
        
        // aqui se prepara la base de datos junto a su conexion y le pasamos el comando,
        // ademas usamos resulset para ejecutar el comando
        try (PreparedStatement statement = DataBaseManager.getConnection().prepareStatement(comando);
                ResultSet resultado = statement.executeQuery()) {
            statement.setInt(1, id);
            
            // este bucle elimina al empleado que contenga el numero de id
            while (resultado.next()) {
                Empleado empleado = new Empleado();
                empleado.setNss(resultado.getInt("NSS"));
                empleado.setNom(resultado.getString("NOM"));
                empleado.setApellidos(resultado.getString("APELLIDOS"));
                empleado.setEmail(resultado.getString("EMAIL"));
                empleado.setIban(resultado.getString("IBAN"));
            }
        } catch (SQLException e) {
            // si el try devuelve error, se imprimira el mensaje
            System.err.println("Err Recojer Empleado: " + e.getMessage());
        }
    }
}
