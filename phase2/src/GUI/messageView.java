package GUI;

import GUIPresenters.EventPresenter;
import GUIPresenters.MessagePresenter;
import GUIPresenters.SignoutPresenter;
import entities.User;

import javax.swing.*;

public class messageView {

    public static JPanel getMessageView(User u){
        JPanel messagePanel = new JPanel();
        messagePanel.setLayout(null);

        String[] messageOptions = MessagePresenter.messageOptions(u);
        JComboBox<String> messageComboBox = new JComboBox<>(messageOptions);
        messageComboBox.setBounds(10, 20, 160, 25);
        messageComboBox.setSelectedIndex(0);
        messagePanel.add(messageComboBox);

        JButton confirmButton = new JButton("Confirm");
        confirmButton.setBounds(10, 60, 160, 25);
        messagePanel.add(confirmButton);
        confirmButton.addActionListener(e -> MessagePresenter.nextMessagePanel((String)messageComboBox.getSelectedItem(), u));

        JButton backButton = new JButton("Back");
        backButton.setBounds(10, 230, 100, 25);
        messagePanel.add(backButton);
        backButton.addActionListener(e -> mainView.toMenuPanel(u));

        JButton signoutButton = new JButton("Sign Out");
        signoutButton.setBounds(10, 260, 100, 25);
        messagePanel.add(signoutButton);
        signoutButton.addActionListener(e -> SignoutPresenter.signOut());

        return messagePanel;
    }
}
