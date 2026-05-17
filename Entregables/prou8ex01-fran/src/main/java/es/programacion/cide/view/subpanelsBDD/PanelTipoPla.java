package es.programacion.cide.view.subpanelsBDD;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import es.programacion.cide.DAO.TipusPlazaDao;
import es.programacion.cide.model.TipusPlaza;

public class PanelTipoPla extends PanelAbstractoGeneral {

    // atributos
    private TipusPlazaDao tipoPlaDao;

    // constructor
    public PanelTipoPla() {
        // parametros de la tabla
        super(new String[] { "ID", "Nombre", "Funcion" }, "Busca por el nombre del tipo de plaza");

        tipoPlaDao = new TipusPlazaDao();

        // se cargan los datos para poder ver los tipo de plazas que hay
        cargarDatos();
    }
    // getters y setters

    // metodos

    // metodo para listar los tipos de plaza dentro de la base de datos
    @Override
    protected void cargarDatos() {
        // setrowcount(0) vacia todas las filas de la tabla
        modelotabla.setRowCount(0);

        // Por cada tipo de plaza dentro de la base de datos se creara una fila con su
        // info
        for (TipusPlaza tipoPla : tipoPlaDao.listarTodos()) {
            modelotabla.addRow(new Object[] {
                    tipoPla.getId(), tipoPla.getNom(), tipoPla.getFuncion()
            });
        }
    }

    // metodo para añadir un tipo de plaza
    @Override
    protected void anadir() {
        Boolean valido = false;
        JTextField fieldNom = new JTextField();
        JTextField fieldFuncion = new JTextField();

        // esto es un array de objetos que tiene dentro los diferentes
        // campos que se van a rellenar
        Object[] campos = {
                "Nombre:", fieldNom, "Funcion:", fieldFuncion
        };

        // mientras no sea valido el bucle seguira
        while (!valido) {

            // showConfirmDialog hace un JOptionPane con el array de objetos anterior
            // y guarda si cancela o no la operacion
            int formNuevaTipoPla = JOptionPane.showConfirmDialog(this, campos, "Nuevo Tipo de plaza",
                    JOptionPane.OK_CANCEL_OPTION);

            // si el usuario cancela sale de la funcion añadir
            if (formNuevaTipoPla != JOptionPane.OK_OPTION)
                return;

            // si los valores son validos
            if (validarCampos(fieldNom, fieldFuncion, null)) {
                TipusPlaza TipoPla = new TipusPlaza(); // se crea un nuevo tipo de plaza

                // se le pone los datos de los textfield
                // .trim() elimina los espacio que haya entre los textos
                TipoPla.setNom(fieldNom.getText().trim());
                TipoPla.setFuncion(fieldFuncion.getText().trim());

                // se llama a la funcion insertar de tipoPlaDao
                // para insertar la info en la base de datos
                tipoPlaDao.insertar(TipoPla);

                // se vuelve a cargar los datos para actualizar la tabla
                cargarDatos();
                valido = true; // sale del while
            }
        }
    }

    // metodo para eliminar los tipos de plaza
    @Override
    protected void eliminar(Integer id) {
        if (id == null)
            return; // si no hay id no hace nada
        // JOptionPane que pregunta si quieres eliminar el tipo de plaza
        // dandote a elejir entre si o no
        int eleccion = JOptionPane.showConfirmDialog(this,
                "Quieres eliminar este tipo de plaza",
                "eliminar tipo de plaza...",
                JOptionPane.YES_NO_OPTION);

        // si la eleccion es si
        if (eleccion == JOptionPane.YES_OPTION) {
            // se llama a la funcion eliminar de tipoPlaDao
            // que hara el comando para eliminarlo de la base de datos
            tipoPlaDao.eliminarPorId(id);

            // y se actualizara la tabla
            cargarDatos();
        }

    }

    // metodo para editar los datos de un tipo de plaza
    @Override
    protected void editar(Integer id) {
        if (id == null)
            return; // si no hay id no hace nada
        TipusPlaza tipoPla = tipoPlaDao.recojerPorId(id);
        if (tipoPla == null)
            return; // si no hay un tipo de plaza con ese id no hace nada

        Boolean valido = false;
        JTextField fieldNom = new JTextField(tipoPla.getNom());
        JTextField fieldFuncion = new JTextField(tipoPla.getFuncion());

        // esto es un array de objetos que tiene dentro los diferentes
        // campos que se van a rellenar
        Object[] campos = {
                "Nombre:", fieldNom, "Funcion:", fieldFuncion
        };

        // mientras no sea valido
        while (!valido) {

            // showConfirmDialog hace un JOptionPane con el array de objetos anterior
            // y guarda si cancela o no la operacion
            int formEditarTipoPla = JOptionPane.showConfirmDialog(this, campos, "Editar tipo de plaza",
                    JOptionPane.OK_CANCEL_OPTION);

            // si el usuario cancela sale de la funcion editar
            if (formEditarTipoPla != JOptionPane.OK_OPTION)
                return;

            // si los valores son validos
            if (validarCampos(fieldNom, fieldFuncion, null)) {

                // se le pone los datos de los textfield
                // .trim() elimina los espacio que haya entre los textos
                tipoPla.setNom(fieldNom.getText().trim());
                tipoPla.setFuncion(fieldFuncion.getText().trim());

                // llama a la funcion editar de tipoPlaDao
                // que es la funcion que ejcutara el comando sql
                tipoPlaDao.editar(tipoPla);
                cargarDatos();
                valido = true; // sale del while
            }
        }
    }

    // metodo para buscar por nombre del tipo de plaza 
    // entre los tipos de plaza
    @Override
    protected void buscar(String elementoABuscar) {
        // setrowcount vacia las filas de la tabla
        modelotabla.setRowCount(0);

        // Por cada tipo de plaza dentro de la base de datos
        for (TipusPlaza tipoPla : tipoPlaDao.listarTodos()) {
            // cojera el nombre del tipo de plaza
            String nombreTipoPla = tipoPla.getNom().trim().toLowerCase();

            // y compara el nombre del tipo de plaza completo
            // con lo que se ha escrito en la busqueda
            if (nombreTipoPla.contains(elementoABuscar.trim().toLowerCase())) {
                // por cada coindicencia, se añade una fila con el tipo de plaza
                modelotabla.addRow(new Object[] {
                        tipoPla.getId(), tipoPla.getNom(), tipoPla.getFuncion()
                });
            }
        }

    }

    // metodo privado que valida las condicionees que tiene que tener cada campo
    // dentro de su valor
    private boolean validarCampos(JTextField fieldNom,
            JTextField fieldFuncion, Integer id) {

        // validar vacios

        // si los campos estan vacios se pedira que se rellene
        if (fieldNom.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "El Nombre de la plaza es obligatorio");
            return false;
        }
        if (fieldFuncion.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "El Salario de la plaza es obligatorio");
            return false;
        }

        // validar duplicados

        // por cada tipo de plaza dentro de la base de datos
        for (TipusPlaza tipoPla : tipoPlaDao.listarTodos()) {

            // si tiene un id ya asignado es que esta editando
            if (id != null && tipoPla.getId() == id)
                continue; // hace que no se compruebe tipoPla con si mismo

            // si un tipo de plaza es el mismo el del textfield
            if (tipoPla.getNom().trim().equalsIgnoreCase(fieldNom.getText().trim())) {
                // devuelve un mensaje de error
                JOptionPane.showMessageDialog(this, "Ya existe un tipo de plaza con ese Nombre");
                return false; // y de vuelve falso
            }
        }
        return true;
    }

}