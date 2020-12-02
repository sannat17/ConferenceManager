package GUI;

import GUIPresenters.LoginPresenter;
import entities.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class loginView {

    private static User user;

    public static JPanel getLoginPanel(){
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(null);
        JButton loginButton = new JButton("Login");

        KeyListener enterPressed = new KeyListener(){

            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER){
                    loginButton.doClick();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        };

        JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setBounds(10, 20, 80, 25);
        loginPanel.add(usernameLabel);

        JTextField usernameTextField = new JTextField();
        usernameTextField.setBounds(100, 20, 165, 25);
        loginPanel.add(usernameTextField);
        usernameTextField.addKeyListener(enterPressed);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10, 50, 80, 25);
        loginPanel.add(passwordLabel);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(100, 50, 165, 25);
        loginPanel.add(passwordField);
        passwordField.addKeyListener(enterPressed);


        loginButton.setBounds(10, 80, 80, 25);
        loginPanel.add(loginButton);
        loginButton.addActionListener(e -> LoginPresenter.loginCheck(usernameTextField.getText(), String.valueOf(passwordField.getPassword())));



        return loginPanel;
    }
}
