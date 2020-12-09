package GUI;

import GUIPresenters.SignoutPresenter;

import javax.swing.*;

public class printEventsView {
    public static JPanel getPrintEventsPanel(){
        JPanel printEventsPanel = new JPanel();
        printEventsPanel.setLayout(null);

        JComboBox<String> sortingComboBox = new JComboBox<>();
        sortingComboBox.setBounds(10, 20, 165, 25);
        sortingComboBox.setSelectedIndex(0);
        printEventsPanel.add(sortingComboBox);

        JButton printEventsButton = new JButton("Print Events");
        printEventsButton.setBounds(10, 60, 160, 25);
        printEventsPanel.add(printEventsButton);
//        printEventsButton.addActionListener(e -> );

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
