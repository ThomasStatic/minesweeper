import java.awt.*;
import javax.swing.*;

public class Board {
    
    private String difficulty;
    private int nSize;
    JFrame frame = new JFrame("Minesweeper");

    Board(){
        this.difficulty = "Easy";
    }

    Board(String userDifficulty) throws IllegalArgumentException{
        this.difficulty = userDifficulty;
        switch(this.difficulty){
            case "Easy":
                this.nSize = 10;
                break;
            

            default:
                throw new IllegalArgumentException(this.difficulty + "is not a valid difficulty");
        }
    }

    public void createWindow(){

        // Create and set up the window
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //JButton button = new JButton("Test");
        //this.frame.add(button);

        generateButtonGrid();

        // Display the window
        this.frame.setLocationRelativeTo(null);
        this.frame.pack(); // Pack sets the screensize to be big enough for all the components in it
        this.frame.setVisible(true);

    }

    private void generateButtonGrid(){
        JPanel buttonPanel = new JPanel();
        JPanel containerPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(this.nSize, this.nSize));
        for(int i = 0; i < nSize; i++){
            for(int j = 0; j < nSize; j++){
                buttonPanel.add(new JButton());
            }
        }
        buttonPanel.setPreferredSize(new Dimension(400,400));
        containerPanel.add(buttonPanel);
        this.frame.getContentPane().add(containerPanel);

        
    }


}
