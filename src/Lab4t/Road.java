package Lab4t;
import java.util.*;

import java.util.*;

public class Road {
    List<Vehicle<? extends Passenger>> vehiclesOnRoad = new ArrayList<>();

    public int getCountOfHumans() {
        int count = 0;
        for (Vehicle<? extends Passenger> vehicle : vehiclesOnRoad) {
            count += vehicle.getOccupiedSeats();
        }
        return count;
    }

    public void addCarToRoad(Vehicle<? extends Passenger> vehicle) {
        vehiclesOnRoad.add(vehicle);
    }
}
