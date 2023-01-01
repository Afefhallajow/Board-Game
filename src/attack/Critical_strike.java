/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attack;

import champoins.Champoin;
import java.io.Serializable;
import java.util.HashMap;
import player.player;

/**
 *
 * @author TOSHIBA
 */
public class Critical_strike extends do_attack implements Serializable{

    public Critical_strike(Champoin obj, player[] players, player this_player) {
        super(obj, players, this_player);
    }
    
    
    
    public void do_Critical_strike(String name_to_att){

    HashMap <Integer,Champoin>champoin_to_att;
    HashMap <Integer,Champoin>champoin_target;
    HashMap <Integer,Integer>player_num;
    champoin_to_att=obj.get_enemy_to_att();
    player_num=obj.get_num_player_to_att();
    int i;int k=0;
    if(!champoin_to_att.isEmpty()){
    for(i=0;i<champoin_to_att.size();i++){
    if(name_to_att.contains(champoin_to_att.get(i).get_name()))
    {k=1;break;}
    }
    if(k==0){System.out.println(name_to_att+" not in attack range");}
    else{
    champoin_target=players[player_num.get(i)].get_champoins_list();
    
    int j=0;
    //System.out.println("for(j=1;j<=champoin_target");
    for(j=1;j<=champoin_target.size();j++){
    if(name_to_att.contains(champoin_target.get(j).get_name()))
    {break;}
    }
    double t=obj.get_str_damage();
    t=t/100;
    //System.out.println("aaaaaa8888"+obj.get_attack_damage()+(t*obj.get_attack_damage()));
    
    champoin_target.get(j).takedammage(obj.get_attack_damage()+(t*obj.get_attack_damage()));
    obj.increase_mena(1);
    obj.decrease_str_chance();
    //System.out.println("aaaaaaddd");
    players[player_num.get(i)].set_champoins_list(champoin_target);
    //System.out.println("hhhhhhhh");
    //champoin_target=players[player_num.get(i)].get_champoins_list();
    //System.out.println("hhhhhhhh1111111");
    //System.out.println("champoin_target+"+champoin_target.get(j).get_health());
    System.out.println(obj.get_name()+"do critical attacked to "+name_to_att+" !!");
    }
    }
    else{System.out.println(name_to_att+" not in attack range");}
    }
    
    
    
}
