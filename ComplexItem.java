import java.util.HashMap;
import java.lang.String;

/**
 * This class is part of the "Eternal Destiny" application. 
 * "Eternal Destiny" is a text based adventure game.
 * 
 * A complex item is an item that contains other items. (Backpack, toolbox, etc.)
 * 
 * @author Andrea Siejna
 * @version 3.21.14
 */
public class ComplexItem extends Item
{
    /** Container for all the individual items found within the complex item */
    private HashMap <String, Item> containedItems;

    /** Maximum amount of items a complexItem can hold */
    private static final int MAX;

    /**
     * Constructor for the ComplexItem class
     * 
     * @param theName - the name of the complex item
     * @param theDescription - the description of the complex item
     * @param theWeight - the weight of the complex item
     */
    public ComplexItem(String theName, String theDescription, int theWeight) {
        super(theName, theDescription, theWeight);

        containedItems  = new HashMap <> ();
    
    }

    static {
        MAX = 5;  
    }

    /**
     * Method that adds an item to the complex item
     */
    public void addItem(Item item){
        containedItems.put( item.getName() , item );
    }

    /**
     * Returns an array of names of the items that are contained in the complex item
     * 
     */
    public String[] getItemNames(){
        String[] itemNames = new String[MAX];
        int index = 0;

        for (String itemName : containedItems.keySet() ){
            itemNames[index] = itemName;
            index++;
        }

        return itemNames;
    }

    /**
     * Removes the named item from the complex item
     *
     */
    public Item removeItem(String name){
        Item removedItem = containedItems.remove(name);

        return removedItem;
    }
    
    
    /**
     * Returns the item within the complex item
     * 
     * @param theItem - the item to be searched for
     * @return - the item to be retrieved
     */
    public Item getItem(String theItem){
        theItem = theItem.toLowerCase();

        return containedItems.get( theItem );
    }

    /**
     * Returns a string representing the item
     * @return - a string representing the item
     */
    public String toString(){
        String itemString = getName() + " contains: ";
        String[] itemNames = getItemNames();
        
        for (int index = 0; index < itemNames.length; index++){
            if ( itemNames[index] == null ){
                
            } else
            {
                itemString = itemString.concat( itemNames[index] + ", ");
            }
            
        }
        
        
        itemString = itemString.concat( "\n" + getDescription() + "\n" + "[Weight: " + getWeight() + "]");
        return itemString;
    }
}
