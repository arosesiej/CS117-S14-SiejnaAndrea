
/**
  * This class is part of the "Eternal Destiny" application. 
 * "Eternal Destiny" is a text based adventure game.
 * 
 * This is the specific Shark Class of Type Player
 * 
 * @author Andrea Siejna
 * @version 4.23.14
 */
public class Shark extends Player
{
     /**
     * Constructor for objects of class Shark
     * 
     * @param theCurrentRoom - the current room of the Shark
     * @param maxSize - the maximum size of the inventory
     */
    public Shark(Room theCurrentRoom, int maxSize)
    {
        super(theCurrentRoom, maxSize);
    }   
}