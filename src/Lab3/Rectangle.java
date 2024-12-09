package Lab3;

public class Rectangle extends Shape {
    private double width, height;

    public Rectangle(String color, double width, double height) {
        super(color); // Викликаємо конструктор батьківського класу Shape
        this.width = width;
        this.height = height;
    }

    @Override
    public double calcArea() {
        return width * height;
    }
}

