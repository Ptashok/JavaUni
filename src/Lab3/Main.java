package Lab3;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

// Головний клас
public class Main {
    public static void main(String[] args) {
        List<Shape> shapes = Arrays.asList(
                new Rectangle("Red", 100, 50),
                new Circle("Blue", 40),
                new Triangle("Green", 80, 60),
                new Rectangle("Yellow", 60, 30),
                new Circle("Red", 20),
                new Triangle("Blue", 50, 40),
                new Rectangle("Green", 70, 50),
                new Circle("Yellow", 60),
                new Triangle("Red", 100, 80),
                new Rectangle("Blue", 40, 30)
        );

        // 1. Відображення набору даних
        System.out.println("Initial Shapes:");
        shapes.forEach(System.out::println);

        // 2. Обчислення сумарної площі всіх фігур
        double totalArea = shapes.stream().mapToDouble(Shape::calcArea).sum();
        System.out.println("\nTotal area of all shapes: " + totalArea);

        // 3. Обчислення сумарної площі фігур заданого виду
        double totalRectangleArea = shapes.stream()
                .filter(shape -> shape instanceof Rectangle)
                .mapToDouble(Shape::calcArea)
                .sum();
        double totalCircleArea = shapes.stream()
                .filter(shape -> shape instanceof Circle)
                .mapToDouble(Shape::calcArea)
                .sum();
        double totalTriangleArea = shapes.stream()
                .filter(shape -> shape instanceof Triangle)
                .mapToDouble(Shape::calcArea)
                .sum();
        System.out.println("Total area of Rectangle shapes: " + totalRectangleArea);
        System.out.println("Total area of Circle shapes: " + totalCircleArea);
        System.out.println("Total area of Triangle shapes: " + totalTriangleArea);

        // 4. Сортування за площею
        shapes.sort(Comparator.comparingDouble(Shape::calcArea));
        System.out.println("\nShapes sorted by area:");
        shapes.forEach(System.out::println);

        // 5. Сортування за кольором
        shapes.sort(Comparator.comparing(shape -> shape.shapeColor));
        System.out.println("\nShapes sorted by color:");
        shapes.forEach(System.out::println);

        // Додатково - графічне відображення (опціонально)
        JFrame frame = new JFrame("Shape Drawer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 400);
        ShapePanel shapePanel = new ShapePanel(shapes);
        frame.add(shapePanel);
        frame.setVisible(true);
    }
}

// Клас для відображення фігур
class ShapePanel extends JPanel {
    private List<Shape> shapes;

    public ShapePanel(List<Shape> shapes) {
        this.shapes = shapes;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int xOffset = 10;
        for (Shape shape : shapes) {
            Graphics g2 = g.create(xOffset, 50, getWidth(), getHeight());
            shape.draw(g2);
            xOffset += 150;
        }
    }
}