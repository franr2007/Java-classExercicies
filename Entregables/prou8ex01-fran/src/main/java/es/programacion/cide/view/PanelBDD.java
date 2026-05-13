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
}
