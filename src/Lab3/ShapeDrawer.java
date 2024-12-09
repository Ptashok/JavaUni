package Lab3;
import java.util.List;
import java.util.Comparator;

public class ShapeDrawer {

    // Метод для сортування фігур за площею
    public void sortByArea(List<Shape> shapes) {
        shapes.sort(Comparator.comparingDouble(Shape::calcArea));
    }

    // Метод для сортування фігур за кольором
    public void sortByColor(List<Shape> shapes) {
        shapes.sort(Comparator.comparing(Shape::getShapeColor));
    }

    // Виведення фігур
    public void printShapes(List<Shape> shapes) {
        for (Shape shape : shapes) {
            System.out.println(shape);
        }
    }

    // Виведення загальної площі всіх фігур
    public double getTotalArea(List<Shape> shapes) {
        return shapes.stream().mapToDouble(Shape::calcArea).sum();
    }

    // Виведення площі фігур певного типу
    public double getTotalAreaByType(List<Shape> shapes, Class<?> shapeClass) {
        return shapes.stream()
                .filter(shape -> shape.getClass().equals(shapeClass))
                .mapToDouble(Shape::calcArea)
                .sum();
    }
}
