package GUI;

import GUIPresenters.MessagePresenter;
import GUIPresenters.SignoutPresenter;

import javax.swing.*;

public class replyView {

    public static JPanel getReplyPanel(String content, int replyID, String recipientName) {
        JPanel replyPanel = new JPanel();
        replyPanel.setLayout(null);

        String text = "From: "+recipientName+"\n"+"Message: "+content;

        JTextArea message = new JTextArea(text);
        message.setLineWrap(true);
        message.setWrapStyleWord(true);
        message.setEditable(false);
        JScrollPane messageScrollPanel = new JScrollPane(message);
        messageScrollPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        messageScrollPanel.setBounds(10, 20, 200, 200);
        replyPanel.add(messageScrollPanel);

        JTextArea reply = new JTextArea();
        reply.setLineWrap(true);
        reply.setWrapStyleWord(true);
        JScrollPane replyScrollPanel = new JScrollPane(reply);
        replyScrollPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        replyScrollPanel.setBounds(220, 20, 200, 200);
        replyPanel.add(replyScrollPanel);

        JButton replyButton = new JButton("Reply");
        replyButton.setBounds(270, 230, 100, 25);
        replyPanel.add(replyButton);
        replyButton.addActionListener(e -> MessagePresenter.reply(MessagePresenter.getUsersID(recipientName),replyID,reply.getText()));

        JButton backButton = new JButton("Back");
        backButton.setBounds(10, 230, 100, 25);
        replyPanel.add(backButton);
        backButton.addActionListener(e -> mainView.toPanel("Messages"));

        JButton signoutButton = new JButton("Sign Out");
        signoutButton.setBounds(10, 260, 100, 25);
        replyPanel.add(signoutButton);
        signoutButton.addActionListener(e -> SignoutPresenter.signOut());


        return replyPanel;
    }
}
