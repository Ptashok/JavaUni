package Lab4;

import java.util.ArrayList;
import java.util.List;

// Базовий клас транспортного засобу
abstract class Vehicle<T extends Human> {
    protected List<Human> passengers;
    protected int maxCapacity;

    public Vehicle(int maxCapacity) {
        this.maxCapacity = maxCapacity;
        this.passengers = new ArrayList<Human>();
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public int getOccupiedSeats() {
        return passengers.size();
    }

    public void boardPassenger(Human passenger) throws Exception {
        if (passengers.size() >= maxCapacity) {
            throw new Exception("No available seats.");
        }
        passengers.add(passenger);
    }

    public void unboardPassenger(T passenger) throws Exception {
        if (!passengers.contains(passenger)) {
            throw new Exception("Passenger is not in the vehicle.");
        }
        passengers.remove(passenger);
    }

    public List<Human> getPassengers() {
        return passengers;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " with " + passengers.size() + "/" + maxCapacity + " passengers";
    }
}

// Автобус, який може перевозити будь-яких пасажирів
class Bus extends Vehicle<Human> {
    public Bus(int maxCapacity) {
        super(maxCapacity);
    }
}

// Таксі, яке також може перевозити будь-яких пасажирів
class Taxi extends Vehicle<Human> {
    public Taxi(int maxCapacity) {
        super(maxCapacity);
    }
}

// Пожежна машина, яка може перевозити тільки пожежників
class FireTruck extends Vehicle<Firefighter> {
    public FireTruck(int maxCapacity) {
        super(maxCapacity);
    }
}

// Поліцейська машина, яка може перевозити тільки поліцейських
class PoliceCar extends Vehicle<Policeman> {
    public PoliceCar(int maxCapacity) {
        super(maxCapacity);
    }
}
