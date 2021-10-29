/*
 *@author: Jose Soto
 
 */
import java.util.ArrayList;

public class Ally extends Player {

    private final int numero;


    public Ally(int i) {
        numero = i;
    }

    public CardPlayer juega() {

        ArrayList<CardPlayer> pci = new ArrayList<>();
        ArrayList<CardPlayer> pcd = new ArrayList<>();
        int i = 0;
        fj = null;

        if (Animation.cI.size() == 0) {
            fj = new CardPlayer(data.get(i), 1);
            i++;
            while (i < 10) {
                if (data.get(i).getSum() > fj.getFicha().getSum()) {
                    fj = new CardPlayer(data.get(i), 1);
                }
                i++;
            }
            return fj;
        } else {
            while (i < 10) {
                if (data.get(i).esActiva() && !super.esForro(data.get(i), 1)) {
                    pci.add(new CardPlayer(data.get(i), 1));

                }
                if (data.get(i).esActiva() && !super.esForro(data.get(i), 2)) {
                    pcd.add(new CardPlayer(data.get(i), 2));

                }
                i++;
            }
        }

        if (fj==null&&pci.size() != 0) {

            int j = 0;
            while (j < pci.size()) {
                if (!mataI() && !fallaI(pci.get(j).getFicha())) {
                    fj = pci.get(j);
                    j++;
                } else {
                    j++;
                }
            }
        }
            
            if (pcd.size() != 0 && fj == null) {

               int j = 0;
                while (j < pcd.size()) {
                    if (!mataD() && !fallaD(pcd.get(j).getFicha())) {
                        fj = pcd.get(j);
                        j++;
                    } else {
                        j++;
                    }
                }
                
            }




        if (fj==null&&pci.size() != 0) {

            int j = 0;
            while (j < pci.size()) {
                if (!mataI()) {
                    fj = pci.get(j);
                }
                j++;
            }
        }

            if (pcd.size() != 0 && fj == null) {

               int j = 0;
                while (j < pcd.size()) {
                    if (!mataD()) {
                        fj = pcd.get(j);
                    }
                    j++;
                }

            }




        if (fj==null&&pci.size() != 0) {

            int j = 0;
            while (j < pci.size()) {
                if ( !fallaI(pci.get(j).getFicha())) {
                    fj = pci.get(j);
                }
                j++;
            }
        }

            if (pcd.size() != 0 && fj == null) {

               int j = 0;
                while (j < pcd.size()) {
                    if (!fallaD(pcd.get(j).getFicha())) {
                        fj = pcd.get(j);
                        j++;
                    } else {
                        j++;
                    }
                }

            }
        
        if (fj != null) {

            return fj;
        } else {
            if (pci.size() != 0) {

                return pci.get(0);
            } else {
                if (pcd.size() != 0) {

                    return pcd.get(0);
                } else {
                    return null;
                }
            }
        }
    }

    private boolean mataI() {
        if (numero == 1) {
            return 3 == Table.getUltCI();
        } else {
            return numero - 2 == Table.getUltCI();
        }
    }

    private boolean mataD() {
        if (numero == 1) {
            return 3 == Table.getUltCD();
        } else {
            return numero - 2 == Table.getUltCD();
        }
    }

    private boolean fallaI(Card f) {
        int f1 = f.getV1();
        int f2 = f.getV2();
        int k;
        if (f1 == Animation.cabezaD) {
            k = f2;

        } else {
            k = f1;
        }
        int i = 0;
        if (numero == 1) {
            if (Table.getPases(3).size()!=0) {
                while (i < Table.getPases(3).size() && k != Table.getPases(3).get(i)) {
                    i++;
                }
                return i < Table.getPases(3).size();
            } else {
                return false;
            }
        } else {
            if (Table.getPases(numero - 2).size()!=0) {
                while (i < Table.getPases(numero - 2).size() && k != Table.getPases(numero - 2).get(i)) {
                    i++;
                }
                return i < Table.getPases(numero - 2).size();
            } else {
                return false;
            }
        }
    }

    private boolean fallaD(Card f) {
        int f1 = f.getV1();
        int f2 = f.getV2();
        int k;
        if (f1 == Animation.cabezaI) {
            k = f2;

        } else {
            k = f1;
        }
        int i = 0;
        if (numero == 1) {
            if (Table.getPases(3).size()!=0) {
                while (i < Table.getPases(3).size() && k != Table.getPases(3).get(i)) {
                    i++;
                }
                return i < Table.getPases(3).size();
            } else {
                return false;
            }
        } else {
            if (Table.getPases(numero - 2).size()!=0) {
                while (i < Table.getPases(numero - 2).size() && k != Table.getPases(numero - 2).get(i)) {
                    i++;
                }
                return i < Table.getPases(numero - 2).size();
            } else {
                return false;
            }
        }
    }

    @Override
    public String toString() {
        return "Ally";
    }
}
