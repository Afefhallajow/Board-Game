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
public class zed extends do_ability implements Serializable{

    public zed(Champoin obj, player this_player) {
        super(obj, this_player);
    
        buy_in_ability("Zed");
}
}