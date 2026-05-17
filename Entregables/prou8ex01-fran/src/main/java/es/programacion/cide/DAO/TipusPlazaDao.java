package es.programacion.cide.DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import es.programacion.cide.db.DataBaseManager;
import es.programacion.cide.model.TipusPlaza;

public class TipusPlazaDao implements Dao<TipusPlaza, Integer> {

    //metodo para insertar un tipo de plaza
    @Override
    public void insertar(TipusPlaza tipusPlaza) {
        // este es el comando en sqlite para insertar valores a la base de datos
        String comando = "INSERT INTO TIPUS_PLAZA (NOM,FUNCIO) VALUES(?,?)";
        // aqui se prepara la base de datos junto a su conexion y le pasamos el comando
        try (PreparedStatement statement = DataBaseManager.getConex().prepareStatement(comando)) {
            // por cada interrogante dentro de values recojemos los datos de la tipusPlaza y se
            // pone en values
            statement.setString(1, tipusPlaza.getNom());
            statement.setString(2, tipusPlaza.getFuncion());
            //ejecuta el comando
            statement.executeUpdate();//update para modificar
        } catch (SQLException e) {
            // en caso de error al preparar la conexion, se imprime el mensaje del error
            System.err.println("Err insert TipusPlaza: " + e.getMessage());
        }
    }

    //metodo para recojer un tipo de plaza por id
    @Override
    public TipusPlaza recojerPorId(Integer id) {
        // este es el comando que servira para recojer una tipusPlaza por id
        String comando = "SELECT * FROM TIPUS_PLAZA WHERE ID=?";
        // aqui se prepara la base de datos junto a su conexion y le pasamos el comando
        try (PreparedStatement statement = DataBaseManager.getConex().prepareStatement(comando)) {
            // se le pasa el valor del interogante, con el id que se busca
            statement.setInt(1, id);

            //se usa resulset para ejecutar el comando
            ResultSet resultado = statement.executeQuery();//query para hacer selects

            // este bucle lista las tipusPlazas que contenga el numero de id
            while (resultado.next()) {
                TipusPlaza tipusPlaza = new TipusPlaza();
                tipusPlaza.setId(resultado.getInt("ID"));
                tipusPlaza.setNom(resultado.getString("NOM"));
                tipusPlaza.setFuncion(resultado.getString("FUNCIO"));
                
                return tipusPlaza;
            }
        } catch (SQLException e) {
            // si el try devuelve error, se imprimira el mensaje
            System.err.println("Err Recojer TipusPlaza: " + e.getMessage());
        }
        // en caso de no haber ninguna tipusPlaza con ese id, no devuelve nada
        return null;
    }

    //metodo para listar todos los tipos de plaza
    @Override
    public List<TipusPlaza> listarTodos() {
        // comando que se usara para listar todas las tipusPlazas
        String comando = "SELECT * FROM TIPUS_PLAZA";
        // arrayList para poder guardar todas las tipusPlazas listadas
        List<TipusPlaza> listaPla = new ArrayList<>();

        // aqui se prepara la base de datos junto a su conexion y le pasamos el comando,
        // ademas usamos resulset para ejecutar el comando
        try (PreparedStatement statement = DataBaseManager.getConex().prepareStatement(comando);
                ResultSet resultado = statement.executeQuery()) {
            
            //bucle que listara la tipusPlaza segun cuantos resultados de el comando
            while (resultado.next()) {
                TipusPlaza tipusPlaza = new TipusPlaza();
                tipusPlaza.setId(resultado.getInt("ID"));
                tipusPlaza.setNom(resultado.getString("NOM"));
                tipusPlaza.setFuncion(resultado.getString("FUNCIO"));

                listaPla.add(tipusPlaza);//se añade a la lista
            }
        } catch (SQLException e) {
            // si el try devuelve error, se imprimira el mensaje
            System.err.println("Err listar tipusPlaza: " + e.getMessage());
        }

        return listaPla;
    }

    //metodo para editar un tipo de plaza
    @Override
    public void editar(TipusPlaza tipusPlaza) {
        //este es el comando que se utilizara para hacer update a la tipusPlaza
        String comando = "UPDATE TIPUS_PLAZA SET NOM=?, FUNCIO=? WHERE ID=?";

        //aqui se prepara la base de datos junto a su conexion y le pasamos el comando
        try (PreparedStatement statement = DataBaseManager.getConex().prepareStatement(comando)) {
            // por cada interrogante se sustituira por el valor en orden de la tipusPlaza
            statement.setString(1, tipusPlaza.getNom());
            statement.setString(2, tipusPlaza.getFuncion());
            statement.setInt(3, tipusPlaza.getId());

            //ejcuta el comando
            statement.executeUpdate();//update para hacer modificaciones
        } catch (SQLException e) {
            // si el try devuelve error, se imprimira el mensaje
            System.err.println("Err editar tipusPlaza: " + e.getMessage());
        }
    }

    //metodo para eliminar un tipo de plaza por id
    @Override
    public void eliminarPorId(Integer id) {
        //comando para eliminar tipusPlazas por id
        String comando = "DELETE FROM TIPUS_PLAZA WHERE ID=?";
        
        // aqui se prepara la base de datos junto a su conexion y le pasamos el comando
        try (PreparedStatement statement = DataBaseManager.getConex().prepareStatement(comando)) {
            // se le pasa el valor del interogante, con el id que se busca
            statement.setInt(1, id);

            //ejcuta el comando
            statement.executeUpdate();
        } catch (SQLException e) {
            // si el try devuelve error, se imprimira el mensaje
            System.err.println("Err Recojer tipusPlaza: " + e.getMessage());
        }
}
}
