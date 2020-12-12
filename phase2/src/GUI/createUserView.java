package GUI;

import GUIPresenters.CreateUserPresenter;
import GUIPresenters.SignoutPresenter;

import javax.swing.*;

public class createUserView {
    /** Creates the JPanel to create user
     *
     * @return JPanel of the create user
     */
    public static JPanel getCreateUserPanel(){
        JPanel createUserPanel = new JPanel();
        createUserPanel.setLayout(null);

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(10, 20, 80, 25);
        createUserPanel.add(usernameLabel);

        JTextField usernameTextField = new JTextField();
        usernameTextField.setBounds(280, 20, 165, 25);
        createUserPanel.add(usernameTextField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(10, 50, 80, 25);
        createUserPanel.add(passwordLabel);

        JTextField passwordField = new JTextField();
        passwordField.setBounds(280, 50, 165, 25);
        createUserPanel.add(passwordField);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(10,80, 80, 25);
        createUserPanel.add(nameLabel);

        JTextField nameField = new JTextField();
        nameField.setBounds(280, 80, 165, 25);
        createUserPanel.add(nameField);

        JLabel typeLabel = new JLabel("Type:");
        typeLabel.setBounds(10, 110, 80, 25);
        createUserPanel.add(typeLabel);

        String [] typeOptions = {"Organizer", "Attendee", "Speaker", "VIP"};
        JComboBox typeComboBox = new JComboBox(typeOptions);
        typeComboBox.setBounds(280, 110, 165, 25);
        createUserPanel.add(typeComboBox);

        JLabel dietaryRestrictions = new JLabel("Dietary Restrictions (Blank if none)");
        dietaryRestrictions.setBounds(10, 140, 230, 25);
        createUserPanel.add(dietaryRestrictions);

        JTextField dietaryTextField = new JTextField();
        dietaryTextField.setBounds(280, 140, 165, 25);
        createUserPanel.add(dietaryTextField);

        JLabel accessibilityLabel = new JLabel("Accessibility Requirements (Blank if none)");
        accessibilityLabel.setBounds(10, 170, 260, 25);
        createUserPanel.add(accessibilityLabel);

        JTextField accessibilityTextField = new JTextField();
        accessibilityTextField.setBounds(280, 170, 165, 25);
        createUserPanel.add(accessibilityTextField);

        JButton createUserButton = new JButton("Create User");
        createUserButton.setBounds(10, 200, 165, 25);
        createUserPanel.add(createUserButton);
        createUserButton.addActionListener(e -> CreateUserPresenter.createNewUser(usernameTextField.getText(),
                passwordField.getText(), nameField.getText(), (String)typeComboBox.getSelectedItem(),
                dietaryTextField.getText(), accessibilityTextField.getText()));

        JButton backButton = new JButton("Back");
        backButton.setBounds(10, 230, 100, 25);
        createUserPanel.add(backButton);
        backButton.addActionListener(e -> mainView.toPanel("Menu"));

        JButton signoutButton = new JButton("Sign Out");
        signoutButton.setBounds(10, 260, 100, 25);
        createUserPanel.add(signoutButton);
        signoutButton.addActionListener(e -> SignoutPresenter.signOut());

        return createUserPanel;
    }
}
