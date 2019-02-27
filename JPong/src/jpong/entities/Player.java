package jpong.entities;

import java.awt.Color;
import jpong.Game;

/**
 *
 * @author Ryan Wilson
 */
public class Player extends Paddle {
    private Game game;
    private boolean arrowControls;
    
    public Player(int x, int y, int width, int height, Color colour, boolean arrowControls, Game game){
        super(x, y, width, height, colour);
        this.game = game;
        this.arrowControls = arrowControls;
    }
    
    @Override
    public void movePaddle(){
        game.getKeyManager().update();
        if(game.getKeyManager().getRight(arrowControls) && (x + width) != game.getWindowWidth()){
            x += moveSpeed;
        } else if (game.getKeyManager().getLeft(arrowControls) && x != 0){
            x -= moveSpeed;
        }
           
    }
}
