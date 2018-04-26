package Genetic_Algorithms;

import java.awt.Graphics;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
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
    Graphics g;
    List<Integer> chromosome = new ArrayList<Integer>();
    protected Point2D.Double location;
        
    public void setLocation(Point2D.Double nuLocation) {location = nuLocation;}


    
    
    public Individuals(){
        //constructor
        ranChrom();
    }
    
    public void ranChrom(){
       this.chromosome.add(ThreadLocalRandom.current().nextInt(0, 7 + 1));
        
        for(int i=0;i<1000;)
        {
            
            System.out.println(this.chromosome.get(i));
            int z = direction(this.chromosome.get(i));
            //int randomNum = ThreadLocalRandom.current().nextInt(0, 7 + 1);
            for(int j = 0; j < 1;){
            this.chromosome.add(z);
            ++j;
            }
            ++i;
        }
//        System.out.println("list = " + chromosome);
//        System.out.println("list = " + chromosome.get(999));
    }

    public int direction(int i){
        int dir = 0;
        int d = i;
        //int[] intArray = {d, d, d};
            if(d != 0 && d != 7){
                int[] intArray = {d-1, d, d+1}; 
                int idx = new Random().nextInt(intArray.length);
                dir = intArray[idx];
            
            }if(d == 0){
                int[] intArray = {d+7, d, d+1}; 
                int idx = new Random().nextInt(intArray.length);
                dir = intArray[idx];
            }if(d == 7){
                int[] intArray = {d-1,d,d-7}; 
                int idx = new Random().nextInt(intArray.length);
                dir = intArray[idx];
          }
               
        
        return dir;
    }
    public Individuals(int x, int y, double d, int w, int l) {
        this();   // invoke the default constructor
        this.x = x;
        this.y = y;
        this.d = d;
        this.w = w;
        this.l = l;
    }
    
    public void step(int i){
        //for(int i = 0; i < 1000;){
           // System.out.println("X before transformation: " + this.x);
            int x1= (int) (this.x + Math.cos(angle(i))*3);
            int y1= (int) (this.y + Math.sin(angle(i))*3);
            this.x = x1;
            this.y = y1;    
//            System.out.println("Gene" + this.chromosome.get(i));
            System.out.println("Angle value: " + angle(i));
//            System.out.println("X1 value: " + x1);
//            System.out.println("X after transformation: " + this.x);
            g.drawRect(x1, y1, this.w, this.l);
           // ++i;
        //}

    }
    
    public double angle(int i){
        int chromVal = this.chromosome.get(i);
        int ang = 0;
        switch(chromVal){
            case 0: ang = 0;
                break;
            case 1: ang = 45;
                break;
            case 2: ang = 90;
                break;
            case 3: ang = 135;
                break;
            case 4: ang = 180;
                break;
            case 5: ang = 225;
                break;
            case 6: ang = 270;
                break;
            case 7: ang = 315;
                break;
        
        }
        return ang;
    }
    //create the vehicles and their sensors and properties
        void paint(Graphics g) {
            this.g = g;
            g.drawRect(this.x, this.y, this.w, this.l);
    }
        
        //chromosome storage and retrieval methods
        public List<Integer> setChromosome(List<Integer> c){
            this.chromosome = c;
            return c;
        }
        
        public List<Integer> getChromosome(){
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
