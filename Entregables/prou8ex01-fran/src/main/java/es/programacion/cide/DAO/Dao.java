package es.programacion.cide.DAO;

import java.util.List;

public interface Dao<X, ID> {
    //metodos
    void insertar(X obj);

    X recojerPorId(ID id);

    List<X> listarTodos();

    void actualizar(X obj);

    void eliminarPorId(ID id);
}