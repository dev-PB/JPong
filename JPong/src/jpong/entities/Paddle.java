package jpong.entities;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Ryan Wilson
 */
public class Paddle {
    private int x;
    private int y;
    private int width;
    private int height;
    private int points;
    private Color colour;
    
    public Paddle(int x, int y, int width, int height, Color colour){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.colour = colour;
        points = 0;
    }
    
    public void renderPaddle(Graphics graphics){
        graphics.setColor(colour);
        graphics.fillRect(x,y,width,height);
    }
    
    
}
