package es.programacion.cide.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import es.programacion.cide.db.DataBaseManager;
import es.programacion.cide.model.Empleado;

public class EmpleadoDao implements Dao<Empleado, Integer> {

    @Override
    public void insertar(Empleado empleado) {
        String comando = "INSERT INTO Empleado (NSS,NOM,APELLIDOS,EMAIL,IBAN) VALUES(?,?,?,?,?)";
        try (PreparedStatement statement = DataBaseManager.getConnection().prepareStatement(comando)) {
            statement.setInt(1, empleado.getNss());
            statement.setString(2, empleado.getNom());
            statement.setString(3, empleado.getApellidos());
            statement.setString(4, empleado.getEmail());
            statement.setString(5, empleado.getIban());
        } catch (SQLException e) {
            System.err.println("Err insert empelado: " + e.getMessage());
        }
    }

    @Override
    public Empleado recojerPorId(Integer id) {
        String comando = "SELECT * FROM EMPLEADO WHERE ID=?";

        try (PreparedStatement statement = DataBaseManager.getConnection().prepareStatement(comando);
                ResultSet resultado = statement.executeQuery()) {
            statement.setInt(1, id);

            while (resultado.next()) {
                Empleado empleado= new Empleado();
                empleado.setNss(resultado.getInt("NSS"));
                empleado.setNom(resultado.getString("NOM"));
                empleado.setApellidos(resultado.getString("APELLIDOS"));
                empleado.setEmail(resultado.getString("EMAIL"));
                empleado.setIban(resultado.getString("IBAN"));
                return empleado;
            }
        } catch (SQLException e) {
            System.err.println("Err Recojer Empleado: "+e.getMessage());
        }
        return null;
    }

    @Override
    public List<Empleado> listarTodos() {
        String comando = "SELECT * FROM EMPLEADO";
        List<Empleado> listaEmp = new ArrayList<>();

        try (PreparedStatement statement = DataBaseManager.getConnection().prepareStatement(comando);
                ResultSet resultado = statement.executeQuery()) {
            
            while (resultado.next()) {
                Empleado empleado= new Empleado();
                empleado.setNss(resultado.getInt("NSS"));
                empleado.setNom(resultado.getString("NOM"));
                empleado.setApellidos(resultado.getString("APELLIDOS"));
                empleado.setEmail(resultado.getString("EMAIL"));
                empleado.setIban(resultado.getString("IBAN"));
                listaEmp.add(empleado);
            }
        } catch (SQLException e) {
            System.err.println("Err listar Empleado: "+e.getMessage());
        }

        return listaEmp;
    }

    @Override
    public void editar(Empleado empleado) {
        String comando= "UPDATE EMPLEADO SET NSS=?, NOM=?, APELLIDO=?, EMAIL=?, IBAN=? WHERE ID=?";

        try (PreparedStatement statement = DataBaseManager.getConnection().prepareStatement(comando)){
            statement.setInt(1, empleado.getNss());
            statement.setString(2, empleado.getNom());
            statement.setString(3, empleado.getApellidos());
            statement.setString(4, empleado.getEmail());
            statement.setString(5, empleado.getIban());
            statement.setInt(6, empleado.getId());

            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Err editar empleado: "+e.getMessage());
        }
    }

    @Override
    public void eliminarPorId(Integer id) {
        String comando = "DELETE * FROM EMPLEADO WHERE ID=?";

        try (PreparedStatement statement = DataBaseManager.getConnection().prepareStatement(comando);
                ResultSet resultado = statement.executeQuery()) {
            statement.setInt(1, id);

            while (resultado.next()) {
                Empleado empleado= new Empleado();
                empleado.setNss(resultado.getInt("NSS"));
                empleado.setNom(resultado.getString("NOM"));
                empleado.setApellidos(resultado.getString("APELLIDOS"));
                empleado.setEmail(resultado.getString("EMAIL"));
                empleado.setIban(resultado.getString("IBAN"));
            }
        } catch (SQLException e) {
            System.err.println("Err Recojer Empleado: "+e.getMessage());
        }
    }
}
