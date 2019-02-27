package jpong.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Ryan Wilson
 */
public class KeyManager implements KeyListener {
    
    private boolean[] keys;
    private boolean left;
    private boolean right;
    private boolean A;
    private boolean D;
    
    public KeyManager(){
        keys = new boolean[256];
    }
    
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
    
    public boolean getLeft(boolean arrows){
        if(arrows){
            return left;
        } else {
            return A;
        }
    }
    
    public boolean getRight(boolean arrows){
        if(arrows){
            return right;
        } else {
            return D;
        }
    }
    
}
