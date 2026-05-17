package es.programacion.cide.view;

import javax.swing.*;
import java.awt.*;
import es.programacion.cide.view.subpanelsBDD.*;

public class PanelBDD extends JPanel {
    // atributo
    private JTabbedPane pestanas;

    // constructor
    public PanelBDD() {
        setLayout(new BorderLayout());

        pestanas = new JTabbedPane();

        pestanas.addTab("Empleados", new PanelEmpleado());
        pestanas.addTab("Nominas", new PanelNomina());
        pestanas.addTab("Plazas", new PanelPlaza());
        pestanas.addTab("Tipos de plaza", new PanelTipoPla());
        pestanas.addTab("Ocupacion", new PanelOcupa());

        add(pestanas, BorderLayout.CENTER);
    }
    // getters y setters
    
    // metodos
}
