/*
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Run the GUI creation task safely on the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Body Mass Index Calculator");

            // Create an instance of your GUI designer class
            BMICalculator calc = new BMICalculator();

            // Attach the GUI designer panel content into the runtime frame
            frame.setContentPane(calc.getMainPanel());

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack(); // Automatically sizes the window based on your GUI layout dimensions
            frame.setLocationRelativeTo(null); // Centers the app layout cleanly on user's monitor
            frame.setVisible(true); // Renders it interactive
        });
    }
}
*/