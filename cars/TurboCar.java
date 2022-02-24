package cars;

public abstract class TurboCar extends ACar {
    protected boolean turboOn = false;
    /**
     * Sets the turbo on
     */
    public void setTurboOn() {
        //Sets turboOn to true
        turboOn = true;
    }

    /**
     * Turns the turbo off
     */
    public void setTurboOff() {
        //Sets turboOn to false
        turboOn = false;
    }
}
