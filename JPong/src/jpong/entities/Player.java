package jpong.entities;

import java.awt.Color;

/**
 *
 * @author Ryan Wilson
 */
public class Player extends Paddle {
    
    public Player(int x, int y, int width, int height, Color colour){
        super(x, y, width, height, colour);
    }
    
    @Override
    public void movePaddle(){
        x += 1;
    }
}
