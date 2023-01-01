/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game_c;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import player.player;
import rounds.round;
import store.permanent_store;

/**
 *
 * @author HP
 */
public class save implements Serializable {
      player []players;
      int player_num=0,round=0,time=0;
      int max_round;
      
      permanent_store s;
      
       int y;
      String a=".txt";
      String b="game";
      String filename=a+y+b;
      int number;
      int board_w;
      int board_h;
      int swap;
      int max_swap;
      int max_champoins;
      boolean []bots;
      String [][]btn_type;
      
       save(){}
      save(player []players,
      int player_num,int round,int time,
      int max_round,
      permanent_store s,
      int board_w,
      int board_h,
      int swap,
      int max_swap,
      
      boolean []bots,
      String [][]btn_type
      ){
      this.players=players;
      this.player_num=player_num;
      this.round=round;
      this.time=time;
      this.max_round=max_round;
      
       this.s=s;
      
      this.board_w=board_w;
      this.board_h=board_h;
      this.swap=swap;
      this.max_swap=max_swap;
      //this.max_champoins=max_champoins;
      this.bots=bots;
      this.btn_type=btn_type;
      }
      
      
/*      public void save_players( player [] players1)
      {
          for(int j=0;j<=players1.length;j++)
          {players[j]=players1[j];
          }
      String a="player";
String b=".txt";
          // {
           ObjectOutputStream out;
        try {  
            for(int i=0;i<=players.length;i++)
                    {
          out = new ObjectOutputStream(new FileOutputStream(a+i+b));
          out.writeObject(players[i]);}
        } catch (IOException ex) {
            Logger.getLogger(save.class.getName()).log(Level.SEVERE, null, ex);
        }
      
      }
      public void save_round( round my_round1) throws FileNotFoundException
      {  String a="round";
String b=".txt";
int i=0;
 ObjectOutputStream out;
         try {
             out = new ObjectOutputStream(new FileOutputStream(a+b));
             out.writeObject(my_round1);
         } catch (IOException ex) {
             Logger.getLogger(save.class.getName()).log(Level.SEVERE, null, ex);
      }   }
  */    
      
      /**
      public void save_date( int player_num1,int round1,int time1,int max_round1) throws FileNotFoundException
      { player_num=player_num1;
      round=round1;
      time=time1;
      max_round=max_round1;
     File b=new File("date.txt");
    PrintStream writer=new PrintStream(b);
      writer.println(player_num);
      writer.println(round);
      writer.println(time);
      writer.println(max_round);
      writer.close();
      }
      public void save_obj(save n,int numb)
      { number=numb;
          try {
          ObjectOutputStream out;
          
         
          out = new ObjectOutputStream(new FileOutputStream(a+number+b));
          out.writeObject(n);
          
        } catch (IOException ex) {
            Logger.getLogger(save.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
      public void save_game(round my_round1,save m,int player_num1,int round1,int time1,int max_round1, player [] players1,int numb1)
      {File e=new File(filename);
      m.max_round=max_round1;
       m.time=time1;
       m.round=round1;
       m.my_round=my_round1;
       m.players=  players1;
       m.number =numb1;
   //    m.save_players(players1);
      m.save_obj(m,numb1);
      
      }
 public   save load_game(int numb) throws FileNotFoundException, IOException, ClassNotFoundException
 {save temp=new save();
   ObjectInputStream out=null;
       number=numb;
            
            out = new  ObjectInputStream(new FileInputStream(a+number+b));
        temp =  (save) out.readObject();
           
 
     
     return temp;
 }
     **/ 
      
      
}
