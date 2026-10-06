import java.util.Scanner;

abstract class Vehicle {
    String vehicleNumber;
    String brand;

    Vehicle(String vehicleNumber, String brand) {
        this.vehicleNumber = vehicleNumber;
        this.brand = brand;
    }

    abstract void startEngine();

    final void showVehicleIdentity() {
        System.out.println("Vehicle Number: " + vehicleNumber);
        System.out.println("Brand: " + brand);
    }
}

class Car extends Vehicle {
    Car(String vehicleNumber, String brand) {
        super(vehicleNumber, brand);
    }

    void startEngine() {
        System.out.println("Car engine is starting.");
    }
}

class Bike extends Vehicle {
    Bike(String vehicleNumber, String brand) {
        super(vehicleNumber, brand);
    }

    void startEngine() {
        System.out.println("Bike engine is starting.");
    }
}

public class pro3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n1. Create Car");
            System.out.println("2. Create Bike");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    Car car = new Car("KA01AB1234", "Toyota");
                    car.startEngine();
                    car.showVehicleIdentity();
                    break;

                case 2:
                    Bike bike = new Bike("KA05XY5678", "Honda");
                    bike.startEngine();
                    bike.showVehicleIdentity();
                    break;

                case 3:
                    System.out.println("Program ended.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 3);

        sc.close();
    }
}