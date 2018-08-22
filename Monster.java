import java.util.Random;

/**
 * This class deals with characters during the attack command
 * and how they respond
 * 
 * @author Andrea Siejna
 * @version 4.28.14
 */
public class Monster extends Character
{
    /** The health of the monster*/
    private int health;

    /** The hit damage randomizer */
    private Random generator;

    /**
     * Constructor for objects of class Monster
     * 
     * @param theName - the name of the character
     * @param theRoom - the room of the character's current location
     * @param theTriggerWord - the key that will start the 
     *                      character's conversation
     * @param theItem - the special item the character needs/uses
     * 
     */
    public Monster(String theName, Room theRoom, 
                    String theTriggerWord, Item theItem ) {
        super (theName, theRoom, theTriggerWord, theItem);
        health = 100;
        generator = new Random();
        
    }

    /**
     * Get the monster's health
     * 
     * 
     * @return - the monster's health
     */
    public int getHealth() {
        return health;
    }

    /**
     * How the character responds to getting attacked
     * 
     * @return deathNumber - 1 for Monster killed, 0 for not
     */
    public int attackString() {
        System.out.println("You have injured " + getName() + ".");
        int randomNumber = generator.nextInt(50) + 1;
        int deathNumber = 0;
        health -= randomNumber;
        if (health <= 0) {
            System.out.println("You have successfully killed the " 
                + getName() + "!");
            deathNumber = 1;
                      
        } 
        else {    
            System.out.println(getName() + "'s health: " + getHealth() );
            System.out.println(getName() + " attacked you back!");
            deathNumber = 0;
        }
        
        return deathNumber;
    }

}
