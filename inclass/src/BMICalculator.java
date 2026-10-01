import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BMICalculator {
    private JRadioButton metricRadioButton;
    private JLabel weightLabel;
    private JFormattedTextField weight;
    private JFormattedTextField height;
    private JButton calculateButton;
    private JButton clearButton;
    private JPanel mainPanel;

    public BMICalculator() {
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                height.setText("");
                weight.setText("");
            }
        });


        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    double weightValue = Double.parseDouble(weight.getText().trim());
                    double heightValue = Double.parseDouble(height.getText().trim());
                    double bmi = 0.0;
                    String unitSystem = "";


                    if (metricRadioButton != null && metricRadioButton.isSelected()) {
                        MetricUnit me = new MetricUnit(heightValue, weightValue);
                        me.calculate();
                        bmi = me.getBmi();

                    } else {
                        EnglshUnit en = new EnglshUnit(heightValue, weightValue);
                        en.calculate();
                        bmi = en.getBmi();
                    }


                    String status;
                    if (bmi < 18.5) {
                        status = "Underweight";
                    } else if (bmi < 25.0) {
                        status = "Healthy weight";
                    } else if (bmi < 30.0) {
                        status = "Overweight";
                    } else {
                        status = "Obesity";
                    }


                    String resultMessage = String.format("System: %s\nYour BMI: %.2f\nStatus: %s", unitSystem, bmi, status);
                    JOptionPane.showMessageDialog(mainPanel, resultMessage, "BMI Calculation Result", JOptionPane.INFORMATION_MESSAGE);

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(mainPanel, "Please enter valid numeric values for height and weight.", "Input Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("BMICalculator");
        BMICalculator calc = new BMICalculator();


        if (calc.mainPanel == null) {
            calc.mainPanel = new JPanel();
            JOptionPane.showMessageDialog(null, "UI components need to be bound via GUI Designer layout.");
        }

        frame.setContentPane(calc.mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
