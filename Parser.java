import java.util.ArrayList;
import java.util.Scanner;
import java.lang.String;

/**
 * This class is part of the "Eternal Destiny" application. 
 * "Eternal Destiny" is a text based adventure game.
 * 
 * This parser reads user input and tries to interpret it as an "Adventure"
 * command. Every time it is called it reads a line from the terminal and tries
 * to interpret the line as a two word command. It returns the command as an
 * object of class Command.
 * 
 * The parser has a set of known command words. It checks user input against the
 * known commands, and if the input is not one of the known commands, it returns
 * a command object that is marked as an unknown command.
 * 
 * @author Maria Jump, Andrea Siejna
 * @version 2013.03.12
 */
public class Parser {
    /** Holds all valid command words */
    private CommandWords commands;
    /** The source of command input */
    private Scanner reader;

    /**
     * Create a parser to read from the terminal window.
     */
    public Parser() {
        commands = new CommandWords();
        reader = new Scanner(System.in);
    }

    /**
     * Returns the next command from the user.
     * @return The next command from the user.
     */
    public Command getCommand() {
        String inputLine; // will hold the full input line
        String word1 = null;
        ArrayList<String> restOfLine = new ArrayList<String>();


        System.out.print("> "); // print prompt

        inputLine = reader.nextLine().toLowerCase();

        // Find up to two words on the line.
        Scanner tokenizer = new Scanner(inputLine);
        if (tokenizer.hasNext()) {
            word1 = tokenizer.next(); // get first word  
            if (tokenizer.hasNext()) {
                while (tokenizer.hasNext()) {
                    restOfLine.add(tokenizer.next());
                }
            }
        }
        tokenizer.close();

        // Now check whether this word is known. If so, create a command
        // with it. If not, create a "null" command (for unknown command)

        Command returnedCommand = new Command( commands.getCommand(word1),
                restOfLine);

        return returnedCommand;
    }
    /**
     * Used only for initial prompt for character type
     * (e.g. first time arrive in clearing, buoy, apartment
     * 
     * @return word1 - returns first word
     */
    public String getUserResponse() {
        String inputLine; // will hold the full input line
        String word1 = null;
        ArrayList<String> restOfLine = new ArrayList<String>();


        System.out.print("> "); // print prompt

        inputLine = reader.nextLine().toLowerCase();

        // Find up to two words on the line.
        Scanner tokenizer = new Scanner(inputLine);
        if (tokenizer.hasNext()) {
            word1 = tokenizer.next(); // get first word  
            if (tokenizer.hasNext()) {
                while (tokenizer.hasNext()) {
                    restOfLine.add(tokenizer.next());
                }
            }
        }
        tokenizer.close();    
        
        //
        return word1;
    }

    /**
     * Return the response to a question in lower case.
     * 
     * @return The response typed in by the user.
     */
    public String getResponse() {
        return getResponse(true);
    }

    /**
     * Return the response to a question.
     * 
     * @param changeCase Whether the input should be converted 
     * to all lower case characters.
     * 
     * @return The response typed in by the user.
     */
    public String getResponse(boolean changeCase) {
        String inputLine = reader.nextLine().trim();
        if (changeCase) {
            return inputLine.toLowerCase();
        }
        else {
            return inputLine;
        }
    }

    /**
     * Return a list of the available commands.
     * 
     * @return The list of available commands.
     */
    public String getCommandString() {
        return commands.getCommandString();
    }     

}
