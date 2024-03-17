package me.velsh.objects;

import me.velsh.abstraction.Vehicle;

public class Car extends Vehicle {
    private int id;
    public Car(String brand, String model, int year, int price, boolean rented) {
        super(brand, model, year, price, rented);
        this.id = Car.getId();
    }

    public int getCarId() {
        return id;
    }

    public void setCarId(int id) {
        this.id = id;
    }

    @Override
    public String toCsv() {
        return "c;" + super.toCsv() + id + ";" + "\n";
    }
}
