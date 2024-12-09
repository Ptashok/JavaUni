package Lab3;

public class Circle extends Shape {
    private double radius;

    public Circle(String color, double radius) {
        super(color); // Викликаємо конструктор батьківського класу Shape
        this.radius = radius;
    }

    @Override
    public double calcArea() {
        return Math.PI * radius * radius;
    }
}

