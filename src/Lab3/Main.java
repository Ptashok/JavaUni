package Lab3;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // Масиви кольорів, ширини, висоти, радіусів
        List<String> colors = Arrays.asList("Red", "Blue", "Green", "Yellow", "Purple");
        List<Double> widths = Arrays.asList(50.0, 60.0, 70.0, 80.0, 90.0);
        List<Double> heights = Arrays.asList(20.0, 30.0, 40.0, 50.0, 60.0);
        List<Double> radii = Arrays.asList(15.0, 20.0, 25.0, 30.0, 35.0);
        List<Double> bases = Arrays.asList(25.0, 30.0, 35.0, 40.0, 45.0);

        // Генератор випадкових чисел
        Random random = new Random();

        // Створюємо список фігур
        List<Shape> shapes = Arrays.asList(
                new Rectangle(colors.get(random.nextInt(colors.size())), widths.get(random.nextInt(widths.size())), heights.get(random.nextInt(heights.size()))),
                new Circle(colors.get(random.nextInt(colors.size())), radii.get(random.nextInt(radii.size()))),
                new Triangle(colors.get(random.nextInt(colors.size())), bases.get(random.nextInt(bases.size())), heights.get(random.nextInt(heights.size()))),
                new Rectangle(colors.get(random.nextInt(colors.size())), widths.get(random.nextInt(widths.size())), heights.get(random.nextInt(heights.size()))),
                new Circle(colors.get(random.nextInt(colors.size())), radii.get(random.nextInt(radii.size()))),
                new Triangle(colors.get(random.nextInt(colors.size())), bases.get(random.nextInt(bases.size())), heights.get(random.nextInt(heights.size()))),
                new Rectangle(colors.get(random.nextInt(colors.size())), widths.get(random.nextInt(widths.size())), heights.get(random.nextInt(heights.size()))),
                new Circle(colors.get(random.nextInt(colors.size())), radii.get(random.nextInt(radii.size()))),
                new Triangle(colors.get(random.nextInt(colors.size())), bases.get(random.nextInt(bases.size())), heights.get(random.nextInt(heights.size()))),
                new Rectangle(colors.get(random.nextInt(colors.size())), widths.get(random.nextInt(widths.size())), heights.get(random.nextInt(heights.size())))
        );

        // Створюємо об'єкт ShapeDrawer для сортування і виведення
        ShapeDrawer shapeDrawer = new ShapeDrawer();

        // Вивести всі фігури
        shapeDrawer.printShapes(shapes);

        // Вивести загальну площу всіх фігур
        System.out.println("Total area of all shapes: " + shapeDrawer.getTotalArea(shapes));

        // Вивести загальну площу фігур певного типу (наприклад, Rectangle)
        System.out.println("Total area of Rectangle shapes: " + shapeDrawer.getTotalAreaByType(shapes, Rectangle.class));

        // Вивести всі фігури після сортування за площею
        shapeDrawer.sortByArea(shapes);
        System.out.println("\nShapes sorted by area:");
        shapeDrawer.printShapes(shapes);

        // Вивести всі фігури після сортування за кольором
        shapeDrawer.sortByColor(shapes);
        System.out.println("\nShapes sorted by color:");
        shapeDrawer.printShapes(shapes);
    }
}
