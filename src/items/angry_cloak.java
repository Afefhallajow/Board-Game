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
public class angry_cloak extends item implements Serializable{

    public angry_cloak(Champoin c) {
        super(c,"Angry cloak");
    }

    public void do_item(){
    
        System.out.println("first str_damage "+c.get_str_damage());
        c.set_str_damage(c.get_str_damage()+c.get_str_damage()*0.1);
    
        System.out.println("after wearer : "+c.get_str_damage());
        
        c.set_extra_class("Yordle");
    }
}
