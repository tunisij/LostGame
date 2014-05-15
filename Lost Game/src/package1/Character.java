package package1;

import java.util.*;

/**************************************************
 * Creates characters for the game.
 * 
 * Characters are located within rooms and can give
 * useful pieces of information to the player.
 * 
 * @author John Tunisi
 * @version 4/3/13
 **************************************************/
public class Character
{
    /**Character name*/
    private String name;

    /**Character description*/
    private String interact;
    
    /**room characters*/
    private HashMap <String, Room> chars;

    /**********************************************
     * Constructor for objects of class Character
     * 
     * @param n name of character
     * @param d description of character
     **********************************************/
    public Character(String n, String d)
    {
        name = n;
        interact = d;
        chars = new HashMap <String, Room>();
    }

    /**************************************************
     * Gets character name
     * 
     * @return name
     **************************************************/
    public String getCharName(){
        return name;
    }

    /**************************************************
     * Sets character name
     * 
     * @param n character name
     **************************************************/
    public void setCharName(String n){
        name = n;
    }

    /**************************************************
     * Gets character interaction
     * 
     * @return interact
     **************************************************/
    public String getInteraction(){
        return interact;
    }

    /**************************************************
     * Sets character interaction
     * 
     * @param i character interaction
     **************************************************/
    public void setInteraction(String i){
        interact = i;
    }
    
    /**************************************************
     * Gets character string
     * 
     * @return str
     **************************************************/
    public String getCharString(){
        String str = (getCharName() + ": " + getInteraction());
        return str;
    }

    /***************************************************
     * Main method for testing
     ***************************************************/
    public static void main(String args[]){
        Character jack = new Character("Jack", "nice to meet you");
        System.out.println(jack.getCharName());
        System.out.println(jack.getInteraction());
        System.out.println(jack.getCharString());
    }
}
