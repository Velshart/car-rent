package me.velsh.abstraction;

public abstract class Vehicle {
    private final String brand;
    private final String model;
    private final int year;
    private final int price;
    private boolean rented;

    private static int id = 0;

    public Vehicle(String brand, String model, int year, int price, boolean rented) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.price = price;
        this.rented = rented;
        id++;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public int getPrice() {
        return price;
    }

    public boolean isRented() {
        return rented;
    }

    public static int getId() {
        return id;
    }

    public void setRented(boolean rented) {
        this.rented = rented;
    }

    public String toCsv() {
        return brand + ";" + model + ";" + year + ";" + price + ";" + rented + ";";
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", price=" + price +
                ", rented=" + rented +
                '}';
    }
}
