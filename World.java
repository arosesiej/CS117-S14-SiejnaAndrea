import java.util.HashMap;

/**
 * This class represents the entire world that makes 
 * up the "Eternal Destiny" application.
 * "Eternal Destiny" is a text based adventure game. 
 * 
 * This world class creates the world where the game takes place.
 * 
 * @author Maria Jump, Andrea Siejna
 * @version 2013.01.22
 */
public class World {
    /** The rooms in the world */
    private HashMap<String, Room> rooms;

    /** The characters in the world */
    private HashMap<String, Character> characters;

    private HashMap<String, Player> players;

    /**
     * Constructor for the world.
     */
    public World() {
        rooms = new HashMap<String, Room>();
        characters = new HashMap<String, Character>();
        players = new HashMap<String, Player>();
        createRooms();
        createItems();
        createCharacters();
        createPlayers();
    }

    /**
     * Get a room with a given name.
     * @param roomName The name of the room that should be returned.
     * @return The room with the given name.
     */
    public Room getRoom(String roomName) {
        return rooms.get(roomName);
    }

    /**
     * Get a character with a given name.
     * @param characterName The name of the character that should be returned.
     * @return The character with the given name.
     */
    public Character getCharacter(String characterName) {
        return characters.get(characterName);
    }

    /////////// Start of private helper methods

    /**
     * This method creates all of the individual places in this world
     * and all the doors connecting them.
     */
    private void createRooms() {
        // Room name = this.addRoom("name", "description");

        // Debug room 
        Room debug = this.addRoom("Debug", "Unseen by player", "Debug");
        
        // The Spirit World's rooms
        Room cliff = this.addRoom("Cliff", "There is a path that" +
            " drops off into dark nothingness. \nA spirit wanders" +
             " nervously back and forth from the edge" +
             " of the cliff.", "Spirit World");
        Room plain = this.addRoom("Plain", "There’s a large plain of" +
            " dirt and rubble. Nothing but rocks around. \nUp ahead you see" +
            " glowing figures in the distance." +
            " \nBehind you, you see a drop-off" +
            " with another glowing figure floating nearby.", "Spirit World");
        Room valley = this.addRoom("Valley", "Mountains surround you" +
            " and a dreary atmosphere looms over you." +
            " \nYou see a cavern approaching and the" +
            " figures are getting closer. \nFog fills" +
            " the valley. ", "Spirit World");
        Room cavern = this.addRoom("Cavern", "You reach a cavern with" +
            " fog pouring out of it. Inside, there \nare three glowing" +
            " figures that are huddled together. They look \nlike balls" +
            " of smoke floating and each has a different color \nradiating" +
            " from it. One is blue, another red, and the third, green. \nTo" +
            " your left is a dark cobblestone path that seems to lead \ninto" +
            " the shadows. To your right, a narrow path" +
            " can be spotted.", "Spirit World");
        Room abyssOne = this.addRoom("Abyss (Savanna)", "You follow" +
            " down the dark trail and are eventually \nengulfed in a" +
            " thick, black fog. You wander aimlessly" +
            " \nuntil a red light fills" +
            " your vision. A giant creature that resembles \nZeus from Greek" +
            " mythology stands in front of you. His eyes are \nshining and" +
            " he’s three times your size. \nThunder and lightning shutter" +
            " in the background.", "Spirit World");
        Room narrowPath = this.addRoom("Narrow Path", "There’s a thin" +
            " path leading into more caves. Another figure that \nglows" +
            " gold floats nervously back and forth. Behind you, the three" +
            " \nfigures are huddled in a group. To your right, a dark" +
            " \ncobblestone path that seems to" +
            " lead into the shadows." +
            " \nTowards south, another shady-looking" +
            " path approaches. ", "Spirit World");
        Room abyssTwo = this.addRoom("Abyss (Sea)", "You follow down" +
            " the dark trail and are eventually \nengulfed in a" +
            " thick, black fog. You wander aimlessly" +
            " \nuntil a blue light fills your vision." +
            " A giant figure that resembles \nZeus from" +
            " Greek mythology stands in front of you." +
            " His eyes are \nshining and he’s three" +
            " times your size. Thunder\n and lightning" +
            " shutter in the background.", "Spirit World" );
        Room abyssThree = this.addRoom("Abyss (City)", "You" +
            " follow" +
            " down the dark trail and are eventually" +
            " \nengulfed" +
            " in a thick, black fog. You wander aimlessly" +
            " \nuntil a green light fills your vision. A" +
            " giant figure that resembles \nZeus from Greek" +
            " mythology stands in front of you. His eyes are" +
            " \nshining and he’s three times your size." +
            " \nThunder and lightning shutter in the" +
            " background.", "Spirit World");

        
        // The Savanna's rooms
        Room clearing = this.addRoom("Clearing", "You feel" +
            " the hot African climate on your fur. There’s \n" +
            "fields in the distance. There are three small lion" +
            " cubs \nwhining and crying, complaining that they’re" +
            " hungry. To your left, \nthere’s a field of short" +
            " grass. To your right, \nsome rocks and a tree.", "Savanna");
        Room field = this.addRoom("Field", "Grass surrounds" +
            " you. There’s an elephant lounging in the sun.", "Savanna");
        Room tallGrass = this.addRoom("Tall Grass", "Two zebra" +
            " are feeding on grass. \nThey look skittish and " +
            "nervously peek over their shoulders.", "Savanna");
        Room canyon = this.addRoom("Canyon", "You arrive at a " +
            "large canyon. There are \nhoove-marks that indicate" +
            " a herd commonly passes through. ", "Savanna");
        Room grassyPlains = this.addRoom("Grassy Plains", "A " +
            "trail of nuts is seen leading up to a tree in " +
            "the far distance.", "Savanna");
        Room warthogDen = this.addRoom("Warthog Den", "There " +
            "is a warthog sleeping under the shade of a tree." +
            " \nHe grunts and snores loudly.", "Savanna");
        Room bottomOfTree = this.addRoom("Bottom of Tree", "These" +
            " are the roots of an Acacia tree. At the " +
            "top you see \na large blue-billed bird " +
            "soaring around its branches.", "Savanna");
        Room topOfTree = this.addRoom("Top of Tree", "Branches " +
            "surround the nest of the blue-bill bird. \nYou see " +
            "its dinner sitting in the corner of the nest: juicy," +
            " pink berries.", "Savanna");

        // The Sea's rooms
        Room buoy = this.addRoom("Buoy", "You’re on a buoy out at " +
            "sea that has drifted far from the shore. \nIn the " +
            "distance, a ship can be spotted. In the sky, you see" +
            " \nbirds flying around. Below, the dark ocean looms " +
            "underneath you.", "Sea");
        Room sky = this.addRoom("Sky", "Up in the clouds there are " +
            "two seagulls \nsoaring. You see a ship " +
            "underneath you.", "Sea");
        Room frontOfBoat = this.addRoom("Front of Boat", "Two fishermen" +
            " hold spears and nets and greedily talk about the " +
            "\nwhales they’re about to poach.", "Sea");
        Room insideOfBoat = this.addRoom("Inside of Boat", "Various" +
            " levers and buttons are on all the walls and \nsurfaces" +
            " of the room. This looks more " +
            "like a spaceship than a boat.", "Sea");
        Room backOfBoat = this.addRoom("Back of Boat", "There is " +
            "one fisherman \npulling in a net from the ocean.", "Sea");
        Room seaweedForest = this.addRoom("Seaweed Forest", "Clumps " +
            "of seaweed drift pass. \nA group of whales " +
            "are approaching.", "Sea");
        Room underTheBuoy = this.addRoom("Under the Buoy", "You " +
            "splashed into the waters. It’s cold and in the " +
            "\ndistance you can see whales swimming. ", "Sea");
        Room coralReef = this.addRoom("Coral Reef", "Above " +
            "you is the front of the boat. \nThere is a " +
            "school of fish swimming around. ", "Sea");
        Room underTheBoat = this.addRoom("Under the Boat", "Above " +
            "you is the back of the boat. \nThere is a group of " +
            "tuna fish that are huddled together.\n You hear them " +
            "talk about the fishermen.", "Sea");
        Room seaside = this.addRoom("Seaside", "A stingray is seen " +
            "floating \nwith the current of the tide. ", "Sea");

        // The City's rooms
        Room apartment = this.addRoom("Apartment", "You’re in a " +
            "living room \nof an empty apartment. There is a TV " +
            "on displaying the \nlocal news. A terror of a criminal" +
            " can be heard from the anchorman. \nA container of " +
            "half-eaten Chinese food is on the coffee table. ", "City");
        Room porch = this.addRoom("Porch", "The porch of the " +
            "apartment is dilapidated and a \nfew pipes are " +
            "seen in the corner. The \nstreet ahead is bustling" +
            " with crowds of people and the\n city skyline " +
            "peeks from the distance.", "City");
        Room street = this.addRoom("Street", "The road expands " +
            "and you see large buildings \nand skyscrapers " +
            "around you. Groups of people all make \ntheir " +
            "way through the city. A guy walking his dog " +
            "looks at \nyou with a terrified expression.", "City");
        Room alleyway = this.addRoom("Alleyway", "A criminal" +
            " and a young girl are seen struggling \n in the" +
            " back corner against a dumpster. He raises\n his" +
            " fist and is threatening to hurt her.", "City");
        Room basement = this.addRoom("Basement", "The" +
            " dim glow " +
            "of a single light bulb illuminates\n" +
            " a small red toolbox. ", "City");
        Room cornerOfBuilding = this.addRoom("Corner of Building", "A " +
            "cop is standing looking for someone. ", "City");

        // Creates doors for each room.
        // this.createDoor(name, "direction", exitName);

        // Doors for The Spirit World's rooms

        this.createDoor(cliff, "north", plain);

        this.createDoor(plain, "north", valley);
        this.createDoor(plain, "south", cliff);

        this.createDoor(valley, "north", cavern);
        this.createDoor(valley, "south", plain);

        this.createDoor(cavern, "south", valley);
        this.createDoor(cavern, "east", narrowPath);
        this.createDoor(cavern, "west", abyssOne);

        this.createDoor(abyssOne, "east", cavern);

        this.createDoor(narrowPath, "south", abyssTwo);
        this.createDoor(narrowPath, "east", abyssThree);
        this.createDoor(narrowPath, "west", cavern);

        this.createDoor(abyssTwo, "north", narrowPath);

        this.createDoor(abyssThree, "west", narrowPath);
        

        
        
        // Doors for The Savanna's rooms

        this.createDoor(clearing, "east", grassyPlains);
        this.createDoor(clearing, "west", field);

        this.createDoor(field, "north", tallGrass);
        this.createDoor(field, "east", clearing);

        this.createDoor(tallGrass, "north", canyon);
        this.createDoor(tallGrass, "south", field);

        this.createDoor(canyon, "south", tallGrass);

        this.createDoor(grassyPlains, "north", warthogDen);
        this.createDoor(grassyPlains, "west", clearing);

        this.createDoor(warthogDen, "north", bottomOfTree);
        this.createDoor(warthogDen, "south", grassyPlains);

        this.createDoor(bottomOfTree, "up", topOfTree);
        this.createDoor(bottomOfTree, "south", warthogDen);

        this.createDoor(topOfTree, "down", bottomOfTree);

        // Doors for The Sea's rooms

        this.createDoor(buoy, "up", sky);
        this.createDoor(buoy, "down", underTheBuoy);

        this.createDoor(sky, "south", buoy);
        this.createDoor(sky, "east", frontOfBoat);

        this.createDoor(frontOfBoat, "down", coralReef);       
        this.createDoor(frontOfBoat, "east", insideOfBoat);
        this.createDoor(frontOfBoat, "west", sky);

        this.createDoor(insideOfBoat, "east", backOfBoat);
        this.createDoor(insideOfBoat, "west", frontOfBoat);

        this.createDoor(backOfBoat, "down", underTheBoat);
        this.createDoor(backOfBoat, "east", seaside);

        this.createDoor(backOfBoat, "west", insideOfBoat);

        this.createDoor(seaweedForest, "east", underTheBuoy);

        this.createDoor(underTheBuoy, "north", buoy);
        this.createDoor(underTheBuoy, "east", coralReef);
        this.createDoor(underTheBuoy, "west", seaweedForest);

        this.createDoor(coralReef, "up", frontOfBoat);
        this.createDoor(coralReef, "east", underTheBoat);
        this.createDoor(coralReef, "west", underTheBuoy);

        this.createDoor(underTheBoat, "up", backOfBoat);
        this.createDoor(underTheBoat, "west", coralReef);

        this.createDoor(seaside, "west", backOfBoat);

        //Doors for The City's rooms

        this.createDoor(apartment, "north", porch);
        this.createDoor(apartment, "east", basement);

        this.createDoor(porch, "north", cornerOfBuilding);
        this.createDoor(porch, "south", apartment);
        this.createDoor(porch, "east", street);

        this.createDoor(street, "south", alleyway);
        this.createDoor(street, "west", porch);

        this.createDoor(alleyway, "north", street);

        this.createDoor(basement, "west", apartment);

        this.createDoor(cornerOfBuilding, "south", porch);

        //Locks rooms
        (frontOfBoat.getExit("east")
            ).setLocked(true); //Inside of Boat locked from east
        (backOfBoat.getExit("west")
            ).setLocked(true); //Inside of Boat locked from west

 
    }

    /**
     * Helper method for recreating a Room.  Ensure that the room is created
     * and installed in to the collection of Rooms
     * @param name The name for the new room.
     * @param description The description for the new room.
     * @param area The area for the new room.
     * @return The Room that was created.
     */
    private Room addRoom(String name, String description, String area) {
        Room aRoom = new Room(name, description, area);
        rooms.put(name, aRoom);
        return aRoom;
    }

    /**
     * Helper method for creating doors between rooms
     * 
     * @param from The room where you are creating the door.
     * @param direction The direction of the exit for the door.
     * @param to The room in the direction provided
     */
    private void createDoor(Room from, String direction, Room to) {
        Door toDoor = null;

        if (to != null) {
            toDoor = new Door(to);
        }

        from.setExit(direction, toDoor);
    }

    /**
     * Creates all the items in each room and places them accordingly
     */
    private void createItems() {

        // Item itemname = new Item(name, description, weight);

        //getRoom("Roomname").addItem(Item); Regular item placement

        // Items in the Spirit World's rooms
        Item boulder = new Item("boulder", "A large granite boulder", 3);
        Item dirt = new Item("dirt", "Powdery cosmic dust", 1);
        Item rubble = new Item("rubble", "Pieces of shattered rock", 1);
        Item rocks = new Item("rocks", "A few hard rocks", 1);
        Item sign1 = new Item("sign - savanna", "Warm, sunny...", 3);
        Item sign2 = new Item("sign - sea", "Cold, wet...", 3);
        Item sign3 = new Item("sign - city", "Urban, bustling...", 3);

        //Adds items to rooms
        getRoom("Cliff").addItem(boulder);
        getRoom("Plain").addItem(dirt);
        getRoom("Plain").addItem(rubble);
        getRoom("Plain").addItem(rocks);
        getRoom("Cavern").addItem(sign1);
        getRoom("Narrow Path").addItem(sign2);
        getRoom("Narrow Path").addItem(sign3);

        // Items in the Savanna's rooms

        Item stones = new Item("stones", "A few large pebbles", 1);
        Item tree = new Item("tree", "A large tree", 3);
        Item nuts = new Item("nuts", "A couple of kola nuts", 1);


        //Adds items to rooms
        getRoom("Clearing").addItem(stones);
        getRoom("Clearing").addItem(tree);
        getRoom("Grassy Plains").addItem(nuts);
                

        // Items in the Sea's rooms

        Item buoyItem = new Item("buoy", "Slimy, seaweed covered buoy", 3);
        Item button = new Item("button", "Large red button", 3);
        Item lever = new Item("lever", 
            "A silver lever with the words 'DO NOT PULL' ", 3);
        Item net = new Item("net", 
            "Grey, slimy fishing net", 1);
        Item seaweed = new Item("seaweed", 
            "Slimy seaweed", 1);
        Item seashell = new Item("seashell", 
            "Beautiful, sparkling seashell", 1);

        //Adds items to rooms
        getRoom("Buoy").addItem(buoyItem);
        getRoom("Inside of Boat").addItem(button);
        getRoom("Inside of Boat").addItem(lever);
        getRoom("Back of Boat").addItem(net);
        getRoom("Seaweed Forest").addItem(seaweed);
        getRoom("Inside of Boat").addItem(seashell);

        // Items in the City's rooms
        Item tv = new Item("tv",  
            "TV is on the news channel: URGENT! A CRIMINAL ON THE LOOSE!", 3);
        Item coffeeTable = new Item("coffee table",  
            "Large wooden coffee table", 3);
        Item chinese = new Item("chinese",  
            "Half-eaten General Tso's chicken inside a paper container", 1);
        Item pipes = new Item("pipes",  
            "Rusty plumbing pipes", 1);
        ComplexItem toolbox = new ComplexItem("toolbox",  
            "Small red toolbox", 1);
        Item screwdriver = new Item("screwdriver",  
            "Tiny phillips-head screwdriver", 1);
        Item hammer = new Item("hammer",  
            "Large silver hammer with wooden handle", 1);

        //Adds items to rooms
        getRoom("Apartment").addItem(tv);
        getRoom("Apartment").addItem(coffeeTable);
        getRoom("Apartment").addItem(chinese);
        getRoom("Porch").addItem(pipes);

        getRoom("Basement").addItem(toolbox); 

        //Adds items to toolbox (complex item)
        toolbox.addItem(screwdriver);
        toolbox.addItem(hammer);

       
        Item key = new Item("key",  
            "Shiny, golden key", 1);
        getRoom("Coral Reef").addItem(key);

        Item carcass = new Item("carcass",  
            "A dead zebra carcass", 1);
        getRoom("Debug").addItem(carcass);

        Item purse = new Item("purse",  
            "A Louie Vuitton handbag", 1);
        getRoom("Debug").addItem(purse);
        
        Item berries = new Item("berries",  
            "Bright, pink berries with nourishing properties", 1);
        getRoom("Debug").addItem(berries);
    }

    /**
     * Creates all the NPC's in each room and places them accordingly
     */
    private void createCharacters() {



        Character graySpirit = new Character("Gray Spirit", 
             getRoom("Cliff"), "hi" , null );        
        Conversation graySpiritDialogue = new Conversation( "Gray Spirit", 
             "world");
        graySpiritDialogue.addReply("hi",  
            "You look new around here... You must find the Spirit King \n" +
            "and try to get out of this world! \n");
        graySpirit.setDialogue(graySpiritDialogue);
        (graySpirit.getRoom()).addCharacter(graySpirit);

        Character blueSpirit = new Character("Blue Spirit",  
            getRoom("Cavern"), "hi", null );
        Conversation blueSpiritDialogue = new Conversation( "Blue Spirit", 
             "there");
        blueSpiritDialogue.addReply("hi",  
            "You don't have an aura, are you new here? \n" +
            "I've just gone to a really wet place. If you \n" +
            "like the ocean, you'll want to go there! \n");
        blueSpirit.setDialogue(blueSpiritDialogue);
        (blueSpirit.getRoom()).addCharacter(blueSpirit);

        Character redSpirit = new Character("Red Spirit", getRoom("Cavern"), 
             "hi", null );
        Conversation redSpiritDialogue = new Conversation( "Red Spirit", 
             "king");
        redSpiritDialogue.addReply("hi",  
            "I've been to the safari in a past life. It was wild!\n" +
            "You should try to get there by talking to the Spirit King! \n");
        redSpirit.setDialogue(redSpiritDialogue);
        (redSpirit.getRoom()).addCharacter(redSpirit);

        Character greenSpirit = new Character("Green Spirit", 
             getRoom("Cavern"), "hi", null );
        Conversation greenSpiritDialogue = new Conversation( "Green Spirit",  
            "out");
        greenSpiritDialogue.addReply("hi", 
             "I like the human world! It's more interesting\n" +
            "than this place.. go check it out! \n");
        greenSpirit.setDialogue(greenSpiritDialogue);
        (greenSpirit.getRoom()).addCharacter(greenSpirit);

        Character spiritKingSavanna = new Character("Savanna Spirit King", 
             getRoom("Abyss (Savanna)"), "hi", null );
        Conversation spiritKingSavannaDialogue = new Conversation( 
             "Savanna Spirit King", "goodbye");
        spiritKingSavannaDialogue.addReply("hi", 
             "You've found me. Now do you want a shot\n" +
            "at life on earth?\n" +
            "A. Yes, I'll try!\n" +
            "B. No, I don't..\n");

        spiritKingSavannaDialogue.addReply("hia", 
            "Spirits like you wander this " +
            "world everyday and now it's finally\n " +
            "your chance to become more than just a soul. I'm sending you\n " +
            "to the Savanna where you'll learn to help those\n" +
            "who need you. \n" +
            "A. Okay, sounds great.\n" +
            "B. I don't want to go there. \n");

        spiritKingSavannaDialogue.addReply("hib", 
             "Then come back when you do.. Goodbye. \n");

        spiritKingSavannaDialogue.addReply("hiaa",  
            "You'll come back when you've finished. Good luck.\n"
            + "Goodbye. \n");

        spiritKingSavannaDialogue.addReply("hiab", 
             "Then come back when you do.. Goodbye. \n");
        spiritKingSavanna.setDialogue(spiritKingSavannaDialogue);
        (spiritKingSavanna.getRoom()).addCharacter(spiritKingSavanna);
        characters.put("Savanna Spirit King", spiritKingSavanna);

        //

        Character spiritKingSea = new Character("Sea Spirit King",  
            getRoom("Abyss (Sea)"), "hi", null );
        Conversation spiritKingSeaDialogue = new Conversation( 
            "Sea Spirit King",  
            "goodbye");
        spiritKingSeaDialogue.addReply("hi", 
             "You've found me. Now do you want a shot\n" +
            "at life on earth?\n" +
            "A. Yes, I'll try!\n" +
            "B. No, I don't..\n");

        spiritKingSeaDialogue.addReply("hia", 
             "Spirits like you wander this" +
            " world everyday and now it's finally\n " +
            "your chance to become more than just a soul. I'm sending you\n " +
            "to the Sea where you'll learn to help those\n" +
            "who need you. \n" +
            "A. Okay, sounds great.\n" +
            "B. I don't want to go there. \n");

        spiritKingSeaDialogue.addReply("hib", 
             "Then come back when you do.. Goodbye. \n");

        spiritKingSeaDialogue.addReply("hiaa",  
            "You'll come back when you've finished. Good luck.\n"
            + "Goodbye. \n");

           
        spiritKingSeaDialogue.addReply("hiab",  
            "Then come back when you do.. Goodbye.");
        spiritKingSea.setDialogue(spiritKingSeaDialogue);
        (spiritKingSea.getRoom()).addCharacter(spiritKingSea);
        characters.put("Sea Spirit King", spiritKingSea);

        //

        Character spiritKingCity = new Character("City Spirit King", 
             getRoom("Abyss (City)"), "hi", null );
        Conversation spiritKingCityDialogue = new Conversation( 
            "City Spirit King", 
             "goodbye");
        spiritKingCityDialogue.addReply("hi", 
             "You've found me. Now do you want a shot\n" +
            "at life on earth?\n" +
            "A. Yes, I'll try!\n" +
            "B. No, I don't..");

        spiritKingCityDialogue.addReply("hia", 
             "Spirits like you wander this" +
            " world everyday and now it's finally\n " +
            "your chance to become more than just a soul. I'm sending you\n " +
            "to the Sea where you'll learn to help those\n" +
            "who need you. \n" +
            "A. Okay, sounds great.\n" +
            "B. I don't want to go there. \n");

        spiritKingCityDialogue.addReply("hib", 
             "Then come back when you do.. Goodbye. \n");

        spiritKingCityDialogue.addReply("hiaa", 
             "You'll come back when you've finished. Good luck.\n"
            + "Goodbye. \n");

        spiritKingCityDialogue.addReply("hiab",  
            "Then come back when you do.. Goodbye. \n");
        spiritKingCity.setDialogue(spiritKingCityDialogue);
        (spiritKingCity.getRoom()).addCharacter(spiritKingCity);
        characters.put("City Spirit King", spiritKingCity);

        //

        Character goldSpirit = new Character("Gold Spirit", 
             getRoom("Narrow Path"), "hi", null );
        Conversation goldSpiritDialogue = new Conversation( 
            "Gold Spirit",  
            "me");
        goldSpiritDialogue.addReply("hi", 
            "Don't harm anything in the human world\n" +
            "or you'll be doomed like me! \n");
        goldSpirit.setDialogue(goldSpiritDialogue);
        (goldSpirit.getRoom()).addCharacter(goldSpirit);

        // Savanna Characters     

        EndGameCharacter lionCub1 = new EndGameCharacter("Lion Cub (Biggest)",  
             getRoom("Clearing"), "hi", getRoom("Debug").getItem("berries") );
        Conversation lionCub1Dialogue = new Conversation("Lion Cub (Biggest)", 
             "dinner");
        lionCub1Dialogue.addReply("hi",  
            "I'm sooooo hungry! Where's momma? I want zebra for dinner! \n");
        lionCub1.setDialogue(lionCub1Dialogue);
        (lionCub1.getRoom()).addCharacter(lionCub1);
        characters.put("Lion Cub (Biggest)", lionCub1);

        EndGameCharacter lionCub2 = new EndGameCharacter("Lion Cub (Smallest)", 
              getRoom("Clearing"), "hi", getRoom("Debug").getItem("carcass") );
        Conversation lionCub2Dialogue = new Conversation("Lion Cub (Smallest)", 
             "now");
        lionCub2Dialogue.addReply("hi",  
            "Please find us something to eat! \n" +
            "My mom's been gone for so long now... \n");
        lionCub2.setDialogue(lionCub2Dialogue);
        (lionCub2.getRoom()).addCharacter(lionCub2);
        characters.put("Lion Cub (Smallest)", lionCub2);

        EndGameCharacter lionCub3 = new EndGameCharacter("Lion Cub",  
             getRoom("Clearing"), "hi",  
            getRoom("Debug").getItem("berries") );
        Conversation lionCub3Dialogue = new Conversation( 
            "Lion Cub ", "STAAARVING!");
        lionCub3Dialogue.addReply("hi", "MOMMMYY! I'M STAAARVING! \n");
        lionCub3.setDialogue(lionCub3Dialogue);
        (lionCub3.getRoom()).addCharacter(lionCub3);
        characters.put("Lion Cub", lionCub3);

        EndGameCharacter elephant = new EndGameCharacter("Elephant",  
            getRoom("Field"), 
             "hi", getRoom("Grassy Plains").getItem("nuts") );
        Conversation elephantDialogue = new Conversation("Elephant", 
             "careful");
        elephantDialogue.addReply("hi", 
             "Be careful up ahead. A herd stampedes\n" +
            "through the canyon every sunset. You can\n" +
            "get trampled if you're not careful! \n");
        elephant.setDialogue(elephantDialogue);

        (elephant.getRoom()).addCharacter(elephant);
        elephant.setScared(true);

        Character zebra1 = new LosePointsCharacter("Zebra (tall)",  
             getRoom("Tall Grass"), "hi", null );
        Conversation zebra1Dialogue = new Conversation("Zebra (tall)", 
             "berries");
        zebra1Dialogue.addReply("hi",  
            "I heard there's a huge tree halfway from here! \n"
            + "There's a mean old bird that guards its delicious berries! \n");
        zebra1.setDialogue(zebra1Dialogue);
        (zebra1.getRoom()).addCharacter(zebra1);
        zebra1.setScared(true);

        Character zebra2 = new LosePointsCharacter("Zebra", 
            getRoom("Tall Grass"), 
             "hi", null );
        Conversation zebra2Dialogue = new Conversation( 
            "Zebra", "now.");
        zebra2Dialogue.addReply("hi", 
             "That mom lion has left her babies in the clearing\n" +
            "for an awfully long time now... \n");
        zebra2.setDialogue(zebra2Dialogue);
        (zebra2.getRoom()).addCharacter(zebra2);
        zebra2.setScared(true);

        Monster zebraHerd = new Monster("Zebra Herd", 
              getRoom("Canyon"), "hi", null );
        Conversation zebraHerdDialogue = new Conversation( 
            "Zebra Herd", "now.");
        zebraHerdDialogue.addReply("hi", "Time to migrate! \n");
        zebraHerd.setDialogue(zebraHerdDialogue);
        (zebraHerd.getRoom()).addCharacter(zebraHerd);
        zebraHerd.setScared(false);

        EndGameCharacter warthog = new EndGameCharacter("Warthog", 
              getRoom("Warthog Den"), "hi", null );
        Conversation warthogDialogue = new Conversation("Warthog", 
             "nutritious");
        warthogDialogue.addReply("hi",  
            "There’s a stingy bird up ahead that won’t share\n" +
            "his berries. They’re so nutritious! \n");
        warthog.setDialogue(warthogDialogue);
        (warthog.getRoom()).addCharacter(warthog);
        warthog.setScared(true);

        Monster blueBilledBird = new Monster("Blue-Billed Bird",  
             getRoom("Top of Tree"), "hi", null );
        Conversation blueBilledBirdDialogue = new Conversation( 
            "Blue-Billed Bird", "NOOO");
        blueBilledBirdDialogue.addReply("hi",  
            "GET AWAY FROM MY BERRIES! NOOO! \n");
        blueBilledBird.setDialogue(blueBilledBirdDialogue);
        (blueBilledBird.getRoom()).addCharacter(blueBilledBird);
        blueBilledBird.setScared(true);

        Character seagull1 = new Character("Seagull (brown)",  
             getRoom("Sky"), "hi", null );
        Conversation seagull1Dialogue = new Conversation("Seagull (brown)",  
            "doomed");
        seagull1Dialogue.addReply("hi",  
            "Those fisher-humans are gonna score big tonight!\n" +
            "Those whales are doomed. \n");
        seagull1.setDialogue(seagull1Dialogue);
        (seagull1.getRoom()).addCharacter(seagull1);

        Character seagull2 = new Character("Seagull",  
             getRoom("Sky"), "hi", null );
        Conversation seagull2Dialogue = new Conversation("Seagull", 
             "stuff");
        seagull2Dialogue.addReply("hi", 
             "I heard there’s a shiny object that’ll let us\n" +
            "into that room. We can really mess up some stuff! \n");
        seagull2.setDialogue(seagull2Dialogue);
        (seagull2.getRoom()).addCharacter(seagull2);

        Character fishermanJohn = new Character("Fisherman John",  
             getRoom("Front of Boat"), "hi", null );
        Conversation fishermanJohnDialogue = new Conversation("Fisherman John", 
             "sure");
        fishermanJohnDialogue.addReply("hi",  
            "Those whales are ours for sure! \n");
        fishermanJohn.setDialogue(fishermanJohnDialogue);
        (fishermanJohn.getRoom()).addCharacter(fishermanJohn);
        fishermanJohn.setScared(true);

        Character fishermanBob = new Character("Fisherman Bob",  
             getRoom("Front of Boat"), "hi", null );
        Conversation fishermanBobDialogue = new Conversation("Fisherman Bob",  
            "whale");
        fishermanBobDialogue.addReply("hi",  
            "I can’t wait to eat me some whale mwahaha! \n");
        fishermanBob.setDialogue(fishermanBobDialogue);
        (fishermanBob.getRoom()).addCharacter(fishermanBob);
        fishermanBob.setScared(true);

        Character fishermanKyle = new Character("Fisherman Kyle",   
            getRoom("Back of Boat"), "hi", null );
        Conversation fishermanKyleDialogue = new Conversation(
            "Fisherman Kyle",  
            "nets");
        fishermanKyleDialogue.addReply("hi", 
             "I hate nets… \n");
        fishermanKyle.setDialogue(fishermanKyleDialogue);
        (fishermanKyle.getRoom()).addCharacter(fishermanKyle);
        fishermanKyle.setScared(true);

        EndGameCharacter whale1 = new EndGameCharacter("Whale (blue)",  
             getRoom("Seaweed Forest"), "hi", null );
        Conversation whale1Dialogue = new Conversation("Whale (blue)",  
            "great");
        whale1Dialogue.addReply("hi", "Today is great! \n");
        whale1.setDialogue(whale1Dialogue);
        (whale1.getRoom()).addCharacter(whale1);

        EndGameCharacter whale2 = new EndGameCharacter("Whale (gray)",   
            getRoom("Seaweed Forest"), "hi", null );
        Conversation whale2Dialogue = new Conversation("Whale (gray)", 
             "today");
        whale2Dialogue.addReply("hi", "Everything is going perfect today! \n");
        whale2.setDialogue(whale2Dialogue);
        (whale2.getRoom()).addCharacter(whale2);

        Character fish = new LosePointsCharacter("Fish",   
            getRoom("Coral Reef"), "hi", null );
        Conversation fishDialogue = new Conversation("Fish", 
             "fishermen");
        fishDialogue.addReply("hi",  
            "I feel bad for those whales.. " +
            "If I could fly I’d go\n" +
            "up to that boat and mess everything up for those fishermen! \n");
        fish.setDialogue(fishDialogue);
        (fish.getRoom()).addCharacter(fish);

        Character tuna = new LosePointsCharacter("Tuna",  
             getRoom("Under the Boat"), "hi", 
             getRoom("Inside of Boat").getItem("seashell") );
        Conversation tunaDialogue = new Conversation("Tuna", 
             "want");
        tunaDialogue.addReply("hi",  
            "Strength in numbers! We can help you if you\n" +
            "have something we want.. \n");
        tuna.setDialogue(tunaDialogue);
        (tuna.getRoom()).addCharacter(tuna);
        characters.put("Tuna", tuna);

        EndGameCharacter stingray = new EndGameCharacter("Stingray",  
             getRoom("Seaside"), "hi", null);
        Conversation stingrayDialogue = new Conversation("Stingray", 
             "team");
        stingrayDialogue.addReply("hi",  
            "Those tuna are big. I’d like to have that\n"
            + "kind of power on my team. \n");
        stingray.setDialogue(stingrayDialogue);
        (stingray.getRoom()).addCharacter(stingray);

        Character guy = new LosePointsCharacter("Guy",   
            getRoom("Street"), "hi", null );
        Conversation guyDialogue = new Conversation("Guy",  
            "alleyway");
        guyDialogue.addReply("hi",  
            "I’m worried; I heard something crazy \n" +
            "going on in an alleyway.. \n");
        guy.setDialogue(guyDialogue);
        (guy.getRoom()).addCharacter(guy);

        Character dog = new LosePointsCharacter("Dog",  
             getRoom("Street"), "hi", null );
        Conversation dogDialogue = new Conversation("Dog", 
             "happening");
        dogDialogue.addReply("hi", 
             "Bark! Bark! I smell something scary happening.. \n");
        dog.setDialogue(dogDialogue);
        (dog.getRoom()).addCharacter(dog);

        Monster criminal = new Monster("Criminal",  
             getRoom("Alleyway"), "hi", null );
        Conversation criminalDialogue = new Conversation("Criminal",  
            "IT");
        criminalDialogue.addReply("hi",  
            "DON’T COME ANY CLOSER OR THE GIRL GETS IT!! \n");
        criminal.setDialogue(criminalDialogue);
        criminal.setScared(true);

        (criminal.getRoom()).addCharacter(criminal);

        EndGameCharacter girl = new EndGameCharacter("Girl", 
            getRoom("Alleyway"),  
            "hi", getRoom("Debug").getItem("purse") );
        Conversation girlDialogue = new Conversation("Girl", 
             "SOMEONE");
        girlDialogue.addReply("hi", "AHHHH! PLEASE HELP ME! SOMEONE! \n");
        girl.setDialogue(girlDialogue);
        girl.setScared(false);
        (girl.getRoom()).addCharacter(girl);
        characters.put("Girl", girl);

        EndGameCharacter cop = new EndGameCharacter("Cop",  
             getRoom("Corner of Building"), "hi", null );
        Conversation copDialogue = new Conversation("Cop",  
            "lately");
        copDialogue.addReply("hi",  
            "Have you seen anything suspicious lately? \n");
        cop.setDialogue(copDialogue);
        (cop.getRoom()).addCharacter(cop);
        cop.setScared(true);

    }

    /**
     * Creates all the players of the world
     */
    public void createPlayers() {
        Player lioness = new Lioness( getRoom("Clearing") , 1);
        players.put("lioness", lioness);

        Player lemur = new Lemur( getRoom("Clearing"), 2);
        players.put("lemur", lemur);

        Player pelican = new Pelican( getRoom("Buoy"), 1);
        players.put("pelican", pelican);

        Player shark = new Shark( getRoom("Buoy"), 1);
        players.put("shark", shark);

        Player human = new Human( getRoom("Apartment"), 2);
        players.put("human", human);

        Player dog = new Dog(getRoom("Apartment"), 1);
        players.put("dog", dog);

        Player spirit = new Player(getRoom("Plain"), 3);
        players.put("spirit", spirit);
    }

    /**
     * Returns a player
     * 
     * @param characterName - the name of the desired player
     * @return the player
     */
    public Player getPlayer(String characterName) {
        return players.get(characterName);
    }
}
