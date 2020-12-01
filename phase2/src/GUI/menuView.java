package GUI;

import GUIPresenters.MenuPresenter;
import GUIPresenters.SignoutPresenter;
import entities.User;

import javax.swing.*;

public class menuView {
    public static JPanel getMenuPanel(User u){
        JPanel organizerMenuPanel = new JPanel();
        organizerMenuPanel.setLayout(null);

        String[] menuOptions = MenuPresenter.menuOptions(u);
        JComboBox menuComboBox = new JComboBox(menuOptions);
        menuComboBox.setBounds(10, 20, 160, 25);
        menuComboBox.setSelectedIndex(0);
        organizerMenuPanel.add(menuComboBox);

        JButton confirmButton = new JButton("Confirm");
        confirmButton.setBounds(10, 60, 160, 25);
        organizerMenuPanel.add(confirmButton);
        confirmButton.addActionListener(e -> MenuPresenter.nextPanel((String)menuComboBox.getSelectedItem(), u));

        JButton signoutButton = new JButton("Sign Out");
        signoutButton.setBounds(10, 260, 100, 25);
        organizerMenuPanel.add(signoutButton);
        signoutButton.addActionListener(e -> SignoutPresenter.signOut());


        return organizerMenuPanel;
    }
}
