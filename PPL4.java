import java.util.Scanner;

class Vehicle {
    String type;
    String name;
    double ratePerDay;

    Vehicle(String type, String name, double ratePerDay) {
        this.type = type;
        this.name = name;
        this.ratePerDay = ratePerDay;
    }

    double calculateRent(int days) {
        return ratePerDay * days;
    }

    void display(int days, double total) {
        System.out.println("\n--- Vehicle Details ---");
        System.out.println("Vehicle Type : " + type);
        System.out.println("Vehicle Name : " + name);
        System.out.println("Rate Per Day : ₹" + ratePerDay);
        System.out.println("Rental Days  : " + days);
        System.out.println("Total Rent   : ₹" + total);
    }
}

class Car extends Vehicle {
    Car(String name) {
        super("Car", name, 2000);   
    }
}

class Bike extends Vehicle {
    Bike(String name) {
        super("Bike", name, 800);   
    }
}

class Truck extends Vehicle {
    Truck(String name) {
        super("Truck", name, 5000); 
    }
}

public class VehicleRentalSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Vehicle Rental System");
        System.out.println("1. Car");
        System.out.println("2. Bike");
        System.out.println("3. Truck");
        System.out.print("Choose vehicle type: ");
        int choice = sc.nextInt();
        sc.nextLine();

        Vehicle v = null;

        switch (choice) {

            case 1:
                System.out.print("Enter car name: ");
                String carName = sc.nextLine();
                v = new Car(carName);
                break;

            case 2:
                System.out.print("Enter bike name: ");
                String bikeName = sc.nextLine();
                v = new Bike(bikeName);
                break;

            case 3:
                System.out.print("Enter truck name: ");
                String truckName = sc.nextLine();
                v = new Truck(truckName);
                break;

            default:
                System.out.println("Invalid choice");
                sc.close();
                return;
        }

        System.out.print("Enter rental days: ");
        int days = sc.nextInt();

        double total = v.calculateRent(days);
        v.display(days, total);

        
    }
}
