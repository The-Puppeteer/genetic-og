package Genetic_Algorithms;

import java.awt.Color;
import java.awt.Graphics;

public class Obstacles {
    int x;
    int y;
    int w;
    int h;
    public Obstacles(){
        
    }
    
    public void paintGoal(int x, int y, int w, int h, Graphics g){
        g.fillRect(x, y, h, h);
        g.setColor(Color.black);
        g.drawRect(x, y, h, h);
        
        this.x = x;
        this.y=y;
        this.w = w;
        this.h = h;
    }
    
    public double distance(Individuals a){
        double x2 = a.getX();
        double y2 = a.getY();
        double dist = Math.sqrt(Math.pow(this.x - x2,2) + Math.pow(this.y - y2, 2));
        
        return dist;
    }
    public int getX() {
    return x;
    }

    public int getY() {
        return y;
    }
    
    public int getW() {
        return w;
    }
    
    public int getH() {
        return h;
    }
    
}