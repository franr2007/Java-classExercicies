package es.programacion.cide;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class Fondo {
    // Atributos
    private VentanaPrincipal vp;
    private PanelInicio pI;
    private int contadorj1;
    private int contadorj2;

    // constructor
    Fondo(VentanaPrincipal ventanaPrincipal, PanelInicio panelInicio) {
        this.vp = ventanaPrincipal;
        this.pI=panelInicio;
    }

    // getters y setters
    public int getContadorj1() {
        return contadorj1;
    }

    public void setContadorj1(int contadorj1) {
        this.contadorj1 = contadorj1;
    }

    public int getContadorj2() {
        return contadorj2;
    }

    public void setContadorj2(int contadorj2) {
        this.contadorj2 = contadorj2;
    }
    // metodos

    protected void pintarFondo(Graphics2D g) {
            g.setColor(Color.black);
            g.fillRect(0, 0, vp.getAnchoVentana(), vp.getAltoVentana());
    }

    protected void pintarLC(Graphics2D g) {
        g.setColor(new Color(255, 80, 0, 100));

        int posLinea = vp.getAnchoVentana() / 2; // centro horizontal
        int linea = 18; // la altura de la linea
        int vacio = 12; // espacio entre lineas

        for (int y = 0; y < vp.getAltoVentana(); y += linea + vacio) {// bucle que empieza desde arriba y acaba cuando
                                                                      // llega al final de la pantalla, luego se le suma
                                                                      // los px tanto del hueco como de la linea
            g.fillRect(posLinea - 2, y, 4, linea);// dibuja 1 linea con 4 px de ancho y la altura de la linea
        }
    }

    protected void pintarContadorIzq(Graphics2D g) {
        g.setColor(new Color(255, 32, 32));
        g.setFont(new Font("Arial", Font.BOLD, 100));
        g.drawString(String.valueOf(contadorj1), vp.getAnchoVentana() / 2-80, 100);
    }

    protected void pintarContadorDer(Graphics2D g) {
        g.setColor(new Color(255, 107, 0));
        g.setFont(new Font("Arial", Font.BOLD, 100));
        g.drawString(String.valueOf(contadorj2), vp.getAnchoVentana()/2+25, 100);
    }

    protected void pintarNombrej1(Graphics2D g) {
        g.setColor(new Color(255, 32, 32));
        g.setFont(new Font("Arial", Font.BOLD, 100));
        g.drawString(pI.getNombreJugador1(), 40, 100);
    }

    protected void pintarNombrej2(Graphics2D g) {
        g.setColor(new Color(255, 107, 0));
        g.setFont(new Font("Arial", Font.BOLD, 100));
        g.drawString(pI.getNombreJugador2(), vp.getAnchoVentana()+40- (vp.getAnchoVentana() / 3), 100);
    }

    protected void pintarCRT(Graphics2D g) {
        g.setColor(new Color(0, 0, 0, 40));
        for (int y = 0; y < vp.getAltoVentana(); y += 4) { //bucle para aplicar lineas tipo 'retro'
            g.fillRect(0, y, vp.getAnchoVentana(), 2);//pinta las lineas
        }

        // Tinte rojizo sutil
        g.setColor(new Color(255, 20, 0, 8));
        g.fillRect(0, 0, vp.getAnchoVentana(), vp.getAltoVentana());
    }
}