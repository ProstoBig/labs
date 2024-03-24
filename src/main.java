import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class EquationSolverWindow extends JFrame {
    public EquationSolverWindow() {
        setTitle("Equation Solver");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        JButton linearEquationButton = new JButton("Solve Linear Equation (2x2)");
        JButton quadraticEquationButton = new JButton("Solve Quadratic Equation");

        linearEquationButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showLinearEquationWindow();
            }
        });

        quadraticEquationButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showQuadraticEquationWindow();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 1));
        buttonPanel.add(linearEquationButton);
        buttonPanel.add(quadraticEquationButton);

        add(buttonPanel, BorderLayout.CENTER);
    }

    private void showLinearEquationWindow() {
        JFrame linearEquationFrame = new JFrame("Solve Linear Equation (2x2)");
        linearEquationFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        linearEquationFrame.setSize(300, 200);
        linearEquationFrame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));

        JLabel label1 = new JLabel("Enter a:");
        JTextField textField1 = new JTextField();

        JLabel label2 = new JLabel("Enter b:");
        JTextField textField2 = new JTextField();

        JLabel label3 = new JLabel("Enter c:");
        JTextField textField3 = new JTextField();

        JButton solveButton = new JButton("Solve");

        panel.add(label1);
        panel.add(textField1);
        panel.add(label2);
        panel.add(textField2);
        panel.add(label3);
        panel.add(textField3);
        panel.add(solveButton);

        linearEquationFrame.add(panel);

        solveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double a = Double.parseDouble(textField1.getText());
                double b = Double.parseDouble(textField2.getText());
                double c = Double.parseDouble(textField3.getText());

                double x = (c - b) / a;

                JOptionPane.showMessageDialog(linearEquationFrame, "Solution: x = " + x);
            }
        });

        linearEquationFrame.setVisible(true);
    }

    private void showQuadraticEquationWindow() {
        JFrame quadraticEquationFrame = new JFrame("Solve Quadratic Equation");
        quadraticEquationFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        quadraticEquationFrame.setSize(300, 200);
        quadraticEquationFrame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));

        JLabel label1 = new JLabel("Enter a:");
        JTextField textField1 = new JTextField();

        JLabel label2 = new JLabel("Enter b:");
        JTextField textField2 = new JTextField();

        JLabel label3 = new JLabel("Enter c:");
        JTextField textField3 = new JTextField();

        JButton solveButton = new JButton("Solve");

        panel.add(label1);
        panel.add(textField1);
        panel.add(label2);
        panel.add(textField2);
        panel.add(label3);
        panel.add(textField3);
        panel.add(solveButton);

        quadraticEquationFrame.add(panel);

        solveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double a = Double.parseDouble(textField1.getText());
                double b = Double.parseDouble(textField2.getText());
                double c = Double.parseDouble(textField3.getText());

                double discriminant = b * b - 4 * a * c;

                if (discriminant > 0) {
                    double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
                    double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
                    JOptionPane.showMessageDialog(quadraticEquationFrame, "Solutions: x1 = " + root1 + ", x2 = " + root2);
                } else if (discriminant == 0) {
                    double root = -b / (2 * a);
                    JOptionPane.showMessageDialog(quadraticEquationFrame, "Solution: x = " + root);
                } else {
                    JOptionPane.showMessageDialog(quadraticEquationFrame, "No real solutions");
                }
            }
        });

        quadraticEquationFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                EquationSolverWindow window = new EquationSolverWindow();
                window.setVisible(true);
            }
        });
    }
}
