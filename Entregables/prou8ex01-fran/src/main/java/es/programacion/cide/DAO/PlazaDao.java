package es.programacion.cide.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import es.programacion.cide.db.DataBaseManager;
import es.programacion.cide.model.Plaza;

public class PlazaDao implements Dao<Plaza, Integer> {

    @Override
    public void insertar(Plaza plaza) {
        // este es el comando en sqlite para insertar valores a la base de datos
        String comando = "INSERT INTO PLAZA (NOM,SALARI,INFORME_SUPERVISIO,CODI_PLAZA_SUPERVISORA, NOM_TIPUS_PLAZA) VALUES(?,?,?,?,?)";
        // aqui se prepara la base de datos junto a su conexion y le pasamos el comando
        try (PreparedStatement statement = DataBaseManager.getConnection().prepareStatement(comando)) {
            // por cada interrogante dentro de values recojemos los datos de la plaza y se
            // pone en values
            statement.setString(1, plaza.getNom());
            statement.setDouble(2, plaza.getSalari());
            statement.setString(3, plaza.getInformeSuper());
            // si no tiene plaza supervisora
            if (plaza.getCodiPlaSuper() != null) {
                statement.setInt(4, plaza.getCodiPlaSuper());
            } else {
                // lo guarda como
                statement.setNull(4, java.sql.Types.INTEGER);
            }
            statement.setString(5, plaza.getipoPlaza());
            // ejecuta el comando
            statement.executeUpdate();
        } catch (SQLException e) {
            // en caso de error al preparar la conexion, se imprime el mensaje del error
            System.err.println("Err insert plaza: " + e.getMessage());
        }
    }

    @Override
    public Plaza recojerPorId(Integer codi) {
        // este es el comando que servira para recojer una plaza por codi
        String comando = "SELECT * FROM PLAZA WHERE CODI=?";
        // aqui se prepara la base de datos junto a su conexion y le pasamos el comando,
        // ademas usamos resulset para ejecutar el comando
        try (PreparedStatement statement = DataBaseManager.getConnection().prepareStatement(comando)) {
            // se le pasa el valor del interogante, con el codi que se busca
            statement.setInt(1, codi);

            //ejecuta el comando
            ResultSet resultado = statement.executeQuery();

            // este bucle lista las plazas que contenga el numero de codi
            while (resultado.next()) {
                Plaza plaza = new Plaza();
                plaza.setCodi(resultado.getInt("CODI"));
                plaza.setNom(resultado.getString("NOM"));
                plaza.setSalari(resultado.getDouble("SALARI"));
                plaza.setInformeSuper(resultado.getString("INFORME_SUPERVISIO"));
                plaza.setCodiPlaSuper(resultado.getInt("CODI_PLAZA_SUPERVISORA"));
                plaza.setipoPlaza(resultado.getString("NOM_TIPUS_PLAZA"));

                return plaza;
            }
        } catch (SQLException e) {
            // si el try devuelve error, se imprimira el mensaje
            System.err.println("Err Recojer plaza: " + e.getMessage());
        }
        // en caso de no haber ninguna plaza con ese codi, no devuelve nada
        return null;
    }

    @Override
    public List<Plaza> listarTodos() {
        // comando que se usara para listar todas las plazas
        String comando = "SELECT * FROM PLAZA";
        // arrayList para poder guardar todas las plazas listadas
        List<Plaza> listaPla = new ArrayList<>();

        // aqui se prepara la base de datos junto a su conexion y le pasamos el comando,
        // ademas usamos resulset para ejecutar el comando
        try (PreparedStatement statement = DataBaseManager.getConnection().prepareStatement(comando);
                ResultSet resultado = statement.executeQuery()) {

            // bucle que listara la plaza segun cuantos resultados de el comando
            while (resultado.next()) {
                Plaza plaza = new Plaza();
                plaza.setCodi(resultado.getInt("CODI"));
                plaza.setNom(resultado.getString("NOM"));
                plaza.setSalari(resultado.getDouble("SALARI"));
                plaza.setInformeSuper(resultado.getString("INFORME_SUPERVISIO"));
                plaza.setCodiPlaSuper(resultado.getInt("CODI_PLAZA_SUPERVISORA"));
                plaza.setipoPlaza(resultado.getString("NOM_TIPUS_PLAZA"));
                listaPla.add(plaza);// se añade a la lista
            }
        } catch (SQLException e) {
            // si el try devuelve error, se imprimira el mensaje
            System.err.println("Err listar plaza: " + e.getMessage());
        }

        return listaPla;
    }

    @Override
    public void editar(Plaza plaza) {
        // este es el comando que se utilizara para hacer update a la plaza
        String comando = "UPDATE PLAZA SET NOM=?, SALARI=?, INFORME_SUPERVISIO=?, CODI_PLAZA_SUPERVISORA=?, NOM_TIPUS_PLAZA=? WHERE CODI=?";

        // aqui se prepara la base de datos junto a su conexion y le pasamos el comando
        try (PreparedStatement statement = DataBaseManager.getConnection().prepareStatement(comando)) {
            // por cada interrogante se sustituira por el valor en orden de la plaza
            statement.setString(1, plaza.getNom());
            statement.setDouble(2, plaza.getSalari());
            statement.setString(3, plaza.getInformeSuper());
            // si no tiene plaza supervisora
            if (plaza.getCodiPlaSuper() != null) {
                statement.setInt(4, plaza.getCodiPlaSuper());
            } else {
                // lo guarda como
                statement.setNull(4, java.sql.Types.INTEGER);
            }
            statement.setString(5, plaza.getipoPlaza());
            statement.setInt(6, plaza.getCodi());

            statement.executeUpdate();
        } catch (SQLException e) {
            // si el try devuelve error, se imprimira el mensaje
            System.err.println("Err editar plaza: " + e.getMessage());
        }
    }

    @Override
    public void eliminarPorId(Integer codi) {
        // comando para eliminar plazas por codi
        String comando = "DELETE FROM PLAZA WHERE CODI=?";

        // aqui se prepara la base de datos junto a su conexion y le pasamos el comando,
        // ademas usamos resulset para ejecutar el comando
        try (PreparedStatement statement = DataBaseManager.getConnection().prepareStatement(comando)) {
            statement.setInt(1, codi);
            // ejecuta el comando
            statement.executeUpdate();
        } catch (SQLException e) {
            // si el try devuelve error, se imprimira el mensaje
            System.err.println("Err Recojer plaza: " + e.getMessage());
        }
    }
}
