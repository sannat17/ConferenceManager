package GUI;

import GUIPresenters.MessagePresenter;
import GUIPresenters.SignoutPresenter;

import javax.swing.*;

public class changeAdditionalRequestStatusView {

    /** Creates the JPanel for change user request status
     *
     * @return JPanel of the change user requests status
     */
    public static JPanel getChangeRequestStatusPanel(){
        JPanel additionalRequests = new JPanel();
        additionalRequests.setLayout(null);

        String[] messageOptions = MessagePresenter.messageOptions();
        JComboBox<String> messageComboBox = new JComboBox<>(messageOptions);
        messageComboBox.setBounds(10, 20, 100, 25);
        messageComboBox.setSelectedIndex(0);
        additionalRequests.add(messageComboBox);

        JButton confirmButton = new JButton("Confirm");
        confirmButton.setBounds(10, 60, 100, 25);
        additionalRequests.add(confirmButton);
        confirmButton.addActionListener(e -> MessagePresenter.nextMessagePanel((String)messageComboBox.getSelectedItem()));

        JButton backButton = new JButton("Back");
        backButton.setBounds(10, 230, 100, 25);
        additionalRequests.add(backButton);
        backButton.addActionListener(e -> mainView.toPanel("Menu"));

        JButton signoutButton = new JButton("Sign Out");
        signoutButton.setBounds(10, 260, 100, 25);
        additionalRequests.add(signoutButton);
        signoutButton.addActionListener(e -> SignoutPresenter.signOut());

        return additionalRequests;
    }
}
