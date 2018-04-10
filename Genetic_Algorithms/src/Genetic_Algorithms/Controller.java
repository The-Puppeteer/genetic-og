package Genetic_Algorithms;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import static java.lang.Thread.sleep;

/**
 *
 * @author Connor McGuigan Apr 9, 2018 7:11:51 PM
 */
class Controller extends Thread {

    boolean running = false;
    Individuals theIndividual;
    Vehicle_World theWorld;

    private final Genetic_Panel thePanel;

    Controller(Genetic_Panel thePanel, Individuals p) {
        this.thePanel = thePanel;
        theIndividual = p;
    }

    public void run() {
        for (;;) {
            if (running) {
                //individual motion and directional randomness (chromosomes)
                //fitness level calculation and crossover
        System.out.println("running");
        for (;;) {
            int stepsToTake = 0;
            if (stepsToTake > 0) {      // if we should take a step, do so
                stepsToTake--;
                step();
            }
            delay();                  // always delay, to avoid spin-lock
         }
        }
      }
    }
        private void step() {
        theWorld.step();
        thePanel.repaint();
     }

    public double getDirection(int r) {
        double angle = 0;
        if (r == 0) {
            angle = 0;
        } else if (r == 1) {
            angle = Math.PI / 4;
            angle = Math.PI / 2;
            angle = Math.PI * 3 / 4;
            angle = Math.PI;
            angle = Math.PI * 5 / 4;
            angle = Math.PI * 3 / 2;
        }
        return angle;
    }

    public double setDirection(int h) {
        return h;
    }

    public int makeLocation() {
        int distance = 2;
        int angle = 0;
        int direction = angle;
        int dx = (int) (distance * Math.cos(direction));
        int dy = (int) (-distance * Math.sin(direction));
        int x = theIndividual.getX();
        int y = theIndividual.getY();
        theIndividual.setLocation(new Point2D.Double(x + dx, y + dy));
        
        return angle;
    }

    void toggleRunning() {
        running = !running;
    }

    void paint(Graphics g) {
        //theWorld.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        theIndividual.paint(g2);
    }

    private void delay() {
        try {
            sleep(33);
        } catch (Exception e) {
        }
    }
}
