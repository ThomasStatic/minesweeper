import java.awt.*;
import javax.swing.*;

public class Board {
    
    public void createWindow(){

        // Create and set up the window
        JFrame frame = new JFrame("Minesweeper");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel textLabel = new JLabel("Test", SwingConstants.CENTER);
        textLabel.setPreferredSize(new Dimension(300, 100));
        frame.getContentPane().add(textLabel, BorderLayout.CENTER);

        // Display the window
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);

    }


}
