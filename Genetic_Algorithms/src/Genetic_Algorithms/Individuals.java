package Genetic_Algorithms;

import java.awt.Graphics;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Connor McGuigan Apr 9, 2018 7:02:06 PM
 */
public class Individuals {
    
    protected int x;
    protected int y;
    protected double d;
    protected int w;
    protected int l;
    List<Integer> chromosome = new ArrayList<Integer>();
    protected Point2D.Double location;
        
    public void setLocation(Point2D.Double nuLocation) {location = nuLocation;}


    
    
    public Individuals(){
        //constructor
        for(int i=0;i<1000;i++)
        {
            int randomNum = ThreadLocalRandom.current().nextInt(0, 7 + 1);
            chromosome.add(randomNum);
        }
//        System.out.println("list = " + chromosome);
//        System.out.println("list = " + chromosome.get(999));
    }


    public Individuals(int x, int y, double d, int w, int l) {
        this();   // invoke the default constructor
        this.x = x;
        this.y = y;
        this.d = d;
        this.w = w;
        this.l = l;
    }
    //create the vehicles and their sensors and properties
        void paint(Graphics g) {
        g.drawRect(this.x, this.y, this.w, this.l);
    }
        
        //chromosome storage and retrieval methods
        public List<Integer> setChromosome(List<Integer> c){
            chromosome = c;
            return c;
        }
        
        public List<Integer> getChromosome(){
            return chromosome; 
        }
        
    public int getX() {
    return x;
    }

    public int getY() {
        return y;
    }

    public double getD() {
        return d;
    }

    public double getW() {
        return w;
    }

    public double getL() {
        return l;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setD(double d) {
        this.d = d;
    }

//    public void setW(double w) {
//        this.w = w;
//    }
//
//    public void setL(double l) {
//        this.l = l;
//    }
    
    public String toString() {
        String returnMe = "Indiv: ";
        returnMe += "\tx=" + getX();
        returnMe += " y=" + getY();
        returnMe += " d=" + getD();
        returnMe += " w=" + getW();
        returnMe += " l=" + getL();
        return returnMe;
    } // toString()
    
    //still need sensors and accurate drawings and locations for the individuals
}
