package Lab3;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ShapeDrawer extends JPanel {
    private List<Shape> shapes;

    public ShapeDrawer(List<Shape> shapes) {
        this.shapes = shapes;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int x = 50;
        int y = 50;

        for (Shape shape : shapes) {
            shape.draw(g, x, y);
            y += 150; // Відступ між фігурами
        }
    }
}
