package Genetic_Algorithms;

import java.awt.Graphics;

public class Obstacles {
    int x;
    int y;
    public Obstacles(){
        
    }
    
    public void paintGoal(int x, int y, int w, int h, Graphics g){
        g.draw3DRect(x, y, h, h, true);
        g.fill3DRect(x, y, h, h, true);
        this.x = x;
        this.y=y;
    }
    
    public double distance(Individuals a){
        double x2 = a.getX();
        double y2 = a.getY();
        double dist = Math.sqrt(Math.pow(this.x - x2,2) + Math.pow(this.y - y2, 2));
        
        return dist;
    }
    
}