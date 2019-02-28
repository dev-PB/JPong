package jpong.entities;

import java.awt.Color;

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
    
    public Ball(int width, int height, Color colour){
        x = DEFAULT_X;
        y = DEFAULT_Y;
        this.width = width;
        this.height = height;
        this.colour = colour;
    
        
    }
    
    public void update(){
       move();
       render();
    }
    
    private void render(){
        
    }
    
    private void move(){
        
    }
    
    public void reset(){
        x = DEFAULT_X;
        y = DEFAULT_Y;
    }
}
