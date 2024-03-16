package me.velsh.manager;

import me.velsh.objects.Car;
import me.velsh.interfaces.IVVehicleRepository;
import me.velsh.objects.Motorcycle;
import me.velsh.abstraction.Vehicle;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RentingManager implements IVVehicleRepository {
    private final List<Vehicle> vehicles;

    public RentingManager() {
        this.vehicles = getVehicles();
    }

    @Override
    public void rentVehicle(int id) {
        List<Vehicle> vehiclesFromFile = getVehicles();
        Vehicle toRent = vehiclesFromFile.get(id);

        if(!toRent.isRented()) {
            toRent.setRented(true);
            vehiclesFromFile.set(id, toRent);

            try(FileWriter fw = new FileWriter("cars.txt", false)) {
                for (Vehicle vehicle : vehiclesFromFile) {
                    fw.write(vehicle.toCsv());
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }

    @Override
    public void returnVehicle(int id) {
        List<Vehicle> vehiclesFromFile = getVehicles();
        Vehicle toReturn = vehiclesFromFile.get(id);

        if(toReturn.isRented()) {
            toReturn.setRented(false);
            vehiclesFromFile.set(id, toReturn);

            try(FileWriter fw = new FileWriter("cars.txt", false)) {
                for (Vehicle vehicle : vehiclesFromFile) {
                    fw.write(vehicle.toCsv());
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }

    @Override
    public List<Vehicle> getVehicles() {
        List<Vehicle> vehiclesFromCsv = new ArrayList<>(10);



        File file = new File("cars.txt");

        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                if(vehiclesFromCsv.size() == 10) break;
                String car = scanner.nextLine();

                String[] attributes = car.split(";");
                if (attributes[0].equals("c")) {
                    Car readCar = new Car(attributes[1], attributes[2], Integer.parseInt(attributes[3]), Integer.parseInt(attributes[4]), Boolean.parseBoolean(attributes[5]));
                    readCar.setCarId(Integer.parseInt(attributes[6]));

                    vehiclesFromCsv.add(readCar);

                } else if (attributes[0].equals("m")) {
                    Motorcycle readMotorcycle = new Motorcycle(attributes[1], attributes[2], Integer.parseInt(attributes[3]), Integer.parseInt(attributes[4]), Boolean.parseBoolean(attributes[5]), attributes[6]);
                    readMotorcycle.setMotorcycleId(Integer.parseInt(attributes[7]));

                    vehiclesFromCsv.add(readMotorcycle);
                }
            }
            scanner.close();
        }catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        }
        return vehiclesFromCsv;
    }

    public void save(Vehicle vehicle) {
        String csvLine = vehicle.toCsv();

        try(FileWriter writer = new FileWriter("cars.txt")) {
            writer.write(csvLine+"\n");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
