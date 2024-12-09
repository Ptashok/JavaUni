package Lab3;
public abstract class Shape implements Drawable {
    protected String shapeColor; // Поле для збереження кольору фігури

    // Конструктор для ініціалізації кольору
    public Shape(String shapeColor) {
        this.shapeColor = shapeColor;
    }

    // Абстрактний метод для обчислення площі
    public abstract double calcArea();

    // Метод для отримання кольору фігури
    public String getShapeColor() {
        return shapeColor;
    }

    // Перевизначення методу toString
    @Override
    public String toString() {
        return "Shape: " + this.getClass().getSimpleName() + ", Color: " + shapeColor + ", Area: " + calcArea();
    }

    // Реалізація методу draw() (можна залишити базову реалізацію)
    @Override
    public void draw() {
        // Загальна реалізація методу draw(), наприклад, для консолі
        System.out.println("Drawing a " + this.getClass().getSimpleName());
    }
}
