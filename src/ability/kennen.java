/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ability;

import champoins.Champoin;
import java.io.Serializable;
import player.player;

/**
 *
 * @author TOSHIBA
 */
public class kennen extends do_ability implements Serializable{

    public kennen(Champoin obj, player this_player) {
        super(obj, this_player);
    
        obj.set_attack_damage(obj.get_attack_damage()*0.35);
        //obj.set_attack_range(obj.get_attack_range()+10);
}
}
