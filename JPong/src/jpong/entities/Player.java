package jpong.entities;

import java.awt.Color;
import jpong.Game;

/**
 * A human player
 * @author Ryan Wilson
 */
public class Player extends Paddle {
    private boolean arrowControls;
    
    /**
     * Constructs the Player object
     * @param x the x position of the player's paddle
     * @param y the y position of the player's paddle
     * @param width the width of the player's paddle in pixels
     * @param height the height of the player's paddle in pixels
     * @param colour the colour of the player's paddle
     * @param game the Game object
     * @param arrowControls if true, the player uses the left and right arrow keys to move, else they use A and D
     */
    public Player(int x, int y, int width, int height, Color colour,Game game, boolean arrowControls){
        super(x, y, width, height, colour, game);
        this.arrowControls = arrowControls;
    }
    
    //Moves the Player's paddle depending on what key they press and what controls they're using
    @Override
    public void movePaddle(){
        game.getKeyManager().update();
        if(game.getKeyManager().getRight(arrowControls) && (x + width) < game.getWindowWidth()){
            x += moveSpeed;
        } else if (game.getKeyManager().getLeft(arrowControls) && x > 0){
            x -= moveSpeed;
        }
           
    }
}
