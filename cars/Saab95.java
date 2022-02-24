package cars;

import java.awt.*;

/**
 * The cars.Saab95 class introduces a car with specific values
 **/

public class Saab95 extends TurboCar {

    /**
     * Default values for a cars.Saab95 car
     */
    public Saab95() {
        nrDoors = 2;
        color = Color.red;
        enginePower = 125;
        modelName = "Saab95";
        transportable = true;
    }

    public Saab95(int x) {
        nrDoors = 2;
        color = Color.red;
        enginePower = 125;
        modelName = "Saab95";
        transportable = true;
        this.position.x = x;
    }


    /**
     * Calculates the cars speed factor
     * @return the cars speed factor
     */
    public double speedFactor() {
        //Calculates the speedFactor
        double turbo = 1;
        if (turboOn) turbo = 1.3;
        return enginePower * 0.01 * turbo;
    }
}
