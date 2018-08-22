
/**
  * This class is part of the "Eternal Destiny" application. 
 * "Eternal Destiny" is a text based adventure game.
 * 
 * This is the specific Human Class of Type Player
 * 
 * @author Andrea Siejna
 * @version 4.23.14
 */
public class Human extends Player
{
     /**
     * Constructor for objects of class Human
     * 
     * @param theCurrentRoom - the current room of the Human
     * @param maxSize - the maximum size of the inventory
     */
    public Human(Room theCurrentRoom, int maxSize)
    {
        super(theCurrentRoom, maxSize);
    }   
}