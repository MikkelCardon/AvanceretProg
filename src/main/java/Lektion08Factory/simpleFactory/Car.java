package Lektion08Factory.simpleFactory;

public class Car {
    private int seats;
    private int doors;
    private CarType carType;
    private FuelType fuelType;

    private String model;


    public Car(int seats, int doors, CarType carType, FuelType fuelType, String model) {
        this.seats = seats;
        this.doors = doors;
        this.carType = carType;
        this.fuelType = fuelType;
        this.model = model;
    }


}
