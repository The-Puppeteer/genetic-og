package Genetic_Algorithms;

import java.util.ArrayList;

/**
 *
 * @author Connor McGuigan Feb 13, 2018 2:51:54 PM
 */
public class Individual_List extends ArrayList<Individuals> {
    
    public String toString()
    {
        String returnMe="PLIST:";
        
        for (Individuals nextIndiv : this) {
            returnMe += "\n\t" + nextIndiv.toString();
        }
        
        return returnMe;
    }

}
