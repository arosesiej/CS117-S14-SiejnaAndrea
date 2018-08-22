/**
 * This class deals with characters during the attack command
 * and how they respond
 * 
 * @author Andrea Siejna
 * @version 4.28.14
 */
public class EndGameCharacter extends Character
{
    /**
     * Constructor for objects of class EndGameCharacter
     * 
     * @param theName - the name of the character
     * @param theRoom - the room of the character's current location
     * @param theTriggerWord - the key that will start 
     *                          the character's conversation
     * @param theItem - the special item the character needs/uses
     * 
     */
    public EndGameCharacter(String theName, Room theRoom, 
                            String theTriggerWord, Item theItem ) {
        super(theName, theRoom, theTriggerWord, theItem);
    }
    
    /**
     * How the character responds to getting attacked
     * 
     *  @return 0 - for Monster class purposes
     */
    public int attackString() {

        if ( getName().equals("elephant") || (getName().equals("warthog") || 
            getName().equals("stringray") || getName().equals("cop") ) ) {
            System.out.println(getName() + 
                " is now pissed and has killed you!");
              
        } 
        else {        
            System.out.println(getName() + 
                " has been killed! Mission failed.");  
        }
        
        return 0;
    }
}
