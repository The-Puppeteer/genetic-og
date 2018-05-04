package Genetic_Algorithms;

import java.awt.Graphics;
import java.awt.Graphics2D;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

class Controller extends Thread {

    boolean running = false;
    boolean nextGen = false;
    Graphics g;
    double prevMin = 0;
    double currMin = 0;
    int indNum;
    int goalX = 1000;
    int goalY = 500;
    int genNum;
    int runIndex;
    int fit=0;
    int speed = 20;
    int mutationRate = 10;
    Obstacles goal = new Obstacles();
    double minDist;
    Boolean draw = true;
    private final Genetic_Panel thePanel;
    List<Individuals> iList = new ArrayList<>();
    Individuals fittestIndividual = new Individuals();
    Individuals secondFittestIndividual = new Individuals();
    Individuals f1 = new Individuals();
    Individuals sf1 = new Individuals();
    List<Double> distList = new ArrayList<>();
    //  Individual_List individuals = new Individual_List();

    Controller(Genetic_Panel thePanel, int i) {

        this.thePanel = thePanel;
        this.indNum = i;
        for (int j = 0; j < i; ++j) {
            Individuals swag = new Individuals(100, 300, 3, 30, 30, goal, j);
            iList.add(j, swag);
        }
    }

    public void run() {
        this.runIndex = 0;
        genNum = 1;

        thePanel.jLabel1.setText("Generation Number: " + Integer.toString(genNum));

//        this.d1 = goal.distance(iList.get(1));
//        System.out.println(d1);
        for (;;) {
            //this.minDist = goal.distance(iList.get(0));
            if (running) {
                
                if (this.runIndex < 1000) {

                    //System.out.println(indNum);
                    
                    for (int k = 0; k < indNum; ++k) {

                        iList.get(k).step(this.runIndex, this.draw);
                        iList.get(k).distList(goal);

                        //System.out.println(fittest(iList.get(k)));
                    }

                    //fittest();
                    thePanel.repaint();
                    ++this.runIndex;

                }
                if (this.runIndex == 999) {
                    endLife();

                    //this.fittestIndividual = fittest();
                    //this.secondFittestIndividual = secondFittest();
                }

//                if(nextGen){
//                    
//                    
//                    i = 0;
//                    if (i == 0) {
//                        System.out.println("fit: " + fittest());
//                    System.out.println("second fit: " + secondFittest());
//                    crossover();
//                        
//                    }
//                    if(i < 1000){
//                    
//                //System.out.println(indNum);
//                for(int k = 0; k<indNum;++k){
//                    
//                iList.get(k).step(i);
//                iList.get(k).distList(goal);
//                                
//                //System.out.println(fittest(iList.get(k)));
//                }
//                
//
//                //fittest();
//                thePanel.repaint();
//                ++i;
//                }
//                if(i == 999){
//                    
//                    
//                    
//                    //this.fittestIndividual = fittest();
//                    //this.secondFittestIndividual = secondFittest();
//                    nextGen = false;
//                }
                //  }
//                System.out.println(theIndividual.getChromosome().get(i));
//                System.out.println(i);
            }
            delay();

        }

    }

    void endLife() {
        
        draw = true;
        this.speed = 20;
//        System.out.println("fittest: " + fittest());
//        System.out.println("second fit: " + secondFittest());
//        this.f1 = fittest();
//        this.sf1 = secondFittest();
fitness();
        crossover();
        for (int k = 0; k < indNum; ++k) {

                        
                        iList.get(k).min.clear();

                        //System.out.println(fittest(iList.get(k)));
                    }
        newColor();
        repaint();
        ++this.genNum;
        thePanel.jLabel1.setText("Generation Number: " + Integer.toString(genNum));
        thePanel.jLabel2.setText("Fittest Individual Score: " + fittestIndividual.fitness );
        thePanel.jLabel3.setText("2nd Fittest Individual Score: " + secondFittestIndividual.fitness );
        this.runIndex = 0;
    }

    void newColor() {
        for (int i = 0; i < indNum; ++i) {
            iList.get(i).newColor();
        }
    }

    void toggleRunning() {
        running = !running;

    }

    void repaint() {
        for (int k = 0; k < indNum; ++k) {

            iList.get(k).repaint();
        }
    }

    void toggleNG() {
        nextGen = !nextGen;

    }

    void paint(Graphics g, int i) {
        Graphics2D g2 = (Graphics2D) g;
        iList.get(i).paint(g2);
        goal.paintGoal(goalX, goalY, 50, 50, g);

    }

    private void delay() {
        try {
            sleep(this.speed);
        } catch (Exception e) {
        }
    }
    public void fitness(){
        
        fittest();
        secondFittest();
        if(fit==0){
          this.f1 = this.fittestIndividual;
          this.sf1 = this.secondFittestIndividual;
          ++fit;
        }else{
            if(this.f1.minDist() <= this.fittestIndividual.minDist()){
                this.fittestIndividual = this.f1;
                System.out.println("f1: " +f1);
            }else{
                this.f1 = this.fittestIndividual;
            }
            if(this.sf1.minDist() <= secondFittestIndividual.minDist() && this.sf1.minDist() > this.f1.minDist()){
                this.secondFittestIndividual = this.sf1;
                System.out.println("sf1: " + sf1);
            }else{
                this.sf1 = this.secondFittestIndividual;
            }
        }
    }

        
    
        
    
    public Individuals fittest() {
        double maxFit = Double.MIN_VALUE;
        int maxFitIndex = 0;
        for (int i = 0; i < indNum; ++i) {
            this.distList.add(1500-iList.get(i).minDist());
        }
        for (int i = 0; i < indNum; i++) {
            if (maxFit <= distList.get(i)) {
                maxFit = distList.get(i);
                maxFitIndex = i;
                        
fittestIndividual = iList.get(maxFitIndex);
fittestIndividual.setFitness(maxFit);
                
            }
        }
        this.distList.clear();
        
        return fittestIndividual;
//        this.distList.clear();
//        for (int i = 0; i < indNum; ++i) {
//            this.distList.add(iList.get(i).minDist());
//        }
//        this.currMin = distList.get(0);
//        System.out.println("1st currMin: " + this.currMin);
//        System.out.println("prevMin: " + prevMin);
//            for (int i = 0; i < this.distList.size(); ++i) {
//                if (this.distList.get(i) <= this.currMin) {
//                    this.currMin = this.distList.get(i);
//                        this.fittestIndividual = iList.get(i);
//                }
//            
//
//        }
//
//        prevMin = this.currMin;
//        //this.overallMin= min;
//        System.out.println("currMin: " + this.currMin);
//        return this.fittestIndividual;

    }

    public Individuals secondFittest() {
        int maxFit1 = 0;
        int maxFit2 = 0;
        for (int i = 0; i < indNum; ++i) {
            this.distList.add(1500-iList.get(i).minDist());
        }
        for (int i = 0; i < indNum; i++) {
            if (distList.get(i) > distList.get(maxFit1)) {
                maxFit2 = maxFit1;
                maxFit1 = i;
            } else if (distList.get(i) > distList.get(maxFit2)) {
                maxFit2 = i;
            }
        }
        this.secondFittestIndividual.setFitness(distList.get(maxFit2));
        this.distList.clear();
        this.secondFittestIndividual = iList.get(maxFit2);
        
        //  System.out.println(distList);
        return this.secondFittestIndividual;
        //return individuals[maxFit2];
        //Individuals b = new Individuals();
//        double min = distList.get(0);//current minimim value for individual i
//        // System.out.println(min);
////        for (int i = 0; i < indNum; ++i) {
////            distList.add(iList.get(i).minDist());
////           // System.out.println(iList.get(i));
////            //System.out.println(iList.get(i).minDist());
////            
////        }
////System.out.println(this.distList);
//        //     System.out.println(this.iList);
//        for (int i = 0; i < this.distList.size(); ++i) {
//
//            //min = this.distList.get(i);
//            if (this.distList.get(i) <= min && this.distList.get(i) > this.fittestIndividual.minDist()) {
//
//                min = this.distList.get(i);
//                this.secondFittestIndividual = iList.get(i);
//
//            }
//
////            if(this.distList.get(i) == min){
////                 min = this.distList.get(i);
////                    this.secondFittestIndividual = iList.get(i); 
////            }
//        }
//        // System.out.println(min);
        

    }

    public void crossover() {
        int crossPoint;
        int rand;
        int mutation;
        int geneSize = 4;
        for (int i = 0; i < indNum; ++i) {

//            iList.get(indNum - 1).chromosome = this.fittestIndividual.chromosome;
//            iList.get(indNum - 2).chromosome = this.secondFittestIndividual.chromosome;
            crossPoint = ThreadLocalRandom.current().nextInt(0, 997 + 1);
            for (int j = 0; j < crossPoint; ++j) {
                iList.get(i).getChromosome().remove(i);
                rand = ThreadLocalRandom.current().nextInt(0, 1 + 1);
                mutation = ThreadLocalRandom.current().nextInt(0, mutationRate + 1);
                //mutation = 0;
                if (rand == 0) {
                    int k;
                    for (k = 0; k < geneSize; ++k) {
                        if (mutation == 1) {
                            iList.get(i).getChromosome().add(k + j, ThreadLocalRandom.current().nextInt(0, 7 + 1));
                        } else {
                            iList.get(i).getChromosome().add(k + j, this.fittestIndividual.getChromosome().get(j + k));
                        }
                    }
                    j += k;
                } else {
                    int k;
                    for (k = 0; k < geneSize; ++k) {
                        if (mutation == 1) {
                            iList.get(i).getChromosome().add(k + j, ThreadLocalRandom.current().nextInt(0, 7 + 1));
                        } else {

                            iList.get(i).getChromosome().add(j + k, this.secondFittestIndividual.getChromosome().get(j + k));
                        }
                    }
                    j += k;
                }

            }
        }
    }

}
