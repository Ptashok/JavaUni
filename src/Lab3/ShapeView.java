package Lab3;

import java.util.List;

public class ShapeView {

    // Виведення інформації про фігури
    public void printShapeDetails(List<Shape> shapes) {
        for (Shape shape : shapes) {
            System.out.println(shape);
        }
    }

    // Виведення сумарної площі
    public void printTotalArea(double area) {
        System.out.println("Total area of all shapes: " + area);
    }

    // Виведення сумарної площі для фігур певного типу
    public void printTotalAreaByType(double area) {
        System.out.println("Total area of selected shapes: " + area);
    }
}
