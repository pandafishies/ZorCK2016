
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alexb
 */
public class Character {
    public int hp;
    public int speed;
    public int attack;
    public int defense;

    public final String name;

    
    //the following variables are base stats that are permanent and will be used
    //to determine the characters used stats as the level changes.
    public final int HP;
    public final int ATTACK;
    public final int DEFENSE;
    public final int SPEED;

    
    //the following variables are permanent values randomly generated upon the creation
    //of a character to allow for stat variation among charaters of the same type.
    public final int HPIV;
    public final int ATTACKIV;
    public final int DEFENSEIV;
    public final int SPEEDIV;
    
    
    private ArrayList<Item> items;
    
    public Character(int hp, int speed, int attack, int defense, String name){


        this.ATTACK = attack;
        this.DEFENSE = defense;
        this.HP = hp;
        this.SPEED = speed;
        this.HPIV = (int) (Math.random() * 32);
        this.ATTACKIV = (int) (Math.random() * 32);
        this.DEFENSEIV = (int) (Math.random() * 32);
        this.SPEEDIV = (int) (Math.random() * 32);
        this.hp = ((HP+HPIV)*2)/100+11;
        this.attack = ((ATTACK+ATTACKIV)*2)/100 + 5;
        this.defense = ((DEFENSE+DEFENSEIV)*2)/100 + 5;
        this.speed = ((SPEED+SPEEDIV)*2)/100 + 5;
        this.name =  name;
        this.items = new ArrayList<>();
    }
 
}
