import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BMICalculator {
    private JLabel BMICalculatorLabel;
    private JLabel unitLabel;
    private JRadioButton metricUnits;
    private JRadioButton englishUnits;
    private JTextField weight;
    private JLabel heightLabel;
    private JLabel weightLabel;
    private JTextField height;
    private JButton calculateButton;
    private JButton clearButton;
    private JPanel mainPanel;

    public BMICalculator() {
        if (englishUnits.isSelected()) {
            weightLabel.setText("Weight in Kilograms");
            heightLabel.setText("Height in Meters");
        } else {
            weightLabel.setText("Weight in Pounds");
            heightLabel.setText("Height in Inches");
        }

        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String message = "";
                double bmi;
                if (englishUnits.isSelected()) {
                    EnglishUnit cx = new EnglishUnit(Double.parseDouble(weight.getText()), Double.parseDouble(height.getText()));
                    cx.calculate();
                    bmi = cx.getBmi();
                    message = message + "Your BMI is " + bmi + "\n\nAnalysis: ";
                    if (bmi < 18.5) {
                        message = message + "Underweight";
                    } else if (bmi > 18.5 && bmi < 24.9) {
                        message = message + "Normal";
                    } else if (bmi > 24.9 && bmi < 29.9) {
                        message = message + "Overweight";
                    } else {
                        message = message + "Obese";
                    }

                    System.out.println(cx.getBmi());
                } else {
                    MetricUnit c = new MetricUnit(Double.parseDouble(weight.getText()), Double.parseDouble(height.getText()));
                    c.calculate();
                    bmi = c.getBmi();
                    message = message + "Your BMI is " + bmi + "\n\nAnalysis: ";
                    if (bmi < 18.5) {
                        message = message + "Underweight";
                    } else if (bmi > 18.5 && bmi < 24.9) {
                        message = message + "Normal";
                    } else if (bmi > 24.9 && bmi < 29.9) {
                        message = message + "Overweight";
                    } else {
                        message = message + "Obese";
                    }

                    System.out.println(c.getBmi());
                }

                JOptionPane.showMessageDialog(null, message, "Result", 1);
            }
        });
        this.clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                BMICalculator.this.height.setText("");
                BMICalculator.this.weight.setText("");
            }
        });
        englishUnits.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                BMICalculator.this.weightLabel.setText("Weight in Kilograms");
                BMICalculator.this.heightLabel.setText("Height in Meters");
            }
        });
        metricUnits.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                BMICalculator.this.weightLabel.setText("Weight in Pounds");
                BMICalculator.this.heightLabel.setText("Height in Inches");
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("BMICalculator");
        frame.setContentPane((new BMICalculator()).mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.pack();
        frame.setSize(500, 300);
        frame.setVisible(true);
    }
}
/*
    public static void main(String[] args) {
        JFrame frame = new JFrame("BMICalculator");
        frame.setContentPane(new BMICalculator().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
*/