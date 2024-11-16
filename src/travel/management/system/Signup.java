package travel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.border.*;

public class Signup extends JFrame implements ActionListener {

    private JPanel contentPane;
    private JTextField nameField;    // Name field
    private JTextField emailField;   // Email field
    private JPasswordField passwordField; // Password field
    private JButton createButton, backButton;

    public static void main(String[] args) {
        new Signup().setVisible(true);
    }

    public Signup() {
        setTitle("Create Account");
        setBounds(600, 250, 700, 406);
        
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setBackground(Color.WHITE);
        contentPane.setLayout(null);

        // Create Title Label
        JLabel titleLabel = new JLabel("Create Your Account");
        titleLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
        titleLabel.setForeground(new Color(34, 139, 34));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBounds(150, 30, 400, 40);
        contentPane.add(titleLabel);

        // Labels for fields
        JLabel lblName = new JLabel("Name:");
        lblName.setForeground(Color.DARK_GRAY);
        lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblName.setBounds(99, 86, 92, 26);
        contentPane.add(lblName);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setForeground(Color.DARK_GRAY);
        lblEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblEmail.setBounds(99, 123, 92, 26);
        contentPane.add(lblEmail);

        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setForeground(Color.DARK_GRAY);
        lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblPassword.setBounds(99, 160, 92, 26);
        contentPane.add(lblPassword);

        // Input fields for Name, Email, and Password
        nameField = new JTextField();
        nameField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        nameField.setBounds(265, 91, 148, 25);
        contentPane.add(nameField);

        emailField = new JTextField();
        emailField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        emailField.setBounds(265, 128, 148, 25);
        contentPane.add(emailField);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        passwordField.setBounds(265, 165, 148, 25);
        contentPane.add(passwordField);

        // Create button to submit form
        createButton = new JButton("Create");
        createButton.addActionListener(this);
        createButton.setFont(new Font("Tahoma", Font.BOLD, 13));
        createButton.setBackground(new Color(34, 139, 34));
        createButton.setForeground(Color.WHITE);
        createButton.setBounds(140, 289, 100, 30);
        contentPane.add(createButton);

        // Back button to return to Login screen
        backButton = new JButton("Back");
        backButton.addActionListener(this);
        backButton.setFont(new Font("Tahoma", Font.BOLD, 13));
        backButton.setBackground(new Color(255, 69, 0));
        backButton.setForeground(Color.WHITE);
        backButton.setBounds(300, 289, 100, 30);
        contentPane.add(backButton);

        // Panel to group fields within a border
        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(
                new LineBorder(new Color(34, 139, 34), 2), 
                "Create Account", 
                TitledBorder.LEADING, 
                TitledBorder.TOP, 
                null, 
                new Color(34, 139, 34)
        ));
        panel.setBounds(31, 80, 640, 210);
        panel.setBackground(Color.WHITE);
        contentPane.add(panel);
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            Conn con = new Conn();  // Database connection

            if (ae.getSource() == createButton) {
                String sql = "INSERT INTO account(name, email, password) VALUES (?, ?, ?)";
                PreparedStatement st = con.c.prepareStatement(sql);

                // Map the input fields to the SQL query
                st.setString(1, nameField.getText());     // Name
                st.setString(2, emailField.getText());    // Email
                st.setString(3, String.valueOf(passwordField.getPassword())); // Password

                // Execute the query
                int i = st.executeUpdate();
                if (i > 0) {
                    JOptionPane.showMessageDialog(null, "Account Created Successfully");
                }

                // Clear input fields after insertion
                nameField.setText("");
                emailField.setText("");
                passwordField.setText("");
            }

            if (ae.getSource() == backButton) {
                this.setVisible(false);
                new Login().setVisible(true);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Print error details
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
