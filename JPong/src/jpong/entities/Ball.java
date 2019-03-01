package jpong.entities;

import java.awt.Color;
import java.awt.Graphics;
import jpong.Game;

/**
 *
 * @author Ryan Wilson
 */
public class Ball {
    private int x;
    private int y;
    private final int DEFAULT_X = 400;
    private final int DEFAULT_Y = 300;
    private int width;
    private int height;
    private Color colour;
    private Game game;
    private Graphics graphics;
    private int xMovement;
    private int yMovement;
    
    public Ball(int width, int height, Color colour, Game game){
        x = DEFAULT_X;
        y = DEFAULT_Y;
        xMovement = 1;
        yMovement = -1;
        this.width = width;
        this.height = height;
        this.colour = colour;
        this.game = game;
        
    }
    
    public void update(Graphics graphics){
       paddleCollision();
       outOfBounds();
       move();
       render(graphics);
    }
    
    private void render(Graphics graphics){
        graphics.setColor(colour);
        graphics.fillRect(x,y,width,height);
    }
    
    private void move(){
        x += xMovement;
        y += yMovement;
    }
    
    private void paddleCollision(){
        if (x <= game.getPlayerOne().getX() + game.getPlayerOne().getWidth() && x>= game.getPlayerOne().getX() && y >= game.getPlayerOne().getY() && y <= game.getPlayerOne().getY() + game.getPlayerOne().getHeight()){
            yMovement = -yMovement;
            if(x >  game.getPlayerOne().getX() + game.getPlayerOne().getWidth() / 2){
                xMovement = 10;
            } else {
                xMovement = -10;
            }
        }
        
        else if (x <= game.getPlayerTwo().getX() + game.getPlayerTwo().getWidth() && x>= game.getPlayerTwo().getX() && y >= game.getPlayerTwo().getY() && y <= game.getPlayerTwo().getY() + game.getPlayerTwo().getHeight()){
            
            
            if (x > game.getPlayerTwo().getX() + (game.getPlayerTwo().getWidth() / 2)){
                xMovement = -1;
            }
            
            yMovement = -yMovement;
        }
    }
    
    private void outOfBounds(){
        if(x > game.getWindowWidth() || x + width > 0){
            xMovement = -xMovement;
        }
        if (y > game.getWindowHeight() || y + height < 0){
            reset();
        }
    }
    
    public void reset(){
        x = DEFAULT_X;
        y = DEFAULT_Y;
    }
}
