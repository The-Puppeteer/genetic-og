package Genetic_Algorithms;

import java.awt.Graphics;
import java.awt.Graphics2D;
import static java.lang.Thread.sleep;


class Controller extends Thread {
    boolean running = false;
    Individuals theIndividual;
    
    private final Genetic_Panel thePanel;
    
    Controller(Genetic_Panel thePanel, Individuals p) {
        this.thePanel = thePanel;
        theIndividual = p;
    }

    public void run() {
        for(;;) {
            if (running) {
                theIndividual.step();
                thePanel.repaint();
            }
            delay();
        }
    }
    
    void toggleRunning() {
        running = !running;
    }

    void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        theIndividual.paint(g2);
    }

    private void delay() {
        try {
            sleep(33);
        } catch (Exception e){}
    }
}
