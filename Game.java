import java.util.Random;
import java.util.HashMap;

/**
 * This class is the main class of the "Eternal Destiny" application.
 * "Eternal Destiny" is a text based adventure game. 
 * 
 * This game class creates and initializes all the others: it creates all
 * rooms, creates the parser and starts the game. It also evaluates and
 * executes the commands that the parser returns.
 * 
 * @author Maria Jump, Andrea Siejna
 * @version 2013.01.22
 */

public class Game {
    
    /** The maximum score of the game */
    private static final int MAXIMUM_SCORE;

    /** The parser for getting input from */
    private Parser parser;
    /** The world where the game takes place */
    private World world;
    /** The player which plays the game */
    private Player player;

    /**The current number of turns the player has taken so far */
    private int time;

    /**The current state of whether the mission is won or not */
    private int missionWon;
    // 0 = start of game, -1 = lost game, 1 = mission accomplished

    /**The current state of whether the game is won or not */
    private int gameWon;
    
    /**The score of the current mission */
    private int missionScore;
    
    /**The overall score of the game */
    private int gameScore;
    
    /**If the game is finished or not */
    private boolean finished;
    
       
    static {
        MAXIMUM_SCORE = 2300;  
    }

    /**
     * Create the game and initialize its internal map.
     */
    public Game() {
        parser = new Parser();
        world = new World();
        player = new Player( world.getRoom("Plain"), 3);
        missionWon = 0;
        gameWon = 0;
        time = 0;
        gameScore = 0;
        missionScore = 0;
        finished = false;
    }

    /**
     * Main play routine. Loops until end of play.
     */
    public void play() {
        printWelcome();

        // Enter the main command loop. Here we repeatedly read commands and
        // execute them until the game is over.

        
        while (!finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);

            missionAccomplished();

            time++;

        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome() {
        System.out.println("Welcome to An Eternal Destiny! \n" +
            "\n Your vision is blurry and you feel disoriented." + 
            " You have no recollection of \n" +
            "who you are or where you are. The" +
            " only thing you're sure of is that you're \n" +
            "a spirit. As you look around, you notice that" + 
            " you're in a very desolate \n" +
            "place. The world around you is foggy" +
            " and has a dreary atmosphere among it. \n" +
            "You become despondent and unsure of" +
            " your purpose in life... \n" +
            "\n ... so you set out to figure out what that is! \n" +
            "\nType 'help' if you need any! \n");
        printLocationInformation();
    }

    /**
     * Given a command, process (that is: execute) the command.
     * 
     * @param command
     *            The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) {
        boolean wantToQuit = false;

        if (command.isUnknown()) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        CommandEnum commandWord = command.getCommandWord();

        switch (commandWord) {
            case HELP:
                printHelp();
                break;

            case GO:
                goRoom(command);
                break;

            case QUIT:
                wantToQuit = quit(command);
                break;

            case LOOK:
                look();
                break;

            case STATUS:
                status();
                break;

            case SCORE:
                score();
                break;

            case TIME:
                time();
                break;

            case BACK:
                back();
                break;

            case EXAMINE:
                examine(command);
                break;

            case UNPACK:
                unpack(command);
                break;

            case PACK:
                pack(command);
                break;

            case TAKE:
                take(command);
                break;

            case DROP:
                drop(command);
                break;

            case INVENTORY:
                inventory();
                break;

            case UNLOCK:
                unlockDoor(command);
                break;

            case SAY:
                say(command);
                break;

            
            case GIVE:
                give(command);
                break;

            case MORPH:
                morph(command);
                break;

            case OBSERVE:
                observe(command);
                break;

            case STEAL:
                steal(command);
                break;

            /////////////SPECIAL CREATURE COMMANDS

            case ROAR:
                if (player instanceof Lioness) {
                    scare(command);
                } 
                else {
                    System.out.println("You must be the lioness to roar!");
                }
                break;

            case SQUAWK:
                if (player instanceof Pelican) {
                    scare(command);
                } 
                else {
                    System.out.println("You must be the pelican to squawk!");
                }
                break;

            case BARK:
                if (player instanceof Dog) {
                    scare(command);
                } 
                else {
                    System.out.println("You must be the dog to bark!");
                }
                break;

            case CLIMB:
                if (player instanceof Lemur) {
                    climb(command);
                } 
                else {
                    System.out.println("You must be the lemur to climb!");
                }
                break;

            case FLY:
                if (player instanceof Pelican) {
                    fly(command);
                }  
                else {
                    System.out.println("You must be the pelican to fly!");
                }
                break;

            case SWIM:
                if (player instanceof Shark) {
                    swim(command);
                } 
                else {
                    System.out.println("You must be the shark to swim!");
                }
                break;

            case ATTACK:
                if (player instanceof Human) {
                    attack(command);
                } 
                else {
                    System.out.println("You must be the human to attack!");
                }
                break;

            case BITE:
                if (player instanceof Lioness || player instanceof Shark || 
                    player instanceof Dog) {
                    bite(command);
                } 
                else {
                    System.out.println("You must be the lioness/dog/" + 
                                        "shark to bite!");
                }
                break;

            case PECK:
                if (player instanceof Pelican) {
                    peck(command);
                } 
                else {
                    System.out.println("You must be the pelican to peck!");
                }
                break;

            default:
                break;
        }

        return wantToQuit;
    }

    // implementations of user commands:
    /**
     * Print out some help information. Here we print some stupid, cryptic
     * message and a list of the command words.
     */
    private void printHelp() {
        System.out.println("You are a spirit wandering aimlessly to find your");
        System.out.println("purpose in life. Try to find where you belong in");
        System.out.println("the world.");
        System.out.println();
        System.out.println("(HINT: have you checked your spelling?)");
        System.out.println( parser.getCommandString() );
    }

    /**
     * Try to go to one direction. If there is an exit, enter the new room,
     * otherwise print an error message.
     * 
     * @param command The go command.
     */
    private void goRoom(Command command) {
        if (!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        String direction = command.getRestOfLine();

        // Try to leave current .
        Door doorway = null;

        Room currentRoom = player.getCurrentRoom();

        if (direction.equals("up") || direction.equals("down") ) {
            System.out.println("You must use a special command to" + 
                " move that way. Try climb, fly, or swim");
        }
        else {  

            doorway = currentRoom.getExit(direction);

            if (doorway == null) {
                System.out.println("There is no door!");
            } 
            else {

                if (doorway.isLocked() ) {
                    System.out.println("Door is locked!");
                } 
                else {

                    player.setCurrentRoom(doorway.getDestination());
                    printLocationInformation();

                }
            }

        }
    }

    /**
     * "Quit" was entered. Check the rest of the command to see whether we
     * really quit the game.
     * 
     * @param command The quit command.     * 
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) {
        if (command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        } 
        else {
            
            return true; // signal that we want to quit
        }
        
    }

    /**
     * Print out information of where the player is 
     * at the current time
     */
    private void printLocationInformation() {
        Room currentRoom = player.getCurrentRoom();

        System.out.println( currentRoom.getName() + ": " );        
        System.out.println( currentRoom.getDescription() );
        System.out.println();
        System.out.println("------------Information------------");
        System.out.println( currentRoom.getCharacterString() );
        System.out.println( currentRoom.getItemString() );
        System.out.println( currentRoom.getExitString() );
        System.out.println("------------------------------------");

        System.out.println();
    }

    /**
     * Print out the description of the room and exits.
     */
    private void look() {

        printLocationInformation();

    }

    /**
     * Takes the player into the previous room he/she was in. 
     */
    private void back() {
        Room temp = player.getPreviousRoom();
        player.setCurrentRoom(temp);
        look();

    }

    /**
     * Prints out the current score.
     */
    private void score() {
        System.out.println("Your current score is " + 
            missionScore + " out of " + MAXIMUM_SCORE 
            + " points.");
    }

    /**
     * Prints out the current number of turns that a player has used so far.
     */
    private void time() {
        System.out.println("You have used " + time + " turns so far.");    
    }

    /**
     * Prints out the current state of the game including the 
     * complete description of the current room, the player's 
     * score, and the number of turns a player has used so far,
     * and the current form of the player.
     */
    private void status() {
        score();
        time();
        currentForm();
        System.out.println("Current health: " + player.getHealth() );
    }

    /**
     * Prints out the current form of the player
     * Creature type: Lioness, Lemur, Shark, Pelican, Human, Dog
     */
    private void currentForm() {
        if (player instanceof Lioness) {
            System.out.println("Current form: Lioness");
        } 
        else if (player instanceof Lemur) {
            System.out.println("Current form: Lemur");
        } 
        else if (player instanceof Pelican) {
            System.out.println("Current form: Pelican");
        } 
        else if (player instanceof Shark) {
            System.out.println("Current form: Shark");
        } 
        else if (player instanceof Human) {
            System.out.println("Current form: Human");
        } 
        else if (player instanceof Dog) {
            System.out.println("Current form: Dog");
        } 
        else {
            System.out.println("Current form: Spirit");
        }
    }

    /**
     * Prints out a complete description of the named item. 
     * When a complex item is examined, the items that are 
     * contained inside are listed.
     * 
     * @param command - the command input from the player
     */
    private void examine(Command command) {
        if (!command.hasSecondWord()) {
            // if there is no second word, we don't know what to examine.
            System.out.println("Examine what?");
            return;
        }

        String item = command.getRestOfLine();

        Room currentRoom = player.getCurrentRoom();

        Item itemToExamine = currentRoom.getItem(item);

        if (itemToExamine == null) {
            System.out.println("That item doesn't exist here!");
            
                
                        
        } 
        else {
            System.out.println( itemToExamine.toString() );
            
            if ((itemToExamine.getName()).equals("boulder") ||
                            (itemToExamine.getName()).equals("dirt") ||
                            (itemToExamine.getName()).equals("rubble") ||
                            (itemToExamine.getName()).equals("rocks") ||
                            (itemToExamine.getName()).equals(
                                "sign - savanna") ||
                            (itemToExamine.getName()).equals("sign - sea") ||
                            (itemToExamine.getName()).equals("sign - city") )  {
                              gameScore += 100;
            }
        }
    }

    /**
     * Remove all of the items inside a complex item and place them
     * in the current room.
     * 
     * @param command - the command of the user
     */
    private void unpack(Command command) {
        if (!command.hasSecondWord()) {
            // if there is no second word, we don't know what to unpack.
            System.out.println("Unpack what?");
            return;
        }

        //Turns the rest of the response into the item 
        //that we want to unpack's String name
        String item = command.getRestOfLine();

        //Turns the string ^^ into an Item (retrieves it from the room).
        Room currentRoom = player.getCurrentRoom();
        Item itemToUnpack = currentRoom.getItem(item);

        //If successfully retrieved it won't be null
        if (itemToUnpack == null) {
            System.out.println("That item doesn't exist here!");
        } 
        else {
            //Checks to see if it is a complex item that can be unpacked
            if (itemToUnpack instanceof ComplexItem) {
                //Retrieves a string array holding all the
                //names of the items inside the complex item
                String[] itemNames = ((ComplexItem)itemToUnpack).getItemNames();

                //Loops through the each item name inside the complex item
                for (int index = 0; index < itemNames.length; index++) {

                    //If there isn't an item inside then do nothing
                    if (itemNames[index] == null) {

                        // If there is an item, remove it.
                    } 
                    else {
                        // Goes through each item inside the complex item
                        // retrieves its name and removes it by name
                        // returns that item and adds it to the current room

                        currentRoom.addItem(((ComplexItem)itemToUnpack)
                            .removeItem( itemNames[index] )  );

                    }

                }

                look();

            } 
            else {
                System.out.println("You can't unpack anything from that!");
            }

        }

    }

    /**
     * Moves the specified item into the specified complex item
     * 
     * @param command - the command of the user
     */
    private void pack(Command command) {
        if (!command.hasSecondWord()) {
            // if there is no second word, this command isn't usable
            System.out.println("Use format 'Pack ___ into ___ '");
            return;
        }

        // Grabs rest of line "item into Complexitem"
        String restOfLine = command.getRestOfLine();

        //Splits up each word "item" "into" "ComplexItem"
        String[] restOfLineArray = restOfLine.split(" ");

        Room currentRoom = player.getCurrentRoom();

        //Makes sure the array is proper length
        if ( restOfLineArray.length == 3 ) {

            //Checks to see if proper format where "into" should be the 2nd word
            if ( restOfLineArray[1].equals("into") ) {

                //Grabs the item that's to be packed into the complex item
                String itemString = restOfLineArray[0];
                Item itemToPackInto = currentRoom.getItem( itemString );

                //Grabs the complex item
                String complexItemString = restOfLineArray[2];
                Item complexItem = currentRoom.getItem( complexItemString );

                //If the item is an complexItem then add 
                //the item into the Complex
                if (complexItem instanceof ComplexItem ) {
                    ((ComplexItem)complexItem).addItem( itemToPackInto );

                    System.out.println(itemString + 
                        " has been successfully packed into " 
                        + complexItemString);
                } 
                else {
                    System.out.println("You cannot pack anything into that!");
                }

            } 
            else {
                System.out.println("Use format 'Pack ___ into ___ '");
            }

        } 
        else {
            System.out.println("Use format 'Pack ___ into ___ '");
        }

    }

    /**
     * Takes an item and places it into the player's inventory
     * 
     * @param command - the command the user inputs
     */
    private void take(Command command) {
        if (!command.hasSecondWord()) {
            // if there is no second word, we don't know what to examine.
            System.out.println("Take what?");
            return;
        }

        String item = command.getRestOfLine();

        Room currentRoom = player.getCurrentRoom();

        Item itemToTake = currentRoom.getItem(item);

        if (itemToTake == null) {
            System.out.println("That item doesn't exist here!");
        } 
        else {

            if (itemToTake.getWeight() > player.getMaxWeight() ) {
                System.out.println("Item is too heavy to carry!");
            } 
            else {

                if ( player.getInventorySize() > 
                    player.getMaxInventorySize() ) {
                    System.out.println("Your inventory is full!");

                } 
                else {

                    player.addItem(itemToTake);
                    System.out.println( itemToTake.getName() + 
                        " has been added to your inventory. ");
                        
                }

            }

        }

    }

    /**
     * Takes an item from the player's inventory and drops
     * it into the current room
     * 
     * @param command - the command the user inputs
     */
    private void drop(Command command) {
        if (!command.hasSecondWord()) {
            // if there is no second word, we don't know what to drop.
            System.out.println("Drop what?");
            return;
        }

        String item = command.getRestOfLine();

        Room currentRoom = player.getCurrentRoom();

        Item itemToDrop = player.getItem(item);

        if (itemToDrop == null) {
            System.out.println("That item doesn't exist here!");
        } 
        else {

            currentRoom.addItem(  player.removeItem(itemToDrop) );
            look();
        }

    }

    /**
     * Prints out the player's inventory
     */
    private void inventory() {
        System.out.println( player.getItemString() );
    }

    /**
     * Unlocks a locked door
     * 
     * @param command - the command the user inputs
     */
    private void unlockDoor(Command command ) {
        if (!command.hasSecondWord()) {
            // if there is no second word, we don't know what to examine.
            System.out.println("Use format: Unlock _____ (direction)");
            return;
        }

        // Grabs direction from player
        String exit = command.getRestOfLine();

        //Grabs the current room
        Room currentRoom = player.getCurrentRoom();

        //Grabs the door from the room depending on what direction
        Door doorToUnlock = currentRoom.getExit(exit);

        //If this door is null or not
        if (doorToUnlock == null) {
            System.out.println("Door doesn't exist.");
        } 
        else {
            //Does exist, now sees if its locked or not.
            if ( !doorToUnlock.isLocked() ) {
                System.out.println("Door is unlocked already.");
            } 
            else {
                //Sees if player has the key or not

                Item key = player.getItem( (doorToUnlock.getKey()).getName() );

                if ( key == null ) {
                    System.out.println("You do not have the key!");

                } 
                else {
                    doorToUnlock.unlock();
                    System.out.println("Successfully unlocked.");

                }

            }
        }

    }

    /**
     * Begins conversation between player and NPC
     * 
     * @param command - the command of the user
     */
    private void say(Command command) {
        if (!command.hasSecondWord()) {
            // if there is no second word, this command isn't usable
            System.out.println("Use format 'Say hi to ___ '");
            return;
        }

        // Grabs rest of line "hi to NPC"
        String restOfLine = command.getRestOfLine();

        //Splits up each word "hi" "to" "NPC"
        String[] restOfLineArray = restOfLine.split(" ");

        Room currentRoom = player.getCurrentRoom();

        //Makes sure the array is proper length
        if ( restOfLineArray.length >= 3 ) {

            //Checks to see if proper format where "hi" should be the 1st word
            if ( restOfLineArray[0].equals("hi") ) {

                //Checks to see if proper format 
                //where "to" should be the 2nd word
                if ( restOfLineArray[1].equals("to") ) {

                    //Proper format is correct 

                    //Grabs the key that's to be used for the character
                    String keyString = restOfLineArray[0];

                    //Grabs the Character to talk to
                    String characterName = "";

                    for (int index = 0; index < restOfLineArray.length; 
                        index++) {
                        if (index > 1) {

                            characterName = characterName.concat( 
                                restOfLineArray[index] + " ");

                        }
                    }

                    characterName = characterName.trim();
                    Character characterTalking = currentRoom.getCharacter( 
                                                characterName );

                    //Checks to see if that character is in the room
                    if (characterTalking == null) {
                        System.out.println("That character isn't here!");
                    } 
                    else {
                        teleportPlayer( 
                            (characterTalking.getDialogue()
                            ).startConversation(keyString), characterTalking);
                            
                        if ((
                                characterTalking.getName()).equals(
                                    "gray spirit") ||
                            (characterTalking.getName()).equals(
                                "blue spirit") ||
                            (characterTalking.getName()).equals(
                                "red spirit") ||
                            (characterTalking.getName()).equals(
                                "green spirit") ||
                            (characterTalking.getName()).equals(
                                "gold spirit") 
                             )  
                        {
                            gameScore += 100;
                        }
                    }

                } 
                else   {
                    System.out.println("Use format 'Say hi to ___'");
                }
            } 
            else  {
                System.out.println("Use format 'Say hi to ___ '");
            }

        } 
        else  {
            System.out.println("Use format 'Say hi to ___ '");
        }

    } 


    /**
     * A method that uses the end key of the Spirit King
     * conversation to judge whether or not
     * to teleport the player to the 
     * Clearing (Savanna), Buoy (Sea), Apartment (City)
     * 
     * If teleport occurs then it resets the player's health and
     * starts time over (turn count starts over).
     * 
     * @param key - the key from the conversation
     * @param theCharacter - the character to talk to
     */
    public void teleportPlayer(String key, Character theCharacter) {
        Room currentRoom = player.getCurrentRoom();
        if (key.equals("hiaa")) {

            if (theCharacter == world.getCharacter("Savanna Spirit King") ) {
                System.out.println("A red mist fills your vision" +
                    " and everything becomes blurry... \n");
                currentRoom.removeCharacter(theCharacter);
                player.setCurrentRoom( world.getRoom("Clearing"));

                look();
                playerCharacterType();
                
            }

            if (theCharacter == world.getCharacter("Sea Spirit King") ) {
                System.out.println("A blue mist fills your vision" +
                    " and everything becomes blurry... \n");
                currentRoom.removeCharacter(theCharacter);
                player.setCurrentRoom( world.getRoom("Buoy"));
                

                look();
                playerCharacterType();
                
            }

            if (theCharacter == world.getCharacter("City Spirit King") ) {
                System.out.println("A green mist fills your vision" +
                    " and everything becomes blurry... \n");
                currentRoom.removeCharacter(theCharacter);
                player.setCurrentRoom( world.getRoom("Apartment"));

                look();
                playerCharacterType();
                
            }
        }
        
        time = 0;
        player.setHealth(100);
    }

    /**
     * Method that gives an item from the
     * Player's inventory to a NPC's inventory
     * 
     * @param command - the command of the user
     */
    public void give(Command command) {
        if (!command.hasSecondWord()) {
            // if there is no second word, this command isn't usable
            System.out.println("Use format 'Give ___ to ___ '");
            return;
        }

        // Grabs rest of line "item to NPC"
        String restOfLine = command.getRestOfLine();

        //Splits up each word "item" "to" "NPC"
        String[] restOfLineArray = restOfLine.split(" ");

        Room currentRoom = player.getCurrentRoom();

        //Makes sure the array is proper length
        if ( restOfLineArray.length >= 3 ) {

            //Checks to see if proper format where "to" should be the 2nd word
            if ( restOfLineArray[1].equals("to") ) {

                //Grabs the item that's to be given to the NPC
                String itemString = restOfLineArray[0];
                Item itemToGive = player.getItem( itemString );

                if (itemToGive == null) {
                    System.out.println("That item is not in your inventory.");
                } 
                else {

                    //Grabs the NPC that should be given the item

                    String characterName = "";
                    for (int index = 0; index < 
                        restOfLineArray.length; index++) {
                        if (index > 1) {

                            characterName = characterName.concat( 
                                restOfLineArray[index] + " ");

                        }
                    }

                    characterName = characterName.trim();
                    Character characterReceiver = currentRoom.getCharacter( 
                        characterName );

                    if (characterReceiver == null) {
                        System.out.println("That character " +
                            "doesn't exist here.");
                    } 
                    else {

                        if (itemToGive.equals( 
                            characterReceiver.getSpecialItem() )  ) {
                            characterReceiver.addItem(itemToGive);
                            player.removeItem(itemToGive);
                            observe(characterReceiver);
                        } 
                        else {
                            System.out.println(characterReceiver.getName() 
                                + ": I don't want that!");
                        }
                    }

                }
            } 
            else {
                System.out.println("Use format 'Give ___ to ___ '");
            }
        } 
        else {
            System.out.println("Use format 'Give ___ to ___ '");
        }
    }

    /**
     * Looks at NPC's inventory
     * 
     * @param characterToObserve - the NPC to observe
     */
    public void observe(Character characterToObserve) {
        System.out.println( characterToObserve.getItemString() );
    }

    /**
     * Changes player type to a different player type
     * 
     * @param command - the command the user inputs
     */
    private void morph(Command command) {
        if (!command.hasSecondWord()) {
            // if there is no second word, we don't know what to examine.
            System.out.println("Use format: morph ____");
            return;
        }

        //takes input and turns it into the new form
        String newForm = command.getRestOfLine();

        Room currentRoom = player.getCurrentRoom();
        
        if ((currentRoom.getArea()).equals("Savanna")) {

            if ( (newForm.equals("lemur")) ) {
                //changes player's form to desired input
                //notifies player of new form
                playerMorph(newForm);
                currentForm();
            } 
            else if (newForm.equals("lioness") ) {
                //changes player's form to desired input
                //notifies player of new form
                playerMorph(newForm);
                currentForm();
            } 
            else {
                System.out.println("You can only morph between the" +
                    " Lioness and the Lemur \nin the Savanna.");
            }

        }

        if ((currentRoom.getArea()).equals("Sea")) {
            if ( (newForm.equals("pelican")) ) {
                //changes player's form to desired input
                //notifies player of new form
                playerMorph(newForm);
                currentForm();
            } 
            else if (newForm.equals("shark")) {
                //changes player's form to desired input
                //notifies player of new form
                playerMorph(newForm);
                currentForm();
            } 
            else {
                System.out.println("You can only morph between the" +
                    " Shark and the Pelican \nin the Sea.");
            }
        }

        if ((currentRoom.getArea()).equals("City")) {
            if ( (newForm.equals("human")) ) {
                //changes player's form to desired input
                //notifies player of new form
                playerMorph(newForm);
                currentForm();
            }
            else if (newForm.equals("dog"))  {
                //changes player's form to desired input
                //notifies player of new form
                playerMorph(newForm);
                currentForm();
            } 
            else {
                System.out.println("You can only morph between the" +
                    " Human and the Dog \nin the City.");
            }
        }
        
        if ((currentRoom.getArea()).equals("Spirit World")) {
            System.out.println("You cannot morph in the Spirit world!");
        }
    } 

    /**
     * Prompts the user what character they wish to be
     */
    public void playerCharacterType() {
        boolean satisfied = false;
        System.out.println("What creature would you like to be?");

        String playerType = "";

        do {
            switch ( (player.getCurrentRoom()).getName() ) {
                case "Clearing":
                    System.out.println("Enter: Lioness or Lemur");
                    playerType = parser.getUserResponse();
                    if ( playerType.equals("lioness") 
                        || playerType.equals("lemur") )  {
                        playerMorph(playerType);
                        currentForm();
                        satisfied = true;
                    } 
                    else {
                        System.out.println("You must pick a form!");
                        satisfied = false;
                    }
                    break;

                case "Buoy":
                    System.out.println("Enter: Shark or Pelican");
                    playerType = parser.getUserResponse();
                    if ( playerType.equals("shark") 
                        || playerType.equals("pelican") )  {
                        playerMorph(playerType);
                        currentForm();
                        satisfied = true;
                    } 
                    else {
                        System.out.println("You must pick a form!");
                        satisfied = false;
                    }
                    break;

                case "Apartment":
                    System.out.println("Enter: Human or Dog");
                    playerType = parser.getUserResponse();
                    if ( playerType.equals("human") 
                        || playerType.equals("dog") )  {
                        playerMorph(playerType);
                        currentForm();
                        satisfied = true;
                    }
                    else {
                        System.out.println("You must pick a form!");
                        satisfied = false;
                    }
                    break;

                default:
                    break;
            }
        } while (satisfied == false);
    }

    /**
     * Changes general type of player to a specific type of player
     * 
     * @param playerType - the type of player to morph to
     */
    public void playerMorph(String playerType) {
        HashMap<String, Item> inventory = player.getInventory();
        HashMap<String, Item> inventoryClone = new HashMap<String, Item>();
        
        inventoryClone = (HashMap<String, Item>)inventory.clone();
        
        Room currentRoom = player.getCurrentRoom();
        
        
        
        switch (playerType) {
            case "lioness":
                Player lioness = world.getPlayer("lioness");
                player = lioness;
                break;

            case "lemur":
                Player lemur = world.getPlayer("lemur");
                player = lemur;
                break;

            case "shark":
                Player shark = world.getPlayer("shark");
                player = shark;
                break;

            case "pelican":
                Player pelican = world.getPlayer("pelican");
                player = pelican;
                break;

            case "human":
                Player human = world.getPlayer("human");
                player = human;
                break;

            case "dog":
                Player dog = world.getPlayer("dog");
                player = dog;
                break;

            default:
                Player spirit = world.getPlayer("spirit");
                player = spirit;
                break;
        }
        
        player.setInventory(inventoryClone);
        player.setCurrentRoom(currentRoom);
    }

    /**
     * Sees if final mission goals are complete
     */
    public void missionAccomplished() {
        //Sees if player is alive
        if ( (player.getHealth()) == 0 ) {
            gameWon = -1;
        }

        // Sees for Savanna mission if goals have been met
        // which in this instance, one lion cub must have
        // the food it wants
        if ( (world.getCharacter("Lion Cub")).hasCorrectItem() ) {
            missionWon = 1;
            // means the mission has been accomplished

            System.out.println("Thank you so much! \n");
            Character lionCub = (world.getCharacter("Lion Cub"));
            lionCub.removeItem( lionCub.getSpecialItem() );
            //removes the special item so the game doesnt increment missionWon

        }

        if ( (world.getCharacter("Lion Cub (Smallest)")).hasCorrectItem() ) {
            missionWon = 1;
            // means the mission has been accomplished

            System.out.println("Thank you so much! \n");
            Character lionCub = (world.getCharacter("Lion Cub (Smallest)"));
            lionCub.removeItem( lionCub.getSpecialItem() );
            //removes the special item so the game doesnt increment missionWon
        }

        if ( (world.getCharacter("Lion Cub (Biggest)")).hasCorrectItem() ) {
            missionWon = 1;
            // means the mission has been accomplished

            System.out.println("Thank you so much! \n");
            Character lionCub = (world.getCharacter("Lion Cub (Biggest)"));
            lionCub.removeItem( lionCub.getSpecialItem() );
            //removes the special item so the game doesnt increment missionWon
        }

        if ( (world.getCharacter("Girl")).hasCorrectItem() ) {
            missionWon = 1;
            // means the mission has been accomplished

            System.out.println("Thank you so much! \n");
            Character girl = (world.getCharacter("Girl"));
            girl.removeItem( girl.getSpecialItem() );
            //removes the special item so the game doesnt increment missionWon
        }

        if ( (world.getCharacter("Tuna")).hasCorrectItem() ) {
            missionWon = 1;
            // means the mission has been accomplished

            System.out.println("Thank you so much! \n");
            Character tuna = (world.getCharacter("Tuna"));
            tuna.removeItem( tuna.getSpecialItem() );
            //removes the special item so the game doesnt increment missionWon
        }
        
        //

        if (gameWon == -1) { 
            System.out.println("==========--------------GAME--" 
                + "--------------==========");
            System.out.println("A puff of smoke appears " +
                "and you're transported...");
            System.out.println("You have jeopardized your" +
                " mission toward life on earth..");
            System.out.println("You are doomed to wander the" + 
                " Spirit World forever!");
            System.out.println("==========-------------------" +
                "----------------==========");
            status();
            System.out.println("==========--------------OVER---" + 
                "--------------==========");
            finished = true;
        }

        //

        if (missionWon == 1 ) {
            System.out.println("==========-------------" +
                "-----------------==========");
            System.out.println("A puff of smoke appears and" +
                " you're transported...");
            System.out.println("You have successfully completed" +
                " the mission..");
            System.out.println("But you still have more to do...");
            System.out.println("==========----------------------" +
                "-------------==========");
            
            System.out.println("==========---------------------" +
                "----------==========");
                     
            if (time >= 35) {
                missionScore = 100;
            }
            else if (time >= 30) {
                missionScore = 200;
            }
            else if (time >= 25) {
                missionScore = 300;
            }
            else if (time >= 20) {
                missionScore = 400;
            }
            else {
                missionScore = 500;
            }
                
            status();    
            missionWon = 0;
            gameWon += 1;
            Player spirit = world.getPlayer("spirit");
            player = spirit;
            gameScore += missionScore;
            missionScore = 0;
            player.setHealth(100);
            player.setCurrentRoom( world.getRoom("Plain") );
            look();
        }

        // 

        if (gameWon == 3) {
            System.out.println("==========---------CONGRATULATIONS" +
                "----------==========");
            System.out.println("A puff of smoke appears and you're" +
                " transported...");
            System.out.println("You have successfully completed " +
                "each mission!");
            System.out.println("You are granted life on earth as a " +
                success() + ".");
            System.out.println("==========------------------------" +
                "-----------==========");
            status();
            System.out.println("Your overall score is " +
                gameScore + "!");
            System.out.println("==========---------CONGRATULATIONS---" +
                "-------==========");
            finished = true;
        }
    }
    
   
    /**
     *  This method determines what creature the player would be on earth. 
     *  
     *  @return successCreature - the creature String the player will end up as
     */
    public String success() {
        String successCreature = "";
        if (gameScore >= 2300) {
            successCreature = "SPIRIT KING";
        }
        else if (gameScore >= 1199) {
            successCreature = "human";
        } 
        else if (gameScore >= 8000) {
            successCreature = "dog";
        } 
        else if (gameScore >= 5000) {
            successCreature = "lioness";
        } 
        else if (gameScore >= 3000) {
            successCreature = "lemur";
        } 
        else if (gameScore >= 1000) {
            successCreature = "shark";
        } 
        else  {
            successCreature = "pelican";

           
        }
        return successCreature;
    }
    

    ///////////////////// SPECIAL CREATURE COMMANDS
    /**
     * This method removes desired NPC's away. 
     * 
     * @param command - the command entered by the user
     */
    public void scare(Command command) {
        if (!command.hasSecondWord()) {
            // if there is no second word, this command isn't usable
            System.out.println("Use format 'Roar/Squawk/Bark at ____'");
            return;
        }

        // Grabs rest of line "at NPC"
        String restOfLine = command.getRestOfLine();

        //Splits up each word "at" "NPC"
        String[] restOfLineArray = restOfLine.split(" ");

        Room currentRoom = player.getCurrentRoom();

        //Makes sure the array is proper length
        if ( restOfLineArray.length >= 2 ) {

            //Checks to see if proper format where "at" should be the 1st word
            if ( restOfLineArray[0].equals("at") ) {

                //Grabs the NPC that should be given the item

                String characterName = "";
                for (int index = 0; index < restOfLineArray.length;
                    index++) {
                    if (index >= 1) {

                        characterName = characterName.concat( 
                            restOfLineArray[index] + " ");

                    }
                }

                characterName = characterName.trim();
                Character characterRoaredAt = currentRoom.getCharacter( 
                    characterName );

                if (characterRoaredAt == null) {
                    System.out.println("That character doesn't exist here.");
                } 
                else {

                    if (characterRoaredAt.getScared() == false) {
                        System.out.println("That character isn't" +
                            " afraid of you.");
                    } 
                    else {
                        currentRoom.removeCharacter(characterRoaredAt);
                        System.out.println("You have scared " +
                            characterRoaredAt.getName() + " away!");
                        look();
                    }
                }

            } 
            else {
                System.out.println("Use format 'Roar/Squawk/Bark at ____'");
            }
        } 
        else {
            System.out.println("Use format 'Roar/Squawk/Bark at ____'");
        }
    }

    /**
     * Try to climb to one direction
     * 
     * @param command The command entered by player.
     */
    private void climb(Command command) {
        if (!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Climb where?");
            return;
        }

        String direction = command.getRestOfLine();

        // Try to leave current .
        Door doorway = null;

        Room currentRoom = player.getCurrentRoom();

        if (direction.equals("up") || direction.equals("down") ) {
            doorway = currentRoom.getExit(direction);
            if (doorway == null) {
                System.out.println("There is no door!");
            } 
            else {
                player.setCurrentRoom(doorway.getDestination());
                printLocationInformation();

            }

        } 
        else {
            System.out.println("You can only climb UP/DOWN things");
        }

    }

    /**
     * Try to fly to one direction - "up"
     * 
     * @param command The command entered by player.
     */
    private void fly(Command command) {
        if (!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Fly where?");
            return;
        }

        String direction = command.getRestOfLine();

        // Try to leave current .
        Door doorway = null;

        Room currentRoom = player.getCurrentRoom();

        if (direction.equals("up") ) {
            doorway = currentRoom.getExit(direction);
            if (doorway == null) {
                System.out.println("There is no door!");
            } 
            else {
                player.setCurrentRoom(doorway.getDestination());
                printLocationInformation();

            }

        } 
        else {
            System.out.println("You can only fly UP!");
        }

    }

    /**
     * Try to swim to one direction - "down"
     * 
     * @param command The command entered by player.
     */
    private void swim(Command command) {
        if (!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Swim where?");
            return;
        }

        String direction = command.getRestOfLine();

        // Try to leave current .
        Door doorway = null;

        Room currentRoom = player.getCurrentRoom();

        if (direction.equals("down") ) {
            doorway = currentRoom.getExit(direction);
            if (doorway == null) {
                System.out.println("There is no door!");
            } 
            else {
                player.setCurrentRoom(doorway.getDestination());
                printLocationInformation();

            }

        } 
        else {
            System.out.println("You can only swim DOWN!");
        }

    }

    /**
     * The method to battle a Monster NPC
     * 
     * @param command - the command entered by the user
     */
    public void bite(Command command) {
        if (!command.hasSecondWord()) {
            // if there is no second word, this command isn't usable
            System.out.println("Use format 'Bite ____'");
            return;
        }

        // Grabs rest of line 
        String victimName = command.getRestOfLine();

        Room currentRoom = player.getCurrentRoom();

        // Grabs NPC to attack
        Character victim = currentRoom.getCharacter(victimName);

        if (victim == null) {
            System.out.println("That character doesn't exist here!");
        } 
        else {
            if (victim instanceof EndGameCharacter) {
                victim.attackString();
                gameWon = -1;
            } 
            else if (victim instanceof LosePointsCharacter) {
                victim.attackString();
                currentRoom.removeCharacter(victim);
                gameScore -= 100;
            } 
            else if (victim instanceof Monster ) {    

                int dead = victim.attackString();
                
                depleteHealth();

                if (dead == 1) {

                    if ( (victim.getName()).equals("zebra herd") ) {
                        Item carcass = (
                            world.getRoom("Debug")).getItem("carcass");
                        currentRoom.addItem(carcass);

                    }

                    if ( (victim.getName()).equals("criminal") ) {
                        Item purse = (
                            world.getRoom("Debug")).getItem("purse");
                        currentRoom.addItem(purse);

                    }

                    if ( (victim.getName()).equals("blue-billed bird") ) {
                        Item berries = (
                            world.getRoom("Debug")).getItem("berries");
                        currentRoom.addItem(berries);

                    }
                    
                    currentRoom.removeCharacter(victim);
                    look();
                    // ADD POINTS
                }

            } 
            else {
                victim.attackString();
            }

        }  
    }

    /**
     * Pelican action to interact with button or lever
     * 
     * @param command - the command input from the player
     */
    private void peck(Command command) {
        if (!command.hasSecondWord()) {
            // if there is no second word, we don't know what to peck.
            System.out.println("Peck what?");
            return;
        }

        String item = command.getRestOfLine();

        Room currentRoom = player.getCurrentRoom();

        Item itemToPeck = currentRoom.getItem(item);

        if (itemToPeck == null) {
            System.out.println("That item doesn't exist here!");
        } 
        else {
            if ( (itemToPeck.getName()).equals("button") 
                || (itemToPeck.getName()).equals("lever") ) {
                System.out.println("You hear a huge mechanical" +
                    " screech come from the rear of the boat.");
                System.out.println("The fishermen are " +
                    "yelling and abandoning ship.");
                missionWon = 1;
            } 
            else {
                System.out.println("It had no effect.");
            }
        }
    }

    /**
     * Takes away from player's health
     */
    public void depleteHealth() {
        Random generator = new Random();
        int randomNumber = generator.nextInt(20) + 1;

        player.setHealth( player.getHealth() - randomNumber);
        System.out.println("Current health: " + player.getHealth() );
    }

    /**
     * Examine a NPC's inventory
     *
     * @param command The command entered by the player
     */
    public void observe(Command command) {
        if (!command.hasSecondWord()) {
            // if there is no second word, this command isn't usable
            System.out.println("Use format 'Observe ____'");
            return;
        }

        // Grabs rest of line 
        String characterName = command.getRestOfLine();

        Room currentRoom = player.getCurrentRoom();

        // Grabs NPC to observe
        Character character = currentRoom.getCharacter(characterName);

        if (character == null) {
            System.out.println("That character doesn't exist here.");
        } 
        else {
            System.out.println(character.getItemString() );

        }
    }

    /**
     * Takes an item from the NPC's inventory and 
     * gives it to the player

     * @param command - the command the user inputs
     */
    private void steal(Command command) {
        if (!command.hasSecondWord()) {
            // if there is no second word, we don't know what to steal.
            System.out.println("Use format: Steal ___ from ___");
            return;
        }

        // Grabs rest of line "item from npc"
        String restOfLine = command.getRestOfLine();

        //Splits up each word "item" "from" "npc"
        String[] restOfLineArray = restOfLine.split(" ");

        Room currentRoom = player.getCurrentRoom();

        //Makes sure the array is proper length
        if ( restOfLineArray.length >= 3 ) {

            //Checks to see if proper format where "into" should be the 2nd word
            if ( restOfLineArray[1].equals("from") ) {

                //Grabs the Character 
                String characterName = "";

                for (int index = 0; index < restOfLineArray.length;
                    index++) {
                    if (index > 1) {

                        characterName = characterName.concat( 
                            restOfLineArray[index] + " ");

                    }
                }

                characterName = characterName.trim();
                Character victim = currentRoom.getCharacter( characterName ); 

                if (victim == null) {
                    System.out.println("That character doesn't exist here!");
                } 
                else {

                    //Grabs the item that's to be stolen
                    String itemString = restOfLineArray[0];
                    Item itemToSteal = victim.getItem( itemString );

                    if (itemToSteal == null) {
                        System.out.println("They don't have that item!");
                    } 
                    else {
                        player.addItem(itemToSteal);
                        victim.removeItem(itemToSteal);
                        inventory();
                    }

                }
            } 
            else {
                System.out.println("Use format: Steal ___ from ___");
            }

        } 
        else {
            System.out.println("Use format: Steal ___ from ___");
        }       
    }

     /**
     * The method to battle a Monster NPC
     * 
     * @param command - the command entered by the user
     */
    public void attack(Command command) {
        if (!command.hasSecondWord()) {
            // if there is no second word, this command isn't usable
            System.out.println("Use format 'Attack ____ with _____'");
            return;
        }

        // Grabs rest of line "NPC with item"
        String restOfLine = command.getRestOfLine();

        //Splits up into "NPC" "item"
        String[] restOfLineArray = restOfLine.split("with");

        if (restOfLineArray.length >= 2) {

            // Grabs victim 
            String victimName = restOfLineArray[0].trim();

            // Grabs weapon
            String weaponName = restOfLineArray[1].trim();

            Room currentRoom = player.getCurrentRoom();

            // Grabs NPC to attack
            Character victim = currentRoom.getCharacter(victimName);

            // Grabs weapon from inventory
            Item weapon = player.getItem(weaponName);

            if (victim == null) {
                System.out.println("That character doesn't exist here!");
            } 
            else {

                if (weapon == null) {
                    System.out.println("You don't have that weapon!");
                } 
                else {

                    if ( (weapon.getName()).equals("pipes") 
                        || (weapon.getName()).equals("screwdriver") 
                            || (weapon.getName()).equals("hammer")) {

                        if (victim instanceof EndGameCharacter) {
                            victim.attackString();
                            gameWon = -1;
                        } 
                        else if (victim instanceof LosePointsCharacter) {
                            victim.attackString();
                            currentRoom.removeCharacter(victim);
                            gameScore -= 100;
                        } 
                        else if (victim instanceof Monster) {    

                            int dead = victim.attackString();
                            System.out.println( victim.getName() +
                                " attacked you back!");
                            depleteHealth();

                            if (dead == 1) {

                                if ( (victim.getName()).equals("zebra herd") ) {
                                    Item carcass = (
                                        world.getRoom("Debug")
                                            ).getItem("carcass");
                                    currentRoom.addItem(carcass);

                                }

                                if ( (victim.getName()).equals("criminal") ) {
                                    Item purse = (
                                        world.getRoom("Debug")
                                            ).getItem("purse");
                                    currentRoom.addItem(purse);

                                }

                                if ( 
                                    (
                                        victim.getName()
                                            ).equals("blue-billed bird") ) {
                                    Item berries = (
                                        world.getRoom("Debug")
                                        ).getItem("berries");
                                    currentRoom.addItem(berries);

                                }

                                currentRoom.removeCharacter(victim);
                                look();
                                // ADD POINTS
                            }

                        } 
                        else {
                            victim.attackString();
                        }

                    } 
                    else {
                        System.out.println("That cannot be used as a weapon!");
                    }

                }

            }
        } 
        else {
            System.out.println("Use format 'Attack ____ with _____'");
        }
    } 
}
