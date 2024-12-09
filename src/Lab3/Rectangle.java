package Lab3;

import java.awt.*;

public class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(String color, double width, double height) {
        super(color);
        this.width = width;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return width * height;
    }

    @Override
    public void draw(Graphics g, int x, int y) {
        g.setColor(parseColor());
        g.fillRect(x, y, (int) width, (int) height);
    }
}
