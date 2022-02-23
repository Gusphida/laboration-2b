public class main {
    public static void main(String[] args) {
        // Instance of this class
        CarModel cm = new CarModel();
        CarController cc = new CarController(cm);
        CarView cv = new CarView("CarSim 1.0", cc.gasPanel, cc.controlPanel, cc.startButton, cc.stopButton);

        //cv.setResizable(false);
        cm.addObserver(cv);

        // Start the timer
        cm.timer.start();
    }
}
