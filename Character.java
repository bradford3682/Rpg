/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg;

/**
 *
 * @author bradf
 */
public abstract class Character {
    public String name;
	public int maxHp, hp, df, magicpoints, md,maxmagicpoints;
	public String type;
	//Constructor for character
	public Character(String name, int maxHp, int magicdef,int physicaldef,String race, int mp,int maxMp){
		this.name = name;
		this.maxHp = maxHp;
		this.md=magicdef;
		this.type=race;
                this.df=physicaldef;
                this.magicpoints=mp;
                this.maxmagicpoints=maxMp;
	}
public abstract double attack();
	public abstract double defend();
public abstract int special();

	public abstract int item();
        

}
