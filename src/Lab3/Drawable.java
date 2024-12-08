package Lab3;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

// Інтерфейс Drawable без змін
interface Drawable {
    void draw(Graphics g);
}

// Абстрактний клас Shape
abstract class Shape implements Drawable {
    protected String shapeColor;

    public Shape(String shapeColor) {
        this.shapeColor = shapeColor;
    }

    public abstract double calcArea();

    public Color getColor() {
        switch (shapeColor.toLowerCase()) {
            case "red": return Color.RED;
            case "blue": return Color.BLUE;
            case "green": return Color.GREEN;
            case "yellow": return Color.YELLOW;
            default: return Color.BLACK;
        }
    }

    @Override
    public String toString() {
        return "Shape: " + this.getClass().getSimpleName() + ", Color: " + shapeColor;
    }
}

// Клас Rectangle
class Rectangle extends Shape {
    private int width;
    private int height;

    public Rectangle(String shapeColor, int width, int height) {
        super(shapeColor);
        this.width = width;
        this.height = height;
    }

    @Override
    public double calcArea() {
        return width * height;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(getColor());
        g.fillRect(10, 10, width, height);
    }

    @Override
    public String toString() {
        return super.toString() + ", Width: " + width + ", Height: " + height + ", Area: " + calcArea();
    }
}

// Клас Triangle
class Triangle extends Shape {
    private int base;
    private int height;

    public Triangle(String shapeColor, int base, int height) {
        super(shapeColor);
        this.base = base;
        this.height = height;
    }

    @Override
    public double calcArea() {
        return 0.5 * base * height;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(getColor());
        int[] xPoints = {10, 10 + base / 2, 10 + base};
        int[] yPoints = {10 + height, 10, 10 + height};
        g.fillPolygon(xPoints, yPoints, 3);
    }

    @Override
    public String toString() {
        return super.toString() + ", Base: " + base + ", Height: " + height + ", Area: " + calcArea();
    }
}

// Клас Circle
class Circle extends Shape {
    private int radius;

    public Circle(String shapeColor, int radius) {
        super(shapeColor);
        this.radius = radius;
    }

    @Override
    public double calcArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(getColor());
        g.fillOval(10, 10, radius * 2, radius * 2);
    }

    @Override
    public String toString() {
        return super.toString() + ", Radius: " + radius + ", Area: " + calcArea();
    }
}