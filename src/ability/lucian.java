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
public class lucian  extends do_ability implements Serializable{

    public lucian(Champoin obj, player this_player) {
        super(obj, this_player);
    
        obj.set_mov_speed(obj.get_mov_speed()+10);
        obj.set_attack_range(obj.get_attack_range()+10);
}
}
