
package player;


import ability_classes.blade_master;
import ability_classes.brawler;
import ability_classes.dragons;
import ability_classes.elementalist;
import ability_classes.ninja;
import ability_classes.noble;
import ability_classes.pirate;
import java.util.HashMap;
//import java.util.Scanner;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import champoins.*;
import items.item;
import java.io.Serializable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
/**
 *
 * @author TOSHIBA
 */
public class player implements Serializable{
   // Scanner reader=new Scanner(System.in);
    boolean a=true;
    protected int coins=0;
    protected int num_champ=0,num_bench_champ=0;
    protected int const_num_cham=8;
    protected int const_max_cham=17;
    protected int []board_size=new int[2];
    protected int x=0,y=0;
    protected boolean increase_2_coins=false;
    protected boolean  increased_before=false;
    protected HashMap<Integer,Champoin> champoins_list=new HashMap<Integer,Champoin>();
    protected HashMap<Integer,Champoin> bench_list=new HashMap<Integer,Champoin>();
    protected HashMap<Integer,String> order_list=new HashMap<Integer,String>();
    protected HashMap<Integer,String> order_list_name=new HashMap<Integer,String>();
    public HashMap<Integer,String> name_class_champoins=new HashMap<Integer,String>();
    public HashMap<String,Integer> num_class_champoins=new HashMap<String,Integer>();
    int number_items=0;
    protected HashMap<Integer,String> name_items=new HashMap<Integer,String>();
    protected HashMap<item,Integer> items=new HashMap<item,Integer>();

    int count_class=0;
    public HashMap get_name_class_champoins(){return name_class_champoins;}
    public HashMap get_num_class_champoins(){return num_class_champoins;}
    
    
    


    public HashMap get_order_list(){
    return order_list;
    }
    public void decrease_num_cham(){
    num_champ--;
    }
    
    public void decrease_const_num_cham(){
    const_num_cham--;
    }
    
    boolean name_items_contain_Value(item n_item){
    for(int i=0;i<name_items.size();i++){
    if(name_items.get(i).contains(n_item.get_name())){
    return true;
    }
    
    }
    return false;
    }
    
    void set_item_in_itms(item n_item){
        
            if(n_item!=null){
            //System.out.println("items.get(n_item)"+n_item.get_name());
            //System.out.println("name_items"+name_items.get(0));
            if(name_items_contain_Value(n_item))
            {
            items.put(n_item,items.get(n_item)+1);
            int j=0;
            //System.out.println("name_items.size()"+name_items.size());
            for(j=0;j<name_items.size();j++){
            //System.out.println("name_items.get(j)"+name_items.get(j));
            if(name_items.get(j).contains(n_item.get_name())){
            name_items.put(j,n_item.get_name()+" "+(items.get(n_item)));
            System.out.println(n_item.get_name()+" item added !!");
            break;
            }
            }
            //number_items++;
            }
            else{
              //  System.out.println("asdasdasd");
            items.put(n_item,1);
            //System.out.println("items.get(n_item)"+items.get(n_item));
            
            name_items.put(number_items,n_item.get_name()+" "+1);
            System.out.println(n_item.get_name()+" item added !!");
            number_items++;
            }
            }
          }
        
        void delete_item(item n_item){
        
            items.put(n_item,items.get(n_item)-1);
          
            int j=0;
           // System.out.println("12313213ame_items"+n_item.get_name());
            for(j=0;j<name_items.size();j++){
            if(name_items.get(j).contains(n_item.get_name())){
            name_items.put(j,n_item.get_name()+" "+(items.get(n_item)));
            //System.out.println("ame_items");
            break;
            }
            }
        }
        //22
        
        public void return_items_from_bench_by_name(String s){
        int i;
            for(i=1;i<=bench_list.size();i++){
            if(bench_list.get(i).get_name().contains(s)){
            return_items_from_champ(bench_list.get(i));
            break;
            }
            }
             
        }
        
        public void return_items_from_champ_by_name(String s){
        int i;
            for(i=1;i<=champoins_list.size();i++){
            if(champoins_list.get(i).get_name().contains(s)){
            return_items_from_champ(champoins_list.get(i));
            break;
            }
            }
             
        }
        
        public void return_items_from_champ(Champoin obj){
        HashMap<Integer,item> items=obj.get_items();
        if(!items.isEmpty())
        {for(int i=0;i<items.size();i++){
        set_item_in_itms(items.get(i));
        }
        }
        delete_extra_classes(obj);
        }
        
    public String []get_name_items(){
    String []my_item=new String[20];
    //22
    //name_items.put(0,"kkk");
       //System.out.println("bench_list.size()"+bench_list.size());
    if(!name_items.isEmpty())
    {for(int i=0;i<name_items.size();i++){
            //System.out.println("bench_list.i"+i);
            my_item[i]=name_items.get(i);
        }
        for(int i=(name_items.size());i<20;i++){
        my_item[i]="";
        }}
    else{for(int i=0;i<20;i++){
            //System.out.println("bench_list.i"+i);
            my_item[i]="";
        }}
       //my_item[0]="ljklj";
        return my_item;
        
        
        }
        
        
        boolean check_available_item(item n_item){
        
            if(!items.isEmpty()){
            if(items.get(n_item)!=null){
            if(items.get(n_item)>0){
                return true;
            }
            }
            }
            return false;
            
          }
        
        public void set_item_in_champoin_by_name(item n_item,String champ_name,int round){
        
            int i;
            if(round >=9)
            {String t=champ_name.substring(2);
            champ_name=t;}
    
    //        System.out.println("1111111ame_items"+champ_name);
      //      System.out.println("champoins_list.get(i).get_name()"+champoins_list.get(1).get_name());
            
            
            
            for(i=1;i<=champoins_list.size();i++){
            if(champ_name.contains(champoins_list.get(i).get_name())){
       //         System.out.println("cham");
            break;
            
            }
            
            }
        //    System.out.println("1111111ame_items ="+i);
            
            set_item_in_champoin(n_item,champoins_list.get(i));
            
        
        
        }
        
        
        void set_item_in_champoin(item n_item,Champoin obj){
  
          
            if(check_available_item(n_item)){
                if(obj.add_item(n_item)){
                delete_item(n_item);
                take_extra_classes(obj);
                System.out.println("you get a new item to champoin !!");
                }
                else{
                System.out.println("max items for this champion");
                }
            }
            else{
            System.out.println("not enough items to do That !!");
            }
                
            
        }
        
        
        public void set_item_in_bench_by_name(item n_item,String champ_name,int round){
        
            int i;
            
    
    //        System.out.println("1111111ame_items"+champ_name);
      //      System.out.println("champoins_list.get(i).get_name()"+champoins_list.get(1).get_name());
            
            
            
            for(i=1;i<=bench_list.size();i++){
            if(champ_name.contains(bench_list.get(i).get_name())){
                //System.out.println("cham");
            break;
            
            }
            
            }
        //    System.out.println("1111111ame_items ="+i);
            
            set_item_in_bench(n_item,bench_list.get(i));
            
        
        
        }
        
        
       void set_item_in_bench(item n_item,Champoin obj){
  
          if(obj!=null && n_item!=null){
            if(check_available_item(n_item)){
                obj.add_item(n_item);
                delete_item(n_item);
                
                System.out.println("you get a new item to champoin !!");
                               
            }
            else{
            System.out.println("not enough items to do That !!");
            }
                
          }
        }
        
      void take_extra_classes(Champoin obj){
       if(obj.get_extra_class()!=null){   
       Champoin c=new Champoin();
       String []s=new String [3];
       s[0]=obj.get_extra_class();
       s[1]=null;
       s[2]=null;
       c.set_his_class(s);
       take_classes(c);
       //obj.set_extra_class(null);
       }
       } 
        
        
       void delete_extra_classes(Champoin obj){
       Champoin c=new Champoin();
       String []s=new String [3];
       s[0]=obj.get_extra_class();
       s[1]=null;
       s[2]=null;
       c.set_his_class(s);
       
       
       delet_classes(this,c);
       
       } 
       
       
  
       
    
       public boolean check_have_champoin(String val){
        //System.out.println("String val"+val);
           if(!champoins_list.isEmpty()){
        for(int i=1;i<=champoins_list.size();i++){
        if(champoins_list.get(i).get_name().contains(val)){
        return true;
        }
        
        }}
        if(!bench_list.isEmpty()){
        for(int i=1;i<=bench_list.size();i++){
        if(bench_list.get(i).get_name().contains(val)){
        return true;
        }
        
        }
        }
        return false;
    }
       
       
       
       
       
   // num_class_champoins        
   public  void increase_coins(){
    if(increase_2_coins){coins+=4;}
      else coins+=2;
    }
   public void increase_2_coins(){
       increase_2_coins=true;
   }
   public void increase_size_champ(){
    if(!increased_before){   
   const_max_cham++;
   increased_before=true;
    System.out.println("grant team an extra place !!");}
   System.out.println("you granted team an extra place before !!");
   }
   public void increase_champ_bench_level(String s1){
    int i=1;
   for(i=1;i<=bench_list.size();i++){
    if((bench_list.get(i).get_name()).equals(s1))
    {//System.out.println("hhhhhh");
    break;}
        }
   bench_list.get(i).increase_level();
   //System.out.println("1111111111");
   }
   
   public void increase_champ_level(String s1){
       int i=1;
   for(i=1;i<=champoins_list.size();i++){
    if((champoins_list.get(i).get_name()).equals(s1))
    {break;}
        }
   champoins_list.get(i).increase_level();
   
   }
   public void set_board_size(int val1,int val2){board_size[0]=val1; board_size[1]=val2;}
   public int[] get_board_size(){return board_size;}
   
   public void set_const_max_cham(int val){const_max_cham=val;}
   public void set_champoins_list(HashMap val){champoins_list=val;}
   public HashMap get_bench_list(){return bench_list;}
   public HashMap get_order_list_name(){return order_list_name;}
    public int get_coins(){return coins;}
    public void set_coins(int val){coins-=val;}
   public void take_pos(Champoin c){
    
    //System.out.print("\nx=");
//    x=reader.nextInt();
    //System.out.print("\ny="); 
  //  y=reader.nextInt();
    c.set_pos(x,y);
   }
    
    public void add_champoin(Champoin c){
        num_champ++;
    champoins_list.put(num_champ, c);
   System.out.println("done !! you have a new champoin in arena");
    }
    /**
    public boolean need_switch(){
    System.out.println("you need switch ?? n/y");
    String c=reader.nextLine();
    if(c.equals("y")){
    return true;
    }
    return false;
    }
    **/
    
    public void swap(int round, String s_bench,String s_cham,int x,int y,item n_item){
        int i=1,j=1;
    //System.out.println(x+" kkk "+y);
    //System.out.println("11num_bench_champ++"+s_bench);
    //System.out.println("go here !!!!!!"+s_cham);
    
    Champoin temp_cham=null;
    Champoin temp_bench=null;
    if(!max_game_champon()){
    if(!s_cham.equals("")&& round >=9)
    {String t=s_cham.substring(2);
    s_cham=t;}
    //System.out.println("go here !!!!!!"+s_cham);
    if(!champoins_list.isEmpty()&&!s_cham.equals(""))
    {for(i=1;i<=champoins_list.size();i++){
     //   System.out.println("s_cham "+s_cham);
   // System.out.println("champoins_list.get(i).get_name() "+champoins_list.get(i).get_name());
    if(s_cham.contains((champoins_list.get(i).get_name())))
    {
 //System.out.println("123123go here !!!!!!");
    temp_cham = champoins_list.get(i);
    //champoins_list=list_new(champoins_list,i);
    num_champ--;
    delet_classes(this,temp_cham);
    break;}
    }}else i=num_champ+1;
    for(j=1;j<=bench_list.size();j++){
    if((bench_list.get(j).get_name()).equals(s_bench))
    {temp_bench = bench_list.get(j);
     break;}
    }
    temp_bench.set_pos(x, y);
    //temp_bench.set_mov_speed(2);
    //System.out.println("111111i="+i);
    champoins_list.remove(i);
    champoins_list.put(i,temp_bench);
    take_classes(champoins_list.get(i));
    take_extra_classes(champoins_list.get(i));
    new check_ability_class(this);
                    
//System.out.println("");
    //int []p=new int[2];
    //p=champoins_list.get(1).get_pos();
    //System.out.println("x="+p[0]+" y="+p[1]);
    num_champ++;
    if(temp_cham!=null)
    {//System.out.println("dsadsadsad");
        delete_extra_classes(temp_cham);
        bench_list.put(j, temp_cham);
    
    }
    else{
    bench_list=list_new(bench_list,j);
    num_bench_champ--;
    set_item_in_itms(n_item);
    
    }
    //System.out.println("1name_class_champoins"+name_class_champoins.get(1));
    //System.out.println("1num_class_champoins"+num_class_champoins.get(name_class_champoins.get(1)));
    
    //System.out.println("2name_class_champoins"+name_class_champoins.get(2));
    //System.out.println("2num_class_champoins"+num_class_champoins.get(name_class_champoins.get(2)));
    System.out.println("done !!");
    }
    else{System.out.println("max champions in arena !! can't swap");}
    }
    
   public HashMap list_new(HashMap h1,int t){
    int j;
    for(j=t;j<h1.size();j++){
    h1.put(j,h1.get(j+1));
    }
    h1.remove(h1.size());
    return h1;
    }
    
    public void delete_from_bench(String s1){
    int i=1;
    System.out.println("bench_list.size()"+bench_list.size());
        for(i=1;i<=bench_list.size();i++){
    if((bench_list.get(i).get_name()).equals(s1)){
        break;
            }
            }
       set_coins(-(bench_list.get(i).get_price()));
        bench_list=list_new(bench_list,i);
        num_bench_champ--;
//        System.out.println("2222bench_list.size()"+bench_list.size());    
    };
    
    

    
    
    public void add_bench_champoin(Champoin c){
    num_bench_champ++;
    //pos champoin 0,0
    bench_list.put(num_bench_champ, c);
//    System.out.println("bench_list_add[1]"+bench_list.get(1).get_name());
   System.out.println("done !! you have a new champoin in bench");
    }
    
    
   public  boolean max_game_champon(){
    if(num_champ==const_num_cham){return true;}
    return false;
    }
    
    public boolean max_bench_champon(){
    if(num_bench_champ==8){return true;}
    return false;
    }
    public boolean maxchampon(){
    if((num_bench_champ+num_champ)==const_max_cham){return true;}
    return false;
    
    }
    
   public  boolean nocoins(){
    if(coins<0.1){return true;}
    return false;
    }
    
    
    
    
    boolean check_in_cham_in_champ_list(String name){
  //System.out.println("name"+name);
    HashMap<Integer,Champoin> champoins_temp=get_champoins_list();    
    for(int i=1;i<=champoins_temp.size();i++){
    //System.out.println("champoins_temp.size()"+(champoins_temp.get(i).get_name())+"name"+name);
    if(name.contains(champoins_temp.get(i).get_name()))
    {  
      //  System.out.println("aaaaaaa");
            return true;}
    
    }
    return false;    
        
        
    }
    
    
    
    
    
    public HashMap get_champoins_list(){return champoins_list;}
    public String[] get_name_bench_list(){
        String []my_bench=new String[8];
    
       //System.out.println("bench_list.size()"+bench_list.size());
    if(!bench_list.isEmpty())
    {for(int i=1;i<=bench_list.size();i++){
            //System.out.println("bench_list.i"+i);
            my_bench[i-1]=bench_list.get(i).get_name();
        }
        for(int i=(bench_list.size());i<8;i++){
        my_bench[i]="";
        }}
    else{for(int i=0;i<8;i++){
            //System.out.println("bench_list.i"+i);
            my_bench[i]="";
        }}
       
        return my_bench;}
    
    
    public String[] get_name_cham_list(){
        String []my_cham=new String[8];
    
       //System.out.println("bench_list.size()"+bench_list.size());
        for(int i=1;i<=bench_list.size();i++){
            //System.out.println("bench_list.i"+i);
            my_cham[i-1]=champoins_list.get(i).get_name();
        }
        for(int i=(bench_list.size()+1);i<8;i++){
        my_cham[i]=null;
        }
       
        return my_cham;
    
    
    }
    
    
    
    
    
    public void take_classes(Champoin obj){
    String []temp=new String[3];
    temp=obj.get_his_class();
    if(temp[0]!=null){
    if(num_class_champoins.get(temp[0])==null){//System.out.println("123here");
    num_class_champoins.put(temp[0],1);count_class++;name_class_champoins.put(count_class,temp[0]);}    
    else
    {//System.out.println("or here");
    num_class_champoins.put(temp[0],(num_class_champoins.get(temp[0])+1));
    }
    }
    if(temp[1]!=null){
    if(num_class_champoins.get(temp[1])==null){num_class_champoins.put(temp[1],1);count_class++;name_class_champoins.put(count_class,temp[1]);}    
    else num_class_champoins.put(temp[1], (num_class_champoins.get(temp[1])+1));
    }
    if(temp[2]!=null){
    if(num_class_champoins.get(temp[2])==null){num_class_champoins.put(temp[2],1);count_class++;name_class_champoins.put(count_class,temp[2]);}
    else num_class_champoins.put(temp[2], (num_class_champoins.get(temp[2])+1));
    }
    
    }
    
    
    
    
    
    
    public void delet_classes(player p,Champoin c){
    String []temp=new String[3];
    temp=c.get_his_class();
    if(temp[0]!=null&&temp[0]!=" "){
    //new_list();
    //System.out.println("num_class_champoins"+p.num_class_champoins.get(temp[0]));
        p.num_class_champoins.put(temp[0],((p.num_class_champoins.get(temp[0]))-1));
    //System.out.println("num_class_champoins"+p.num_class_champoins.get(temp[0]));
    if(p.num_class_champoins.get(temp[0])==0){
        int j=0;
        for(j=1;j<=p.name_class_champoins.size();j++)
        {
        if(p.name_class_champoins.get(j).equals(temp[0]))
            break;
        }
    p.name_class_champoins=list_new(p.name_class_champoins,j);
    p.count_class--;
    p.num_class_champoins.remove(temp[0]);
    }
    }
    if(temp[1]!=null&&temp[1]!=" "){
    //System.out.println("num_class_champoins"+p.num_class_champoins.get(temp[1]));
    
        p.num_class_champoins.put(temp[1], (p.num_class_champoins.get(temp[1])-1));
    //System.out.println("num_class_champoins"+p.num_class_champoins.get(temp[1]));
   
        if(p.num_class_champoins.get(temp[1])==0){
    
        int j=0;
        for(j=1;j<=p.name_class_champoins.size();j++)
        {
        if(p.name_class_champoins.get(j).equals(temp[1]))
            break;
        }
    p.name_class_champoins=list_new(p.name_class_champoins,j);
    p.count_class--;
    p.num_class_champoins.remove(temp[1]);    
//num_class_champoins=list_new(num_class_champoins,j);
    }
    }
    
    if(temp[2]!=null&&temp[2]!=" "){
    System.out.println("temp[2]!=null :"+temp[2]);
        p.num_class_champoins.put(temp[2], (p.num_class_champoins.get(temp[2])-1));
   
         if(p.num_class_champoins.get(temp[2])==0){
    
        int j=0;
        for(j=1;j<=p.name_class_champoins.size();j++)
        {
        if(p.name_class_champoins.get(j).equals(temp[2]))
            break;
        }
    p.name_class_champoins=list_new(p.name_class_champoins,j);
    p.count_class--;
    p.num_class_champoins.remove(temp[2]);
    }
        
    }
    
    
    }

    
 
 
 public void sell(){
 
 
 }
 /**
 public void buy_exe(){
 //show champoin in shop
     boolean a=true;
     int temp=0;
     while(a){
     if(num_bench_champ<8){
     
         //buy
        num_bench_champ++;    
         a=false;}
     else{
     System.out.println("you don't have enough space in bench !!\n 1-you can sell champoin \n2-exit buy ");
     temp=reader.nextInt();
     if(temp==1)
     {
     
     //sell();
     num_bench_champ--;
     }
     else{
     a=false;
     }
     }
     }
     
 }
 **/
 boolean check_in_cham_max_order(String name){
  //System.out.println("name"+name);
    //HashMap<Integer,String> champoins_temp=get_order_list_name();    
    int n;
     if(!champoins_list.isEmpty())
    for(int i=1;i<=champoins_list.size();i++){
    //System.out.println("champoins_temp.size()"+(champoins_temp.get(i).get_name())+"name"+name);
    if(name.contains((champoins_list.get(i).get_name())))
    {  
      
        n=champoins_list.get(i).get_order_num();
        //System.out.println("n="+n);
        if(n>0){
            champoins_list.get(i).set_order_num(champoins_list.get(i).get_order_num()-1);
            return false;}
            return true;}
    
    }
    return true;    
        
        
    }
    
 
 
    boolean check_in_cham_not_take_order(String name){
  //System.out.println("name"+name);
    HashMap<Integer,String> champoins_temp=get_order_list_name();    
    if(!champoins_temp.isEmpty())
    for(int i=1;i<=champoins_temp.size();i++){
    //System.out.println("champoins_temp.size()"+(champoins_temp.get(i).get_name())+"name"+name);
    if(name.contains(champoins_temp.get(i)))
    {  
      //  System.out.println("aaaaaaa");
            return false;}
    
    }
    return true;    
        
        
    }
    
 
 
 
 
   public  boolean take_order(String name,String order){
    //System.out.println("name"+name);
    if(check_in_cham_in_champ_list(name)){
        if(!check_in_cham_max_order(name)){
    order_list=new player_plan(order_list).take_plan(order);
    order_list_name=new player_plan(order_list_name).take_plan_name(name);
    
    return true;}
        else{System.out.println("this chamoins have max order !!");}
    
    
    }
    
    else
        System.out.println("this chamoins is't in your champoins");
    return false;}
 
 
 
 
 
 
   
   
    public void remove_order(){
        HashMap<Integer,String> temp=new HashMap<Integer,String>();
        order_list=new HashMap<Integer,String>();
        order_list_name=new HashMap<Integer,String>();
     
    if(!champoins_list.isEmpty())
    for(int i=1;i<=champoins_list.size();i++){
    
        champoins_list.get(i).set_order_num(3);
    
        
    }
    }
    public int get_num_champ(){
    return num_champ;
    }
    
    public int get_num_bench_champ(){
    return num_bench_champ;
    }
    
    
    

    /**
    public boolean need_buy(){
    System.out.println("123you need buy new champoin ?? n/y");
    //flash();
    String c;
    c=reader.nextLine();
    //int h=reader.nextInt();
    
    if(c.equals("y")){
    return true;
    }
    return false;
    }
    **/
 
    //inner class
    
 public class check_dead implements Serializable{
 
     player []players;
     
        check_dead(player []players){
        this.players=players;
        }
        
        
           
 public void if_dead(player p)
  {
 
  for(int i=1;i<=p.champoins_list.size();i++)
  {
   if(!champoins_list.isEmpty())
  if(p.champoins_list.get(i).ifdead())
  {    
  System.out.println(p.champoins_list.get(i).get_name()+" is die in last round !!");
  delet_classes(p,p.champoins_list.get(i));
  return_items_from_champ(p.champoins_list.get(i));
  list_new(p.champoins_list,i);
  //order_list.remove(i);
  p.num_champ--;
  p.const_num_cham--;
  
  i=i-1;
  }
     
  }  
     
  }
 public void check_dead_all_players(){
 
 for(int i=0;i<players.length;i++){
 if(players[i]!=null)
 if_dead(players[i]);
 
 }
 }

        
        
}
 
 
 
 
//inner
   public class check_ability_class implements Serializable{
    
    check_ability_class(player obj){
        String temp;
    for(int i=1;i<=name_class_champoins.size();i++){
//    System.out.println("asdasd1111="+i);
        temp=name_class_champoins.get(i);
  //      System.out.println("asdasd2222="+temp);
        //HashMap<Integer,Champoin> champoins_list2;
        if(num_class_champoins.get(temp)>=2){
    //    System.out.println("obj.num_class_champoins.get(temp)"+num_class_champoins.get(temp));
      //  System.out.println("temp "+temp);
            if(temp.contains("BladeMaster")){
        //champoins_list2=get_champoins_list();
        for(int j=1;j<=champoins_list.size();j++){
        for(int k=0;k<3;k++){
         if(champoins_list.get(j).get_his_class()[k]!=null){
         if(champoins_list.get(j).get_his_class()[k].contains("BladeMaster")){
        new blade_master(champoins_list.get(j),obj).do_it();
        }}
        }
        
        }
        //set_champoins_list(champoins_list);
        }
        else if(temp.contains("Brawler")){
        
           // champoins_list2=get_champoins_list();
        for(int j=1;j<=champoins_list.size();j++){
        for(int k=0;k<3;k++){
         if(champoins_list.get(j).get_his_class()[k]!=null){
         if(champoins_list.get(j).get_his_class()[k].contains("Brawler")){
        new brawler(champoins_list.get(j),obj).do_it();
        }}
        }
        
        }
        //set_champoins_list(champoins_list);
        
        }
        
        else if(temp.contains("Dragon")){
        
            
         //champoins_list2=get_champoins_list();
        for(int j=1;j<=champoins_list.size();j++){
        for(int k=0;k<3;k++){
         if(champoins_list.get(j).get_his_class()[k]!=null){
         if(champoins_list.get(j).get_his_class()[k].contains("Dragon")){
        new dragons(champoins_list.get(j),obj).do_it();
        }}
        }
        
        }
        //set_champoins_list(champoins_list);
        
        
        
        }
        else if(temp.contains("Elementalist")){
        
        //champoins_list2=get_champoins_list();
        for(int j=1;j<=champoins_list.size();j++){
        for(int k=0;k<3;k++){
         if(champoins_list.get(j).get_his_class()[k]!=null){
         if(champoins_list.get(j).get_his_class()[k].contains("Elementalist")){
        new elementalist(champoins_list.get(j),obj).do_it();
        }}
        }
        
        }
        //set_champoins_list(champoins_list);
        
        
        }
        else if(temp.contains("Ninja")){
        
        
         //champoins_list=get_champoins_list();
        for(int j=1;j<=champoins_list.size();j++){
        for(int k=0;k<3;k++){
         if(champoins_list.get(j).get_his_class()[k]!=null){
         if(champoins_list.get(j).get_his_class()[k].contains("Ninja")){
        new ninja(champoins_list.get(j),obj).do_it();
        }}
        }
        
        }
        //set_champoins_list(champoins_list);
        
        
        }
        else if(temp.contains("Noble")){
        
            
                //champoins_list2=get_champoins_list();
        for(int j=1;j<=champoins_list.size();j++){
        for(int k=0;k<3;k++){
         if(champoins_list.get(j).get_his_class()[k]!=null){
         if(champoins_list.get(j).get_his_class()[k].contains("Noble")){
        new noble(champoins_list.get(j),obj).do_it();
        }}
        }
        
        }
        //set_champoins_list(champoins_list);
        
        
        
        }
        else if(temp.contains("Pirate")){
        
            
          //      champoins_list2=get_champoins_list();
        for(int j=1;j<=champoins_list.size();j++){
        for(int k=0;k<3;k++){
         if(champoins_list.get(j).get_his_class()[k]!=null){
         if(champoins_list.get(j).get_his_class()[k].contains("Pirate")){
        new pirate(champoins_list.get(j),obj).do_it();
        }}
        }
        
        }
        //set_champoins_list(champoins_list);
        
        }
        
        }
    
    }
    }
    
    }

    
    
    
    
    
    
}
