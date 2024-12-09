package Lab3;

public class Triangle extends Shape {
    private double base, height;

    public Triangle(String color, double base, double height) {
        super(color); // Викликаємо конструктор батьківського класу Shape
        this.base = base;
        this.height = height;
    }

    @Override
    public double calcArea() {
        return (base * height) / 2;
    }
}

