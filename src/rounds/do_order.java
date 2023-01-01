/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rounds;

import champoins.Champoin;
import champoins.champoin_action;
import java.util.HashMap;
//import java.util.concurrent.TimeUnit;
import player.player;

/**
 *
 * @author TOSHIBA
 */
public class do_order implements Runnable{

    player []players;
    int p;
    String [][]btn_type;
    do_order(player []players,int p,String [][]btn_type){
    this.players=players;
    this.p=p;
    this.btn_type=btn_type;
    }
    
    @Override
    public void run() {
     
     int j;
     HashMap<Integer,String> order_name=players[p].get_order_list_name();
     HashMap<Integer,String> order_list=players[p].get_order_list();
     HashMap<Integer,Champoin> champoins=players[p].get_champoins_list();    
     if(!order_name.isEmpty()){
         
     for(int k=1;k<=order_name.size();k++){
     //System.out.println("132bbbbb"+order_list_name.get(k));
         int t=0;
         String tem;
         for(j=1;j<=champoins.size();j++){
             tem=order_name.get(k);
             if((tem).contains(champoins.get(j).get_name())){
     
                 t=1; break;}
     }
     
     
            
      //  System.out.println("enjjjj"+j);
        if(t==1){
            System.out.print("\n"+order_name.get(k)+" do :");
            new champoin_action(order_list.get(k),champoins.get(j),players,players[p],btn_type).begin();
        }
       else{System.out.println(order_name.get(k)+" not stall in arena !!");}
        
        
    (new check_dead(players)).check_dead_all_players();
    }
     
     
    }
     else{
     System.out.println("no order !!");
     }
     
   
     
    }
    
    
    
    
    //inner
    
       
 public class check_dead {
 
     player []players;
     
        check_dead(player []players){
        this.players=players;
        }
        
        
           
 public void if_dead(player p)
  {
 HashMap<Integer,Champoin> champoins_list=p.get_champoins_list();    
     
  for(int i=1;i<=champoins_list.size();i++)
  {
   if(!champoins_list.isEmpty())
  if(champoins_list.get(i).ifdead())
  {    
  System.out.println(champoins_list.get(i).get_name()+" is die in last round !!");
  p.delet_classes(p,champoins_list.get(i));
  p.return_items_from_champ(champoins_list.get(i));
  p.list_new(champoins_list,i);
  //order_list.remove(i);
  p.decrease_num_cham();
  p.decrease_const_num_cham();
  
  i=i-1;
  }
     
  }  
     
  }
 public void check_dead_all_players(){
 
 for(int i=0;i<players.length;i++){
 if(players[i]!=null)
 if_dead(players[i]);
 
 }
 }

        
        
}
 
    
    
    
}
