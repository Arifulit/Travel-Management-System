package travel.management.system;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.sql.*;
import java.awt.event.*;

public class ForgotPassword extends JFrame implements ActionListener {

    private JPanel contentPane;
    private JTextField t1, t2, t5;
    private JButton b1, b2, b3;

    public static void main(String[] args) {
        new ForgotPassword().setVisible(true);
    }

    public ForgotPassword() {
        setTitle("Forgot Password");
        setBounds(450, 200, 850, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setBackground(Color.WHITE);
        contentPane.setLayout(null);

        // Title
        JLabel title = new JLabel("Forgot Password");
        title.setFont(new Font("Tahoma", Font.BOLD, 22));
        title.setForeground(new Color(34, 139, 34));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setBounds(300, 20, 250, 30);
        contentPane.add(title);

        // Labels
        JLabel l1 = new JLabel("Name:");
        l1.setFont(new Font("Tahoma", Font.BOLD, 14));
        l1.setBounds(100, 90, 100, 25);
        contentPane.add(l1);

        JLabel l2 = new JLabel("Email:");
        l2.setFont(new Font("Tahoma", Font.BOLD, 14));
        l2.setBounds(100, 140, 100, 25);
        contentPane.add(l2);

        JLabel l5 = new JLabel("Password:");
        l5.setFont(new Font("Tahoma", Font.BOLD, 14));
        l5.setBounds(100, 190, 100, 25);
        contentPane.add(l5);

        // Input Fields
        t1 = new JTextField(); // Name input
        t1.setFont(new Font("Tahoma", Font.PLAIN, 13));
        t1.setBounds(200, 90, 200, 25);
        contentPane.add(t1);

        t2 = new JTextField(); // Email display
        t2.setFont(new Font("Tahoma", Font.PLAIN, 13));
        t2.setEditable(false);
        t2.setBounds(200, 140, 200, 25);
        contentPane.add(t2);

        t5 = new JTextField(); // Password display
        t5.setFont(new Font("Tahoma", Font.PLAIN, 13));
        t5.setEditable(false);
        t5.setBounds(200, 190, 200, 25);
        contentPane.add(t5);

        // Buttons
        b1 = new JButton("Search");
        b1.setFont(new Font("Tahoma", Font.BOLD, 12));
        b1.setBounds(430, 90, 100, 25);
        b1.setBackground(new Color(0, 128, 128));
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        contentPane.add(b1);

        b2 = new JButton("Retrieve");
        b2.setFont(new Font("Tahoma", Font.BOLD, 12));
        b2.setBounds(430, 190, 100, 25);
        b2.setBackground(new Color(0, 128, 128));
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        contentPane.add(b2);

        b3 = new JButton("Back");
        b3.setFont(new Font("Tahoma", Font.BOLD, 12));
        b3.setBounds(200, 250, 150, 30);
        b3.setBackground(new Color(139, 69, 19));
        b3.setForeground(Color.WHITE);
        b3.addActionListener(this);
        contentPane.add(b3);

        // Decorative Panel
        JPanel panel = new JPanel();
        panel.setBounds(80, 50, 550, 250);
        panel.setBackground(new Color(240, 248, 255));
        panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(34, 139, 34), 2), 
                                                          "Recover Account", 
                                                          0, 0, new Font("Tahoma", Font.BOLD, 14), 
                                                          new Color(34, 139, 34)));
        contentPane.add(panel);

        // Add Icon
        ImageIcon c1 = new ImageIcon(ClassLoader.getSystemResource("Travel/Management/System/icons/forgotpassword.jpg"));
        Image i1 = c1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);

        JLabel l6 = new JLabel(i2);
        l6.setBounds(650, 90, 150, 150);
        contentPane.add(l6);
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            Conn con = new Conn();
            if (ae.getSource() == b1) { // Search by name
                String sql = "SELECT * FROM account WHERE name=?";
                PreparedStatement st = con.c.prepareStatement(sql);
                st.setString(1, t1.getText());
                ResultSet rs = st.executeQuery();

                if (rs.next()) {
                    t2.setText(rs.getString("email")); // Display email
                } else {
                    JOptionPane.showMessageDialog(null, "No user found with this name!");
                }
            }

            if (ae.getSource() == b2) { // Retrieve password
                String sql = "SELECT * FROM account WHERE name=?";
                PreparedStatement st = con.c.prepareStatement(sql);
                st.setString(1, t1.getText());
                ResultSet rs = st.executeQuery();

                if (rs.next()) {
                    t5.setText(rs.getString("password")); // Display password
                } else {
                    JOptionPane.showMessageDialog(null, "No user found!");
                }
            }

            if (ae.getSource() == b3) { // Back to login
                this.setVisible(false);
                new Login().setVisible(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
