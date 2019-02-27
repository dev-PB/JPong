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
    
    public KeyManager(){
        keys = new boolean[256];
    }
    
    public void update(){
        left = keys[KeyEvent.VK_A];
        right = keys[KeyEvent.VK_D];
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
    
    public boolean getLeft(){
        return left;
    }
    
    public boolean getRight(){
        return right;
    }
    
}
