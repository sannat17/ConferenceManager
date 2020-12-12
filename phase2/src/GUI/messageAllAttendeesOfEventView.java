package GUI;

import GUIPresenters.MessagePresenter;
import GUIPresenters.SignoutPresenter;

import javax.swing.*;

public class messageAllAttendeesOfEventView {

    /** Creates the JPanel for sending a message to all attendees of a talk
     *
     * @return JPanel for sending a message to all attendees of a talk
     */
    public static JPanel getMessageAllAttendeesOfTalkView() {
        JPanel messageAllAttendeesOfTalkPanel = new JPanel();
        messageAllAttendeesOfTalkPanel.setLayout(null);

        String[] listOfTalks = MessagePresenter.getAllTalks();
        JComboBox<String> messageTalksComboBox = new JComboBox<>(listOfTalks);
        messageTalksComboBox.setBounds(10, 20, 160, 25);
        messageAllAttendeesOfTalkPanel.add(messageTalksComboBox);

        JTextArea message = new JTextArea();
        message.setLineWrap(true);
        message.setWrapStyleWord(true);
        JScrollPane JScrollPanel = new JScrollPane(message);
        JScrollPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        JScrollPanel.setBounds(10, 60, 160, 50);
        messageAllAttendeesOfTalkPanel.add(JScrollPanel);

        JButton confirmButton = new JButton("Confirm");
        confirmButton.setBounds(10, 130, 160, 25);
        messageAllAttendeesOfTalkPanel.add(confirmButton);
        confirmButton.addActionListener(e -> {
            MessagePresenter.sendMessageToAllAttendeesOfTalk(MessagePresenter.getIDOfTalkByTitle((String)messageTalksComboBox.getSelectedItem()), message.getText());
            MessagePresenter.createMessagePopUp("Message Sent!");
        });

        JButton backButton = new JButton("Back");
        backButton.setBounds(10, 230, 100, 25);
        messageAllAttendeesOfTalkPanel.add(backButton);
        backButton.addActionListener(e -> mainView.toPanel("Messages"));

        JButton signoutButton = new JButton("Sign Out");
        signoutButton.setBounds(10, 260, 100, 25);
        messageAllAttendeesOfTalkPanel.add(signoutButton);
        signoutButton.addActionListener(e -> SignoutPresenter.signOut());

        return messageAllAttendeesOfTalkPanel;
    }
}
