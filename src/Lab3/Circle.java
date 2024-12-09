package Lab3;

import java.awt.*;

public class Circle extends Shape {
    private double radius;

    public Circle(String color, double radius) {
        super(color);
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public void draw(Graphics g, int x, int y) {
        g.setColor(parseColor());
        g.fillOval(x, y, (int) (2 * radius), (int) (2 * radius));
    }
}
