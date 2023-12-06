import sudoku.SudokuMain;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class SudokuMenuBar extends JFrame {
    public SudokuMenuBar(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Game Sudoku Kelompok 8");
        this.setMinimumSize( new Dimension(600,800));

        JMenuBar menuBar = new JMenuBar();
        JMenu file = new JMenu("Game");
        JMenu newGame = new JMenu("New Game");

        JMenuItem sixBySixGame = new JMenuItem("6 By 6 Game");
        JMenuItem nineByNineGame = new JMenuItem("9 By 9 Game");

        newGame.add(sixBySixGame);
        newGame.add(nineByNineGame);

        nineByNineGame.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        new SudokuMain();
                    }
                });
            }
        });

        file.add(newGame);
        menuBar.add(file);
        this.setJMenuBar(menuBar);

    }
}
