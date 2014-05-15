package package1;

/***********************************************************
 * Maintains items for game
 * 
 * Items can be edible, and can be required for entry to 
 * certain rooms.
 * 
 * @author John Tunisi 
 * @version 3/31/13
 ***********************************************************/
public class Item
{
    /**Item name and description*/
    private String name;
    private String description;

    /**Item weight*/
    private int weight;

    /**Is edible?*/
    private boolean eat;

    /*******************************************************
     * Constructor for objects of class Item
     * 
     * @param n the name of item
     * @param d the description of item
     * @param w the weight of item
     * @param e if item is edible
     *******************************************************/
    public Item(String n, String d, int w, boolean e){
        name = n;
        description = d;
        weight = w;
        eat = e;
    }
    
    /*******************************************************
     * Creates a string for item
     * 
     * @return str
     *******************************************************/
    public String toString(){
        String str = (name + ": " + description);
        return str;
    }

    /*******************************************************
     * Checks if item is edible
     * 
     * @return isEdible
     *******************************************************/
    public boolean isEdible(){
        //if item is edible
        if(eat)
            return true;
        return false;
    }

    /*******************************************************
     * Gets name
     * 
     * @return name
     *******************************************************/
    public String getName(){
        return name;
    }

    /*******************************************************
     * Sets name
     * 
     * @param n the name of item
     *******************************************************/
    public void setName(String n){
        name = n;
    }

    /*******************************************************
     * Gets weight
     * 
     * @return weight
     *******************************************************/
    public int getWeight(){
        return weight;
    }

    /*******************************************************
     * Sets weight
     * 
     * @param w the weight of item
     *******************************************************/
    public void setWeight(int w){
        weight = w;
    }

    /*******************************************************
     * Gets description
     * 
     * @return description
     *******************************************************/
    public String getDescription(){
        return description;
    }

    /*******************************************************
     * Sets description
     * 
     * @param d the description of item
     *******************************************************/
    public void setDiscription(String d){
        description = d;
    }
    
    /*******************************************************
     * Main method for testing
     *******************************************************/
     public static void main(String args[]){
         Item a = new Item("banana", "a tasty fruit", 4, true);
         System.out.println(a.getDescription());
         System.out.println(a.getName());
         System.out.println(a.getWeight());
         System.out.println(a.isEdible());
        }
}
