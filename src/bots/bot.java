/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bots;
import attack.do_attack;
import champoins.Champoin;
import java.util.HashMap;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import player.*;
import rounds.planning;
import store.*;
/**
 *
 * @author TOSHIBA
 */
public class bot implements Runnable {
    
    player bot_player=new player();
    int round_num;
    permanent_store s;
    HashMap<Integer,String> list_store;
    player []players;
    
    public bot(int round_num,permanent_store s,HashMap<Integer,String> list_store,player []players)
    {this.round_num=round_num;
    this.s=s;
    this.list_store=list_store;
    this.players=players;
    }
    
    
    public void set_player(player bot_player){
    this.bot_player=bot_player;
    }
    
    public player get_player(){
    return bot_player;}
    
    
    void buy_from_store(){
        int k;
        Random r=new Random();
        k=r.nextInt(5);
        if(k==0){k++;}
        //k=0;
        //System.out.println("dddd"+k);
        Champoin c=new Champoin(list_store.get(k));
        c.set_name(list_store.get(k));
        //System.out.println("dddd"+list_store.get(k));
    //c.set_price(1);
    if(s.chack_price(c,bot_player.get_coins())){
        //System.out.println("ddddbbbbbb");
        (new planning(bot_player,s,list_store.get(k))).begin();
    
        
        }
        
    
    }
    /**
    void buy_in_bot(permanent_store s,String s1){
    //System.out.println("22222s= "+s1);
    Champoin c=s.buy(s1,bot_player.get_coins());
    
    if(c!=null){
    add_champoin(c);
    bot_player.set_coins(c.get_price());
    }
    
    }
    
    void add_champoin(Champoin c){
    bot_player.add_bench_champoin(c);
    
    }
    **/
    void call_swap(){

         
        try {
            Thread.sleep(2000);
        }
        catch (InterruptedException ex) {
            
        }
       
        int i,x,y;
        Random r=new Random();
        HashMap<Integer,Champoin> bench_list=bot_player.get_bench_list();
        if(!bench_list.isEmpty()){
        if(bench_list.size()==1){
        i=1;}
        else{i=r.nextInt(bench_list.size()-1);
        if(i==0)i=1;}
      //  System.out.println("1111i="+i);
        int []size=new int[2];
        size=bot_player.get_board_size();
        if((size[0]-1)!=0){
        x=r.nextInt(size[0]-1);}
        else{x=0;}
        if((size[1]-1)!=0){
        y=r.nextInt(size[1]-1);}
        else{y=0;}
        HashMap<Integer,Champoin> champoins_list=bot_player.get_champoins_list();
        if(!champoins_list.isEmpty()){
        for(int j=1;j<=champoins_list.size();j++){
        int []pos=champoins_list.get(j).get_pos();
            if(pos[0]==x &&pos[1]==y){
            swap_bot(bench_list.get(i).get_name(),champoins_list.get(j).get_name(),x,y);
            return;}
        }
        swap_bot(bench_list.get(i).get_name(),"",x,y);
        }
        else{swap_bot(bench_list.get(1).get_name(),"",x,y);}
        
        
        
        }//is empty
    
    }
    
    void call_swap_cham(){
    
        Random r=new Random();
        HashMap<Integer,Champoin> bench_list=bot_player.get_bench_list();
        HashMap<Integer,Champoin> champoins_list=bot_player.get_champoins_list();
        int i,j;
        if(!bench_list.isEmpty()&&!champoins_list.isEmpty()){
        if(bench_list.size()==1){
        i=1;}
        else{i=r.nextInt(bench_list.size());}
    
        if(champoins_list.size()==1){
        j=1;}
        else{j=r.nextInt(champoins_list.size());}
        int []pos=new int [2];
        pos=champoins_list.get(j).get_pos();
        swap_bot(bench_list.get(i).get_name(),champoins_list.get(j).get_name(),pos[0],pos[1]);
           
        }
    }
    
    
    void swap_bot(String ch_bench,String ch_arena,int x,int y){
        
        
        bot_player.swap(round_num,ch_bench, ch_arena, x, y,null);
    
    }
    
    void take_move_order_random(){
    
        if(round_num>=9){
        
            try {
            Thread.sleep(2000);
        }
        catch (InterruptedException ex) {
            
        }
            int j,k;
        String []s=new String[4];
        s[0]="move to left";
        s[1]="move to right";
        s[2]="move to up";
        s[3]= "move to down";       
        Random r=new Random();
        HashMap<Integer,Champoin> champoins_list=bot_player.get_champoins_list();
        if(!champoins_list.isEmpty()){
        if(champoins_list.size()==1){
        j=1;}
        
        else{
            //System.out.println("champoins_list.size()"+champoins_list.size());
            j=r.nextInt(champoins_list.size()-1);}
        if(j==0){j=1;}
        k=r.nextInt(3);
        //System.out.println("222take_move_order j= "+j+"k="+k+" champoins_list.get(j).get_name()");
        bot_player.take_order(champoins_list.get(j).get_name(),s[k]);
        System.out.println("take_move_order "+s[k]);
        }
        }
    }

    
    
    void take_att_order_random(){
    
        if(round_num>=9){
        try {
            Thread.sleep(2000);
        }
        catch (InterruptedException ex) {
            
        }
            int j,k;
        
        Random r=new Random();
        HashMap<Integer,Champoin> champoins_list=bot_player.get_champoins_list();
        if(!champoins_list.isEmpty()){
        if(champoins_list.size()==1){
        j=1;}
        else{j=r.nextInt(champoins_list.size()-1);}
        //k=r.nextInt(3);
        if(j==0){j=1;}
        //System.out.println("bnmqqqbnm "+j);
        new do_attack(champoins_list.get(j),players,bot_player);
        HashMap<Integer,Champoin> en_list=champoins_list.get(j).get_enemy_to_att();
        
        if(en_list!=null){
        if(!en_list.isEmpty()){
            //System.out.println("bnm111bnm"+en_list.size());
        if(en_list.size()==1){
        k=0;}
        else{k=r.nextInt(en_list.size()-1);}
        //System.out.println("bnm111bnm"+k);
        String s1=en_list.get(k).get_name();
        bot_player.take_order(champoins_list.get(j).get_name()," attack "+s1);
        //System.out.println("take_attack_order"+s1);
        }
        }
        
//    bot_player.take_order(champoins_list.get(j).get_name(),s[k]);
        
        }
        }
    
    }
    
    
    
    
    
    @Override
    public void run() {
    
        
        
        try {
            Thread.sleep(2000);
        }
        catch (InterruptedException ex) {
            
        }
        
        Random r=new Random();
        for(int i=0;i<2;i++){
        buy_from_store();
             try {
            Thread.sleep(2000);
        }
        catch (InterruptedException ex) {
            
        }
   
        
        call_swap();
        }
        take_move_order_random();
        
        int k=r.nextInt(4);
        if(k<=3){buy_from_store();
        if(k<=2){
            
        call_swap();}}
        
        for(int j=0;j<9;j++){
        if(j%2==0)take_att_order_random();
        else take_move_order_random();      
        
        }
        
        for(int i=0;i<2;i++){
        
        
        k=r.nextInt(5);
        
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
        
        }
        
        
        if(k==1){
        take_move_order_random();      
        }        
//
        if(k==0&&k==2&&k==3){
        take_att_order_random();
        }
        if(k==4){buy_from_store();
        }
        
    }
    
    
    }
}
