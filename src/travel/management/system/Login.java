package travel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    private JPanel panel;
    private JTextField textField;
    private JPasswordField passwordField;
    private JButton b1, b2, b3;

    public Login() {
        setTitle("Login");
        setBounds(450, 200, 800, 400);

        panel = new JPanel();
        panel.setBackground(Color.WHITE);
        setContentPane(panel);
        panel.setLayout(null);

        // Title
        JLabel title = new JLabel("Login to Your Account");
        title.setFont(new Font("Tahoma", Font.BOLD, 22));
        title.setForeground(new Color(34, 139, 34));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setBounds(200, 20, 400, 40);
        panel.add(title);

        // Labels
        JLabel l1 = new JLabel("Email:");
        l1.setFont(new Font("Tahoma", Font.BOLD, 14));
        l1.setBounds(180, 100, 100, 25);
        panel.add(l1);

        JLabel l2 = new JLabel("Password:");
        l2.setFont(new Font("Tahoma", Font.BOLD, 14));
        l2.setBounds(180, 150, 100, 25);
        panel.add(l2);

        // Input Fields
        textField = new JTextField();
        textField.setFont(new Font("Tahoma", Font.PLAIN, 13));
        textField.setBounds(300, 100, 250, 30);
        panel.add(textField);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 13));
        passwordField.setBounds(300, 150, 250, 30);
        panel.add(passwordField);

        // Buttons
        b1 = new JButton("Login");
        b1.setFont(new Font("Tahoma", Font.BOLD, 14));
        b1.setForeground(Color.WHITE);
        b1.setBackground(new Color(0, 128, 128));
        b1.setBounds(300, 210, 100, 30);
        b1.addActionListener(this);
        panel.add(b1);

        b2 = new JButton("Sign Up");
        b2.setFont(new Font("Tahoma", Font.BOLD, 14));
        b2.setForeground(Color.WHITE);
        b2.setBackground(new Color(139, 69, 19));
        b2.setBounds(450, 210, 100, 30);
        b2.addActionListener(this);
        panel.add(b2);

        b3 = new JButton("Forgot Password");
        b3.setFont(new Font("Tahoma", Font.BOLD, 13));
        b3.setForeground(new Color(255, 69, 0));
        b3.setBackground(new Color(250, 240, 230));
        b3.setBounds(350, 260, 150, 30);
        b3.addActionListener(this);
        panel.add(b3);

        // Decorative Labels
        JLabel l3 = new JLabel("Trouble in Login?");
        l3.setFont(new Font("Tahoma", Font.PLAIN, 14));
        l3.setForeground(Color.RED);
        l3.setBounds(180, 260, 150, 25);
        panel.add(l3);

        // Add Icon/Image
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("Travel/Management/System/icons/login.png"));
        Image img = icon.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
        ImageIcon resizedIcon = new ImageIcon(img);

        JLabel imageLabel = new JLabel(resizedIcon);
        imageLabel.setBounds(600, 100, 150, 150);
        panel.add(imageLabel);

        // Decorative Panel
        JPanel innerPanel = new JPanel();
        innerPanel.setBounds(150, 80, 450, 230);
        innerPanel.setBackground(new Color(245, 245, 245));
        innerPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(0, 128, 128), 2),
                "Login Credentials",
                0,
                0,
                new Font("Tahoma", Font.BOLD, 14),
                new Color(0, 128, 128)));
        panel.add(innerPanel);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {  // Login button action
            try {
                Conn con = new Conn();
                String sql = "SELECT * FROM account WHERE email=? AND password=?";
                PreparedStatement st = con.c.prepareStatement(sql);

                st.setString(1, textField.getText());
                st.setString(2, String.valueOf(passwordField.getPassword()));

                ResultSet rs = st.executeQuery();
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "Login Successful!");
                    this.setVisible(false);
                    new Loading(rs.getString("name")).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Email or Password!");
                }
                st.close();
                con.c.close();
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Database Error: " + e.getMessage());
            }
        } else if (ae.getSource() == b2) {  // Sign Up button action
            setVisible(false);
            new Signup().setVisible(true);
        } else if (ae.getSource() == b3) {  // Forgot Password button action
            setVisible(false);
            new ForgotPassword().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Login().setVisible(true);
    }
}
