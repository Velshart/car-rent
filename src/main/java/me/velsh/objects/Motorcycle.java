package me.velsh.objects;

import me.velsh.abstraction.Vehicle;

public class Motorcycle extends Vehicle {
    private String kategoria;
    private int id;


    public Motorcycle(String brand, String model, int year, int price, boolean rented, String kategoria) {
        super(brand, model, year, price, rented);
        this.kategoria = kategoria;
        this.id = Motorcycle.getId();
    }

    public String getKategoria() {
        return kategoria;
    }

    public int getMotorcycleId() {
        return id;
    }

    public void setMotorcycleId(int id) {
        this.id = id;
    }

    @Override
    public String toCsv() {
        return "m;" + super.toCsv() + kategoria + ";" + id + ";" + "\n";
    }
}
