package GUI;

import GUIPresenters.MessagePresenter;
import GUIPresenters.SignoutPresenter;
import entities.Message;
import javafx.scene.control.ComboBox;
import useCases.MessageManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class displayMessagesView {

    static int currentMessageID;
    static boolean changeRead;
    static boolean deleted;
    static JButton archiveButton;
    static JButton unArchiveButton;
    static JButton inboxDeleteButton;
    static JButton archiveDeleteButton;
    static boolean inbox = true;
    static boolean archive = false;

    /** Creates the JPanel for Display Messages Panel
     *
     * @return JPanel of the display messages
     */
    public static JPanel getDisplayMessagesPanel() {
        JPanel DisplayMessagesPanel = new JPanel();
        DisplayMessagesPanel.setLayout(null);
        currentMessageID = -1;
        changeRead = true;
        deleted = false;


        HashMap<Integer, String> inboxMessageHash = MessagePresenter.getUsernamesFromInbox();
        ArrayList<String> inboxMessageUsernamesList = new ArrayList<>(inboxMessageHash.values());
        ArrayList<Integer> inboxMessageIDList = new ArrayList<>(inboxMessageHash.keySet());
        inboxMessageUsernamesList.add(0,"Select an Option");
        String [] inboxMessageUsernames = inboxMessageUsernamesList.toArray(new String[0]);

        HashMap<Integer, String> archivedMessageHash = MessagePresenter.getUsernamesFromArchived();
        ArrayList<String> archivedMessageUsernamesList = new ArrayList<>(archivedMessageHash.values());
        ArrayList<Integer> archivedMessageIDList = new ArrayList<>(archivedMessageHash.keySet());
        archivedMessageUsernamesList.add(0,"Select an Option");
        String [] archivedMessageUsernames = archivedMessageUsernamesList.toArray(new String[0]);

        JTextArea message = new JTextArea();
        message.setLineWrap(true);
        message.setWrapStyleWord(true);
        JScrollPane messageScrollPanel = new JScrollPane(message);
        messageScrollPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        messageScrollPanel.setBounds(200, 20, 250, 200);
        message.setEditable(false);
        DisplayMessagesPanel.add(messageScrollPanel);

        JComboBox<String> inboxMessages = new JComboBox<>(inboxMessageUsernames);
        inboxMessages.setSelectedIndex(0);
        inboxMessages.setBounds(10, 20, 160, 25);
        DisplayMessagesPanel.add(inboxMessages);

        JComboBox<String> archivedMessages = new JComboBox<>(archivedMessageUsernames);
        archivedMessages.setSelectedIndex(0);
        archivedMessages.setBounds(10, 20, 160, 25);
        DisplayMessagesPanel.add(archivedMessages);
        archivedMessages.setVisible(false);


        if (inboxMessages.getItemCount() > 1 || archivedMessages.getItemCount() > 1) {

            JButton unreadButton = new JButton("Mark as Unread");
            unreadButton.setBounds(200, 230, 100, 25);
            unreadButton.setFont(new Font("Dialog", Font.BOLD, 8));
            DisplayMessagesPanel.add(unreadButton);
            unreadButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (inboxMessages.getSelectedIndex() != 0 && inbox){
                        MessagePresenter.markUnread(inboxMessageIDList.get(inboxMessages.getSelectedIndex()-1));
                        String text = "";
                        text += "Status: " + MessagePresenter.getMessageStatus(inboxMessageIDList.get(inboxMessages.getSelectedIndex()-1)) + "\n";
                        text += "Message: " + MessagePresenter.getMessageContent(inboxMessageIDList.get(inboxMessages.getSelectedIndex()-1));
                        message.setText(text);
                        changeRead = false;
                    }
                }
            });

            JButton replyButton = new JButton("Reply");
            replyButton.setBounds(350, 230, 100, 25);
            DisplayMessagesPanel.add(replyButton);
            replyButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(inbox && inboxMessages.getSelectedIndex() != 0){
                        MessagePresenter.replyToMessage(MessagePresenter.getMessageContent(inboxMessageIDList.get(inboxMessages.getSelectedIndex()-1)),
                                inboxMessageIDList.get(inboxMessages.getSelectedIndex()-1),
                                MessagePresenter.getSendersUsername(inboxMessageIDList.get(inboxMessages.getSelectedIndex()-1)));
                    } else if (archive && archivedMessages.getSelectedIndex() != 0){
                        MessagePresenter.replyToMessage(MessagePresenter.getMessageContent(archivedMessageIDList.get(archivedMessages.getSelectedIndex()-1)),
                                archivedMessageIDList.get(archivedMessages.getSelectedIndex()-1),
                                MessagePresenter.getSendersUsername(archivedMessageIDList.get(archivedMessages.getSelectedIndex()-1)));
                    }
                }
            });

            archiveButton = new JButton("Archive");
            archiveButton.setBounds(200, 260, 100, 25);
            DisplayMessagesPanel.add(archiveButton);
            archiveButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(inboxMessages.getSelectedIndex() != 0) {
                        int index = inboxMessages.getSelectedIndex() - 1;
                        archivedMessages.addItem(inboxMessages.getItemAt(inboxMessages.getSelectedIndex()));
                        archivedMessageUsernamesList.add(inboxMessageUsernamesList.get(index));
                        archivedMessageIDList.add(inboxMessageIDList.get(index));
                        inboxMessages.removeItemAt(inboxMessages.getSelectedIndex());
                        inboxMessages.setSelectedIndex(index);
                        inboxMessageUsernamesList.remove(index);
                        MessagePresenter.markArchived(inboxMessageIDList.get(index));
                        inboxMessageIDList.remove(index);
                    }
                }
            });

            unArchiveButton = new JButton("Unarchive");
            unArchiveButton.setBounds(200, 260, 100, 25);
            DisplayMessagesPanel.add(unArchiveButton);
            unArchiveButton.setVisible(false);
            unArchiveButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(archivedMessages.getSelectedIndex() != 0) {
                        int index = archivedMessages.getSelectedIndex() - 1;
                        inboxMessages.addItem(archivedMessages.getItemAt(archivedMessages.getSelectedIndex()));
                        inboxMessageUsernamesList.add(archivedMessageUsernamesList.get(index));
                        inboxMessageIDList.add(archivedMessageIDList.get(index));
                        archivedMessages.removeItemAt(archivedMessages.getSelectedIndex());
                        archivedMessages.setSelectedIndex(index);
                        archivedMessageUsernamesList.remove(index);
                        MessagePresenter.markRead(archivedMessageIDList.get(index));
                        archivedMessageIDList.remove(index);
                    }
                }
            });

            inboxDeleteButton = new JButton("Delete");
            inboxDeleteButton.setBounds(350, 260, 100, 25);
            DisplayMessagesPanel.add(inboxDeleteButton);
            inboxDeleteButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(inboxMessages.getSelectedIndex() != 0){
                        deleted = true;
                        int index = inboxMessages.getSelectedIndex() - 1;
                        MessagePresenter.deleteMessage(inboxMessageIDList.get(index));
                        inboxMessages.removeItemAt(inboxMessages.getSelectedIndex());
                        inboxMessages.setSelectedIndex(index);
                        inboxMessageUsernamesList.remove(index);
                        inboxMessageIDList.remove(index);
                    }
                }
            });

            archiveDeleteButton = new JButton("Delete");
            archiveDeleteButton.setBounds(350, 260, 100, 25);
            DisplayMessagesPanel.add(archiveDeleteButton);
            archiveDeleteButton.setVisible(false);
            archiveDeleteButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(archivedMessages.getSelectedIndex() != 0){
                        deleted = true;
                        int index = archivedMessages.getSelectedIndex() - 1;
                        MessagePresenter.deleteMessage(archivedMessageIDList.get(index));
                        archivedMessages.removeItemAt(archivedMessages.getSelectedIndex());
                        archivedMessages.setSelectedIndex(index);
                        archivedMessageUsernamesList.remove(index);
                        archivedMessageIDList.remove(index);
                    }
                }
            });

            inboxMessages.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(currentMessageID != -1 && changeRead && !deleted){
                        MessagePresenter.markRead(currentMessageID);
                    }

                    if (inboxMessages.getSelectedIndex() != 0){
                        String text = "";
                        text += "Status: " + MessagePresenter.getMessageStatus(inboxMessageIDList.get(inboxMessages.getSelectedIndex()-1)) + "\n";
                        text += "Message: " + MessagePresenter.getMessageContent(inboxMessageIDList.get(inboxMessages.getSelectedIndex()-1));
                        message.setText(text);
                        currentMessageID = inboxMessageIDList.get(inboxMessages.getSelectedIndex()-1);
                        changeRead = true;
                        deleted = false;
                    } else {
                        message.setText("");
                    }
                }
            });

            archivedMessages.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (archivedMessages.getSelectedIndex() != 0){
                        String text = "";
                        text += "Status: " + MessagePresenter.getMessageStatus(archivedMessageIDList.get(archivedMessages.getSelectedIndex()-1)) + "\n";
                        text += "Message: " + MessagePresenter.getMessageContent(archivedMessageIDList.get(archivedMessages.getSelectedIndex()-1));
                        message.setText(text);
                        currentMessageID = archivedMessageIDList.get(archivedMessages.getSelectedIndex()-1);
                        changeRead = true;
                        deleted = false;
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
            archiveButton.setVisible(false);
            unArchiveButton.setVisible(true);
            archiveDeleteButton.setVisible(true);
            inboxDeleteButton.setVisible(false);
            inboxMessages.setVisible(false);
            archivedMessages.setVisible(true);
            archive = true;
            inbox = false;
        });

        inboxButton.addActionListener(e -> {
            archivedButton.setVisible(true);
            inboxButton.setVisible(false);
            archiveButton.setVisible(true);
            unArchiveButton.setVisible(false);
            archiveDeleteButton.setVisible(false);
            inboxDeleteButton.setVisible(true);
            inboxMessages.setVisible(true);
            archivedMessages.setVisible(false);
            inbox = true;
            archive = false;
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
