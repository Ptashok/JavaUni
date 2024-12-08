package Lab4;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Road road = new Road();

        try {
            while (true) {
                System.out.println("\nВиберіть тип транспорту:");
                System.out.println("1. Автобус");
                System.out.println("2. Таксі");
                System.out.println("3. Пожежна машина");
                System.out.println("4. Поліцейська машина");
                System.out.println("5. Вийти та показати підсумки");
                int choice = scanner.nextInt();

                if (choice == 5) break;

                System.out.print("Введіть максимальну кількість місць: ");
                int maxCapacity = scanner.nextInt();

                Vehicle<? extends Human> vehicle = null;
                switch (choice) {
                    case 1 -> vehicle = new Bus(maxCapacity);
                    case 2 -> vehicle = new Taxi(maxCapacity);
                    case 3 -> vehicle = new FireTruck(maxCapacity);
                    case 4 -> vehicle = new PoliceCar(maxCapacity);
                }

                if (vehicle != null) {
                    while (true) {
                        System.out.println("\nДодати пасажира:");
                        System.out.println("1. Звичайний пасажир");
                        System.out.println("2. Пожежник");
                        System.out.println("3. Поліцейський");
                        System.out.println("4. Завершити додавання пасажирів");
                        int passengerChoice = scanner.nextInt();

                        if (passengerChoice == 4) break;

                        System.out.print("Введіть ім'я пасажира: ");
                        String name = scanner.next();
                        Human passenger = switch (passengerChoice) {
                            case 1 -> new Passenger(name);
                            case 2 -> new Firefighter(name);
                            case 3 -> new Policeman(name);
                            default -> null;
                        };

                        try {
                            if (passenger != null) {
                                vehicle.boardPassenger(passenger);
                            }
                        } catch (Exception e) {
                            System.out.println("Помилка: " + e.getMessage());
                        }
                    }

                    road.addCarToRoad(vehicle);
                }
            }

            System.out.println("Загальна кількість пасажирів на дорозі: " + road.getCountOfHumans());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
