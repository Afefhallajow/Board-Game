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
public class night_shift extends item implements Serializable{

    public night_shift(Champoin c) {
        super(c,"Night Shift");
    }
public void do_item(){
    
    System.out.println("attack_damage"+c.get_attack_damage());
        c.set_attack_damage(c.get_attack_damage()+c.get_attack_damage()*0.2);
    
    System.out.println("after item : "+c.get_attack_damage());
    c.set_extra_class("Assassin");
}    
}
