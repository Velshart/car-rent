package me.velsh.abstraction;

public abstract class Vehicle {
    private String brand;
    private String model;
    private int year;
    private int price;
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

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setRented(boolean rented) {
        this.rented = rented;
    }

    public static void setId(int id) {
        Vehicle.id = id;
    }

    public String toCsv() {
        return brand+";"+model+";"+year+";"+price+";"+rented+";";
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
