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
    JPanel buttonPanel = new JPanel();
    JLabel score = new JLabel("Score: "+board.getScore());
    JButton btnSolve = new JButton("Solve");

    // Constructor
    public SudokuMain() {
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLayout(new BorderLayout());
        scorebox.setSize(100,50);
        score.setFont(new Font("Arial",Font.PLAIN,25));
        scorebox.add(score);
        frame.add(scorebox,BorderLayout.NORTH);
        sudokuPanel.add(board);
        frame.add(sudokuPanel, BorderLayout.CENTER);
        
        // Add a button to the south to re-start the game via board.newGame()
        buttonPanel.setLayout(new FlowLayout());
        frame.add(buttonPanel,BorderLayout.SOUTH);
        buttonPanel.add(btnNewGame);
        buttonPanel.add(btnSolve);
        btnNewGame.setPreferredSize(new Dimension(200,50));
        btnSolve.setPreferredSize(new Dimension(200,50));
        btnSolve.addActionListener(new ActionListener() {

            // Override the actionPerformed() method
            public void actionPerformed(ActionEvent e){

                board.solve();
            }

        });
        btnNewGame.addActionListener(new ActionListener() {

            // Override the actionPerformed() method
            public void actionPerformed(ActionEvent e){
                board.newGame();
            }

        });
        // Initialize the game board to start the game
        board.newGame();


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