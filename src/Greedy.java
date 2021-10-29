/*
 *@author: Jose Soto
 */
import java.util.ArrayList;
public class Greedy extends Player {
    private int numero;
    public Greedy(int i){
        numero=i;
    }
    public CardPlayer juega() {
        
        ArrayList<CardPlayer> pc = new ArrayList<CardPlayer>();
        int i = 0;
        fj = null;
        if (Animation.cI.size() == 0) {
            fj = new CardPlayer(data.get(i), 1);
            i++;
            while (i < 10) {
                if (data.get(i).getSum() > fj.getFicha().getSum()) {
                    fj = new CardPlayer(data.get(i), 1);
                    i++;
                } else {
                    i++;
                }
            }
            return fj;
        } else {
            while (i < 10) {
                if (data.get(i).esActiva() && !super.esForro(data.get(i), 1)) {
                    pc.add(new CardPlayer(data.get(i), 1));
                    i++;
                } else {
                    if (data.get(i).esActiva() && !super.esForro(data.get(i), 2)) {
                        pc.add(new CardPlayer(data.get(i), 2));
                        i++;
                    } else {
                        i++;
                    }

                }
            }
        }
        if (pc.size() != 0) {
            fj = pc.get(0);
            int j = 1;
            while (j < pc.size()) {
                if (pc.get(j).getFicha().getSum() > fj.getFicha().getSum()) {
                    fj = pc.get(j);
                    j++;
                } else {
                    j++;
                }
            }
            return fj;
        } else {
            return null;
        }
    }
    
    @Override
    public String toString(){
        return "Botagorda";
    }
}
