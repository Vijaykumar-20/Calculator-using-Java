package org.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class CalculatorGUI extends JFrame {
    private JTextField display;

    public CalculatorGUI() {
        setTitle("Vijay's Calculator");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        display = new JTextField();
        display.setEditable(false);
        display.setHorizontalAlignment(SwingConstants.RIGHT);
        add(display, BorderLayout.NORTH);
        display.setBackground(Color.BLACK);
        display.setForeground(Color.WHITE);
        display.setFont(new Font("Arial", Font.BOLD, 24));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 4, 10, 10));
        buttonPanel.setBackground(Color.BLACK);

        // Add number buttons
        for (int i = 1; i <= 9; i++) {
            buttonPanel.add(createButton(String.valueOf(i)));
        }

        // Add operator buttons
        buttonPanel.add(createButton("0"));
        buttonPanel.add(createButton("+"));
        buttonPanel.add(createButton("-"));
        buttonPanel.add(createButton("/"));
        buttonPanel.add(createButton("*"));
        buttonPanel.add(createButton("%"));

        // Add the Zero button in the center
        buttonPanel.add(createButton("Clear"));
        buttonPanel.add(createButton("Back"));
        buttonPanel.add(createButton("="));

        // Add buttons to the panel
        add(buttonPanel, BorderLayout.CENTER);
        setVisible(true);
    }

    private JButton createButton(String label) {
        JButton button = new JButton(label);
        button.setFocusPainted(false);
        button.setBackground(Color.CYAN); // Set button background to cyan
        button.setForeground(Color.BLACK); // Set text color to black
        button.setFont(new Font("Arial", Font.BOLD, 24)); // Adjust font size
        button.setBorder(BorderFactory.createLineBorder(Color.CYAN, 2)); // Cyan border

        // Set the button's preferred size to make it circular
        button.setPreferredSize(new Dimension(80, 80));
        button.setOpaque(true);
        button.setContentAreaFilled(true);
        button.setBorderPainted(true);
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        button.addActionListener(new ButtonClickListener());
        return button;
    }

    private class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            // Handle button clicks (add functionality as needed)
            if (command.equals("Clear")) {
                display.setText("");
            } else if (command.equals("Backspace")) {
                String text = display.getText();
                if (text.length() > 0) {
                    display.setText(text.substring(0, text.length() - 1));
                }
            }
                else if (command.equals("=")) {
                    // Handle calculation on '=' button click
                    String expression = display.getText();
                    try {
                        // Parse and calculate the expression
                        long result = evaluateExpression(expression);
                        display.setText(String.valueOf(result));  // Display the result
                    } catch (Exception ex) {
                        display.setText("Error");  // Handle invalid input
                    }
                } else {
                    // For all other buttons (numbers and operators), append to the display
                    display.setText(display.getText() + command);
                }
            }

            }
    private long evaluateExpression(String expression) {
        String[] tokens = expression.split("([+\\-*/%])"); // Split by operators
        if (tokens.length != 2) throw new IllegalArgumentException("Invalid expression");

        long operand1 = Long.parseLong(tokens[0].trim());
        long operand2 = Long.parseLong(tokens[1].trim());

        char operator = expression.charAt(tokens[0].length()); // Get operator character

        switch (operator) {
            case '+':
                return CalculatorFunctions.Addition(operand1, operand2);
            case '-':
                return CalculatorFunctions.Subtraction(operand1, operand2);
            case '*':
                return CalculatorFunctions.Multiplication(operand1, operand2);
            case '/':
                return (long)CalculatorFunctions.Division(operand1, operand2);
            case '%':
                return (long)CalculatorFunctions.Percentage(operand1, operand2);
            default:
                throw new IllegalArgumentException("Unknown operator");
        }
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(CalculatorGUI::new);
//        long result= CalculatorFunctions.Addition(0,5);
////        System.out.println(result);//print addition
//        long result= CalculatorFunctions.Subtraction(7,5);
////        System.out.println(result);//print Subtraction
//        long result= CalculatorFunctions.Multiplication(4,5);
////        System.out.println(result);//print Multiplication
//        double result= CalculatorFunctions.Division(5,8);
////        System.out.println(result);//print Division
//        double result= CalculatorFunctions.Percentage(90,100);
////        System.out.println(result);//print Percentage

    }
}
