package es.programacion.cide.view;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import es.programacion.cide.DAO.EmpleadoDao;
import es.programacion.cide.DAO.NominaDao;
import es.programacion.cide.DAO.PlazaDao;

public class PanelBDD extends JPanel {
    // atributo
    private EmpleadoDao empleadoDao;
    private NominaDao nominaDao;
    private PlazaDao plazaDao;
    private JTabbedPane pestañas;

    // constructor
    public PanelBDD() {
        empleadoDao = new EmpleadoDao();
        nominaDao = new NominaDao();
        plazaDao = new PlazaDao();
        pestañas = new JTabbedPane();
    }
    // getters y setters

    // metodos

}
