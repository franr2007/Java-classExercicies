package es.programacion.cide.DAO;

import java.util.List;
/*
    DAO significa Data Access Object (Objeto de Acceso a Datos)
    esta clase solo se encarga de hablar con la base de datos
    utilizando los modelos logicos que hacen referencia
    a todas las tablas de la base de datos
*/
//clase abstracta para las clases hijas
//x se referira al tipo de clase Empleado,Nomina,Plaza,etc..
public interface Dao<X, ID> {
    //metodos

    //metodo para insertar
    void insertar(X obj);

    //metodo para recojer un id
    X recojerPorId(ID id);

    //metodo que lista todo el contenido de la tabla
    List<X> listarTodos();

    //metodo para editar
    void editar(X obj);

    void eliminarPorId(ID id);
}