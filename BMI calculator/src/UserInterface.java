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
        ButtonGroup unitGroup = new ButtonGroup();
        unitGroup.add(Metric);
        unitGroup.add(RadioButton);
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

    public JTextField getBMICalculatorTextField() { return BMICalculatorTextField; }
    public void setBMICalculatorTextField(JTextField BMICalculatorTextField) { this.BMICalculatorTextField = BMICalculatorTextField; }

    public JButton getCalculateButton() { return calculateButton; }
    public void setCalculateButton(JButton calculateButton) { this.calculateButton = calculateButton; }

    public JButton getClearButton() { return clearButton; }
    public void setClearButton(JButton clearButton) { this.clearButton = clearButton; }

    public JRadioButton getMetric() { return Metric; }
    public void setMetric(JRadioButton metric) { Metric = metric; }

    public JRadioButton getRadioButton() { return RadioButton; }
    public void setRadioButton(JRadioButton radioButton) { RadioButton = radioButton; }

    public JTextField getTextField1() { return textField1; }
    public void setTextField1(JTextField textField1) { this.textField1 = textField1; }

    public JTextField getTextField2() { return textField2; }
    public void setTextField2(JTextField textField2) { this.textField2 = textField2; }

    public JTextField getTextField3() { return textField3; }
    public void setTextField3(JTextField textField3) { this.textField3 = textField3; }
}
