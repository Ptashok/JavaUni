package Lab4t;
import java.io.*;
import java.util.*;

public abstract class Vehicle<T extends Passenger> implements Serializable {
    private List<T> passengers;
    private int capacity;

    public Vehicle(int capacity) {
        this.capacity = capacity;
        this.passengers = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public int getOccupiedSeats() {
        return passengers.size();
    }

    public void boardPassenger(Passenger passenger) throws Exception {
        if (passengers.size() >= capacity) {
            throw new Exception("No more seats available.");
        }
        passengers.add((T) passenger);
    }

    public void unboardPassenger(T passenger) throws Exception {
        if (!passengers.contains(passenger)) {
            throw new Exception("Passenger not found in the vehicle.");
        }
        passengers.remove(passenger);
    }

    public void savePassengersToFile(String filename) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(passengers);
        }
    }

    public void loadPassengersFromFile(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            passengers = (List<T>) in.readObject();
        }
    }

    public List<T> getPassengers() {
        return passengers;
    }
}


