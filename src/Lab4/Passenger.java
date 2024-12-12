package Lab4;
import java.util.*;
import java.io.*;

// --- Passenger classes ---
abstract class Passenger implements Serializable {
    private final String name;

    public Passenger(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}