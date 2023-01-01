/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package champoins;

import ability.*;
//import ability.azir;
import ability_classes.*;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import attack.*;
import java.io.Serializable;
import player.player;
/**
 *
 * @author TOSHIBA
 */
public class champoin_action implements Runnable,Serializable{

    
    
    player []players;
    int []pos_att=new int[2];
    Champoin obj;
    String h1;
    int g=0;
    player this_player;
    int []board_size=new int[2];
    String [][]btn_type;
    
    public  champoin_action(String h1,Champoin obj,player []players,player this_player,String [][]btn_type){
    this.players=players;
    this.h1=h1;
    this.obj=obj;
    this.this_player=this_player;
    this.btn_type=btn_type;
    
    }
    

    public void begin(){
        g++;
  //     System.out.println("here!!!"+h1);
       int i=0;
      // obj.set_mov_speed(2);
       //System.out.println("here!!!");
        
       
//       System.out.println("here!!!pppppp"); 
       i++;
        
        if(h1.contains("move")){
        
        board_size=this_player.get_board_size();
   
        boolean terrain=false;
        int water=1;
       int []pos=obj.get_pos();
        if(h1.contains("left"))
         {
             System.out.print(" move left !!");
             int y;
             System.out.println("pos[1]-1"+(pos[1]-1));
             System.out.println("pos[1]-2*obj.get_mov_speed()"+(pos[1]-2*obj.get_mov_speed()));
             if((pos[1]-2*obj.get_mov_speed())>0){
             for(y=pos[1]-1;y>=pos[1]-2*obj.get_mov_speed();y--){
             
                 System.out.println("here!!!");
                 if(btn_type[pos[0]][y]!=null)
             if(btn_type[pos[0]][y].contains("Terrain")){
                 //System.out.println("here!!!ttttttt");
                 terrain=true;break;}
             else if(btn_type[pos[0]][y].contains("Water")){water++;}
             }}
             else{
             for(y=pos[1]-1;y>=0;y--){
             
                // System.out.println("here!!!");
                 if(btn_type[pos[0]][y]!=null)
             if(btn_type[pos[0]][y].contains("Terrain")){
              //   System.out.println("here!!!ttttttt");
                 terrain=true;break;}
             else if(btn_type[pos[0]][y].contains("Water")){water++;}
             }
             }
             
             
             
             if(terrain){
             obj.set_pos((pos[0]),y+1);
                System.out.println("not possible to move throw Terrain !!");
                 return;
             }
             else{
             if(pos[1]-(2*obj.get_mov_speed())>=0)
             {
                 if(water>1){System.out.println("there is "+ water+" water seq !!");}
                 obj.set_pos((pos[0]),pos[1]-(2*obj.get_mov_speed()/water));
             }else{
             obj.set_pos((pos[0]),0);
             }
         }
             
         }
        else if(h1.contains("right"))
        {
        
            System.out.print(" move right !!");
            int y;
             for(y=pos[1]+1;y<=pos[1]+2*obj.get_mov_speed();y++){
             if(btn_type[pos[0]][y]!=null)
             if(btn_type[pos[0]][y].contains("Terrain")){terrain=true;break;}
             else if(btn_type[pos[0]][y].contains("Water")){water++;}
             }
             if(terrain){
             obj.set_pos((pos[0]),y-1);
                System.out.println("not possible to move throw Terrain !!");
                 return;
             }
             else{
             
            
            if(pos[1]+(2*obj.get_mov_speed())<=(board_size[1]-1))
            {
                if(water>1){System.out.println("there is "+ water+" water seq !!");}
                 
                obj.set_pos((pos[0]),pos[1]+(2*obj.get_mov_speed()/water));
            }
            else{obj.set_pos((pos[0]),(board_size[1]-1));}
        
            }
        }
            else if(h1.contains("up"))
            {
                System.out.print(" move up !!");
            int y;
            if(pos[0]-2*obj.get_mov_speed()>0){ 
            for(y=pos[0]-1;y>=pos[0]-2*obj.get_mov_speed();y--){
             if(btn_type[y][pos[1]]!=null)
             if(btn_type[y][pos[1]].contains("Terrain")){terrain=true;break;}
             else if(btn_type[y][pos[1]].contains("Water")){water++;}
             }
            }
            else{
              
             for(y=pos[0]-1;y>=0;y--){
             if(btn_type[y][pos[1]]!=null)
             if(btn_type[y][pos[1]].contains("Terrain")){terrain=true;break;}
             else if(btn_type[y][pos[1]].contains("Water")){water++;}
             }
            
            }
             if(terrain){
             obj.set_pos(y+1,(pos[1]));
                System.out.println("not possible to move throw Terrain !!");
                 return;
             }
             else{
             
            if(pos[0]-(2*obj.get_mov_speed())>=0)
            {
                if(water>1){System.out.println("there is "+ water+" water seq !!");}
                
                obj.set_pos((pos[0]-(2*obj.get_mov_speed())/water),pos[1]);
             }else{obj.set_pos(0,pos[1]);}
        
             }
            
            }
        else if(h1.contains("down"))
        {
            System.out.print(" move down !!");
            int y;
             for(y=pos[0]+1;y<=pos[0]+2*obj.get_mov_speed();y++){
             if(btn_type[y][pos[1]]!=null)
             if(btn_type[y][pos[1]].contains("Terrain")){terrain=true;break;}
             else if(btn_type[y][pos[1]].contains("Water")){water++;}
             }
             if(terrain){
                obj.set_pos(y-1,(pos[1]));
                System.out.println("not possible to move throw Terrain !!");
                 return;
             }
             else{
            
            
            if(pos[0]+(2*obj.get_mov_speed())<=(board_size[0]-1))
            {
                if(water>1){System.out.println("there is "+ water+" water seq !!");}
                
                obj.set_pos((pos[0]+(2*obj.get_mov_speed())/water),pos[1]);
            }else{obj.set_pos((board_size[0]-1),pos[1]);
            } 
             }
        }
        
        
        } else if(h1.contains("attack")) 
        {
            System.out.print(" attack !!");
            String sub=h1.substring(7);
            int extra_att=obj.get_extra_attack();
            if(extra_att==0)
            (new normal_attack(obj,players,this_player)).do_normal_attact(sub);
            else{
             System.out.println("you have"+(extra_att)+" extra attack !!");
            while(extra_att>=0){
            
                (new normal_attack(obj,players,this_player)).do_normal_attact(sub);
            extra_att--;
            }
            }
            


//HashMap <Integer,Champoin>enemy=obj.get_enemy_to_att();
     /**
            int []num_pos=new int[2];
            Champoin c =new Champoin();
            c.set_name("akali");
            enemy.put(0, c);
             
            for(i=0;i<enemy.size();i++)
            {
                     
                if(enemy.get(i).get_name().equals(sub)){
            
                enemy.get(i).takedammage(obj.get_attack_damage());
                 System.out.println(sub+" gets damage !! ");
                Thread.currentThread().stop();}
            }
            System.out.println("enemy not in range !! ");
        **/    
        }
        else if(h1.contains("Critical strike")) 
        {
        
            String sub=h1.substring(7);
            (new Critical_strike(obj,players,this_player)).do_Critical_strike(sub);
            
        }
        else if(h1.contains("do Ability")) 
        {

            if(obj.get_name().contains("Aatrox"))
            new aatrox(obj,this_player,players);
        
            else if(obj.get_name().contains("Azir"))
            new azir(obj,this_player);
            
            else if(obj.get_name().contains("Kennen"))
            new kennen(obj,this_player);
        
            else if(obj.get_name().contains("Lucian"))
            new lucian(obj,this_player);
        
            else if(obj.get_name().contains("Zed"))
            new zed(obj,this_player);
        
        }
        
        
        }

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

        
    
    
    
    
    
    
}
