
/**
  * This class is part of the "Eternal Destiny" application. 
 * "Eternal Destiny" is a text based adventure game.
 * 
 * This is the specific Lemur Class of Type Player
 * 
 * @author Andrea Siejna
 * @version 4.23.14
 */
public class Lemur extends Player
{
     /**
     * Constructor for objects of class Lemur
     * 
     * @param theCurrentRoom - the current room of the Lemur
     * @param maxSize - the maximum size of the inventory
     */
    public Lemur(Room theCurrentRoom, int maxSize)
    {
        super(theCurrentRoom, maxSize);
    }   
}