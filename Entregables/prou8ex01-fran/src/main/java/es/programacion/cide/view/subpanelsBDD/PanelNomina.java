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
        super(new String[] { "ID", "IBAN_pagament", "Importe", "NSS Empleado", "CodigoPlaza" });

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

    // metodo para añadir un nomleado
    @Override
    protected void anadir() {
        Boolean valido = false;
        JTextField fieldIbanPag = new JTextField();
        JTextField fieldImporte = new JTextField();
        fieldImporte.setEditable(false);
        JTextField fieldNssEmp = new JTextField();
        JComboBox<Plaza> comboCodiPlaza = new JComboBox<>();

        // esto es un array de objetos que tiene dentro los diferentes
        // campos que se van a rellenar
        Object[] campos = {
                "IBAN pagament:", fieldIbanPag, "Importe:", fieldImporte, "Nss Empleado:", fieldNssEmp,
                "Codigo Plaza:", comboCodiPlaza
        };

        // mete dentro las plaza que ya existen
        comboCodiPlaza.addItem(null);
        //por cada plaza en la base de datos
        for (Plaza pla : plaDao.listarTodos()) {
            //se mete en el combobox
            comboCodiPlaza.addItem(pla);
        }

        //este actionListener hace que cada vez que se cambia de plaza
        //cambia el Jtextfield de importe por el salario de la plaza
        comboCodiPlaza.addActionListener(e -> {
            //coje la plaza seleccionada
            Plaza pla = (Plaza) comboCodiPlaza.getSelectedItem();
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
            if (validarCampos(fieldIbanPag, fieldImporte, fieldNssEmp, comboCodiPlaza, null)) {
                Nomina nom = new Nomina(); // se crea un nueva Nomina
                Plaza pla = (Plaza) comboCodiPlaza.getSelectedItem();
                Double importePla;

                // se controla el null
                if (pla != null) {
                    // asi el get no peta el programa
                    importePla = pla.getSalari();
                } else {
                    importePla = null;
                }

                // se le pone los datos de los textfield
                // .trim() elimina los espacio que haya entre los textos
                nom.setIbanPag(fieldIbanPag.getText().toUpperCase().trim());
                nom.setImporte(importePla);
                nom.setNssEmleado(Long.parseLong(fieldNssEmp.getText().trim()));
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
        JTextField fieldNssEmp = new JTextField(String.valueOf(nom.getNssEmpleado()));
        JComboBox<Plaza> comboCodiPlaza = new JComboBox<>();

        // esto es un array de objetos que tiene dentro los diferentes
        // campos que se van a rellenar
        Object[] campos = {
                "IBAN pagament:", fieldIbanPag, "Importe:", fieldImporte, "Nss Empleado:", fieldNssEmp,
                "Codigo Plaza:", comboCodiPlaza
        };

        // mete dentro las plaza que ya existen
        comboCodiPlaza.addItem(null);
        //por cada plaza en la base de datos
        for (Plaza pla : plaDao.listarTodos()) {
            //se mete en el combobox
            comboCodiPlaza.addItem(pla);
        }

        //este actionListener hace que cada vez que se cambia de plaza
        //cambia el Jtextfield de importe por el salario de la plaza
        comboCodiPlaza.addActionListener(e -> {
            //coje la plaza seleccionada
            Plaza pla = (Plaza) comboCodiPlaza.getSelectedItem();
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
            if (validarCampos(fieldIbanPag, fieldImporte, fieldNssEmp, comboCodiPlaza, id)) {
                Plaza pla = (Plaza) comboCodiPlaza.getSelectedItem();
                Double importePla;

                // se controla el null
                if (pla != null) {
                    // asi el get no peta el programa
                    importePla = pla.getSalari();
                } else {
                    importePla = null;
                }

                // se le pone los datos de los textfield
                // .trim() elimina los espacio que haya entre los textos
                nom.setIbanPag(fieldIbanPag.getText().trim());
                nom.setImporte(importePla);
                nom.setNssEmleado(Long.parseLong(fieldNssEmp.getText().trim()));
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
            JTextField fieldNssEmp, JComboBox<Plaza> comboCodiPla, Integer id) {

        Plaza codiPla = (Plaza) comboCodiPla.getSelectedItem();
        Boolean existe = false;

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
        if (fieldNssEmp.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "El Nss del empleado es obligatorio");
            return false;
        }
        if (codiPla == null) {
            JOptionPane.showMessageDialog(this, "El Codigo de la plaza es obligatorio");
            return false;
        }

        // validar nss

        // coje el texto del textfiel del nss
        // y con regex se valida el formato de que tenga 12 numeros
        if (!fieldNssEmp.getText().trim().matches("\\d{12}")) {
            JOptionPane.showMessageDialog(this, "El NSS debe tener 12 digitos");
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

        // validar si existe nss
        // por cada empleado en la base de datos
        for (Empleado emp : empDao.listarTodos()) {
            // se comprueba de que el que se ha puesto coincida con uno
            if (emp.getNss() == Long.parseLong(fieldNssEmp.getText())) {
                // si coincide es que existe
                existe = true;
            }
        }

        // si no existe
        if (!existe) {
            // devuelve un mensaje de error
            JOptionPane.showMessageDialog(this, "No hay ningun empleado con ese nss");
            return false;
        }

        // validar duplicados

        // por cada Nomina dentro de la base de datos
        for (Nomina nom : nomDao.listarTodos()) {

            // si tiene una id ya asignada es que esta editando
            if (id != null && nom.getId() == id)
                continue; // hace que no se comprueba el nom con si mismo

            // si una nomina tiene el mismo nss que el de el textfield
            if (nom.getNssEmpleado() == Long.parseLong(fieldNssEmp.getText().trim())) {
                // devuelve un mensaje de error
                JOptionPane.showMessageDialog(this, "ya existe un nomina con ese NSS");
                return false; // y de vuelve falso
            }

            // si el iban de un nom es igual indiferentemente de las mayus y minusculas
            // y es exactamente igual que el del textfield
            if (nom.getIbanPag().equalsIgnoreCase(fieldIbanPag.getText().trim())) {
                // devuelve un mensaje de error
                JOptionPane.showMessageDialog(this, "Ya existe un nomina con ese IBAN");
                return false;// y de vuelve falso
            }
        }
        return true;
    }

}