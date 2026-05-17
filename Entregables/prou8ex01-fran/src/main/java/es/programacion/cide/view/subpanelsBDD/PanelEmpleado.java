package es.programacion.cide.view.subpanelsBDD;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import es.programacion.cide.DAO.EmpleadoDao;
import es.programacion.cide.model.Empleado;

public class PanelEmpleado extends PanelAbstractoGeneral {

    // atributos
    private EmpleadoDao empDao = new EmpleadoDao();

    // constructor
    public PanelEmpleado() {
        // parametros de la tabla
        super(new String[] { "ID", "NSS", "Nombre", "Apellido", "Email", "IBAN" }, "Busca por nombre y apellidos");

        // se cargan los datos para poder ver los empleados que hay
        cargarDatos();
    }
    // getters y setters

    // metodos

    // metodo para listar a los empleados dentro de la base de datos
    @Override
    protected void cargarDatos() {
        // setrowcount(0) vacia todas las filas de la tabla
        modelotabla.setRowCount(0);

        // Por cada empleado dentro de la base de datos se creara una fila con su info
        for (Empleado emp : empDao.listarTodos()) {
            modelotabla.addRow(new Object[] {
                    emp.getId(), emp.getNss(), emp.getNom(),
                    emp.getApellidos(), emp.getEmail(), emp.getIban()
            });
        }
    }

    // metodo para añadir un empleado
    @Override
    protected void anadir() {
        Boolean valido = false;
        JTextField fieldNss = new JTextField();
        JTextField fieldNombre = new JTextField();
        JTextField fieldApellido = new JTextField();
        JTextField fieldEmail = new JTextField();
        JTextField fieldIban = new JTextField();

        // esto es un array de objetos que tiene dentro los diferentes
        // campos que se van a rellenar
        Object[] campos = {
                "NSS:", fieldNss, "Nombre:", fieldNombre, "Cognoms:", fieldApellido,
                "Email:", fieldEmail, "IBAN:", fieldIban
        };

        // mientras no sea valido el bucle seguira
        while (!valido) {

            // showConfirmDialog hace un JOptionPane con el array de objetos anterior
            // y guarda si cancela o no la operacion
            int formNuevoEmp = JOptionPane.showConfirmDialog(this, campos, "Nuevo empleado",
                    JOptionPane.OK_CANCEL_OPTION);

            // si el usuario cancela sale de la funcion añadir
            if (formNuevoEmp != JOptionPane.OK_OPTION)
                return;

            // si los valores son validos
            if (validarCampos(fieldNss, fieldNombre, fieldApellido, fieldIban, null)) {
                Empleado emp = new Empleado(); // se crea un nuevo empleado

                // se le pone los datos de los textfield
                // .trim() elimina los espacio que haya entre los textos
                emp.setNss(Long.parseLong(fieldNss.getText().trim()));
                emp.setNom(fieldNombre.getText().trim());
                emp.setApellidos(fieldApellido.getText().trim());
                emp.setEmail(fieldEmail.getText().trim());
                emp.setIban(fieldIban.getText().trim().toUpperCase());

                // se llama a la funcion insertar de empDao
                // para insertar la info en la base de datos
                empDao.insertar(emp);

                // se vuelve a cargar los datos para actualizar la tabla
                cargarDatos();
                valido = true; // sale del while
            }
        }
    }

    // metodo para eliminar empleados
    @Override
    protected void eliminar(Integer id) {
        if (id == null)
            return; // si no hay id no hace nada
        // JOptionPane que pregunta si quieres eliminar al empleado
        // dandote a elejir entre si o no
        int eleccion = JOptionPane.showConfirmDialog(this,
                "Quieres eliminar a este empleado?",
                "eliminar empleado...",
                JOptionPane.YES_NO_OPTION);

        // si la eleccion es si
        if (eleccion == JOptionPane.YES_OPTION) {
            // se llama a la funcion eliminar de empDao
            // que hara el comando para eliminarlo de la base de datos
            empDao.eliminarPorId(id);

            // y se actualizara la tabla
            cargarDatos();
        }

    }

    // metodo para editar los datos de un empleado
    @Override
    protected void editar(Integer id) {
        if (id == null)
            return; // si no hay id no hace nada
        Empleado emp = empDao.recojerPorId(id);
        if (emp == null)
            return; // si no hay empleado con ese id no hace nada

        Boolean valido = false;
        JTextField fieldNss = new JTextField(String.valueOf(emp.getNss()));
        JTextField fieldNombre = new JTextField(emp.getNom());
        JTextField fieldApellido = new JTextField(emp.getApellidos());
        JTextField fieldEmail = new JTextField(emp.getEmail());
        JTextField fieldIban = new JTextField(emp.getIban());

        // esto es un array de objetos que tiene dentro los diferentes
        // campos que se van a rellenar
        Object[] campos = {
                "NSS:", fieldNss, "Nom:", fieldNombre, "Cognoms:", fieldApellido,
                "Email:", fieldEmail, "IBAN:", fieldIban
        };

        // mientras no sea valido
        while (!valido) {

            // showConfirmDialog hace un JOptionPane con el array de objetos anterior
            // y guarda si cancela o no la operacion
            int formEditarEmp = JOptionPane.showConfirmDialog(this, campos, "Editar empleado",
                    JOptionPane.OK_CANCEL_OPTION);

            // si el usuario cancela sale de la funcion editar
            if (formEditarEmp != JOptionPane.OK_OPTION)
                return;

            // si los valores son validos
            if (validarCampos(fieldNss, fieldNombre, fieldApellido, fieldIban, id)) {

                // se le pone los datos de los textfield
                // .trim() elimina los espacio que haya entre los textos
                emp.setNss(Long.parseLong(fieldNss.getText().trim()));
                emp.setNom(fieldNombre.getText().trim());
                emp.setApellidos(fieldApellido.getText().trim());
                emp.setEmail(fieldEmail.getText().trim());
                emp.setIban(fieldIban.getText().trim().toUpperCase());

                // llama a la funcion editar de empDao
                // que es la funcion que ejcutara el comando sql
                empDao.editar(emp);
                //carga los datos
                cargarDatos();
                valido = true; // sale del while
            }
        }
    }

    // metodo para buscar por nombre entre los empleados
    @Override
    protected void buscar(String elementoABuscar) {
        // setrowcount vacia las filas de la tabla
        modelotabla.setRowCount(0);

        // Por cada empleado dentro de la base de datos
        for (Empleado emp : empDao.listarTodos()) {
            // cojera su nombre completo
            String nombreCompleto = (emp.getNom() + " " + emp.getApellidos()).toLowerCase();

            // y compara el nombre completo con lo que se ha escrito en la busqueda
            // y mira si contiene esas letras el nombrecompleto
            if (nombreCompleto.contains(elementoABuscar)) {
                // por cada coindicencia, se añade una fila con el empleado
                modelotabla.addRow(new Object[] {
                        emp.getId(), emp.getNss(), emp.getNom(),
                        emp.getApellidos(), emp.getEmail(), emp.getIban()
                });
            }
        }

    }

    // metodo privado que valida las condicionees que tiene que tener cada campo
    // dentro de su valor
    private boolean validarCampos(JTextField fieldNss, JTextField fieldNombre,
            JTextField fieldApellido, JTextField fieldIban, Integer id) {

        // validar vacios

        // si los campos estan vacios se pedira que se rellene
        if (fieldNss.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "El NSS es obligatorio");
            return false;
        }
        if (fieldNombre.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "El nombre es obligatorio");
            return false;
        }
        if (fieldApellido.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Los apellidos son obligatorios");
            return false;
        }
        if (fieldIban.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "El IBAN es obligatorio");
            return false;
        }

        // validar nss

        // coje el texto del textfiel del nss
        // y con regex se valida el formato de que tenga 12 numeros
        if (!fieldNss.getText().trim().matches("\\d{12}")) {
            JOptionPane.showMessageDialog(this, "El NSS debe tener 12 digitos");
            return false;
        }

        // validar IBAN

        // coje el texto del textfiel del IBAN
        // y con regex se valida el formato de que tenga ES al principio y los 22
        // digitos
        if (!fieldIban.getText().trim().toUpperCase().matches("ES\\d{22}")) {
            JOptionPane.showMessageDialog(this, "El IBAN debe empezar con ES seguido de 22 numeros");
            return false;
        }

        // validar duplicados

        // por cada empleado dentro de la base de datos
        for (Empleado emp : empDao.listarTodos()) {

            // si tiene una id ya asignada es que esta editando
            if (id != null && emp.getId() == id)
                continue; // hace que no se comprueba el emp con si mismo

            // si un emp tiene el mismo nss que el de el textfield
            if (emp.getNss() == Long.parseLong(fieldNss.getText().trim())) {
                // devuelve un mensaje de error
                JOptionPane.showMessageDialog(this, "Ya existe un empleado con ese NSS");
                return false; // y de vuelve falso
            }

            // si el iban de un emp es igual indiferentemente de las mayus y minusculas
            // y es exactamente igual que el del textfield
            if (emp.getIban().equalsIgnoreCase(fieldIban.getText().trim())) {
                // devuelve un mensaje de error
                JOptionPane.showMessageDialog(this, "Ya existe un empleado con ese IBAN");
                return false;// y de vuelve falso
            }
        }
        // si nunguna de las validaciones anteriores da falso esta todo bien
        // y se de vuelve true
        return true;
    }

}