package es.programacion.cide.DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import es.programacion.cide.db.DataBaseManager;
import es.programacion.cide.model.Ocupa;

public class OcupaDao implements Dao<Ocupa, Integer> {

    //metodo para insertar una ocupaccion
    @Override
    public void insertar(Ocupa ocupa) {
        // este es el comando en sqlite para insertar valores a la base de datos
        String comando = "INSERT INTO OCUPA (NSS_EMPLEADO,CODI_PLAZA,DATA_INICI,DATA_FI) VALUES(?,?,?,?)";
        // aqui se prepara la base de datos junto a su conexion y le pasamos el comando
        try (PreparedStatement statement = DataBaseManager.getConex().prepareStatement(comando)) {
            // por cada interrogante dentro de values recojemos los datos de ocupa y se
            // pone en values
            statement.setLong(1, ocupa.getNssEmp());
            statement.setInt(2, ocupa.getCodiPlaza());
            statement.setString(3, ocupa.getDataInici());
            statement.setString(4, ocupa.getDataFi());
            //ejecuta el comando
            statement.executeUpdate();//update para modificar
        } catch (SQLException e) {
            // en caso de error al preparar la conexion, se imprime el mensaje del error
            System.err.println("Err insert ocupa: " + e.getMessage());
        }
    }

    //metodo para recojer una ocupacion por id
    @Override
    public Ocupa recojerPorId(Integer id) {
        // este es el comando que servira para recojer una ocupacion por id
        String comando = "SELECT * FROM OCUPA WHERE ID=?";
        // aqui se prepara la base de datos junto a su conexion y le pasamos el comando
        try (PreparedStatement statement = DataBaseManager.getConex().prepareStatement(comando)) {
            // se le pasa el valor del interogante, con el id que se busca
            statement.setInt(1, id);
            //resultset ejecuta el comando
            ResultSet resultado = statement.executeQuery();
            // este bucle lista el que ocupa que contenga el numero de id
            while (resultado.next()) {
                Ocupa ocupa = new Ocupa();
                ocupa.setId(resultado.getInt("ID"));
                ocupa.setNssEmp(resultado.getLong("NSS_EMPLEADO"));
                ocupa.setCodiPlaza(resultado.getInt("CODI_PLAZA"));
                ocupa.setDataInici(resultado.getString("DATA_INICI"));
                ocupa.setDataFi(resultado.getString("DATA_FI"));
                
                return ocupa;
            }
        } catch (SQLException e) {
            // si el try devuelve error, se imprimira el mensaje
            System.err.println("Err Recojer ocupa: " + e.getMessage());
        }
        // en caso de no haber ninguna ocupacion con ese id, no devuelve nada
        return null;
    }

    //metodo para listar todas las ocupaciones
    @Override
    public List<Ocupa> listarTodos() {
        // comando que se usara para listar todas las ocupaciones
        String comando = "SELECT * FROM OCUPA";
        // arrayList para poder guardar todas las ocupaciones listadas
        List<Ocupa> listaOcu = new ArrayList<>();

        // aqui se prepara la base de datos junto a su conexion y le pasamos el comando,
        // ademas usamos resulset para ejecutar el comando
        try (PreparedStatement statement = DataBaseManager.getConex().prepareStatement(comando);
                ResultSet resultado = statement.executeQuery()) {
            
            //bucle que listara las ocupaciones segun los resultados de el comando
            while (resultado.next()) {
                Ocupa ocupa = new Ocupa();
                ocupa.setId(resultado.getInt("ID"));
                ocupa.setNssEmp(resultado.getLong("NSS_EMPLEADO"));
                ocupa.setCodiPlaza(resultado.getInt("CODI_PLAZA"));
                ocupa.setDataInici(resultado.getString("DATA_INICI"));
                ocupa.setDataFi(resultado.getString("DATA_FI"));

                listaOcu.add(ocupa);//se añade a la lista
            }
        } catch (SQLException e) {
            // si el try devuelve error, se imprimira el mensaje
            System.err.println("Err listar ocupa: " + e.getMessage());
        }

        return listaOcu;
    }

    //metodo para editar las ocupaciones
    @Override
    public void editar(Ocupa ocupa) {
        //este es el comando que se utilizara para hacer update a la ocupacion
        String comando = "UPDATE OCUPA SET NSS_EMPLEADO=?, CODI_PLAZA=?, DATA_INICI=?, DATA_FI=? WHERE ID=?";

        //aqui se prepara la base de datos junto a su conexion y le pasamos el comando
        try (PreparedStatement statement = DataBaseManager.getConex().prepareStatement(comando)) {
            // por cada interrogante se sustituira por el valor en orden de la plaza
            statement.setLong(1, ocupa.getNssEmp());
            statement.setInt(2, ocupa.getCodiPlaza());
            statement.setString(3, ocupa.getDataInici());
            statement.setString(4, ocupa.getDataFi());
            statement.setInt(5, ocupa.getId());
            //ejcuta el comando
            statement.executeUpdate();//update para modificar
        } catch (SQLException e) {
            // si el try devuelve error, se imprimira el mensaje
            System.err.println("Err editar ocupa: " + e.getMessage());
        }
    }

    //metodo para eliminar una ocupacion por id
    @Override
    public void eliminarPorId(Integer id) {
        //comando para eliminar una ocupacion por id
        String comando = "DELETE FROM OCUPA WHERE ID=?";
        
        // aqui se prepara la base de datos junto a su conexion y le pasamos el comando
        try (PreparedStatement statement = DataBaseManager.getConex().prepareStatement(comando)) {
            //statemeent.setint pondra el id en el primer ? justo al lado de ID=?
            statement.setInt(1, id);
            //ejecuta el comando
            statement.executeUpdate();//update para modificar
        } catch (SQLException e) {
            // si el try devuelve error, se imprimira el mensaje
            System.err.println("Err Recojer ocupa: " + e.getMessage());
        }
}
}
