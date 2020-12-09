package GUI;

import GUIPresenters.MessagePresenter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class displayMessagesView {

    public static JPanel getDisplayMessagesPanel() {
        JPanel DisplayMessagesPanel = new JPanel();
        DisplayMessagesPanel.setLayout(null);
        HashMap<Integer, String> messageHash = MessagePresenter.messageUsernamnes();
        ArrayList<String> messageUsernamesList = new ArrayList<>(messageHash.values());
        ArrayList<Integer> messageIDList = new ArrayList<>(messageHash.keySet());
        messageUsernamesList.add(0,"Select an Option");
        String [] messageUsernames = messageUsernamesList.toArray(new String[0]);


        if (messageUsernames.length > 0) {
            JComboBox<String> messages = new JComboBox<>(messageUsernames);
            messages.setBounds(10, 20, 160, 25);
            messages.setSelectedIndex(0);
            DisplayMessagesPanel.add(messages);
            if (messages.getSelectedIndex() != 0){
                System.out.println("Hello World");
            }
            JLabel message = new JLabel("");
            message.setBounds(10, 80, 50, 20);
            DisplayMessagesPanel.add(message);
            message.setVisible(false);
            messages.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (messages.getSelectedIndex() != 0){
                        message.setText(MessagePresenter.getMessageContent(messageIDList.get(messages.getSelectedIndex()-1)));
                        message.setVisible(true);
                    }
                }
            });
        } else {
            JLabel noMessages = new JLabel("No Messages to Display!");
            noMessages.setBounds(10, 20, 80, 25);
            DisplayMessagesPanel.add(noMessages);
        }

        JButton backButton = new JButton("Back");
        backButton.setBounds(10, 230, 100, 25);
        DisplayMessagesPanel.add(backButton);
        backButton.addActionListener(e -> mainView.toPanel("Menu"));

        return DisplayMessagesPanel;
    }

    public static void showMessage(String message, JPanel panel){
        JLabel content = new JLabel(message);
        content.setBounds(10, 80, 50, 20);
        panel.add(content);

    }
}
