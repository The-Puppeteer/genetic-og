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
    double d1;
    private final Genetic_Panel thePanel;
    List<Individuals> iList = new ArrayList<>();
  //  Individual_List individuals = new Individual_List();

    Controller(Genetic_Panel thePanel,int i) {
        this.thePanel = thePanel;
        this.indNum = i;
        for(int j =0; j<i;++j){
            Individuals swag = new Individuals(300, 200, 3, 30, 30);
            iList.add(j,swag);
        }
    }

    public void run() {
        int i =0;
                this.d1 = goal.distance(iList.get(0));

        for(;;) {
            if (running) {
                if(i < 1000){
                            System.out.println(fittest());

                //System.out.println(indNum);
                for(int k = 0; k<indNum;++k){
                iList.get(k).step(i);
                }
                thePanel.repaint();
                ++i;
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
            sleep(10);
        } catch (Exception e){}
    }
    Individuals a = new Individuals();
    public Individuals fittest(){
        double distance = 0;
        

            for(int k = 0; k<indNum;++k){
                distance = goal.distance(iList.get(k));
               // System.out.println(distance);
                
                if(distance < d1){
                    d1 = distance;
                    a = iList.get(k);
                    
                }else{
                    
                }
                
                }
       
        
        //return a;
      return a;          
    }
    
}