package cars;

import java.util.ArrayList;
import java.util.Random;

public class CarFactory {
    private ArrayList<ACar> allCars = new ArrayList<>();
    private ArrayList<LiftCar> liftCars = new ArrayList<>();
    private ArrayList<TurboCar> turboCars = new ArrayList<>();
    Random rand = new Random();

    public CarFactory() {
        Volvo240 volvo = new Volvo240();
        Saab95 saab = new Saab95(100);
        Scania scania = new Scania(200);
        allCars.add(volvo);
        allCars.add(saab);
        allCars.add(scania);
        turboCars.add(saab);
        liftCars.add(scania);
    }

    public void createCar(){
        int num = rand.nextInt(1, 4);
        if (allCars.size() < 8) {
            int x = allCars.size() * 100;
            switch (num) {
                case 1:
                    allCars.add(new Volvo240(x));
                    break;
                case 2:
                    Saab95 saab = new Saab95(x);
                    allCars.add(saab);
                    turboCars.add(saab);
                    break;
                case 3:
                    Scania scania = new Scania(x);
                    allCars.add(scania);
                    liftCars.add(scania);
                    break;
            }
        }
    }

    public void removeCar() {
        if (allCars.size() > 0) {
            switch (allCars.get(allCars.size() - 1).modelName) {
                case "Saab95" -> {
                    allCars.remove(allCars.size() - 1);
                    turboCars.remove(turboCars.size() - 1);
                }
                case "Scania" -> {
                    allCars.remove(allCars.size() - 1);
                    liftCars.remove(liftCars.size() - 1);
                }
                default -> allCars.remove(allCars.size() - 1);
            }
        }
    }

    public ArrayList<ACar> getAllCars(){
        return allCars;
    }

    public ArrayList<TurboCar> getAllTurbo(){
        return turboCars;
    }

    public ArrayList<LiftCar> getAllLift(){
        return liftCars;
    }

}
