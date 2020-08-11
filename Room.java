/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg;
import java.util.ArrayList;
/**
 *
 * @author bradf
 */
public class Room {
    public  int n,s,e,w;
    public  String Name,location;
     ArrayList<Room>  map  = new ArrayList<>();
    
    

     
     Room(String name,String Description,int aN,int aS,int aE,int aW)
    {
        
       Name=name;
       location=Description;
       n=aN;
       s=aS;
       e=aE;
       w=aW;
    
    
    }
    
     public int getN() {
        return n;
    }
    public String getName()
            {
    
    return Name;
             }
    
    public String getDescription(){
    
    return location;
    
}
    
    
    public void setN(int aN) {
        this.n = aN;
    }

    // s
    public int getS() {
        return s;
    }

    public void setS(int aS) {
        this.s = aS;
    }

    // e
    public int getE() {
        return e;
    }

    public void setE(int aE) {
        this.e = aE;
    }

    // w
    public int getW() {
        return w;
    }

    void setW(int aW) {
        this.w = aW;
    }

   
}
