package GUI;

import GUIPresenters.EventPresenter;
import GUIPresenters.SignoutPresenter;

import javax.swing.*;
import java.io.IOException;

public class printEventsView {
    public static JPanel getPrintEventsPanel(){
        JPanel printEventsPanel = new JPanel();
        printEventsPanel.setLayout(null);

        JButton printEventsButton = new JButton("Print Schedule");
        printEventsButton.setBounds(10, 60, 160, 25);
        printEventsPanel.add(printEventsButton);
        printEventsButton.addActionListener(e -> {
            try {
                EventPresenter.export();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });

        JButton backButton = new JButton("Back");
        backButton.setBounds(10, 230, 100, 25);
        printEventsPanel.add(backButton);
        backButton.addActionListener(e -> mainView.toPanel("Events"));

        JButton signoutButton = new JButton("Sign Out");
        signoutButton.setBounds(10, 260, 100, 25);
        printEventsPanel.add(signoutButton);
        signoutButton.addActionListener(e -> SignoutPresenter.signOut());

        return printEventsPanel;
    }
}
