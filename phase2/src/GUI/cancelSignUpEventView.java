package GUI;

import GUIPresenters.EventPresenter;
import GUIPresenters.SignoutPresenter;
import entities.User;

import javax.swing.*;

public class cancelSignUpEventView {
    public static JPanel getCancelSignUpEventPanel(User u){
        JPanel CancelSignUpEventPanel = new JPanel();
        CancelSignUpEventPanel.setLayout(null);

        JComboBox eventsComboBox = new JComboBox(EventPresenter.getAttending(u).toArray(new String[0]));
        eventsComboBox.setBounds(10, 20, 160, 25);
        CancelSignUpEventPanel.add(eventsComboBox);

        JButton cancelSignUpButton = new JButton("Cancel Sign Up");
        cancelSignUpButton.setBounds(10, 60, 160, 25);
        CancelSignUpEventPanel.add(cancelSignUpButton);
        cancelSignUpButton.addActionListener(e -> EventPresenter.cancelSpotEvent(u, (String) eventsComboBox.getSelectedItem()));

        JButton backButton = new JButton("Back");
        backButton.setBounds(10, 230, 100, 25);
        CancelSignUpEventPanel.add(backButton);
        backButton.addActionListener(e -> mainView.toEventsPanel(u));

        JButton signoutButton = new JButton("Sign Out");
        signoutButton.setBounds(10, 260, 100, 25);
        CancelSignUpEventPanel.add(signoutButton);
        signoutButton.addActionListener(e -> SignoutPresenter.signOut());

        return CancelSignUpEventPanel;

    }
}
