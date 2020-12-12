package GUI;

import GUIPresenters.EventPresenter;
import GUIPresenters.SignoutPresenter;

import javax.swing.*;

public class cancelEventView {
    /** Creates the JPanel to cancel event
     *
     * @return JPanel of the cancel event
     */
    public static JPanel getCancelEventPanel(){
        JPanel cancelEventPanel = new JPanel();
        cancelEventPanel.setLayout(null);

        JComboBox eventsComboBox = new JComboBox(EventPresenter.getOrganizingTitles().toArray(new String[0]));
        eventsComboBox.setBounds(10, 20, 160, 25);
        cancelEventPanel.add(eventsComboBox);

        JButton cancelEventButton = new JButton("Cancel Event");
        cancelEventButton.setBounds(10, 60, 160, 25);
        cancelEventPanel.add(cancelEventButton);
        cancelEventButton.addActionListener(e -> EventPresenter.cancelEvent((String) eventsComboBox.getSelectedItem()));


        JButton backButton = new JButton("Back");
        backButton.setBounds(10, 230, 100, 25);
        cancelEventPanel.add(backButton);
        backButton.addActionListener(e -> mainView.toPanel("Events"));

        JButton signoutButton = new JButton("Sign Out");
        signoutButton.setBounds(10, 260, 100, 25);
        cancelEventPanel.add(signoutButton);
        signoutButton.addActionListener(e -> SignoutPresenter.signOut());

        return cancelEventPanel;
    }
}
