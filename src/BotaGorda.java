/*
 *@author: Jose Carlos Soto
 */
import java.util.ArrayList;
public class BotaGorda extends Jugador { 
    private int numero;
    public BotaGorda(int i){
        numero=i;
    }
    public FichaJ juega() {
        
        ArrayList<FichaJ> pc = new ArrayList<FichaJ>();
        int i = 0;
        fj = null;
        if (Animadora.cI.size() == 0) {
            fj = new FichaJ(data.get(i), 1);
            i++;
            while (i < 10) {
                if (data.get(i).getSum() > fj.getFicha().getSum()) {
                    fj = new FichaJ(data.get(i), 1);
                    i++;
                } else {
                    i++;
                }
            }
            return fj;
        } else {
            while (i < 10) {
                if (data.get(i).esActiva() && !super.esForro(data.get(i), 1)) {
                    pc.add(new FichaJ(data.get(i), 1));
                    i++;
                } else {
                    if (data.get(i).esActiva() && !super.esForro(data.get(i), 2)) {
                        pc.add(new FichaJ(data.get(i), 2));
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
