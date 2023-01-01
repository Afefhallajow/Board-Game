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
public class knight_armor extends item implements Serializable{

    public knight_armor(Champoin c) {
        super(c,"Knight Armor");
    }
public void do_item(){
    
       System.out.println("first armor : "+c.get_armor());
        c.set_armor(c.get_armor()+c.get_armor()*0.15);
    
   System.out.println("after item :"+c.get_armor());
   c.set_extra_class("Knight");
}    
}
