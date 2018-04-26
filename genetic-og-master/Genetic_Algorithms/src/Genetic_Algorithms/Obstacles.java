/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Genetic_Algorithms;

import java.awt.Graphics;

/**
 *
 * @author Dalton
 */
public class Obstacles {
    public Obstacles(){
        
    }
    
    public void paintGoal(int x, int y, int w, int h, Graphics g){
        g.draw3DRect(x, y, h, h, true);
        g.fill3DRect(x, y, h, h, true);
    }
    
}
