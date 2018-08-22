import java.util.HashMap;
import java.lang.String;

/**
 * This class is part of the "Eternal Destiny" application. 
 * "Eternal Destiny" is a text based adventure game.
 * 
 * This class holds an enumeration of all command words known to the game. It is
 * used to recognize commands as they are typed in.
 * 
 * @author Maria Jump, Andrea Siejna
 * @version 2013.01.22
 */

public class CommandWords {
    /** a constant array that holds all valid command words */
    private HashMap <String, CommandEnum> validCommands;

    /**
     * Constructor - initialize the command words in the HashMap.
     */
    public CommandWords() {
        validCommands  = new HashMap <String, CommandEnum> ();

        for (CommandEnum command : CommandEnum.values() ) {
            validCommands.put(command.toString(), command );
        }

    }

    /**
     * Check whether a given String is a valid command word.
     * 
     * @param aString The string to determine whether it is a valid command.
     * @return true if a given string is a valid command, false if it isn't.
     */
    public boolean isCommand(String aString) {
        boolean isCommand = false;    
        if ( validCommands.get(aString) != null ) {
            isCommand = true;
        }
        return isCommand;
    }

    /**
     * Return a list of the available commands, of the form:
     *      Your command words are:
     *          look    go      quit    help
     *          
     *@return A string containing the list of available commands.
     */
    public String getCommandString() {
        String commandString = "Your commands words are: \n";

        for (String commandWord : validCommands.keySet() ) {
            commandString = commandString.concat(commandWord + ", ");
        }
        return commandString;
    }

    /**
     * Convert a string into a CommandEnum object.
     * @param aString The string containing the command word.
     * @return The CommandEnum object representing the command.
     */
    public CommandEnum getCommand(String aString) {

        return validCommands.get(aString);
    }

}
