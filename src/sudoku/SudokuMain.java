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
    int levelGame=1;
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
    private ImageIcon bgsudoku;
    private JLabel bgLabel;
    JPanel container = new JPanel();
    JMenuBar difficulty;
    JMenu diffmenu;
    JMenuItem easy, medium, hard;
//    JButton easy = new JButton("Easy");
//    JButton medium = new JButton("Medium");
//    JButton hard = new JButton("Hard");
    // Constructor
    public SudokuMain() {
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLayout(null);

        bgsudoku = new ImageIcon("Assets/bgsudoku.jpg");
        bgLabel = new JLabel(bgsudoku);

        bgLabel.setBounds(0,0,screenWidth,screenHeight);
        container.setOpaque(false);
        container.setBounds(screenWidth/2-350,20,700,800);
        frame.add(container);
        frame.add(bgLabel);

        difficulty = new JMenuBar();

        // create a menu
        diffmenu = new JMenu("  Select Difficulty Level  ");

        // create menuitems
        easy = new JMenuItem("Easy");
        medium = new JMenuItem("Medium");
        hard = new JMenuItem("Hard");

        // add menu items to menu
        diffmenu.add(easy);
        diffmenu.add(medium);
        diffmenu.add(hard);

        // add menu to menu bar
        difficulty.add(diffmenu);
        difficulty.setPreferredSize(new Dimension(150,40));
        easy.setPreferredSize(new Dimension(150,20));
        medium.setPreferredSize(new Dimension(150,20));
        hard.setPreferredSize(new Dimension(150,20));

        // add menubar to frame
        buttonPanel.add(difficulty);

        container.setLayout(new BorderLayout());
        sudokuPanel.add(board);
        sudokuPanel.setOpaque(false);
        container.add(sudokuPanel, BorderLayout.CENTER);
        // Add a button to the south to re-start the game via board.newGame()
        buttonPanel.setLayout(new FlowLayout(FlowLayout.LEFT,30,10));
        container.add(buttonPanel,BorderLayout.SOUTH);
        buttonPanel.add(btnNewGame);
        buttonPanel.add(btnSolve);
        buttonPanel.setOpaque(false);
        buttonPanel.setPreferredSize(new Dimension(700,80));
        btnNewGame.setPreferredSize(new Dimension(200,40));
        btnSolve.setPreferredSize(new Dimension(200,40));
        btnSolve.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                board.solve();
            }
        });
        btnNewGame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                board.newGame(levelGame);}
        });
        easy.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                levelGame=1;
                board.newGame(levelGame);
            }
        });
        medium.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                levelGame=2;
                board.newGame(levelGame);
            }
        });
        hard.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                levelGame=3;
                board.newGame(levelGame);
            }
        });
        // Initialize the game board to start the game
        board.newGame(levelGame);

        // Pack the UI components, instead of using setSize()
        frame.setLocationRelativeTo(null);
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