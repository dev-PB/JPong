package jpong;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import jpong.display.Display;

/**
 *
 * @author Ryan Wilson
 */
public class Game {
    private boolean isRunning;
    private String windowTitle;
    private int windowWidth;
    private int windowHeight;
    
    private Display display;
    private Thread thread;
    private BufferStrategy buffer;
    private Graphics graphics;
    
    public Game(String windowTitle, int windowWidth, int windowHeight){
        isRunning = false;
        this.windowTitle = windowTitle;
        this.windowWidth = windowWidth;
        this.windowHeight = windowHeight;
    }
}
