/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package areas;
import core.*;
import items.*;

/**
 *
 * @author pedro
 */
public class Test8 extends Area{

       public Test8(World containingWorld){
            super(containingWorld);
            setPortal(World.WEST, new Portal(Portal.UNLOCKED, "Test7"));
            setPortal(World.EAST, new Portal(Portal.UNLOCKED, "Test9"));
            setPortal(World.NORTH, new Portal(Portal.UNLOCKED, "Test5"));
            setPortal(World.SOUTH, new Portal(Portal.UNLOCKED, "Test10"));
            setTitle("Test Area 8");
            setInitialDescription("This is the eighth test area, there is path "
                    + "leading east-west and path leading north. There is a cave"
                    + " to the south. There is a magic orb on the ground");
            addItem(new MagicOrb());
       }
       
        public void interact(Command command, Context context){
            if(command.verb.getTitle().equals("take") && 
                    command.noun.getName().equals("Magic Orb")){
                context.player.setMaxHp(context.player.getMaxHp() + 10);
                context.player.setHp(context.player.getHp() + 10);
                context.player.getCurrentArea().removeItem(command.noun);
                //
                System.out.println("The orb seeps into your skin");
                System.out.println("Your max HP just went up by 10!");
            }else{
                command.verb.run(command, context);
            }
            
            command.verb.run(command, context);
                
        }

}
