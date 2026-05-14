package es.programacion.cide.view.subpanelsBDD;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import es.programacion.cide.DAO.EmpleadoDao;
import es.programacion.cide.model.Empleado;

public class PanelEmpleado extends PanelAbstractoGeneral<Empleado> {
    
    //atributos
    private EmpleadoDao daoEmpleado= new EmpleadoDao();

    //constructor
    public PanelEmpleado(){
        super(new String[]{"ID", "NSS" ,"Nombre", "Apellido", "Email", "IBAN"});
    }
    //getters y setters

    //metodos
    @Override
    protected void cargarDatos() {
        modelotabla.setRowCount(0);
        for(Empleado emp: daoEmpleado.listarTodos()){
            modelotabla.addRow(new Object[]{
                emp.getId(), emp.getNss(), emp.getNom(),
                emp.getApellidos(), emp.getEmail(), emp.getIban()
            });
        }     
    }

    @Override
    protected void anadir() {
        JTextField fieldNss     = new JTextField();
        JTextField fieldNombre     = new JTextField();
        JTextField fieldApellido = new JTextField();
        JTextField fieldEmail   = new JTextField();
        JTextField fieldIban    = new JTextField();
        Object[] campos = {
            "NSS:", fieldNss, "Nombre:", fieldNombre, "Cognoms:", fieldApellido,
            "Email:", fieldEmail, "IBAN:", fieldIban
        };
        int res = JOptionPane.showConfirmDialog(this, campos, "Nou empleat", JOptionPane.OK_CANCEL_OPTION);
        if (res == JOptionPane.OK_OPTION) {
            Empleado emp = new Empleado();
            emp.setNss(Integer.parseInt(fieldNss.getText().trim()));
            emp.setNom(fieldNombre.getText().trim());
            emp.setApellidos(fieldApellido.getText().trim());
            emp.setEmail(fieldEmail.getText().trim());
            emp.setIban(fieldIban.getText().trim());
            daoEmpleado.insertar(emp); 
            cargarDatos();
        }
        
    }

    @Override
    protected void eliminar(Integer id) {
        if (id == null) return;
        Empleado emp = daoEmpleado.recojerPorId(id);
        if (emp == null) return;

        JTextField fieldNss     = new JTextField(String.valueOf(e.getNss()));
        JTextField fieldNombre     = new JTextField(e.getNom());
        JTextField fieldApellido = new JTextField(e.getApellidos());
        JTextField fieldEmail   = new JTextField(e.getEmail());
        JTextField fieldIban    = new JTextField(e.getIban());
        Object[] campos = {
            "NSS:", fieldNss, "Nom:", fieldNombre, "Cognoms:", fieldApellido,
            "Email:", fieldEmail, "IBAN:", fieldIban
        };
        int res = JOptionPane.showConfirmDialog(this, campos, "Editar empleat", JOptionPane.OK_CANCEL_OPTION);
        if (res == JOptionPane.OK_OPTION) {
            emp.setNss(Integer.parseInt(fieldNss.getText().trim()));
            emp.setNom(fieldNombre.getText().trim());
            emp.setApellidos(fieldApellido.getText().trim());
            emp.setEmail(fieldEmail.getText().trim());
            emp.setIban(fieldIban.getText().trim());
            daoEmpleado.editar(emp);  // aquí usa el DAO
            cargarDatos();
        }
        
    }

    @Override
    protected void editar(Integer id) {
        // TODO Auto-generated method stub
        
    }

    @Override
    protected void buscar(String elementoABuscar) {
        // TODO Auto-generated method stub
        
    }

    @Override
    protected List<Empleado> listarTodos() {
        // TODO Auto-generated method stub
        return null;
    }

}
