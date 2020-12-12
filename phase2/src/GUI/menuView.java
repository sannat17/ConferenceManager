package GUI;

import GUIPresenters.MenuPresenter;
import GUIPresenters.SignoutPresenter;

import javax.swing.*;

public class menuView {
    /** Creates the JPanel for the menu
     *
     * @return JPanel of the menu
     */
    public static JPanel getMenuPanel(){
        JPanel MenuPanel = new JPanel();
        MenuPanel.setLayout(null);

        String[] menuOptions = MenuPresenter.menuOptions();
        JComboBox<String> menuComboBox = new JComboBox<>(menuOptions);
        menuComboBox.setBounds(10, 20, 160, 25);
        menuComboBox.setSelectedIndex(0);
        MenuPanel.add(menuComboBox);

        JButton confirmButton = new JButton("Confirm");
        confirmButton.setBounds(10, 60, 160, 25);
        MenuPanel.add(confirmButton);
        confirmButton.addActionListener(e -> MenuPresenter.nextPanel((String) menuComboBox.getSelectedItem()));

        JButton signoutButton = new JButton("Sign Out");
        signoutButton.setBounds(10, 260, 100, 25);
        MenuPanel.add(signoutButton);
        signoutButton.addActionListener(e -> SignoutPresenter.signOut());


        return MenuPanel;
    }
}
