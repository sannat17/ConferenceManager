package GUI;

import GUIPresenters.EventPresenter;
import GUIPresenters.SignoutPresenter;

import javax.swing.*;

public class eventView {
    /** Creates the JPanel for the event menu
     *
     * @return JPanel of the event menu
     */
    public static JPanel getEventView(){
        JPanel eventPanel = new JPanel();
        eventPanel.setLayout(null);

        String[] eventOptions = EventPresenter.eventOptions();
        JComboBox<String> eventComboBox = new JComboBox<>(eventOptions);
        eventComboBox.setBounds(10, 20, 160, 25);
        eventComboBox.setSelectedIndex(0);
        eventPanel.add(eventComboBox);

        JButton confirmButton = new JButton("Confirm");
        confirmButton.setBounds(10, 60, 160, 25);
        eventPanel.add(confirmButton);
        confirmButton.addActionListener(e -> EventPresenter.nextEventPanel((String)eventComboBox.getSelectedItem()));

        JButton backButton = new JButton("Back");
        backButton.setBounds(10, 230, 100, 25);
        eventPanel.add(backButton);
        backButton.addActionListener(e -> mainView.toPanel("Menu"));

        JButton signoutButton = new JButton("Sign Out");
        signoutButton.setBounds(10, 260, 100, 25);
        eventPanel.add(signoutButton);
        signoutButton.addActionListener(e -> SignoutPresenter.signOut());

        return eventPanel;
    }
}
