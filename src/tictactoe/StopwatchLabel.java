/**
 * ES234317-Algorithm and Data Structures
 * Semester Ganjil, 2023/2024
 * Group Capstone Project
 * Group #8
 * 1 - 5026221040 - Alif Faturrohman
 * 2 - 5026221104- Muhamad Arif Satriyo
 * 3 - 5026221132 - Zikrul Khalis
 */
package tictactoe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StopwatchLabel extends JLabel {

    public long startTime = System.currentTimeMillis();
    private long stopTime;
    private Timer timer;

    public StopwatchLabel() {
        setFont(new Font("Arial", Font.PLAIN, 24));
        setForeground(Color.BLACK);
        timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateTime();
            }
        });
        timer.start();
    }

    public void updateTime() {
        long timeGoesOn = System.currentTimeMillis() - startTime;
        String timeString = String.format("%02d:%02d", timeGoesOn % 3600000 / 1000 / 60, (timeGoesOn % 60000) / 1000);
        setText(timeString);
    }

    public void stopTimer() {
        timer.stop();
        stopTime = System.currentTimeMillis();
    }

    public void resetTimer() {
        startTime = System.currentTimeMillis();
        stopTime = 0;
        timer.restart();
        updateTime();
    }

    public long getTime() {
        return stopTime - startTime;
    }
}
