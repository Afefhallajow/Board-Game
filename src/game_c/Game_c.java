
package game_c;

import champoins.Champoin;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import player.*;
import rounds.*;
import attack.*;
import bots.*;
import items.*;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.Random;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.effect.ColorInput;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
//import javax.swing.border.Border;
import store.permanent_store;


public class Game_c extends Application implements Serializable{
    
   permanent_store s=new permanent_store();
    String cham_bench_name="";
    int swap_num=2;
    int const_swap=2;
    String cham_to_order="";
    String  name_cham="";
    String name_temp="";
    String  cham_to_att="";
    String  choise_item="";
    String choise_game="";
    boolean end_choise=false;
    boolean watch_mode=false;
    boolean save_mode=false;
    
    public Button btn[][];
    public String [][]btn_type;
   
   public int i,j;
   int player_num=0,round=0,time=20;
   int check_second=0;
   int save_time=0;
   int max_round;
   Timeline time_line=new Timeline();
   player []players;

   ObservableList<String> list_thems_o=null;
   ObservableList<String> list_store_o;
   ObservableList<String> list_bench_o=null;
   ObservableList<String> list_order_o=null;
   ObservableList<String> list_tiers_o=null;
   ObservableList<String> list_items_o=null;
   round my_round;
   bot one_bot;
   boolean bot_on=false;
   boolean []bots=new boolean [8];
   boolean a=true;
   Thread t=new Thread();
   int []size_board=new int [2];
//    11
   item angry_cloak_item=new angry_cloak(null);
   item knight_armor_item=new knight_armor(null);
   item magic_hat_item=new magic_hat(null);
   item night_shift_item=new night_shift(null);
   item universe_core_item=new universe_core(null);
   item void_hit_item=new void_hit(null);
   item warrior_gloves_item=new warrior_gloves(null);
   
   save_play data_to_save;
   save_play data_to_load=new save_play();
   save save_ga=null;
   
   Pane root=new Pane();
   
    ListView<String>list_items=new ListView<>();
       ListView<String>list_order=new ListView<>();
       ListView<String>list_bench=new ListView<>();
       ListView<String>list_store=new ListView<>();
        
      ListView<String>list_tiers=new ListView<>();

        Label coins_label=new Label();
        Label time_label=new Label();
        
   @Override
    public void start(Stage primaryStage) {
   
        
        Button new_game_btn=new Button(" New Game ");
        Button load_game_btn=new Button(" Load Game ");
        Button watch_game_btn=new Button(" Watch Game ");
        
        Label thems_label=new Label("thems ");
        ListView<String>list_thems=new ListView<>();    
        list_thems.setOrientation(Orientation.HORIZONTAL);  
        //list_thems.setPadding(new Insets(0,0,30,0));
        list_thems_o=FXCollections.observableArrayList(
            "Blue","Dark");
        
        list_thems.setItems(list_thems_o);
        new_game_btn.setTranslateX(450);
        new_game_btn.setTranslateY(150);
        new_game_btn.setMinSize(100,50);
        
          
        load_game_btn.setTranslateX(450);
        load_game_btn.setTranslateY(300);
        load_game_btn.setMinSize(100,50);
        
          
        watch_game_btn.setTranslateX(450);
        watch_game_btn.setTranslateY(450);
        watch_game_btn.setMinSize(100,50);
        
        thems_label.setTranslateX(945);
        thems_label.setTranslateY(550);
        
        list_thems.setTranslateX(925);
        //list_thems.setStyle("-fx-alignment: center;");
        list_thems.setTranslateY(570);
        //list_thems.setMinSize(70, 70);
        list_thems.setMaxSize(80,80);
       
         
        new_game_btn.setOnAction(new EventHandler<ActionEvent>() {
             @Override
        public void handle(ActionEvent event3) {
        
            
            
                    root.getChildren().remove(list_thems);
                    root.getChildren().remove(thems_label);
                    root.getChildren().remove(watch_game_btn);
                    root.getChildren().remove(load_game_btn);
                    root.getChildren().remove(new_game_btn);
                    
            
//        22    
        TextField name_text=new TextField("");
        Label name_label=new Label("name : ");
        name_text.setTranslateX(430);
        name_text.setTranslateY(100);
        name_label.setTranslateX(388);
        name_label.setTranslateY(102);
                                
                    
        Button start_btn=new Button(" start ");
        
        start_btn.setTranslateX(480);
        start_btn.setTranslateY(500);
        
        TextField player_text=new TextField("");
        Label player_label=new Label("players:");

        player_text.setTranslateX(250);
        player_text.setTranslateY(200);
        player_label.setTranslateX(208);
        player_label.setTranslateY(202);
        
        TextField bot_text=new TextField("");
        Label bot_label=new Label("bots:");
        
        bot_text.setTranslateX(250);
        bot_text.setTranslateY(300);
        bot_label.setTranslateX(220);
        bot_label.setTranslateY(302);
        
        TextField round_text=new TextField("");
        Label round_label=new Label("rounds: ");
        
        round_text.setTranslateX(250);
        round_text.setTranslateY(400);
        round_label.setTranslateX(208);
        round_label.setTranslateY(402);
        
        TextField swap_text=new TextField("");
        Label swap_label=new Label("swap:");
        
        swap_text.setTranslateX(650);
        swap_text.setTranslateY(200);
        swap_label.setTranslateX(615);
        swap_label.setTranslateY(202);
        
        TextField champ_text=new TextField("");
        Label champ_label=new Label("max champoins:");
        
        champ_text.setTranslateX(650);
        champ_text.setTranslateY(300);
        champ_label.setTranslateX(560);
        champ_label.setTranslateY(302);
        
        TextField hight_text=new TextField("");
        Label hight_label=new Label("board hight:");
        
        hight_text.setTranslateX(650);
        hight_text.setTranslateY(380);
        hight_label.setTranslateX(570);
        hight_label.setTranslateY(382);
        
        TextField width_text=new TextField("");
        Label width_label=new Label("board width:");
        
        width_text.setTranslateX(650);
        width_text.setTranslateY(410);
        width_label.setTranslateX(570);
        width_label.setTranslateY(412);
        
        
        start_btn.setOnAction(new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent event2) {
                    if(!player_text.getText().equals("") && !bot_text.getText().equals("") && !round_text.getText().equals("") && !swap_text.getText().equals("") && !champ_text.getText().equals("") &&!width_text.getText().equals("")&&!hight_text.getText().equals(""))    
                    {
                      //  int o=Integer.parseInt(player_text.getText().toString());
                       // System.out.println("i="+o);
                        if(Integer.parseInt(player_text.getText().toString())>=Integer.parseInt(bot_text.getText().toString()))
                        {
                          data_to_save=new save_play(name_text.getText());  
                          size_board[0]=Integer.parseInt(hight_text.getText().toString());
                          size_board[1]=Integer.parseInt(width_text.getText().toString());
                          
                          swap_num=Integer.parseInt(swap_text.getText().toString());
                          const_swap=Integer.parseInt(swap_text.getText().toString());
                          max_round=8+Integer.parseInt(round_text.getText().toString());
                         //System.out.print("max_round "+max_round);
                          players=new player[Integer.parseInt(player_text.getText().toString())];
                          for(int i=0;i<Integer.parseInt(player_text.getText().toString());i++){
                          
                              System.out.println("player " + i);
                              players[i]=new player();
                              players[i].set_const_max_cham(Integer.parseInt(champ_text.getText().toString())); 
                              players[i].set_board_size(size_board[0],size_board[1]);
                          }
                          for(int i=0;i<8;i++){
                          bots[i]=false;}
                         // System.out.println("121212bot" + ((Integer.parseInt(player_text.getText().toString()))-(Integer.parseInt(bot_text.getText().toString()))));
                          for(int i=(Integer.parseInt(player_text.getText().toString()))-(Integer.parseInt(bot_text.getText().toString()));i<Integer.parseInt(player_text.getText().toString());i++){
                          //System.out.println("bot" + i);
                              bots[i]=true;
                          
                          }
                            
                    root.getChildren().remove(start_btn);
                    root.getChildren().remove(player_text);
                    root.getChildren().remove(player_label);
                    root.getChildren().remove(bot_text);
                    root.getChildren().remove(bot_label);
                    root.getChildren().remove(round_text);
                    root.getChildren().remove(round_label);
                    root.getChildren().remove(swap_text);
                    root.getChildren().remove(swap_label);
                    root.getChildren().remove(champ_text);
                    root.getChildren().remove(champ_label);
                    root.getChildren().remove(hight_text);
                    root.getChildren().remove(hight_label);
                    root.getChildren().remove(width_text);
                    root.getChildren().remove(width_label);
                    root.getChildren().remove(name_text);
                    root.getChildren().remove(name_label);
                    
                    players[0].increase_coins();
                    start_game();
                    
                    return;
                    
      }//if player<bot
                        else{System.out.println("number of player must be greater than bot num");}
                    }//if
      }  });
         root.getChildren().add(start_btn);
         root.getChildren().add(player_text);
         root.getChildren().add(player_label);
         root.getChildren().add(bot_text);
         root.getChildren().add(bot_label);
         root.getChildren().add(round_text);
         root.getChildren().add(round_label);
         root.getChildren().add(swap_text);
         root.getChildren().add(swap_label);
         root.getChildren().add(champ_text);
         root.getChildren().add(champ_label);
         root.getChildren().add(hight_text);
         root.getChildren().add(hight_label);
         root.getChildren().add(width_text);
         root.getChildren().add(width_label);
         root.getChildren().add(name_text);
         root.getChildren().add(name_label);
                     
         
    }  });
        
        
        
    
        load_game_btn.setOnAction(new EventHandler<ActionEvent>() {
             @Override
        public void handle(ActionEvent event3) {
        
            
            
                    root.getChildren().remove(list_thems);
                    root.getChildren().remove(thems_label);
                    root.getChildren().remove(watch_game_btn);
                    root.getChildren().remove(load_game_btn);
                    root.getChildren().remove(new_game_btn);
            
                    ObservableList<String> list_seved_game_o;
                   list_seved_game_o=FXCollections.observableArrayList(
                    ""
                    );
            
                    ListView<String>list_saved=new ListView<>();    
                    list_saved.setItems(list_seved_game_o);
                    
                    Button load_btn=new Button(" load ");
                    
                    Label saved_game_label=new Label(" Saved Games :");
        
                    saved_game_label.setTranslateX(300);
                    saved_game_label.setTranslateY(100);
                    
                    list_saved.setTranslateX(300);
                    list_saved.setTranslateY(120);
                    list_saved.setMinSize(500,400);
                    
                    load_btn.setTranslateX(755);
                    load_btn.setTranslateY(525);
                    load_btn.setMinSize(50,30);
        
                    
                   
                    list_saved.getSelectionModel().selectedItemProperty().addListener(
                    (ObservableValue<? extends String>ov, String old_val, String new_val)->{
        
                    if(new_val==null){new_val="";}
                    choise_game=new_val;
                    
                    });
                    /**
                    String []saved_game_name=new String[5];
                    for(int q=0;q<saved_game_name.length;q++){
                    saved_game_name[q]=null;
                    }
                    **/
                    //String saved_game_name;
                    File folder=new File("savedgames/");
                    File []list_file=folder.listFiles();
                    //System.out.println("a"+list_file[0].getName());
                    int t9;
                   String h9;
                   //String h2=h.substring(t+1);
                   
                    for(i=0;i<list_file.length;i++){
                    if(list_file[i].isFile()){
                      t9=(list_file[i].getName()).indexOf(".");
                      h9=(list_file[i].getName()).substring(0, t9);
                     list_seved_game_o.add(h9);
                    
                    }
                    }
                    //get the name of all saved games
                    /**
                    //for to put the name in the list
                    for(int q=0;q<saved_game_name.length;q++){
                    if(saved_game_name[q]!=null){
                    list_seved_game_o.add(saved_game_name[q]);
                    }
                    }
                    **/
                    list_saved.setItems(list_seved_game_o);
                    
                    load_btn.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event3) {
                    if(choise_game.contains("")){
                    root.getChildren().remove(load_btn);
                    root.getChildren().remove(list_saved);
                    root.getChildren().remove(saved_game_label);
                    
                    save save_ga=null;        
                        try {        
                            save_ga=data_to_load.load_last_round(choise_game);
                       
                        } catch (IOException ex) {
                            Logger.getLogger(Game_c.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(Game_c.class.getName()).log(Level.SEVERE, null, ex);
                        }
//                        22
                    //choise_game  is string parmeter contains the name of game we want to load
                    data_to_save=new save_play(choise_game);  
                          
                        size_board[1]=save_ga.board_h;
                    size_board[0]=save_ga.board_w;
                          
                          swap_num=save_ga.swap;
                          const_swap=save_ga.max_swap;
                          max_round=save_ga.max_round;
                         System.out.print("max_round "+max_round);
                          players=save_ga.players;
                          
                          
                          bots=save_ga.bots;
                          time=save_ga.time;
                          round=save_ga.round;
                          System.out.print("player_num"+save_ga.player_num);
                          System.out.print("round="+save_ga.round);
                          player_num=save_ga.player_num;
                          
                          s=save_ga.s;
                          btn_type=save_ga.btn_type;
           
                          
//            22
// System.out.println("121212bot" + ((Integer.parseInt(player_text.getText().toString()))-(Integer.parseInt(bot_text.getText().toString()))));
                          
                          
                    //round
                    //time
                    //player
                    //num_player
                          
                    save_mode=true;
                    
                        try {
                            data_to_save.last_save_object(round,player_num,time,new save(players,player_num,round,time,max_round,s,size_board[0],size_board[1],swap_num,const_swap,bots,btn_type));
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(Game_c.class.getName()).log(Level.SEVERE, null, ex);
                        }
                
                    
                    start_game();
                    
                    return;
                    
                    
                        }
                        }  });
                    
                    root.getChildren().add(list_saved);
                    root.getChildren().add(load_btn);
                    root.getChildren().add(saved_game_label);
                    
                    
         
        }  });
        
        
        
        
        
        watch_game_btn.setOnAction(new EventHandler<ActionEvent>() {
             @Override
        public void handle(ActionEvent event3) {
        
            
            
                    root.getChildren().remove(list_thems);
                    root.getChildren().remove(thems_label);
                    root.getChildren().remove(watch_game_btn);
                    root.getChildren().remove(load_game_btn);
                    root.getChildren().remove(new_game_btn);
            
                    ObservableList<String> list_watch_game_o;
                   list_watch_game_o=FXCollections.observableArrayList(
                    ""
                    );
                 ListView<String>list_watch=new ListView<>();    
                    list_watch.setItems(list_watch_game_o);
                    
                    Button watch_btn=new Button(" watch ");
                    
                    Label watch_game_label=new Label(" Games :");
        
                    watch_game_label.setTranslateX(300);
                    watch_game_label.setTranslateY(100);
                    
                    list_watch.setTranslateX(300);
                    list_watch.setTranslateY(120);
                    list_watch.setMinSize(500,400);
                    
                    watch_btn.setTranslateX(755);
                    watch_btn.setTranslateY(525);
                    watch_btn.setMinSize(50,30);
        
                    
                   
                    list_watch.getSelectionModel().selectedItemProperty().addListener(
                    (ObservableValue<? extends String>ov, String old_val, String new_val)->{
        
                    if(new_val==null){new_val="";}
                    choise_game=new_val;
        
                    });
                    File folder=new File("savedgames/");
                    File []list_file=folder.listFiles();
                    //System.out.println("a"+list_file[0].getName());
                     int t9;
                   String h9;
                   //String h2=h.substring(t+1);
                   
                    for(i=0;i<list_file.length;i++){
                    if(list_file[i].isFile()){
                      t9=(list_file[i].getName()).indexOf(".");
                      h9=(list_file[i].getName()).substring(0, t9);
                     list_watch_game_o.add(h9);
                    
                    }
                    }
                   
                    list_watch.setItems(list_watch_game_o);
                    
                    watch_btn.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event3) {
        
                    root.getChildren().remove(watch_btn);
                    root.getChildren().remove(list_watch);
                    root.getChildren().remove(watch_game_label);
                    
                    
                    load_first_round();
                    //choise_game  is string parmeter contains the name of game we want to watch
                    
                    //تلقائيا يبدا الوقت والراوند كلعبة عادية
                    //need method take time as parmeter and changed in players in this second
                    //player
              
                    // لاحقا في كل ثانية نستدعي الدالة لتغير على مصفوفة اللاعبين
                    watch_mode=true;
                    start_game();
                    
                    return;
    
                 }  });
                    
                    root.getChildren().add(list_watch);
                    root.getChildren().add(watch_btn);
                    root.getChildren().add(watch_game_label);

        }  });
        
        
         root.getChildren().add(new_game_btn);
         root.getChildren().add(load_game_btn);
         root.getChildren().add(watch_game_btn);
         root.getChildren().add(thems_label);
         root.getChildren().add(list_thems);
         
         Scene scene = new Scene(root, 1000, 650);
        
         list_thems.getSelectionModel().selectedItemProperty().addListener(
        (ObservableValue<? extends String>ov, String old_val, String new_val)->{
        
            if(new_val==null){new_val="";}
            //System.out.println("new vla="+new_val);
            if(new_val.contains("Blue")){
          //System.out.println("qeqweqwe");
          scene.getStylesheets().removeAll(
          Game_c.class.getResource("dark.css").toExternalForm());
                scene.getStylesheets().add(
          Game_c.class.getResource("blue.css").toExternalForm());
        }
        else if(new_val.contains("Dark")){ 
          scene.getStylesheets().removeAll(
          Game_c.class.getResource("blue.css").toExternalForm());
          
            scene.getStylesheets().add(
          Game_c.class.getResource("dark.css").toExternalForm());
        }
        new_val=null;
        });
         
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
       
    }
    
    
    ObservableList get_items()
    {String []item_name=players[player_num].get_name_items();
            
    ObservableList o=FXCollections.observableArrayList(
    );
    for(i=0;i<20;i++){
    if(!item_name[i].equals("")){
    o.add(item_name[i]);
    }
    }
    return o;
    
    }
    ObservableList show_store(HashMap<Integer,String> h1){
   // HashMap<Integer,String> h1=new HashMap<Integer,String>();
    
    ObservableList o=FXCollections.observableArrayList(
         h1.get(1),h1.get(2),h1.get(3),h1.get(4),h1.get(5)
          );
    return o;
    }
    
    HashMap get_store(){
    HashMap<Integer,String> h1=new HashMap<Integer,String>();
    h1=s.print();
    return h1;
    }
    
    
    void buy_in_store(String name){
    Champoin c=new Champoin(name);
    c=s.buy(name, 200);
    if(c!=null){
    //add in player
     System.out.println("choise");
     name_cham=name;
    }
    }
    void change_btn(Button button1){
    button1.setText("bbbb");
    }
    
    void delete_arena(){
   // System.out.println("xxxxxxxxxx ");
                        
        int []pos=new int[2];
        HashMap<Integer,Champoin>cham_l;
            for(int i=0;i<players.length;i++){
            if(players[i]!=null){
                cham_l=players[i].get_champoins_list();
            if(!cham_l.isEmpty()){
    //          System.out.println("mmmmmmk="+cham_l.size());
       
                for(int k=1;k<=cham_l.size();k++){
              //System.out.println("mmmmmmk="+k);
                pos=cham_l.get(k).get_pos();
         //       System.out.println("2aaaaa "+k);
                btn[pos[0]][pos[1]].setText("");
                
            }
            }
            }
            }
    
            
    }
    
    
    
    void show_arena(){
    //System.out.println("zzzzzzzzzzz ");
        int []pos=new int[2];
    HashMap<Integer,Champoin>cham_l;
        for(int i=0;i<players.length;i++){
            if(players[i]!=null){
            cham_l=players[i].get_champoins_list();
            
            for(int k=1;k<=cham_l.size();k++){
              //  System.out.println("mmmmmmk="+k);
                pos=cham_l.get(k).get_pos();
                if(btn[pos[0]][pos[1]].getText().equals(""))
                btn[pos[0]][pos[1]].setText((i+1)+"/"+cham_l.get(k).get_name());
                else
                {btn[pos[0]][pos[1]].setText(btn[pos[0]][pos[1]].getText()+"\n"+(i+1)+"/"+cham_l.get(k).get_name());}
            }
            }
        }
        
        
    
    
    }
    
    
    
    
    void check_loser(player []players){
    int i,j;
    for(i=0;i<players.length;i++){
    if(players[i]!=null){
    HashMap<Integer,Champoin> champoins_list=players[i].get_champoins_list();
    if(champoins_list.isEmpty())
    {
    players[i]=null;
    System.out.println("player "+(i+1)+" out of game !!");
    }
    }
    
    }
      
    }
    
    
    
    
    boolean check_winner(player []players){
    int i,j=0,w=0;
    for(i=0;i<players.length;i++){
       // System.out.print("11check_winner = "+i);
    if(players[i]!=null){
       // System.out.print("check_winner = "+i);
    j++;
    w=i;
    }
    }
    if(j==1){
    System.out.print("\n\n\tgreat player "+w+" !! you win ");    
    return true;
    }
    else{
    return false;
    }
    
    }
    boolean no_player(){
    int i;
    for(i=0;i<players.length;i++){
    if(players[i]!=null){
    return false;
    }
    
    }
    return true;
    } 
    

    void give_sqeare_type(){
    
            for (i = 0; i < size_board[0]; i++) {
            for ( j = 0; j < size_board[1]; j++) {
             // System.out.println("hhhhhh");
                btn[i][j].setStyle("-fx-border-width: 8 ;");
            if(btn_type[i][j].contains("Terrain")){btn[i][j].setStyle("-fx-background-color: black;");}
            else if(btn_type[i][j].contains("Standard")){btn[i][j].setStyle("-fx-background-color: red;");}
            else if(btn_type[i][j].contains("Grass")){btn[i][j].setStyle("-fx-background-color: green;");}
            else if(btn_type[i][j].contains("Water")){btn[i][j].setStyle("-fx-background-color: blue;");}
            
            }}
    
    }
    
    
    boolean load_one_round(){
    
                    time_line.stop();
                    
                    
                            
                    //System.out.println("round"+round+"player_num"+player_num+"time"+time);
                    try {        
                            save_ga=data_to_load.load_round(round,player_num,time,choise_game);
                        } catch (IOException ex) {
                            Logger.getLogger(Game_c.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(Game_c.class.getName()).log(Level.SEVERE, null, ex);
                        }
//                  
                    if(save_ga==null){return false;}
                    
                    
                    
                    size_board[1]=save_ga.board_h;
                    size_board[0]=save_ga.board_w;
                          
                          swap_num=save_ga.swap;
                          const_swap=save_ga.max_swap;
                          max_round=save_ga.max_round;
                         //System.out.print("max_round "+max_round);
                          players=save_ga.players;
                          
                          
                          bots=save_ga.bots;
                         
                          
                          player_num=save_ga.player_num;
                          
                          s=save_ga.s;
                          btn_type=save_ga.btn_type;
                         // System.out.println("121212bot" + ((Integer.parseInt(player_text.getText().toString()))-(Integer.parseInt(bot_text.getText().toString()))));
                
                    
                    
                    time_line.setCycleCount(Timeline.INDEFINITE);
                time_line.play();
                
    return true;
    }
    
    
    boolean load_first_round(){
        time_line.stop();
                                
        System.out.println("round"+round+"player_num"+player_num+"time"+time);
                    try {        
                            save_ga=data_to_load.load_round(round,player_num,time,choise_game);
                        } catch (IOException ex) {
                            Logger.getLogger(Game_c.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(Game_c.class.getName()).log(Level.SEVERE, null, ex);
                        }
//                  
                    if(save_ga==null){return false;}
                    
                    

                    size_board[1]=save_ga.board_h;
                    size_board[0]=save_ga.board_w;
                          
                          swap_num=save_ga.swap;
                          const_swap=save_ga.max_swap;
                          max_round=save_ga.max_round;
                         //System.out.print("max_round "+max_round);
                          players=save_ga.players;
                          
                          
                          bots=save_ga.bots;
                         
                          
                          player_num=save_ga.player_num;
                          
                          s=save_ga.s;
                          btn_type=save_ga.btn_type;
                         // System.out.println("121212bot" + ((Integer.parseInt(player_text.getText().toString()))-(Integer.parseInt(bot_text.getText().toString()))));
return true;
    
           }
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    



void start_game(){



    
         
        //first labels
        Button save_btn = new Button("save");
        Label player_label=new Label("player:"+(player_num+1));
        coins_label.setText("player coins:"+players[player_num].get_coins());
        Label round_label=new Label("round:"+(round+1));
        time_label.setText("time:");
        Label store_label=new Label("store:");
        Label bench_label=new Label("bench:");
         
        Label order_label=new Label("order : ");
         
        Label tiers_label=new Label("tiers:");
         
        ScrollPane board2=new ScrollPane();
           
        Label item_label=new Label("items:");
            
//TextField order_text=new TextField();
        player_label.setTranslateX(200);
        coins_label.setTranslateX(200);
        round_label.setTranslateX(500);
        time_label.setTranslateX(800);
        save_btn.setTranslateX(910);
        //order_text.setTranslateX(850);
        //order_text.setTranslateY(600);
        player_label.setTranslateY(10);
        coins_label.setTranslateY(30);
        round_label.setTranslateY(20);
        time_label.setTranslateY(20);
        save_btn.setTranslateY(13);
        save_btn.setMinSize(60,30);
        
        
        
                save_btn.setOnAction(new EventHandler<ActionEvent>() {

                    @Override
            public void handle(ActionEvent event) {
                    //save players store .....
                    time_line.stop();
                         try {
                            data_to_save.last_save_object(round,player_num,time,new save(players,player_num,round,time,max_round,s,size_board[0],size_board[1],swap_num,const_swap,bots,btn_type));
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(Game_c.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        try {
                            data_to_save.last_save_object(round,player_num,time,null);
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(Game_c.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    //System.out.println("round= "+round+" (player_num+1)*time= "+(player_num+1)*time+" ((player_num+1)*time)+1= "+(((player_num+1)*time)+1));
                    time=-1;
                    t.stop();
                    return;
                     
                    }});
                    

                    //store
        
        
            
            list_items_o=FXCollections.observableArrayList(
            ""
            );
//            22
            list_items.setItems(list_items_o);
            
          
            
          list_items.setTranslateX(860);
          list_items.setTranslateY(570); 
          item_label.setTranslateX(857);
          item_label.setTranslateY(550);
          list_items.setPrefSize(135,77);  

            
          
          list_store.setMinWidth(100);
          list_store.setPadding(new Insets(5,5,5,5));
          store_label.setPrefSize(500,50);
          list_store.setPrefSize(500,50);
          
          store_label.setTranslateX(300);
          store_label.setTranslateY(600);
          list_store.setOrientation(Orientation.HORIZONTAL);
          list_store.setTranslateX(350);
          list_store.setTranslateY(600);
           
//           22
           //bench
           
          /**HashMap<Integer,String>s2=new HashMap<Integer,String>();
          s2.put(1, "Orientat\nion");
          s2.put(2, "dddd");
            **/
          
          list_bench.setItems(list_bench_o);
          
          
          list_bench.setMinWidth(500);
          list_bench.setPadding(new Insets(5,5,5,5));
          bench_label.setPrefSize(50,50);
          list_bench.setPrefSize(500,50);
          
          bench_label.setTranslateX(300);
          bench_label.setTranslateY(550);

          list_bench.setOrientation(Orientation.HORIZONTAL);
          list_bench.setTranslateX(350);
          list_bench.setTranslateY(550);
        
          HashMap<Integer,String> first_store=new HashMap<Integer,String>();
          

            
            //order 
          
         if(round<9){ 
         list_order_o=FXCollections.observableArrayList(
         "sell","buy"
          );
         }else{
            list_order_o=FXCollections.observableArrayList(
            "sell","buy","move to left","move to right","move to up","move to down","do Ability","choise the specified champoin"
            );

         }
              list_order.setItems(list_order_o);
          
              order_label.setTranslateX(130);
              order_label.setTranslateY(550);
              list_order.setTranslateX(130);
              list_order.setTranslateY(570);
              
              list_order.setPrefSize(150,70);
          
          
          
           
           //tiers
           /**
             HashMap<Integer,String>s3=new HashMap<Integer,String>();
          s1.put(1, "bbb");
          s1.put(2, "dddd");
   **/         
            list_tiers_o=FXCollections.observableArrayList(
         "player "+(player_num+1),
         "in arena:"+players[player_num].get_num_champ(),
         "in bench:"+players[player_num].get_num_bench_champ(),
         "classes : "
          );
          
           HashMap<Integer,String> name_class_champoins=players[player_num].get_name_class_champoins();
           HashMap<String,Integer> num_class_champoins=players[player_num].get_num_class_champoins();
           //String []t_m=new String[10];
           //int []t_n=new int[10];
           if(!name_class_champoins.isEmpty()){
           for(int j=1;j<=name_class_champoins.size();j++){
           list_tiers_o.add(name_class_champoins.get(j)+": "+num_class_champoins.get(name_class_champoins.get(j)));
           }
           
           }  
          
          list_tiers.setItems(list_tiers_o);
          //list_store.fixedCellSizeProperty();
          list_tiers.setFixedCellSize(40);
          list_tiers.setMinWidth(100);
          list_tiers.setPadding(new Insets(5,5,5,5));
          tiers_label.setPrefSize(70,70);
          list_tiers.setPrefSize(70,650);
          
          tiers_label.setTranslateX(10);
          tiers_label.setTranslateY(-20);
          //list_tiers.setOrientation(Orientation.HORIZONTAL);
          list_tiers.setTranslateX(10);
          list_tiers.setTranslateY(25);
        
           
           
           
           
           
          //board
           
           

          GridPane board=new GridPane();
           
           btn = new Button[100][100];
           btn_type= new String[100][100];
       //    btn_mat = new Button[100][100];
           int m,n;
           String type="";
           Random r2=new Random();
           
           
        for (i = 0; i < size_board[0]; i++) {
            for ( j = 0; j < size_board[1]; j++) {

                if(!watch_mode && !save_mode){
                Random r=new Random();
                int z=r2.nextInt(7);
//                                22
                                
                               
                  if(z==0||z==4){type="Standard";}
                  if(z==1||z==5){type="Grass";}
                  if(z==2){type="Terrain";}
                  if(z==3||z==6){type="Water";}
                                
                                
                btn_type[i][j]=type;
                }
                
                btn[i][j] = new Button("");
              // btn[i][j].setStyle("-fx-border-color: black;");
               // btn[i][j].setStyle("-fx-border-width: 0 3 3 0;");
               
                
                //btn[i][j].setBorder(new Border(Color.BLACK,BorderStrokeStyle.SOLID,CornerRadii.EMPTY,BorderWidths.DEFAULT));
                //btn[i][j].setStyle("-fx-background-color: #ff0000;");
                btn[i][j].setMinSize(60, 60);
                btn[i][j].setMaxSize(60, 60);
                //if(i>9){m=}
                btn[i][j].setId(i+"b"+j);
                
                int s=0;
                btn[i][j].setOnAction(new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent event) {
                     
                        if(!bot_on&& time!=-1){
                        list_tiers_o=FXCollections.observableArrayList(
                        "");
                        if(!(((Button) event.getSource()).getText().equals("")))
                        {
                            
                            int i=0;
                        String h = ((Button) event.getSource()).getId();
                        int t=h.indexOf("b");
                            String h1=h.substring(0, t);
                            String h2=h.substring(t+1);
                   
                        int x=Integer.parseInt(""+h1);
                        int y=Integer.parseInt(""+h2);
                        HashMap <Integer,Champoin>champoin_target;
                        for(i=0;i<players.length;i++){
                            if(players[i]!=null){
                        champoin_target=players[i].get_champoins_list();
                        if(!champoin_target.isEmpty()){
                          int j;
                            int []pos=new int[2];
                        for(j=1;j<=champoin_target.size();j++){
                        pos=champoin_target.get(j).get_pos();
                        if(pos[0]==x&&pos[1]==y){
                            //System.out.println("qqqqqqq");
                            if(i==(player_num)){
                                String []s1=new String[3];
                                s1=champoin_target.get(j).get_his_class();
                                    for(int m=0;m<3;m++){
                                    if(s1[m]==null){s1[m]=" ";}}
                            
                               
                                if(list_tiers_o.contains("")){
                                    
                                list_tiers_o=FXCollections.observableArrayList(
                                    
                                    champoin_target.get(j).get_name(),
                                    "player : "+(i+1),
                                    "health : "+String.valueOf(champoin_target.get(j).get_health()),
                                    "armor : "+String.valueOf(champoin_target.get(j).get_armor()),
                                    "damage :"+String.valueOf(champoin_target.get(j).get_attack_damage()),
                                    "att range :"+String.valueOf(champoin_target.get(j).get_attack_range()),
                                    "mena : "+String.valueOf(champoin_target.get(j).get_mena()),
                                    "mena cost: "+String.valueOf(champoin_target.get(j).get_cost_mena()),
                                    "C.s chance: "+String.valueOf(champoin_target.get(j).get_str_chance()),
                                    "price : "+String.valueOf(champoin_target.get(j).get_price()),
                                    "level : "+String.valueOf(champoin_target.get(j).get_level()+1),
                                    "his classes :",
                                    "  "+s1[0]+"/"+s1[1]+"\n  "+s1[2]
                            
                            );
                                String []item_name=champoin_target.get(j).get_items_name();
                                if(!item_name[0].equals(""))
                                {
                                    list_tiers_o.add("items: ");
                                    for(int q=0;q<3;q++){
                                    if(!item_name[q].equals("")){
                                    list_tiers_o.add(" "+item_name[q]);
                                    }
                                    }
                                    
                                }
                                }
                                else{
                                   // System.out.println("qweqwe");
                                list_tiers_o.addAll("\n",
                                    champoin_target.get(j).get_name(),
                                    "player : "+(i+1),
                                    "health : "+String.valueOf(champoin_target.get(j).get_health()),
                                    "armor : "+String.valueOf(champoin_target.get(j).get_armor()),
                                    "damage :"+String.valueOf(champoin_target.get(j).get_attack_damage()),
                                    "att range :"+String.valueOf(champoin_target.get(j).get_attack_range()),
                                    
                                    "mena : "+String.valueOf(champoin_target.get(j).get_mena()),
                                    "mena cost: "+String.valueOf(champoin_target.get(j).get_cost_mena()),
                                    "C.s chance: "+String.valueOf(champoin_target.get(j).get_str_chance()),
                                    "price : "+String.valueOf(champoin_target.get(j).get_price()), 
                                    "level : "+String.valueOf(champoin_target.get(j).get_level()+1),
                                    "his classes:"+"\n"+s1[0]+" "+s1[1]+" "+s1[2]
                                     
                                );
                                
                                String []item_name=champoin_target.get(j).get_items_name();
                                if(!item_name[0].equals(""))
                                {
                                    list_tiers_o.add("items : ");
                                    for(int q=0;q<3;q++){
                                    if(!item_name[q].equals("")){
                                    list_tiers_o.add(" "+item_name[q]);
                                    }
                                    }
                                    
                                }
                                
                                }
                                    }
                            else{
                                if(list_tiers_o.contains("")){
                                list_tiers_o=FXCollections.observableArrayList(
                                    
                                    champoin_target.get(j).get_name(),
                                    "player : "+(i+1),
                                    "health : "+String.valueOf(champoin_target.get(j).get_health()),
                                    "damage :"+String.valueOf(champoin_target.get(j).get_attack_damage()),
                                   
                                    "level : "+String.valueOf(champoin_target.get(j).get_level()+1)
                                    
                            
                            );
                                }
                                else{
                                
                                    list_tiers_o.addAll("\n",
                                    champoin_target.get(j).get_name(),
                                    "player : "+(i+1),
                                    "health : "+String.valueOf(champoin_target.get(j).get_health()),
                                    "damage :"+String.valueOf(champoin_target.get(j).get_attack_damage()),
                                    "level : "+String.valueOf(champoin_target.get(j).get_level()+1)
                                    );
                                    
                                    
                                }
                            }
                                    }
                        
                        }
                        
                        
                        
                        }
                        }
                        }
                        
                        
                        
                        
                        }
                        else{//System.out.println("qqqqqqqvvvvvvvvv");
                            list_tiers_o=FXCollections.observableArrayList(
                            "player "+(player_num+1),
                            "in arena:"+players[player_num].get_num_champ(),
                            "in bench:"+players[player_num].get_num_bench_champ(),
                            "classes : "
                            );
          
            HashMap<Integer,String> name_class_champoins=players[player_num].get_name_class_champoins();
             HashMap<String,Integer> num_class_champoins=players[player_num].get_num_class_champoins();
           //String []t_m=new String[10];
           //int []t_n=new int[10];
           if(!name_class_champoins.isEmpty()){
           for(int j=1;j<=name_class_champoins.size();j++){
           list_tiers_o.add(name_class_champoins.get(j)+": "+num_class_champoins.get(name_class_champoins.get(j)));
           }
           
           }  
          
          
         
                        }
                        
     
                        if(cham_bench_name==null){cham_bench_name="";}
                        

                        if(!cham_bench_name.equals("") && swap_num>0)
                        {//System.out.println("qqqqqqqqwqwqwqwqwq222222");
                            String h = ((Button) event.getSource()).getId();
                            int t=h.indexOf("b");
                            String h1=h.substring(0, t);
                            String h2=h.substring(t+1);
                            //System.out.println("h1="+h1);
                            //System.out.println("h2="+h2);
                            if(players[player_num].max_game_champon()&&((Button) event.getSource()).getText().equals(""))
                            {System.out.println("max champoins in arena !! you can only swap");}    
                            else {
                                Random r=new Random();
                                int z=r.nextInt(6);
//                                22
                                item n_i=null;
                                if(round>=9){n_i=null;}
                                else{
                                if(z==0){n_i=angry_cloak_item;}
                                if(z==1){n_i=knight_armor_item;}
                                if(z==2){n_i=magic_hat_item;}
                                if(z==3){n_i=night_shift_item;}
                                if(z==4){n_i=universe_core_item;}
                                if(z==5){n_i=void_hit_item;}
                                if(z==6){n_i=warrior_gloves_item;}
                                }
                               if(!((Button) event.getSource()).getText().contains("")){n_i=null;} 
                                
                                players[player_num].swap(round,cham_bench_name,((Button) event.getSource()).getText(),Integer.parseInt(""+h1),Integer.parseInt("" + h2),n_i);
                                    //System.out.println("h.charAt(0)"+Integer.parseInt(""+h.charAt(0))+" i="+i);
                                    //System.out.println("h.charAt(1)"+Integer.parseInt(""+h.charAt(1))+" i="+j);
               ObservableList<String> list_temp_o=list_bench_o;
   
                list_bench_o=FXCollections.observableArrayList(
                               "");
                list_bench.setItems(list_bench_o);
                list_bench_o=list_temp_o;
                list_bench.setItems(list_bench_o);
                
                ((Button) event.getSource()).setText("");}

                            if(((Button) event.getSource()).getText().equals(""))
                            {cham_to_order="";}
                            else{cham_to_order=((Button) event.getSource()).getText();}
                        cham_bench_name="";
                        swap_num--;
                        }
                        else if(!choise_item.equals("") && cham_bench_name.equals("")){
                            //System.out.println("321321you get a new item to champoin !!");
                                
                            if(!((Button) event.getSource()).getText().equals("")){
                            //System.out.println("456456you get a new item to champoin !!");
                               //22    
                               /** if(choise_item.contains("Magic Hat")){
                                players[player_num].set_item_in_champoin_by_name(magic_hat_item,((Button) event.getSource()).getText(),round);
                                }
                                **/
                                
                                if(choise_item.contains("Angry cloak")){
                                   players[player_num].set_item_in_champoin_by_name(angry_cloak_item,((Button) event.getSource()).getText(),round);
                                                        }
                                else if(choise_item.contains("Knight Armor")){
                                players[player_num].set_item_in_champoin_by_name(knight_armor_item,((Button) event.getSource()).getText(),round);
                                }
                                else if(choise_item.contains("Magic Hat")){
                                players[player_num].set_item_in_champoin_by_name(magic_hat_item,((Button) event.getSource()).getText(),round);
                                }
                                else if(choise_item.contains("Night Shift")){
                                players[player_num].set_item_in_champoin_by_name(night_shift_item,((Button) event.getSource()).getText(),round);
                                }
                                else if(choise_item.contains("Universe Core")){
                                players[player_num].set_item_in_champoin_by_name(universe_core_item,((Button) event.getSource()).getText(),round);
                                }
                                else if(choise_item.contains("Void Hit")){
                                players[player_num].set_item_in_champoin_by_name(void_hit_item,((Button) event.getSource()).getText(),round);
                                }
                                else if(choise_item.contains("Warrior Gloves")){
                                players[player_num].set_item_in_champoin_by_name(warrior_gloves_item,((Button) event.getSource()).getText(),round);
                                }
            
                                
                                
                                
                                
                                choise_item="";
                            }
                        }
                        else if(swap_num<=0){System.out.println("maximum number of swap !!");}
                        
                        
 
                        if(((Button) event.getSource()).getText().equals(""))
                            {cham_to_order="";}
                            else{cham_to_order=((Button) event.getSource()).getText();}
 
                        }//bot off
                    }});
                
                
                board.add(btn[i][j],j,i);
            }
        }
        //btn[1][1].setStyle("-fx-border-color: green;");
                
       //board.setStyle("-fx-border-color:#1d1d1d;");
        board.setId("buttons_board");
        board2.setId("buttons_board2");
        board.setMinSize(840, 480);
        board2.setContent(board);
        i=0;j=0;
         
           board2.setTranslateX(150);
           board2.setTranslateY(50);
           board2.setMaxSize(850, 490);
           board2.setMinSize(850, 490);
           
       
           
        
     
            //btn[i][j].setText(temp.getText());
            //temp.setText("");
            
           
           
           
            
          if(!watch_mode && !save_mode){
           first_store=get_store();
           list_store_o=show_store(first_store);
           list_store.setItems(list_store_o);
            try {
                data_to_save.save_object(round,player_num,time,new save(players,0,0,0,max_round,s,size_board[0],size_board[1],swap_num,const_swap,bots,btn_type));
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Game_c.class.getName()).log(Level.SEVERE, null, ex);
            }

          }
          else{
           
              list_store_o=FXCollections.observableArrayList(
             ""
            );
              list_store_o.removeAll(list_store_o);
               //get store from iostrem
              HashMap<Integer,String> h1=s.get_h1();
               //System.out.println("h1="+h1.get(1));
              for(int y=1;y<=h1.size();y++){
               //   System.out.println("h1="+h1.get(y));
              list_store_o.add(h1.get(y));
              }}
              
              list_store.setItems(list_store_o);
          
           
           
                        if(bots[player_num] && !watch_mode)
                          {//System.out.println("777bots[0]");
                             bot_on=true;
                             if(save_mode){one_bot=new bot(round,s,s.get_h1(),players);}
                             else{ one_bot=new bot(round,s,first_store,players);}
                            one_bot.set_player(players[player_num]);
                            t=new Thread(one_bot);
                            t.start();
                          player_label.setText("player(bot): "+(player_num+1));}  
          

           
           
         
        /**for (int i = 0; i < 17; i++) {
            for (int j = 0; j < 11; j++) {
          board.getChildren().add(btn[i][j]);
            }}**/
           root.getChildren().add(save_btn);
           root.getChildren().add(player_label);
           root.getChildren().add(round_label);
           root.getChildren().add(time_label);
           root.getChildren().add(coins_label);
//           root.getChildren().add(order_text);
            
            
          root.getChildren().add(store_label);
          root.getChildren().add(list_store);
          
          root.getChildren().add(bench_label);
          root.getChildren().add(list_bench);
         // root.getChildren().add(bench_choise);
          root.getChildren().add(order_label);
          root.getChildren().add(list_order);
         
          
          root.getChildren().add(tiers_label);
          root.getChildren().add(list_tiers);
          
          root.getChildren().add(board2);
        
          root.getChildren().add(list_items);
          root.getChildren().add(item_label);
        
        
          //items choise
          list_items.getSelectionModel().selectedItemProperty().addListener(
        (ObservableValue<? extends String>ov, String old_val, String new_val)->{
        if(!watch_mode){
          
            if(!bot_on){
            if(new_val==null){new_val="";}
            choise_item=new_val;
            //System.out.println("choise_item"+choise_item);

            }
        }
        });
        




// bench_choise
        list_bench.getSelectionModel().selectedItemProperty().addListener(
        (ObservableValue<? extends String>ov, String old_val, String new_val)->{
      // bench_choise.setText(new_val);
        
            if(!watch_mode){
          
            if(!bot_on){
            //show in tires
            
             HashMap <Integer,Champoin>champoin_target;
                       i=player_num;
                champoin_target=players[i].get_bench_list();
                
                if(new_val==null){new_val="";}
                for(j=1;j<=champoin_target.size();j++){
                if(champoin_target.get(j).get_name().contains(new_val)){
                break;}
                
                }
                if(!champoin_target.isEmpty()){
                        
                                list_tiers_o=FXCollections.observableArrayList(
                                    
                                    champoin_target.get(j).get_name(),
                                    "player : "+(i+1),
                                    "health : "+String.valueOf(champoin_target.get(j).get_health()),
                                    "armor : "+String.valueOf(champoin_target.get(j).get_armor()),
                                    "damage :"+String.valueOf(champoin_target.get(j).get_attack_damage()),
                                    "att range :"+String.valueOf(champoin_target.get(j).get_attack_range()),
                                    "mena : "+String.valueOf(champoin_target.get(j).get_mena()),
                                    "mena cost: "+String.valueOf(champoin_target.get(j).get_cost_mena()),
                                    "C.s chance: "+String.valueOf(champoin_target.get(j).get_str_chance()),
                                    "price : "+String.valueOf(champoin_target.get(j).get_price()),
                                    "level : "+String.valueOf(champoin_target.get(j).get_level()+1)
                
                                    
                                    );
                                String []item_name=champoin_target.get(j).get_items_name();
                                if(!item_name[0].equals(""))
                                {
                                    list_tiers_o.add("items: ");
                                    for(int q=0;q<3;q++){
                                    if(!item_name[q].equals("")){
                                    list_tiers_o.add(" "+item_name[q]);
                                    }
                                    }
                                    
                                
                                     }
            
            
                }
//            88
            if(choise_item==null){choise_item="";}
            if(!choise_item.equals("")){
            
//            22
            if(choise_item.contains("Angry cloak")){
            players[player_num].set_item_in_bench_by_name(angry_cloak_item,new_val,round);
            }
            else if(choise_item.contains("Knight Armor")){
            players[player_num].set_item_in_bench_by_name(knight_armor_item,new_val,round);
            }
            else if(choise_item.contains("Magic Hat")){
            players[player_num].set_item_in_bench_by_name(magic_hat_item,new_val,round);
            }
            else if(choise_item.contains("Night Shift")){
            players[player_num].set_item_in_bench_by_name(night_shift_item,new_val,round);
            }
            else if(choise_item.contains("Universe Core")){
            players[player_num].set_item_in_bench_by_name(universe_core_item,new_val,round);
            }
            else if(choise_item.contains("Void Hit")){
            players[player_num].set_item_in_bench_by_name(void_hit_item,new_val,round);
            }
            else if(choise_item.contains("Warrior Gloves")){
            players[player_num].set_item_in_bench_by_name(warrior_gloves_item,new_val,round);
            }
                                    
             end_choise=true;
            
             
            
            }
            else{
        cham_bench_name=new_val;
        }
        }
        
        }//watch
        }
        );
        
        //btn[1][2].setText("kkkk");
         
        
        
        // store_choise
        list_store.getSelectionModel().selectedItemProperty().addListener(
        (ObservableValue<? extends String>ov, String old_val, String new_val)->{
      //bench_label.setText(new_val);
            if(!watch_mode){
          
            if(!bot_on && new_val!=null){
                //show champ
      ObservableList<String> list_temp_o=list_bench_o;
   
                list_bench_o=FXCollections.observableArrayList(
                               "");
                list_bench.setItems(list_bench_o);
            
                list_bench.setItems(list_temp_o);
                
                //System.out.println("5555new_val"+new_val);
                Champoin c=new Champoin(new_val);
                c.set_name(new_val);
                    String []s1=new String[3];
                                s1=c.get_his_class();
                                    for(int z=0;z<3;z++){
                                    if(s1[z]==null){s1[z]=" ";}}
                list_tiers_o.removeAll(list_tiers_o);
                list_tiers_o=FXCollections.observableArrayList(
                                    
                                    //champoin_target.get(j).get_name(),
                                    //"player : "+(i+1),
                                    "health : "+String.valueOf(c.get_health()),
                                    "armor : "+String.valueOf(c.get_armor()),
                                    "damage :"+String.valueOf(c.get_attack_damage()),
                                   // "mena : "+String.valueOf(champoin_target.get(j).get_mena()),
                                    "price : "+String.valueOf(c.get_price()), 
                                    //"level : "+String.valueOf(champoin_target.get(j).get_level()+1),
                                    "classes :",
                                    "  "+s1[0]+"/"+s1[1]+"\n  "+s1[2]
                            
                            );
                            //dd
                            if(new_val==null){new_val="";}
                            if(players[player_num].check_have_champoin(new_val))
                            {
                                list_tiers_o.add("note:");
                                list_tiers_o.add("upgrade to\nnew level");
                            }
                            else{
                            HashMap<String,Integer> num_class_champoin=players[player_num].get_num_class_champoins();
                            String []classes=c.get_his_class();
                            list_tiers_o.add("note:");    
                            for(int r=0;r<3;r++){
                            
                                if(classes[r]!=null&&!classes[r].equals(" ")){
                                 //System.out.println("classes[r]"+r+" v "+classes[r]);
                                    if(num_class_champoin.get(classes[r])!=null)
                                    //for(int p=1;p<=num_class_champoin.size();p++){
                                //if(players[player_num].
                            {
                                //list_tiers_o.add("note:");
                                list_tiers_o.add("you will have\n"+(num_class_champoin.get(classes[r])+1)+" "+classes[r]);
                            }
                                    else{
                                    list_tiers_o.add("first champoin\nin "+classes[r]);
                            
                                    }
                            //}
                                }
                            }
                            }
                            
            name_cham=new_val;
            //buy_in_store(new_val);
        }
        }
        }
        );
        
        //order
        list_order.getSelectionModel().selectedItemProperty().addListener(
        (ObservableValue<? extends String>ov, String old_val, String new_val)->{
        
            if(!watch_mode){
          
            if(!bot_on){
//            System.out.println("cham_bench_name"+cham_bench_name);
            if(cham_bench_name==null){cham_bench_name="";}
            if(cham_to_order==null){cham_to_order="";}
            if(new_val==null){new_val="";}
            if(!cham_bench_name.equals("")&&new_val.equals("sell"))
            {
            (new planning(players[player_num],s,name_cham)).sell_champ(cham_bench_name);
            cham_bench_name="";}
                
                if(name_cham==null){name_cham="";}
                if(new_val==null){new_val="";}
            if(!name_cham.equals("")&&new_val.contains("buy"))
            {
            //buy new champ           
             
                
             (new planning(players[player_num],s,name_cham)).begin(); 
             //name_temp=name_cham;
           
              
                            
             name_cham="";}
            
            
                
                
            if(cham_to_order==null){cham_to_order="";}
            if(new_val==null){new_val="";}
            
            if(!cham_to_order.equals("") && new_val.contains("move") && round>=9)
            {
                if(players[player_num].take_order(cham_to_order, new_val))
                System.out.println("order move taken !!"+cham_to_order);
                cham_to_order="";
            }
            if(cham_to_att==null){cham_to_att="";}
            if(new_val==null){new_val="";}
            if(!cham_to_att.equals("") && !cham_to_order.equals("")&&new_val.contains("attack")&& round>=9)
            {
                //System.out.println("in attack 222222222");
                if(players[player_num].take_order(cham_to_order, new_val+" "+cham_to_att))
                System.out.println("order attack taken !!"+cham_to_order);
                cham_to_order="";
                cham_to_att="";
                      list_order_o=FXCollections.observableArrayList(
         "sell","buy","move to left","move to right","move to up","move to down","do Ability","choise the specified champoin"
          );
                
                      
            }
            if(cham_to_order==null){cham_to_order="";}
            if(new_val==null){new_val="";}
            if(!cham_to_order.equals("")&&new_val.contains("choise the specified champoin")&& round>=9)
            {
                String c_t=cham_to_order.substring(2);;
            
            //System.out.println("1dsadas"+cham_to_order);
             //System.out.println("2dsadas"+c_t);
            String t="attack "+c_t;
                list_order_o=FXCollections.observableArrayList(
                "sell","move to left","move to right","move to up","move to down","do Ability","choise the specified champoin"
                 ,t,"Critical strike");
                
          
            cham_to_att=c_t;
            cham_to_order="";
            }
            if(cham_to_order==null){cham_to_order="";}
            if(new_val==null){new_val="";}
            if(!cham_to_att.equals("")&&!cham_to_order.equals("")&&new_val.contains("Critical strike")&& round>=9)
            {
               HashMap<Integer,Champoin> cham_l=players[player_num].get_champoins_list();
            int k;
            //System.out.println("cham_l.size() "+cham_l.size());
            
            //System.out.println("cham_to_order "+cham_to_order);
            String c_t=cham_to_order.substring(2);;
           int t=0; 
            for(k=1;k<=cham_l.size();k++){
                if(cham_l.get(k).get_name().contains(c_t)){
                t++;
                    break;
                }
            }
            if(t==1){
            //System.out.println("cham_l.get(k).get_name() "+cham_l.get(k).get_name());
            //System.out.println("k="+k);
            if((cham_l.get(k).get_str_chance())==100){
                if(players[player_num].take_order(cham_to_order, new_val+" "+cham_to_att))
                System.out.println("Critical strike order taken !!"+c_t);
                      list_order_o=FXCollections.observableArrayList(
                "sell","buy","move to left","move to right","move to up","move to down","do Ability","choise the specified champoin"
                );
                
                cham_to_order="";
                cham_to_att="";
            }
            else{
                System.out.println("don't have chance yet !!");
            }
            }
            t=0;
            }
            if(cham_to_order==null){cham_to_order="";}
            if(new_val==null){new_val="";}
            //System.out.println("cham_to_order "+cham_to_order);
            //System.out.println("new_val "+new_val);
            if(!cham_to_order.equals("")&&new_val.contains("Ability")&& round>=9)
            {
                //check mena
            HashMap<Integer,Champoin> cham_l=players[player_num].get_champoins_list();
            int k;
            //System.out.println("cham_l.size() "+cham_l.size());
            
            //System.out.println("cham_to_att "+cham_to_att);
            //String c_a=cham_to_att;
            String c_o=cham_to_order.substring(2);
            int t=0;
            for(k=1;k<=cham_l.size();k++){
                if(cham_l.get(k).get_name().contains(c_o)){
                t++;
                    break;
                }
            } 
            if(t==1){
            //cham_l.get(k).set_mena(20);
            if(cham_l.get(k).get_mena()>=cham_l.get(k).get_mena_cost()){
            
                if(players[player_num].take_order(c_o, new_val))
                System.out.println("do ability order taken !!"+c_o);
                
            
            
            cham_to_att="";
            cham_to_order="";
            }
            else{System.out.println("not enough mena");}
            }t=0;
            }
            
            
            //System.out.println("333322222dsadas");
            }
        }
        }
        );
        
        time_line.getKeyFrames().add(new KeyFrame(Duration.seconds(0.1),(ActionEvent event)->{
       //System.out.println("ffff");
        if(time>0){
            if(!watch_mode){
                time_0();
                time_line.stop();
                
                try {
                    //System.out.println("time= "+time);
                    data_to_save.save_object(round,player_num,time,new save(players,player_num,round,time,max_round,s,size_board[0],size_board[1],swap_num,const_swap,bots,btn_type));
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Game_c.class.getName()).log(Level.SEVERE, null, ex);
                }
                time_line.setCycleCount(Timeline.INDEFINITE);
                time_line.play();
                           }
            else{
          

                if(!load_one_round()){
                
                    time_line.stop();
                    time=-1;
                    return;}
                //method to changeing players in this second
            
                if(time%2!=0){
                time_0();
                    
                }
                else{
                    time_label.setText("time: "+time);
            time--;}
            }
           
        }
        
        else{
            // System.out.println("55round = "+round+" time= "+time);
            
            if(!watch_mode){
            try {
                data_to_save.save_object(round,player_num,time,new save(players,player_num,round,time,max_round,s,size_board[0],size_board[1],swap_num,const_swap,bots,btn_type));
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Game_c.class.getName()).log(Level.SEVERE, null, ex);
            }
      
            t.stop();
            list_items_o.removeAll(list_items_o);
            list_items.setItems(list_items_o);
            
            list_store_o.removeAll(list_bench_o);
            list_store.setItems(list_store_o);
            
            if(bot_on){
            
                players[player_num]=one_bot.get_player();
            
               /** t.stop();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Game_c.class.getName()).log(Level.SEVERE, null, ex);
                }
**/
                bot_on=false;
            
            
            }
            
            if(round>=8&&player_num==(players.length-1)){//end player in round
             check_loser(players);
            if(no_player()){
            //data_to_save.save_object(round,player_num,time,new save(players,player_num,round,time,max_round,s,size_board[0],size_board[1],swap_num,const_swap,bots,btn_type));
//            data_to_save.save_thegame("game");
                        
            System.out.println("all players losed !! game over");
             time=-1;
            time_line.stop();
            return;
            }
            if(check_winner(players)){
                 try {
                     data_to_save.save_object(round,player_num,time,new save(players,player_num,round,time,max_round,s,size_board[0],size_board[1],swap_num,const_swap,bots,btn_type));
//                data_to_save.save_thegame("game");
                 } catch (ClassNotFoundException ex) {
                     Logger.getLogger(Game_c.class.getName()).log(Level.SEVERE, null, ex);
                 }
                    
                //System.out.print(" .... game ended !!");
                time=-1;
                time_line.stop();
                return;
                }
            }
            //btn[3][3].setText("kll");
            delete_arena();
            
            //System.out.print("round"+round);
            //System.out.print("player_num"+player_num+"  players.length"+players.length);
            if(round>=9&&player_num==(players.length-1))//player_num==8
            {
              //      System.out.print("kjhjkhkjh");
                
                 time_line.stop();
           /**      
                 //btn[4][4].setText("kll");
           Random r=new Random();
           //int k=r.nextInt(10);
           int []t_i=new int[8];
           t_i[0]=r.nextInt(players.length);
           //System.out.println("r.nextInt("+t_i[0]);
           for(int j=1;j<players.length;j++){
           t_i[j]=r.nextInt(players.length);
           //System.out.println("r.nextInt("+j+"=="+t_i[j]);
           for(int u=0;u<j;u++){
           //System.out.println("r.nextIntuuuu( "+u+"=="+t_i[u]);
               if(t_i[j]==t_i[u]){
           j--;
           break;
           }
           }
           
           }
           **/
           /**for(int i=0;i<players.length;i++)
                    {
                        if(players[t_i[i]]!=null)
                        {
                   //     btn[5][5].setText("kll");
                        System.out.println("player "+((t_i[i])+1)+" execute ");
                        try {
                            Thread.currentThread().sleep(500);
                        } catch (InterruptedException ex) {
             
                        }
                     //   btn[6][6].setText("kll");
                        delete_arena();
                        new execute(players,t_i[i],btn_type);
                        //players[t_i[i]].do_order(players,t_i[i]);
                       // btn[7][7].setText("kll");
           
                        players[t_i[i]].remove_order();
                        
                        
                        show_arena();
                        /**try {
                            Thread.currentThread().sleep(2000);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Game_c.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                    }
                    }**/
                        delete_arena();
                        
                        new execute(players,btn_type);
                        delete_arena();
                        
                        show_arena();
              
                 
                //System.out.print("round "+round+"max_round "+max_round);
                if(round==max_round){
                
                    System.out.print("rounds are over !! no winner .... game ended !!");
                    time=-1;
                    return;
                }    
                check_loser(players);
                //System.out.print("123132132132");
                if(check_winner(players)){
                //System.out.print(" .... game ended !!");
                time=-1;
                return;
                }
                else{
                time_line.setCycleCount(Timeline.INDEFINITE);
                time_line.play();
                //time=60;
            
                }
            }
            else{
                
                time=20;}
            boolean a=true;
            
            if(player_num==(players.length-1)){
                round++;
//                data_to_save.new_round();
                player_num=-1;
                
                while(a)
                {if(players[player_num+1]!=null)
                {player_num++;break;}
                player_num++;}
            }
            else {
                
                while(a)
                {
                if(player_num==(players.length-1)){
                 round++;
  //               data_to_save.new_round();
                player_num=-1;
                }
                    if(players[player_num+1]!=null)
                {player_num++;break;}
                player_num++;}
            }
            //if(player_num==1){bot_on=true;}
            System.out.println("player_num"+(player_num+1));
            players[player_num].increase_coins();
            if(round>=9){
                time=20;
            list_order_o=FXCollections.observableArrayList(
            "sell","buy","move to left","move to right","move to up","move to down","do Ability","choise the specified champoin"
             
            );
              list_order.setItems(list_order_o);
                }
            HashMap<Integer,String> store=new HashMap<Integer,String>();
            store=get_store();
            if(bots[player_num]){
                System.out.println("bots[player_num] "+player_num);
                bot_on=true;
                one_bot=new bot(round,s,store,players);
                one_bot.set_player(players[player_num]);
                t=new Thread(one_bot);
                t.start();}
            
            
            
            round_label.setText("round: "+(round+1));
            if(bot_on){player_label.setText("player(bot): "+(player_num+1));}
            else player_label.setText("player: "+(player_num+1));
            
            
            list_store_o=show_store(store);
            list_store.setItems(list_store_o);
        
            list_tiers_o=FXCollections.observableArrayList(
                        "");
            list_tiers.setItems(list_tiers_o);
            
            ObservableList<String> list_temp_o=list_bench_o;
   
                list_bench_o=FXCollections.observableArrayList(
                               "");
                list_bench.setItems(list_bench_o);
            
               list_bench.setItems(list_temp_o);
   
               
               list_temp_o=list_store_o;
            
                list_store_o=FXCollections.observableArrayList(
                               "");
                list_store.setItems(list_store_o);
            
               list_store.setItems(list_temp_o);
   
            
            
            //time=5;
            name_cham="";
            cham_bench_name="";
            cham_to_order="";
            choise_item="";
            swap_num=const_swap;
//            order_text.setText("");
            list_items_o=get_items();
            list_items.setItems(list_items_o);
            if(round==9){give_sqeare_type();}
                     System.out.println("66round = "+round+" time= "+time);
                 try {
                     data_to_save.save_object(round,player_num,time,new save(players,player_num,round,time,max_round,s,size_board[0],size_board[1],swap_num,const_swap,bots,btn_type));
                     
                     //save :players time round store 
                 } catch (ClassNotFoundException ex) {
                     Logger.getLogger(Game_c.class.getName()).log(Level.SEVERE, null, ex);
                 }
            
        }//watch mode
        
        else{
             
                
            boolean a=true;
            
            if(player_num==(players.length-1)){
                round++;
                player_num=-1;
                
                while(a)
                {if(players[player_num+1]!=null)
                {player_num++;break;}
                player_num++;}
            }
            else {
                
                while(a)
                {
                if(player_num==(players.length-1)){
                 round++;
                player_num=-1;
                }
                    if(players[player_num+1]!=null)
                {player_num++;break;}
                player_num++;}
            }
            
            if(round>=9){
                time=20;
            list_order_o=FXCollections.observableArrayList(
            "sell","buy","move to left","move to right","move to up","move to down","do Ability","choise the specified champoin"
             
            );
              list_order.setItems(list_order_o);
            
            
              check_loser(players);
            if(no_player()){
            
                
                System.out.println("all players losed !! game over");
            time=-1;
            time_line.stop();
            return;
            }
            if(check_winner(players)){
            
//                data_to_save.save_object(round,player_num,time,new save(players,player_num,round,time,max_round,s,size_board[0],size_board[1],swap_num,const_swap,bots,btn_type));
//                data_to_save.save_thegame("game");
                    
                //System.out.print(" .... game ended !!");
                time=-1;
                time_line.stop();
                return;
                }
            
            
            
            
            }
            else{
            time=20;
            }
            
            round_label.setText("round: "+(round+1));
            
            player_label.setText("player: "+(player_num+1));
            
            
                if(!load_one_round()){
                
                    time_line.stop();
                    time=-1;
                    return;}
                list_store_o=FXCollections.observableArrayList(
             ""
            );
              list_store_o.removeAll(list_store_o);
               //get store from iostrem
              HashMap<Integer,String> h1=s.get_h1();
               //System.out.println("h1="+h1.get(1));
              for(int y=1;y<=h1.size();y++){
               //   System.out.println("h1="+h1.get(y));
              list_store_o.add(h1.get(y));
              }
              
              list_store.setItems(list_store_o);
        
            
            
            
            
       
            }            
            
        }
        }));
        time_line.setCycleCount(Timeline.INDEFINITE);
        time_line.play();
                    



}


void time_0(){

            delete_arena();
            
            if(choise_item==null){choise_item="";}
            if(!choise_item.equals("")){
            
                
                ObservableList<String> list_temp_o=list_bench_o;
   
                list_bench_o=FXCollections.observableArrayList(
                               "");
                list_bench.setItems(list_bench_o);
            
               list_bench.setItems(list_temp_o);
   
            
            
            }
            if(end_choise){
             choise_item="";
             end_choise=false;
             }
            
            
            
            
            ObservableList<String> list_temp_o=list_order_o;            
        //    ObservableList<String> list_temp2_o=list_items_o;            
            
            list_order_o=FXCollections.observableArrayList(
             ""
            );

         
            list_items_o=get_items();
            
            list_items.setItems(list_items_o);
              
              
              list_order.setItems(list_order_o);
              list_order_o=list_temp_o;
              
              list_order.setItems(list_order_o);
              if(bot_on){
                players[player_num]=one_bot.get_player();
                      }
            time_label.setText("time: "+time);
            coins_label.setText("player coins: "+players[player_num].get_coins());
            if(list_tiers_o.contains("classes : "))
            {
                //System.out.println("qqqqqqqqqqqq");
                list_tiers_o=FXCollections.observableArrayList(
                            "player "+(player_num+1),
                            "in arena:"+players[player_num].get_num_champ(),
                            "in bench: "+players[player_num].get_num_bench_champ(),
                            "classes : "
                            );
            
           HashMap<Integer,String> nam_class_champoins=players[player_num].get_name_class_champoins();
           HashMap<String,Integer> nu_class_champoins=players[player_num].get_num_class_champoins();
           //String []t_m=new String[10];
           //int []t_n=new int[10];
           if(!nam_class_champoins.isEmpty()){
           for(int j=1;j<=nam_class_champoins.size();j++){
           list_tiers_o.add(nam_class_champoins.get(j)+": "+nu_class_champoins.get(nam_class_champoins.get(j)));
           }
           
           }  
          
            
            }
            String []bench_cham=players[player_num].get_name_bench_list();
            
            list_bench_o=FXCollections.observableArrayList(
            bench_cham[0],bench_cham[1],bench_cham[2],bench_cham[3],bench_cham[4],bench_cham[5],bench_cham[6],bench_cham[7]
            );
            
                        

            
            list_bench.setItems(list_bench_o);
            if(round<9){
            HashMap<Integer,Champoin>cham_l=players[player_num].get_champoins_list();
            int[]pos=new int[2];
            String temp;
            if(!cham_l.isEmpty())
            {for(int k=1;k<=cham_l.size();k++){
                //System.out.println("k="+k);
                pos=cham_l.get(k).get_pos();
            
                temp=btn[pos[0]][pos[1]].getText();
                if(!temp.contains(cham_l.get(k).get_name()))
                btn[pos[0]][pos[1]].setText(cham_l.get(k).get_name()+"\n"+temp);
            }}
            }
            else {delete_arena(); show_arena();}
            
            /**else{btn[pos[0]][pos[1]].setText(cham_l.get(k).get_name());
                }**/
            list_order.setItems(list_order_o);
            list_tiers.setItems(list_tiers_o);
            
        
            
            
            //System.out.print("hereeee2222");
            if(check_second==10){
            time--;
            check_second=0;
            }
            else{
            check_second++;
            }
            

}


}
