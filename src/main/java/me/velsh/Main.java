package me.velsh;

import me.velsh.abstraction.Vehicle;
import me.velsh.manager.RentingManager;
import me.velsh.objects.Car;
import me.velsh.objects.Motorcycle;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        RentingManager rentingManager = new RentingManager();
        //rentingManager.rentVehicle(0);
        //rentingManager.returnVehicle(0);

        //List<Vehicle> vehicleList = rentingManager.getVehicles();

        //vehicleList.forEach(System.out::println);
        Scanner sc = new Scanner(System.in);

        System.out.println("--------");
        System.out.println("0- wyswietl oferte");
        System.out.println("1- wypozycz pojazd");
        System.out.println("2- zwroc pojazd");
        System.out.println("--------");
        while(true) {
            String operation = sc.nextLine();
            switch (operation) {
                case "0":
                    List<Vehicle> availableVehicles = rentingManager.getVehicles();
                    availableVehicles.forEach(vehicle -> {
                        if(vehicle instanceof Car carToRent) {

                            if(!carToRent.isRented()) {
                                System.out.println("{" +carToRent.getCarId() + "}" + " " + carToRent.getBrand() + " " + carToRent.getModel() + " " + carToRent.getYear() + " Cena:" + carToRent.getPrice());
                            }
                        }else if (vehicle instanceof Motorcycle motorcycleToRent) {
                            if(!motorcycleToRent.isRented()) {
                                System.out.println("{" +motorcycleToRent.getMotorcycleId() + "}" + " " + motorcycleToRent.getBrand() + " " + motorcycleToRent.getModel() + " " + motorcycleToRent.getYear() + " Cena:" + motorcycleToRent.getPrice() + " Kategoria:" + motorcycleToRent.getKategoria());

                            }
                        }
                    });
                    break;
                case "1":
                    System.out.println("Podaj id pojazdu, ktory chcesz wypozyczyc: ");
                    int idToRent = Integer.parseInt(sc.nextLine());
                    List<Vehicle> availableVehiclesToRent = rentingManager.getVehicles();
                    rentingManager.rentVehicle(idToRent);

                    if(!availableVehiclesToRent.get(idToRent).isRented()) {
                        System.out.println("Pomyslnie wypozyczono pojazd " + idToRent + ".");
                    }else {
                        System.out.println("Ten pojazd zostal juz wypozyczony.");
                    }
                    break;
                case "2":
                    List<Vehicle> allAvailableVehicles = rentingManager.getVehicles();
                    System.out.println("Podaj id pojazdu do zwrotu: ");
                    int idToReturn = Integer.parseInt(sc.nextLine());
                    if(allAvailableVehicles.get(idToReturn).isRented()) {
                        rentingManager.returnVehicle(idToReturn);
                        System.out.println("Pomyslnie zwrocono pojazd " + idToReturn + ".");
                    }else {
                        System.out.println("Ten pojazd nie zostal wypozyczony.");
                    }
                    break;
            }
        }
    }
}