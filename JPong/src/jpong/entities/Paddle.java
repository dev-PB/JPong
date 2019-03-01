package jpong.entities;

import java.awt.Color;
import java.awt.Graphics;
import jpong.Game;

/**
 *
 * @author Ryan Wilson
 */
public class Paddle {
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected int points;
    protected Color colour;
    protected int moveSpeed;
    protected Game game;
    protected final int DEFAULT_X;
    
    public Paddle(int x, int y, int width, int height, Color colour, Game game){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;  
        this.colour = colour;
        this.game = game;
        points = 0;
        moveSpeed = 2;
        DEFAULT_X = (game.getWindowWidth() / 2) - (width/2);
    }
    public void update(Graphics graphics){
        movePaddle();
        renderPaddle(graphics);
    }
    
    private void renderPaddle(Graphics graphics){
        graphics.setColor(colour);
        graphics.fillRect(x,y,width,height);
    }
    
    public void movePaddle(){
        
    }
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
    
    public int getWidth(){
        return width;
    }
    
    public int getHeight(){
        return height;
    }
    
    public int getPoints(){
        return points;
    }
    
    public void incrementPoints(){
        points++;
    }
    
    public void reset(){
        x = DEFAULT_X;
    }
}
