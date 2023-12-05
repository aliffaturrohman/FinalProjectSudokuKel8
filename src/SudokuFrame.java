import java.awt.*;
import javax.swing.*;
public class SudokuFrame extends JFrame {
     public SudokuFrame(){
         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         this.setTitle("Game Sudoku Kelompok 8");
         this.setMinimumSize( new Dimension(600,800));

         JMenuBar menuBar = new JMenuBar();
         JMenu file = new JMenu("Game");
         JMenu newGame = new JMenu("New Game");
         JMenuItem sixBySixGame = new JMenuItem("6 By 6 Game");
         JMenuItem nineByNineGame = new JMenuItem("9 By 9 Game");


         file.add(newGame);
         menuBar.add(file);
         this.setJMenuBar(menuBar);

     }
}
