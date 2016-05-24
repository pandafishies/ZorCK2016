/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alexb
 */
public class Enemy extends Character{
    public final int EXP;
    public final int LEVEL;
    
    //the following variables are values used to represent the number of EVs awarded
    //for the defeat of the enemy
    public final int HPEV;
    public final int ATKEV;
    public final int DEFEV;
    public final int SPDEV;
    
    public Enemy(int hp, int speed, int attack, int defense, int exp, int level, String name, int hpev, int atkev, int defev, int spdev){
        super(hp,speed,attack,defense,name);
        this.EXP = exp;
        this.LEVEL = level;
        //when a basic character is created stats are set for level one the following 
        //maths properly adjusts the stats to the proper level.
        this.hp = (this.hp-11)*LEVEL+this.LEVEL + 10;
        this.attack = (this.attack-5)*LEVEL+5;
        this.defense = (this.defense-5)*LEVEL+5;
        this.speed = (this.speed-5)*LEVEL+5;
        
        this.HPEV = hpev;
        this.DEFEV = defev;
        this.ATKEV = atkev;
        this.SPDEV = spdev;
    }
}
