package GUI;

import GUIPresenters.SignoutPresenter;
import GUIPresenters.additionalUserRequestsPresenter;

import javax.swing.*;

public class additionalUserRequestsView {
    /** Creates the JPanel for additional user request
     *
     * @return JPanel of the additional user requests
     */
    public static JPanel getAdditionalUserRequestsPanel() {
        JPanel additionalUserRequestsPanel = new JPanel();
        additionalUserRequestsPanel.setLayout(null);

        String[] viewTypes = {"Dietary Restrictions", "Accessibility Requirements"};
        JComboBox<String> additionalUserRequestsComboBox = new JComboBox<>(viewTypes);
        additionalUserRequestsComboBox.setBounds(10, 20, 165, 25);
        additionalUserRequestsComboBox.setSelectedIndex(0);
        additionalUserRequestsPanel.add(additionalUserRequestsComboBox);

        JButton confirmTypeButton = new JButton("Confirm");
        confirmTypeButton.setBounds(10, 60, 160, 25);
        additionalUserRequestsPanel.add(confirmTypeButton);

        JTextArea userRequestsField = new JTextArea();
        userRequestsField.setLineWrap(true);
        userRequestsField.setWrapStyleWord(true);
        JScrollPane JScrollPanel = new JScrollPane(userRequestsField);
        JScrollPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        JScrollPanel.setBounds(10, 100, 250, 110);
        userRequestsField.setEditable(false);
        additionalUserRequestsPanel.add(JScrollPanel);

        confirmTypeButton.addActionListener(e -> userRequestsField.setText(
                additionalUserRequestsPresenter.formatAdditionalUserRequests((String)additionalUserRequestsComboBox.getSelectedItem())));

        JButton backButton = new JButton("Back");
        backButton.setBounds(10, 230, 100, 25);
        additionalUserRequestsPanel.add(backButton);
        backButton.addActionListener(e -> mainView.toPanel("Menu"));

        JButton signoutButton = new JButton("Sign Out");
        signoutButton.setBounds(10, 260, 100, 25);
        additionalUserRequestsPanel.add(signoutButton);
        signoutButton.addActionListener(e -> SignoutPresenter.signOut());

        return additionalUserRequestsPanel;
    }

}
