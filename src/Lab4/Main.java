package Lab4;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Road road = new Road();

        while (true) {
            System.out.println("\n1. Add vehicle");
            System.out.println("2. Add passenger");
            System.out.println("3. Remove passenger");
            System.out.println("4. Show total passengers on the road");
            System.out.println("5. Exit");
            System.out.print("Your action: ");
            int action = scanner.nextInt();
            scanner.nextLine(); // consume the newline

            try {
                switch (action) {
                    case 1 -> {
                        System.out.println("\nChoose vehicle type:");
                        System.out.println("1. Bus");
                        System.out.println("2. Taxi");
                        System.out.println("3. Fire Truck");
                        System.out.println("4. Police Car");
                        System.out.print("Your choice: ");
                        int vehicleType = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Enter the maximum number of seats: ");
                        int maxSeats = scanner.nextInt();
                        scanner.nextLine();

                        switch (vehicleType) {
                            case 1 -> road.addCarToRoad(new Bus(maxSeats));
                            case 2 -> road.addCarToRoad(new Taxi(maxSeats));
                            case 3 -> road.addCarToRoad(new FireTruck(maxSeats));
                            case 4 -> road.addCarToRoad(new PoliceCar(maxSeats));
                            default -> System.out.println("Invalid vehicle type!");
                        }
                    }
                    case 2 -> {
                        if (road.getCarsInRoad().isEmpty()) {
                            System.out.println("No vehicles available. Add a vehicle first.");
                            break;
                        }

                        System.out.println("\nAvailable vehicles:");
                        for (int i = 0; i < road.getCarsInRoad().size(); i++) {
                            Vehicle<?> vehicle = road.getCarsInRoad().get(i);
                            System.out.printf("%d. %s (Occupied: %d/%d)%n",
                                    i + 1, vehicle.getClass().getSimpleName(),
                                    vehicle.getOccupiedSeats(), vehicle.getMaxSeats());
                        }
                        System.out.print("Choose a vehicle: ");
                        int vehicleIndex = scanner.nextInt() - 1;
                        scanner.nextLine();

                        if (vehicleIndex < 0 || vehicleIndex >= road.getCarsInRoad().size()) {
                            System.out.println("Invalid vehicle choice.");
                            break;
                        }

                        Vehicle<?> vehicle = road.getCarsInRoad().get(vehicleIndex);

                        System.out.println("Choose passenger type:");
                        System.out.println("1. Regular Passenger");
                        System.out.println("2. Firefighter");
                        System.out.println("3. Policeman");
                        System.out.print("Your choice: ");
                        int passengerType = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Enter passenger name: ");
                        String name = scanner.nextLine();

                        try {
                            if (vehicle instanceof Bus || vehicle instanceof Taxi) {
                                Vehicle<Passenger> v = (Vehicle<Passenger>) vehicle; // Явне приведення типу
                                switch (passengerType) {
                                    case 1 -> v.addPassenger(new RegularPassenger(name));
                                    case 2 -> v.addPassenger(new Firefighter(name));
                                    case 3 -> v.addPassenger(new Policeman(name));
                                    default -> System.out.println("Invalid passenger type!");
                                }
                            } else if (vehicle instanceof FireTruck) {
                                FireTruck v = (FireTruck) vehicle; // Явне приведення типу
                                if (passengerType == 2) {
                                    v.addPassenger(new Firefighter(name));
                                } else {
                                    System.out.println("Fire Truck only accepts Firefighters.");
                                }
                            } else if (vehicle instanceof PoliceCar) {
                                PoliceCar v = (PoliceCar) vehicle; // Явне приведення типу
                                if (passengerType == 3) {
                                    v.addPassenger(new Policeman(name));
                                } else {
                                    System.out.println("Police Car only accepts Policemen.");
                                }
                            }

                        } catch (IllegalStateException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                    }
                    case 3 -> {
                        if (road.getCarsInRoad().isEmpty()) {
                            System.out.println("No vehicles available. Add a vehicle first.");
                            break;
                        }

                        System.out.println("\nAvailable vehicles:");
                        for (int i = 0; i < road.getCarsInRoad().size(); i++) {
                            Vehicle<?> vehicle = road.getCarsInRoad().get(i);
                            System.out.printf("%d. %s (Occupied: %d/%d)%n",
                                    i + 1, vehicle.getClass().getSimpleName(),
                                    vehicle.getOccupiedSeats(), vehicle.getMaxSeats());
                        }
                        System.out.print("Choose a vehicle: ");
                        int vehicleIndex = scanner.nextInt() - 1;
                        scanner.nextLine();

                        if (vehicleIndex < 0 || vehicleIndex >= road.getCarsInRoad().size()) {
                            System.out.println("Invalid vehicle choice.");
                            break;
                        }

                        Vehicle<?> vehicle = road.getCarsInRoad().get(vehicleIndex);

                        System.out.print("Enter passenger name to remove: ");
                        String name = scanner.nextLine();

                        try {
                            vehicle.removePassenger(
                                    vehicle.getPassengers().stream()
                                            .filter(p -> p.getName().equals(name))
                                            .findFirst()
                                            .orElseThrow(() -> new IllegalArgumentException("Passenger not found!"))
                            );
                            System.out.println("Passenger removed.");
                        } catch (IllegalArgumentException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                    }
                    case 4 -> {
                        System.out.println("Total passengers on the road: " + road.getCountOfHumans());
                    }
                    case 5 -> {
                        System.out.println("Exiting...");
                        return;
                    }
                    default -> System.out.println("Invalid action!");
                }
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }
    }
}

