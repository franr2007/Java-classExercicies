package es.programacion.cide.view.subpanelsBDD;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import es.programacion.cide.DAO.PlazaDao;
import es.programacion.cide.DAO.TipusPlazaDao;
import es.programacion.cide.model.Plaza;
import es.programacion.cide.model.TipusPlaza;

public class PanelPlaza extends PanelAbstractoGeneral {

    // atributos
    private PlazaDao plaDao;
    private TipusPlazaDao tipusPlaDao;

    // constructor
    public PanelPlaza() {
        // parametros de la tabla
        super(new String[] { "Codi", "Nombre Plaza", "Salario", "Codi Plaza Superior", "Informe Plaza Superior",
                "Nombre del tipo de plaza" });

        plaDao = new PlazaDao();
        tipusPlaDao = new TipusPlazaDao();

        // se cargan los datos para poder ver las plazas que hay
        cargarDatos();
    }
    // getters y setters

    // metodos

    // metodo para listar las plazas dentro de la base de datos
    @Override
    protected void cargarDatos() {
        // setrowcount(0) vacia todas las filas de la tabla
        modelotabla.setRowCount(0);

        // Por cada Plaza dentro de la base de datos se creara una fila con su info
        for (Plaza pla : plaDao.listarTodos()) {
            modelotabla.addRow(new Object[] {
                    pla.getCodi(), pla.getNom(), pla.getSalari()+"€",
                    pla.getCodiPlaSuper(), pla.getInformeSuper(), pla.getipoPlaza()
            });
        }
    }

    // metodo para añadir una Plaza
    @Override
    protected void anadir() {
        Boolean valido = false;
        JTextField fieldCodi = new JTextField();
        JTextField fieldNom = new JTextField();
        JTextField fieldSalari = new JTextField();
        // se usa comboBox porque son datos que deben estar desde antes
        JComboBox<Plaza> comboPlaSuper = new JComboBox<>();
        JTextField fieldInforme = new JTextField();
        JComboBox<TipusPlaza> comboTipoPla = new JComboBox<>();

        //mete dentro plazas que ya hay
        comboPlaSuper.addItem(null);
        for (Plaza p : plaDao.listarTodos()) {
            comboPlaSuper.addItem(p);
        }

        //mete dentro los tipos de plaza que ya hay
        for (TipusPlaza t : tipusPlaDao.listarTodos()) {
            comboTipoPla.addItem(t);
        }

        // esto es un array de objetos que tiene dentro los diferentes
        // campos que se van a rellenar
        Object[] campos = {
                "Codi:", fieldCodi, "Nombre Plaza:", fieldNom, "Salario:", fieldSalari,
                "Codi plaza Superior:", comboPlaSuper, "Informe:", fieldInforme, "Tipo de plaza", comboTipoPla
        };

        // mientras no sea valido el bucle seguira
        while (!valido) {

            // showConfirmDialog hace un JOptionPane con el array de objetos anterior
            // y guarda si cancela o no la operacion
            int formNuevapla = JOptionPane.showConfirmDialog(this, campos, "Nuevo plaleado",
                    JOptionPane.OK_CANCEL_OPTION);

            // si el usuario cancela sale de la funcion añadir
            if (formNuevapla != JOptionPane.OK_OPTION)
                return;

            // si los valores son validos
            if (validarCampos(fieldCodi, fieldNom, fieldSalari, comboPlaSuper, comboTipoPla, null)) {
                Plaza pla = new Plaza(); // se crea un nueva Plaza
                Plaza plaSuper = (Plaza) comboPlaSuper.getSelectedItem();
                TipusPlaza tipoPla = (TipusPlaza) comboTipoPla.getSelectedItem();
                Integer codiSuper;

                // se controla el null
                if (plaSuper != null) {
                    // asi el get no peta el programa
                    codiSuper = plaSuper.getCodi();
                } else {
                    codiSuper = null;
                }

                // se le pone los datos de los textfield
                // .trim() elimina los espacio que haya entre los textos
                pla.setCodi(Integer.parseInt(fieldCodi.getText().trim()));
                pla.setNom(fieldNom.getText().trim());
                pla.setSalari(Double.parseDouble(fieldSalari.getText().trim()));
                pla.setCodiPlaSuper(codiSuper);
                pla.setInformeSuper(fieldInforme.getText());
                pla.setipoPlaza(tipoPla.getNom());

                // se llama a la funcion insertar de plaDao
                // para insertar la info en la base de datos
                plaDao.insertar(pla);

                // se vuelve a cargar los datos para actualizar la tabla
                cargarDatos();
                valido = true; // sale del while
            }
        }
    }

    // metodo para eliminar las plazas
    @Override
    protected void eliminar(Integer codi) {
        if (codi == null)
            return; // si no hay codigo no hace nada
        // JOptionPane que pregunta si quieres eliminar la Plaza
        // dandote a elejir entre si o no
        int eleccion = JOptionPane.showConfirmDialog(this,
                "Quieres eliminar esta plaza",
                "eliminar Plaza...",
                JOptionPane.YES_NO_OPTION);

        // si la eleccion es si
        if (eleccion == JOptionPane.YES_OPTION) {
            // se llama a la funcion eliminar de plaDao
            // que hara el comando para eliminarlo de la base de datos
            plaDao.eliminarPorId(codi);

            // y se actualizara la tabla
            cargarDatos();
        }

    }

    // metodo para editar los datos de una Plaza
    @Override
    protected void editar(Integer codi) {
        if (codi == null)
            return; // si no hay codigo no hace nada
        Plaza pla = plaDao.recojerPorId(codi);
        if (pla == null)
            return; // si no hay una Plaza con ese codigo no hace nada

        Boolean valido = false;
        JTextField fieldNom = new JTextField(pla.getNom());
        JTextField fieldSalari = new JTextField(String.valueOf(pla.getSalari()));
        JComboBox<Plaza> comboPlaSuper = new JComboBox<>();
        JTextField fieldInforme = new JTextField(pla.getInformeSuper());
        JComboBox<TipusPlaza> comboTipoPla = new JComboBox<>();

        //mete dentro plazas que ya hay
        comboPlaSuper.addItem(null);
        for (Plaza p : plaDao.listarTodos()) {
            comboPlaSuper.addItem(p);
        }

        //mete dentro los tipos de plaza que ya hay
        for (TipusPlaza t : tipusPlaDao.listarTodos()) {
            comboTipoPla.addItem(t);
        }

        // esto es un array de objetos que tiene dentro los diferentes
        // campos que se van a rellenar
        Object[] campos = {
                "Nombre Plaza:", fieldNom, "Salario:", fieldSalari,
                "Codi plaza Superior:", comboPlaSuper, "Informe:", fieldInforme, "Tipo de plaza", comboTipoPla
        };

        // mientras no sea valido
        while (!valido) {

            // showConfirmDialog hace un JOptionPane con el array de objetos anterior
            // y guarda si cancela o no la operacion
            int formEditarPla = JOptionPane.showConfirmDialog(this, campos, "Nuevo plaleado",
                    JOptionPane.OK_CANCEL_OPTION);

            // si el usuario cancela sale de la funcion editar
            if (formEditarPla != JOptionPane.OK_OPTION)
                return;

            // si los valores son validos
            if (validarCampos(null, fieldNom, fieldSalari, comboPlaSuper, comboTipoPla, codi)) {

                Plaza plaSuper = (Plaza) comboPlaSuper.getSelectedItem();
                TipusPlaza tipoPla = (TipusPlaza) comboTipoPla.getSelectedItem();
                Integer codiSuper;

                // se controla el null
                if (plaSuper != null) {
                    // asi el get no peta el programa
                    codiSuper = plaSuper.getCodi();
                } else {
                    codiSuper = null;
                }

                // se le pone los datos de los textfield
                // .trim() elimina los espacio que haya entre los textos
                pla.setNom(fieldNom.getText().trim());
                pla.setSalari(Double.parseDouble(fieldSalari.getText().trim()));
                pla.setCodiPlaSuper(codiSuper);
                pla.setInformeSuper(fieldInforme.getText());
                pla.setipoPlaza(tipoPla.getNom());

                // llama a la funcion editar de plaDao
                // que es la funcion que ejcutara el comando sql
                plaDao.editar(pla);
                cargarDatos();
                valido = true; // sale del while
            }
        }
    }

    // metodo para buscar por nombre de plaza entre las plazas
    @Override
    protected void buscar(String elementoABuscar) {
        // setrowcount vacia las filas de la tabla
        modelotabla.setRowCount(0);

        // Por cada Plaza dentro de la base de datos
        for (Plaza pla : plaDao.listarTodos()) {
            // cojera el nombre de la plaza
            String nombrePla = pla.getNom();

            // y compara el nombre de la plaza completo 
            // con lo que se ha escrito en la busqueda
            if (nombrePla.contains(elementoABuscar)) {
                // por cada coindicencia, se añade una fila con la Plaza
                modelotabla.addRow(new Object[] {
                        pla.getCodi(), pla.getNom(), pla.getSalari()+"€",
                        pla.getCodiPlaSuper(), pla.getInformeSuper(), pla.getipoPlaza()
                });
            }
        }

    }

    // metodo privado que valida las condicionees que tiene que tener cada campo
    // dentro de su valor
    private boolean validarCampos(JTextField fieldCodi, JTextField fieldNom,
            JTextField fieldSalari, JComboBox<Plaza> comboPlaSuper, JComboBox<TipusPlaza> comboTipoPla, Integer codi) {
        
        //se recoje el item seleccinado de cada combobox
        Plaza codiSuper = (Plaza) comboPlaSuper.getSelectedItem();
        TipusPlaza tipoPlaza = (TipusPlaza) comboTipoPla.getSelectedItem();

        // validar vacios

        // si los campos estan vacios se pedira que se rellene
        if (codi == null && fieldCodi.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "El codigo es obligatorio");
            return false;
        }
        if (fieldNom.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "El Nombre de la plaza es obligatorio");
            return false;
        }
        if (fieldSalari.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "El Salario de la plaza es obligatorio");
            return false;
        }
        if (tipoPlaza == null) {
            JOptionPane.showMessageDialog(this, "El tipo de plaza es obligatorio");
            return false;
        }

        // validar numeros
        if (fieldCodi != null) {
            try {
                Integer.parseInt(fieldCodi.getText().trim());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "El codigo debe ser un numero");
                return false;
            }
        }

        try {
            Integer.parseInt(fieldSalari.getText().trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                    "El salario debe ser un numero");
            return false;
        }

        // validar supervisar a si mismo

        if (codiSuper != null && codiSuper.getCodi() == codi) {
            JOptionPane.showMessageDialog(this, "Una plaza no se puede supervisar a si misma");
            return false;
        }

        // validar duplicados

        // por cada Plaza dentro de la base de datos
        for (Plaza pla : plaDao.listarTodos()) {

            // si tiene un codi ya asignada es que esta editando
            if (codi != null && pla.getCodi() == codi)
                continue; // hace que no se compruebe pla con si mismo

            // si una Plaza tiene el mismo nss que el de el textfield
            if (pla.getCodi() == Integer.parseInt(fieldCodi.getText().trim())) {
                // devuelve un mensaje de error
                JOptionPane.showMessageDialog(this, "Ya existe una Plaza con ese codigo");
                return false; // y de vuelve falso
            }
        }
        return true;
    }

}