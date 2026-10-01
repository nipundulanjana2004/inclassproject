import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserInterface {

    private JPanel mainPanel;
    private JTextField BMICalculatorTextField;
    private JRadioButton Metric;
    private JRadioButton RadioButton;
    private JTextField textField1; // Weight
    private JTextField textField2; // Height
    private JButton calculateButton;
    private JButton clearButton;
    private JTextField textField3; //  Output
    private JTextArea underweightLessThan18TextArea;

    public UserInterface() {
        ButtonGroup u = new ButtonGroup();
        u.add(Metric);
        u.add(RadioButton);
        Metric.setSelected(true);

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateBMI();
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearFields();
            }
        });
    }

    private void calculateBMI() {
        try {
            String weightStr = textField1.getText().trim();
            String heightStr = textField2.getText().trim();


            if (weightStr.isEmpty() || heightStr.isEmpty()) {
                textField3.setText("Please enter values!");
                return;
            }

            double weight = Double.parseDouble(weightStr);
            double height = Double.parseDouble(heightStr);
            double bmi = 0.0;

            if (Metric.isSelected()) {
                if (height > 3) {
                    height = height / 100.0;
                }
                bmi = weight / (height * height);
            } else if (RadioButton.isSelected()) {
                bmi = (weight / (height * height)) * 703.0;
            }

            String formattedBMI = String.format("%.2f", bmi);


            String status;
            if (bmi < 18.5) status = "Underweight";
            else if (bmi < 25.0) status = "Normal";
            else if (bmi < 30.0) status = "Overweight";
            else status = "Obese";


            textField3.setText(formattedBMI + " (" + status + ")");

        } catch (NumberFormatException ex) {

            textField3.setText("Invalid Number Input!");
        }
    }

    private void clearFields() {
        textField1.setText("");
        textField2.setText("");
        textField3.setText("");
        Metric.setSelected(true);
    }


    public JPanel getMainPanel() { return mainPanel; }
    public void setMainPanel(JPanel mainPanel) { this.mainPanel = mainPanel; }

}
