package package1;

import java.util.*;

/*****************************************************************
 * Keeps track of items, location, characters, rules, etc for game
 * 
 * A player must travel through rooms and pick up items. The player
 * must find their way through the game, collecting certain items
 * or pieces of information which they can then use to win the game.
 * 
 * @author John Tunisi
 * @version 3/31/13
 *****************************************************************/
public class Game
{
    /**List of items*/
    private ArrayList <Item> inventory;

    /**Rooms*/
    private Room beach;
    private Room kateHut;
    private Room kateFood;
    private Room plane;
    private Room water;
    private Room lookingGlass;
    private Room jungle;
    private Room statue;
    private Room jungle2;
    private Room radio;
    private Room hatch;
    private Room blackRock;
    private Room swan;
    private Room computer;
    private Room others;
    private Room currentLoc;
    private Room previousLoc;
    private Room nextRoom;

    /**Items*/
    private Item hatchet;
    private Item bananas;
    private Item chips;
    private Item msgBottle;
    private Item goldLocket;
    private Item boarMeat;
    private Item rock;
    private Item notepad;
    private Item dynamite;

    /**Characters*/
    private Character jack;
    private Character kate;
    private Character sawyer;
    private Character charlie;
    private Character jackFather;
    private Character jacob;
    private Character walter;
    private Character locke;
    private Character vincent;
    private Character rousseau;
    private Character desmond;
    private Character hurley;
    private Character ben;

    /**Current message*/
    private String message;

    /**Counts items eaten*/
    private int itemsEaten;

    /**Game conditions*/
    private boolean gameLost;
    boolean gameWon;
    private boolean swanOpen;
    private boolean compRoom;

    /*************************************************************
     * Constructor for objects of class Game
     *************************************************************/
    public Game(){
        inventory = new ArrayList <Item>();
        createRooms();
        gameLost = false;
        gameWon = false;
        swanOpen = false;
        compRoom = false;
        setIntroMessage();
        currentLoc = beach;
        itemsEaten = 0;
    }

    /*************************************************************
     * Creates rooms
     *************************************************************/
    private void createRooms(){
        //instantiates items
        hatchet = new Item("hatchet", "a hatchet to cut down thick"
        + " foliage.", 4, false);
        bananas = new Item("bananas", "a tasty fruit grown on trees"
        + ".", 4, true);
        chips = new Item("bag of chips", "a salty snack.", 2, true);
        msgBottle = new Item("message in a bottle", "Reads: 15 years"
        + " I have searched for you.", 5, false);
        goldLocket = new Item("golden locket", "a golden locket with"
        + " 'A.R.+B.L.' enscribed.", 1, false);
        boarMeat = new Item("boars meat", "the meat of a boar, an "
        + "excellent food source.", 6, true);
        rock = new Item("rock", "There's something etched into it. "
        + "Reads: P. Sherman 42 Wallaby Way Sydney.", 15, false);
        notepad = new Item("notepad", "Reads: 4, 8.", 2, false);
        dynamite = new Item("sticks of dynamite", "highly explosive, "
        + "handle with caution.", 5, false);

        //instantiates characters
        jack = new Character("Jack", "We need to explore this island.");
        kate = new Character("Kate", "Take this hatchet if you are "
        + "going exploring, it might come in handy.");
        sawyer = new Character("Sawyer", "What do you think you are "
        + "doing stealing this food? I already claimed it all for my"
        + "self. Take the bag of chips, but that’s all you’re getting.");
        charlie = new Character("Charlie", "So much for fate.");
        jackFather = new Character("Jack's Father", "The island does "
        + "not welcome you.");
        jacob = new Character("Jacob", "The island has chosen you to "
        + "be here.");
        walter = new Character("Walter", "Have you seen my dog?");
        locke = new Character("John Locke", "I wrote down what I "
        + "could make out of the signal on the notepad.");
        vincent = new Character("Walt's dog Vincent", "TAG READS: "
        + "Return me to Walt on 23rd Street.");
        rousseau = new Character("Rousseau", "I have been stuck on "
        + "this island for 16 years.");
        desmond = new Character("Desmond", "See you in another life "
        + "brotha.");
        hurley = new Character("Hurley", "Don't even think about "
        + "using those numbers, they are cursed!");
        ben = new Character("Ben", "You have broken our treaty, "
        + "leave something of value or we will take you as hostage.");

        //instantiates rooms
        beach = new Room("on the beach where camp has been setup"
        + ".", boarMeat, jack);
        kateHut = new Room("in Kate's hut.", hatchet, kate);
        kateFood = new Room("secretly rummaging through Kate's "
        + "food.", bananas, null);
        plane = new Room("inside what's left of the Oceanic flight "
        + ".", chips, sawyer);
        water = new Room("swimming in the ocean.", msgBottle, null);
        lookingGlass = new Room("in the Looking Glass, an underwater"
        + " Dharma station.", goldLocket, charlie);
        jungle = new Room("in a thick jungle where direction becomes"
        + " unknown.", null, jackFather);
        statue = new Room("at the remnant foot of the statue of "
        + "Taweret.", rock, jacob);
        jungle2 = new Room("in a thick jungle where direction becomes"
        + " unknown.", null, walter);
        radio = new Room("at a radio tower that is transmitting a "
        + "looped distress signal.", notepad, locke);
        hatch = new Room("at a hatch enclosing a tunnel going into "
        + "the ground.", null, vincent);
        blackRock = new Room("at the Black Rock, an old wooden ship "
        + "that is mysteriously in the middle of the island"
        + ".", dynamite, rousseau);
        swan = new Room("at the Swan, an underground Dharma station"
        +".", null, desmond);
        computer = new Room("at a computer terminal waiting for numbers"
        + " to be inputted.", null, hurley);
        others = new Room("at the other's village, people who were "
        + "here on the island already.", null, ben);

        //adds neighbors
        beach.addNeighbor("inside", plane);
        beach.addNeighbor("north", jungle);
        beach.addNeighbor("south", water);
        beach.addNeighbor("east", kateHut);
        kateHut.addNeighbor("west", beach);
        kateHut.addNeighbor("inside", kateFood);
        kateFood.addNeighbor("outside", kateHut);
        plane.addNeighbor("outside", beach);
        water.addNeighbor("inside", lookingGlass);
        water.addNeighbor("north", beach);
        lookingGlass.addNeighbor("outside", water);
        jungle.addNeighbor("south", jungle2);
        jungle.addNeighbor("north", beach);
        jungle.addNeighbor("west", statue);
        statue.addNeighbor("east", jungle2);
        statue.addNeighbor("north", jungle);
        jungle2.addNeighbor("east", radio);
        jungle2.addNeighbor("north", beach);
        jungle2.addNeighbor("west", hatch);
        jungle2.addNeighbor("south", others);
        radio.addNeighbor("south", jungle2);
        hatch.addNeighbor("inside", swan);
        hatch.addNeighbor("south", jungle2);
        hatch.addNeighbor("east", blackRock);
        blackRock.addNeighbor("west", hatch);
        swan.addNeighbor("inside", computer);
        swan.addNeighbor("outside", hatch);
        computer.addNeighbor("outside", swan);
        others.addNeighbor("south", jungle2);

        previousLoc = null;

    }

    /*************************************************************
     * Initializes game introduction
     *************************************************************/
    private void setIntroMessage(){
        message = "Your Oceanic flight has crashed on what seems to "
        + "be a deserted island. Your goal is to find a way off of "
        + "this island using clues that can be found around the "
        + "island. ";
    }

    /*************************************************************
     * Returns the game's message
     * 
     * @return message
     *************************************************************/
    public String getMessage(){
        return message;
    }

    /*************************************************************
     * Computer terminal for winning game
     * 
     * @return computerRoom
     *************************************************************/
    public boolean computerRoom(){
        //if player is in computer room
        if(compRoom){
            return true;
        }
        return false;
    }

    /*************************************************************
     * Gives hints, suggestions, and reminders about the game
     *************************************************************/
    public void help(){
        //if player is in beach
        if(currentLoc == beach){
            message = "There is something eerie about this island."
            + " It seems as though the island is telling me numbers";
        }

        //if player is in computer room
        if(currentLoc == computer){
            message = "Input the numbers you found around the island"
            + " from low to high.";
        }

        //if player is in jungle
        if(currentLoc == jungle){
            message = "Try to talk to some of the other survivors "
            + "of the crash, they may have a useful tool.";
        }

        //if player is in hatch
        if(currentLoc == hatch){
            message = "I wonder if there is a way to get inside this"
            + " hatch, maybe we can blow it up.";
        }

        //if player is in jungle2
        if(currentLoc == jungle2){
            message = "Be careful of wandering in the wrong direction, "
            + "things could go south quickly, and we don't want that "
            + "to happen!";
        }

    }

    /*************************************************************
     * Shows room's long description
     *************************************************************/
    public void show(){
        message = currentLoc.getLongDescription();
    }

    /*************************************************************
     * Moves current location
     * 
     * @param direction the direction to travel
     *************************************************************/
    public void move(String direction){
        Room nextRoom = currentLoc.getNeighbor(direction);
        //if room does not have specified neighbor
        if(currentLoc.getNeighbor(direction) == (null)){
            message = "You can't go that direction.";

            //if jungle2 is next
        }else if(nextRoom == jungle2){
            //if player has hatchet
            if(searchInventory("hatchet") == hatchet){
                previousLoc = currentLoc;
                currentLoc = nextRoom;
                message = currentLoc.getLongDescription();

                //else they must go find hatchet
            }else{
                message = "The forest brush is too thick to pass through"
                + " now, better find something to cut through it, or "
                + "find another way around!\n"
                + currentLoc.getLongDescription();  

                previousLoc = currentLoc;
                nextRoom = jungle;
                currentLoc = nextRoom;

            }

            //if next room is the others village
        }else if(nextRoom == others){
            //if player has gold locket they survive
            if(searchInventory("golden locket") == goldLocket){
                previousLoc = null;
                currentLoc = nextRoom;
                inventory.remove(goldLocket);
                jungle2.removeNeighbor("south");
                message = currentLoc.getLongDescription()
                + "\nThe golden locket has been taken.\n"
                + "Ben: never return here again.";

                //else they lose
            }else{
                previousLoc = null;
                currentLoc = nextRoom;
                gameLost = true;
            }
            //if next room is the black rock
        }else if(nextRoom == blackRock){
            //player must have eaten 2 or more food items
            if(itemsEaten >= 2){
                previousLoc = currentLoc;
                currentLoc = nextRoom;
                message = currentLoc.getLongDescription();

                //player is required to eat more food
            }else{
                message = "You do not have the nourishment necessary to "
                + "continue, try eating some food.\n";

                previousLoc = currentLoc;
                nextRoom = hatch;
                currentLoc = nextRoom;
            }
            //if next room is hatch
        }else if(nextRoom == swan){
            //if player has dynamite
            if(searchInventory("sticks of dynamite") == dynamite){
                message = "You use the dynamite to bust open the hatch, "
                + "allowing you to climb inside!\n";

                previousLoc = currentLoc;
                currentLoc = swan;
                message += currentLoc.getLongDescription();
                inventory.remove(dynamite);
                swanOpen = true;

                //else player does not have dynamite      
            }else if(swanOpen){
                previousLoc = currentLoc;
                currentLoc = nextRoom;
                message = currentLoc.getLongDescription();

                //else gives error message
            }else{
                message = "You can't go that direction.";
            }
            //else player moves normally
        }else{
            previousLoc = currentLoc;
            currentLoc = nextRoom;
            message = currentLoc.getLongDescription();
            compRoom = false;
        }

        //if next room is computer room
        if(nextRoom == computer){
            compRoom = true;

            //else next room is not computer room
        }else{
            compRoom = false;
        }

    }

    /*************************************************************
     * Gets a list of items, and gets notes
     *************************************************************/
    public void inventory(){
        int count = 0;
        message = "";

        //seaches each item in inventory
        for(Item a : inventory){
            count ++;

            //if item is not null
            if(a != null){
                message += a.getName() + "\n"; 
            }
        }
        message += (count + " items in your inventory.");
    }

    /*************************************************************
     * Checks if player is holding requested item
     * 
     * @param name the name of an item
     * @return item
     *************************************************************/
    private Item searchInventory(String name){
        //searches each item in inventory
        for(Item a : inventory){
            //checks inventory for inputted item
            if(a.getName().equals(name)){
                return a;
            }
        }
        return null;
    }

    /*************************************************************
     * Tries to eat items
     * 
     * @param item the name of the item
     *************************************************************/
    public void eat(String item){
        Item i = searchInventory(item);
        //checks if inventory size is zero
        if(inventory.size() == 0){
            message = "You are not holding anything!";

            //if item is null
        }else if(i == null){
            message = "You are not holding " + item + ".";

            //if item is edible
        }else if(i.isEdible()){
            message = "Yum, the " + i.getName() + " were tasty!";
            inventory.remove(i);
            itemsEaten ++;

            //if item is not edible
        }else if(!i.isEdible()){
            message = i.getName() + " is not edible.";
        }
    }

    /*************************************************************
     * Determines if game is won or lost
     * 
     * @return gameOver
     *************************************************************/
    public boolean gameOver(){
        //instance of losing game
        if(gameLost){
            message = "You have been taken hostage by the others."
            + " You are presumed dead, and rescue comes and leaves "
            + "without you. You lose.";
            return true;
        }

        //instance of winning game
        if(gameWon){
            message = "";

            //displays 10 lines of message
            for(int i = 0; i < 10; i++){
                message += "\n\n4,8,15,16,23,42";
            }
            message += "\n\nYou have used the sacred numbers."
            + "\nThe computer shuts off and the alarm sounds."
            + "\nThere is a bright light and a high pitch noise."
            + "\nDarkness envelops you.\nYou wake up in a church"
            + " surrounded by your family and friends who have "
            + "passed on before you...\nWhat is this place?\n"
            + "All you know is that you have left the island and"
            + " that gives you peace of mind.\n\n\nYou successfully"
            + " left the island.\nCongratulations.";
            return true;
        }
        return false;
    }

    /*************************************************************
     * Picks up items in room, adds to inventory
     *************************************************************/
    public void pickup(){
        //if there is no item in room
        if(!currentLoc.hasItem()){
            message = "Check your surroundings, there is no item...";

            //else pickup item
        }else if(currentLoc.getItem().getWeight() > 10){
            message = "Item is too heavy to carry!";
        }else{
            inventory.add(currentLoc.getItem());
            message = "You have picked up " + currentLoc.removeItem();
        }
    }

    /*************************************************************
     * Leaves item in inventory in current room
     * 
     * @param item the name of the item
     *************************************************************/
    public void leave(String item){
        Item i = searchInventory(item);             

        //if room has item
        if(currentLoc.hasItem()){
            message = "The room already has an item.";

            //if item is not null
        }else if(i != null){
            currentLoc.addItem(searchInventory(item));
            inventory.remove(searchInventory(item));
            message = "Item dropped successfully.";

            //if item is null
        }else if(i == null){
            message =  "You are not holding that!";

            //else update message
        }else{
            message = "You are not holding " + item + ".";
        }
    }

    /*************************************************************
     * Returns player to previous room if possible
     *************************************************************/
    public void backup(){
        //if previous location is null
        if(previousLoc == null){
            message = "You cannot go back from here.";
        }else{
            //if last location is others
            if(previousLoc == others){
                currentLoc = previousLoc;
                ben.setInteraction("I told you never to return, yet"
                    + " you still did. I must take you as hostage for"
                    + " your own good.");
                message = currentLoc.getLongDescription();
                gameLost = true;
            }
            currentLoc = previousLoc;
            previousLoc = null;
            show();
        }
    }

    /*************************************************************
     * Main method for testing purposes
     *************************************************************/
    public static void main(String args[]){
        Game g = new Game();
        System.out.println(g.getMessage());
        g.show();
        g.pickup();
        System.out.println(g.getMessage());
        g.inventory(); 
        System.out.println(g.getMessage());
        g.eat("bananas");
        System.out.println(g.getMessage());
        g.leave("book");   
        System.out.println(g.getMessage());
        g.move("outside");
        System.out.println(g.getMessage());
        g.move("inside");//oceanic 815
        System.out.println(g.getMessage());
        g.pickup();
        System.out.println(g.getMessage());
        g.move("outside");//beach
        System.out.println(g.getMessage());
        g.move("east");//kates hut
        System.out.println(g.getMessage());
        g.pickup();
        System.out.println(g.getMessage());
        g.move("inside");//kates food
        System.out.println(g.getMessage());
        g.pickup();
        System.out.println(g.getMessage());
        g.move("outside");//kates hut
        System.out.println(g.getMessage());
        g.move("west");//beach
        System.out.println(g.getMessage());
        g.move("south");//ocean
        System.out.println(g.getMessage());
        g.pickup();
        System.out.println(g.getMessage());
        g.move("inside");//dharma station
        System.out.println(g.getMessage());
        g.pickup();
        System.out.println(g.getMessage());
        g.move("outside");//ocean
        System.out.println(g.getMessage());
        g.move("north");//beach
        System.out.println(g.getMessage());
        g.move("north");//jungle
        System.out.println(g.getMessage());
        g.move("south");//jungle2
        System.out.println(g.getMessage());
        g.move("west");//hatch
        System.out.println(g.getMessage());
        //take notes
        g.move("east");//need to eat 2 foods
        System.out.println(g.getMessage());
        g.eat("boars meat");
        g.eat("bag of chips");
        g.move("east");//black rock
        System.out.println(g.getMessage());
        g.pickup();
        System.out.println(g.getMessage());
        //take notes
        g.move("west");//hatch
        System.out.println(g.getMessage());
        g.move("inside");//swan
        System.out.println(g.getMessage());
        g.move("inside");//computer
        System.out.println(g.getMessage());
        //type 4/8/15/16/23/42
    }
}