package tictactoe;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class StopwatchLabel extends JLabel {

    private long startTime = System.currentTimeMillis();

    public StopwatchLabel() {
        setFont(new Font("Arial", Font.PLAIN, 24));
        setForeground(Color.BLACK);
        new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateTime();
            }
        }).start();
    }

    public void updateTime() {
        long timeGoesOn = System.currentTimeMillis() - startTime;
        String timeString = String.format("%02d:%02d",(timeGoesOn % 3600000) /1000/60,(timeGoesOn % 60000) /1000);
        setText(timeString);
    }
}