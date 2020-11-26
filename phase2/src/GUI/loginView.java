package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class loginView {
    private JFrame loginFrame;
    private JPanel container;
    private JPanel loginPanel;
    private JPanel secondPanel;
    private JLabel secondLabel;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JTextField usernameTextField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private CardLayout c1;

    public loginView(){
        createUI();
    }

    private void createUI(){
        loginFrame = new JFrame();
        c1 = new CardLayout(5,5);
        container = new JPanel(c1);
        loginPanel = new JPanel();
        secondPanel = new JPanel();
        container.add(loginPanel, "Login");
        container.add(secondPanel, "Test");
        loginFrame.setSize(350, 200);
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.add(container);


        loginPanel.setLayout(null);
        secondPanel.setLayout(null);

        secondLabel = new JLabel("Test");
        secondLabel.setBounds(10,20,80,25);
        secondPanel.add(secondLabel);

        usernameLabel = new JLabel("Username");
        usernameLabel.setBounds(10, 20, 80, 25);
        loginPanel.add(usernameLabel);

        usernameTextField = new JTextField();
        usernameTextField.setBounds(100, 20, 165, 25);
        loginPanel.add(usernameTextField);

        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10, 50, 80, 25);
        loginPanel.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(100, 50, 165, 25);
        loginPanel.add(passwordField);

        loginButton = new JButton("Login");
        loginButton.setBounds(10, 80, 80, 25);
        loginPanel.add(loginButton);
        loginButton.addActionListener(e -> c1.show(container, "Test"));

        loginFrame.setVisible(true);
        c1.show(container, "Login");
    }

    public static void main(String[] args) {
        new loginView();
    }
}
