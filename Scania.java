package cars;

import java.awt.*;

/**
 * The cars.Scania class introduces a truck with specific values
 */

public class Scania extends LiftCar {

    /**
     * Default values for the cars.Scania
     */
    public Scania() {
        nrDoors = 2;
        color = Color.red;
        enginePower = 125;
        modelName = "Scania";
        transportable = false;
    }
    public Scania(int x) {
        nrDoors = 2;
        color = Color.red;
        enginePower = 125;
        modelName = "Scania";
        transportable = false;
        this.position.x = x;
    }

    /**
     * Sets the currentSpeed to 0.1 if platformAngle is 0
     */
    @Override
    public void startEngine() {
        if (platformAngle == 0) {
            super.startEngine();
        }
    }

    /**
     * Increases the cars current speed based on an interval of 0 to 1 if the angle is 0
     */
    @Override
    public void gas(double amount){
        //Calls on incrementSpeed within an interval of 0 to 1
        if (platformAngle == 0) {
            super.gas(amount);
        }
    }
}

