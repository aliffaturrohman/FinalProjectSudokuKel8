package sudoku;

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

        // Copy from hardcodedNumbers into the array "numbers"
        for (int row = 0; row < GRID_SIZE; ++row) {
            for (int col = 0; col < GRID_SIZE; ++col) {
                numbers[row][col] = hardcodedNumbers[row][col];
            }
        }

        // Need to use input parameter cellsToGuess!
        // Hardcoded for testing, only 2 cells of "8" is NOT GIVEN
        int levelchosen = 0;
        if (levelGame==1){
        levelchosen = getRandomNumber(25, 40);}
        int falselimit = 0;
            for (int row = 0; row < GRID_SIZE; ++row) {
                int rowfalselimit = 0;
                for (int col = 0; col < GRID_SIZE; ++col) {
                    int remove = getRandomNumber(0,3);
                    if (remove == 0 && falselimit < levelchosen && rowfalselimit < 6) {
                        isGiven[row][col] = false;
                        falselimit = falselimit + 1;
                        rowfalselimit = rowfalselimit + 1;
                    } else {
                        isGiven[row][col] = true;
                    }
                }
            }
    }
    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
