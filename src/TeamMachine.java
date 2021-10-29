/*
 *@author: Jose Soto
 */

import java.util.Random;

public class TeamMachine extends Team {
 public TeamMachine() {
       
        Random r = new Random();
        int in = r.nextInt(9);
        if (in <= 2) {
            j1 = new Greedy(3);
        } else {
            if (in > 2 && in <= 5) {
                j1 = new Ally(3);
            } else {
                j1 = new Domineering(3);
            }
        }
        int in2 = r.nextInt(9);
        if (in2 <= 2) {
            j2 = new Greedy(1);
        } else {
            if (in2 > 2 && in2 <= 5) {
                j2 = new Ally(1);
            } else {
                j2 = new Domineering(1);
            }
        }
    }

}
