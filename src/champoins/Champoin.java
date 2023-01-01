
package champoins;

import items.*;
import java.io.Serializable;
//import items.magic_hat;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TOSHIBA
 */
public class Champoin implements Serializable{

    protected double health=100;
    protected double armor=50;
    protected double magic;
    protected int vison;
    protected int attack_range=4;
    protected int mov_speed=0;
    protected int str_chance;
    protected double str_damage;
    protected double mena;
    protected double mena_cost;
    
    protected int []pos=new int [2];
    protected int price;
    protected int level=0;
    protected double attack_damage=70;
  //  protected champion_action his_actions;
    protected HashMap <Integer,Champoin>enemy_to_att=new HashMap<Integer,Champoin>();
    protected HashMap <Integer,Integer>num_player_to_att=new HashMap <Integer,Integer>(); 
    protected String []his_class=new String[3];
    protected String extra_class=null;
    protected String name;
    protected boolean protect_from_ability=false;
    protected int extra_attack=0;
    protected HashMap<Integer,item> items=new HashMap<Integer,item>();
    protected int order_num=3;
    
    public void set_health(double val){health=val; if(if_min(health)){health=0;}}
    public void set_armor(double val){armor=val;}
    public void set_magic(double val){magic=val;}
    void set_vison(int val){vison=val;}
    public void set_attack_range(int val){attack_range=val;}
    public void set_mov_speed(int val){mov_speed=val;}
    void set_str_chance(int val){str_chance=val;}
    public void set_str_damage(double val){str_damage=val;}
    public void set_mena(double val){mena=val;  if(if_min(mena)){mena=0;}}
    public void set_pos(int val1,int val2){pos[0]=val1;pos[1]=val2; }
    public void set_price(int val){price=val;}
    void set_level(int val){level=val;}
    public void set_attack_damage(double val){attack_damage=val;}
    public void set_enemy_to_att(HashMap val){enemy_to_att=val;}
    public void set_num_player_to_att(HashMap val){num_player_to_att=val;}
    public void set_extra_attack(int val){extra_attack=val;}
    public void set_extra_class(String val){extra_class=val;}
    
    public void new_mena(double val){mena=mena-val;if(mena<0)mena=0;}
    public void new_str_chance(double val){str_chance+=val;}
    public void new_str_damage(double val){str_damage+=val;}
    
    
    /** void set_his_class(String val1,String val2,String val3){if(val1!=null){his_class[0]=val1;}else his_class[0]=null;
                                                               if(val2!=null){his_class[1]=val2;}else his_class[1]=null;
                                                               if(val3!=null){his_class[2]=val3;}else his_class[2]=null;}
    **/
     public void set_name(String val){name=val;};
     public void set_his_class(String[]val){his_class=val;}
     public void set_order_num(int val){order_num=val;};
    
    
    public double get_health(){return health;}
    public double get_armor(){return armor;}
    public double get_magic(){return magic;}
    int get_vison(){return vison;}
    public int get_attack_range(){return attack_range;}
    public int get_mov_speed(){return mov_speed;}
    public int get_str_chance(){return str_chance;}
    public double get_str_damage(){return str_damage;}
    public double get_mena(){return mena;}
    public double get_mena_cost(){return mena_cost;}
    
    
    public int[] get_pos(){return pos;}
    public int get_price(){return price;}
    public int get_level(){return level;}
    public double get_attack_damage(){//System.out.println("attack_damage"+attack_damage);
    return attack_damage;}
    public String[] get_his_class(){return his_class;}
    public String get_extra_class(){return extra_class;}
    public String get_name(){return name;};
    public HashMap get_enemy_to_att(){return enemy_to_att;}
    public HashMap get_num_player_to_att(){return num_player_to_att;}
    public double get_cost_mena(){return mena_cost;}
    public int get_extra_attack(){return extra_attack;}
    public HashMap<Integer,item> get_items(){return items;}
    public int get_order_num(){return order_num;};
    
    public Champoin(){
      /**  attack_damage=70;
        his_class[0]="Wild";
        his_class[1]="Sorcerer";
        his_class[2]=null;
        price=1;
        mov_speed=2;**/
    };
    public void take_Champoin(
     int price,
     int health,
     int armor,
     int magic,
     int vison,
     int attack_range,
     double attack_damage,
     int mov_speed,
     int str_chance,
     int str_damage,
     double mena,
     double mena_cost,
     String his_class[]
     )
    {
     this.price=price;
     this.health=health;
     this.armor=armor;
     this.magic=magic;
     this.vison=vison;
     this.attack_range=attack_range;
     this.attack_damage=attack_damage;
     this.mov_speed=mov_speed;
     this.str_chance=0;
     this.str_damage=str_damage;
     this.mena=mena;
     this.mena_cost=mena_cost;
     //this.pos=pos;
     this.enemy_to_att=null;
     this.his_class=his_class;
//     champion_action his_actions=new champion_action();
     
    }
    
    
    
    
    
    
    public Champoin(String s){
   //this(1,2,3,4,5,6,7,8,9,1,2,3);
   String []classes=new String[3];
                
        switch (s) {
            case "Aatrox":
                classes[0]="Demon";
                classes[1]="BladeMaster";
                classes[2]=null;
                //set_name("Aatrox");
                take_Champoin(3,750,40,40,20,10,50,10,25,150,5,10,classes);
                break;
            case "Ahri":
                //String []classes=new String[3];
                classes[0]="Wild";
                classes[1]="Sorcerer";
                classes[2]="Assassin";
                //set_name("Ahri");
                take_Champoin(3,400,30,30,20,10,30,10,25,150,5,10,classes);
                break;
            case "Akali":
                classes[0]="Ninja";
                classes[1]="Assassin";
                classes[2]="Imperial";
                //set_name("Akali");
                take_Champoin(6,350,25,25,20,10,30,10,25,150,2,4,classes);
                break;
            case "Anivia":
                classes[0]="Glacial";
                classes[1]="Elementalist";
                classes[2]="Sorcerer";
                //set_name("Anivia");
                take_Champoin(6,500,50,50,20,10,20,10,25,150,5,10,classes);
                break;
            case "Ashe":
                classes[0]="Glacial";
                classes[1]="Ranger";
                classes[2]=null;
                //set_name("Ashe");
                take_Champoin(1,350,10,10,60,30,25,5,25,200,5,10,classes);
                break;
            case "Brand":
                classes[0]="Demon";
                classes[1]="Sorcerer";
                classes[2]=null;
                //set_name("Brand");
                take_Champoin(4,400,30,30,20,10,25,10,25,150,5,10,classes);
                break;
            case "Chogath":
                classes[0]="Void";
                classes[1]="Brawler";
                classes[2]=null;
                //set_name("Chogath");
                take_Champoin(1,600,30,30,25,15,35,10,25,150,5,10,classes);
                break;
            case "Draven":
                classes[0]="Imperial";
                classes[1]="BladeMaster";
                classes[2]="Ranger";
                //set_name("Darius");
                take_Champoin(6,400,40,40,20,10,35,10,25,150,5,10,classes);
                break;
            case "Darius":
                classes[0]="Imperial";
                classes[1]="Knight";
                classes[2]="Brawler";
                //set_name("Draven");
                take_Champoin(5,600,50,50,20,10,50,10,25,150,5,10,classes);
                break;
            case "Evelynn":
                classes[0]="Demon";
                classes[1]="Assassin";
                classes[2]=null;
                //set_name("Evelynn");
                take_Champoin(3,500,25,25,20,10,20,10,25,150,5,8,classes);
                break;
            case "Fiora":
                classes[0]="Noble";
                classes[1]="BladeMaster";
                classes[2]=null;
                //set_name("Fiora");
                take_Champoin(1,500,40,40,20,10,45,10,25,150,5,10,classes);
                break;
            case "Gankplank":
                classes[0]="Pirate";
                classes[1]="BladeMaster	";
                classes[2]="Gunslinger";
                //set_name("Gankplank");
                take_Champoin(4,200,40,40,20,10,50,10,25,150,5,10,classes);
                break;
            case "Garen":
                classes[0]="Noble";
                classes[1]="Knight";
                classes[2]="Brawler";
                //set_name("Garen");
                take_Champoin(5,600,50,50,20,10,50,10,25,150,5,10,classes);
                break;
            case "Gnar":
                classes[0]="Wild";
                classes[1]="Yordle";
                classes[2]="Shapeshifter";
                //set_name("Gnar");
                take_Champoin(4,450,30,30,20,10,45,10,25,150,5,10,classes);
                break;
            case "Graves":
                classes[0]="Imperial";
                classes[1]="Gunslinger";
                classes[2]="Pirate";
                //set_name("Graves");
                take_Champoin(4,200,20,20,60,30,30,5,25,200,5,10,classes);
                break;
            case "Karthus":
                classes[0]="Void";
                classes[1]="Sorcerer";
                classes[2]=null;
                //set_name("Karthus");
                take_Champoin(4,450,30,30,20,10,50,10,25,150,5,10,classes);
                break;
            case "Kassadin":
                classes[0]="Void";
                classes[1]="Sorcerer";
                classes[2]=null;
                //set_name("Kassadin");
                take_Champoin(2,550,30,30,20,10,50,10,25,150,0,0,classes);
                break;
            case "Katarina":
                classes[0]="Imperial";
                classes[1]="Assassin";
                classes[2]=null;
                //set_name("Katarina");
                take_Champoin(2,450,25,25,20,10,50,10,25,150,2,8,classes);
                break;
            case "Kayle":
                classes[0]="Noble";
                classes[1]="Knight";
                classes[2]="Ranger";
                //set_name("Kayle");
                take_Champoin(8,550,50,50,20,10,50,10,25,150,5,10,classes);
                break;
            case "Kennen":
                classes[0]="Ninja";
                classes[1]="Yordle";
                classes[2]="Elementalist";
                //set_name("Kennen");
                take_Champoin(5,350,50,50,20,10,60,10,25,150,5,10,classes);
                break;
            case "Khazix":
                classes[0]="Void";
                classes[1]="Assassin";
                classes[2]=null;
                //set_name("Khazix");
                take_Champoin(2,400,25,25,20,10,50,10,25,150,5,7,classes);
                break;
            case "Kindred":
                classes[0]="Void";
                classes[1]="Ranger";
                classes[2]=null;
                //set_name("Kindred");
                take_Champoin(2,350,10,10,60,30,50,5,25,200,5,10,classes);
                break;
            case "Leona":
                classes[0]="Noble";
                classes[1]="BladeMaster";
                classes[2]="Brawler";
                //set_name("Leona");
                take_Champoin(2,500,40,40,20,10,50,10,25,150,5,10,classes);
                break;
            case "Lissandra":
                classes[0]="Glacial";
                classes[1]="Elementalist";
                classes[2]="Sorcerer";
                //set_name("Lissandra");
                take_Champoin(6,800,50,50,20,10,50,10,25,150,5,10,classes);
                break;
            case "Lucian":
                classes[0]="Noble";
                classes[1]="Gunslinger";
                classes[2]=null;
                //set_name("Lucian");
                take_Champoin(1,450,20,20,60,30,50,5,25,200,5,10,classes);
                break;
            case "Lulu":
                classes[0]="Yordle";
                classes[1]="Elementalist";
                classes[2]=null;
                //set_name("Lulu");
                take_Champoin(2,350,50,50,20,10,50,10,25,150,5,10,classes);
                break;
            case "MissFortune":
                classes[0]="Pirate";
                classes[1]="Gunslinger";
                classes[2]=null;
                //set_name("Aatrox");
                take_Champoin(1,200,20,20,60,30,50,5,25,200,5,10,classes);
                break;
            case "Mordekaiser":
                classes[0]="Void";
                classes[1]="Knight";
                classes[2]=null;
                //set_name("Aatrox");
                take_Champoin(1,550,50,50,20,10,50,10,25,150,5,10,classes);
                break;
            case "Morgana":
                classes[0]="Demon";
                classes[1]="Sorcerer";
                classes[2]=null;
                //set_name("Aatrox");
                take_Champoin(3,500,30,30,20,10,50,10,25,150,5,10,classes);
                break;
            case "Nidale":
                classes[0]="Wild";
                classes[1]="Shapeshifter";
                classes[2]=null;
                //set_name("Aatrox");
                take_Champoin(1,500,45,45,20,10,50,10,25,150,5,10,classes);
                break;
            case "Poppy":
                classes[0]="Yordle";
                classes[1]="Knight";
                classes[2]="Brawler";
                //set_name("Aatrox");
                take_Champoin(6,650,50,50,20,10,50,10,25,150,5,10,classes);
                break;
            case "Pyke":
                classes[0]="Pirate";
                classes[1]="Assassin";
                classes[2]=null;
                //set_name("Aatrox");
                take_Champoin(2,200,25,25,20,10,50,10,25,150,5,7,classes);
                break;
            case "Ranger":
                classes[0]="Wild";
                classes[1]="Assassin";
                classes[2]=null;
                //set_name("Aatrox");
                take_Champoin(2,500,25,25,20,10,50,10,25,150,5,7,classes);
                break;
            case "Sejuani":
                classes[0]="Glacial";
                classes[1]="Knight";
                classes[2]=null;
                //set_name("Aatrox");
                take_Champoin(2,550,50,50,20,10,50,10,25,150,5,10,classes);
                break;
            case "Shen":
                classes[0]="Ninja";
                classes[1]="BladeMaster";
                classes[2]=null;
                //set_name("Aatrox");
                take_Champoin(4,650,40,40,20,10,50,10,25,150,5,10,classes);
                break;
            case "Shyvana":
                classes[0]="Dragon";
                classes[1]="Knight";
                classes[2]="Brawler";
                //set_name("Aatrox");
                take_Champoin(6,650,50,50,20,10,50,10,25,150,5,10,classes);
                break;
            case "Sol":
                classes[0]="Dragon";
                classes[1]="Elementalist";
                classes[2]=null;
                //set_name("Aatrox");
                take_Champoin(3,400,50,50,20,10,50,10,25,150,5,10,classes);
                break;
            case "Swain":
                classes[0]="Demon";
                classes[1]="Shapeshifter";
                classes[2]="Imperial";
                //set_name("Aatrox");
                take_Champoin(6,600,45,45,20,10,50,10,25,150,2,10,classes);
                break;
            case "Talon":
                classes[0]="Ninja";
                classes[1]="BladeMaster";
                classes[2]="Assassin";
                //set_name("Aatrox");
                take_Champoin(6,500,40,40,20,10,50,10,25,150,5,10,classes);
                break;
            case "Tristana":
                classes[0]="Yordle";
                classes[1]="Gunslinger";
                classes[2]=null;
                //set_name("Aatrox");
                take_Champoin(1,450,20,20,60,30,50,5,25,200,5,10,classes);
                break;
            case "Varus":
                classes[0]="Demon";
                classes[1]="Ranger";
                classes[2]=null;
                //set_name("Aatrox");
                take_Champoin(2,500,10,10,60,30,50,5,25,200,5,10,classes);
                break;
            case "Vayne":
                classes[0]="Noble";
                classes[1]="Ranger";
                classes[2]=null;
                //set_name("Aatrox");
                take_Champoin(1,300,10,10,60,30,50,5,25,200,0,3,classes);
                break;
            case "Veiger":
                classes[0]="Yordle";
                classes[1]="Sorcerer";
                classes[2]=null;
                //set_name("Aatrox");
                take_Champoin(3,300,30,30,20,10,50,10,25,150,0,7,classes);
                break;
            case "Volibear":
                classes[0]="Glacial";
                classes[1]="Brawler";
                classes[2]=null;
                //set_name("Aatrox");
                take_Champoin(1,650,30,30,25,15,50,10,25,150,5,10,classes);
                break;
            case "Warwick":
                classes[0]="Wild";
                classes[1]="Brawler";
                classes[2]=null;
                //set_name("Aatrox");
                take_Champoin(1,500,30,30,25,15,50,10,25,150,5,10,classes);
                break;
            case "Yasuo":
                classes[0]="BladeMaster";
                classes[1]="Assassin";
                classes[2]=null;
                //set_name("Aatrox");
                take_Champoin(4,500,25,25,20,10,50,10,25,150,5,7.5,classes);
                break;
            case "Zed":
                classes[0]="Ninja";
                classes[1]="Assassin";
                classes[2]="BladeMaster";
                //set_name("Aatrox");
                take_Champoin(4,350,25,25,20,10,50,10,25,150,5,7.5,classes);
                break;
            case "Azir":
                classes[0]="Dragon";
                classes[1]="Sorcerer";
                classes[2]="Ranger";
                //set_name("Aatrox");
                take_Champoin(6,400,25,25,60,30,50,10,25,150,2,10,classes);
                break;
            /**case "":
                classes[0]="";
                classes[1]="";
                classes[2]="";
                //set_name("Aatrox");
                take_Champoin(1,2,3,4,5,6,7,8,9,1,2,3,classes);
                break;
                default:
                break;**/
        }
    }
    int num_item=0;
    public boolean add_item(item n_item){
   
        if(can_add_item()){
        if(n_item!=null){
        items.put(num_item,n_item);
        num_item++;
        
        if(n_item instanceof angry_cloak){
        new angry_cloak(this).do_item();
        }
        
        else if(n_item instanceof knight_armor){
        new knight_armor(this).do_item();
        }
        
        else if(n_item instanceof magic_hat){
        new magic_hat(this).do_item();
        }
        
        else if(n_item instanceof night_shift){
        new night_shift(this).do_item();
        }
        
        else if(n_item instanceof universe_core){
        new universe_core(this).do_item();
        }
        
        else if(n_item instanceof void_hit){
        new void_hit(this).do_item();
        }
        
        else if(n_item instanceof warrior_gloves){
        new warrior_gloves(this).do_item();
        }
        
    }
        return true;}
        else{
        return false;
        }
    }
    
    public String []get_items_name(){
    
    String []my_item=new String[3];
    //22
    //name_items.put(0,"kkk");
       //System.out.println("bench_list.size()"+bench_list.size());
    if(!items.isEmpty())
    {for(int i=0;i<items.size();i++){
            //System.out.println("bench_list.i"+i);
            my_item[i]=items.get(i).get_name();
        }
        for(int i=(items.size());i<3;i++){
        my_item[i]="";
        }}
    else{for(int i=0;i<3;i++){
            //System.out.println("bench_list.i"+i);
            my_item[i]="";
        }}
       //my_item[0]="ljklj";
        return my_item;
        
    
    }
    
    
    /**   if(!items.isEmpty()){
    if(can_add_item()){
    if(items.get(n_item)!=null){    
    items.put(num_item,n_item);
    num_item++;}
    else{items.put(num_item,n_item);
        num_item++;
    }
    }
    }
    else{//is empty
        items.put(num_item,n_item);
        num_item++;
    }
    }
    **/
    public boolean can_add_item(){
    if(num_item<3){
    return true;
    }
    return false;
    
    }
    
    
    public void decrease_mena(){
    mena=mena-mena_cost;
    }
    public void protection(){
    protect_from_ability=true;
    }
    public boolean check_protection(){
    if(protect_from_ability)return true;
    return false;
    }
    
    public boolean ifdead(){
    if(health==0){
    return true;}
    return false;
    }
    
    
    public boolean ifmax_mena(){
    if(mena==100){
    return true;}
    return false;
    }
    
    
    public boolean if_max(double val){
    if(val>100){
    return true;}
    return false;
    }
    
    
    public boolean if_min(double val){
    if(val<0){
    return true;}
    return false;
    }
    
    synchronized public void takedammage(double val){
    //System.out.println("armor_eff(val)"+armor_eff(val));
    set_health(health-armor_eff(val));
    //System.out.println("health"+health);
    increase_mena(1);
    }
    
    public void increase_mena(double val){
    set_mena(mena+val);
    //if(mena>mena_cost){mena=mena_cost;}
    }
    
    public void decrease_str_chance(){
    str_chance=0;
    
    }
    public void increase_str_chance(){
    str_chance+=25;
    if(str_chance>100){str_chance=100;}
    }
    public void increase_level(){
    
        set_level(1+level);
        if(level==1){
            //System.out.println("h : "+health);
            double d=0.2,d1=0.1;
            
            //System.out.println("n : "+d);
            //System.out.println("l2"+health*d);
        set_attack_damage(attack_damage+attack_damage*d1);
        set_health(health+health*d);
        set_armor(armor+armor*d);}
        
        if(level==2){
            double d=0.25,d1=0.15;
        set_attack_damage(attack_damage+attack_damage*(d1));
        set_health(health+health*(d));
        set_armor(armor+armor*(d));}
        
        }
//System.out.println("aaaaaaaaa"+level);
     
    
    public double armor_eff(double val){//dammage from enmes
        //System.out.println("aaaaaaaaa"+val+" f "+armor);
        double f=armor/100;
    return (val*f);
    
    }
    
    public boolean arr_vison(int val1,int val2){
    if(val1<(pos[0]+vison) && val1>(pos[0]-vison))
        if(val2<(pos[1]+vison) && val1>(pos[1]-vison))
            return true;
    
    return false;
    }
    
    public boolean arr_att(int val1,int val2){
        //System.out.println("aaaaaaa");
    if(val1<=(pos[0]+attack_range) && val1>=(pos[0]-attack_range))
        if(val2<=(pos[1]+attack_range) && val1>=(pos[1]-attack_range))
            return true;
    return false;
    }
    //change
    public void str_chance_check(){
    if(str_chance==100){
//    str_damage=true;
    }
    }
    
    public boolean str_damage_check(){
  /**  if(str_damage==true){
    return true;
    }**/
    return false;
    }
    
    public boolean magic_check(){
    if(magic==100){return true;}
    return false;
    }
    
    
    public void  do_ability(){};

/**    private Champoin(int i, int i0, int i1, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Champoin(int i, int i0, int i1, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   **/ 
/**
    //inner class
public class champion_action implements Runnable{
    }
    **/
/**    
    void pos_att(int val1,int val2){
    pos_att[0]=val1;
    pos_att[1]=val2;
    }
    //enemy
    void champ_att(Champoin obj){
    this.obj=obj;
    }
   **/ 
}

    
    

