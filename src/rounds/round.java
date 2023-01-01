/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rounds;

//import java.util.TimerTask;
import store.permanent_store;
//import main_game.player;
import champoins.*;
import player.*;
/**
 *
 * @author TOSHIBA
 */
public abstract class round {
    player obj=new player();
    permanent_store s=new permanent_store();
    String name;
    round(player obj,permanent_store s,String name){
    this.obj=obj;
    this.s=s;
    this.name=name;}

    void do_round(){};
            }

