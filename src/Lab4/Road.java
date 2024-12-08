package Lab4;

import java.util.ArrayList;
import java.util.List;

public class Road {
    public List<Vehicle<? extends Human>> carsInRoad = new ArrayList<>();

    // Додаємо транспортний засіб на дорогу
    public void addCarToRoad(Vehicle<? extends Human> car) {
        carsInRoad.add(car);
    }

    // Підрахунок кількості людей, які перевозяться всіма транспортними засобами на дорозі
    public int getCountOfHumans() {
        int total = 0;
        for (Vehicle<? extends Human> car : carsInRoad) {
            total += car.getOccupiedSeats();
        }
        return total;
    }
}
