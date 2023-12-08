import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class test {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(new Dimension(600,800));
        StopwatchLabel stopwatch = new StopwatchLabel();
        stopwatch.setAlignmentX(Component.CENTER_ALIGNMENT);
        frame.addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent componentEvent) {
                Dimension size = frame.getSize();
                int width = (int) size.getWidth();
                int height = (int) size.getHeight();



            }
        });
        frame.add(stopwatch);
        frame.setVisible(true);
    }
}
