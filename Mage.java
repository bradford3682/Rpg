/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg;

import static rpg.Gamelogic.act;
import static rpg.Gamelogic.anythingToContinue;
import static rpg.Gamelogic.clearConsole;
import static rpg.Gamelogic.printHeading;
import static rpg.Gamelogic.readInt;
import static rpg.Gamelogic.rollDice;
import static rpg.Story.BLUE;
import static rpg.Story.RED;

/**
 *
 * @author bradf
 * 
 */
public final  class  Mage extends Character{
   public int numAtkUpgrades, numDefUpgrades ,hp=50;
    public static String element,job; //for spell weakness enemy will have weakness attribute
    Mage(String name)
   {
     super(name,50,30,10,"human",50,50);
         this.job="mage";
       this.numAtkUpgrades = 0;
		this.hp=maxHp;
       this.numDefUpgrades = 0;
		//let the player choose a trait when creating a new character
		chooseTrait();
     }
    public String[] atkUpgrades = {"Fire", "Reflect", "ManaRegen", "Ultimate"};
	public String[] defUpgrades = {"Magic defense", "Spikeskin", "FireArmor", "Holy Aura"};
   

   @Override
    public double attack() {
        double attackDmg=0;
        if (numAtkUpgrades>0)
        {
            attackDmg= (act/4 + rollDice(5,10)); // higher act more damage
        }
        else if(numAtkUpgrades>2)
        {
           
            attackDmg=  (act/4+ rollDice(5,10) +1);
        }
        return attackDmg;
    }

    @Override
    public double defend() {
        
        double attackDmg=0;
        if (numDefUpgrades>0)
        {
            attackDmg= (act/4* this.df*.25); // higher act more damage
        }
        else if(numDefUpgrades>2)
        {
           
            attackDmg=  (act/4* this.df*.25 +2);
        }
        return attackDmg;
        
       
        
        
    }

    @Override
    public int special() {
        int choice;
        int attackDmg=0;
        System.out.println("choose spell \n"+ RED+" (1) fire"+ BLUE+" \n (2) ice");
       
       choice= readInt("->",2);
      if(choice==1)
      {
          element="fire";
           System.out.println( RED+"FIRE ");
          attackDmg=(30+numAtkUpgrades);
      
      }
      else if(choice==2)
      {
          element="ice";
           System.out.println( BLUE+"ICE ");
          attackDmg=(25+numAtkUpgrades);
      }
          
    
            return attackDmg;      
                  
                  }

    @Override
    public int item() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public void chooseTrait(){
		clearConsole();
		printHeading("Choose a trait:");
		System.out.println("(1) " + atkUpgrades[numAtkUpgrades]);
		System.out.println("(2) " + defUpgrades[numDefUpgrades]);
		//get the players choice:
		int input = readInt("-> ", 2);
		clearConsole();
		//deal with both cases
		if(input == 1){
			printHeading("You chose " + atkUpgrades[numAtkUpgrades] + "!");
			numAtkUpgrades++;
		}else{
			printHeading("You chose " + defUpgrades[numDefUpgrades] + "!");
			numDefUpgrades++;
		}
		anythingToContinue();
	}
}
