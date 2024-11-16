package travel.management.system;

import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class Loading extends JFrame implements Runnable {

    private JPanel contentPane;
    private JProgressBar progressBar;
    private String username;
    private int s;
    private Thread th;

    public static void main(String[] args) {
        new Loading("").setVisible(true);
    }

    public Loading(String username) {
        this.username = username;
        th = new Thread(this);
        initialize();
    }

    private void initialize() {
        setBounds(600, 300, 600, 400);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(51, 204, 255));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel titleLabel = new JLabel("Travel and Tourism Application");
        titleLabel.setForeground(new Color(72, 209, 204));
        titleLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 35));
        titleLabel.setBounds(50, 46, 500, 35);
        contentPane.add(titleLabel);

        progressBar = new JProgressBar();
        progressBar.setFont(new Font("Tahoma", Font.BOLD, 12));
        progressBar.setStringPainted(true);
        progressBar.setBounds(130, 135, 300, 25);
        contentPane.add(progressBar);

        JLabel waitLabel = new JLabel("Please Wait....");
        waitLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
        waitLabel.setForeground(new Color(160, 82, 45));
        waitLabel.setBounds(200, 165, 150, 20);
        contentPane.add(waitLabel);

        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setBounds(10, 10, 580, 380);
        contentPane.add(panel);

        setUndecorated(true);
        setUploading();
    }

    public void setUploading() {
        setVisible(true);
        th.start();
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 200; i++) {
                s++;
                if (progressBar.getValue() < progressBar.getMaximum()) {
                    progressBar.setValue(progressBar.getValue() + 1);
                } else {
                    i = 201;
                    setVisible(false);
                    new Home(username).setVisible(true);  // Transition to home screen
                }
                Thread.sleep(50);  // Simulate loading delay
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
