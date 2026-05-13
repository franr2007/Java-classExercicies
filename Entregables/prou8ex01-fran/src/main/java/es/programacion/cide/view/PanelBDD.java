package es.programacion.cide.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;

import es.programacion.cide.DAO.EmpleadoDao;
import es.programacion.cide.DAO.NominaDao;
import es.programacion.cide.DAO.OcupaDao;
import es.programacion.cide.DAO.PlazaDao;
import es.programacion.cide.DAO.TipusPlazaDao;
import es.programacion.cide.model.Empleado;

public class PanelBDD extends JPanel {
    // atributo
    private EmpleadoDao empleadoDao;
    private NominaDao nominaDao;
    private PlazaDao plazaDao;
    private OcupaDao ocupaDao;
    private TipusPlazaDao tipusPlazaDao;
    private JTabbedPane pestanas;

    // constructor
    public PanelBDD() {
        setLayout(new BorderLayout());

        empleadoDao = new EmpleadoDao();
        nominaDao = new NominaDao();
        plazaDao = new PlazaDao();
        tipusPlazaDao= new TipusPlazaDao();
        ocupaDao = new OcupaDao();
        pestanas = new JTabbedPane();

        pestanas.addTab("Empleado", crearPanelEmpleado());
    }
    // getters y setters
    
    // metodos
    private void carregarEmpleats(DefaultTableModel model) {
        model.setRowCount(0);
        for (Empleado empleado : empleadoDao.listarTodos()) {
            model.addRow(new Object[]{empleado.getId(), empleado.getNss(), empleado.getNom(), empleado.getApellidos(), empleado.getEmail(), empleado.getIban()});
        }
    }

    private JPanel crearPanelEmpleado(){
        String[] columnas= {"ID", "NSS", "Nom", "Cognoms", "Email", "IBAN"};
        DefaultTableModel modeloTabla = new DefaultTableModel();
        for (int i=0; i< columnas.length;i++){
            modeloTabla.addColumn(columnas[i]);
        }

        JTable tabla= new JTable(modeloTabla);

        carregarEmpleats(modeloTabla);

        JTextField buscador= new JTextField();
        buscador.setToolTipText("Busca por nombre, apellidos o IBAN ...");
        buscador.addActionListener(e ->{
            String palabra= buscador.getText().trim().toLowerCase();
            modeloTabla.setRowCount(0);

            for(Empleado empleado: empleadoDao.listarTodos()){
                if (empleado.getNom().toLowerCase().contains(palabra) || empleado.getApellidos().toLowerCase().contains(palabra) || empleado.getIban().toLowerCase().contains(palabra)) {
                    modeloTabla.addRow(new Object[]{
                        empleado.getId(),empleado.getNss(),empleado.getNom(),empleado.getApellidos(), empleado.getEmail(),empleado.getIban()
                    });
                }
            }
        });;

    }
}
