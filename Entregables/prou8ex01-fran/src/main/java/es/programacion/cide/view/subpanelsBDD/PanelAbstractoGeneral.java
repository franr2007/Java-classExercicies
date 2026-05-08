package es.programacion.cide.view.subpanelsBDD;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

/**
 * PANEL CRUD GENÉRICO
 * Sustituye Empleados, Plazas, Tipos, Ocupa y Nóminas
 */
public abstract class PanelAbstractoGeneral<T> extends JPanel {

    protected JTable tabla;
    protected DefaultTableModel modelotabla;
    protected JTextField buscador;

    public PanelAbstractoGeneral(String[] columns) {
        setLayout(new BorderLayout());

        modelotabla = new DefaultTableModel(columns, 0);

        tabla = new JTable(modelotabla);
        buscador = new JTextField();

        add(panelBuscador(), BorderLayout.NORTH);
        add(new JScrollPane(tabla), BorderLayout.CENTER);
        add(panelBotones(), BorderLayout.SOUTH);

        cargarDatos();
    }

    private JPanel panelBuscador() {
        JPanel panel = new JPanel(new BorderLayout(6, 0));
        panel.add(new JLabel("Cercar:"), BorderLayout.WEST);
        panel.add(buscador, BorderLayout.CENTER);

        buscador.addActionListener(e -> buscar(buscador.getText().trim().toLowerCase()));

        return panel;
    }

    private JPanel panelBotones() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 6, 0));

        JButton anadir = new JButton("Añadir");
        JButton editar = new JButton("Editar");
        JButton eliminar = new JButton("Eliminar");
        JButton actualizar = new JButton("Actualizar");

        anadir.addActionListener(e -> anadir());
        editar.addActionListener(e -> editar(getSelectedId()));
        eliminar.addActionListener(e -> eliminar(getSelectedId()));
        actualizar.addActionListener(e -> cargarDatos());

        panel.add(anadir);
        panel.add(editar);
        panel.add(eliminar);
        panel.add(actualizar);

        return panel;
    }

    protected Integer getSelectedId() {
        int row = tabla.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Selecciona un registre");
            return null;
        }
        return (Integer) modelotabla.getValueAt(row, 0);
    }


    protected abstract void cargarDatos();

    protected abstract void buscar(String query);

    protected abstract void anadir();

    protected abstract void editar(Integer id);

    protected abstract void eliminar(Integer id);

    protected abstract List<T> listarTodos();
}
