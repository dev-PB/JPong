package jpong.entities;

import java.awt.Color;
import jpong.Game;

/**
 *
 * @author Ryan Wilson
 */
public class Player extends Paddle {
    private Game game;
    
    public Player(int x, int y, int width, int height, Color colour, Game game){
        super(x, y, width, height, colour);
        this.game = game;

    }
    
    @Override
    public void movePaddle(){
        game.getKeyManager().update();
        if(game.getKeyManager().getRight() && (x + width) != game.getWindowWidth()){
            x += moveSpeed;
        } else if (game.getKeyManager().getLeft() && x != 0){
            x -= moveSpeed;
        }
    }
}
