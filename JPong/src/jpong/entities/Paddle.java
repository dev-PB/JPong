package jpong.entities;

import java.awt.Color;
import java.awt.Graphics;

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
    
    public Paddle(int x, int y, int width, int height, Color colour){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;  
        this.colour = colour;
        points = 0;
        moveSpeed = 2;
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
}
