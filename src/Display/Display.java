package Display;

import javax.swing.*;
import java.awt.*;

public class Display {
    private JFrame frame;
    private Canvas canvas;

    // Properties
    private String title;
    private int width;
    private int height;
    private Dimension dimension;

    // Constructor
    public Display(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;

        // Initialize " dimension "
        dimension = new Dimension(width, height);

        createDisplay();
    }

    private void createDisplay() {
        // Configure JFrame
        frame = new JFrame(title);
        frame.setSize(dimension);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        // Configure Canvas object
        canvas = new Canvas();
        canvas.setPreferredSize(dimension);
        canvas.setMaximumSize(dimension);
        canvas.setMinimumSize(dimension);
        canvas.setFocusable(false);

        // Add Canvas
        frame.add(canvas);
        frame.pack();
    }

    // Access canvas
    public Canvas getCanvas() {
        return this.canvas;
    }

    // Access frame
    public JFrame getFrame(){
        return this.frame;
    }
}
