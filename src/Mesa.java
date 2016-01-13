/*
 *@author: Jose Carlos Soto
 */
import java.util.ArrayList;
import java.util.Random;

public class Mesa{
    private static int ultCI;
    private static int ultCD;
    private static ArrayList<Integer> pases1;
    private static ArrayList<Integer> pases2;
 private static ArrayList<Integer> pasesU;
    private static ArrayList<Integer> pasesA;
   static Pareja pU,pM;
   static Ficha[] p1,  p2,  p3,  p4;
private Ficha[] tf = {new Ficha(0, 0), new Ficha(1, 0), new Ficha(2, 0), new Ficha(3, 0), new Ficha(4, 0),
        new Ficha(5, 0), new Ficha(6, 0), new Ficha(7, 0), new Ficha(8, 0), new Ficha(9, 0),
        new Ficha(1, 1), new Ficha(2, 1), new Ficha(3, 1), new Ficha(4, 1), new Ficha(5, 1),
        new Ficha(6, 1), new Ficha(7, 1), new Ficha(8, 1), new Ficha(9, 1), new Ficha(2, 2),
        new Ficha(3, 2), new Ficha(4, 2), new Ficha(5, 2), new Ficha(6, 2), new Ficha(7, 2),
        new Ficha(8, 2), new Ficha(9, 2), new Ficha(3, 3), new Ficha(4, 3), new Ficha(5, 3),
        new Ficha(6, 3), new Ficha(7, 3), new Ficha(8, 3), new Ficha(9, 3), new Ficha(4, 4),
        new Ficha(5, 4), new Ficha(6, 4), new Ficha(7, 4), new Ficha(8, 4), new Ficha(9, 4),
        new Ficha(5, 5), new Ficha(6, 5), new Ficha(7, 5), new Ficha(8, 5), new Ficha(9, 5),
        new Ficha(6, 6), new Ficha(7, 6), new Ficha(8, 6), new Ficha(9, 6), new Ficha(7, 7),
        new Ficha(8, 7), new Ficha(9, 7), new Ficha(8, 8), new Ficha(9, 8), new Ficha(9, 9)};
    public static int getUltCI() {
        return ultCI;
    }

    public static void setUltCI(int aUltCI) {
        ultCI = aUltCI;
    }

    public static int getUltCD() {
        return ultCD;
    }

    public static void setUltCD(int aUltCD) {
        ultCD = aUltCD;
    }
    
    static int x,  y, x2, y2;
    static int xc1 =362,  xc2 =-75,  yc1 =275,  yc2 =275;
public Mesa(){
    ultCI=0;
    ultCD=0;
      pasesU=new ArrayList<Integer>();
    pasesA=new ArrayList<Integer>();
     pases1 = new ArrayList<Integer>();
        pases2 = new ArrayList<Integer>();
}
    

    public static void creaPareja(int t) {
        pU = new ParejaU(t);
        pM = new ParejaM();
    }

    public void daAgua() {
p1 = new Ficha[10];
        p2 = new Ficha[10];
        p3 = new Ficha[10];
        p4 = new Ficha[10];

        Random r = new Random();
        int x = getTf().length;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 10; j++) {
                int p = r.nextInt(x);
                Ficha v = getTf()[p];
                switch (i) {
                    case 0:
                        p1[j] = v;
                        break;
                    case 1:
                        p2[j] = v;
                        break;
                    case 2:
                        p3[j] = v;
                        break;
                    case 3:
                        p4[j] = v;
                }
                Ficha[] tmp = new Ficha[--x];
                for (int k = 0; k < p; k++) {
                    tmp[k] = getTf()[k];
                }
                int a = p;
                for (int k = p + 1; k <= x; k++) {
                    tmp[a] = getTf()[k];
                    a++;
                }
                tf = tmp;
               
            }
        }
    }

    public void repartir() {
        pU.getA().cojeFich(p3,'c');
        pU.getU().cojeFich(p1,'u');
        pM.getJ1().cojeFich(p2,'m');
        pM.getJ2().cojeFich(p4,'m');
    }

    public static Pareja getPu() {
        return pU;
    }

    public static Pareja getPm() {
        return pM;
    }

    public Ficha[] getTf() {
        return tf;
    }
  

    public static void setPasesU(int a,int b) {
int i=0;
      while(i<pasesU.size()&&pasesU.get(i)!=a){
          i++;
      }
      if(i>=pasesU.size()){
          pasesU.add(a);
      }
      int j=0;
      while(j<pasesU.size()&&pasesU.get(j)!=b){
          j++;
      }
      if(j>=pasesU.size()){
          pasesU.add(b);
      }
      
    }


    public static void setPasesA(int a,int b) {
int i=0;
      while(i<pasesA.size()&&pasesA.get(i)!=a){
          i++;
      }
      if(i>=pasesA.size()){
          pasesA.add(a);
      }
      int j=0;
      while(j<pasesA.size()&&pasesA.get(j)!=b){
          j++;
      }
      if(j>=pasesA.size()){
          pasesA.add(b);
      }
    }
    

    public static void setPases1(int a, int b) {
        int i = 0;
        while (i < pases1.size() && pases1.get(i) != a) {
            i++;
        }
        if (i >= pases1.size()) {
            pases1.add(a);
        }
        int j = 0;
        while (j < pases1.size() && pases1.get(j) != b) {
            j++;
        }
        if (j >= pases1.size()) {
            pases1.add(b);
        }

    }

   

    public static void setPases2(int a, int b) {
        int i = 0;
        while (i < pases2.size() && pases2.get(i) != a) {
            i++;
        }
        if (i >= pases2.size()) {
            pases2.add(a);
        }
        int j = 0;
        while (j < pases2.size() && pases2.get(j) != b) {
            j++;
        }
        if (j >= pases2.size()) {
            pases2.add(b);
        }
    }
    public static ArrayList<Integer> getPases(int i){
        ArrayList<Integer> p=null;
        switch (i){
                case 0:p= pasesU;break;
            case 3:p= pases1;break;
            case 2:p= pasesA;break;
            case 1:p= pases2;break;

        }
        return p;
    }
    
}
