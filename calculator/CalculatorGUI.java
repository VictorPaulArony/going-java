
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CalculatorGUI {
    public static void main(String[] args) {

        // create frame
        JFrame frame = new JFrame("Simple Calculator");
        frame.setSize(400, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(6, 2, 5, 5));

        // create components
        JLabel num1Label = new JLabel("First Number: ");
        JTextField num1Field = new JTextField();

        JLabel operatorLabel = new JLabel("Operator: ");
        String[] operators = { "+", "-", "/", "*", "%" };
        JComboBox<String> operatorBox = new JComboBox<>(operators);

        JLabel num2Label = new JLabel("Second number: ");
        JTextField num2Field = new JTextField();

        JButton calculateButton = new JButton("calculate");

        JLabel resultLabel = new JLabel("Results: ");
        JLabel resultValue = new JLabel("");

        // adding components to frames
        frame.add(num1Label);
        frame.add(num1Field);

        frame.add(operatorLabel);
        frame.add(operatorBox);

        frame.add(num2Label);
        frame.add(num2Field);

        frame.add(new JLabel());
        frame.add(calculateButton);

        frame.add(resultLabel);
        frame.add(resultValue);

        // actin listiner for the calculator button
        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double num1 = Double.parseDouble(num1Field.getText());
                    double num2 = Double.parseDouble(num2Field.getText());
                    String operator = (String) operatorBox.getSelectedItem();
                    double result;

                    switch (operator) {
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
                                resultValue.setText("Error: Divide by zero");
                                return;
                            }
                            result = num1 / num2;
                            break;
                        case "%":
                            result = num1 % num2;
                            break;
                        default:
                            resultValue.setText("Invalid Operator");
                            return;
                    }

                    resultValue.setText(String.format("%.2f", result));
                } catch (NumberFormatException ex) {
                    resultValue.setText("Invalid number input");
                }
            }
        });

        frame.setVisible(true);
    }
}