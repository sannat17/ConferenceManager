package GUI;

import entities.User;

import javax.swing.*;

public class messageUserView {

    public static JPanel getMessageUserView(User u) {
        JPanel messageUserPanel = new JPanel();
        messageUserPanel.setLayout(null);

        JButton confirmButton = new JButton("Confirm");
        confirmButton.setBounds(10, 60, 160, 25);
        messageUserPanel.add(confirmButton);

        return messageUserPanel;
    }
}
