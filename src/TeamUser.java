/*
 *@author: Jose Soto
 */


public class TeamUser extends Team {



public TeamUser(int tipo){
      if(tipo==0){
    a=new Greedy(2);
    }else{
        if(tipo==1){
            a=new Ally(2);
        }else a=new Domineering(2);
    }
   
   
    u=new UserPlayer(0);
}

}
