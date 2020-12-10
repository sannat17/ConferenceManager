package GUI;

import GUIPresenters.MessagePresenter;
import GUIPresenters.SignoutPresenter;

import javax.swing.*;

public class messageAllUsersView {
    /** Creates the JPanel for message all users
     *
     * @return JPanel of the message all users view
     */
    public static JPanel getMessageAllUserView(String type) {
        JPanel messageAllUsersPanel = new JPanel();
        messageAllUsersPanel.setLayout(null);

        JLabel text = new JLabel("Enter your message to all " + type + "s");
        text.setBounds(10, 20, 280, 25);
        messageAllUsersPanel.add(text);

        JTextArea message = new JTextArea();
        message.setLineWrap(true);
        message.setWrapStyleWord(true);
        JScrollPane JScrollPanel = new JScrollPane(message);
        JScrollPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        JScrollPanel.setBounds(10, 60, 280, 50);
        messageAllUsersPanel.add(JScrollPanel);

        JButton confirmButton = new JButton("Confirm");
        confirmButton.setBounds(10, 130, 160, 25);
        messageAllUsersPanel.add(confirmButton);
        confirmButton.addActionListener(e -> MessagePresenter.sendMessageToAllType(type, message.getText()));

        JButton backButton = new JButton("Back");
        backButton.setBounds(10, 230, 100, 25);
        messageAllUsersPanel.add(backButton);
        backButton.addActionListener(e -> mainView.toPanel("Messages"));

        JButton signoutButton = new JButton("Sign Out");
        signoutButton.setBounds(10, 260, 100, 25);
        messageAllUsersPanel.add(signoutButton);
        signoutButton.addActionListener(e -> SignoutPresenter.signOut());

        return messageAllUsersPanel;
    }
}
