/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attack;

import java.util.HashMap;
import champoins.*;
import java.io.Serializable;
import player.*;
/**
 *
 * @author TOSHIBA
 */
public class do_attack implements Serializable{
    Champoin obj;
    player []players;
    public do_attack(Champoin obj,player []players,player this_player){
    this.obj=obj;
    this.players=players;
    int k=0;
        int i=0,j=0,a=0;
        
        HashMap <Integer,Champoin>h2=new HashMap<Integer,Champoin>();
        HashMap <Integer,Integer>player_num=new HashMap<Integer,Integer>();
        for(a=0;a<players.length;a++){
        if(players[a]!=null &&players[a]!=this_player){
        HashMap<Integer,Champoin> temp=players[a].get_champoins_list();
        k++;
        if(!temp.isEmpty()){
        int []pos=new int[2];
        for(i=1;i<=temp.size();i++)
        {
            //System.out.println("11aaaa"+temp.get(i).get_name());
            //System.out.println("22aaaa"+obj.get_name());
        
            pos=temp.get(i).get_pos();
         if(obj.arr_att(pos[0],pos[1]))
        {
            
            h2.put(j,temp.get(i));
        player_num.put(j, a);
        j++;}
        
        }
        }
        }
        }
        if(!h2.isEmpty()){
        obj.set_enemy_to_att(h2);
        obj.set_num_player_to_att(player_num);
        }
        else{
        
        }
        
        
    }
    
    void enemy_to_att(){

        
        }
    
    
    
}
