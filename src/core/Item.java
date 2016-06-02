package core;

import java.util.ArrayList;


/**
 *
 * @author pedro
 */
public class Item {
    private String name;
    public String description;
    
    public static final int TAKEABLE = 11;
    public static final int TOO_HEAVY = 12;
    public static final int BOLTED_DOWN = 13;
    public static final int EDIBLE = 21;
    public static final int INEDIBLE = 22;
    public static final int POTABLE = 31;
    public static final int UNPOTABLE = 32;
    public static final int NEED_TO_OPEN = 33;
    public static final int OPEN = 41;
    public static final int CLOSED = 42;
    public static final int LOCKED = 51;
    public static final int UNLOCKED = 52;
    public static final int READABLE = 61;
    public static final int ILLEGIBLE = 62;
    public static final int TURNEDON = 71;
    public static final int TURNEDOFF = 72;
    public static final int WEARABLE = 81;
    public static final int UNWEARABLE = 82;
    
    public final ArrayList<Integer> adjectives;
    
    public String taste;
    public Item inside;
    public String text; 	//if item is read
    public boolean active;	//if item can be turned on or pressed
    public String smell;
    public String sound;
    public ArrayList<Item> received;
    public ArrayList<Item> keys;
    public Portal portal;
    public ArrayList<String> synonyms;
	
    public Item(){
        for(int i = 0; i < this.usage.length; i++){
            this.usage[i] = 0;
        }
        this.synonyms = new ArrayList<String>();
    }
    
    public String getName(){
        return this.name;
    }
	
    public void setName(String name){
	this.name = name;
    }
	
    public String getDescription(){
        return this.description;
    }
	
    public void setDescription(String description){
        this.description = description;
    }
	
    public int getUsageKey(int n){
        if(n < this.usage.length) return this.usage[n];
        else return -1;
    }
	
    public void setUsageKey(int n, int state){
        if(n < this.usage.length) usage[n] = state;
    }
	
    public String getTaste(){
        return this.taste;
    }
	
    public void setTaste(String taste){
        this.taste = taste;
    }
	
    public Item getInside(){
        return this.inside;
    }
	
    public void setInside(Item inside){
        this.inside = inside;
    }
	
    public String getText(){
        return this.text;
    }
	
    public void setText(String text){
        this.text = text;
    }
	
    public boolean getActive(){
        return getUsageKey(7) == 3;
    }
	
    public void setActive(boolean active){
        if(active)
            setUsageKey(7,3);
        else setUsageKey(7,2);
    }
	
    public String getSmell(){
        return this.smell;
    }
	
    public void setSmell(String smell){
        this.smell = smell;
    }
    
    public String getSound(){
        return this.sound;
    }
	
    public void setSound(String sound){
        this.sound = sound;
    }
    
    public ArrayList<Item> getKey(){
        return this.keys;
    }
	
    public void setKey(ArrayList<Item> keys){
        this.keys = keys;
    }

    public Portal getPortal(){
        return this.portal;
    }
    
    public void setPortal(Portal portal){
        this.portal = portal;
    }
    
    public void addSynonym(String str){
        this.synonyms.add(str);
    }
    
    public boolean hasMatching(String str){
        for(String item: this.synonyms){
            if(item.equals(str)) return true;
        }
        return false;
    }
    
    public void drop(Area area){
        if(getInside() !=  null){
            area.addItem(getInside());
            setInside(null);
        }
    }
    
    public void receive(Item item){
        this.received.add(item);
    }
    
    
    public boolean hasReceived(String name){
        for(Item item: this.received){
            if(item.getName().equals(name)) return true;
        }
        return false;
    }
    
    public void synchronizeDoor(World world, Area currentArea){
        Portal portal;
        portal = getPortal();
        Area target;
        target = world.getArea(portal.getTarget());
        int oppDir;
        if(currentArea.getDirection(portal) < 4){
            oppDir = currentArea.getDirection(portal) - 2;
            if(oppDir < 0) oppDir += 4;
        }else if(currentArea.getDirection(portal) < 8){
            oppDir = currentArea.getDirection(portal) - 2;
            if(oppDir < 4) oppDir += 4;
        }else{
            if(currentArea.getDirection(portal) == 8) oppDir = 9;
            else oppDir = 8;
        }
        
        Item oppDoor;
        oppDoor = target.getPortal(oppDir).getDoor(target);
        
        if(getUsageKey(5) == 3){
            target.getPortal(oppDir).lock();
            if(oppDoor != null)
                oppDoor.setUsageKey(5,3);
        }else{
            target.getPortal(oppDir).unlock();
            if(oppDoor != null)
                oppDoor.setUsageKey(5,2);
        }
    }
}
