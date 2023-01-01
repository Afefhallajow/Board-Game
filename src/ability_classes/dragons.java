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
public class dragons extends do_ability implements Serializable{

    public dragons(Champoin obj, player my_player) {
        super(obj, my_player);
    }
    
    
    
    public void do_it(){
    HashMap<Integer,String> name_class_champoins=my_player.get_name_class_champoins();
    HashMap<String,Integer> num_class_champoins=my_player.get_num_class_champoins();

    if(num_class_champoins.get("Dragon")>=2){
    obj.protection();
    System.out.println("it's immune to ability");
    
    }
    
    
    
    }
    
    
    
}
