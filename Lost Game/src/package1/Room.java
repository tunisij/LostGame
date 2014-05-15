package package1;

import java.util.*;

/******************************************************
 * Creates rooms for game
 * 
 * Rooms are "places" that a player can be at a given 
 * time. Rooms have neighbors which can be travelled
 * to from the current room. They can contain an item.
 * 
 * @author John Tunisi
 * @version 3/31/13
 ******************************************************/
public class Room
{
    /**Room description*/
    private String description;

    /**Items*/
    private Item item;
    
    /**Characters*/
    private Character character;

    /**room neighbors*/
    private HashMap <String, Room> neighbors;

    /**************************************************
     * Constructor for objects of class Room
     * 
     * @param d room description
     * @param i item
     * @param c character
     **************************************************/
    public Room(String d, Item i, Character c){
        description = d;
        item = i;
        character = c;
        neighbors = new HashMap <String, Room>();
    }

    /**************************************************
     * Gets room description
     * 
     * @return description
     **************************************************/
    public String getDescription(){
        return description;
    }

    /**************************************************
     * Sets room description
     * 
     * @param d room description
     **************************************************/
    public void setDescription(String d){
        description = d;
    }

    /**************************************************
     * Adds item to a room
     * 
     * @param i item
     **************************************************/
    public void addItem(Item i){
        item = i;
    }
    
    /**************************************************
     * Removes item from room
     * 
     * @return temp
     **************************************************/
    public Item removeItem(){
        Item temp = item;
        item = null;
        return temp;
    }
    
    /**************************************************
     * Gets room item
     * 
     * @return item
     **************************************************/
    public Item getItem(){
        return item;
    }

    /**************************************************
     * Checks if room has an item
     * 
     * @return hasItem
     **************************************************/
    public boolean hasItem(){
        //if the item is not null
        if(item != null)
            return true;
        return false;
    }

    /**************************************************
     * Checks if room has a character
     * 
     * @return hasCharacter
     **************************************************/
    public boolean hasCharacter(){
        //if the character is not null
        if(character != null)
            return true;
        return false;
    }
  
    /**************************************************
     * Gets character in room
     * 
     * @return character
     **************************************************/
    public String getCharacter(){
        return character.getCharString();
    }
    
    /**************************************************
     * Adds character to a room
     * 
     * @param c character
     **************************************************/
    public void addCharacter(Character c){
        character = c;
    }
    
    /**************************************************
     * Removes character from room
     * 
     * @return character
     **************************************************/
    public Character removeCharacter(){
        Character temp = character;
        character = null;
        return temp;
    }
    
    /**************************************************
     * Adds neighbor to room
     * 
     * @param dir direction of neighbor
     * @param r neighboring room
     **************************************************/
    public void addNeighbor(String dir, Room r){
        neighbors.put(dir, r);
    }
    
    /**************************************************
     * Removes neighbor from room
     * 
     * @param dir direction of neighbor
     * @param r neighboring room
     **************************************************/
    public void removeNeighbor(String dir){
        neighbors.remove(dir);
    }

    /**************************************************
     * Returns room in requested direction
     * 
     * @param dir direction of neighbor
     * @return room
     **************************************************/
    public Room getNeighbor(String dir){
        return neighbors.get(dir);
    }

    /**************************************************
     * Gets a long description of current state
     * 
     * @return message
     **************************************************/
    public String getLongDescription(){
        String message = ("You are " + getDescription());
        
        //adds to string if there is a character
        if(hasCharacter()){
            message += ("\n" + character.getCharString());
        }
        
        //adds to string if there is an item
        if(hasItem()){
            message += ("\nYou see " + item);
        }
        return message;
    }

    /***************************************************
     * Main method for testing
     ***************************************************/
    public static void main(String args[]){
        Item banana = new Item("bananas", "a tasty fruit", 4, true);
        Character jack = new Character("Jack", "Welcome to the island");
        Room a = new Room("in Kate's hut", banana, jack);
        System.out.println(a.getDescription());
        System.out.println(a.hasItem());
        System.out.println(a.getNeighbor("north"));
        a.removeItem();
        System.out.println(a.hasItem());
        System.out.println(a.getLongDescription());
    }
}
