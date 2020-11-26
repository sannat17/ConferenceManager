package GUI;

import GUIPresenters.SignoutPresenter;

import javax.swing.*;

public class menuOrganizerView {
    public static JPanel getOrganizerMenuPanel(){
        JPanel organizerMenuPanel = new JPanel();
        organizerMenuPanel.setLayout(null);

        String[] menuOptions = {"Messages", "Events","Create User"};
        JComboBox menuComboBox = new JComboBox(menuOptions);
        menuComboBox.setBounds(10, 20, 160, 25);
        menuComboBox.setSelectedIndex(0);
        organizerMenuPanel.add(menuComboBox);

        JButton confirmButton = new JButton("Confirm");
        confirmButton.setBounds(10, 60, 160, 25);
        organizerMenuPanel.add(confirmButton);

        JButton signoutButton = new JButton("Sign Out");
        signoutButton.setBounds(10, 260, 100, 25);
        organizerMenuPanel.add(signoutButton);
        signoutButton.addActionListener(e -> SignoutPresenter.signOut());


        return organizerMenuPanel;
    }
}
