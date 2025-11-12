package Lektion08Factory.factoryMethod;

import Lektion08Factory.simpleFactory.Car;
import Lektion08Factory.simpleFactory.CarType;
import Lektion08Factory.simpleFactory.FuelType;

public interface Creator {

    public Car createCar(CarType carType);
}
