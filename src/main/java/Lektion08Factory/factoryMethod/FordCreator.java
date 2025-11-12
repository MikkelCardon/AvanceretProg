package Lektion08Factory.factoryMethod;

import Lektion08Factory.simpleFactory.Car;
import Lektion08Factory.simpleFactory.CarType;
import Lektion08Factory.simpleFactory.FuelType;

public class FordCreator implements Creator{
    @Override
    public Car createCar(CarType carType) {
        return switch (carType){
            case CarType.CONVERTIBLE -> new Car(5, 5, carType, FuelType.ELECTRICITY, "F450");
            case CarType.PICKUP -> new Car(2, 5, carType, FuelType.ELECTRICITY, "Focus");
            case CarType.SEDAN -> new Car(2, 2, carType, FuelType.ELECTRICITY, "Mustang");
            default -> null;
        };
    }
}
