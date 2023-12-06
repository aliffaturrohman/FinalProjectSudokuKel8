package tictactoe;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class TictactoeMain {
    public static void main(String[] args) {
        // Run GUI codes in the Event-Dispatching thread for thread safety
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TTTGraphics(); // Let the constructor do the job
            }
        });
    }
}
