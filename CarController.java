import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    ArrayList<ACar> cars = new ArrayList<>();

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        cc.cars.add(new Volvo240());
        cc.cars.add(new Scania(100));
        cc.cars.add(new Saab95(200));

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);
        cc.frame.setResizable(false);

        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (ACar car : cars) {
                if (car.position.getY() >= 600 - 100 || car.position.getY() < 0) {
                    car.turnLeft();
                    car.turnLeft();
                }
                car.move();
                int x = (int) Math.round(car.position.getX());
                int y = (int) Math.round(car.position.getY());
                frame.drawPanel.moveit(new Point(x, y), car.modelName);
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
        }
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (ACar car : cars) {
            car.gas(gas);
        }
    }

    // Calls the brake method for each car once
    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (ACar car : cars) {
            car.brake(brake);
        }
    }

    void startEngine(){
        for (ACar car : cars){
            car.startEngine();
        }
    }

    void stopEngine(){
        for (ACar car : cars){
            car.stopEngine();
        }
    }

    void setTurboOn(){
        for (ACar car : cars) {
            if (car instanceof Saab95) {
                ((Saab95) car).setTurboOn();
            }
        }
    }

    void setTurboOff(){
        for (ACar car : cars) {
            if (car instanceof Saab95) {
                ((Saab95) car).setTurboOff();
            }
        }
    }

    void raiseAngle(){
        for (ACar car : cars) {
            if (car instanceof Scania) {
                ((Scania) car).raiseAngle(10);
            }
        }
    }

    void lowerAngle(){
        for (ACar car : cars) {
            if (car instanceof Scania) {
                ((Scania) car).lowerAngle(10);
            }
        }
    }
}
