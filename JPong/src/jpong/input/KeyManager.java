package jpong.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Manages keyboard inputs
 * @author Ryan Wilson
 */
public class KeyManager implements KeyListener {
    //Fields
    private boolean[] keys;
    private boolean left;
    private boolean right;
    private boolean A;
    private boolean D;
    
    /**
     * Constructs the KeyManager object
     */
    public KeyManager(){
        keys = new boolean[256];
    }
    
    /**
     * Updates the state of the keys
     */
    public void update(){
        left = keys[KeyEvent.VK_LEFT];
        right = keys[KeyEvent.VK_RIGHT];
        A = keys[KeyEvent.VK_A];
        D = keys[KeyEvent.VK_D];
    }
    
    @Override
    public void keyPressed(KeyEvent e){
        keys[e.getKeyCode()] = true;
    }
    
    @Override
    public void keyReleased(KeyEvent e){
        keys[e.getKeyCode()] = false;
    }
    
    @Override
    public void keyTyped(KeyEvent e){
        
    }
    
    /**
     * Gets the state of the key the player uses to move left
     * @param arrows if the player uses arrow keys or not
     * @return true or false for the left arrow key if the arrows parameter is true, or true or false for the A key if the arrows parameter is false
     */
    public boolean getLeft(boolean arrows){
        if(arrows){
            return left;
        } else {
            return A;
        }
    }
    
    /**
     * Gets the state of the key the player uses to move right
     * @param arrows if the player uses arrow keys or not
     * @return true or false for the right arrow key if the arrows parameter is true, or true or false for the D key if the arrows parameter is false
     */
    public boolean getRight(boolean arrows){
        if(arrows){
            return right;
        } else {
            return D;
        }
    }
    
}
