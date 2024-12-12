package Lab4;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

abstract class Vehicle<T extends Passenger> implements Serializable {
    private final int maxSeats;
    private final List<T> passengers;

    public Vehicle(int maxSeats) {
        this.maxSeats = maxSeats;
        this.passengers = new ArrayList<>();
    }

    public int getMaxSeats() {
        return maxSeats;
    }

    public int getOccupiedSeats() {
        return passengers.size();
    }

    public void addPassenger(T passenger) {
        if (passengers.size() >= maxSeats) {
            throw new IllegalStateException("No more seats available!");
        }
        passengers.add(passenger);
    }

    public void removePassenger(Passenger passenger) {
        if (!passengers.remove(passenger)) {
            throw new NoSuchElementException("Passenger not found in vehicle!");
        }
    }

    public List<T> getPassengers() {
        return passengers;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " (" + getOccupiedSeats() + "/" + getMaxSeats() + " occupied)";
    }
}