/**
 * ES234317-Algorithm and Data Structures
 * Semester Ganjil, 2023/2024
 * Group Capstone Project
 * Group #8
 * 1 - 5026221040 - Alif Faturrohman
 * 2 - 5026221104- Muhamad Arif Satriyo
 * 3 - 5026221132 - Zikrul Khalis
 */
import sudoku.SudokuMain;
import tictactoe.TTTGraphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;


import javax.imageio.ImageIO;

public class StartMenu extends JFrame {

    public static void main(String[] args) throws Exception {

        JFrame frame = new JFrame("Sudoku and Tictactoe Kelompok 8");
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setMinimumSize(new Dimension(800,700));

        int buttonHeight = 75;
        int buttonWidth = 300;
        int exitButtonHeight = 50;
        int exitButtonWidth = 50;

        ImageIcon logo = new ImageIcon("Assets/logo.png");

        BufferedImage bgImage = ImageIO.read(new File("Assets/backgroundimage.png"));
        Image scaledBgImage = bgImage.getScaledInstance(screenSize.width, screenSize.height, Image.SCALE_SMOOTH);
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

        JLabel textCopyright = new JLabel("Dibuat oleh Kelompok 8: Alif Faturrohman(5026221040), Muhamad Arif Satriyo(5026221104), Zikrul Khalis(5026221132)");
        textCopyright.setFont(new Font("Arial", Font.PLAIN, 20));
        textCopyright.setForeground(Color.WHITE);
        textCopyright.setBackground(Color.DARK_GRAY);
        textCopyright.setOpaque(true);

        exitButton.setBackground(new Color(220,53,69));
        exitButton.setFont(new Font("Arial",Font.PLAIN,20));
        exitButton.setBorderPainted(false);
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
                Dimension textCopyrightSize = textCopyright.getPreferredSize();
                int width = (int) size.getWidth();
                int height = (int) size.getHeight();

                background.setBounds(0, 0, width, height);
                sudokuButton.setBounds((width * 3 / 4) - (buttonWidth / 2), (height * 3 / 4) - (buttonHeight / 2), buttonWidth, buttonHeight);
                ticTacToeButton.setBounds((width / 4) - (buttonWidth / 2), (height * 3 / 4) - (buttonHeight / 2), buttonWidth, buttonHeight);
                logoImage.setBounds((width / 2) - (logo.getIconWidth() / 2), 10, logo.getIconWidth(), logo.getIconHeight());
                exitButton.setBounds(width / 8 - (exitButtonWidth /2 ), (height / 8) - (exitButtonHeight /2 ), exitButtonWidth,exitButtonHeight);
                textCopyright.setBounds((width - textCopyrightSize.width ) / 2, height * 7 /8, textCopyrightSize.width, textCopyrightSize.height);
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        LoopSound loopSound = new LoopSound("Assets/lagu game.wav");
        loopSound.play();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - frame.getWidth()) / 2, (Toolkit.getDefaultToolkit().getScreenSize().height - frame.getHeight()) / 2);

        frame.add(textCopyright);
        frame.add(exitButton);
        frame.add(logoImage);
        frame.add(sudokuButton);
        frame.add(ticTacToeButton);
        frame.add(background);

        frame.setLayout(null);
        frame.setVisible(true);
    }
}

