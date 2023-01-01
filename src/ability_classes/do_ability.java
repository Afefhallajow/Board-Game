
package ability_classes;

import attack.normal_attack;
import champoins.Champoin;
import java.io.Serializable;
import player.player;


public class do_ability implements Serializable{
    player my_player;
    Champoin obj;
//    player []players;
    do_ability(Champoin obj,player my_player){
  //  this.players=players;
    this.my_player=my_player;
    this.obj=obj;
    //new normal_attack(obj,players,my_player);
    }
    
    
    
}
