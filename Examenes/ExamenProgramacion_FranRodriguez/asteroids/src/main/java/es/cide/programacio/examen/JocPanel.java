package es.cide.programacio.examen;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class JocPanel extends JPanel {
    private NauEspacial nau; // Nau espacial del jugador
    private List<Asteroide> asteroides; // Llista d'asteroides
    private List<Estrelles> estrelles; // Llista d'estrelles
    private int puntuacio; // Puntuació del jugador
    private boolean jocActiu; // Indica si el joc està actiu

    public JocPanel() {
        nau = new NauEspacial(350, 550); // Posició inicial de la nau
        asteroides = new ArrayList<>(); // Inicialitza la llista d'asteroides
        estrelles = new ArrayList<>();//Inicialitza la llista d'estrelles
        puntuacio = 0; // Inicialitza la puntuació
        jocActiu = true; // El joc comença actiu

        // Configura el panell
        setBackground(Color.BLACK); // Fons negre
        setFocusable(true); // Permet que el panell rebi el focus
        requestFocusInWindow(); // Demana el focus per rebre les tecles

        // Afegeix un KeyListener per controlar la nau
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    nau.moureEsquerra(); // Mou la nau a l'esquerra
                }
                else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    nau.moureDreta(); // Mou la nau a la dreta
                }
                else if (e.getKeyCode() == KeyEvent.VK_UP) {
                    nau.moureAlt(); // Mou la nau a la adalt
                }
                else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    nau.moureBaix(); // Mou la nau a la abaix
                }
            }
        });

        // Crea un Timer per actualitzar el joc
        Timer temporitzador = new Timer(20, e -> {
            if (jocActiu) {
                actualitzarJoc(); // Actualitza l'estat del joc
                repaint(); // Redibuixa el panell
            }
        });
        temporitzador.start(); // Inicia el temporitzador
    }

    private void actualitzarJoc() {
        // Genera asteroides aleatoris
        if (Math.random() < 0.02) {
            asteroides.add(new Asteroide(getWidth(),new Random().nextInt(3))); // Afegeix un nou asteroide
        }
        if (Math.random() < 0.95) {
            estrelles.add(new Estrelles(getWidth())); // Afegeix una nova estrella
        }

        // Mou els asteroides i comprova les col·lisions
        for (int i = asteroides.size() - 1; i >= 0; i--) {
            Asteroide asteroide = asteroides.get(i);
            asteroide.moure(); // Mou l'asteroide

            // Comprova si l'asteroide col·lisiona amb la nau
            if (collisio(nau, asteroide)) {
                jocActiu = false; // El joc acaba
            }

            // Comprova si l'asteroide ha sortit de la pantalla
            if (asteroide.getY() > getHeight()) {
                asteroides.remove(i); // Elimina l'asteroide
                puntuacio++; // Augmenta la puntuació
            }
        }

        for (int f = estrelles.size() - 1; f >= 0; f--) {
            Estrelles estrella = estrelles.get(f);
            estrella.moure(); // Mou l'estrella

            // Comprova si l'estrella ha sortit de la pantalla
            if (estrella.getY() > getHeight()) {
                estrelles.remove(f); // Elimina l'estrella
            }
        }
    }

    private boolean collisio(NauEspacial nau, Asteroide asteroide) {
        // Comprova si hi ha col·lisió entre la nau i l'asteroide
        int nauX = nau.getX();
        int nauY = nau.getY();
        int asteroideX = asteroide.getX();
        int asteroideY = asteroide.getY();
        int radiAsteroide = asteroide.getRadi();
        int ampleNau = nau.getAmple();
        int altNau = nau.getAlt();

        return nauX < asteroideX + radiAsteroide &&
               nauX + ampleNau > asteroideX - radiAsteroide &&
               nauY < asteroideY + radiAsteroide &&
               nauY + altNau > asteroideY - radiAsteroide;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        //dibuja las estrellas
        for (Estrelles estrella : estrelles) {
            estrella.dibuixar(g);
        }

        // Dibuixa la nau espacial
        nau.dibuixar(g);

        // Dibuixa els asteroides
        for (Asteroide asteroide : asteroides) {
            asteroide.dibuixar(g);
        }

        // Dibuixa la puntuació
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Puntuació: " + puntuacio, 10, 30);

        // Dibuixa el missatge de final de joc
        if (!jocActiu) {
            g.setColor(Color.YELLOW);
            g.setFont(new Font("Arial", Font.BOLD, 40));
            String missatge = "Fi del joc";
            int ampleMissatge = g.getFontMetrics().stringWidth(missatge);
            g.drawString(missatge, getWidth() / 2 - ampleMissatge / 2, getHeight() / 2);
        }
    }
}