import java.awt.*;
import javax.swing.*;

public class Board {
    
    private String difficulty;
    private int nSize;
    private int numMines;
    private int boardSize;
    JFrame frame = new JFrame("Minesweeper");

    

    Board(String userDifficulty) throws IllegalArgumentException{
        this.difficulty = userDifficulty;
        switch(this.difficulty){
            case "Easy":
                this.nSize = 10;
                this.numMines = 10;
                this.boardSize = 300;
                break;

            case "Medium":
                this.nSize = 16;
                this.numMines = 40;
                this.boardSize = 400;
                break;

            case "Hard":
                this.nSize = 22;
                this.numMines = 99;
                this.boardSize = 500;
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
        

        buttonPanel.setPreferredSize(new Dimension(this.boardSize,this.boardSize));
        containerPanel.add(buttonPanel);
        this.frame.getContentPane().add(containerPanel);

        
    }


}
