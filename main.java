public class main {
    public static void main(String[] args) {
        // Instance of this class
        CarModel cm = new CarModel();
        CarView cv = new CarView("CarSim 1.0");
        CarController cc = new CarController(cm, cv);

        //cv.setResizable(false);
        cm.addObserver(cv);

        // Start the timer
        cm.timer.start();
    }
}
