

package items;

import champoins.Champoin;
import java.io.Serializable;


public class item implements Serializable{
    
    Champoin c;
    String name;
    item(Champoin c,String name){
    this.c=c;
    this.name=name;
    }
    public String get_name(){
    return name;
    }
    
}
