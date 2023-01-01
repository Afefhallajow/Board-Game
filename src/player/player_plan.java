
package player;

import java.io.Serializable;
import java.util.HashMap;
//import java.util.Scanner;


public class player_plan implements Serializable{

  //  Scanner reader=new Scanner(System.in);
    protected HashMap<Integer,String> order_list=new HashMap<Integer,String>();
    player_plan(HashMap order_list){this.order_list=order_list;}
    
    
    HashMap take_plan(String order){
    
        String temp;
        int j;
        
       
        order_list.put((order_list.size()+1), order);
        
        
        
        //order_list.put(j, temp);
    
        return order_list; 
    
    }
    
    HashMap take_plan_name(String name){
    //System.out.println("order_list.size()+1"+(order_list.size()+1)+"name"+name);    
    order_list.put((order_list.size()+1), name);
    return order_list;
    }
    
}
