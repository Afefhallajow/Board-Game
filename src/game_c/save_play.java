/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game_c;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */

public class save_play implements Serializable{
    //int round=30;
    //int second=90;
    //int pl_num=9;
    String name_file="game";
    String b=".txt";
    int num_save=0;
    //save [][]temp= new save[9] [21];
    HashMap<Integer,save[][]> data=new HashMap<Integer,save [][]>();
    int last_round=0;
    boolean s_l=false;
    save[][] s_g=new save[9][21];
    int l_round=100;
 save_play( )
{
}
 
save_play(String name_file)
{
    
this.name_file=name_file;

}
/**
public void new_round(){
for(int i=0;i<9;i++)
{
for(int j=0;j<21;j++)
{
temp[i][j]=new save();

}
}
}
**/
public void save_object(int round1,int pl_num,int time1,save m) throws ClassNotFoundException
{//System.out.println("time= "+(time1));
 //System.out.println("pl n= "+pl_num);
 //System.out.println("round1= "+round1);
   //temp[pl_num][time1]=m;
  /**save [][]temp3=new save[9][21];
   HashMap<Integer,save[][]> my_data=new HashMap<Integer,save [][]>();
    if(s_l){
     ObjectInputStream in=null;
   
     try {
         //save[][] s_g=new save[9][21];
         in = new  ObjectInputStream(new FileInputStream("savedgames/"+name_file+b));
         my_data= (HashMap) in.readObject();
         
         in.close();
     } catch (IOException ex) {
         Logger.getLogger(save_play.class.getName()).log(Level.SEVERE, null, ex);
     }
 
 
   data=my_data;
    
    s_l=false;
    }
   //System.out.println("time= "+(time1));
   if(round1==0 &&pl_num==0&&time1==20){
    temp3[pl_num][time1]=m;   
//   System.out.println("0000");    
   my_data.put(0,temp3);
   data=my_data;
   }
   else if(time1%5==0 || time1==20){
       
   
    if(time1==20 && round1!=last_round){
        my_data=data;
        temp3[pl_num][time1]=m;
        my_data.put(round1,temp3);}
    else{
    my_data=data;
    temp3=my_data.get(round1);
    my_data.remove(round1);
    temp3[pl_num][time1]=m;
   // System.out.println("11round = "+round1+"data.put 00= "+(temp3[0][15].round));    
   my_data.put(round1,temp3);
   }
   
 //  System.out.println("data.size()="+data.size());
   //save [][]temp2=my_data.get(data.size()-1);
    //save [][]temp7=my_data.get(0);  
// System.out.println("data.put= "+temp2[pl_num][time1].round);
 //System.out.println("22round = "+round1+"data.put 00= "+(temp7[0][20].round));

   
   

 try {
          ObjectOutputStream out;
         
          out = new ObjectOutputStream(new FileOutputStream("savedgames/"+name_file+b));
          
          out.writeObject(my_data);
          s_l=true;
          out.close();
          
        } catch (IOException ex) {
            Logger.getLogger(save.class.getName()).log(Level.SEVERE, null, ex);
        }
 
 }
   else{
  // System.out.println("ti = "+time1);
   temp3[pl_num][time1]=m;   
   temp3=data.get(round1);
    data.remove(round1);
    temp3[pl_num][time1]=m;
   // System.out.println("11round = "+round1+"data.put 00= "+(temp3[0][15].round));    
   data.put(round1,temp3);
   
   
   }
 last_round=round1;

 
 
**/
}

 public void last_save_object(int round1,int pl_num,int time1,save m) throws ClassNotFoundException
{
    
   save [][]temp3=new save[9][21];
   HashMap<Integer,save[][]> my_data=new HashMap<Integer,save [][]>();
   
    try {
         //save[][] s_g=new save[9][21];
        ObjectInputStream in=null;
     
        in = new  ObjectInputStream(new FileInputStream("savedgames/"+name_file+b));
         my_data= (HashMap) in.readObject();
         data=my_data;
   
         in.close();
     } catch (IOException ex) {
         Logger.getLogger(save_play.class.getName()).log(Level.SEVERE, null, ex);
     }
 
    //my_data=data;
    temp3=my_data.get(round1);
    my_data.remove(round1);
    
    temp3[pl_num][time1]=m;
   // System.out.println("11round = "+round1+"data.put 00= "+(temp3[0][15].round));    
   my_data.put(round1,temp3);
   
   
 try {
          ObjectOutputStream out;
         
          out = new ObjectOutputStream(new FileOutputStream("savedgames/"+name_file+b));
          
          out.writeObject(my_data);
          out.close();
          
        } catch (IOException ex) {
            Logger.getLogger(save.class.getName()).log(Level.SEVERE, null, ex);
        }
    
}
   
    
    

void save_thegame2(String file_name)
{

 try {
          ObjectOutputStream out;
         
          out = new ObjectOutputStream(new FileOutputStream("savedgames/"+file_name+b));
          out.writeObject(data);
          out.close();
        } catch (IOException ex) {
            Logger.getLogger(save.class.getName()).log(Level.SEVERE, null, ex);
        }
 
}

save load_game(int time1,int round1,String file_name2) throws FileNotFoundException, IOException, ClassNotFoundException
{       ObjectInputStream out=null;
       
            save[][] s=new save[9][21];
            out = new  ObjectInputStream(new FileInputStream("savedgames/"+file_name2+b));
            
            s= (save[][]) out.readObject();
            return(s[round1][time1]);
    
 }


save load_last_round(String file_name2) throws FileNotFoundException, IOException, ClassNotFoundException
{       
            ObjectInputStream in=null;
       
            save[][] s_g=new save[9][21];
            in = new  ObjectInputStream(new FileInputStream("savedgames/"+file_name2+b));
            data= (HashMap<Integer,save[][]>) in.readObject();
            System.out.println("data.size()"+data.size());
            s_g=data.get(data.size()-1);
            
            int max_round=s_g[0][20].max_round;
            
           // System.out.println("123max_round= "+max_round);
            for(int i=0;i<8;i++){
                //System.out.println("i= "+i); 
           
                
                for(int j=20;j>0;j--){
               if(s_g[i][j-1]==null){
                
                //System.out.println("i= "+i+"  j="+j);
                return s_g[i][j];}
            }
            }
            return(null);
    
        }








save load_round(int round2,int pl_num,int time,String file_name2) throws FileNotFoundException, IOException, ClassNotFoundException
{       
           ObjectInputStream in=null;
       
           if(round2!=l_round){
            in = new  ObjectInputStream(new FileInputStream("savedgames/"+file_name2+b));
            data= (HashMap) in.readObject();
            in.close();
            //System.out.println("data.size()"+data.size());
            //System.out.println("round"+round2);
            s_g=data.get(round2);
            if(s_g[pl_num][time]==null){System.out.println("end of game !!"); return null;}
            System.out.println("time"+(time));
            l_round=round2;
            return s_g[pl_num][time];
           }
           else{
           if(s_g[pl_num][time]==null){System.out.println("end of game !!"); return null;}
                
           return s_g[pl_num][time];
           }



}



}