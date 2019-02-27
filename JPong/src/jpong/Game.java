package jpong;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import jpong.display.Display;

/**
 *
 * @author Ryan Wilson
 */
public class Game implements Runnable {
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
    
    
    private void init(){
        display = new Display(windowTitle, windowWidth, windowHeight);
    }
    
    private void update(){
        // stuff to update each tick
    }
    
    private void render(){
        // stuff to render each tick
    }
    
    @Override 
    public void run(){
        init();
        while(isRunning){
            update();
            render();
        }
        stop();
    }
    
    public synchronized void start(){
        if(isRunning){
            return;
        }
        isRunning = true;
        thread = new Thread(this);
        thread.start();
    }
    
    public synchronized void stop(){
        if(!isRunning){
            return;
        }
        isRunning = false;
        try {
            thread.join();
        } catch(InterruptedException ie){
            ie.printStackTrace();
        }
    }
}
