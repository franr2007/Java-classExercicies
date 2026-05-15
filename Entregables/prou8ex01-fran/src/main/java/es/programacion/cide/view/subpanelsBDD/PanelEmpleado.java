package es.programacion.cide.view.subpanelsBDD;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import es.programacion.cide.DAO.EmpleadoDao;
import es.programacion.cide.model.Empleado;

public class PanelEmpleado extends PanelAbstractoGeneral {
    
    //atributos
    private EmpleadoDao daoEmpleado= new EmpleadoDao();

    //constructor
    public PanelEmpleado(){
        super(new String[]{"ID", "NSS" ,"Nombre", "Apellido", "Email", "IBAN"});

        cargarDatos();
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

        int opcion = JOptionPane.showConfirmDialog(this,
                "Quieres eliminar a este empleado?",
                "eliminar empleado...",
                JOptionPane.YES_NO_OPTION);

        if (opcion == JOptionPane.YES_OPTION) {
            daoEmpleado.eliminarPorId(id);
            cargarDatos();
        }
        
    }

    @Override
    protected void editar(Integer id) {
        if (id == null) return;
        Empleado emp = daoEmpleado.recojerPorId(id);
        if (emp == null) return;

        JTextField fieldNss     = new JTextField(String.valueOf(emp.getNss()));
        JTextField fieldNombre     = new JTextField(emp.getNom());
        JTextField fieldApellido = new JTextField(emp.getApellidos());
        JTextField fieldEmail   = new JTextField(emp.getEmail());
        JTextField fieldIban    = new JTextField(emp.getIban());

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
            daoEmpleado.editar(emp);
            cargarDatos();
        }
    }

    @Override
    protected void buscar(String elementoABuscar) {
         modelotabla.setRowCount(0);

        for (Empleado e : daoEmpleado.listarTodos()) {
            boolean coincideNombre    = e.getNom().toLowerCase().contains(elementoABuscar);
            boolean coincideApellidos = e.getApellidos().toLowerCase().contains(elementoABuscar);

            if (coincideNombre || coincideApellidos) {
                modelotabla.addRow(new Object[]{
                    e.getNss(),
                    e.getNom(),
                    e.getApellidos(),
                    e.getEmail(),
                    e.getIban()
                });
            }
        }
        
    }
}
