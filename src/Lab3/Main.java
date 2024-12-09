package Lab3;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Ініціалізація фігур
        List<Shape> shapes = new ArrayList<>();
        shapes.add(new Rectangle("Red", 100, 50));
        shapes.add(new Circle("Blue", 40));
        shapes.add(new Triangle("Green", 80, 60));
        shapes.add(new Rectangle("Yellow", 60, 30));
        shapes.add(new Circle("Red", 20));
        shapes.add(new Triangle("Blue", 50, 40));

        // Обчислення площ
        double totalArea = shapes.stream().mapToDouble(Shape::calculateArea).sum();
        System.out.println("Total area of all shapes: " + totalArea);

        // Обчислення площ за типом
        double totalRectangleArea = shapes.stream()
                .filter(shape -> shape instanceof Rectangle)
                .mapToDouble(Shape::calculateArea)
                .sum();
        System.out.println("Total area of Rectangle shapes: " + totalRectangleArea);

        double totalCircleArea = shapes.stream()
                .filter(shape -> shape instanceof Circle)
                .mapToDouble(Shape::calculateArea)
                .sum();
        System.out.println("Total area of Circle shapes: " + totalCircleArea);

        double totalTriangleArea = shapes.stream()
                .filter(shape -> shape instanceof Triangle)
                .mapToDouble(Shape::calculateArea)
                .sum();
        System.out.println("Total area of Triangle shapes: " + totalTriangleArea);

        // Сортування за площею
        shapes.sort(Comparator.comparingDouble(Shape::calculateArea));
        System.out.println("\nShapes sorted by area:");
        shapes.forEach(shape -> System.out.println(
                shape.getClass().getSimpleName() + ", Color: " + shape.getColor() + ", Area: " + shape.calculateArea()));

        // Сортування за кольором
        shapes.sort(Comparator.comparing(Shape::getColor));
        System.out.println("\nShapes sorted by color:");
        shapes.forEach(shape -> System.out.println(
                shape.getClass().getSimpleName() + ", Color: " + shape.getColor() + ", Area: " + shape.calculateArea()));

        // Відображення графіки
        JFrame frame = new JFrame("Shape Drawer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 800);
        frame.add(new ShapeDrawer(shapes));
        frame.setVisible(true);
    }
}
