package GUI;

import GUIPresenters.EventPresenter;
import GUIPresenters.SignoutPresenter;
import entities.User;

import javax.swing.*;

public class signUpEventView {
    public static JPanel getSignUpEventPanel(User u){
        JPanel signUpEventPanel = new JPanel();
        signUpEventPanel.setLayout(null);

        JComboBox eventsComboBox = new JComboBox(EventPresenter.getSignUpEventTitle(u).toArray(new String[0]));
        eventsComboBox.setBounds(10, 20, 160, 25);
        signUpEventPanel.add(eventsComboBox);

        JButton signUpButton = new JButton("Sign Up");
        signUpButton.setBounds(10, 60, 160, 25);
        signUpEventPanel.add(signUpButton);
        signUpButton.addActionListener(e -> EventPresenter.signUpForEvent(u, (String)eventsComboBox.getSelectedItem()));

        JButton backButton = new JButton("Back");
        backButton.setBounds(10, 230, 100, 25);
        signUpEventPanel.add(backButton);
        backButton.addActionListener(e -> mainView.toEventsPanel(u));

        JButton signoutButton = new JButton("Sign Out");
        signoutButton.setBounds(10, 260, 100, 25);
        signUpEventPanel.add(signoutButton);
        signoutButton.addActionListener(e -> SignoutPresenter.signOut());

        return signUpEventPanel;

    }
}
