import java.util.HashMap;

/**
 * This class is part of the "Eternal Destiny" application. 
 * "Eternal Destiny" is a text based adventure game.
 * 
 * @author Andrea Siejna
 * @version 4.2.14
 */
public class Player {
    

    /** The maximum amount of items a player can carry */
    protected int maxInventorySize;
    
    /** The maximum weight a player can carry */
    private int maxWeight;

    /** Where the player is at the current time */
    private Room currentRoom;
    /**Where the player was previously*/
    private Room previousRoom;

    /** The current health of the player */
    private int health;

    /** The items a player has in their inventory */
    private HashMap<String, Item> inventory;



    /**
     * Constructor for objects of class Player
     * 
     * @param theCurrentRoom - the current room the player is in
     * @param maxSize - the maximum size of the inventory
     */
    public Player( Room theCurrentRoom, int maxSize )   {
        currentRoom = theCurrentRoom;
        previousRoom = currentRoom;

        inventory = new HashMap <String, Item> ();

        maxWeight = 1;
        maxInventorySize = maxSize;
        health = 100;
    }

    // Inventory swapping methods
    /**
     * Returns the player's inventory
     *
     *@return inventory - the player's inventory
     */
    public HashMap<String, Item> getInventory() {
        return inventory;
    }
    
        /**
     * Sets the player's inventory
     *
     *@param newInventory - the player's inventory
     */
    public void setInventory(HashMap<String, Item> newInventory) {
        inventory = newInventory;
    }

    // Room methods
    
    /**
     * Returns the previous room the player was in.
     * 
     * @param theRoom - The room that will be set as the current room
     */
    public void setCurrentRoom(Room theRoom) {
        previousRoom = currentRoom;   
        currentRoom = theRoom;

    }

    /**
     * Returns the current size of the player's inventory
     * 
     * @return inventory.length() - the size of the inventory currently
     */
    public int getInventorySize() {
        return inventory.size();
    }
    
    
    /**
     * Modifies the player's health
     * 
     * @param theHealth - The new health for the player
     */
    public void setHealth(int theHealth) {
        health = theHealth;

    }

    /**
     * Accesses the player's health
     * 
     * @return health - The health of the player
     */
    public int getHealth() {
        return health;

    }

    /**
     * Mutates the maximum weight a player can carry.
     * 
     * @param newWeight - the new weight the player can carry
     */
    public void setMaxWeight(int newWeight) {
        maxWeight = newWeight;
    }
    
        /**
     * Accesses the maximum weight a player can carry.
     * 
     * @return maxWeight - the maximum weight the player can carry
     */
    public int getMaxWeight() {
        return maxWeight;
    }

    /**
     * Returns the current room the player is in.
     * 
     * @return currentRoom - The current room the player is in
     */
    public Room getCurrentRoom() {
        return currentRoom;
    }

    /**
     * Returns the room the player was previously in.
     * 
     * @return previousRoom - The  room the player was previously in
     */
    public Room getPreviousRoom() {
        return previousRoom;
    }

    /**
     * Returns the maximum inventory size
     * 
     * @return maxInventorySize - the max inventory size
     */
    public int getMaxInventorySize() {
        return maxInventorySize;
    }

    // Item methods
    /**
     * Adds an item to the player's inventory
     * 
     * @param theItem - the item to be added to the inventory
     */
    public void addItem(Item theItem) {
        inventory.put( theItem.getName(), theItem );
        currentRoom.removeItem(theItem);

    }

    /**
     * Removes an item from the inventory
     * 
     * @param theItem - the item to be removed from the inventory
     * @return itemToRemove - the item to be removed
     */
    public Item removeItem(Item theItem) {
        Item itemToRemove = inventory.remove( theItem.getName() );

        return itemToRemove;
    }

    /**
     * Get an item from the inventory
     * 
     * @param theItem - the item to be searched for
     * @return - the item to be retrieved
     */
    public Item getItem(String theItem) {
        return inventory.get( theItem );
    }

    /**
     * Returns a list of items in the inventory
     * 
     * @return itemString - the list of items in the inventory
     */
    public String getItemString() {
        String itemString = "Inventory: ";
        int sumWeight = 0;

        for (Item item : inventory.values() ) {
            itemString = itemString.concat( item.getName() + ", ");
            sumWeight += item.getWeight();
        }

        String sumWeightString = Integer.toString(sumWeight);

        itemString = itemString.concat( "\n" + 
            "Total Weight: " + sumWeightString);

        return itemString;
    }

}
