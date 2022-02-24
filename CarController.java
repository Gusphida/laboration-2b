import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:
    CarModel cm;
    CarView cv;
    int gbAmount = 0;

    public CarController(CarModel cm, CarView cv) {
        this.cm = cm;
        this.cv = cv;
        initComponents();
    }

    public void initComponents(){
        cv.gasSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                gbAmount = (int) ((JSpinner)e.getSource()).getValue();
            }
        });

        // This actionListener is for the gas button only
        cv.gasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cm.gas(gbAmount);
            }
        });
        cv.brakeButton.addActionListener(brake -> cm.brake(gbAmount));
        cv.turboOnButton.addActionListener(turboOn -> cm.setTurboOn());
        cv.turboOffButton.addActionListener(turboOff -> cm.setTurboOff());
        cv.startButton.addActionListener(startEngine -> cm.startEngine());
        cv.stopButton.addActionListener(stopEngine -> cm.stopEngine());
        cv.lowerBedButton.addActionListener(lowerAngle -> cm.lowerAngle());
        cv.liftBedButton.addActionListener(raiseAngle -> cm.raiseAngle());
        cv.addCarButton.addActionListener(addCar -> cm.addCar());
        cv.removeCarButton.addActionListener(removeCar -> cm.removeCar());
    }
}
