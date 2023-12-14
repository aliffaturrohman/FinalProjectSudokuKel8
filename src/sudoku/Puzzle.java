package sudoku;

import java.util.Random;

public class Puzzle {
    // All variables have package access
    // The numbers on the puzzle
    public static final int GRID_SIZE = 9;
    public static final int SUBGRID_SIZE = 3;
    int[][] numbers = new int[GRID_SIZE][GRID_SIZE];
    // The clues - isGiven (no need to guess) or need to guess
    boolean[][] isGiven = new boolean[GRID_SIZE][GRID_SIZE];
    // Constructor
    public Puzzle() {
        super();
    }

    // Generate a new puzzle given the number of cells to be guessed, which can be used
    //  to control the difficulty level.
    // This method shall set (or update) the arrays numbers and isGiven

    public void newPuzzle(int levelGame) {
        numbers = new int[GRID_SIZE][GRID_SIZE];
        int givenlimit = 0;
        int rowcolgivenlimit=0;
        if (levelGame==1){
            givenlimit = getRandomNumber(50,5);
            rowcolgivenlimit = 8;
        }
        else if (levelGame==2){
            givenlimit = getRandomNumber(35,10);
            rowcolgivenlimit = 6;
        }
        else if (levelGame==3){
            givenlimit = getRandomNumber(20,5);
            rowcolgivenlimit = 4;
        }
        int givencount = 0;
        int[] columnlimit = new int[9];
        int[] rowlimit = new int[9];
        System.out.println(givenlimit);
        while (givencount<givenlimit){
            int ranrow= getRandomNumber(0,9);
            int rancol = getRandomNumber(0,9);
            int ranvalue = getRandomNumber(1,9);
            if (numbers[ranrow][rancol]==0){
                if(validValue(ranrow,rancol,ranvalue)){
                    if (columnlimit[rancol]<=rowcolgivenlimit && rowlimit[ranrow]<=rowcolgivenlimit) {
                        numbers[ranrow][rancol] = ranvalue;
                        givencount += 1;
                    }
                }
            }
        }
        for (int i=0;i<9;i++){
            for (int j=0;j<9;j++){
                if (numbers[i][j]==0)isGiven[i][j] = false;
                else isGiven[i][j]=true;}
        }
    }
    public int getRandomNumber(int min, int max) {
        Random random = new Random();
        int randnum = random.nextInt(max)+min;
        return randnum;
    }
    public boolean validValue(int row, int col, int value) {
        boolean valid = true;
        for (int i=0;i<GRID_SIZE;i++){
            if (numbers[i][col]==value) {
                valid=false;
                break;
            }
        }
        for (int i=0;i<GRID_SIZE;i++){
            if (numbers[row][i]==value) {
                valid = false;
                break;
            }
        }
        int subgridrow = row/3;
        int subgridcol = col/3;
        for (int i=0;i<SUBGRID_SIZE;i++){
            for (int j=0;j<SUBGRID_SIZE;j++){
                if (numbers[subgridrow+i][subgridcol+1]==value){
                    valid=false;
                    break;
                }
            }
        }
        return valid;
    }
}