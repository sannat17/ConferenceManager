package GUI;

import GUIPresenters.MessagePresenter;
import entities.User;

import javax.swing.*;
import java.util.ArrayList;

public class messageUserView {

    public static JPanel getMessageUserView(User u, String type) {
        JPanel messageUserPanel = new JPanel();
        messageUserPanel.setLayout(null);

        String[] messageUsers = MessagePresenter.usersUsernames(type);
        JComboBox<String> messageUsersComboBox = new JComboBox<>(messageUsers);
        messageUsersComboBox.setBounds(10, 20, 160, 25);
        messageUsersComboBox.setSelectedIndex(0);
        messageUserPanel.add(messageUsersComboBox);

        JButton confirmButton = new JButton("Confirm");
        confirmButton.setBounds(10, 60, 160, 25);
        messageUserPanel.add(confirmButton);

        return messageUserPanel;
    }
}
