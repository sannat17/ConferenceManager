package GUI;

import GUIPresenters.EventPresenter;
import GUIPresenters.MenuPresenter;
import GUIPresenters.SignoutPresenter;
import entities.User;

import javax.swing.*;

public class eventView {
    public static JPanel getEventView(User u){
        JPanel eventPanel = new JPanel();
        eventPanel.setLayout(null);

        String[] eventOptions = EventPresenter.eventOptions(u);
        JComboBox<String> eventComboBox = new JComboBox<>(eventOptions);
        eventComboBox.setBounds(10, 20, 160, 25);
        eventComboBox.setSelectedIndex(0);
        eventPanel.add(eventComboBox);

        JButton confirmButton = new JButton("Confirm");
        confirmButton.setBounds(10, 60, 160, 25);
        eventPanel.add(confirmButton);
        confirmButton.addActionListener(e -> EventPresenter.nextEventPanel((String)eventComboBox.getSelectedItem(), u));

        JButton backButton = new JButton("Back");
        backButton.setBounds(10, 230, 100, 25);
        eventPanel.add(backButton);
        backButton.addActionListener(e -> mainView.toMenuPanel(u));

        JButton signoutButton = new JButton("Sign Out");
        signoutButton.setBounds(10, 260, 100, 25);
        eventPanel.add(signoutButton);
        signoutButton.addActionListener(e -> SignoutPresenter.signOut());

        return eventPanel;
    }
}
