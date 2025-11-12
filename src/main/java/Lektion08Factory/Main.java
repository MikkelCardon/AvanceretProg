package Lektion08Factory;

import Lektion08Factory.factoryMethod.Creator;
import Lektion08Factory.factoryMethod.Factory;
import Lektion08Factory.factoryMethod.FordCreator;
import Lektion08Factory.simpleFactory.Car;
import Lektion08Factory.simpleFactory.CarType;

public class Main {
    public static void main(String[] args) {
        Creator creator = new FordCreator();
        Factory factory = new Factory(creator);

        Car car = factory.buildCar(CarType.PICKUP);

        System.out.println(car);
    }
}
