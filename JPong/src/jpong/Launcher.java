package jpong;

/**
 * <h1>JPong - a simple pong game made in Java.</h1>
 * @author Ryan Wilson
 * @version 1.0.1 03/03/2019
 * The Launcher class launches the game
 */
public class Launcher {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Game game = new Game("JPong", 800, 600);
        game.start();
    }
    
}
