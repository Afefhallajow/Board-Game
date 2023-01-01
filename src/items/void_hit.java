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
public class void_hit extends item implements Serializable{

    public void_hit(Champoin c) {
        super(c,"Void Hit");
    }

    public void do_item(){
    
       System.out.println("health : "+c.get_health());
        c.set_health(c.get_health()+c.get_health()*0.05);
    
       System.out.println("after item : "+c.get_health());
       
       c.set_extra_class("Void");
    }
    
 }
