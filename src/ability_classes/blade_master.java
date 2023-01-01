
package ability_classes;

import champoins.Champoin;
import java.io.Serializable;
import java.util.HashMap;
import player.player;

/**
 *
 * @author TOSHIBA
 */
public class blade_master extends do_ability implements Serializable{

    public blade_master(Champoin obj, player my_player) {
        super(obj, my_player);
    }
    
    
    public void do_it(){
    HashMap<Integer,String> name_class_champoins=my_player.get_name_class_champoins();
    HashMap<String,Integer> num_class_champoins=my_player.get_num_class_champoins();

    if(num_class_champoins.get("BladeMaster")==3){
    obj.set_extra_attack(1);
    System.out.println("you will have 1 extra attack");
    
    }
    else if(num_class_champoins.get("BladeMaster")==6){
        obj.set_extra_attack(2); 
        System.out.println("you will have 2 extra attack");
    
    }
    else if(num_class_champoins.get("BladeMaster")==9){
        obj.set_extra_attack(4); 
        System.out.println("you will have 4 extra attack");
         
    }
    
    
    }
    
    
}
