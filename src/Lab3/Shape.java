package Lab3;

import java.awt.*;

public abstract class Shape {
    private String color;

    public Shape(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public abstract double calculateArea();
    public abstract void draw(Graphics g, int x, int y);

    protected Color parseColor() {
        switch (color.toLowerCase()) {
            case "red": return Color.RED;
            case "blue": return Color.BLUE;
            case "green": return Color.GREEN;
            case "yellow": return Color.YELLOW;
            default: return Color.BLACK;
        }
    }
}
