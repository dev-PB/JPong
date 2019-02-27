package display;

import java.awt.Canvas;
import java.awt.Dimension;
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
        createWindow();
    }
    
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
}
