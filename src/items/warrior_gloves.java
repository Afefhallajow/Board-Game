/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package items;

import champoins.Champoin;
import java.io.Serializable;
import player.player;

/**
 *
 * @author TOSHIBA
 */
public class warrior_gloves extends item implements Serializable{

    public warrior_gloves(Champoin c) {
        super(c,"Warrior Gloves");
    }

    public void do_item(){
    
        System.out.println("attack_damage : "+c.get_attack_damage());
        c.set_attack_damage(c.get_attack_damage()+c.get_attack_damage()*0.1);
    //    Champoin c=get_cham_with_class();
        System.out.println("after item : "+c.get_attack_damage());
        c.set_extra_class("BladeMaster");
    }
    
    
    
}
