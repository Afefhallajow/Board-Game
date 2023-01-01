/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ability;

import attack.normal_attack;
import champoins.Champoin;
import java.io.Serializable;
import java.util.HashMap;
import player.player;

/**
 *
 * @author TOSHIBA
 */
public class aatrox extends do_ability implements Serializable{

    public aatrox(Champoin obj, player this_player,player []players) {
        super(obj, this_player);
    
        String temp;
        Champoin c=obj;
        int t_r=obj.get_attack_range();
        double t_a=obj.get_attack_damage();
        c.set_attack_range(25);
        c.set_attack_damage(250);
        new normal_attack(c,players,this_player);
        HashMap <Integer,Champoin>enemy=c.get_enemy_to_att();
        if(!enemy.isEmpty()){
        for(int i=0;i<enemy.size();i++){
        if(!enemy.get(i).check_protection()){
        temp=enemy.get(i).get_name();
        if(temp!=null){
        new normal_attack(c,players,this_player).do_normal_attact(temp);
        
        }
        }
        else{System.out.println(enemy.get(i).get_name()+" is protected from ability");}
        }
        
            
            
            
            }
        obj.set_attack_range(t_r);
        obj.set_attack_damage(t_a);
        
        //System.out.println("obj attack"+obj.get_attack_damage());
    }
}