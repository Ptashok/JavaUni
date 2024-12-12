package Lab4;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import java.util.ArrayList;
import java.util.List;

public class Road {
    private final List<Vehicle<? extends Passenger>> carsInRoad = new ArrayList<>();

    public void addCarToRoad(Vehicle<? extends Passenger> vehicle) {
        carsInRoad.add(vehicle);
    }

    public int getCountOfHumans() {
        return carsInRoad.stream()
                .mapToInt(vehicle -> vehicle.getPassengers().size())
                .sum();
    }

    public List<Vehicle<? extends Passenger>> getCarsInRoad() {
        return carsInRoad;
    }
}
