import sudoku.SudokuMain;
import tictactoe.StopwatchLabel;
import tictactoe.TTTGraphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class StartMenu extends JFrame {

    public static void main(String[] args) throws IOException {

        JFrame frame = new JFrame("Start Menu");

        frame.setSize(800,600);
//        frame.setExtendedState(MAXIMIZED_BOTH);
//        frame.setUndecorated(true);

        int buttonHeight = 75;
        int buttonWidth = 300;
        int exitButtonHeight = 50;
        int exitButtonWidth = 50;

        ImageIcon logo = new ImageIcon("Assets/logo.png");

        BufferedImage bgImage = ImageIO.read(new File("Assets/backgroundimage.png"));
        Image scaledBgImage = bgImage.getScaledInstance(frame.getWidth(), frame.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon backgroundImage = new ImageIcon(scaledBgImage);
        JLabel background = new JLabel(backgroundImage);
        background.setIcon(backgroundImage);
        background.setHorizontalAlignment(JLabel.CENTER);

        BufferedImage sudokuIcon = ImageIO.read(new File("Assets/sudokuButton.png"));
        Image sudokuImage = sudokuIcon.getScaledInstance(buttonWidth, buttonHeight, Image.SCALE_SMOOTH);
        ImageIcon scaledSudokuIcon = new ImageIcon(sudokuImage);

        BufferedImage ticTacToeIcon = ImageIO.read(new File("Assets/ticTacToeButton.png"));
        Image ticTacToeImage = ticTacToeIcon.getScaledInstance(buttonWidth, buttonHeight, Image.SCALE_SMOOTH);
        ImageIcon scaledTicTacToeIcon = new ImageIcon(ticTacToeImage);

        JButton exitButton = new JButton("X");


        JLabel sudokuButton = new JLabel(scaledSudokuIcon);
        JLabel ticTacToeButton = new JLabel(scaledTicTacToeIcon);
        JLabel logoImage = new JLabel();
        logoImage.setIcon(logo);
        logoImage.setHorizontalAlignment(JLabel.CENTER);

        StopwatchLabel stopwatch = new StopwatchLabel();


        exitButton.setBackground(new Color(220,53,69));
        exitButton.setForeground(Color.WHITE);
        sudokuButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                SwingUtilities.invokeLater(() -> new SudokuMain());
            }
        });

        ticTacToeButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                SwingUtilities.invokeLater(() -> new TTTGraphics());
            }
        });

        frame.addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent componentEvent) {
                Dimension size = frame.getSize();
                int width = (int) size.getWidth();
                int height = (int) size.getHeight();

                background.setBounds(0, 0, width, height);
                sudokuButton.setBounds((width * 3 / 4) - (buttonWidth / 2), (height * 3 / 4) - (buttonHeight / 2), buttonWidth, buttonHeight);
                ticTacToeButton.setBounds((width / 4) - (buttonWidth / 2), (height * 3 / 4) - (buttonHeight / 2), buttonWidth, buttonHeight);
                logoImage.setBounds((width / 2) - (logo.getIconWidth() / 2), 10, logo.getIconWidth(), logo.getIconHeight());
                exitButton.setBounds(width / 8 - (exitButtonWidth /2 ), (height / 8) - (exitButtonHeight /2 ), exitButtonWidth,exitButtonHeight);
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - frame.getWidth()) / 2, (Toolkit.getDefaultToolkit().getScreenSize().height - frame.getHeight()) / 2);

        frame.add(stopwatch);
        frame.add(exitButton);
        frame.add(logoImage);
        frame.add(sudokuButton);
        frame.add(ticTacToeButton);
        frame.add(background);

        frame.setLayout(null);
        frame.setVisible(true);
    }
}
