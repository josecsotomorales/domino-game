/*
 *@author: José Carlos Soto
 */


public class ParejaU extends Pareja {



public ParejaU(int tipo){
      if(tipo==0){
    a=new BotaGorda(2);
    }else{
        if(tipo==1){
            a=new Aliado(2);
        }else a=new Dominador(2);
    }
   
   
    u=new JUsuario(0);
}

}
