/*
 *@author: Jose Soto
 */
import java.util.ArrayList;


public abstract class Jugador{
  

   protected FichaJ fj;
    protected Ficha[] predata;
    protected ArrayList<Ficha> data;

public abstract FichaJ juega();
public void cojeFich(Ficha[] d,char tipo){
        data=new ArrayList<Ficha>();
    predata=d;
    for(int i=0;i<predata.length;i++){
        data.add(i, predata[i]);
        if(tipo=='c'){
            if(data.get(i).isDoble())
               data.get(i).setOrient('a');
            else data.get(i).setOrient('a');
        }else if(tipo=='m'){
           if(data.get(i).isDoble())
               data.get(i).setOrient('r');
            else data.get(i).setOrient('r');
        }else{
            if(data.get(i).isDoble())
        data.get(i).setOrient('v');
        else
            data.get(i).setOrient('n');
        }

    }
    }
public ArrayList<Ficha> getFichas(){
    return data;
}
public boolean lleva(){
        int i=0;
         if(Animadora.cI.size()==0){
        return true;
    }else{
        while(i<10&&(!data.get(i).esActiva()||(esForro(data.get(i),1)&&esForro(data.get(i),2)))){
            i++;
        }
        return i<10;}
    }
 public int cuenta(){
     int s=0;
     int i=0;
     while(i<10){
         if(data.get(i).esActiva()){
         s+=data.get(i).getSum();
         i++;
         }else i++;
     }return s;
 }

   public void virarse(char tipo){
     int i=0;
     while(i<10){
if(data.get(i).esActiva()){
        if(tipo=='c'){
            if(data.get(i).isDoble())
               data.get(i).setOrient('v');
            else data.get(i).setOrient('v');
        }else if(tipo=='m'){
           if(data.get(i).isDoble())
               data.get(i).setOrient('h');
            else data.get(i).setOrient('h');
        }i++;
}else{
    i++;
}

    }
 }
  public boolean esForro(Ficha cual,int pDonde){
    boolean f = false;
    if(Animadora.cI.size()==0){

    }
    if(pDonde==1){
        if((cual.isDoble()&&(Animadora.cI.get(Animadora.cI.size()-1).isDoble()))||!(cual.getV1()==Animadora.cabezaD||cual.getV2()==Animadora.cabezaD)){
            f=true;
        }else{f=false;}
    }else{
        if(pDonde==2){
        if((cual.isDoble()&&(Animadora.cD.get(Animadora.cD.size()-1).isDoble()))||!(cual.getV1()==Animadora.cabezaI||cual.getV2()==Animadora.cabezaI)){
            f=true;
        }else{f=false;}
    }
    }return f;
}
}
