import java.util.HashMap;

/**
 * This class is part of the "Eternal Destiny" application. 
 * "Eternal Destiny" is a text based adventure game.
 * 
 * @author Andrea Siejna
 * @version 4.5.14
 */
public class Character {
    /** The name of the character*/
    private String name;

    /**The room where the character is found */
    private Room room;

    /**The trigger word for the character */
    private String triggerWord;

    /**The dialogue/conversation for a given character */
    private Conversation dialogue;

    /**The character's inventory */
    private HashMap<String, Item> inventory;

    /**The character's special item needed for mission accomplishment*/
    private Item specialItem;

    /**Whether or not the character has its special item*/
    private boolean hasCorrectItem;

    /**Whether or not the character can be scared away */
    private boolean scared;

    /**
     * Constructor for objects of class Character
     * 
     * @param theName - the name of the character
     * @param theRoom - the room of the character's current location
     * @param theTriggerWord - the key that will start the character's 
     *                          conversation
     * @param theItem - the special item the character needs/uses
     * 
     */
    public Character(String theName, Room theRoom, String theTriggerWord, 
                     Item theItem ) {
        name = theName.toLowerCase();
        room = theRoom;
        triggerWord = theTriggerWord;
        dialogue = new Conversation (" ", " ");
        inventory = new HashMap <String, Item> ();
        specialItem = theItem;
        hasCorrectItem = false;
        scared = false;
    }

    /**
     * Accessor method for the character's name
     * @return name - the character's name
     */
    public String getName() {
        return name;
    }

    /**
     * Accessor method for the character's current room
     * @return room - the character's current room
     */
    public Room getRoom() {
        return room;
    }

    /**
     * Mutator method for the character's dialogue
     * @param theDialogue - the character's dialogue
     */
    public void setDialogue(Conversation theDialogue) {
        dialogue = theDialogue;
    }

    /**
     * Accessor method for the character's dialogue
     * @return dialogue - the character's dialogue
     */
    public Conversation getDialogue() {
        return dialogue;
    }

    /**
     * Mutator method for the character's scare
     * @param theScare - if the character can be scared or not
     */
    public void setScared(Boolean theScare) {
        scared = theScare;
    }

    /**
     * Accessor method for the character's scared
     * @return dialogue - the character's scared
     */
    public boolean getScared() {
        return scared;
    }


    // Item methods

    /**
     * Adds an item to the character's inventory
     * 
     * @param theItem - the item to be added to the inventory
     */
    public void addItem(Item theItem) {
        inventory.put( theItem.getName(), theItem );
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
        String itemString = name + " is holding: ";

        for (Item item : inventory.values() ) {
            itemString = itemString.concat( item.getName() + ", ");
        }

        return itemString;
    }

    /**
     * Returns boolean whether the character has its special item or not
     * 
     * @return hasCorrectItem - boolean of whether the NPC
     *                          has a 
     */
    public boolean hasCorrectItem() {

        if (specialItem == null) {

        } 
        else
        {

            if ( getItem( specialItem.getName() ) != null ) {
                hasCorrectItem = true;
            } 
            else {
                hasCorrectItem = false;
            }
        }
        return hasCorrectItem;

    }

    /**
     * Returns the NPC's special item 
     * 
     * @return specialItem - the NPC's special item
     */
    public Item getSpecialItem() {
        return specialItem;
    }

    /**
     * How the character responds to getting attacked
     * 
     * @return 0 - for Monster class purposes
     */
    public int attackString() {
        System.out.println("You cannot attack this character.");
        return 0;
    }
}