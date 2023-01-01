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
public class brawler extends do_ability implements Serializable{

    public brawler(Champoin obj, player my_player) {
        super( obj, my_player);
    }
    
    
    
    public void do_it(){
    HashMap<Integer,String> name_class_champoins=my_player.get_name_class_champoins();
    HashMap<String,Integer> num_class_champoins=my_player.get_num_class_champoins();

    if(num_class_champoins.get("Brawler")>=6){
    obj.set_health(obj.get_health()+1000);
    System.out.println("grant health by 1000");
    
    }
    
    else if(num_class_champoins.get("Brawler")>=4){
    obj.set_health(obj.get_health()+500);
    System.out.println("grant health by 500");
    
    }
    
    else if(num_class_champoins.get("Brawler")>=2){
    obj.set_health(obj.get_health()+250);
    System.out.println("grant health by 250");
    
    }
    
    
    
    
    
    
    }
    
    
    
}

