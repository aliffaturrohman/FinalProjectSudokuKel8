package sudoku;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
/**
 * The main Sudoku program
 */
public class SudokuMain extends JFrame {
    private static final long serialVersionUID = 1L;  // to prevent serial warning

    // private variables
    GameBoardPanel board = new GameBoardPanel();
    JPanel sudokuPanel = new JPanel();
    JButton btnNewGame = new JButton("New Game");

    // Constructor
    public SudokuMain() {
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(new FlowLayout(FlowLayout.LEFT,250,50));
        sudokuPanel.add(board);
        add(sudokuPanel);
//        Container cp = getContentPane();
//        cp.setLayout(new BorderLayout());;
//        cp.add(board, BorderLayout.CENTER);

        // Add a button to the south to re-start the game via board.newGame()
        add(btnNewGame);
        btnNewGame.addActionListener(new ActionListener() {

            // Override the actionPerformed() method
            public void actionPerformed(ActionEvent e){
                board.newGame();
            }

        });
        // Initialize the game board to start the game
        board.newGame();

        // Pack the UI components, instead of using setSize()
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);  // to handle window-closing
        setTitle("Sudoku");
        setMinimumSize(new Dimension(500, 520));
        setVisible(true);
    }

    /** The entry main() entry method */
    public static void main(String[] args) {
        // [TODO 1] Check "Swing program template" on how to run
        //  the constructor of "SudokuMain"
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new SudokuMain();
            }
        });
    }
}