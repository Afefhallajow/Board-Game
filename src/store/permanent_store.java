/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store;

import java.util.HashMap;
import java.util.Random;
//import java.util.Scanner;
import champoins.Champoin;
import java.io.Serializable;
//import main_game.Champoin;

/**
 *
 * @author TOSHIBA
 */
public class permanent_store implements Serializable{
  //  Scanner reader=new Scanner(System.in);
    
    protected HashMap<Integer,String> champoins_list_store=new HashMap<Integer,String>();
    protected int []size_cham=new int[49];
    int []temp=new int[5];
    boolean []if_buy=new boolean[5];
    HashMap<Integer,String> h1=new HashMap<Integer,String>();
  public HashMap get_h1(){
        System.out.println("h1="+h1.get(1));
        return h1;}   
    public permanent_store(){
    champoins_list_store.put(1, "Aatrox");
    champoins_list_store.put(2, "Ahri");
    champoins_list_store.put(3, "Akali");
    champoins_list_store.put(4, "Anivia");
    champoins_list_store.put(5, "Ashe");
    champoins_list_store.put(6, "Brand");
    champoins_list_store.put(7, "Chogath");
    champoins_list_store.put(8, "Darius");
    champoins_list_store.put(9, "Draven");
    champoins_list_store.put(10, "Evelynn");
    champoins_list_store.put(11, "Fiora");
    champoins_list_store.put(12, "Gankplank");
    champoins_list_store.put(13, "Garen");
    champoins_list_store.put(14, "Gnar");
    champoins_list_store.put(15, "Graves");
    champoins_list_store.put(16, "Karthus");
    champoins_list_store.put(17, "Kassadin");
    champoins_list_store.put(18, "Katarina");
    champoins_list_store.put(19, "Kayle");
    champoins_list_store.put(20, "Kennen");
    champoins_list_store.put(21, "Khazix");
    champoins_list_store.put(22, "Kindred");
    champoins_list_store.put(23, "Leona");
    champoins_list_store.put(24, "Lissandra");
    champoins_list_store.put(25, "Lucian");
    champoins_list_store.put(26, "Lulu");
    champoins_list_store.put(27, "MissFortune");
    champoins_list_store.put(28, "Mordekaiser");
    champoins_list_store.put(29, "Morgana");
    champoins_list_store.put(30, "Nidale");
    champoins_list_store.put(31, "Poppy");
    champoins_list_store.put(32, "Pyke");
    champoins_list_store.put(33, "Ranger");
    champoins_list_store.put(34, "Sejuani");
    champoins_list_store.put(35, "Shen");
    champoins_list_store.put(36, "Shyvana");
    champoins_list_store.put(37, "Sol");
    champoins_list_store.put(38, "Swain");
    champoins_list_store.put(39, "Talon");
    champoins_list_store.put(40, "Tristana");
    champoins_list_store.put(41, "Varus");
    champoins_list_store.put(42, "Vayne");
    champoins_list_store.put(43, "Veiger");
    champoins_list_store.put(44, "Volibear");
    champoins_list_store.put(45, "Warwick");
    champoins_list_store.put(46, "Yasuo");
    champoins_list_store.put(47, "Zed");
    champoins_list_store.put(48, "Azir");
    //System.out.println("temp[i]");
    for(int i=1;i<=48;i++){
    size_cham[i]=10;
    }
     }
    
    void take_cham(HashMap h1){
    champoins_list_store=h1;
    
    size_cham=new int[champoins_list_store.size()];
    for(int i=0;i<champoins_list_store.size();i++){
    size_cham[i]=10;
    }
    }
    
    
    public HashMap print(){
   // System.out.println("fffffffffffffff");
        for(int k=0;k<5;k++){
        if_buy[k]=false;
        }
        
        int i=0;
        Random r=new Random();
        while(i==0){
        temp[0]=r.nextInt(10);
        if(temp[0]==0){temp[0]=1;}
        if(size_cham[temp[i]]>0){break;}
        }
        
        i=1;
        while(i<5){
        temp[i]=temp[i-1]+r.nextInt(10)+1;
        if(temp[4]>48){temp[4]=48;}
        if(size_cham[temp[i]]>0)
        i++;
        }
        
        int j=0;
        for(i=0;i<5;i++){
            j=i+1;
        h1.put(j,(champoins_list_store.get(temp[i])));
        
        }
        
        //h1.put(1,"Fiora");
        return h1;
        //int k=0;
       // System.out.println("11111111111i="+k);
        
        //k=reader.nextInt();
        //System.out.println("11111111111i=");
                
//System.out.println("i="+i+"temp[i]"+temp[i]);
        //return champoins_list_store.get(temp[k-1]);
    }
    
    public void sell(String c){
    int i=0;
    for(i=1;i<=champoins_list_store.size();i++){
    if(champoins_list_store.get(i).equals(c)){
    break;
    }
    size_cham[i]++;
    }
    //return c.get_price();
    }
    
    
    
    public Champoin buy(String s,int coins){
    int i=0;
   
    
    for(i=1;i<=champoins_list_store.size();i++){
    
        if((champoins_list_store.get(i)).equals(s)){
    
            break;
    }
    
        
    }
    int g;
    for(g=0;g<5;g++){
    if(champoins_list_store.get(i).equals(champoins_list_store.get(temp[g])))
    {
   // if_buy[g]=true;
        break;
    }
    }
    if(!if_buy[g]){
    
    //System.out.println("s = "+s);
    Champoin c=new Champoin(s);
    c.set_name(s);
    //c.set_mena(11);
    //c.set_price(1);
    //System.out.println("[i] "+i);
    //System.out.println("size_cham[i]"+size_cham[i]);
    if(chack_price(c,coins)){
    size_cham[i]=(size_cham[i])-1;
    //System.out.println("2size_cham[i]"+size_cham[i]);
    if_buy[g]=true;
    return c;
    }
    else
    {
    
    System.out.println("not enough coins !! you can choise anther champoin : "); 
    //s=get_cham_temp_num();
                
    }
    
    
    return null;
    }//if buy
    else{System.out.println("you buy it in this round !!");
        return null;}
    }
    
    public boolean chack_price(Champoin c,int coins){
    if(c.get_price()<=coins){
    return true;
    
    }
    return false;
    }
/**
    public String get_cham_temp_num(){
    System.out.println("the number of champoin : ");
    int i=reader.nextInt();
    return champoins_list_store.get(temp[i-1]);
    
    }**/
    
}
