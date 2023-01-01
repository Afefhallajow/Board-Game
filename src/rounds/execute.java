/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rounds;

//import main_game.player;

import store.permanent_store;
import champoins.*;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import player.*;



public class execute 
{

    public execute(player []players,String [][]btn_type) {
          ExecutorService executor = Executors.newCachedThreadPool();  
 
        Random r=new Random();
          
        int []t_i=new int[8];
           t_i[0]=r.nextInt(players.length);
        
           for(int j=1;j<players.length;j++){
           t_i[j]=r.nextInt(players.length);
           
           for(int u=0;u<j;u++){
           
               if(t_i[j]==t_i[u]){
           j--;
           break;
           }
           }
           
           }
           
        for(int i=0;i<players.length;i++)
                    {
                        if(players[t_i[i]]!=null)
                        {
           
        System.out.println("player "+((t_i[i])+1)+" execute ");
           
        
        executor.execute(new do_order(players, t_i[i],btn_type));
     //   players[t_i[i]].remove_order();
                        
    }


    
    
    
    
    
        }
    
    executor.shutdown();
        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException ex) {
            Logger.getLogger(execute.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        for(int i=0;i<players.length;i++)
                    {
                        if(players[t_i[i]]!=null)
                        {
     
                            players[t_i[i]].remove_order();
                        
                        }
                        
                    }
        
    }
    
}