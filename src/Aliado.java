/*
 *@author: Jose Soto
 
 */
import java.util.ArrayList;

public class Aliado extends Jugador {

    private int numero;


    public Aliado(int i) {
        numero = i;
    }

    public FichaJ juega() {

        ArrayList<FichaJ> pci = new ArrayList<FichaJ>();
        ArrayList<FichaJ> pcd = new ArrayList<FichaJ>();
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
                    pci.add(new FichaJ(data.get(i), 1));

                }
                if (data.get(i).esActiva() && !super.esForro(data.get(i), 2)) {
                    pcd.add(new FichaJ(data.get(i), 2));

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
                    j++;
                } else {
                    j++;
                }
            }
        }

            if (pcd.size() != 0 && fj == null) {

               int j = 0;
                while (j < pcd.size()) {
                    if (!mataD()) {
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
                if ( !fallaI(pci.get(j).getFicha())) {
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

    private boolean mataI() {
        if (numero == 1) {
            if (3 == Mesa.getUltCI()) {
                return true;
            } else {
                return false;
            }
        } else {
            if ((numero - 2 == Mesa.getUltCI())) {

                return true;
            } else {

                return false;
            }
        }
    }

    private boolean mataD() {
        if (numero == 1) {
            if (3 == Mesa.getUltCD()) {
                return true;
            } else {
                return false;
            }
        } else {
            if ((numero - 2 == Mesa.getUltCD())) {

                return true;
            } else {

                return false;
            }
        }
    }

    private boolean fallaI(Ficha f) {
        int f1 = f.getV1();
        int f2 = f.getV2();
        int k;
        if (f1 == Animadora.cabezaD) {
            k = f2;

        } else {
            k = f1;
        }
        int i = 0;
        if (numero == 1) {
            if (Mesa.getPases(3).size()!=0) {
                while (i < Mesa.getPases(3).size() && k != Mesa.getPases(3).get(i)) {
                    i++;
                }
                return i < Mesa.getPases(3).size();
            } else {
                return false;
            }
        } else {
            if (Mesa.getPases(numero - 2).size()!=0) {
                while (i < Mesa.getPases(numero - 2).size() && k != Mesa.getPases(numero - 2).get(i)) {
                    i++;
                }
                return i < Mesa.getPases(numero - 2).size();
            } else {
                return false;
            }
        }
    }

    private boolean fallaD(Ficha f) {
        int f1 = f.getV1();
        int f2 = f.getV2();
        int k;
        if (f1 == Animadora.cabezaI) {
            k = f2;

        } else {
            k = f1;
        }
        int i = 0;
        if (numero == 1) {
            if (Mesa.getPases(3).size()!=0) {
                while (i < Mesa.getPases(3).size() && k != Mesa.getPases(3).get(i)) {
                    i++;
                }
                return i < Mesa.getPases(3).size();
            } else {
                return false;
            }
        } else {
            if (Mesa.getPases(numero - 2).size()!=0) {
                while (i < Mesa.getPases(numero - 2).size() && k != Mesa.getPases(numero - 2).get(i)) {
                    i++;
                }
                return i < Mesa.getPases(numero - 2).size();
            } else {
                return false;
            }
        }
    }

    @Override
    public String toString() {
        return "Aliado";
    }
}
