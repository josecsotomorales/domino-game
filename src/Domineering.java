/*
 *@author: Jose Soto
 */
import java.util.ArrayList;

public class Domineering extends Player {

    private int nDat;
    private final int numero;

    public Domineering(int i) {
        numero = i;
    }

    public CardPlayer juega() {
        buscaNDat();
        ArrayList<CardPlayer> pci = new ArrayList<CardPlayer>();
        ArrayList<CardPlayer> pcd = new ArrayList<CardPlayer>();
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
                if (esNDat(pci.get(j).getFicha())&&pasaCont(pci.get(j).getFicha())) {
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
                    if (esNDat(pcd.get(j).getFicha())&&pasaCont(pcd.get(j).getFicha())) {
                        fj = pcd.get(j);
                        j++;
                    } else {
                        j++;
                    }
                }
                
                    
            }
        if(fj==null&&pci.size()!=0){
            
            int j = 0;
            while (j < pci.size()) {
                if (esNDat(pci.get(j).getFicha())) {
                    fj = pci.get(j);
                    j++;
                } else {
                    j++;
                }
            }
                    
        }
        if ( fj == null&&pcd.size() != 0 ) {

               int j = 0;
                while (j < pcd.size()) {
                    if (esNDat(pcd.get(j).getFicha())) {
                        fj = pcd.get(j);
                        j++;
                    } else {
                        j++;
                    }
                }

                    
            }




        if(fj==null&&pci.size()!=0){

            int j = 0;
            while (j < pci.size()) {
                if (pasaCont(pci.get(j).getFicha())) {
                    fj = pci.get(j);
                    j++;
                } else {
                    j++;
                }
            }
                    
        }
        if ( fj == null&&pcd.size() != 0 ) {

               int j = 0;
                while (j < pcd.size()) {
                    if (pasaCont(pcd.get(j).getFicha())) {
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
            if (fj == null && (pci.size() != 0)) {

                return pci.get(0);
            } else {
                if (fj == null && (pcd.size() != 0)) {

                    return pcd.get(0);
                } else {
                    return null;
                }
            }
        }
    }

    private void buscaNDat() {
        int f = 0;
        int ma = 0;
        int[] cont = new int[10];
        for (int i = 0; i < data.size(); i++) {
            switch (data.get(i).getV1()) {
                case 0:
                    cont[0] += 1;
                    break;
                case 1:
                    cont[1] += 1;
                    break;
                case 2:
                    cont[2] += 1;
                    break;
                case 3:
                    cont[3] += 1;
                    break;
                case 4:
                    cont[4] += 1;
                    break;
                case 5:
                    cont[5] += 1;
                    break;
                case 6:
                    cont[6] += 1;
                    break;
                case 7:
                    cont[7] += 1;
                    break;
                case 8:
                    cont[8] += 1;
                    break;
                case 9:
                    cont[9] += 1;
                    break;
            }
            switch (data.get(i).getV2()) {
                case 0:
                    cont[0] += 1;
                    break;
                case 1:
                    cont[1] += 1;
                    break;
                case 2:
                    cont[2] += 1;
                    break;
                case 3:
                    cont[3] += 1;
                    break;
                case 4:
                    cont[4] += 1;
                    break;
                case 5:
                    cont[5] += 1;
                    break;
                case 6:
                    cont[6] += 1;
                    break;
                case 7:
                    cont[7] += 1;
                    break;
                case 8:
                    cont[8] += 1;
                    break;
                case 9:
                    cont[9] += 1;
                    break;
            }


        }
        for (int k = 0; k < cont.length; k++) {
            if (cont[k] > ma) {
                ma = cont[k];
                f = k;
            }
        }
        switch (f) {
            case 0:
                nDat = 0;
                break;
            case 1:
                nDat = 1;
                break;
            case 2:
                nDat = 2;
                break;
            case 3:
                nDat = 3;
                break;
            case 4:
                nDat = 4;
                break;
            case 5:
                nDat = 5;
                break;
            case 6:
                nDat = 6;
                break;
            case 7:
                nDat = 7;
                break;
            case 8:
                nDat = 8;
                break;
            case 9:
                nDat = 9;
                break;
        }
        
    }

    private boolean esNDat(Card f) {
        int v1 = f.getV1();
        int v2 = f.getV2();
        if (((v1 == Animation.cabezaD || v1 == Animation.cabezaI) && v2 == nDat) || ((v2 == Animation.cabezaD || v2 == Animation.cabezaI) && v1 == nDat)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean pasaCont(Card f) {
        boolean be;
        int f1 = f.getV1();
        int f2 = f.getV2();
        int k;
        if (f1 == Animation.cabezaD || f1 == Animation.cabezaI) {
            k = f2;

        } else {
            k = f1;
        }
        int j = 0;
        int i = 0;
        if (numero == 3) {
            if (Table.getPases(0).size()!=0) {
                while (i < Table.getPases(0).size() && k != Table.getPases(0).get(i)) {
                    i++;
                }

                be=i < Table.getPases(2).size();
            }
            if (Table.getPases(0).size()==0 && Table.getPases(2).size()!=0) {
                while (i < Table.getPases(2).size() && k != Table.getPases(2).get(i)) {
                    i++;
                }

                be=i < Table.getPases(2).size();
            } else {
                be= false;
            }
            
return be;
        } else {
            if (Table.getPases(numero + 1).size()!=0) {
                
                while (i < Table.getPases(numero + 1).size() && k != Table.getPases(numero + 1).get(i)) {
                    i++;
                }

                be=i < Table.getPases(numero + 1).size();
            }
            if (Table.getPases(numero + 1).size()==0 && Table.getPases(numero - 1).size()!=0) {
                
                while (i < Table.getPases(numero - 1).size() && k != Table.getPases(numero - 1).get(i)) {
                    i++;
                }

                be=i < Table.getPases(2).size();
            } else {
                be= false;
            }
            
            return be;
        }

    }

    @Override
    public String toString() {
        return "Domineering";
    }
}
