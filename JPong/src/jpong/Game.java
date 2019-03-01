package jpong;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import jpong.display.Display;
import jpong.entities.Ball;
import jpong.entities.Player;
import jpong.input.KeyManager;

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
    private Player playerOne;
    private Player playerTwo;
    private Ball ball;
    private KeyManager keyManager;
    private Font scoreFont;
    
    public Game(String windowTitle, int windowWidth, int windowHeight){
        isRunning = false;
        this.windowTitle = windowTitle;
        this.windowWidth = windowWidth;
        this.windowHeight = windowHeight;
        keyManager = new KeyManager();
    }
    
    
    private void init(){
        display = new Display(windowTitle, windowWidth, windowHeight);
        display.getJFrame().addKeyListener(keyManager);
        playerOne = new Player(20,20,100,30,Color.red, this, false);
        playerTwo = new Player(windowWidth - 50,windowHeight - 50, 100,30,Color.blue, this, true);
        scoreFont = new Font("Comic Sans MS", Font.PLAIN, 20);
        ball = new Ball(10,10,Color.black,this);
        
        
        
    }
    
    private void update(){
        playerOne.update();
        playerTwo.update();
        ball.update();
    }
    
    private void render(){
        buffer = display.getCanvas().getBufferStrategy();
        if(buffer == null){
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        graphics = buffer.getDrawGraphics();
        
        //Clears screen
        graphics.clearRect(0,0,windowWidth,windowHeight);
        //Renders things
        playerOne.render(graphics);
        playerTwo.render(graphics);
        ball.render(graphics);
        renderScores(playerOne.getPoints(), playerTwo.getPoints());
        //Displays buffer
        buffer.show(); 
        graphics.dispose();
    }
    
    private void renderScores(int p1Points, int p2Points){
        graphics.setFont(scoreFont);
        graphics.drawString("Player one: " + p1Points, windowWidth - 150, 20);
        graphics.drawString("Player two: " + p2Points, windowWidth - 150, windowHeight - 20);
    }
    
    public KeyManager getKeyManager(){
        return keyManager;
    }
    
    public int getWindowWidth(){
        return windowWidth;
    }
    
    public int getWindowHeight(){
        return windowHeight;
    }
    
    public Player getPlayerOne(){
        return playerOne;
    }
    
    public Player getPlayerTwo(){
        return playerTwo;
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
