package es.programacion.cide.DAO;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import es.programacion.cide.db.DataBaseManager;
import es.programacion.cide.model.Nomina;

public class NominaDao implements Dao<Nomina, Integer> {

    @Override
    public void insertar(Nomina nomina) {
        String comando = "INSERT INTO nomina (NSS,NOM,APELLIDOS,EMAIL,IBAN) VALUES(?,?,?,?,?)";
        try (PreparedStatement statement = DataBaseManager.getConnection().prepareStatement(comando)) {
            statement.setInt(1, nomina.getNss());
            statement.setString(2, nomina.getNom());
            statement.setString(3, nomina.getApellidos());
            statement.setString(4, nomina.getEmail());
            statement.setString(5, nomina.getIban());
        } catch (SQLException e) {
            System.err.println("Err insert empelado: " + e.getMessage());
        }
    }

    @Override
    public Nomina recojerPorId(Integer id) {
        return null;
    }

    @Override
    public List<Nomina> listarTodos() {
        return null;
    }

    @Override
    public void editar(Nomina valor) {
            
    }

    @Override
    public void eliminarPorId(Integer id) {
            
    }
}
