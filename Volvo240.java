package cars;

import java.awt.*;

/**
 * The cars.Volvo240 class introduces a car with specific values
 **/

public class Volvo240 extends ACar {
    private final static double trimFactor = 1.25;

    /**
     * Default values for a cars.Volvo240 car
     */
    public Volvo240(){
        nrDoors = 4;
        color = Color.black;
        enginePower = 100;
        modelName = "Volvo240";
        transportable = true;
    }

    public Volvo240(int x){
        nrDoors = 4;
        color = Color.black;
        enginePower = 100;
        modelName = "Volvo240";
        transportable = true;
        this.position.x = x;
    }

    /**
     * Calculates the car's speed factor
     * @return the car's speed factor
     */
    public double speedFactor(){
        //Calculates the speedFactor
        return enginePower * 0.01 * trimFactor;
    }
}