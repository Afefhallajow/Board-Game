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
public class universe_core extends item implements Serializable{

    public universe_core(Champoin c) {
        super(c,"Universe Core");
    }
public void do_item(){
    
       System.out.println("magic resist : "+c.get_magic());
        c.set_magic(c.get_magic()+c.get_magic()*0.2);
    
       System.out.println("after item : "+c.get_magic());
       c.set_extra_class("Elementalist");
}

}
