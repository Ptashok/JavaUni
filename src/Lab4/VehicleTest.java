package Lab4;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class VehicleTest {

    @Test
    public void testBoardingToBus() throws Exception {
        Bus bus = new Bus(3);
        Passenger passenger1 = new Passenger("John");
        Passenger passenger2 = new Passenger("Jane");
        bus.boardPassenger(passenger1);
        bus.boardPassenger(passenger2);

        assertEquals(2, bus.getOccupiedSeats());
    }

    @Test
    public void testBoardingOverCapacity() {
        Bus bus = new Bus(1);
        Passenger passenger1 = new Passenger("John");
        Passenger passenger2 = new Passenger("Jane");

        assertDoesNotThrow(() -> bus.boardPassenger(passenger1));
        Exception exception = assertThrows(Exception.class, () -> bus.boardPassenger(passenger2));
        assertEquals("No available seats.", exception.getMessage());
    }

    @Test
    public void testUnboardingPassenger() throws Exception {
        Bus bus = new Bus(2);
        Passenger passenger = new Passenger("John");
        bus.boardPassenger(passenger);
        bus.unboardPassenger(passenger);

        assertEquals(0, bus.getOccupiedSeats());
    }

    @Test
    public void testUnboardingNonexistentPassenger() {
        Bus bus = new Bus(2);
        Passenger passenger = new Passenger("John");
        Exception exception = assertThrows(Exception.class, () -> bus.unboardPassenger(passenger));
        assertEquals("Passenger is not in the vehicle.", exception.getMessage());
    }

    @Test
    public void testFireTruckBoardingFirefighterOnly() {
        FireTruck fireTruck = new FireTruck(2);
        Firefighter firefighter = new Firefighter("Alice");
        Passenger passenger = new Passenger("John");

        assertDoesNotThrow(() -> fireTruck.boardPassenger(firefighter));
        Exception exception = assertThrows(ClassCastException.class, () -> fireTruck.boardPassenger(passenger));
    }

    @Test
    public void testPoliceCarBoardingPolicemanOnly() {
        PoliceCar policeCar = new PoliceCar(2);
        Policeman policeman = new Policeman("Bob");
        Passenger passenger = new Passenger("John");

        assertDoesNotThrow(() -> policeCar.boardPassenger(policeman));
        Exception exception = assertThrows(ClassCastException.class, () -> policeCar.boardPassenger(passenger));
    }
}


