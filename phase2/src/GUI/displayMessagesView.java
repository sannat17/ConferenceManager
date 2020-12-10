package GUI;

import GUIPresenters.MessagePresenter;
import GUIPresenters.SignoutPresenter;
import javafx.scene.control.ComboBox;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class displayMessagesView {

    static int currentMessageID;
    static JComboBox<String> messages;

    public static JPanel getDisplayMessagesPanel() {
        JPanel DisplayMessagesPanel = new JPanel();
        DisplayMessagesPanel.setLayout(null);
        currentMessageID = -1;


        HashMap<Integer, String> messageHash = MessagePresenter.messageUsernamnes();
        ArrayList<String> messageUsernamesList = new ArrayList<>(messageHash.values());
        ArrayList<Integer> messageIDList = new ArrayList<>(messageHash.keySet());
        messageUsernamesList.add(0,"Select an Option");
        String [] messageUsernames = messageUsernamesList.toArray(new String[0]);

        JTextArea message = new JTextArea();
        message.setLineWrap(true);
        message.setWrapStyleWord(true);
        JScrollPane messageScrollPanel = new JScrollPane(message);
        messageScrollPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        messageScrollPanel.setBounds(200, 20, 250, 200);
        message.setEditable(false);
        DisplayMessagesPanel.add(messageScrollPanel);

        JComboBox<String> messages = new JComboBox<>(messageUsernames);
        messages.setSelectedIndex(0);
        messages.setBounds(10, 20, 160, 25);
        DisplayMessagesPanel.add(messages);


        if (messages.getItemCount() > 1) {

            JButton unreadButton = new JButton("Mark as Unread");
            unreadButton.setBounds(200, 230, 100, 25);
            unreadButton.setFont(new Font("Dialog", Font.BOLD, 8));
            DisplayMessagesPanel.add(unreadButton);

            JButton replyButton = new JButton("Reply");
            replyButton.setBounds(350, 230, 100, 25);
            DisplayMessagesPanel.add(replyButton);

            JButton archiveButton = new JButton("Archive");
            archiveButton.setBounds(200, 260, 100, 25);
            DisplayMessagesPanel.add(archiveButton);

            JButton deleteButton = new JButton("Delete");
            deleteButton.setBounds(350, 260, 100, 25);
            DisplayMessagesPanel.add(deleteButton);

            messages.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(currentMessageID != -1){
                        MessagePresenter.markRead(currentMessageID);
                    }

                    if (messages.getSelectedIndex() != 0){
                        String text = "";
                        text += "Status: " + MessagePresenter.getMessageStatus(messages.getSelectedIndex()-1) + "\n";
                        text += "Message: " + MessagePresenter.getMessageContent(messageIDList.get(messages.getSelectedIndex()-1));
                        message.setText(text);
                        currentMessageID = messages.getSelectedIndex()-1;
                    } else {
                        message.setText("");
                    }
                }
            });
        } else {
            message.setText("No Messages To Display");
        }

        JButton inboxButton = new JButton("Inbox");
        inboxButton.setBounds(10, 200, 100, 25);
        DisplayMessagesPanel.add(inboxButton);
        inboxButton.setVisible(false);

        JButton archivedButton = new JButton("Archived");
        archivedButton.setBounds(10, 200, 100, 25);
        DisplayMessagesPanel.add(archivedButton);

        archivedButton.addActionListener(e -> {
            archivedButton.setVisible(false);
            inboxButton.setVisible(true);
        });

        inboxButton.addActionListener(e -> {
            archivedButton.setVisible(true);
            inboxButton.setVisible(false);
        });

        JButton backButton = new JButton("Back");
        backButton.setBounds(10, 230, 100, 25);
        DisplayMessagesPanel.add(backButton);
        backButton.addActionListener(e -> mainView.toPanel("Menu"));

        JButton signoutButton = new JButton("Sign Out");
        signoutButton.setBounds(10, 260, 100, 25);
        DisplayMessagesPanel.add(signoutButton);
        signoutButton.addActionListener(e -> SignoutPresenter.signOut());

        return DisplayMessagesPanel;
    }
}
