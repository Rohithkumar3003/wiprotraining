package com.oop;


abstract class Vehicle {
    private String vehicleId;
    private String vehicleType;
    private double rentalPricePerDay;
    public Vehicle(String vehicleId, String vehicleType, double rentalPricePerDay) {
        this.vehicleId = vehicleId;
        this.vehicleType = vehicleType;
        this.rentalPricePerDay = rentalPricePerDay;
    }
    public abstract void displayDetails();
    public double calculateRentalCost(int rentalDays) {
        return rentalDays * rentalPricePerDay;
    }
    public String getVehicleId() {
        return vehicleId;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public double getRentalPricePerDay() {
        return rentalPricePerDay;
    }
}
class Car extends Vehicle {
    private String carModel;

    public Car(String vehicleId, String carModel, double rentalPricePerDay) {
        super(vehicleId, "Car", rentalPricePerDay);
        this.carModel = carModel;
    }

    @Override
    public void displayDetails() {
        System.out.println("Vehicle ID: " + getVehicleId());
        System.out.println("Vehicle Type: " + getVehicleType());
        System.out.println("Car Model: " + carModel);
        System.out.println("Rental Price per Day: " + getRentalPricePerDay());
    }
}
class Bike extends Vehicle {
    private String bikeModel;

    public Bike(String vehicleId, String bikeModel, double rentalPricePerDay) {
        super(vehicleId, "Bike", rentalPricePerDay);
        this.bikeModel = bikeModel;
    }

    @Override
    public void displayDetails() {
        System.out.println("Vehicle ID: " + getVehicleId());
        System.out.println("Vehicle Type: " + getVehicleType());
        System.out.println("Bike Model: " + bikeModel);
        System.out.println("Rental Price per Day: " + getRentalPricePerDay());
    }
}
class Customers {
    private String customerId;
    private String name;
    public Customers(String customerId, String name) {
        this.customerId = customerId;
        this.name = name;
    }
    public String getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }
}
class Rental {
    private Customers customer;
    private Vehicle vehicle;
    private int rentalDays;
    private boolean isRented;
    public Rental(Customers customer, Vehicle vehicle, int rentalDays) {
        this.customer = customer;
        this.vehicle = vehicle;
        this.rentalDays = rentalDays;
        this.isRented = false;
    }
    public void rentVehicle() {
        if (isRented) {
            System.out.println("Vehicle is already rented.");
        } else {
            isRented = true;
            System.out.println("Vehicle rented successfully by " + customer.getName());
            vehicle.displayDetails();
            System.out.println("Total Rental Cost for " + rentalDays + " days: " + vehicle.calculateRentalCost(rentalDays));
        }
    }
    public void returnVehicle() {
        if (!isRented) {
            System.out.println("No vehicle is rented.");
        } else {
            isRented = false;
            System.out.println("Vehicle returned successfully.");
        }
    }
    public Vehicle getVehicle() {
        return vehicle;
    }

    public boolean isRented() {
        return isRented;
    }
}
public class RentalVehicle {

    public static void main(String[] args) {
        Vehicle car1 = new Car("C123", "Toyota Corolla", 50.0);
        Vehicle bike1 = new Bike("B123", "Yamaha FZ", 20.0);
        Customers customer1 = new Customers("C001", "John Doe");
        Customers customer2 = new Customers("C002", "Jane Smith");
        Rental rental1 = new Rental(customer1, car1, 5); // 5 days rental
        Rental rental2 = new Rental(customer2, bike1, 3); // 3 days rental
        rental1.rentVehicle();
        rental2.rentVehicle();

        rental1.returnVehicle();
        rental2.returnVehicle();
    }
}
