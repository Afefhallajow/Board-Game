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
public class elementalist  extends do_ability implements Serializable{

    public elementalist( Champoin obj, player my_player) {
        super( obj, my_player);
    }
    
    
    
    public void do_it(){
    HashMap<Integer,String> name_class_champoins=my_player.get_name_class_champoins();
    HashMap<String,Integer> num_class_champoins=my_player.get_num_class_champoins();

    if(num_class_champoins.get("Elementalist")>=4){
    obj.set_mena(obj.get_mena()*2);
    my_player.increase_size_champ();
    
    System.out.print("double mena !!");
    }
    
    else if(num_class_champoins.get("Elementalist")>=2){
    obj.set_mena(obj.get_mena()*2);
    System.out.println("double mena !!");
    }
    
    
   

    //System.out.println("aaaaaaddd");
   // players[player_num.get(i)].set_champoins_list(champoin_target);
    
//System.out.println("champoin_target+"+champoin_target.get(j).get_health());
    //System.out.println(obj.get_name()+" do dragons ability to ");
    
     
    
    
    
    
    }
    
}