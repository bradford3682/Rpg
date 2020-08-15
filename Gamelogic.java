/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg;

import static java.lang.Math.random;
import java.util.Scanner;
import java.lang.String;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import static rpg.Story.BLUE;
import static rpg.Story.CYAN;
import static rpg.Story.GREEN;
import static rpg.Story.Oldman;
import static rpg.Story.Oldman2;
import static rpg.Story.Oldman2fight;
import static rpg.Story.Oldman2help;
import static rpg.Story.RED;
import static rpg.Story.act1Intro;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static rpg.Story.YELLOW;
import static rpg.Story.printIntro;
import static rpg.Story.act2Intro;
/**
 *
 * @author bradf
 */
public class Gamelogic {
static Mage mage;
static Paladin paladin;
static Scanner scanner = new Scanner(System.in);
 public static boolean Exit=false;

public static int place = 0,act=1,fireMpcost=5,iceMpcost=5,holyMpcost=6,shieldMpcost=10;	//varible ending in mp cost decrease mp pool cannot use spells if mptotal is <=0 
public static String location = BLUE+" enter number to head to location \n 1 for old house \n 2 Tavern, \n 3 Inn";
public static boolean magic=false,holy=false;

public static double rollDice(int min, int max) 
 {
  return min + Math.floor(Math.random() * (max-min + 1));
}
     
Room r2 =new Room("White house", "It is a small white house next to a field", Direction.NOEXIT, Direction.NOEXIT, 0, Direction.NOEXIT);


List <String> commands = new ArrayList<>(Arrays.asList("n","s","e","w"));


public static boolean isRunning=true,Quest=true;
	//method to get user input from console
	public static int readInt(String prompt, int userChoices){
		int input;
		
		do{
			System.out.println(prompt);
			try{
				input = Integer.parseInt(scanner.next());
			}catch(Exception e){
				input = -1;
				System.out.println("Please enter an integer!");
			}
		}while(input < 1 || input > userChoices);
		return input;
	}
	public static String readString(String prompt, String anwser){
            
            String input="";
			
            System.out.println(prompt);
		boolean flag=false;	
            do{
                        try{
				input= scanner.nextLine();
                            
                                
                                if(input ==anwser);
                                     flag=true;
                        }
                        catch(Exception e){
				
				System.out.println("WRONG!!!!!");
			
                        }
            
                        }while(flag==false);
                        return input;
            
            
            }
            
 
            
        
	//method to simulate clearing out the console
	public static void clearConsole(){
		for(int i = 0; i < 100; i++)
			System.out.println();
	}
	
	//method to print a seperator with length n
	public static void printSeperator(int n){
		for(int i = 0; i < n; i++)
			System.out.print("-");
		System.out.println();
	}
	
	//method to print a heading
	public static void printHeading(String title){
		printSeperator(30);
		System.out.println(title);
		printSeperator(30);
	}
	
	//method to stop the game until user enters anything
	public static void anythingToContinue(){
		System.out.println("\nEnter anything to continue...");
		scanner.next();
	}

public static void startGame(){
		
    boolean nameSet = false;
		String name,Class;
		
//print title screen
               int inputs;
		clearConsole();
		printSeperator(40);
		printSeperator(30);
		System.out.println("Legend of ");
		System.out.println("TEXT RPG BY Bradford Mcdaniel");
		printSeperator(30);
		printSeperator(40);
		anythingToContinue();
		
		//getting the mage name
		do{
		      
                  
                   do{
			 printHeading("choose a Class press 1 for mage 2 for Paladin ?");
			try{
				inputs = Integer.parseInt(scanner.next());
			}catch(Exception e){
				inputs = -1;
				System.out.println("Please enter an integer!");
			}
		}while(inputs < 1 || inputs >2);
		
                          
                    clearConsole();
			
                       printHeading("What's your name?");
			name = scanner.next();
			//asking the mage if he wants to correct his choice
			clearConsole();
			printHeading("Your name is " + name + ".\nIs that correct?");
			System.out.println("(1) Yes!");
			System.out.println("(2) No, I want to change my name.");
			int input = readInt("-> " , 2);
			if(input == 1)
				nameSet = true;
		}while(!nameSet);
		
		//create new mage object with the name
		if(inputs==1)
                {
                    mage=new Mage(name);
                    magic=true;
                }
                else if(inputs==2)
                {
                    paladin =new Paladin(name);
                    holy=true;
                }  
            // act1();    
            gameLoop();
                //
              
	}

public static void gameLoop(){
	while(isRunning){
		printMenu();
		int input = readInt("-> ", 3);
		if(input == 1)
                {
                    switch (act) {
                        case 1:
                            act1();
                            break;
                        case 2:
                            act2();
                            break;
                        case 3:
                            act3();
                            break;
                        default:
                            break;
                    }
                }
                
                else if(input == 2)
			characterInfo();
		else
			isRunning = false;
	}	
}
public static void characterInfo(){
	clearConsole();
	printHeading("CHARACTER INFO");
	if(magic==true){
              System.out.println(mage.name + "\tHP: " + mage.hp + "/" + mage.maxHp +" "+ mage.magicpoints+"/"+ mage.maxmagicpoints);
        printSeperator(20);
        }
      
        else if(holy=true){
        System.out.println(paladin.name + "\tHP: " + paladin.hp + "/" + paladin.maxHp+" " + paladin.magicpoints+"/"+ paladin.maxmagicpoints);
        
        }
	printSeperator(20);
		
	//printing the chosen traits
	if(magic==true){ // check which job was chosen
        
            if(mage.numAtkUpgrades > 0)
            {
                    System.out.println("Offensive trait: " + mage.atkUpgrades[mage.numAtkUpgrades - 1]);
		printSeperator(20);
            }
	if(mage.numDefUpgrades> 0)
        {
		System.out.println("Defensive trait: " + mage.defUpgrades[mage.numDefUpgrades - 1]);
                printSeperator(20);
        
        }
        }	
        else if (holy==true)
        {
            
            if(paladin.numAtkUpgrades > 0)
            {
                    System.out.println("Offensive trait: " + paladin.atkUpgrades[paladin.numAtkUpgrades - 1]);
		printSeperator(20);
            }
	if(paladin.numDefUpgrades> 0)
        {
		System.out.println("Defensive trait: " + paladin.defUpgrades[paladin.numDefUpgrades - 1]);
                printSeperator(20);
        
        }
            
            
            
            
            
        }
	anythingToContinue();
}


public static void printMenu(){
	clearConsole();
	
	System.out.println("Choose an action:");
	printSeperator(20);
	System.out.println("(1) Continue on your journey");
	System.out.println("(2) Character Info");
	System.out.println("(3) Exit Game");
}


public static void act1(){
                int choice,choice2, haveVist=0 ,haveVisit2=0;  
                  String awnser="map"; 
    //printIntro();
   //1
   while(Quest){
   //act1Intro();
   choice =readInt(location,4);

        switch(choice){
      case 1:
      {
         System.out.println(BLUE+"you head to the Old house");
         //  Oldman();
         
           System.out.println(BLUE+"You ask about the location of the Cave of Woes ");
         printSeperator(30);
       //  Oldman2();
         System.out.println(BLUE+"pick number to respond /n 1 for (I seek power) /2 for (I wish to bring balance back to the land");
          choice2=readInt("-->",2);
         if (choice2==1)
         {
           
             bossFight1();
              Quest=false;
         }
         if(choice2==2)
         {
              String talk ="The location is the very top of Death mountain Good luck!";
              printSeperator(30); 
             slowPrint(talk,260,GREEN);
            Quest=false;
         }  
         
         break;
      }
      case 2:
      {
           if (haveVist==1){
           System.out.println(BLUE+"you have explored this region already");
               break;
           }
               else{
          System.out.println(BLUE+"you head to the Tavern");
           printSeperator(30); 
           String talk2 = "Barkeep: Welcome Stranger would you like to try one of our local brews? ";
           slowPrint(talk2,260,CYAN);
    
             System.out.println(BLUE+"You ask about the location of the Cave of Woes ");
             printSeperator(30);     
             talk2 = "Cave of Woes? The old man who lives near the woods can help you ";
            
             slowPrint(talk2,260,CYAN);
            printSeperator(30);     
             System.out.println(BLUE+"You leave the Tavern ");
             printSeperator(30);     
             haveVist=1;
           }
             
             break;
      }
      
      case 3:
      {
           System.out.println(BLUE+"you head to the Haunted Woods");
            if(haveVisit2==1){
                break;
            }
            System.out.println(CYAN+"You find a pillar that has a riddle carved near the bottom");
            printSeperator(30);     
            String temp;
            String  talk2 = "I have seas with no water, coast with no sand, towns without people, mountains without land. What am I? ";
            slowPrint(talk2,260,GREEN);
            temp= scanner.next();
            if(temp.equals(awnser))
            {
                 System.out.println(CYAN+"You hear a clicking sound and suddenly the pillar opens up to reveal a map out Death mountain you leave town");
                  Quest=false;  
                 haveVisit2++;
                 act++;
            }
           else
            {
                System.out.println(CYAN+" Pillar does not react maybe we got the wrong anwser maybe we should ask the town elder");
                 
            }
         
               break;   
      }
           
  
      
  }
     act++;
           // finished act 1      
   }
    
             
anythingToContinue();
}





public static void act2()
{
            
  
                                                                       //          N,        S,      W,      E, 
    Room r1 = new Room(" Entrance", " Room with a underground lake inside ", Direction.NOEXIT, 2, Direction.NOEXIT, 1);
    Room r2 = new Room(" Dead end ", "empty room ", Direction.NOEXIT, Direction.NOEXIT, 0, Direction.NOEXIT);
    Room r3 = new Room(" Spike trap ", "walls are closing in!", 0, 4, Direction.NOEXIT, 3);
    Room r4 = new Room(" Sealed door", "Door sealed with a magic power", Direction.NOEXIT, 5, 2, Direction.NOEXIT);
    Room r5 = new Room("Sleeping Dragon", "Don't wake him!", 2, Direction.NOEXIT, Direction.NOEXIT, 5);
    Room r6 = new Room("Exit", "We found the Crystal", 3, Direction.NOEXIT, 4, Direction.NOEXIT);
    
      act2Intro(); // this has to be called after the Arraylist is loaded otherwise the program hangs
    
	
	
     ArrayList<Room>  map  = new ArrayList<>();
     map.add(r1);
     map.add(r2);
     map.add(r3);
     map.add(r4);
     map.add(r5);
     map.add(r6);
System.out.println(BLUE+"map");
printSeperator(30);  
System.out.println(BLUE+"* room0 -- room1 \n |  * room2 -- room3 \n  |    | room4 -- room5"); // this doesn't line up but its the map -- indicates room that is linked to adjacent room.
    int choice=0,dir;
    String lc="",N="";
    boolean havevisit1=false, hasvisit2=false, hasvisit0=false,hasvisit3=false,hasvisit4=false,hasVisit5=false,canGo=false;
   int cantravel,temp;
    while(Exit==false)
    {
        canGo=false;
        switch(choice)
        {
        
            case 0:
        {
            if(havevisit1==true)
                break;
            
            lc  =  r1.getName();
            N =    r1.getDescription();
            System.out.println(lc);
            printSeperator(30);  
            System.out.println(N);
            
            while(canGo==false)
            {
                System.out.println(BLUE+" chose a direction to go 1 for n \n 2 for south \n 3 for e \n and 4 for south");
                dir=readInt("->",4);
            if(dir==1)
           
            {
                cantravel = r1.getN();
                 if(cantravel<0);
                    System.out.println(" Can't go that way!");
                    
                    if(cantravel>0)
                    {
                             choice=r1.getN(); 
                            canGo=true;
                    }   
            }
            if(dir==2)
            {
                  cantravel = r1.getS();
                 if(cantravel<0);
                    System.out.println(" Can't go that way!");
                    if(cantravel>0)
                    {
                        choice=r1.getS(); 
                        canGo=true;
                    }
                 
             }
              if(dir==3)
              {
                  cantravel = r1.getE();
                 if(cantravel<0);
                    System.out.println(" Can't go that way!");
                    if(cantravel>0)
                    {
                        choice=r1.getE(); 
                        canGo=true;
                    }
              
              }
             if(dir==4)
             {
               
                  cantravel = r1.getW();
                 if(cantravel<0);
                    System.out.println(" Can't go that way!");
                    if(cantravel>0)
                    {
                        choice=r1.getW(); 
                        canGo=true;
                    }
              
                 
                 
             }
           
           }
                
              
               
               
               break;
        }
           
        
        
        
    case 1:
         {
        
           if(hasvisit2==true)
                break;
            
            lc  =  r2.getName();
            N =    r2.getDescription();
            System.out.println(lc);
            printSeperator(30);  
            System.out.println(N);
            
            while(canGo==false)
            {
                System.out.println(BLUE+" chose a direction to go 1 for n \n 2 for south \n 3 for e \n and 4 for south");
                dir=readInt("->",4);
            if(dir==1)
           
            {
                cantravel = r2.getN();
                 if(cantravel<0);
                    System.out.println(" Can't go that way!");
                    if(cantravel>0)
                    {
                             choice=r2.getN(); 
                            canGo=true;
                    }   
            }
            if(dir==2)
            {
                  cantravel = r2.getS();
                 if(cantravel<0);
                    System.out.println(" Can't go that way!");
                    if(cantravel>0)
                    {
                        choice=r2.getS(); 
                        canGo=true;
                    }
                 
             }
              if(dir==3)
              {
                  cantravel = r2.getE();
                 if(cantravel<0);
                    System.out.println(" Can't go that way!");
                    if(cantravel>0)
                    {
                        choice=r2.getE(); 
                        canGo=true;
                    }
              
              }
             if(dir==4)
             {
               
                  cantravel = r2.getW();
                 if(cantravel<0);
                    System.out.println(" Can't go that way!");
                    if(cantravel>0)
                    {
                        choice=r2.getW(); 
                        canGo=true;
                    }
              
                 
                 
             }
         
            }
             break;
         
         
         
         
         
         }
    
       case 2:
        {
            if(havevisit1==true)
                break;
            
            lc  =  r3.getName();
            N =    r3.getDescription();
            System.out.println(lc);
            printSeperator(30);  
            System.out.println(N);
             System.out.println(RED+"You attempt to the escape trap roll a 8 or better to escape");
             printSeperator(30);  
             temp =(int) rollDice(1,20);
             System.out.println(YELLOW+"you rolled an " +temp);
              printSeperator(30); 
             if(temp>8)
             System.out.println(GREEN+"you escaped!");
             else
             {
                 System.out.println(RED+"You were crushed by the spikes game over");
                  System.exit(0);
             }
             
            while(canGo==false)
            {
                System.out.println(BLUE+" chose a direction to go 1 for n \n 2 for south \n 3 for e \n and 4 for south");
                dir=readInt("->",4);
            if(dir==1)
           
            {
                cantravel = r3.getN();
                 if(cantravel<0);
                    System.out.println(" Can't go that way!");
                    clearConsole();
                    if(cantravel>0)
                    {
                             choice=r3.getN(); 
                            canGo=true;
                    }   
            }
            if(dir==2)
            {
                  cantravel = r3.getS();
                 if(cantravel<0);
                    System.out.println(" Can't go that way!");
                    clearConsole();
                    if(cantravel>0)
                    {
                        choice=r3.getS(); 
                        canGo=true;
                    }
                 
             }
              if(dir==3)
              {
                  cantravel = r3.getE();
                 if(cantravel<0);
                    System.out.println(" Can't go that way!");
                    clearConsole();
                    if(cantravel>0)
                    {
                        choice=r3.getE(); 
                        canGo=true;
                    }
              
              }
             if(dir==4)
             {
               
                  cantravel = r3.getW();
                 if(cantravel<0);
                    System.out.println(" Can't go that way!");
                    clearConsole();
                    if(cantravel>0)
                    {
                        choice=r3.getW(); 
                        canGo=true;
                    }
              
                 
                 
             }
            
            
          
            
            
            }
            break;
        }
        
       case 3:
        {
             
            if(havevisit1==true)
                break;
            
            lc  =  r4.getName();
            N =    r4.getDescription();
            System.out.println(lc);
            printSeperator(30);  
            System.out.println(N);
            
            while(canGo==false)
            {
                System.out.println(BLUE+" chose a direction to go 1 for n \n 2 for south \n 3 for e \n and 4 for south");
                dir=readInt("->",4);
            if(dir==1)
           
            {
                cantravel = r4.getN();
                 if(cantravel<0);
                    System.out.println(" Can't go that way!");
                    clearConsole();
                    if(cantravel>0)
                    {
                             choice=r4.getN(); 
                            canGo=true;
                    }   
            }
            if(dir==2)
            {
                  cantravel = r4.getS();
                 if(cantravel<0);
                    System.out.println(" Can't go that way!");
                   clearConsole();
                    if(cantravel>0)
                    {
                        choice=r4.getS(); 
                        canGo=true;
                    }
                 
             }
              if(dir==3)
              {
                  cantravel = r4.getE();
                 if(cantravel<0);
                    System.out.println(" Can't go that way!");
                    clearConsole();
                    if(cantravel>0)
                    {
                        choice=r4.getE(); 
                        canGo=true;
                    }
              
              }
             if(dir==4)
             {
               
                  cantravel = r4.getW();
                 if(cantravel<0);
                    System.out.println(" Can't go that way!");
                    clearConsole();
                    if(cantravel>0)
                    {
                        choice=r4.getW(); 
                        canGo=true;
                    }
              
                 
                 
             }
            
           
            }
             break;
        } 
            
            case 4:
        {
             
            
            if(havevisit1==true)
                break;
            
            lc  =  r5.getName();
            N =    r5.getDescription();
            System.out.println(lc);
            printSeperator(30);  
            System.out.println(N);
            System.out.println(RED+"You attempt to the sneak past the dragon  roll a 9 or better to escape");
             printSeperator(30);  
             temp =(int) rollDice(1,20);
             System.out.println(YELLOW+"you rolled an " +temp);
              printSeperator(30); 
             if(temp>9)
             System.out.println(GREEN+"you escaped!");
             else
             {
                 System.out.println(RED+"The dragon wakes and breathes a wall of fire that leave nothing but bones,  game over!!");
                  System.exit(0);
             }
            while(canGo==false)
            {
                System.out.println(BLUE+" chose a direction to go 1 for n \n 2 for south \n 3 for e \n and 4 for south");
                dir=readInt("->",4);
            if(dir==1)
           
            {
                cantravel = r5.getN();
                 if(cantravel<0);
                    System.out.println(" Can't go that way!");
                    clearConsole();
                    if(cantravel>0)
                    {
                             choice=r5.getN(); 
                            canGo=true;
                    }   
            }
            if(dir==2)
            {
                  cantravel = r5.getS();
                 if(cantravel<0);
                    System.out.println(" Can't go that way!");
                   clearConsole();
                    if(cantravel>0)
                    {
                        choice=r5.getS(); 
                        canGo=true;
                    }
                 
             }
              if(dir==3)
              {
                  cantravel = r5.getE();
                 if(cantravel<0);
                    System.out.println(" Can't go that way!");
                    clearConsole();
                    if(cantravel>0)
                    {
                        choice=r2.getE(); 
                        canGo=true;
                    }
              
              }
             if(dir==4)
             {
               
                  cantravel = r5.getW();
                 if(cantravel<0);
                    System.out.println(" Can't go that way!");
                    clearConsole();
                    if(cantravel>0)
                    {
                        choice=r5.getW(); 
                        canGo=true;
                    }
              
                 
                 
             }
            
            
           
             
        }
          break;  
           
        }  
            
            
                
                
            
            case 5:
        {
            System.out.println(GREEN+"You Found the ancient artifact thanks for playing more adventures coming soon!");
            Exit=false;
            System.exit(0);
        
        }
         
         
       break;  
}
         
         
    } //
}//end act 1
              
    
    
    

public static void act3(){
                  
              }



public static void slowPrint(String message, int millisPerChar,String color)
    {
        
        char[] chars = message.toCharArray();
        for (int i = 0; i < chars.length; i++)
        {
            System.out.print(color+message.charAt(i));
            try {
                
                
                
                Thread.sleep( millisPerChar);
            } 
            catch ( java.lang.InterruptedException ie) 
            {
               System.out.println(ie);
            }
            
           
        }
    }

    public static void bossFight1() {
        int oldManhp=300,oldManmp=70,oldMandf=15, oldManattack=10,oldManSpell=25,oldmanDragon=35;
        
        boolean fight=true,defend=false;
        String talk ="Power as most seek  SHOW ME YOUR POWER";
             slowPrint(talk,260,RED);
                  
                     int dmgTook=0,dmgReduced=0;
            
                   
                     int dmgdone=0,damageRecieved=0,dmg=0, dmg2=0;
         while(fight)
         {
            clearConsole();
              
            
            
            printHeading("Old man? " + "\nHP: " + "??? " );
              if(magic==true)
              {
                    printHeading(mage.name + "\tHP: " + mage.hp + "/" + mage.maxHp +" "+ mage.magicpoints+"/"+ mage.maxmagicpoints);
              }
              else if(holy==true)
              {
              printHeading(paladin.name + "\tHP: " + paladin.hp + "/" + paladin.maxHp+" " + paladin.magicpoints+"/"+ paladin.maxmagicpoints); //  0 mean character not chosen
              
              }
              
              
              System.out.println("Choose an action:");
              printSeperator(20);
              System.out.println("(1) Fight\n(2) defend\n(3) Special attack, warning! uses mp!");
              int input = readInt("-> ", 3);
             
             if(input == 1)
             {
                      if(magic==true)
                      {
                          
                          dmg= (int) mage.attack();
                          oldManhp-=dmg;
                      }
                      else if(holy==true)
                      {
                          
                           dmg= (int) paladin.attack();
                          oldManhp-=dmg;
                                  
                      }
                     
                             
             }
             
             
             else if(input == 2)
             {
		 defend=true;
                  if(magic==true)
                      {
                          
                          dmgReduced= (int) mage.defend();
                          
                      }
                       if(holy==true)
                      {
                          
                           dmgReduced= (int) paladin.defend();
                          
                                  
                      }
                     
                 
                 defend=false;
                 
                 
                 
                 
             }
                 
             else if(input==3)
             {
		
                 if(magic==true)
                      {
                          
                          dmg =mage.special();
                           oldManhp-=dmg;
                          mage.maxmagicpoints-=10;
                      }
                       if(holy==true)
                      {
                          
                         dmg=paladin.special();
                           oldManhp-=dmg;
                         paladin.magicpoints-=15;
                                  
                      }
                     
                 
                 
	     }
             
             if(oldManhp >=220)
             {
                  if(defend==true&&magic==true)
                  {
                      
                      dmgTook=    (int) ((mage.hp = (int) ((mage.hp- (oldManattack -dmgReduced )))));
                      
                  }
                 if(defend==true&&holy==true)
                 {
                     dmgTook=    (int) ((paladin.hp = (int) ((paladin.hp- (oldManattack -dmgReduced )))));
                     
                 }
                  else if(defend==false)
                  {
                      
                     
                  
                 if(magic==true)
                  {
                       dmgTook=    (int) ((mage.hp = (int) ((mage.hp- oldManattack)*.7)));
                  }
                  else if(holy==true){
                      
                      dmgTook= (int) ((paladin.hp= (int) ((paladin.hp-oldManattack)*.3)));
                      
                  }
                 
             
                  }
             }
             
             if(oldManhp<150)
             {
                  
                 if(defend==true&&magic==true)
                  {
                      
                      dmgTook=    (int) ((mage.hp = (int) ((mage.hp- (oldManSpell -dmgReduced )))));
                      
                  }
                 if(defend==true&&holy==true)
                 {
                     dmgTook=    (int) ((paladin.hp = (int) ((paladin.hp- (oldManSpell -dmgReduced )))));
                     
                 }
                 
                 
                 else if(defend==false)
                 {
                 
                    if(magic==true)
                    {
                       dmgTook=    (int) ((mage.hp=(int) ((mage.hp - oldManSpell)*.7)));
                    }
                    else if(holy==true)
                    {
                      
                      dmgTook= (int) ((paladin.hp-oldManSpell)*.3);
                      
                    }
                }
             }
             if(oldManhp<100){
                  
                 if(defend==true&&magic==true)
                  {
                      
                      dmgTook=    (int) ((mage.hp = (int) ((mage.hp- (oldmanDragon -dmgReduced )))));
                      
                  }
                 if(defend==true&&holy==true)
                 {
                     dmgTook=    (int) ((paladin.hp = (int) ((paladin.hp- (oldmanDragon -dmgReduced )))));
                     
                 }
                 
                 
                 
                 
                 else if(defend==false)
                         {
                 
                 if(magic==true)
                  {
                       dmgTook=    (int) ((mage.hp =(int) ((mage.hp- oldmanDragon)*.7)));
                  }
                  else if(holy==true){
                      
                      dmgTook= (int) ((paladin.hp= (int) ((paladin.hp-oldmanDragon)*.3)));
                      
                  }
             
                         
                         }        
                         
              }
                  
               
             
         
             
             System.out.println("You dealt " + dmg + " damage to the Possesed Old man " );
               printSeperator(15);
               System.out.println("The  Possesed Old man dealt " + dmgTook + " damage to you.");
               anythingToContinue();
              if(oldManhp<=0){
                   System.out.println("you defeated the Demon, he dropped a map with location of cave of woes");
                  fight=false;
              }
              if(magic==true&&mage.hp<0){
                  
                   System.out.println("You have been defeated thank for playing");
                   System.exit(0);
                   
              }
         
              else if(holy==true&&paladin.hp<0){
                  
                   System.out.println("You have been defeated thank for playing");
                   
                   System.exit(0);
              }
              
              
              
         }

        }
}
       




