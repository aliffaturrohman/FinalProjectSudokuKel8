package sudoku;

import java.util.Arrays;
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
        // I hardcode a puzzle here for illustration and testing.
        int[][] hardcodedNumbers =
                {{5, 3, 4, 6, 7, 8, 9, 1, 2},
                        {6, 7, 2, 1, 9, 5, 3, 4, 8},
                        {1, 9, 8, 3, 4, 2, 5, 6, 7},
                        {8, 5, 9, 7, 6, 1, 4, 2, 3},
                        {4, 2, 6, 8, 5, 3, 7, 9, 1},
                        {7, 1, 3, 9, 2, 4, 8, 5, 6},
                        {9, 6, 1, 5, 3, 7, 2, 8, 4},
                        {2, 8, 7, 4, 1, 9, 6, 3, 5},
                        {3, 4, 5, 2, 8, 6, 1, 7, 9}};

        // swap number from hardcodednumbers
        int swap = 10; //swap antar angka sebanyak 3 kali
        for (int i=0;i<swap;i++) {
            int targetswap1 = getRandomNumber(1,9);
            int targetswap2 = getRandomNumber(1,9);
            for (int row = 0; row < GRID_SIZE; ++row) {
                for (int col = 0; col < GRID_SIZE; ++col) {
                    if (hardcodedNumbers[row][col]==targetswap1){numbers[row][col]=targetswap2;}
                    else if (hardcodedNumbers[row][col]==targetswap2){numbers[row][col]=targetswap1;}
                    else {numbers[row][col]=hardcodedNumbers[row][col];}
                }
            }
            hardcodedNumbers=numbers;
            //hardcodedNumbers diperbarui agar swap angka berikutnya sesuai dengan numbers yang baru
        }

        int falselimit = 0;
        int rowcolfalselimit=0;
        if (levelGame==1){
            falselimit = getRandomNumber(35,40);
            rowcolfalselimit = 4;
        }
        else if (levelGame==2){
            falselimit = getRandomNumber(45,50);
            rowcolfalselimit = 6;
        }
        else if (levelGame==3){
            falselimit = getRandomNumber(55,60);
            rowcolfalselimit = 7;
        }
        int falsecount = 0;
        int[] columnlimit = new int[9];
        int[] rowlimit = new int[9];

        //array boolean secara default menyimpan false
        //set array boolean menjadi true

            for (int row=0;row<GRID_SIZE;row++){
                for (int col=0;col<GRID_SIZE;col++){
                    int randomnumber = getRandomNumber(1,2);
                    if (randomnumber==1 && falsecount<falselimit && columnlimit[col]<rowcolfalselimit && rowlimit[row]<rowcolfalselimit) {
                        isGiven[row][col] = false;
                        falsecount+=1;
                        columnlimit[col]+=1;
                        rowlimit[row]+=1;
                    } else {
                        isGiven[row][col] = true;
                        }
                    }
            }
            if (falsecount<falselimit){
                for (int row=GRID_SIZE-1;row>0;row--){
                        for (int col=GRID_SIZE-1;col>0;col--){
                            int randomnumber = getRandomNumber(1,2);
                            if (randomnumber==1 && falsecount<falselimit && columnlimit[col]<rowcolfalselimit && rowlimit[row]<rowcolfalselimit) {
                                isGiven[row][col] = false;
                                falsecount+=1;
                                columnlimit[col]+=1;
                                rowlimit[row]+=1;
                            }
                        }
                }
            }
    }
    public int getRandomNumber(int min, int max) {
        Random random = new Random();
        int randnum = random.nextInt(max)+min;
        return randnum;
    }

}