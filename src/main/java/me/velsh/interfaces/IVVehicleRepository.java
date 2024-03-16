package me.velsh.interfaces;

import me.velsh.abstraction.Vehicle;

import java.util.List;

public interface IVVehicleRepository {
    void rentVehicle(int id);
    void returnVehicle(int id);
    List<Vehicle> getVehicles();

    void save(List<Vehicle> vehiclesToSave);
}
