package sudoku;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
/**
 * The main Sudoku program
 */
public class SudokuMain {
    private static final long serialVersionUID = 1L;  // to prevent serial warning

    // private variables
    JFrame frame = new JFrame();
    GameBoardPanel board = new GameBoardPanel();
    JPanel sudokuPanel = new JPanel();
    JButton btnNewGame = new JButton("New Game");
    JPanel scorebox = new JPanel();

    JLabel score = new JLabel("Score: "+board.getScore());

    // Constructor
    public SudokuMain() {
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLayout(new BoxLayout(frame.getContentPane(),BoxLayout.PAGE_AXIS));
        scorebox.setSize(100,50);
        score.setFont(new Font("Arial",Font.PLAIN,25));
        scorebox.add(score);
        frame.add(scorebox);
        sudokuPanel.add(board);
        frame.add(sudokuPanel);
        
        // Add a button to the south to re-start the game via board.newGame()
        frame.add(btnNewGame);
        btnNewGame.addActionListener(new ActionListener() {

            // Override the actionPerformed() method
            public void actionPerformed(ActionEvent e){
                board.newGame();
            }

        });
        // Initialize the game board to start the game
        board.newGame();
        btnNewGame.setAlignmentX(Component.CENTER_ALIGNMENT);


        // Pack the UI components, instead of using setSize()
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);  // to handle window-closing
        frame.setTitle("Sudoku");
        frame.setMinimumSize(new Dimension(500, 520));
        frame.setVisible(true);
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