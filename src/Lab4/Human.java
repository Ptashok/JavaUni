package Lab4;

import java.io.Serializable;

// Базовий клас для пасажирів
abstract class Human implements Serializable {
    String name;

    public Human(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

// Підкласи: Пожежник, Поліцейський, Звичайний пасажир
class Firefighter extends Human {
    public Firefighter(String name) {
        super(name);
    }
}

class Policeman extends Human {
    public Policeman(String name) {
        super(name);
    }
}

class Passenger extends Human {
    public Passenger(String name) {
        super(name);
    }
}
