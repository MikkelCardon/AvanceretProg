package Lektion08Factory.factoryMethod;

import Lektion08Factory.simpleFactory.Car;
import Lektion08Factory.simpleFactory.CarType;
import Lektion08Factory.simpleFactory.FuelType;

public class TeslaCreator implements Creator{
    @Override
    public Car createCar(CarType carType) {
        return switch (carType){
            case CarType.CONVERTIBLE -> throw new UnsupportedOperationException("No Tesla Convertible available");
            case CarType.PICKUP -> new Car(2, 5, carType, FuelType.ELECTRICITY, "ModelX");
            case CarType.SEDAN -> new Car(2, 2, carType, FuelType.ELECTRICITY, "ModelS");
            default -> null;
        };
    }
}
