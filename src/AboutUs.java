import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class AboutUs {
    private static final long serialVersionUID = 1L;

    public AboutUs() throws IOException {
        JPanel name = new JPanel();

        // Create JLabels for each developer
        JLabel developer1Label = new JLabel("Muhamad Arif S\n (5026221104)");
        JLabel developer2Label = new JLabel("Alif faturrohman\n (50262211040)");
        JLabel developer3Label = new JLabel("Zikrul Khalis\n (5026221132)");

        // Load and set images for each developer
        BufferedImage developerPhoto = ImageIO.read(new File("Assets/Devphoto.jpg"));
        Image scaledDevphoto = developerPhoto.getScaledInstance(1000, 600, Image.SCALE_SMOOTH);
        ImageIcon Devphoto = new ImageIcon(scaledDevphoto);
        JLabel photo = new JLabel(Devphoto);

        // Set font for developer names
        Font developerFont = new Font("Arial", Font.BOLD, 16);
        developer1Label.setFont(developerFont);
        developer2Label.setFont(developerFont);
        developer3Label.setFont(developerFont);

        // Add components to the panel
        name.setLayout(new FlowLayout(FlowLayout.CENTER,20,10));
        name.add(developer3Label);
        name.add(developer2Label);
        name.add(developer1Label);

        JFrame frame = new JFrame("About Us");
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 650);
        frame.add(photo);
        frame.add(name,BorderLayout.SOUTH);
        frame.setVisible(true);

    }
}
