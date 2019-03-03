package jpong.entities;

import java.awt.Color;
import java.awt.Graphics;
import jpong.Game;

/**
 * A paddle to be used for the game
 * @author Ryan Wilson
 */
public class Paddle {
    /**
     * The x position of the Paddle
     */
    protected int x;
    
    /**
     * The y position of the Paddle
     */
    protected int y;
    
    /**
     * The width of the Paddle in pixels
     */
    protected int width;
    
    /**
     * The height of the Paddle in pixels
     */
    protected int height;
    
    /**
     * The amount of points the Paddle has
     */
    protected int points;
    
    /**
     * The colour of the Paddle
     */
    protected Color colour;
    
    /**
     * The amount of pixels the Paddle moves per frame while moving
     */
    protected int moveSpeed;
    
    /**
     * The Game object
     */
    protected Game game;
    
    /**
     * The default x position of the paddle
     */
    protected final int DEFAULT_X;
    
    /**
     * Constructs the Paddle object
     * @param x the x position of the paddle
     * @param y the y position of the paddle
     * @param width the width of the paddle in pixels
     * @param height the height of the paddle in pixels
     * @param colour the colour of the paddle
     * @param game the Game object
     */
    public Paddle(int x, int y, int width, int height, Color colour, Game game){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;  
        this.colour = colour;
        this.game = game;
        points = 0;
        moveSpeed = 20;
        DEFAULT_X = (game.getWindowWidth() / 2) - (width/2);
    }
    
    /**
     * Ticks the paddle
     */
    public void update(){
        movePaddle();
        
    }
    
    /**
     * Renders the paddle to the screen
     * @param graphics the Graphics object
     */
    public void render(Graphics graphics){
        graphics.setColor(colour);
        graphics.fillRect(x,y,width,height);
    }
    
    /**
     * Returns true if the paddle has enough points to win
     * @param scoreToWin the amount of points needed to return true
     * @return true if points field is greater than or equal to the scoreToWin parameter
     */
    public boolean checkIfWin(int scoreToWin){
        if (points >= scoreToWin){
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Moves the paddle
     */
    public void movePaddle(){
        
    }
    
    /**
     * Gets the colour of the paddle
     * @return the Color object
     */
    public Color getColour(){
        return colour;
    }
    
    /**
     * Gets the x position of the paddle
     * @return the x position of the paddle
     */
    public int getX(){
        return x;
    }
    
    /**
     * Gets the y position of the paddle
     * @return the y position of the paddle
     */
    public int getY(){
        return y;
    }
    
    /**
     * Gets the width of the paddle
     * @return the width of the paddle in pixels
     */
    public int getWidth(){
        return width;
    }
    
    /**
     * Gets the height of the paddle
     * @return the height of the paddle in pixels
     */
    public int getHeight(){
        return height;
    }
    
    /**
     * Gets the amount of points the paddle has
     * @return the amount of points the paddle has
     */
    public int getPoints(){
        return points;
    }
    
    /**
     * Increments the paddle's points by 1
     */
    public void incrementPoints(){
        points++;
        
    }
    
    /**
     * Resets the paddle's x position
     */
    public void reset(){
        x = DEFAULT_X;
    }
}
