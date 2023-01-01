
package rounds;

//import main_game.player;

import ability_classes.*;
//import java.util.Scanner;
import store.permanent_store;
import champoins.*;
import java.util.HashMap;
import player.*;
import store.*;

/**
 *
 * @author TOSHIBA
 */
public class planning extends round {
  //      Scanner reader=new Scanner(System.in);

    public planning(player obj,permanent_store s,String name)
    {
        
        //System.out.println("ffdddddddddddffffff");
        super(obj,s,name);
    //System.out.println("123name : "+name);
    }
    
    
   
    public void begin() {
    int j=0;
        try{
    boolean a=true;
            //obj.increase_coins();
            /**if(obj.get_num_champ() >1 && obj.get_num_bench_champ()>1)
            {if(obj.need_switch()){
     
                obj.swap();
            };
            }
            else{System.out.println("can't swap here !! ");
                    }**/
            //System.out.println("123name : "+name);
               // String champ=s.print();
          // l:while(a){
               
               Champoin c=s.buy(name,obj.get_coins());
                //go to shop and put return in class champoin
            /**if(obj.max_game_champon() && !obj.max_bench_champon())
            {
                System.out.println("no space in game .you have put it in bench");
                obj.add_bench_champoin(c);}
            else if(obj.max_bench_champon() && !obj.max_game_champon())
            {
            
                System.out.println("no space in bench .you have put it in game");    
                obj.take_pos(c);//champ is par
                obj.add_champoin(c);//champ is par
            
            }**/
              if(can_increase_bench(c))
                  {
                   //System.out.println("here");
                   obj.increase_champ_bench_level(c.get_name());
                   System.out.println(c.get_name()+" have new level in bench");
                   obj.set_coins(c.get_price());
                   //System.out.println("hhh555555");
                   HashMap<Integer,Champoin> champoins_list=obj.get_bench_list();
                   //System.out.println("hhh66666666");
                   Champoin q=champoins_list.get(1);
                   //System.out.println("get_level()"+q.get_level());
                  }
              else if(can_increase_champ(c)){
              obj.increase_champ_level(c.get_name());
              obj.set_coins(c.get_price());
              System.out.println(c.get_name()+" have new level in arena");        
              }
              else if(max_level(c)){
              System.out.println("max leval !! can't buy");
              }
               else{
            if(obj.maxchampon()){System.out.println("max champions ..pls sell first");}
            else{
            if(obj.max_bench_champon()){
            System.out.println("no space in bench .pls swap first");}
            else{
                if(c!=null){
                obj.add_bench_champoin(c);
                obj.set_coins(c.get_price());
                }
            /**if(obj.isbench()){
              obj.add_bench_champoin(c);
            }
            else{
            obj.take_pos(c);//champ is par
           
            obj.add_champoin(c);//champ is par
            
            
            }**/
            }}
            
            /**if(obj.maxchampon()){
            a=false;
            System.out.println("max champoins\n pls wait ....");
            }
            **/
            if(obj.nocoins()){
            
            System.out.println("no coins \n pls wait another round....");
//                break l;
            }
            /**
           System.out.println("you need buy new champoin ?? n/y");
        //flash();
        String ch;
        ch=reader.nextLine();
    //int h=reader.nextInt();
    //System.out.println("bbbb"+c);
        if(ch.equals("y")){
    //champ=s.get_cham_temp_num();
               }
        
            else{System.out.println("please wait until the end of round....");
             break l;
            
            
            }**/
           // }
               }
    } catch(Exception e) {
        //Thread.currentThread().stop();
        System.out.println("nn");
    Thread.currentThread().interrupt();
    }  
        }
    
    
    
    
    boolean can_increase_champ(Champoin c){
    HashMap<Integer,Champoin> champoins_temp=obj.get_champoins_list();    
    for(int i=1;i<=champoins_temp.size();i++){
    if((champoins_temp.get(i).get_name()).equals(c.get_name()))
    {if(champoins_temp.get(i).get_level()<3)
            return true;}
    
    }
    return false;
    
    }
    
    
    boolean can_increase_bench(Champoin c){
    HashMap<Integer,Champoin> champoins_temp=obj.get_bench_list();    
    //System.out.println("c");
    for(int i=1;i<=champoins_temp.size();i++){
    System.out.println("champoins_temp.size()"+champoins_temp.size());
        if((champoins_temp.get(i).get_name()).equals(c.get_name()))
    {    if(champoins_temp.get(i).get_level()<3)
            return true;}
    
    }
    return false;
    
    }
    
    boolean max_level(Champoin c){
    HashMap<Integer,Champoin> champoins_temp=obj.get_champoins_list();
    HashMap<Integer,Champoin> bench_temp=obj.get_bench_list();
    for(int i=1;i<=champoins_temp.size();i++){
    if((champoins_temp.get(i).get_name()).equals(c.get_name()))
    {
        if(champoins_temp.get(i).get_level()==3)
        return true;}
    
    }
    for(int i=1;i<=bench_temp.size();i++){
    if((bench_temp.get(i).get_name()).equals(c.get_name()))
    {
        if(bench_temp.get(i).get_level()==3)
        return true;}
    
    }
    
    return false;
    
    }
    
    public void sell_champ(String s1){
    s.sell(s1);
    obj.return_items_from_bench_by_name(s1);
    obj.delete_from_bench(s1);
    System.out.print("it's selled");
    }
    
    
    

    




/**
//inner
    class check_ability_class{
    
    check_ability_class(){
        String temp;
    for(int i=0;i<obj.name_class_champoins.size();i++){
    System.out.println("asdasd1111");
        temp=obj.name_class_champoins.get(i);
         HashMap<Integer,Champoin> champoins_list;
        if(obj.num_class_champoins.get(temp)>=2){
        System.out.println("obj.num_class_champoins.get(temp)"+obj.num_class_champoins.get(temp));
        System.out.println("temp "+temp);
            if(temp.contains("BladeMaster")){
        champoins_list=obj.get_champoins_list();
        for(int j=1;j<=champoins_list.size();j++){
        for(int k=0;k<3;k++){
         if(champoins_list.get(j).get_his_class()[k]!=null){
         if(champoins_list.get(j).get_his_class()[k].contains("BladeMaster")){
        new blade_master(champoins_list.get(j),obj).do_it();
        }}
        }
        
        }
        obj.set_champoins_list(champoins_list);
        }
        else if(temp.contains("Brawler")){
        
            champoins_list=obj.get_champoins_list();
        for(int j=1;j<=champoins_list.size();j++){
        for(int k=0;k<3;k++){
         if(champoins_list.get(j).get_his_class()[k]!=null){
         if(champoins_list.get(j).get_his_class()[k].contains("Brawler")){
        new brawler(champoins_list.get(j),obj).do_it();
        }}
        }
        
        }
        obj.set_champoins_list(champoins_list);
        
        }
        
        else if(temp.contains("Dragon")){
        
            
                champoins_list=obj.get_champoins_list();
        for(int j=1;j<=champoins_list.size();j++){
        for(int k=0;k<3;k++){
         if(champoins_list.get(j).get_his_class()[k]!=null){
         if(champoins_list.get(j).get_his_class()[k].contains("Dragon")){
        new dragons(champoins_list.get(j),obj).do_it();
        }}
        }
        
        }
        obj.set_champoins_list(champoins_list);
        
        
        
        }
        else if(temp.contains("Elementalist")){
        
                champoins_list=obj.get_champoins_list();
        for(int j=1;j<=champoins_list.size();j++){
        for(int k=0;k<3;k++){
         if(champoins_list.get(j).get_his_class()[k]!=null){
         if(champoins_list.get(j).get_his_class()[k].contains("Elementalist")){
        new elementalist(champoins_list.get(j),obj).do_it();
        }}
        }
        
        }
        obj.set_champoins_list(champoins_list);
        
        
        }
        else if(temp.contains("Ninja")){
        
        
                champoins_list=obj.get_champoins_list();
        for(int j=1;j<=champoins_list.size();j++){
        for(int k=0;k<3;k++){
         if(champoins_list.get(j).get_his_class()[k]!=null){
         if(champoins_list.get(j).get_his_class()[k].contains("Ninja")){
        new ninja(champoins_list.get(j),obj).do_it();
        }}
        }
        
        }
        obj.set_champoins_list(champoins_list);
        
        
        }
        else if(temp.contains("Noble")){
        
            
                champoins_list=obj.get_champoins_list();
        for(int j=1;j<=champoins_list.size();j++){
        for(int k=0;k<3;k++){
         if(champoins_list.get(j).get_his_class()[k]!=null){
         if(champoins_list.get(j).get_his_class()[k].contains("Noble")){
        new noble(champoins_list.get(j),obj).do_it();
        }}
        }
        
        }
        obj.set_champoins_list(champoins_list);
        
        
        
        }
        else if(temp.contains("Pirate")){
        
            
                champoins_list=obj.get_champoins_list();
        for(int j=1;j<=champoins_list.size();j++){
        for(int k=0;k<3;k++){
         if(champoins_list.get(j).get_his_class()[k]!=null){
         if(champoins_list.get(j).get_his_class()[k].contains("Pirate")){
        new pirate(champoins_list.get(j),obj).do_it();
        }}
        }
        
        }
        obj.set_champoins_list(champoins_list);
        
        }
        
        }
    
    }
    }
    
    }

**/



}
