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
public class noble extends do_ability implements Serializable{

    public noble( Champoin obj, player my_player) {
        super( obj, my_player);
    }
    
    
    public void do_it(){
    HashMap<Integer,String> name_class_champoins=my_player.get_name_class_champoins();
    HashMap<String,Integer> num_class_champoins=my_player.get_num_class_champoins();

    if(num_class_champoins.get("Noble")>=3){
    obj.set_health(obj.get_health()+40);
    obj.set_armor(obj.get_armor()+20);
    
    System.out.println("grant "+obj.get_name()+" 20 armor and 40 health");}
    
    
    
    

    
    
    
    
    
    }
    
    
    
}
