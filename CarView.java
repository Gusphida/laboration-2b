import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import cars.ACar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * This class represents the full view of the MVC pattern of your car simulator.
 * It initializes with being center on the screen and attaching it's controller in it's state.
 * It communicates with the Controller by calling methods of it when an action fires of in
 * each of it's components.
 **/

public class CarView extends JFrame implements IObserver {
    protected static final int X = 800;
    protected static final int Y = 800;


    DrawPanel drawPanel = new DrawPanel(X, Y-240);

    // Constructor
    public CarView(String framename, JPanel gasPanel, JPanel controlPanel, JButton startButton, JButton stopButton){
        initComponents(framename);
        this.add(gasPanel);
        this.add(controlPanel);
        this.add(startButton);
        this.add(stopButton);
    }

    // Sets everything in place and fits everything
    private void initComponents(String title) {
        this.setTitle(title);
        this.setPreferredSize(new Dimension(X,Y));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        this.add(drawPanel);

        // Make the frame pack all it's components by respecting the sizes if possible.
        this.pack();

        // Get the computer screen resolution
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        // Center the frame
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        // Make the frame visible
        this.setVisible(true);
        // Make sure the frame exits when "x" is pressed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void update(ArrayList<ACar> cars){
        for (ACar car : cars) {
            drawPanel.moveit((int)Math.round(car.position.x), (int)Math.round(car.position.y), car.modelName);
        }
        drawPanel.repaint();
    }
}