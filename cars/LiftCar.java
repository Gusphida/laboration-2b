package cars;

public abstract class LiftCar extends ACar {
    public double platformAngle = 0;

    /**
     * Gives the angle of the platform
     * @return the value of platformAngle
     */
    public double getPlatformAngle() {
        return platformAngle;
    }

    /**
     * Increases the platformAngle by a set amount
     */
    public void raiseAngle(double increase){
        if (currentSpeed == 0 && platformAngle <= (70 - increase) && increase > 0) {
            platformAngle += increase;
        }
    }

    /**
     * Decreases the platformAngle by a set amount
     */
    public void lowerAngle(double decrease){
        if (currentSpeed == 0 && platformAngle >= decrease && decrease > 0) {
            platformAngle -= decrease;
        }
    }
}
