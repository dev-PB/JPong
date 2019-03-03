package jpong.entities;

import java.awt.Color;
import java.awt.Graphics;
import jpong.Game;

/**
 * The ball to be used for the game
 * @author Ryan Wilson
 */
public class Ball {
    //Fields
    private int x;
    private int y;
    private final int DEFAULT_X;
    private final int DEFAULT_Y;
    private int width;
    private int height;
    private int xMovement;
    private int yMovement;
    private boolean serveDirection;
    private final int VELOCITY;
    
    //Objects
    private Color colour;
    private Game game;
    private Graphics graphics;
    
    
    /**
     * Constructs the Ball object
     * @param width the width of the ball in pixels
     * @param height the height of the ball in pixels
     * @param colour the colour of the ball
     * @param game the game object
     */
    public Ball(int width, int height, Color colour, Game game){
        VELOCITY = 10;
        xMovement = 0;
        yMovement = -VELOCITY;
        this.width = width;
        this.height = height;
        this.colour = colour;
        this.game = game;
        serveDirection = true;
        DEFAULT_X = (game.getWindowWidth() / 2) - (this.width / 2);
        DEFAULT_Y = (game.getWindowHeight() / 2) - (this.height / 2);
        x = DEFAULT_X;
        y = DEFAULT_Y;
    }
    
    /**
     * Ticks the ball
     */
    public void update(){
       paddleCollision();
       outOfBounds();
       move();     
    }
    
    /**
     * Renders the ball
     * @param graphics the Graphics object
     */
    public void render(Graphics graphics){
        graphics.setColor(colour);
        graphics.fillRect(x,y,width,height);
    }
    
    //Moves the Ball's x and y position
    private void move(){
        x += xMovement;
        y += yMovement;
    }
    
    //Checks if the ball has collided with a Player's paddle, and changes movement accordingly
    private void paddleCollision(){
        if (x <= game.getPlayerOne().getX() + game.getPlayerOne().getWidth() && x>= game.getPlayerOne().getX() && y >= game.getPlayerOne().getY() && y <= game.getPlayerOne().getY() + game.getPlayerOne().getHeight()){
            yMovement = -yMovement;
            if(x + (width/2) >  game.getPlayerOne().getX() + game.getPlayerOne().getWidth() / 2){
                xMovement = VELOCITY;
            } else {
                xMovement = -VELOCITY;
            }
            
        } else if (x <= game.getPlayerTwo().getX() + game.getPlayerTwo().getWidth() && x>= game.getPlayerTwo().getX() && y >= game.getPlayerTwo().getY() && y <= game.getPlayerTwo().getY() + game.getPlayerTwo().getHeight()){
            if(x + (width/2) >  game.getPlayerTwo().getX() + game.getPlayerTwo().getWidth() / 2){
                xMovement = VELOCITY;
            } else {
                xMovement = -VELOCITY;
            }
            
            yMovement = -yMovement;
        }
    }
    
    //Checks to see if the Ball is out of bounds, and if it is, it bounces.
    private void outOfBounds(){
        if(x > game.getWindowWidth() || x + width < 0){
            xMovement = -xMovement;
        }
        if (y > game.getWindowHeight()){
            reset();
            game.getPlayerOne().incrementPoints();
            System.out.println("P1: " + game.getPlayerOne().getPoints());
        } else if (y + height < 0) {
            reset();
            game.getPlayerTwo().incrementPoints();
            System.out.println("P2: " + game.getPlayerTwo().getPoints());
        }
    }
    
    /**
     * Resets the Ball object's position, the Player object's positions, and toggles the direction of the next serve
     */
    public void reset(){
        x = DEFAULT_X;
        y = DEFAULT_Y;
        game.getPlayerOne().reset();
        game.getPlayerTwo().reset();
        if(serveDirection){
            serveDirection = false;
            xMovement = 0;
            yMovement = -VELOCITY;
        } else {
            serveDirection = true;
            xMovement = 0;
            yMovement = VELOCITY;
        }
    }
}
