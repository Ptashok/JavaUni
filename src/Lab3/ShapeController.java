package Lab3;
import java.util.*;

public class ShapeController {
    private List<Shape> shapes;

    public ShapeController(List<Shape> shapes) {
        this.shapes = shapes;
    }

    // Підсумкова площа всіх фігур
    public double getTotalArea() {
        double totalArea = 0;
        for (Shape shape : shapes) {
            totalArea += shape.calcArea();
        }
        return totalArea;
    }

    // Підсумкова площа фігур певного виду
    public double getTotalAreaByType(Class<? extends Shape> type) {
        double totalArea = 0;
        for (Shape shape : shapes) {
            if (shape.getClass().equals(type)) {
                totalArea += shape.calcArea();
            }
        }
        return totalArea;
    }

    // Сортування фігур за площею
    public void sortByArea() {
        shapes.sort(Comparator.comparingDouble(Shape::calcArea));
    }

    // Сортування фігур за кольором
    public void sortByColor() {
        shapes.sort(Comparator.comparing(shape -> shape.shapeColor));
    }

    // Виведення всіх фігур
    public void printShapes() {
        for (Shape shape : shapes) {
            System.out.println(shape);
        }
    }
}
