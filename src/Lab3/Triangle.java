package Lab3;

import java.awt.*;

public class Triangle extends Shape {
    private double base;
    private double height;

    public Triangle(String color, double base, double height) {
        super(color);
        this.base = base;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return 0.5 * base * height;
    }

    @Override
    public void draw(Graphics g, int x, int y) {
        g.setColor(parseColor());
        int[] xPoints = {x, x + (int) base / 2, x - (int) base / 2};
        int[] yPoints = {y, y + (int) height, y + (int) height};
        g.fillPolygon(xPoints, yPoints, 3);
    }
}
