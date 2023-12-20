import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Board implements ActionListener {
    
    private String difficulty;
    private int nSize;
    private int numMines;
    private int boardSize;
    JFrame frame = new JFrame("Minesweeper");
    Game playingField;
    JButton[][] buttonGrid;

    

    Board(String userDifficulty) throws IllegalArgumentException{
        this.difficulty = userDifficulty;
        switch(this.difficulty){
            case "Easy":
                this.nSize = 10;
                this.numMines = 10;
                this.boardSize = 400;
                break;

            case "Medium":
                this.nSize = 16;
                this.numMines = 40;
                this.boardSize = 500;
                break;

            case "Hard":
                this.nSize = 22;
                this.numMines = 99;
                this.boardSize = 600;
                break;

            default:
                throw new IllegalArgumentException(this.difficulty + "is not a valid difficulty");
        }

        this.playingField = new Game(this.numMines, this.nSize);
        playingField.generateField();
        this.buttonGrid = new JButton[this.nSize][this.nSize];

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
                
        //         //String tileValue = String.valueOf(this.playingField.getTile(i, j));
        //         //System.out.println(tileValue);
                this.buttonGrid[i][j] = new JButton("?");
                this.buttonGrid[i][j].setSize(new Dimension(40,40));
                this.buttonGrid[i][j].addActionListener(this);
        //         tempButton.setSize(new Dimension(25,25));
                 buttonPanel.add(buttonGrid[i][j]);
             }
         }
        

        
        containerPanel.add(buttonPanel);
        this.frame.getContentPane().add(containerPanel);

        
    }


    public void actionPerformed(ActionEvent e){
        for(int i = 0; i < this.nSize; i++){
            for(int j = 0; j < this.nSize; j++){
                if(this.buttonGrid[i][j] == e.getSource()){
                    String tileValue = String.valueOf(this.playingField.getTile(i, j));
                    this.buttonGrid[i][j].setText(tileValue);

                    if(tileValue.equals("M")){
                        JOptionPane.showMessageDialog(this.frame, "BOOM!", "You hit a mine! Gameover.",0);
                        System.exit(0);
                    }
                }
            }
        }

    
    }

}


