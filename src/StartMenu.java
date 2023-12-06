import sudoku.SudokuMain;
import tictactoe.TTTGraphics;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.*;

public class StartMenu extends JFrame {
    public static void main(String[] args) {
        int width = 800;
        int height = 600;
        int buttonWidth = 220;
        int buttonHeight = 50;




        JFrame frame = new JFrame("Start Menu"); // Set the title for the JFrame
        JButton buttonSudoku = new JButton("Sudoku");
        JButton buttonTicTacToe = new JButton("TicTacToe");
        ImageIcon icon = new ImageIcon("logo.png");
        frame.setIconImage(icon.getImage());
        buttonSudoku.setBounds((width * 3 / 4) - (buttonWidth/2), (height / 2) - (buttonHeight/2), buttonWidth, buttonHeight);
        buttonTicTacToe.setBounds((width / 4) - (buttonWidth/2), (height / 2) - (buttonHeight/2), buttonWidth, buttonHeight);
        buttonSudoku.setBorder(new RoundedBorder(50));
        buttonTicTacToe.setBorder(new RoundedBorder(50));
        buttonSudoku.setForeground(Color.RED);
        buttonTicTacToe.setForeground(Color.RED);
        frame.add(buttonSudoku); // Adding button to JFrame
        frame.add(buttonTicTacToe); // Adding button to JFrame

        frame.setSize(width, height); // Set the size of the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Set default close operation
        frame.setLayout(null); // Using no layout manager
        frame.setVisible(true); // Making the frame visible

        buttonSudoku.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        new SudokuMain();
                    }
                });
            }
        });
        buttonTicTacToe.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        new TTTGraphics();
                    }
                });
            }
        });
    }


}


class RoundedBorder implements Border {
    private int radius;
    RoundedBorder(int radius) {
        this.radius = radius;
    }
    public Insets getBorderInsets(Component c) {
        return new Insets(this.radius + 1, this.radius + 1, this.radius + 2, this.radius);
    }
    public boolean isBorderOpaque() {
        return true;
    }
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        g.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
    }
}