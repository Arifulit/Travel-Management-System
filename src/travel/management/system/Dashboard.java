//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class Dashboard extends JFrame {
//    
//    // Constructor to set up the GUI
//    public Dashboard() {
//        // Set up the frame
//        setTitle("Tourism Management System");
//        setSize(900, 600);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setLocationRelativeTo(null);
//
//        // Create the main panel with a BorderLayout
//        JPanel mainPanel = new JPanel(new BorderLayout());
//
//        // Create the sidebar menu
//        JPanel sidebar = new JPanel();
//        sidebar.setBackground(Color.BLUE);
//        sidebar.setLayout(new GridLayout(15, 1, 5, 5)); // 15 items, spacing of 5 pixels
//        sidebar.setPreferredSize(new Dimension(200, getHeight()));
//
//        // Menu buttons
//        String[] menuItems = {
//            "Add Personal Details", "Update Personal Details", "View Customer", "Check Package",
//            "Book Package", "View Package", "Check Hotels", "Book Hotel",
//            "View Booked Hotel", "Destination", "Payment Gateway", "Delete All Details",
//            "About Us", "Logout"
//        };
//
//        for (String item : menuItems) {
//            JButton button = new JButton(item);
//            button.setBackground(Color.WHITE);
//            button.setForeground(Color.BLACK);
//            sidebar.add(button);
//        }
//
//        // Add the sidebar to the main panel
//        mainPanel.add(sidebar, BorderLayout.WEST);
//
//        // Create a main display area (for the right side)
//        JLabel displayArea = new JLabel(new ImageIcon("tourism-background.jpg")); // Change to your image path
//        displayArea.setHorizontalAlignment(JLabel.CENTER);
//        displayArea.setFont(new Font("Arial", Font.BOLD, 24));
//        displayArea.setForeground(Color.WHITE);
//        displayArea.setText("Tourism Management System");
//        displayArea.setVerticalTextPosition(JLabel.TOP);
//        displayArea.setHorizontalTextPosition(JLabel.CENTER);
//
//        // Add the display area to the main panel
//        mainPanel.add(displayArea, BorderLayout.CENTER);
//
//        // Add the main panel to the frame
//        add(mainPanel);
//
//        // Make the frame visible
//        setVisible(true);
//    }
//
//    // Main method to run the GUI
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                new Dashboard();
//            }
//        });
//    }
//}
