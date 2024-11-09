package SimpleCalculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleCalculator extends JFrame {
    private JTextField tfNumber1;
    private JTextField tfNumber2;
    private JComboBox<String> cbOperations;
    private JButton btnCompute;
    private JLabel lblResult;
    private JPanel panel;

    public SimpleCalculator() {
        setTitle("Simple Calculator");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        tfNumber1 = new JTextField(10);
        tfNumber2 = new JTextField(10);
        String[] operations = {"+", "-", "*", "/"};
        cbOperations = new JComboBox<>(operations);
        btnCompute = new JButton("Compute");
        lblResult = new JLabel("Result: ");

        add(tfNumber1);
        add(cbOperations);
        add(tfNumber2);
        add(btnCompute);
        add(lblResult);

        btnCompute.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                computeResult();
            }
        });
    }

    private void computeResult() {
        try {
            double num1 = Double.parseDouble(tfNumber1.getText());
            double num2 = Double.parseDouble(tfNumber2.getText());
            String operation = (String) cbOperations.getSelectedItem();
            double result;

            switch (operation) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    if (num2 == 0) {
                        lblResult.setText("Error: Division by zero");
                        return;
                    }
                    result = num1 / num2;
                    break;
                default:
                    lblResult.setText("Invalid operation");
                    return;
            }
            lblResult.setText("Result: " + result);
        } catch (NumberFormatException ex) {
            lblResult.setText("Error: Invalid input");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SimpleCalculator calculator = new SimpleCalculator();
            calculator.setVisible(true);
        });
    }
}