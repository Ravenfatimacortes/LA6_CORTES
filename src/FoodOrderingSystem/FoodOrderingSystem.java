package FoodOrderingSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FoodOrderingSystem extends JFrame {
    private static final double PIZZA_PRICE = 100.00;
    private static final double BURGER_PRICE = 80.00;
    private static final double FRIES_PRICE = 65.00;
    private static final double SOFT_DRINKS_PRICE = 55.00;
    private static final double TEA_PRICE = 50.00;
    private static final double SUNDAE_PRICE = 40.00;

    private JRadioButton pizzaButton;
    private JRadioButton burgerButton;
    private JRadioButton friesButton;
    private JRadioButton softDrinksButton;
    private JRadioButton teaButton;
    private JRadioButton sundaeButton;

    private JRadioButton rb5Percent;
    private JRadioButton rb10Percent;
    private JRadioButton rb15Percent;
    private JRadioButton rbNone;

    private JButton btnOrder;

    public FoodOrderingSystem() {
        setTitle("Food Ordering");
        setSize(300, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(0, 2));

        JLabel lblFood = new JLabel("Food");
        JLabel lblDiscount = new JLabel("Discount");

        pizzaButton = new JRadioButton("Pizza - Php " + PIZZA_PRICE);
        burgerButton = new JRadioButton("Burger - Php " + BURGER_PRICE);
        friesButton = new JRadioButton("Fries - Php " + FRIES_PRICE);
        softDrinksButton = new JRadioButton("Soft Drinks - Php " + SOFT_DRINKS_PRICE);
        teaButton = new JRadioButton("Tea - Php " + TEA_PRICE);
        sundaeButton = new JRadioButton("Sundae - Php " + SUNDAE_PRICE);

        ButtonGroup foodGroup = new ButtonGroup();
        foodGroup.add(pizzaButton);
        foodGroup.add(burgerButton);
        foodGroup.add(friesButton);
        foodGroup.add(softDrinksButton);
        foodGroup.add(teaButton);
        foodGroup.add(sundaeButton);

        rb5Percent = new JRadioButton("5% off");
        rb10Percent = new JRadioButton("10% off");
        rb15Percent = new JRadioButton("15% off");
        rbNone = new JRadioButton("None", true);

        ButtonGroup discountGroup = new ButtonGroup();
        discountGroup.add(rb5Percent);
        discountGroup.add(rb10Percent);
        discountGroup.add(rb15Percent);
        discountGroup.add(rbNone);

        btnOrder = new JButton("Compute");

        btnOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                computeTotalPrice();
            }
        });

        add(lblFood);
        add(lblDiscount);

        add(pizzaButton);
        add(rb5Percent);

        add(burgerButton);
        add(rb10Percent);

        add(friesButton);
        add(rb15Percent);

        add(softDrinksButton);
        add(rbNone);

        add(teaButton);

        add(sundaeButton);

        add(btnOrder);
    }

    private void computeTotalPrice() {
        double totalPrice = 0.0;

        if (pizzaButton.isSelected()) totalPrice += PIZZA_PRICE;
        else if (burgerButton.isSelected()) totalPrice += BURGER_PRICE;
        else if (friesButton.isSelected()) totalPrice += FRIES_PRICE;
        else if (softDrinksButton.isSelected()) totalPrice += SOFT_DRINKS_PRICE;
        else if (teaButton.isSelected()) totalPrice += TEA_PRICE;
        else if (sundaeButton.isSelected()) totalPrice += SUNDAE_PRICE;

        if (rb5Percent.isSelected()) {
            totalPrice *= 0.95; // 5% off
        } else if (rb10Percent.isSelected()) {
            totalPrice *= 0.90; // 10% off
        } else if (rb15Percent.isSelected()) {
            totalPrice *= 0.85; // 15% off
        }

        JOptionPane.showMessageDialog(this, String.format("The total price is Php %.2f", totalPrice), "Total Price", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FoodOrderingSystem app = new FoodOrderingSystem();
            app.setVisible(true);
        });
    }
}