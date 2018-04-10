package Genetic_Algorithms;

import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author Connor McGuigan Feb 13, 2018 2:51:54 PM
 */
public class Individual_List extends ArrayList<Individual> {
    
    public String toString()
    {
        String returnMe="PLIST:";
        
        for (Individual nextPend : this) {
            returnMe += "\n\t" + nextPend.toString();
        }
        
        return returnMe;
    }

}
