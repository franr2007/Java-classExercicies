package es.programacion.cide.view.subpanelsBDD;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import es.programacion.cide.DAO.EmpleadoDao;
import es.programacion.cide.DAO.NominaDao;
import es.programacion.cide.DAO.PlazaDao;
import es.programacion.cide.model.Empleado;
import es.programacion.cide.model.Nomina;
import es.programacion.cide.model.Plaza;

public class PanelNomina extends PanelAbstractoGeneral {

    // atributos
    private NominaDao nomDao;
    private PlazaDao plaDao;
    private EmpleadoDao empDao;

    // constructor
    public PanelNomina() {
        // parametros de la tabla
        super(new String[] { "ID", "IBAN Pago", "Importe", "NSS Empleado", "CodigoPlaza" },"Busca por nss o Iban");

        nomDao = new NominaDao();
        plaDao = new PlazaDao();
        empDao = new EmpleadoDao();

        // se cargan los datos para poder ver las nominas que hay
        cargarDatos();
    }
    // getters y setters

    // metodos

    // metodo para listar las nominas dentro de la base de datos
    @Override
    protected void cargarDatos() {
        // setrowcount(0) vacia todas las filas de la tabla
        modelotabla.setRowCount(0);

        // Por cada nomina dentro de la base de datos se creara una fila con su info
        for (Nomina nom : nomDao.listarTodos()) {
            modelotabla.addRow(new Object[] {
                    nom.getId(), nom.getIbanPag(), nom.getImporte(),
                    nom.getNssEmpleado(), nom.getCodiPlaza()
            });
        }
    }

    // metodo para añadir una Nomina
    @Override
    protected void anadir() {
        Boolean valido = false;
        JTextField fieldIbanPag = new JTextField();
        JTextField fieldImporte = new JTextField();
        fieldImporte.setEditable(false);
        JComboBox<Empleado> comboEmp = new JComboBox<>();
        JComboBox<Plaza> comboPla = new JComboBox<>();

        // esto es un array de objetos que tiene dentro los diferentes
        // campos que se van a rellenar
        Object[] campos = {
                "IBAN pago:", fieldIbanPag, "Importe:", fieldImporte, "Nss Empleado:", comboEmp,
                "Codigo Plaza:", comboPla
        };

        // mete dentro los Empleados que ya existen
        comboEmp.addItem(null);
        //por cada empleado en la base de datos
        for (Empleado emp : empDao.listarTodos()) {
            //se mete en el combobox
            comboEmp.addItem(emp);
        }

        // hace lo mismo que el anterior pero con plaza
        comboPla.addItem(null);
        for (Plaza pla : plaDao.listarTodos()) {
            comboPla.addItem(pla);
        }

        //este actionListener hace que cada vez que se cambia de plaza
        //cambia el Jtextfield de importe por el salario de la plaza
        comboPla.addActionListener(e -> {
            //coje la plaza seleccionada
            Plaza pla = (Plaza) comboPla.getSelectedItem();
            //si no esta vacia
            if (pla != null) {
                //coje el salario de la plaza y mete el mismo valor
                fieldImporte.setText(String.valueOf(pla.getSalari()));
            } else {
                //si es nullo no se mete nada
                fieldImporte.setText("");
            }
        });

        // mientras no sea valido el bucle seguira
        while (!valido) {

            // showConfirmDialog hace un JOptionPane con el array de objetos anterior
            // y guarda si cancela o no la operacion
            int formNuevaNom = JOptionPane.showConfirmDialog(this, campos, "Nueva Nomina",
                    JOptionPane.OK_CANCEL_OPTION);

            // si el usuario cancela sale de la funcion añadir
            if (formNuevaNom != JOptionPane.OK_OPTION)
                return;

            // si los valores son validos
            if (validarCampos(fieldIbanPag, fieldImporte, comboEmp, comboPla, null)) {
                Nomina nom = new Nomina(); // se crea un nueva Nomina
                Empleado emp = (Empleado) comboEmp.getSelectedItem();
                Plaza pla = (Plaza) comboPla.getSelectedItem();
                Double importePla;
                Long nssEmp;

                // se controla el null
                if (emp != null) {
                    // asi el get no peta el programa
                    nssEmp = emp.getNss();
                } else {
                    nssEmp = null;
                }

                //hace lo mismo que lo anterior pero con plaza
                if (pla != null) {
                    importePla = pla.getSalari();
                } else {
                    importePla = null;
                }

                // se le pone los datos de los textfield
                // .trim() elimina los espacio que haya entre los textos
                nom.setIbanPag(fieldIbanPag.getText().toUpperCase().trim());
                nom.setImporte(importePla);
                nom.setNssEmleado(nssEmp);
                nom.setCodiPlaza(pla.getCodi());

                // se llama a la funcion insertar de nomDao
                // para insertar la info en la base de datos
                nomDao.insertar(nom);

                // se vuelve a cargar los datos para actualizar la tabla
                cargarDatos();
                valido = true; // sale del while
            }
        }
    }

    // metodo para eliminar las nominas
    @Override
    protected void eliminar(Integer id) {
        if (id == null)
            return; // si no hay id no hace nada
        // JOptionPane que pregunta si quieres eliminar la nomina
        // dandote a elejir entre si o no
        int eleccion = JOptionPane.showConfirmDialog(this,
                "Quieres eliminar esta Nomina",
                "eliminar Nomina...",
                JOptionPane.YES_NO_OPTION);

        // si la eleccion es si
        if (eleccion == JOptionPane.YES_OPTION) {
            // se llama a la funcion eliminar de nomDao
            // que hara el comando para eliminarlo de la base de datos
            nomDao.eliminarPorId(id);

            // y se actualizara la tabla
            cargarDatos();
        }

    }

    // metodo para editar los datos de una nomina
    @Override
    protected void editar(Integer id) {
        if (id == null)
            return; // si no hay id no hace nada
        Nomina nom = nomDao.recojerPorId(id);
        if (nom == null)
            return; // si no hay una nomina con ese id no hace nada

        Boolean valido = false;
        JTextField fieldIbanPag = new JTextField(nom.getIbanPag());
        JTextField fieldImporte = new JTextField(String.valueOf(nom.getImporte()));
        fieldImporte.setEditable(false);
        JComboBox<Empleado> comboEmp = new JComboBox<>();
        JComboBox<Plaza> comboPla = new JComboBox<>();

        // esto es un array de objetos que tiene dentro los diferentes
        // campos que se van a rellenar
        Object[] campos = {
                "IBAN pago:", fieldIbanPag, "Importe:", fieldImporte, "Nss Empleado:", comboEmp,
                "Codigo Plaza:", comboPla
        };

        // mete dentro los empleados que ya existen
        comboEmp.addItem(null);
        //por cada empleado en la base de datos
        for (Empleado emp : empDao.listarTodos()) {
            //se mete en el combobox
            comboEmp.addItem(emp);
        }

        // hace lo mismo que el anterior pero con plaza
        comboPla.addItem(null);
        for (Plaza pla : plaDao.listarTodos()) {
            comboPla.addItem(pla);
        }

        //este actionListener hace que cada vez que se cambia de plaza
        //cambia el Jtextfield de importe por el salario de la plaza
        comboPla.addActionListener(e -> {
            //coje la plaza seleccionada
            Plaza pla = (Plaza) comboPla.getSelectedItem();
            //si no esta vacia
            if (pla != null) {
                //coje el salario de la plaza y mete el mismo valor
                fieldImporte.setText(String.valueOf(pla.getSalari()));
            } else {
                //si es nullo no se mete nada
                fieldImporte.setText("");
            }
        });

        // mientras no sea valido
        while (!valido) {

            // showConfirmDialog hace un JOptionPane con el array de objetos anterior
            // y guarda si cancela o no la operacion
            int formEditarNom = JOptionPane.showConfirmDialog(this, campos, "Editar Nomina",
                    JOptionPane.OK_CANCEL_OPTION);

            // si el usuario cancela sale de la funcion editar
            if (formEditarNom != JOptionPane.OK_OPTION)
                return;

            // si los valores son validos
            if (validarCampos(fieldIbanPag, fieldImporte, comboEmp, comboPla, id)) {
                Empleado emp = (Empleado) comboEmp.getSelectedItem();
                Plaza pla = (Plaza) comboPla.getSelectedItem();
                Double importePla;
                Long nssEmp;

                // se controla el null
                if (emp != null) {
                    // asi el get no peta el programa
                    nssEmp = emp.getNss();
                } else {
                    nssEmp = null;
                }

                //hace lo mismo que lo anterior pero con plaza
                if (pla != null) {
                    importePla = pla.getSalari();
                } else {
                    importePla = null;
                }

                // se le pone los datos de los textfield
                // .trim() elimina los espacio que haya entre los textos
                nom.setIbanPag(fieldIbanPag.getText().trim());
                nom.setImporte(importePla);
                nom.setNssEmleado(nssEmp);
                nom.setCodiPlaza(pla.getCodi());

                // llama a la funcion editar de nomDao
                // que es la funcion que ejcutara el comando sql
                nomDao.editar(nom);
                cargarDatos();
                valido = true; // sale del while
            }
        }
    }

    // metodo para buscar por nss o Iban entre las nominas
    @Override
    protected void buscar(String elementoABuscar) {
        // setrowcount vacia las filas de la tabla
        modelotabla.setRowCount(0);

        // Por cada Nomina dentro de la base de datos
        for (Nomina nom : nomDao.listarTodos()) {
            // coje nss y el iban
            String nss = String.valueOf(nom.getNssEmpleado());
            String iban = nom.getIbanPag();

            // y compara el nss completo o el iban con lo que se ha escrito en la busqueda
            // y mira si contiene esas letras y numeros
            if (nss.contains(elementoABuscar) || iban.contains(elementoABuscar)) {
                // por cada coindicencia, se añade una fila con la nomina
                modelotabla.addRow(new Object[] {
                        nom.getId(), nom.getIbanPag(), nom.getImporte(),
                        nom.getNssEmpleado(), nom.getCodiPlaza()
                });
            }
        }

    }

    // metodo privado que valida las condicionees que tiene que tener cada campo
    // dentro de su valor
    private boolean validarCampos(JTextField fieldIbanPag, JTextField fieldImporte,
            JComboBox<Empleado> comboEmp, JComboBox<Plaza> comboPla, Integer id) {
        
        Empleado emp = (Empleado) comboEmp.getSelectedItem();
        Plaza pla = (Plaza) comboPla.getSelectedItem();

        // validar vacios

        // si los campos estan vacios se pedira que se rellene
        if (fieldIbanPag.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "El Pagamiento del Iban es obligatorio");
            return false;
        }
        if (fieldImporte.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "El Importe es obligatorio");
            return false;
        }
        if (emp==null) {
            JOptionPane.showMessageDialog(this, "El Nss del empleado es obligatorio");
            return false;
        }
        if (pla == null) {
            JOptionPane.showMessageDialog(this, "El Codigo de la plaza es obligatorio");
            return false;
        }

        // validar IBAN

        // coje el texto del textfiel del IBAN
        // y con regex se valida el formato de que tenga ES al principio y los 22
        // digitos
        if (!fieldIbanPag.getText().trim().toUpperCase().matches("ES\\d{22}")) {
            JOptionPane.showMessageDialog(this, "El IBAN debe nomezar con ES seguido de 22 numeros");
            return false;
        }

        // validar duplicados

        // por cada Nomina dentro de la base de datos
        for (Nomina nom : nomDao.listarTodos()) {

            // si tiene una id ya asignada es que esta editando
            if (id != null && nom.getId() == id)
                continue; // hace que no se comprueba el nom con si mismo

            // si una nomina tiene el mismo nss que otro
            if (nom.getNssEmpleado().equals(emp.getNss())) {
                // devuelve un mensaje de error
                JOptionPane.showMessageDialog(this, "ya existe un nomina con ese NSS");
                return false; // y de vuelve falso
            }
        }
        return true;
    }

}