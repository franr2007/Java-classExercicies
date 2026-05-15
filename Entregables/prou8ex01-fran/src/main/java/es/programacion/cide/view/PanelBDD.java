package es.programacion.cide.view;

import javax.swing.*;
import java.awt.*;
import es.programacion.cide.DAO.*;
import es.programacion.cide.view.subpanelsBDD.PanelEmpleado;

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

        pestanas.addTab("Empleado", new PanelEmpleado());

        add(pestanas, BorderLayout.CENTER);
    }
    // getters y setters
    
    // metodos
}
