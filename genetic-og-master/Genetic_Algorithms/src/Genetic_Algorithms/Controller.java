package Genetic_Algorithms;

import java.awt.Graphics;
import java.awt.Graphics2D;
import static java.lang.Thread.sleep;


class Controller extends Thread {
    boolean running = false;
    Individuals a = new Individuals(300, 200, 3, 30, 30);
    Individuals b = new Individuals(300, 200, 3, 30, 30);
    Graphics g;
    private final Genetic_Panel thePanel;
    
    Controller(Genetic_Panel thePanel) {
        this.thePanel = thePanel;
        
    }

    public void run() {
        int i =0;
   
        for(;;) {
            if (running) {
                a.step(i);
                b.step(i);
                thePanel.repaint();
                ++i;
//                System.out.println(theIndividual.getChromosome().get(i));
//                System.out.println(i);
            }
            delay();
        }
    }
    
    void toggleRunning() {
        running = !running;
    }

    void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        a.paint(g2);
        b.paint(g2);
    }

    private void delay() {
        try {
            sleep(3);
        } catch (Exception e){}
    }
}
