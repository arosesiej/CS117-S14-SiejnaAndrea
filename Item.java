
/**
 * This class is part of the "Eternal Destiny" application. 
 * "Eternal Destiny" is a text based adventure game.
 * 
 * An item represents an object that the user can 
 * interact with. It may be carried or used.
 * 
 * 
 * @author Andrea Siejna
 * @version 3.21.14
 */
public class Item {
    /**The name of the item */
    private String name;

    /**The description of the item */
    private String description;

    /**The weight of the item */
    private int weight;

    /**
     * Constructor for the item class
     * 
     * @param theName - the name of the item
     * @param theDescription - the description of the item
     * @param theWeight - the weight of the item
     */
    public Item(String theName, String theDescription, int theWeight ) {
        name = theName;
        description = theDescription;
        weight = theWeight;
    }

    /**
     * Mutator method for the description field
     * 
     * @param theDescription - the description of the item
     */
    public void setDescription(String theDescription) {
        description = theDescription;
    }

    /**
     * Mutator method for the weight field
     * 
     * @param theWeight - the weight of the item
     */
    public void setWeight(int theWeight) {
        weight = theWeight;
    }

    /**
     * Accessor method for the name field
     * @return name - the name of the item
     */
    public String getName() {
        return name;
    }

    /**
     * Accessor method for the description field
     * @return description - the description of the item
     */
    public String getDescription() {
        return description;
    }

    /**
     * Accessor method for the weight field
     * @return weight - the weight of the item
     */
    public int getWeight() {
        return weight;
    }
    
    /**
     * Returns a string representing the item
     * @return - a string representing the item
     */
    public String toString() {
        String itemString = getName() + " \n" + getDescription() + "\n" +
                            "[Weight: " + getWeight() + "]"; 
        return itemString;
    }
}
