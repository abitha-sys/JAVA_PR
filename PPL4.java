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
    Car(String name, double rate) {
        super("Car", name, rate);
    }

    @Override
    double calculateRent(int days) {
        return ratePerDay * days;
    }
}

class Bike extends Vehicle {
    Bike(String name, double rate) {
        super("Bike", name, rate);
    }

    @Override
    double calculateRent(int days) {
        return ratePerDay * days;
    }
}

class Truck extends Vehicle {
    Truck(String name, double rate) {
        super("Truck", name, rate);
    }

    @Override
    double calculateRent(int days) {
        return ratePerDay * days;
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

        switch (choice) {

            case 1: {
                System.out.println("\nEnter Car Details");
                System.out.print("Enter car name: ");
                String name = sc.nextLine();
                System.out.print("Enter rate per day: ");
                double rate = sc.nextDouble();
                System.out.print("Enter rental days: ");
                int days = sc.nextInt();

                Vehicle v = new Car(name, rate);
                double total = v.calculateRent(days);
                v.display(days, total);
                break;
            }

            case 2: {
                System.out.println("\nEnter Bike Details");
                System.out.print("Enter bike name: ");
                String name = sc.nextLine();
                System.out.print("Enter rate per day: ");
                double rate = sc.nextDouble();
                System.out.print("Enter rental days: ");
                int days = sc.nextInt();

                Vehicle v = new Bike(name, rate);
                double total = v.calculateRent(days);
                v.display(days, total);
                break;
            }

            case 3: {
                System.out.println("\nEnter Truck Details");
                System.out.print("Enter truck name: ");
                String name = sc.nextLine();
                System.out.print("Enter rate per day: ");
                double rate = sc.nextDouble();
                System.out.print("Enter rental days: ");
                int days = sc.nextInt();

                Vehicle v = new Truck(name, rate);
                double total = v.calculateRent(days);
                v.display(days, total);
                break;
            }

            default:
                System.out.println("Invalid choice");
        }

        sc.close();
    }
}
