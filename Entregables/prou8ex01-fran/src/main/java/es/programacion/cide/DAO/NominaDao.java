package es.programacion.cide.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import es.programacion.cide.db.DataBaseManager;
import es.programacion.cide.model.Empleado;
import es.programacion.cide.model.Nomina;

public class NominaDao implements Dao<Nomina, Integer> {

    @Override
    public void insertar(Nomina nomina) {
        // este es el comando en sqlite para insertar valores a la base de datos
        String comando = "INSERT INTO NOMINA (IBAN_PAGAMENT,IMPORT_REAL,NSS_EMPLEADO,CODI_PLAZA) VALUES(?,?,?,?)";
        // aqui se prepara la base de datos junto a su conexion y le pasamos el comando
        try (PreparedStatement statement = DataBaseManager.getConnection().prepareStatement(comando)) {
            // por cada interrogante dentro de values recojemos los datos de la Nomina y se
            // pone en values
            statement.setString(1, nomina.getIbanPag());
            statement.setString(2, nomina.getImporte());
            statement.setInt(3, nomina.getNssEmpleado());
            statement.setInt(4, nomina.getCodiPlaza());
        } catch (SQLException e) {
            // en caso de error al preparar la conexion, se imprime el mensaje del error
            System.err.println("Err insert Nomina: " + e.getMessage());
        }
    }

    @Override
    public Nomina recojerPorId(Integer id) {
        // este es el comando que servira para recojer una Nomina por id
        String comando = "SELECT * FROM NOMINA WHERE ID=?";
        // aqui se prepara la base de datos junto a su conexion y le pasamos el comando,
        // ademas usamos resulset para ejecutar el comando
        try (PreparedStatement statement = DataBaseManager.getConnection().prepareStatement(comando);
                ResultSet resultado = statement.executeQuery()) {
            // se le pasa el valor del interogante, con el id que se busca
            statement.setInt(1, id);

            // este bucle lista las Nominas que contenga el numero de id
            while (resultado.next()) {
                Nomina nomina = new Nomina();
                nomina.setIbanPag(resultado.getString("IBAN_PAGAMENT"));
                nomina.setImporte(resultado.getString("IMPORT_REAL"));
                nomina.setNssEmleado(resultado.getInt("NSS_EMPLEADO"));
                nomina.setCodiPlaza(resultado.getInt("CODI_PLAZA"));
                return nomina;
            }
        } catch (SQLException e) {
            // si el try devuelve error, se imprimira el mensaje
            System.err.println("Err Recojer Nomina: " + e.getMessage());
        }
        // en caso de no haber ninguna nomina con ese id, no devuelve nada
        return null;
    }

    @Override
    public List<Nomina> listarTodos() {
        // comando que se usara para listar todas las nominas
        String comando = "SELECT * FROM NOMINA";
        // arrayList para poder guardar todas las nominas listadas
        List<Nomina> listaNom = new ArrayList<>();

        // aqui se prepara la base de datos junto a su conexion y le pasamos el comando,
        // ademas usamos resulset para ejecutar el comando
        try (PreparedStatement statement = DataBaseManager.getConnection().prepareStatement(comando);
                ResultSet resultado = statement.executeQuery()) {
            
            //bucle que listara la nomina segun cuantos resultados de el comando
            while (resultado.next()) {
                Nomina nomina = new Nomina();
                nomina.setIbanPag(resultado.getString("IBAN_PAGAMENT"));
                nomina.setImporte(resultado.getString("IMPORT_REAL"));
                nomina.setNssEmleado(resultado.getInt("NSS_EMPLEADO"));
                nomina.setCodiPlaza(resultado.getInt("CODI_PLAZA"));
                listaNom.add(nomina);//se añade a la lista
            }
        } catch (SQLException e) {
            // si el try devuelve error, se imprimira el mensaje
            System.err.println("Err listar NOMINA: " + e.getMessage());
        }

        return listaNom;
    }

    @Override
    public void editar(Nomina nomina) {
        //este es el comando que se utilizara para hacer update a la nomina
        String comando = "UPDATE NOMINA SET IBAN_PAGAMENT=?, IMPORT_REAL=?, NSS_EMPLEADO=?, CODI_PLAZA=? WHERE ID=?";

        //aqui se prepara la base de datos junto a su conexion y le pasamos el comando
        try (PreparedStatement statement = DataBaseManager.getConnection().prepareStatement(comando)) {
            // por cada interrogante se sustituira por el valor en orden de la nomina
            statement.setString(1, nomina.getIbanPag());
            statement.setString(2, nomina.getImporte());
            statement.setInt(3, nomina.getNssEmpleado());
            statement.setInt(4, nomina.getCodiPlaza());
            statement.setInt(5, nomina.getId());

            statement.executeUpdate();
        } catch (SQLException e) {
            // si el try devuelve error, se imprimira el mensaje
            System.err.println("Err editar NOMINA: " + e.getMessage());
        }
    }

    @Override
    public void eliminarPorId(Integer id) {
        //comando para eliminar nominas por id
        String comando = "DELETE * FROM NOMINA WHERE ID=?";
        
        // aqui se prepara la base de datos junto a su conexion y le pasamos el comando,
        // ademas usamos resulset para ejecutar el comando
        try (PreparedStatement statement = DataBaseManager.getConnection().prepareStatement(comando);
                ResultSet resultado = statement.executeQuery()) {
            statement.setInt(1, id);
            
            // este bucle elimina las nominas que contenga el numero de id
            while (resultado.next()) {
                Nomina nomina = new Nomina();
                nomina.setIbanPag(resultado.getString("IBAN_PAGAMENT"));
                nomina.setImporte(resultado.getString("IMPORT_REAL"));
                nomina.setNssEmleado(resultado.getInt("NSS_EMPLEADO"));
                nomina.setCodiPlaza(resultado.getInt("CODI_PLAZA"));
            }
        } catch (SQLException e) {
            // si el try devuelve error, se imprimira el mensaje
            System.err.println("Err Recojer NOMINA: " + e.getMessage());
        }
    }
}
