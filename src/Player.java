/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alexb
 */
public class Player extends Character{
    private int xp;
    private int level;
    private int hpev;
    private int atkev;
    private int defev;
    private int spdev;
    
    public Player(){
        super(435,235,235,235,"Red");
        this.xp = 0;
        this.level = 1;
        this.hpev = 0;
        this.atkev = 0;
        this.defev = 0;
        this.spdev = 0;
    }
    
    public void gainXP(Enemy enemy){
        if(this.level>enemy.LEVEL){
            this.xp += (enemy.LEVEL * enemy.EXP)/5 * Math.pow(2*enemy.LEVEL+10,2.5)/Math.pow(enemy.LEVEL*2+10,2.5)+1;
        }

        else{
            this.xp += (enemy.LEVEL * enemy.EXP)/5 * Math.pow(2*enemy.LEVEL+10,2.5)/Math.pow(enemy.LEVEL+this.level+10,2.5)+1;
        }
        int evsum = this.hpev+this.atkev+this.defev+this.spdev;
        //this code makes sure that the player can have no more than the maximum number of
        //allowed EVs for each stat and total.
        if(this.hpev<255 && evsum<512){
            this.hpev+=enemy.HPEV;
            if(this.hpev>255){
                this.hpev = 255;
            }
            while(evsum>512){
                hpev--;
                evsum = this.hpev+this.atkev+this.defev+this.spdev;
            }
        }
        evsum = this.hpev+this.atkev+this.defev+this.spdev;
        if(this.atkev<255 && evsum<512){
            this.atkev+=enemy.ATKEV;
            if(this.atkev>255){
                this.atkev = 255;
            }
            while(evsum>512){
                atkev--;
                evsum = this.hpev+this.atkev+this.defev+this.spdev;
            }
        }
        evsum = this.hpev+this.atkev+this.defev+this.spdev;
        if(this.defev<255 && evsum<512){
            this.defev+=enemy.DEFEV;
            if(this.defev>255){
                this.defev = 255;
            }
            while(evsum>512){
                defev--;
                evsum = this.hpev+this.atkev+this.defev+this.spdev;
            }
        }
        evsum = this.hpev+this.atkev+this.defev+this.spdev;
        if(this.spdev<255 && evsum<512){
            this.spdev+=enemy.SPDEV;
            if(this.spdev>255){
                this.spdev = 255;
            }
            while(evsum>512){
                spdev--;
                evsum = this.hpev+this.atkev+this.defev+this.spdev;
            }
        }
        // this code checks to see if it is time for a levelup
        boolean levelChanged = false;
        while(this.xp >= Math.pow(this.level,3)){
            this.level++;
            levelChanged = true;
        }
        // recalculates stats based on new level and new EVs

            this.hp = (int) ((((this.HP+this.HPIV)*2 + Math.pow(hpev, .5)/4)*this.level)/100 + this.level +10);
            this.attack = (int) ((((this.ATTACK+this.ATTACKIV)*2 + Math.pow(atkev, .5)/4)*this.level)/100 + 5);
            this.defense = (int) ((((this.DEFENSE+this.DEFENSEIV)*2 + Math.pow(defev, .5)/4)*this.level)/100 + 5);
            this.speed = (int) ((((this.SPEED+this.SPEEDIV)*2 + Math.pow(spdev, .5)/4)*this.level)/100 + 5);

    }
    
    public void takeDamage(Enemy enemy){
        // the 40 in this equation will be replaced by the strength of the weapon used to attack.
        this.hp -= (2 * enemy.LEVEL +10)/250 * enemy.attack / this.defense * 40 + 1;
        if(this.hp<0) this.hp = 0;
    }
    
    public int getLevel(){
        return this.level;
    }
}
