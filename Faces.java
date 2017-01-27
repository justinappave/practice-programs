import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 * GUI for drawing faces.  This has animation added to it.  The paint method is called every 200 ms
 * to redraw the window.  If we paint something different each time it is called, we 
 * see animation!
 */
public class Faces extends JFrame {
    // Information on how to draw a face.  The information for
    // the face, eyes and mouth is relative.  Each number indicates
    // a percentage of the space available that should be used
    // for each component and a percentage to move left for the
    // x-coordinates and a percentage to move down for the 
    // y-coordinates.
    
    // Relative info for face (circle) where (x,y) are top left of
    // bounding box and diameter is size of bounding box.
    public static final float FACE_DIAMETER = 1.0f;
    public static final float X_FACE = 0.0f;
    public static final float Y_FACE = 0.0f;
    
    // Relative info for eyes
    public static final float EYE_WIDTH  =  0.3f;
    public static final float EYE_HEIGHT = 0.15f;
    public static final float X_LEFT_EYE = 0.15f;
    public static final float X_RIGHT_EYE = 0.55f;
    public static final float Y_RIGHT_EYE = 0.35f;
    public static final float Y_LEFT_EYE = 0.35f;
    
    //Relative info for mouth
    public static final float MOUTH_WIDTH = 0.5f;
    public static final float MOUTH_HEIGHT = 0.25f;
    public static final float X_MOUTH = 0.25f;
    public static final float Y_MOUTH = 0.55f;
    public static final int MOUTH_START_ANGLE = 180;
    public static final int MOUTH_DEGREES_SHOWN = 180;
    
    public static final int WINDOW_WIDTH = 400;
    public static final int WINDOW_HEIGHT = 400;
    public static final int BORDER_SIZE = 50;
    
    public int numberOfFaces = 1;
   
    /** 
     * Draws a face in the specified bounding box on the specified canvas.
     * The relative information for a face stored in the constants is transformed to
     * ensure the face fills the entire bounding box.
     * <p>
     * The bounding box to draw in should be contained in the canvas/window, otherwise
     * nothing will show in the window.
     *
     * @param canvas the canvas/window to draw the face in.
     * @param top_x the x-coordinate of the top-left corner of the box to draw in.
     * @param top_y the y-coordinate of the top-left corner of the box to draw in.
     * @param width the width of the bounding box to draw in.
     * @param height the height of the boudning box to draw in.
     */
    public void drawFace(Graphics canvas, int top_x, int top_y, int width, int height) { 
        // Draw face outline
        canvas.drawOval((int)(width * X_FACE) + top_x, 
                        (int)(height * Y_FACE) + top_y,
                        (int)(width * FACE_DIAMETER), 
                        (int)(height * FACE_DIAMETER));
        //Draw eyes
        canvas.fillOval((int)(width * X_LEFT_EYE) + top_x,
                        (int)(height * Y_LEFT_EYE) + top_y,
                        (int)(width * EYE_WIDTH),
                        (int)(height * EYE_HEIGHT));
        canvas.fillOval((int)(width * X_RIGHT_EYE) + top_x,
                        (int)(height * Y_RIGHT_EYE) + top_y,
                        (int)(width * EYE_WIDTH),
                        (int)(height * EYE_HEIGHT));
                        
        // Draw mouth
        canvas.drawArc((int)(width * X_MOUTH) + top_x,
                        (int)(height * Y_MOUTH) + top_y,
                        (int)(width * MOUTH_WIDTH),
                        (int)(height * MOUTH_HEIGHT),
                        MOUTH_START_ANGLE, MOUTH_DEGREES_SHOWN);
    }    

    /**
     * Draws what should be displayed in this window.  this will be called each
     * time the window needs to be refreshed.  This includes when the window
     * is displayed, maximized, moved, etc.)
     * <p>
     * Currently, it just draws one face.  This code will have to be updated such
     * that more faces are drawn based on the value stored in numberOfFaces.  Use
     * a switch statement to determine the value and draw the correct number of faces.
     * <p>
     * To draw more faces, you will have to make the bounding box for each
     * face smaller than if there is just one face and for each face drawn in a single
     * window, you'll have to move the top-left corner.
     *
     * @param canvas the canvas/window to draw in.
     */
    public void paint(Graphics canvas) {
        // We need to do this call to make sure the window is wiped clean before we
        // start drawing.
        super.paint(canvas);
        
        // Set bounding box to draw face into.  This includes the top-left
        // x and y coordinates and the width and height of the box to draw in.
        int top_x = BORDER_SIZE;
        int top_y = BORDER_SIZE;
        
        // We'll set the size such that we can fit the required number of faces.
        int width = (getWidth() - 2 * BORDER_SIZE)/ numberOfFaces;
        int height = (getHeight() - 2 * BORDER_SIZE)/numberOfFaces;
        
        // We're just drawing a single face now.
        // ********* UPDATE THIS CODE TO: ***********
        // Draw the number of faces as indicated in the variable numberOfFaces
        
		for(int i = 1; i <= 7; i++)
		{
			top_x = 40 * i;
			top_y = 40 * i;
			drawFace(canvas,top_x,top_y, width, height);
		}
		
		
        // ********** END OF CODE TO UPDATE. *********
        
        
        // Increment the number of faces to draw.  This is the last thing we do to ensure
        // the next time this paint method is called, there is one additional face to
        // draw.  (Once numberOfFaces is 10, it loops back to 1.)
        numberOfFaces = (numberOfFaces) % 10 + 1;
    }
    
    /** 
     * Creates the actual window for the faces.
     */
    public Faces() {
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // This creates a times.  Whenever the timer goes off (every 200 ms)
        // we call this frames method to repaint itself.  (Which will
        // indirectly call paint above.
        Timer timer = new Timer(200,
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    repaint();
                }
            });
        // The timer will go off for the first time 1000ms after the timer is started.
        timer.setInitialDelay(1000);
        timer.start();
    }
    
    /**
     * Run the program by prompting the user for the number of faces
     * to draw, then creating the window for the faces.
     */    
    public static void main(String[] args) {
        // Create the window and set the number of faces to draw in the window.
        // It's initialized to 1, but each time the window is painted, we should
        // increment this by 1.
        Faces faceWindow = new Faces();
        faceWindow.numberOfFaces = 1;
        
        // Make the window visible.
        faceWindow.setVisible(true);
    }
}