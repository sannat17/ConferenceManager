package GUI;

import javax.swing.*;

public class loginView {
    private JFrame loginFrame;
    private JPanel loginPanel;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JTextField usernameTextField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public loginView(){
        createUI();
    }

    private void createUI(){
        loginPanel = new JPanel();
        loginFrame = new JFrame();
        loginFrame.setSize(350, 200);
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.add(loginPanel);

        loginPanel.setLayout(null);

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

        loginFrame.setVisible(true);
    }

    public static void main(String[] args) {
        new loginView();
    }
}
