import java.util.HashMap;

/**
 * 
 * This class is part of the "Eternal Destiny" application. 
 * "Eternal Destiny" is a text based adventure game.
 * 
 * A "Room" represents one location in the scenery of the game. It is connected
 * to other rooms via doors. The doors are labeled north, east, south, west.
 * For each direction, the room stores a reference to an instance of door.
 * 
 * @author Maria Jump, Andrea Siejna
 * @version 2013.01.22
 */
public class Room {
    /** The name of this room.  Room names should be unique */
    private String name;
    /** The description of this room */
    private String description;
    /** The area of the room (Spirit World, Savanna, Sea, City) */
    private String area;

    /** The room's exits, null if none exits */
    protected HashMap<String, Door> exits;

    /**The room's items */
    private HashMap<String, Item> items;

    /**The room's characters */
    private HashMap<String, Character> characters;

    /**
     * Create a room described "description". Initially, it has no exits.
     * "description" is something like "a kitchen" or "an open court yard".
     * 
     * @param theName This room's name.
     * @param theDescription
     *            This room's description.
     * @param theArea The room's area.
     */
    public Room(String theName, String theDescription, String theArea) {
        name = theName;
        description = theDescription;
        area = theArea;

        exits = new HashMap <String, Door> ();
        items = new HashMap <String, Item> ();
        characters = new HashMap <String, Character> ();
    }

    /**
     * Return the door in the requested direction.
     * 
     * @param direction The direction of where the door leads to.
     * @return The door in the requested direction.
     */
    public Door getExit(String direction) {
        Door exit = null;

        if ( direction.equalsIgnoreCase(direction) ) {
            exit = exits.get(direction);
        } 

        else {
            // exit stays null
        }

        return exit;
    }

    /**
     * Define an exit from this room.
     * 
     * @param direction The direction of the exit.
     * @param neighbor The door in the given direction.
     */
    public void setExit( String direction, Door neighbor ) {
        exits.put(direction, neighbor);
    }

    /**
     * Returns the name of this room.
     * 
     * @return The name of this room.
     */
    public String getName() {        
        return name;
    }

    /**
     * Returns the description of this room.
     * 
     * @return The description of this room.
     */
    public String getDescription() {        
        return description;
    }
    
    
    /**
     * Returns the area of this room.
     * 
     * @return The area of this room.
     */
    public String getArea() {        
        return area;
    }

    /**
     * Return a description of the room's exits.
     * For example, "Exits: north west".
     * 
     * @return A description of the availible exits.
     */
    public String getExitString() {
        String exitString = "[Exits]: ";

        for (String direction : exits.keySet() ) {
            if ( getExit(direction) != null) {
                exitString = exitString.concat(direction + ", ");
            }

        }

        return exitString;
    }

    /**
     * Adds an item to the room
     * 
     * @param theItem - the item to be added to the room
     */
    public void addItem(Item theItem) {
        items.put( theItem.getName(), theItem );
    }

    /**
     * Removes an item from the room
     * 
     * @param theItem - the item to be removed from the room
     */
    public void removeItem(Item theItem) {
        items.remove( theItem.getName() );
    }

    /**
     * Get an item from a room
     * 
     * @param theItem - the item to be searched for
     * @return - the item to be retrieved
     */
    public Item getItem(String theItem) {

        return items.get( theItem.toLowerCase() );
    }

    /**
     * Returns a list of items in a room
     * 
     * @return itemString - the list of items in the room
     */
    public String getItemString() {
        String itemString = "[Items]: ";

        for (String itemName : items.keySet() ) {
            itemString = itemString.concat(itemName + ", ");
        }

        return itemString;
    }

    //Character methods

    /**
     * Adds a character to the room
     * 
     * @param theCharacter - the character to be added to the room
     */
    public void addCharacter(Character theCharacter) {
        characters.put( theCharacter.getName(), theCharacter );
    }

    /**
     * Get a character from a room
     * 
     * @param theCharacter - the character to be searched for
     * @return - the character to be retrieved
     */
    public Character getCharacter(String theCharacter) {

        return characters.get( theCharacter.toLowerCase() );

    }

    /**
     * Returns a list of characters in a room
     * 
     * @return characterString - the list of characters in the room
     */
    public String getCharacterString() {
        String characterString = "[Creatures]: ";

        for (String characterName : characters.keySet() ) {
            characterString = characterString.concat(characterName + ", ");
        }

        return characterString;
    }

    /**
     * Removes a character from the room
     * 
     * @param theCharacter - the character to be removed from the room
     */
    public void removeCharacter(Character theCharacter) {
        characters.remove( theCharacter.getName() );
    }
      
    
}

