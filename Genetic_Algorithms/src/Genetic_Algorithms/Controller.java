package Genetic_Algorithms;

import java.awt.Graphics;
import java.awt.Graphics2D;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;


class Controller extends Thread {
    boolean running = false;
    boolean nextGen = false;
    Graphics g;
    int indNum;
    Obstacles goal = new Obstacles();
    double minDist;
    private final Genetic_Panel thePanel;
    List<Individuals> iList = new ArrayList<>();
    Individuals fittestIndividual = new Individuals();
    Individuals secondFittestIndividual = new Individuals();
    List<Double> distList = new ArrayList<>();
  //  Individual_List individuals = new Individual_List();

    Controller(Genetic_Panel thePanel,int i) {
        
        this.thePanel = thePanel;
        this.indNum = i;
        for(int j =0; j<i;++j){
            Individuals swag = new Individuals(1000, 100, 3, 30, 30,goal);
            iList.add(j,swag);
        }
    }

    public void run() {
        int i =0;
        int genNum = 1;
        this.minDist = goal.distance(iList.get(0)); 
        thePanel.jLabel1.setText(Integer.toString(genNum));

//        this.d1 = goal.distance(iList.get(1));
//        System.out.println(d1);
        for(;;) {
            if (running) {
                if(i < 1000){
                    
                //System.out.println(indNum);
                for(int k = 0; k<indNum;++k){
                    
                iList.get(k).step(i);
                iList.get(k).distList(goal);
                                
                //System.out.println(fittest(iList.get(k)));
                }
                

                //fittest();
                thePanel.repaint();
                ++i;
                
                }
                if(i == 999){
                    i = 0;
                    System.out.println("fittest: " + fittest());
                    System.out.println("second fit: " + secondFittest());
                    crossover();
                    newColor();
                    repaint();
                    ++genNum;
                    thePanel.jLabel1.setText(Integer.toString(genNum));
                    
                    
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
    void newColor(){
        for (int i = 0; i < indNum; ++i) {
            iList.get(i).newColor();
        }
}
    void toggleRunning() {
        running = !running;
        
    }
    void repaint(){
        for(int k = 0; k<indNum;++k){
                    
                iList.get(k).repaint();
                }
    }
    void toggleNG() {
        nextGen = !nextGen;
        
    }

    void paint(Graphics g,int i) {
        Graphics2D g2 = (Graphics2D) g;
        iList.get(i).paint(g2);
        goal.paintGoal(100,500,50,50,g);

    }

    private void delay() {
        try {
            sleep(25);
        } catch (Exception e){}
    }
    
    
    
   
    
    
    public Individuals fittest(){
        //Individuals a = new Individuals();
        double min = iList.get(0).minDist();
        for (int i = 0; i < indNum; ++i) {
            this.distList.add(iList.get(i).minDist());
           // System.out.println(iList.get(i));
            //System.out.println(iList.get(i).minDist());
            
        }
        for (int i = 0; i < this.distList.size(); ++i) {
            if(this.distList.get(i)<min) {
                min = this.distList.get(i);
                this.fittestIndividual = iList.get(i);
            }
            
        }
        
        return this.fittestIndividual;
        
    }
    
    public Individuals secondFittest(){
        //Individuals b = new Individuals();
        double min = iList.get(0).minDist();//current minimim value for individual i
        
//        for (int i = 0; i < indNum; ++i) {
//            distList.add(iList.get(i).minDist());
//           // System.out.println(iList.get(i));
//            //System.out.println(iList.get(i).minDist());
//            
//        }
System.out.println(this.distList);
        System.out.println(this.iList);
        for (int i = 0; i < this.distList.size(); ++i) {
            if(this.distList.get(i)<min && this.distList.get(i) > this.fittestIndividual.minDist() ) {
                
                  min = this.distList.get(i);
                    this.secondFittestIndividual = iList.get(i);  
                
                
            }
            
        }
        this.distList.clear();
        return this.secondFittestIndividual;
        
    }
    public void crossover(){
        int crossPoint; 
        int rand;
        int geneSize = 3;
        for (int i = 0; i < indNum; ++i) {
            crossPoint = ThreadLocalRandom.current().nextInt(0, 997 + 1);
            for (int j = 0; j < crossPoint; ++j) {
                iList.get(i).getChromosome().remove(i);
                rand = ThreadLocalRandom.current().nextInt(0, 1 + 1);
                if(rand == 0){
                    int k;
                    for (k = 0; k < geneSize; ++k) {
                        iList.get(i).getChromosome().add(k+j, this.fittestIndividual.getChromosome().get(j+k));
                        
                    }
                j+=k;
                }
                else{
                    int k;
                    for (k = 0; k < geneSize; ++k) {
                        
                    
                iList.get(i).getChromosome().add(j+k, this.secondFittestIndividual.getChromosome().get(j+k));
                
                    }
                    j+=k;
                }
                
            }
        }
    }
    
}