package Genetic_Algorithms;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @authors Connor, Dalton, Chris
 */
public class Individuals {

    protected int x;
    protected int x1;
    protected int indNum;
    protected int y;
    protected int y1;
    protected double d;
    protected int w;
    protected int w1;
    protected int l;
    protected int l1;
    int r = (int) (Math.random() * 255);
    int green = (int) (Math.random() * 255);
    int b = (int) (Math.random() * 255);
    Obstacles a;
    Graphics g;
    List<Double> min = new ArrayList<>();
    List<Integer> chromosome = new ArrayList<Integer>();
    protected Point2D.Double location;

    public void setLocation(Point2D.Double nuLocation) {
        location = nuLocation;
    }

    public Individuals() {
        //constructor
        ranChrom();
    }

    public void ranChrom() {
        this.chromosome.add(ThreadLocalRandom.current().nextInt(0, 7 + 1));

        for (int i = 0; i < 1000;) {

            //System.out.println(this.chromosome.get(i));
            int z = direction(this.chromosome.get(i));
            //int randomNum = ThreadLocalRandom.current().nextInt(0, 7 + 1);
            for (int j = 0; j < 1;) {
                this.chromosome.add(z);
                ++j;
            }
            ++i;
        }
//        System.out.println("list = " + chromosome);
//        System.out.println("list = " + chromosome.get(999));
    }

    public int direction(int i) {
        int dir = 0;
        int d = i;
        //int[] intArray = {d, d, d};
        if (d != 0 && d != 7) {
            int[] intArray = {d - 1, d, d + 1};
            int idx = new Random().nextInt(intArray.length);
            dir = intArray[idx];

        }
        if (d == 0) {
            int[] intArray = {d + 7, d, d + 1};
            int idx = new Random().nextInt(intArray.length);
            dir = intArray[idx];
        }
        if (d == 7) {
            int[] intArray = {d - 1, d, d - 7};
            int idx = new Random().nextInt(intArray.length);
            dir = intArray[idx];
        }

        return dir;
    }

    public Individuals(int x, int y, double d, int w, int l, Obstacles a, int number) {
        this();   // invoke the default constructor
        this.x = x;
        this.x1 = x;
        this.y1 = y;
        this.y = y;
        this.d = d;
        this.w1 = w;
        this.w = w;
        this.l1 = l;
        this.l = l;
        this.a = a;
        this.indNum = number;

    }

    public void repaint() {
        this.x = this.x1;
        this.y = this.y1;
        this.w = this.w1;
        this.l = this.l1;
        g.drawRect(this.x1, this.y1, this.w1, this.l1);

    }

    public void step(int i, Boolean draw) {
        //for(int i = 0; i < 1000;){
        // System.out.println("X before transformation: " + this.x);
        int x1 = (int) (this.x + Math.cos(angle(i)) * 3);
        int y1 = (int) (this.y + Math.sin(angle(i)) * 3);
        this.x = x1;
        this.y = y1;
//            System.out.println("Gene" + this.chromosome.get(i));
        //System.out.println("Angle value: " + angle(i));
//            System.out.println("X1 value: " + x1);
//            System.out.println("X after transformation: " + this.x);
        if (draw) {
            g.drawRect(x1, y1, this.w, this.l);
        }
        // ++i;
        //}

    }

    public double minDist() {
        double minDist = this.min.get(0);
        for (int i = 0; i < this.min.size(); ++i) {
            if (this.min.get(i) < minDist) {
                minDist = Math.abs(this.min.get(i));
            }
        }
        //min.clear();
        return minDist;

    }

    public void newColor() {
        this.r = (int) (Math.random() * 255);
        this.green = (int) (Math.random() * 255);
        this.b = (int) (Math.random() * 255);
    }

    public void distList(Obstacles a) {
        
        double x2 = a.getX();
        double y2 = a.getY();
        double dist = Math.sqrt(Math.pow(this.x - x2, 2) + Math.pow(this.y - y2, 2));
        this.min.add(dist);

    }

    public double angle(int i) {
        int chromVal = this.chromosome.get(i);
        int ang = 0;
        switch (chromVal) {
            case 0:
                ang = 0;
                break;
            case 1:
                ang = 45;
                break;
            case 2:
                ang = 90;
                break;
            case 3:
                ang = 135;
                break;
            case 4:
                ang = 180;
                break;
            case 5:
                ang = 225;
                break;
            case 6:
                ang = 270;
                break;
            case 7:
                ang = 315;
                break;

        }
        return ang;
    }

    //create the vehicles and their sensors and properties
    void paint(Graphics g) {

        this.g = g;
        Color randColor = new Color(this.r, this.green, this.b);
        g.setColor(randColor);
        g.fillRect(x, y, w, l);
        g.drawRect(this.x, this.y, this.w, this.l);
    }

    //chromosome storage and retrieval methods
    public List<Integer> setChromosome(List<Integer> c) {
        this.chromosome = c;
        return c;
    }

    public List<Integer> getChromosome() {
        return this.chromosome;
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
        String returnMe = "Indiv " + indNum + ":";
        returnMe += "\tx=" + getX();
        returnMe += " y=" + getY();
        returnMe += " d=" + getD();
        returnMe += " w=" + getW();
        returnMe += " l=" + getL();
        return returnMe;
    } // toString()

}
