
/**
  * This class is part of the "Eternal Destiny" application. 
 * "Eternal Destiny" is a text based adventure game.
 * 
 * This is the specific Pelican Class of Type Player
 * 
 * @author Andrea Siejna
 * @version 4.23.14
 */
public class Pelican extends Player
{
     /**
     * Constructor for objects of class Pelican
     * 
     * @param theCurrentRoom - the current room of the Pelican
     * @param maxSize - the maximum size of the inventory
     */
    public Pelican(Room theCurrentRoom, int maxSize)
    {
        super(theCurrentRoom, maxSize);
    }   
}