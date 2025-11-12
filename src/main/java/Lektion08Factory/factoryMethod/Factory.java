package Lektion08Factory.factoryMethod;

import Lektion08Factory.simpleFactory.Car;
import Lektion08Factory.simpleFactory.CarType;
import Lektion08Factory.simpleFactory.FuelType;

public class Factory {
    private CarType carType;
    private FuelType fuelType;
    private Creator creator;

    public Factory(Creator creator) {
        this.creator = creator;
    }

    public Car buildCar(CarType carType){
        return creator.createCar(carType);
    }
}
