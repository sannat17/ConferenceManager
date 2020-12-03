package GUI;

import GUIPresenters.MessagePresenter;
import entities.User;

import javax.swing.*;

public class displayMessagesView {

    public static JPanel getDisplayMessagesPanel(User u) {
        JPanel DisplayMessagesPanel = new JPanel();
        DisplayMessagesPanel.setLayout(null);
        String[] messageUsernames = MessagePresenter.messageUsernamnes(u);

        if (messageUsernames.length > 0) {
            JComboBox<String> messages = new JComboBox<>(messageUsernames);
            messages.setBounds(10, 20, 160, 25);
            messages.setSelectedIndex(0);
            DisplayMessagesPanel.add(messages);
        } else {
            JLabel noMessages = new JLabel("No Messages to Display!");
            noMessages.setBounds(10, 20, 80, 25);
            DisplayMessagesPanel.add(noMessages);
        }

        JButton backButton = new JButton("Back");
        backButton.setBounds(10, 230, 100, 25);
        DisplayMessagesPanel.add(backButton);
        backButton.addActionListener(e -> mainView.toMenuPanel(u));

        return DisplayMessagesPanel;
    }
}
