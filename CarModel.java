import cars.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CarModel implements IObservable {
    ArrayList<IObserver> observers = new ArrayList<>();
    CarFactory cars = new CarFactory();
    ArrayList<ACar> allCars = cars.getAllCars();
    ArrayList<TurboCar> turboCars = cars.getAllTurbo();
    ArrayList<LiftCar> liftCars = cars.getAllLift();
    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    private int timeLastChecked = 0;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    public Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern

    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (ACar car : allCars) {
                if (car.position.getY() >= 600 - 100 || car.position.getY() < 0) {
                    car.turnLeft();
                    car.turnLeft();
                }
                car.move();
                if (timeLastChecked >= 2){
                    notifyObservers();
                    timeLastChecked = 0;
                }
                timeLastChecked++;
            }
        }
    }

    public void addObserver(IObserver observer){
        this.observers.add(observer);
    }
    public void removeObserver(IObserver observer){
        this.observers.remove(observer);
    }
    public void notifyObservers(){
        for (IObserver obs : observers) {
            obs.update(allCars);
        }
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (ACar car : allCars) {
            car.gas(gas);
        }
    }

    // Calls the brake method for each car once
    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (ACar car : allCars) {
            car.brake(brake);
        }
    }

    void startEngine(){
        for (ACar car : allCars){
            car.startEngine();
        }
    }

    void stopEngine(){
        for (ACar car : allCars){
            car.stopEngine();
        }
    }

    void setTurboOn(){
        for (TurboCar car : turboCars) {
            car.setTurboOn();
        }
    }

    void setTurboOff(){
        for (TurboCar car : turboCars) {
            car.setTurboOff();
        }
    }

    void raiseAngle(){
        for (LiftCar car : liftCars) {
            car.raiseAngle(10);
        }
    }

    void lowerAngle(){
        for (LiftCar car : liftCars) {
            car.lowerAngle(10);
        }
    }

    void addCar() {
        cars.createCar();
    }

    void removeCar() {
        cars.removeCar();
    }
}
