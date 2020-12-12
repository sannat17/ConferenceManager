package GUI;


import GUIPresenters.MessagePresenter;
import GUIPresenters.SignoutPresenter;

import javax.swing.*;

public class messageView {

    /** Creates the JPanel for the message menu
     *
     * @return JPanel of the message panel
     */
    public static JPanel getMessageView(){
        JPanel messagePanel = new JPanel();
        messagePanel.setLayout(null);

        String[] messageOptions = MessagePresenter.messageOptions();
        JComboBox<String> messageComboBox = new JComboBox<>(messageOptions);
        messageComboBox.setBounds(10, 20, 240, 25);
        messageComboBox.setSelectedIndex(0);
        messagePanel.add(messageComboBox);

        JButton confirmButton = new JButton("Confirm");
        confirmButton.setBounds(10, 60, 240, 25);
        messagePanel.add(confirmButton);
        confirmButton.addActionListener(e -> MessagePresenter.nextMessagePanel((String)messageComboBox.getSelectedItem()));

        JButton backButton = new JButton("Back");
        backButton.setBounds(10, 230, 100, 25);
        messagePanel.add(backButton);
        backButton.addActionListener(e -> mainView.toPanel("Menu"));

        JButton signoutButton = new JButton("Sign Out");
        signoutButton.setBounds(10, 260, 100, 25);
        messagePanel.add(signoutButton);
        signoutButton.addActionListener(e -> SignoutPresenter.signOut());

        return messagePanel;
    }
}
