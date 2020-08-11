/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg;

import static rpg.Gamelogic.anythingToContinue;
import static rpg.Gamelogic.clearConsole;
import static rpg.Gamelogic.mage;
import static rpg.Gamelogic.printSeperator;
import static rpg.Gamelogic.slowPrint;

/**
 *
 * @author bradf
 */
public class Story {
public static final String RESET = "\u001B[0m";
public static final String BLACK = "\u001B[30m";
public static final String RED = "\u001B[31m";
public static final String GREEN = "\u001B[32m";
public static final String YELLOW = "\u001B[33m";
public static final String BLUE = "\u001B[34m";
public static final String PURPLE = "\u001B[35m";
public static final String CYAN = "\u001B[36m";
public static final String WHITE = "\u001B[37m";
    public static void printIntro(){
		String opening= "Long ago magic was common place and practiced openly \n man used it to shape the world in any way he pleased \n The world began to rely on magic more than technology ,the increase usage of magic began to attract deadly creatures into the world \n The elders created a Great Crystal to contain all magic deemed dangerous and push the demons back into where they came \n it worked but at a great cost..... ";
         
	        printSeperator(30);
		System.out.println( GREEN +"STORY");
		printSeperator(30);
                slowPrint(opening,15,RED);
                anythingToContinue();
    
    
    
    
    
    
    
    
}
public static void act1Intro(){
    String act1 ="You enter a small village rumored to have information on the location of the Legendary artifact";

 printSeperator(30);
		System.out.println( GREEN +"STORY");
		printSeperator(30);
                slowPrint(act1,270,RED);
                anythingToContinue();

}

public static void Oldman(){
     String talk = " Welcome stranger \n What brings you to our humble village";
    printSeperator(30);
  
     slowPrint(talk,265,PURPLE);
     anythingToContinue();
}

public static void Oldman2(){
     String talk = " Yes many have asked for that location and many have not returned \n why do you seek it?";
    printSeperator(30);
  
     slowPrint(talk,265,PURPLE);
     anythingToContinue();
}

public static void Oldman2fight()
{
     String talk ="Power as most seek"+mage.name+"SHOW ME YOUR POWER";
       slowPrint(talk,260,RED);
     anythingToContinue();
}
public static void act2Intro(){
    String act1 ="You find the Cave of Woes and proceed inward";

 printSeperator(30);
		System.out.println( GREEN +"STORY");
		printSeperator(30);
                slowPrint(act1,270,RED);
                anythingToContinue();

}

public static void Oldman2help()
{
    
    String talk ="The location is the very tip of Death mountain"+mage.name+"Good luck!";
           printSeperator(30); 
    slowPrint(talk,260,CYAN);
             anythingToContinue();
}

}