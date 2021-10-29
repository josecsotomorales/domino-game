/*
 *@author: Jose Soto
 */

import java.util.Random;

public class ParejaM extends Pareja{
 public ParejaM() {
       
        Random r = new Random();
        int in = r.nextInt(9);
        if (in <= 2) {
            j1 = new BotaGorda(3);
        } else {
            if (in > 2 && in <= 5) {
                j1 = new Aliado(3);
            } else {
                j1 = new Dominador(3);
            }
        }
        int in2 = r.nextInt(9);
        if (in2 <= 2) {
            j2 = new BotaGorda(1);
        } else {
            if (in2 > 2 && in2 <= 5) {
                j2 = new Aliado(1);
            } else {
                j2 = new Dominador(1);
            }
        }
    }

}
