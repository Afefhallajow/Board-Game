
package ability;

import champoins.Champoin;
import java.io.Serializable;
import java.util.HashMap;
import player.player;


public class do_ability implements Serializable{
 Champoin obj;
 player this_player;
 
 do_ability(Champoin obj,player this_player){
 this.obj=obj;
 this.this_player=this_player;
 
 }
 
 void buy_in_ability(String name){
 
 Champoin c=new Champoin(name);
 c.set_name(name);
    int []pos=obj.get_pos();
    //System.out.println("pos0 ="+pos[0]+"pos1 ="+pos[1]);
    int t=pos[0];
    int t2=pos[1];
    pos[1]=t;
    //System.out.println("2pos0 ="+pos[0]+"pos1 ="+pos[1]);
    int []size=this_player.get_board_size();
    //System.out.println("size[0] ="+size[0]+"size[1]="+size[1]);
    
    if(t>size[0]){t=size[0]-1;}
    if(t2>size[1]){t2=size[1]-1;}
    //System.out.println("2pos0 ="+pos[0]+"pos1 ="+pos[1]);
    c.set_pos(t,t2);
    String []t3=new String[3];
    t3[0]=null;
    t3[1]=null;
    t3[2]=null;
    c.set_his_class(t3);
 if(this_player.maxchampon()){System.out.println("max champions");}

 else{
 HashMap<Integer,Champoin> temp=this_player.get_champoins_list();
 temp.put(temp.size()+1,c);
    this_player.set_champoins_list(temp);
 }
 }
}
