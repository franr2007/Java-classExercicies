package es.programacion.cide.view.subpanelsBDD;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public abstract class PanelAbstractoGeneral extends JPanel {
    // atributos
    protected JTable tabla;
    protected DefaultTableModel modelotabla;
    protected JTextField buscador;

    // constructor
    // se le pasa un array con en nombre de cada columna, que luego aplicaran las
    // clases hijas
    public PanelAbstractoGeneral(String[] columns, String textoBuscador) {
        setLayout(new BorderLayout(0, 8));

        // modelo de la tabla
        modelotabla = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int col) {
                return false; // esto hace que la tabla no sea editable
            }
        };

        // tabla
        tabla = new JTable(modelotabla); // nueva tabla que coje el modelo que se ha creado antes
        tabla.setRowHeight(28); // altura de la tabla
        tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        add(panelBuscador(textoBuscador), BorderLayout.NORTH);
        add(new JScrollPane(tabla), BorderLayout.CENTER);
    }

    // getters y setters

    // metodos

    // metodo para crear el panel superior
    private JPanel panelBuscador(String textoBuscador) {
        JPanel panel = new JPanel(new BorderLayout(5, 0));

        buscador = new JTextField(textoBuscador);
        buscador.addActionListener(e -> buscar(buscador.getText().trim().toLowerCase()));

        JButton btnBuscar = new JButton("Buscar");
        JButton btnAnadir = new JButton("Añadir");
        JButton btnEditar = new JButton("Editar");
        JButton btnEliminar = new JButton("Eliminar");

        btnBuscar.addActionListener(e -> buscar(buscador.getText().trim().toLowerCase()));
        btnAnadir.addActionListener(e -> anadir());
        btnAnadir.setForeground(new Color(46, 125, 50));//color verde para añadir
        btnEditar.addActionListener(e -> editar(getIdSeleccionado()));
        btnEditar.setForeground(new Color(30, 136, 229));//color azul para editar
        btnEliminar.addActionListener(e -> eliminar(getIdSeleccionado()));
        btnEliminar.setForeground(new Color(198, 40, 40)); //color rojo para eliminar

        JPanel btnsIzquierda = new JPanel(new FlowLayout(FlowLayout.LEFT, 4, 0));
        btnsIzquierda.add(btnAnadir);
        btnsIzquierda.add(btnEditar);
        btnsIzquierda.add(btnEliminar);

        panel.add(buscador, BorderLayout.CENTER);
        panel.add(btnBuscar, BorderLayout.EAST);
        panel.add(btnsIzquierda, BorderLayout.WEST);

        return panel;
    }

    // metodo para obtener el id de la tabla
    protected Integer getIdSeleccionado() {
        // getselectedrow devuelve -1 si no hay filas seleccionadas o el numero de la
        // fila
        int fila = tabla.getSelectedRow();
        // si no hay filas seleccionadas
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Selecciona una fila");
            return null;
        }
        return (Integer) modelotabla.getValueAt(fila, 0);// devuelve el id de la fila
    }

    // metodos que los subpaneles implementaran de distinta manera
    protected abstract void cargarDatos();

    protected abstract void buscar(String elementoABuscar);

    protected abstract void anadir();

    protected abstract void editar(Integer id);

    protected abstract void eliminar(Integer id);
}