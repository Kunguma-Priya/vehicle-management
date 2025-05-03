import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Vehicle vehicle = null;

        while (true) {
            System.out.println("\n1. Add Vehicle");
            System.out.println("2. Change Speed");
            System.out.println("3. Change Gear");
            System.out.println("4. View Vehicles");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Select Vehicle Type: ");
                    System.out.println("1. Car\n2. Truck\n3. Motorcycle\n4. Bus");
                    int typeChoice = scanner.nextInt();
                    scanner.nextLine();  // Consume newline

                    System.out.print("Enter Brand: ");
                    String brand = scanner.nextLine();
                    System.out.print("Enter Model: ");
                    String model = scanner.nextLine();
                    System.out.print("Enter Year: ");
                    int year = scanner.nextInt();

                    switch (typeChoice) {
                        case 1: vehicle = new Car(brand, model, year); break;
                        case 2: vehicle = new Truck(brand, model, year); break;
                        case 3: vehicle = new Motorcycle(brand, model, year); break;
                        case 4: vehicle = new Bus(brand, model, year); break;
                        default: System.out.println("Invalid choice!"); continue;
                    }

                    vehicle.start();
                    VehicleDAO.saveVehicle(vehicle.getClass().getSimpleName(), brand, model, year, vehicle.speed, vehicle.gear);
                    break;


                case 2:
                    if (vehicle == null) {
                        System.out.println("No vehicle found! Add a vehicle first.");
                        continue;
                    }
                    System.out.print("Enter new speed: ");
                    int newSpeed = scanner.nextInt();
                    vehicle.changeSpeed(newSpeed);
                    break;

                case 3:
                    if (vehicle == null) {
                        System.out.println("No vehicle found! Add a vehicle first.");
                        continue;
                    }
                    System.out.print("Enter new gear: ");
                    int newGear = scanner.nextInt();
                    vehicle.changeGear(newGear);
                    break;

                case 4:
                    VehicleDAO.displayVehicles();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
