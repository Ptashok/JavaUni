package Lab4t;
import java.io.Serializable;

public class Passenger implements Serializable {
    private String name;

    public Passenger(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Firefighter extends Passenger {
    public Firefighter(String name) {
        super(name);
    }
}

class Policeman extends Passenger {
    public Policeman(String name) {
        super(name);
    }
}
