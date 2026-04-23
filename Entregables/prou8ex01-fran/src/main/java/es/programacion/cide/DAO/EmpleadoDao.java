package es.programacion.cide.DAO;

import java.util.List;

import es.programacion.cide.model.Empleado;

public class EmpleadoDao implements Dao<Empleado, Integer> {
    //atributos
    Empleado empleado;
    //constructor
    public EmpleadoDao(){
        empleado=new Empleado();
        
    }

    //getters y setters

    //metodos

    @Override
    public void insertar(Empleado obj) {
        
    }

    @Override
    public Empleado recojerPorId(Integer nss) {
        
    }

    @Override
    public List<Empleado> listarTodos() {
        
    }

    @Override
    public void actualizar(Empleado obj) {
            
    }

    @Override
    public void eliminarPorId(Integer id) {
            
    }
    // atributos

    // constructor

    // getters y setters

    // metodos
}
