package GUI;

import GUIPresenters.EventPresenter;
import GUIPresenters.SignoutPresenter;

import javax.swing.*;

public class yourEventsView {
    /** Creates the JPanel to get your events
     *
     * @return JPanel of the get your events
     */
    public static JPanel getYourEventsPanel(){
        JPanel yourEventsPanel = new JPanel();
        yourEventsPanel.setLayout(null);

        String[] viewTypes = {"Title", "Time", "Speaker"};
        JComboBox<String> eventsViewComboBox = new JComboBox<>(viewTypes);
        eventsViewComboBox.setBounds(10, 20, 165, 25);
        eventsViewComboBox.setSelectedIndex(0);
        yourEventsPanel.add(eventsViewComboBox);

        JButton confirmTypeButton = new JButton("Confirm");
        confirmTypeButton.setBounds(10, 60, 160, 25);
        yourEventsPanel.add(confirmTypeButton);

        JTextArea yourEventsField = new JTextArea();
        yourEventsField.setBounds(10, 100, 250, 110);
        yourEventsField.setEditable(false);
        yourEventsPanel.add(yourEventsField);

        confirmTypeButton.addActionListener(e -> yourEventsField.setText(EventPresenter.formatSchedule(
                (String)eventsViewComboBox.getSelectedItem())));

        JButton backButton = new JButton("Back");
        backButton.setBounds(10, 230, 100, 25);
        yourEventsPanel.add(backButton);
        backButton.addActionListener(e -> mainView.toPanel("Events"));

        JButton signoutButton = new JButton("Sign Out");
        signoutButton.setBounds(10, 260, 100, 25);
        yourEventsPanel.add(signoutButton);
        signoutButton.addActionListener(e -> SignoutPresenter.signOut());

        return yourEventsPanel;
    }
}
