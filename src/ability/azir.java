/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ability;

import champoins.Champoin;
import java.io.Serializable;
import player.player;
import rounds.planning;

/**
 *
 * @author TOSHIBA
 */
public class azir extends do_ability implements Serializable{

    public azir(Champoin obj, player this_player) {
        super(obj, this_player);
    
        buy_in_ability("Azir");
        buy_in_ability("Azir");
    }
    
    
    
    
    
}
