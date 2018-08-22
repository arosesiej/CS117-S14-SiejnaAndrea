/**
 * The sole purpose of this class is to start the game up. It does this by
 * creating an instance of the Game and calling it's play method.
 * 
 * @author Maria Jump, Andrea Siejna
 * @version 2013.01.22
 */
public class Main {

    /**
     * The main program.
     * @param args The command line arguments.
     */
    public static void main(String[] args) {
        Game game = new Game();
        game.play();
    }
}
