import java.util.Random;

public class Game {

    private int numMines;
    private int nSize;
    private char[][] field;

    Game(int numberMines, int boardSize){

        this.numMines = numberMines;
        this.nSize = boardSize;
        
        // Initialize the playing field array to be all 0 tiles
        field = new char[boardSize][boardSize];
        for(int i = 0; i <nSize; i++){
            for(int j = 0; j < nSize; j++){
                field[i][j] = '0';
            }
        }

    }

    public void generateField(){
        placeMines();
        generateTileNumbers();

    }

    private void placeMines(){
        int temp = this.numMines;

        // Create the random object
        Random rand = new Random();

        // We want to keep generating random index pairs to place mines until we
        // placed our target number of mines
        while(temp>0){

            // Generate a number between 0 and nSize-1
            int i = rand.nextInt(this.nSize);
            int j = rand.nextInt(this.nSize);
            
            // Check if we have already placed a mine at this location
            if(this.field[i][j]=='M'){
                continue;
            }
            else{
                this.field[i][j] = 'M';
                temp--;
            }

        }
    }

    private void generateTileNumbers(){

        for(int i = 0; i <nSize; i++){
            for(int j = 0; j < nSize; j++){
                this.field[i][j] = calcTileValue(i, j);
            }
        }


    }

    private char calcTileValue(int i, int j){
        char numMines = '0';
        
        // If the tile is a mine, no calculations needed
        if(this.field[i][j] == 'M'){
            return 'M';
        } 
        
        for(int a = -1; a < 2; a++){

            if((a+i) <0 || (a+i)>(this.nSize-1)){
                continue;
            }

            for(int b = -1; b <2; b++){

                if((b+j) <0 || (b+j)>(this.nSize-1)){
                    continue;
                }

                if(this.field[a+i][b+j] == 'M'){
                    numMines++;
                }



            }
        }

        return numMines;
    }

    public char getTile(int i, int j){
        return this.field[i][j];
    }

    

    
}
