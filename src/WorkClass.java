import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class WorkClass {
    WorkClass(){

        JFrame frame = new JFrame("Simple Window");
        frame.setLayout(new FlowLayout());
        frame.setSize(150,150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton button = new JButton("Simple Button");
        final JLabel label = new JLabel("Start text");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText("The button was pressed");
            }
        });

        final JTextField textField = new JTextField("Start JTextField text");

        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText(textField.getText());
                textField.setText("The Enter on TextField was pressed");
            }
        });
        frame.add(button);
        frame.add(label);
        frame.add(textField);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new WorkClass();
            }
        });
    }
}