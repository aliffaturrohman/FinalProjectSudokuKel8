package sudoku;
import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * The main Sudoku program
 */
public class SudokuMain {
    private static final long serialVersionUID = 1L;  // to prevent serial warning
    static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    static int screenHeight = screenSize.height;
    int screenWidth = screenSize.width;

    // private variables
    private String BACKGROUND_IMAGE_URL = "Assets/bgtictactoe.jpg";
    JFrame frame = new JFrame();
    GameBoardPanel board = new GameBoardPanel();
    JPanel sudokuPanel = new JPanel();
    JButton btnNewGame = new JButton("New Game");
    JPanel buttonPanel = new JPanel();
    JButton btnSolve = new JButton("Solve");


    // Constructor
    public SudokuMain() {

        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLayout(new BorderLayout());
        sudokuPanel.add(board);
        frame.add(sudokuPanel, BorderLayout.CENTER);
        // Add a button to the south to re-start the game via board.newGame()
        buttonPanel.setLayout(new FlowLayout());
        frame.add(buttonPanel,BorderLayout.SOUTH);
        buttonPanel.add(btnNewGame);
        buttonPanel.add(btnSolve);
        buttonPanel.setPreferredSize(new Dimension(700,80));
        btnNewGame.setPreferredSize(new Dimension(200,40));
        btnSolve.setPreferredSize(new Dimension(200,40));
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
        frame.setMinimumSize(new Dimension(700, 700));
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