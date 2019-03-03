package jpong.display;

import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;

/**
 * The Display class handles the JFrame and Canvas for the game window
 * @author Ryan Wilson
 */
public class Display {
    //Fields
    private String title;
    private int width;
    private int height;
    
    //Objects
    private JFrame frame;
    private Canvas canvas;
    
    /**
     * Constructs the Display object
     * @param title the title of the window
     * @param width the width of the window in pixels
     * @param height the height of the window in pixels
     */
    public Display(String title, int width, int height){
        this.title = title;
        this.width = width;
        this.height = height;
        createWindow();
    }
    
    //Creates a new window
    private void createWindow(){
        frame = new JFrame(title);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setMaximumSize(new Dimension(width, height));
        canvas.setMinimumSize(new Dimension(width, height));
        canvas.setFocusable(false);
        
        frame.add(canvas);
        frame.pack();
    }
    
    /**
     * Gets the JFrame object
     * @return the JFrame object
     */
    public JFrame getJFrame(){
        return frame;
    }
    
    /**
     * Gets the Canvas object
     * @return the Canvas object
     */
    public Canvas getCanvas(){
        return canvas;
    }
}
