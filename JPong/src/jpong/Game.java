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
 * The Game class handles the running of the game
 * @author Ryan Wilson
 */
public class Game implements Runnable {
    //Fields
    private boolean isRunning;
    private String windowTitle;
    private int windowWidth;
    private int windowHeight;
    private final int WINNING_SCORE;
    private final int FPS;
    
    //Objects
    private Display display;
    private Thread thread;
    private BufferStrategy buffer;
    private Graphics graphics;
    private Player playerOne;
    private Player playerTwo;
    private Ball ball;
    private final KeyManager keyManager;
    private Font scoreFont;
    private Font winFont;
    
    /**
     * Constructs the Game object
     * @param windowTitle the title of the window
     * @param windowWidth the width of the window in pixels
     * @param windowHeight the height of the window in pixels
     */
    public Game(String windowTitle, int windowWidth, int windowHeight){
        WINNING_SCORE = 10;
        FPS = 60;
        isRunning = false;
        this.windowTitle = windowTitle;
        this.windowWidth = windowWidth;
        this.windowHeight = windowHeight;
        keyManager = new KeyManager();
    }
    
    //Initialises objects to be used in the game
    private void init(){   
        display = new Display(windowTitle, windowWidth, windowHeight);
        display.getJFrame().addKeyListener(keyManager);
        playerOne = new Player((windowWidth / 2) - 50,20,100,30,Color.red, this, false);
        playerTwo = new Player((windowWidth / 2) - 50,windowHeight - 50, 100,30,Color.blue, this, true);
        scoreFont = new Font("Comic Sans MS", Font.PLAIN, 20);
        winFont = new Font("Comic Sans MS", Font.BOLD, 30);
        ball = new Ball(10,10,Color.black,this);      
    }
    
    //Ticks the game
    private void update(){
        playerOne.update();
        playerTwo.update();
        ball.update();
    }
    
    //Renders everything to the screen
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
        renderWinners();
        
        //Displays buffer
        buffer.show(); 
        graphics.dispose();
    }
    
    //Renders player's scores to the screen
    private void renderScores(int p1Points, int p2Points){
        graphics.setFont(scoreFont);
        graphics.drawString("Player one: " + p1Points, windowWidth - 150, 20);
        graphics.drawString("Player two: " + p2Points, windowWidth - 150, windowHeight - 20);
    }
    
    //Renders the win screen for either player if one of them wins
    private void renderWinners(){
        graphics.setFont(winFont);
        if (playerOne.checkIfWin(WINNING_SCORE)){
            graphics.clearRect(0,0,windowWidth,windowHeight);
            graphics.setColor(playerOne.getColour());
            graphics.drawString("PLAYER ONE WINS!", (windowWidth / 2) - 150, windowHeight / 2);
            isRunning = false;
            
            
        } else if (playerTwo.checkIfWin(WINNING_SCORE)){
            graphics.clearRect(0,0,windowWidth,windowHeight);
            graphics.setColor(playerTwo.getColour());
            graphics.drawString("PLAYER TWO WINS!", (windowWidth / 2) - 150, windowHeight / 2);
            isRunning = false;
            
        }
    }
    
    /**
     * Gets the keyManager object
     * @return a keyManager object
     */
    public KeyManager getKeyManager(){
        return keyManager;
    }
    
    /**
     * Gets the width of the window
     * @return the width of the window in pixels
     */
    public int getWindowWidth(){
        return windowWidth;
    }
    
    /**
     * Gets the height of the window
     * @return the height of the window in pixels
     */
    public int getWindowHeight(){
        return windowHeight;
    }
    
    /**
     * Gets the Player object for player one
     * @return the Player object for player one
     */
    public Player getPlayerOne(){
        return playerOne;
    }
    
    /**
     * Gets the Player object for player two
     * @return the Player object for player two
     */
    public Player getPlayerTwo(){
        return playerTwo;
    }
    
    //Runs the game
    @Override 
    public void run(){
        init();
        double timePerUpdate = 1000000000 / FPS;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        
        while(isRunning){
            now = System.nanoTime();
            delta += (now - lastTime) / timePerUpdate;
            lastTime = now;
            
            if(delta >= 1){
                update();
                render();
            }
        }
        stop();
    }
    
    /**
     * Starts the game and a new thread
     */
    public synchronized void start(){
        if(isRunning){
            return;
        }
        isRunning = true;
        thread = new Thread(this);
        thread.start();
    }
    
    /**
     * Stops the game and terminates the game thread
     */
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
