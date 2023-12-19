import javax.swing.*;
import java.awt.*;

public class AboutUs extends JPanel {
    private static final long serialVersionUID = 1L;

    public AboutUs() {
        setLayout(new BorderLayout());

        // Create JLabels for each developer
        JLabel developer1Label = new JLabel("Muhammad Arif Satriyo\n (5026221138)");
        JLabel developer2Label = new JLabel("Alif faturrohman\n (50262211040)");
        JLabel developer3Label = new JLabel("Zikrul Khalis\n (5026221132)");

        // Load and set images for each developer
        ImageIcon developer1Image = new ImageIcon("Assets/harimau.png"); // Replace with actual file name
        ImageIcon developer2Image = new ImageIcon("Assets/harimau.png"); // Replace with actual file name
        ImageIcon developer3Image = new ImageIcon("Assets/harimau.png"); // Replace with actual file name
        JLabel developer1Photo = new JLabel(developer1Image);
        JLabel developer2Photo = new JLabel(developer2Image);
        JLabel developer3Photo = new JLabel(developer3Image);

        // Set font for developer names
        Font developerFont = new Font("Arial", Font.BOLD, 16);
        developer1Label.setFont(developerFont);
        developer2Label.setFont(developerFont);
        developer3Label.setFont(developerFont);

        // Set layout for the panel
        setLayout(new GridLayout(3, 1, 10, 10));

        // Add components to the panel
        add(developer1Label);
        add(developer1Photo);
        add(developer2Label);
        add(developer2Photo);
        add(developer3Label);
        add(developer3Photo);
    }

    public static void main(String[] args) {
        // Test the AboutUsPanel
        JFrame frame = new JFrame("About Us");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 600);
        frame.setContentPane(new AboutUs());
        frame.setVisible(true);
    }
}
