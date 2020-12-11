package GUI;

import GUIPresenters.MessagePresenter;
import GUIPresenters.SignoutPresenter;

import javax.swing.*;

public class messageUserView {

    /** Creates the JPanel for get messages
     *
     * @return JPanel of the get message user
     */
    public static JPanel getMessageUserView(String type) {
        JPanel messageUserPanel = new JPanel();
        messageUserPanel.setLayout(null);

        String[] messageUsers = MessagePresenter.usersUsernames(type);
        JComboBox<String> messageUsersComboBox = new JComboBox<>(messageUsers);
        messageUsersComboBox.setBounds(10, 20, 160, 25);
        messageUsersComboBox.setSelectedIndex(0);
        messageUserPanel.add(messageUsersComboBox);

        JTextArea message = new JTextArea();
        message.setLineWrap(true);
        message.setWrapStyleWord(true);
        JScrollPane JScrollPanel = new JScrollPane(message);
        JScrollPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        JScrollPanel.setBounds(10, 60, 160, 50);
        messageUserPanel.add(JScrollPanel);

        JButton confirmButton = new JButton("Confirm");
        confirmButton.setBounds(10, 130, 160, 25);
        messageUserPanel.add(confirmButton);
        confirmButton.addActionListener(e -> {
            MessagePresenter.sendMessage((String)messageUsersComboBox.getSelectedItem(),message.getText());
            MessagePresenter.createMessagePopUp("Message Sent!");
        });


        JButton backButton = new JButton("Back");
        backButton.setBounds(10, 230, 100, 25);
        messageUserPanel.add(backButton);
        backButton.addActionListener(e -> mainView.toPanel("Messages"));

        JButton signoutButton = new JButton("Sign Out");
        signoutButton.setBounds(10, 260, 100, 25);
        messageUserPanel.add(signoutButton);
        signoutButton.addActionListener(e -> SignoutPresenter.signOut());

        return messageUserPanel;
    }
}
