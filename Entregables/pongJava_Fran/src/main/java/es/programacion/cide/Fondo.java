package es.programacion.cide;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;

//41663903R
//Francisco Javier Rodriguez
//16-02-26

public class Fondo {
    // Atributos
    private VentanaPrincipal vp;
    private PanelInicio pI;
    private int contadorj1;
    private int contadorj2;
    private ImageIcon imagenOriginal;
    private Image fondo;

    // constructor
    Fondo(VentanaPrincipal ventanaPrincipal, PanelInicio panelInicio) {
        this.vp = ventanaPrincipal;
        this.pI = panelInicio;
        imagenOriginal= new ImageIcon(getClass().getResource("/fondo_pong.jpg")); // var que recoje de recursos la img
        fondo= imagenOriginal.getImage(); //var que convierte de ImgIcon a img, la img anterior
    }

    // getters y setters
    public int getContadorj1() {
        return contadorj1;
    }

    public void setContadorj1(int contadorj1) {
        this.contadorj1 += contadorj1;
    }

    public int getContadorj2() {
        return contadorj2;
    }

    public void setContadorj2(int contadorj2) {
        this.contadorj2 += contadorj2;
    }
    // metodos

    //metodo para pintar el fondo
    protected void pintarFondo(Graphics2D g) {
        g.drawImage(fondo, 0, 0, vp.getAnchoVentana(), vp.getAltoVentana(), null); //pinta el fondo con la img aplicada
    }

    //metodo que pinta la linea del medio
    protected void pintarLC(Graphics2D g) {
        g.setColor(new Color(255, 80, 0, 100)); //color de la linea

        int posLinea = vp.getAnchoVentana() / 2; // centro horizontal
        int linea = 18; // la altura de la linea
        int vacio = 12; // espacio entre lineas

        for (int y = 0; y < vp.getAltoVentana(); y += linea + vacio) {// bucle que empieza desde arriba y acaba cuando
                                                                      // llega al final de la pantalla, luego se le suma
                                                                      // los px tanto del hueco como de la linea
            g.fillRect(posLinea - 2, y, 4, linea);// dibuja 1 linea con 4 px de ancho y la altura de la linea
        }
    }

    //metodo para pintar el contadorIzq
    protected void pintarContadorIzq(Graphics2D g) {
        // Este es el contadorIzq coloreado pricipal
        g.setColor(new Color(255, 32, 32));
        g.setFont(new Font("Arial", Font.BOLD, 100));
        g.drawString(String.valueOf(contadorj1), vp.getAnchoVentana() / 2 - 80, 100);// esto dibuja el contadorIzq

        // los siguientes 2 hacen lo mismo pero con distinta opacidad, altura y anchura
        // para darle intensidad a las palas
        g.setColor(new Color(255, 32, 32, 60));
        g.setFont(new Font("Arial", Font.BOLD, 100));
        g.drawString(String.valueOf(contadorj1), vp.getAnchoVentana() / 2 - 77, 101);

        g.setColor(new Color(255, 32, 32, 30));
        g.setFont(new Font("Arial", Font.BOLD, 100));
        g.drawString(String.valueOf(contadorj1), vp.getAnchoVentana() / 2 - 74, 102);
    }

    //metodo para pintar el contadorDer
    protected void pintarContadorDer(Graphics2D g) {
        // Este es el contadorDer coloreado pricipal
        g.setColor(new Color(255, 107, 0));
        g.setFont(new Font("Arial", Font.BOLD, 100));
        g.drawString(String.valueOf(contadorj2), vp.getAnchoVentana() / 2 + 25, 100);

        // los siguientes 2 hacen lo mismo pero con distinta opacidad, altura y anchura
        // para darle intensidad a las palas
        g.setColor(new Color(255, 107, 0, 60));
        g.setFont(new Font("Arial", Font.BOLD, 106));
        g.drawString(String.valueOf(contadorj2), vp.getAnchoVentana() / 2 + 22, 101);

        g.setColor(new Color(255, 107, 0, 30));
        g.setFont(new Font("Arial", Font.BOLD, 112));
        g.drawString(String.valueOf(contadorj2), vp.getAnchoVentana() / 2 + 19, 102);
    }

    protected void pintarNombrej1(Graphics2D g) {
        // Este es el nombre j1 coloreado pricipal
        g.setColor(new Color(255, 32, 32));
        g.setFont(new Font("Arial", Font.BOLD, 100));
        g.drawString(pI.getNombreJugador1(), 40, 100);

        // los siguientes 2 hacen lo mismo pero con distinta opacidad, altura y anchura
        // para darle intensidad a las palas
        g.setColor(new Color(255, 32, 32,60));
        g.setFont(new Font("Arial", Font.BOLD, 106));
        g.drawString(pI.getNombreJugador1(), 40-6, 100);

        g.setColor(new Color(255, 32, 32,30));
        g.setFont(new Font("Arial", Font.BOLD, 112));
        g.drawString(pI.getNombreJugador1(), 40-12, 100);
    }

    protected void pintarNombrej2(Graphics2D g) {
        int anchoTexto = g.getFontMetrics().stringWidth(pI.getNombreJugador2());//recoje el ancho del txt 

        // Este es el nombre j2 coloreado pricipal
        g.setColor(new Color(255, 107, 0));
        g.setFont(new Font("Arial", Font.BOLD, 100));
        g.drawString(pI.getNombreJugador2(), vp.getAnchoVentana() - 40 - anchoTexto, 100);

        // los siguientes 2 hacen lo mismo pero con distinta opacidad, altura y anchura
        // para darle intensidad a las palas
        g.setColor(new Color(255, 107, 0,60));
        g.setFont(new Font("Arial", Font.BOLD, 106));
        g.drawString(pI.getNombreJugador2(), vp.getAnchoVentana() - 40 - anchoTexto-6, 100);

        g.setColor(new Color(255, 107, 0,30));
        g.setFont(new Font("Arial", Font.BOLD, 112));
        g.drawString(pI.getNombreJugador2(), vp.getAnchoVentana() - 40 - anchoTexto-12, 100);
    }

    //metodo para meter un tipo de 'filtro'
    protected void pintarCRT(Graphics2D g) {
        g.setColor(new Color(0, 0, 0, 40));
        for (int y = 0; y < vp.getAltoVentana(); y += 4) { // bucle para aplicar lineas tipo 'retro'
            g.fillRect(0, y, vp.getAnchoVentana(), 2);// pinta las lineas
        }

        // tono rojo sutil
        g.setColor(new Color(255, 20, 0, 8));
        g.fillRect(0, 0, vp.getAnchoVentana(), vp.getAltoVentana());
    }
}