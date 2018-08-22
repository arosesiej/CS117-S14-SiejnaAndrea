/**
 * This class deals with characters during the attack command
 * and how they respond
 * 
 * @author Andrea Siejna
 * @version 4.28.14
 */
public class LosePointsCharacter extends Character
{
    /**
     * Constructor for objects of class LosePointsCharacter
     * 
     * @param theName - the name of the character
     * @param theRoom - the room of the character's current location
     * @param theTriggerWord - the key that will start 
     *                         the character's conversation
     * @param theItem - the special item the character needs/uses
     * 
     */
    public LosePointsCharacter(String theName, Room theRoom, 
                             String theTriggerWord, Item theItem ) {
        super(theName, theRoom, theTriggerWord, theItem);
    }

    /**
     * How the character responds to getting attacked
     * 
     * @return 0 - for Monster class purposes
     */
    public int attackString() {

        if ( getName().equals("zebra (tall)") || 
            (getName().equals("zebra") ) ) {
            System.out.println(getName() + 
                " has dodged your attack and ran away.");    
        } 
        else {        
            System.out.println("You have killed " + getName() + "!");
        }
        
        return 0;
    }
}
