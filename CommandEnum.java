/**
 * This class is part of the "Eternal Destiny" application. 
 * "Eternal Destiny" is a text based adventure game.
 * 
 * Enumeration that holds each command word.
 * 
 * @author Andrea Siejna, Andrea Siejna
 * @version 2/26/14
 * 
 * 
 */
public enum CommandEnum
{
    /** Enums representing each of the available commands*/
    BACK ("back"), LOOK ("look"), SCORE ("score"), TIME ("time"),
    /** Enums representing each of the available commands*/
    STATUS ("status"), GO ("go"), QUIT ("quit"), HELP ("help"),
    /** Enums representing each of the available commands*/
    EXAMINE ("examine"), PACK ("pack"), UNPACK ("unpack"),
    /** Enums representing each of the available commands*/
    TAKE ("take"), DROP ("drop"), INVENTORY ("inventory"), STEAL ("steal"),
    /** Enums representing each of the available commands*/
    UNLOCK ("unlock"), SAY ("say"), GIVE ("give"), OBSERVE ("observe"),
    /** Special commands - Lioness */
    ROAR ("roar"),
    /** Special commands - Lemur */
    CLIMB ("climb"), 
    /** Special commands - Pelican */
    SQUAWK ("squawk"), FLY ("fly"), PECK ("peck"),
    /** Special commands - Shark */
    SWIM ("swim"),
    /** Special commands - Human */
    ATTACK ("attack"),
    /** Special commands - Dog */
    BARK ("bark"),
    /** Special commands - Lioness, Shark, Dog */
    BITE ("bite"),
    /** Special command */
    MORPH ("morph");

    /** The String-associated name of the command */
    private String name;

    /** 
     * Constructor 
     * @param theName - the inputted name for the command word
     */
    private CommandEnum (String theName) {
        name = theName;
    }

    /** 
     * Override toString to return the full name associated with the command.
     * @return name - the name of the command word 
     */
    public String toString() {
        return name;
    }
}



