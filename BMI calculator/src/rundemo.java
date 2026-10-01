import javax.swing.*;

public class rundemo {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("BMI Calculator");


            UserInterface ui = new UserInterface();


            frame.setContentPane(ui.getMainPanel());


            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });

    }
}
