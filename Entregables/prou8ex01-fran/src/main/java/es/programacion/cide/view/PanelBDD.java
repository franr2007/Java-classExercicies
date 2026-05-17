package es.programacion.cide.view;

import javax.swing.*;
import java.awt.*;
import es.programacion.cide.view.subpanelsBDD.*;

public class PanelBDD extends JPanel {
    // atributo
    private JTabbedPane pestanas;

    // constructor
    public PanelBDD() {
        //layout del panel
        setLayout(new BorderLayout());

        pestanas = new JTabbedPane();

        //se le añade los subpaneles a las pestañas del Jtabbedpane
        pestanas.addTab("Empleados", new PanelEmpleado());
        pestanas.addTab("Nominas", new PanelNomina());
        pestanas.addTab("Plazas", new PanelPlaza());
        pestanas.addTab("Tipos de plaza", new PanelTipoPla());
        pestanas.addTab("Ocupacion", new PanelOcupa());

        //se añade Jtabbedpane al panel y en el centro para que ocupe todo
        add(pestanas, BorderLayout.CENTER);
    }
    // getters y setters
    
    // metodos
}
