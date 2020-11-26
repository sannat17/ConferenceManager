package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class loginView {

    public static JPanel getLoginPanel(){
        JPanel loginPanel = new JPanel();

        loginPanel.setLayout(null);


        JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setBounds(10, 20, 80, 25);
        loginPanel.add(usernameLabel);

        JTextField usernameTextField = new JTextField();
        usernameTextField.setBounds(100, 20, 165, 25);
        loginPanel.add(usernameTextField);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10, 50, 80, 25);
        loginPanel.add(passwordLabel);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(100, 50, 165, 25);
        loginPanel.add(passwordField);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(10, 80, 80, 25);
        loginPanel.add(loginButton);



        return loginPanel;
    }

}
