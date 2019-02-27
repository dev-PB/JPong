
package display;

import java.awt.Canvas;
import javax.swing.JFrame;

/**
 *
 * @author Ryan Wilson
 */
public class Display {
    private String title;
    private int width;
    private int height;
    
    private JFrame frame;
    private Canvas canvas;
    
    public Display(String title, int width, int height){
        this.title = title;
        this.width = width;
        this.height = height;
    }
}
