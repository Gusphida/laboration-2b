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

    JPanel controlPanel = new JPanel();

    JPanel gasPanel = new JPanel();
    JSpinner gasSpinner = new JSpinner();
    JLabel gasLabel = new JLabel("Amount");

    JButton gasButton = new JButton("Gas");
    JButton brakeButton = new JButton("Brake");
    JButton turboOnButton = new JButton("Turbo on");
    JButton turboOffButton = new JButton("Turbo off");
    JButton liftBedButton = new JButton("Lift Bed");
    JButton lowerBedButton = new JButton("Lower Lift Bed");

    JButton startButton = new JButton("Start all cars");
    JButton stopButton = new JButton("Stop all cars");
    JButton addCarButton = new JButton("Add car");
    JButton removeCarButton = new JButton("Remove car");


    DrawPanel drawPanel = new DrawPanel(X, Y-240);

    // Constructor
    public CarView(String framename){
        initComponents(framename);
        this.add(gasPanel);
        this.add(controlPanel);
        this.add(startButton);
        this.add(stopButton);
    }

    // Sets everything in place and fits everything
    private void initComponents(String title) {
        SpinnerModel spinnerModel =
                new SpinnerNumberModel(0, //initial value
                        0, //min
                        100, //max
                        1);//step
        gasSpinner = new JSpinner(spinnerModel);
        gasPanel.setLayout(new BorderLayout());
        gasPanel.add(gasLabel, BorderLayout.PAGE_START);
        gasPanel.add(gasSpinner, BorderLayout.PAGE_END);

        controlPanel.setLayout(new GridLayout(2,4));

        controlPanel.add(gasButton, 0);
        controlPanel.add(turboOnButton, 1);
        controlPanel.add(liftBedButton, 2);
        controlPanel.add(addCarButton, 3);
        controlPanel.add(brakeButton, 4);
        controlPanel.add(turboOffButton, 5);
        controlPanel.add(lowerBedButton, 6);
        controlPanel.add(removeCarButton, 7);
        controlPanel.setPreferredSize(new Dimension((CarView.X/2)+4, 200));
        controlPanel.setBackground(Color.CYAN);

        startButton.setBackground(Color.blue);
        startButton.setForeground(Color.green);
        startButton.setPreferredSize(new Dimension(CarView.X/5-15,200));

        stopButton.setBackground(Color.red);
        stopButton.setForeground(Color.black);
        stopButton.setPreferredSize(new Dimension(CarView.X/5-15,200));

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