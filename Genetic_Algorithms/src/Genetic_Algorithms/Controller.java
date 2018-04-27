package Genetic_Algorithms;

import java.awt.Graphics;
import java.awt.Graphics2D;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.List;


class Controller extends Thread {
    boolean running = false;
    Graphics g;
    int indNum;
    Obstacles goal = new Obstacles();
    double minDist;
    private final Genetic_Panel thePanel;
    List<Individuals> iList = new ArrayList<>();
    List<Double> distList = new ArrayList<>();
  //  Individual_List individuals = new Individual_List();

    Controller(Genetic_Panel thePanel,int i) {
        
        this.thePanel = thePanel;
        this.indNum = i;
        for(int j =0; j<i;++j){
            Individuals swag = new Individuals(300, 200, 3, 30, 30,goal);
            iList.add(j,swag);
        }
    }

    public void run() {
        int i =0;
        this.minDist = goal.distance(iList.get(0));                       

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
                    System.out.println(fittest());
                }
//                System.out.println(theIndividual.getChromosome().get(i));
//                System.out.println(i);
            }
            delay();
            
        }
        
    }
    
    void toggleRunning() {
        running = !running;
        
    }

    void paint(Graphics g,int i) {
        Graphics2D g2 = (Graphics2D) g;
        iList.get(i).paint(g2);
        goal.paintGoal(300,300,50,50,g);

    }

    private void delay() {
        try {
            sleep(20);
        } catch (Exception e){}
    }
    
    
    
   
    
    
    public Individuals fittest(){
        Individuals a = new Individuals();
        double min = iList.get(0).minDist();
        for (int i = 0; i < indNum; ++i) {
            distList.add(iList.get(i).minDist());
            System.out.println(iList.get(i));
            System.out.println(iList.get(i).minDist());
            
        }
        for (int i = 0; i < distList.size(); ++i) {
            if(distList.get(i)<min) {
                min = distList.get(i);
                a = iList.get(i);
            }
            
        }

        return a;
    }
    
}