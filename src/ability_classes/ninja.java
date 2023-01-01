/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ability_classes;

import champoins.Champoin;
import java.io.Serializable;
import java.util.HashMap;
import player.player;

/**
 *
 * @author TOSHIBA
 */
public class ninja extends do_ability implements Serializable{

    public ninja( Champoin obj, player my_player) {
        super(obj, my_player);
    }
    
    
    
    public void do_it(){
    HashMap<Integer,String> name_class_champoins=my_player.get_name_class_champoins();
    HashMap<String,Integer> num_class_champoins=my_player.get_num_class_champoins();

    if(num_class_champoins.get("Ninja")==5){
    obj.new_str_chance(75);
    obj.new_str_damage(300);
    System.out.println("grant critical chance 75% and critical damage 300%");
    
    }
            
    else if(num_class_champoins.get("Ninja")>=1){
    obj.new_str_chance(50);
    obj.new_str_damage(200);
    System.out.println("grant critical chance 50% and critical damage 200%");
    
    }
    
    
   
    
    
    
    
    }
    
    
    
}
