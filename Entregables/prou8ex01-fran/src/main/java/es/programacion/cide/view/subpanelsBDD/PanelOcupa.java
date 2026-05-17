package es.programacion.cide.view.subpanelsBDD;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import es.programacion.cide.DAO.EmpleadoDao;
import es.programacion.cide.DAO.OcupaDao;
import es.programacion.cide.DAO.PlazaDao;
import es.programacion.cide.model.Empleado;
import es.programacion.cide.model.Ocupa;
import es.programacion.cide.model.Plaza;

public class PanelOcupa extends PanelAbstractoGeneral {

    // atributos
    private OcupaDao ocupaDao;
    private EmpleadoDao empDao;
    private PlazaDao plaDao;

    // constructor
    public PanelOcupa() {
        // parametros de la tabla
        super(new String[] { "ID", "Nss Empleado", "Codigo Plaza", "Fecha Inicio", "Fecha Final" },"Busca por nss de un empleado");

        ocupaDao = new OcupaDao();
        empDao = new EmpleadoDao();
        plaDao = new PlazaDao();

        // se cargan los datos para poder ver las ocupaciones que hay
        cargarDatos();
    }
    // getters y setters

    // metodos

    // metodo para listar las ocupaciones dentro de la base de datos
    @Override
    protected void cargarDatos() {
        // setrowcount(0) vacia todas las filas de la tabla
        modelotabla.setRowCount(0);

        // Por cada tipo de plaza dentro de la base de datos se creara una fila con su
        // info
        for (Ocupa ocupa : ocupaDao.listarTodos()) {
            modelotabla.addRow(new Object[] {
                    ocupa.getId(), ocupa.getNssEmp(), ocupa.getCodiPlaza(),
                    ocupa.getDataInici(), ocupa.getDataFi()
            });
        }
    }

    // metodo para añadir una ocupacion
    @Override
    protected void anadir() {
        Boolean valido = false;
        // se usa comboBox porque son datos que deben estar desde antes
        JComboBox<Empleado> comboNssEmp = new JComboBox<>();
        JComboBox<Plaza> comboCodiPla = new JComboBox<>();
        JTextField fieldFechaIncio = new JTextField();
        JTextField fieldFechaFinal = new JTextField();

        // mete dentro Empleados que ya existen
        comboNssEmp.addItem(null);
        for (Empleado emp : empDao.listarTodos()) {
            comboNssEmp.addItem(emp);
        }

        // mete dentro los tipos de plaza que ya existen
        comboCodiPla.addItem(null);
        for (Plaza pla : plaDao.listarTodos()) {
            comboCodiPla.addItem(pla);
        }

        // esto es un array de objetos que tiene dentro los diferentes
        // campos que se van a rellenar
        Object[] campos = {
                "Nss Empleado:", comboNssEmp, "Codigo Plaza:", comboCodiPla,
                "Fecha Incio:", fieldFechaIncio, "Fecha final:", fieldFechaFinal
        };

        // mientras no sea valido el bucle seguira
        while (!valido) {

            // showConfirmDialog hace un JOptionPane con el array de objetos anterior
            // y guarda si cancela o no la operacion
            int formNuevOcupa = JOptionPane.showConfirmDialog(this, campos, "Nuevo ocupacion",
                    JOptionPane.OK_CANCEL_OPTION);

            // si el usuario cancela sale de la funcion añadir
            if (formNuevOcupa != JOptionPane.OK_OPTION)
                return;

            // si los valores son validos
            if (validarCampos(comboNssEmp, comboCodiPla, fieldFechaIncio, fieldFechaFinal, null)) {
                Ocupa ocupa = new Ocupa(); // se crea un nueva pcupacion
                Empleado emp = (Empleado) comboNssEmp.getSelectedItem();
                Plaza pla = (Plaza) comboCodiPla.getSelectedItem();
                Long nssEmp;
                Integer codiPla;

                // se controla el null
                if (pla != null) {
                    // asi el get no peta el programa
                    codiPla = pla.getCodi();
                } else {
                    codiPla = null;
                }

                // hace lo mismo que el anterior pero con empleado
                if (emp != null) {
                    nssEmp = emp.getNss();
                } else {
                    nssEmp = null;
                }

                // se le pone los datos de los textfield
                // .trim() elimina los espacio que haya entre los textos
                ocupa.setNssEmp(nssEmp);
                ocupa.setCodiPlaza(codiPla);
                ocupa.setDataInici(fieldFechaIncio.getText().trim());
                ocupa.setDataFi(fieldFechaFinal.getText().trim());

                // se llama a la funcion insertar de ocupaDao
                // para insertar la info en la base de datos
                ocupaDao.insertar(ocupa);

                // se vuelve a cargar los datos para actualizar la tabla
                cargarDatos();
                valido = true; // sale del while
            }
        }
    }

    // metodo para eliminar una ocupacion
    @Override
    protected void eliminar(Integer id) {
        if (id == null)
            return; // si no hay id no hace nada
        // JOptionPane que pregunta si quieres eliminar una ocupacion
        // dandote a elejir entre si o no
        int eleccion = JOptionPane.showConfirmDialog(this,
                "Quieres eliminar esta ocupacion",
                "eliminar ocupacion...",
                JOptionPane.YES_NO_OPTION);

        // si la eleccion es si
        if (eleccion == JOptionPane.YES_OPTION) {
            // se llama a la funcion eliminar de OcupaDao
            // que hara el comando para eliminarlo de la base de datos
            ocupaDao.eliminarPorId(id);

            // y se actualizara la tabla
            cargarDatos();
        }

    }

    // metodo para editar los datos de una ocupacion
    @Override
    protected void editar(Integer id) {
        if (id == null)
            return; // si no hay id no hace nada
        Ocupa ocupa = ocupaDao.recojerPorId(id);
        if (ocupa == null)
            return; // si no hay una ocupacion con ese id no hace nada

        Boolean valido = false;
        JComboBox<Empleado> comboNssEmp = new JComboBox<>();
        JComboBox<Plaza> comboCodiPla = new JComboBox<>();
        JTextField fieldFechaIncio = new JTextField(ocupa.getDataInici());
        JTextField fieldFechaFinal = new JTextField(ocupa.getDataFi());

        // mete dentro Empleados que ya existen
        comboNssEmp.addItem(null);
        for (Empleado emp : empDao.listarTodos()) {
            comboNssEmp.addItem(emp);
        }

        // mete dentro los tipos de plaza que ya existen
        comboCodiPla.addItem(null);
        for (Plaza pla : plaDao.listarTodos()) {
            comboCodiPla.addItem(pla);
        }

        // esto es un array de objetos que tiene dentro los diferentes
        // campos que se van a rellenar
        Object[] campos = {
                "Nss Empleado:", comboNssEmp, "Codigo Plaza:", comboCodiPla,
                "Fecha Incio:", fieldFechaIncio, "Fecha final:", fieldFechaFinal
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
            if (validarCampos(comboNssEmp, comboCodiPla, fieldFechaIncio, fieldFechaFinal, id)) {
                Empleado emp = (Empleado) comboNssEmp.getSelectedItem();
                Plaza pla = (Plaza) comboCodiPla.getSelectedItem();
                Long nssEmp;
                Integer codiPla;

                // se controla el null
                if (pla != null) {
                    // asi el get no peta el programa
                    codiPla = pla.getCodi();
                } else {
                    codiPla = null;
                }

                // hace lo mismo que el anterior pero con empleado
                if (emp != null) {
                    nssEmp = emp.getNss();
                } else {
                    nssEmp = null;
                }
                // se le pone los datos de los textfield
                // .trim() elimina los espacio que haya entre los textos
                ocupa.setNssEmp(nssEmp);
                ocupa.setCodiPlaza(codiPla);
                ocupa.setDataInici(fieldFechaIncio.getText().trim());
                ocupa.setDataFi(fieldFechaFinal.getText().trim());

                // llama a la funcion editar de ocupaDao
                // que es la funcion que ejcutara el comando sql
                ocupaDao.editar(ocupa);
                cargarDatos();
                valido = true; // sale del while
            }
        }
    }

    // metodo para buscar por el nss del empleado
    // entre las ocupaciones
    @Override
    protected void buscar(String elementoABuscar) {
        // setrowcount vacia las filas de la tabla
        modelotabla.setRowCount(0);

        // Por cada tipo de ocupacion dentro de la base de datos
        for (Ocupa ocupa : ocupaDao.listarTodos()) {
            // cojera el nss del empleado
            String nssEmp = String.valueOf(ocupa.getNssEmp());

            // y compara el nss del empleado
            // con lo que se ha escrito en la busqueda
            if (nssEmp.contains(elementoABuscar)) {
                // por cada coindicencia, se añade una fila con el tipo de plaza
                modelotabla.addRow(new Object[] {
                        ocupa.getId(), ocupa.getNssEmp(), ocupa.getCodiPlaza(),
                        ocupa.getDataInici(), ocupa.getDataFi()
                });
            }
        }

    }

    // metodo privado que valida las condicionees que tiene que tener cada campo
    // dentro de su valor
    private boolean validarCampos(JComboBox<Empleado> comboNssEmp, JComboBox<Plaza> comboCodiPla,
            JTextField fieldFehcaIncio,
            JTextField fieldFechaFin, Integer id) {

        Empleado emp = (Empleado) comboNssEmp.getSelectedItem();
        Plaza pla = (Plaza) comboCodiPla.getSelectedItem();

        // validar vacios

        // si los campos estan vacios se pedira que se rellene
        if (emp == null) {
            JOptionPane.showMessageDialog(this, "El nss del empleado es obligatorio");
            return false;
        }
        if (pla == null) {
            JOptionPane.showMessageDialog(this, "El codigo de la plaza es obligatorio");
            return false;
        }
        if (fieldFehcaIncio.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "La fecha inicial es obligatoria");
            return false;
        }

        // validar fechas
        // dateTimeFormatter crea un formato para una fecha con el formato dd/mm/yyyy
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try {
            // se intenta pasar a Localdate la fecha dentro Jtexfield
            // si no cumple el formato fallara y ira al catch
            LocalDate.parse(fieldFehcaIncio.getText().trim(), formatoFecha);

            // fechaFin es opcional
            if (!fieldFechaFin.getText().trim().isEmpty()) {
                // si se pone hara lo mismo que fechaIncio
                LocalDate.parse(fieldFechaFin.getText().trim(), formatoFecha);
            }
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(this, "Las fechas deben tener formato dd/MM/yyyy");
            return false;
        }

        // validar duplicados

        // por cada ocupacion dentro de la base de datos
        for (Ocupa ocupa : ocupaDao.listarTodos()) {

            // si tiene un id ya asignado es que esta editando
            if (id != null && ocupa.getId() == id)
                continue; // hace que no se compruebe la ocupacion con si mismo

            // si el nss de un empleado es el mismo el del Jcombobox
            if (ocupa.getNssEmp().equals(emp.getNss())) {
                // devuelve un mensaje de error
                JOptionPane.showMessageDialog(this, "Ya existe una ocupacion con este Nss");
                return false; // y de vuelve falso
            }
        }
        return true;
    }

}