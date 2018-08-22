/**
 * Class Door - a door or portal between two Rooms in an adventure game.
 * 
 * This class is part of the "Eternal Destiny" application. 
 * "Eternal Destiny" is a text based adventure game.
 * 
 * A "Door" represents a door or portal between two locations of the game.
 * It stores a reference to the neighboring room and whether that door
 * or portal is locked.  Doors are not locked by default.
 * 
 * @author Maria Jump, Andrea Siejna
 * @version 2013.01.22
 */
public class Door {

    /** The room that this door leads to */
    private Room destination;
    /** Whether this door is locked */
    private boolean locked;
    /** The 'key' item that can unlock this door */
    private Item key;

    /**
     * Constructor for the Door class
     * @param theDestination The room this door leads to
     */
    public Door(Room theDestination) {
        destination = theDestination;
        locked = false;
        key = new Item("key", "Shiny, gold key", 1);
    }

    /**
     * A getter for the room this door leads to
     * @return The room this door leads to
     */
    public Room getDestination() {
        return destination;
    }

    /**
     * An accessor method for the 'key' item
     * @return The key for this room
     */
    public Item getKey() {
        return key;
    }
    
  
       /**
     * A getter for whether this door is locked.
     * 
     * @return Whether this door is locked 
     */
    public boolean isLocked() {
        return locked;
    }

    /**
     * A setter for whether this door is locked.
     * 
     * @param isLocked Whether this door is locked.
     */
    public void setLocked(boolean isLocked) {
        locked = isLocked;
    }

    /**
     * A method that unlocks a locked door.
     */
    public void unlock() {
           
        if ( isLocked() ) {
            locked = false;
        }
        
        
    }
}
