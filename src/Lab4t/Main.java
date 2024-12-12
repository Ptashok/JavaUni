package Lab4t;
import java.util.Scanner;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Road road = new Road();

        while (true) {
            System.out.println("Choose an action: 1 - Add Vehicle, 2 - Add Passenger, 3 - Exit");
            int action = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (action == 1) {
                System.out.println("Enter vehicle type (bus, taxi, firetruck, policecar):");
                String vehicleType = scanner.nextLine();
                System.out.println("Enter capacity:");
                int capacity = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (vehicleType.toLowerCase()) {
                    case "bus":
                        road.addCarToRoad(new Bus(capacity));
                        break;
                    case "taxi":
                        road.addCarToRoad(new Taxi(capacity));
                        break;
                    case "firetruck":
                        road.addCarToRoad(new FireTruck(capacity));
                        break;
                    case "policecar":
                        road.addCarToRoad(new PoliceCar(capacity));
                        break;
                    default:
                        System.out.println("Invalid vehicle type.");
                }
            } else if (action == 2) {
                if (road.vehiclesOnRoad.isEmpty()) {
                    System.out.println("No vehicles added. Please add a vehicle first.");
                    continue;
                }

                System.out.println("Enter vehicle type (bus, taxi, firetruck, policecar):");
                String vehicleType = scanner.nextLine();
                System.out.println("Enter passenger type (passenger, firefighter, policeman):");
                String passengerType = scanner.nextLine();
                System.out.println("Enter passenger name:");
                String passengerName = scanner.nextLine();

                try {
                    Vehicle<? extends Passenger> vehicle = road.vehiclesOnRoad.stream()
                            .filter(v -> v.getClass().getSimpleName().equalsIgnoreCase(vehicleType))
                            .findFirst().orElse(null);

                    if (vehicle == null) {
                        System.out.println("Vehicle not found.");
                        continue;
                    }

                    switch (passengerType.toLowerCase()) {
                        case "passenger":
                            if (vehicle instanceof Bus || vehicle instanceof Taxi) {
                                vehicle.boardPassenger(new Passenger(passengerName));
                            } else {
                                System.out.println("This vehicle cannot carry passengers of this type.");
                            }
                            break;
                        case "firefighter":
                            if (vehicle instanceof FireTruck) {
                                ((FireTruck) vehicle).boardPassenger(new Firefighter(passengerName));
                            } else {
                                System.out.println("This vehicle can only carry firefighters.");
                            }
                            break;
                        case "policeman":
                            if (vehicle instanceof PoliceCar) {
                                ((PoliceCar) vehicle).boardPassenger(new Policeman(passengerName));
                            } else {
                                System.out.println("This vehicle can only carry policemen.");
                            }
                            break;
                        default:
                            System.out.println("Invalid passenger type.");
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } else if (action == 3) {
                break;
            } else {
                System.out.println("Invalid action.");
            }
        }

        scanner.close();
    }
}


