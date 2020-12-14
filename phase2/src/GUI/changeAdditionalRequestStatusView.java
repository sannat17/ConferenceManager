package GUI;

import GUIPresenters.SignoutPresenter;
import GUIPresenters.changeRequestStatusPresenter;

import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.text.NumberFormat;

public class changeAdditionalRequestStatusView {

    /** Creates the JPanel for change user request status
     *
     * @return JPanel of the change user requests status
     */
    public static JPanel getChangeRequestStatusPanel(){
        JPanel additionalRequests = new JPanel();
        additionalRequests.setLayout(null);


        String[] viewTypes = {"Change Dietary Restrictions Status", "Change Accessibility Requirements Status"};
        JComboBox<String> changeUserRequestsComboBox = new JComboBox<>(viewTypes);
        changeUserRequestsComboBox.setBounds(10, 20, 260, 25);
        changeUserRequestsComboBox.setSelectedIndex(0);
        additionalRequests.add(changeUserRequestsComboBox);

        JLabel userID = new JLabel("User ID");
        userID.setBounds(10,80, 100, 25);
        additionalRequests.add(userID);

        NumberFormat userIDFormat = NumberFormat.getInstance();
        NumberFormatter userIDFormatter = new NumberFormatter(userIDFormat);
        userIDFormatter.setValueClass(Integer.class);
        userIDFormatter.setMinimum(0);
        userIDFormatter.setMaximum(Integer.MAX_VALUE);
        userIDFormatter.setAllowsInvalid(false);
        userIDFormatter.setCommitsOnValidEdit(true);
        JFormattedTextField userIDDField = new JFormattedTextField(userIDFormatter);
        userIDDField.setBounds(290, 80, 165, 25);
        additionalRequests.add(userIDDField);

        JLabel newStatus = new JLabel("New Status");
        newStatus.setBounds(10, 120, 100, 25);
        additionalRequests.add(newStatus);

        JTextField newStatusTextField = new JTextField();
        newStatusTextField.setBounds(290, 120, 165, 25);
        additionalRequests.add(newStatusTextField);

        JButton confirmButton = new JButton("Confirm");
        confirmButton.setBounds(10, 200, 100, 25);
        additionalRequests.add(confirmButton);
        confirmButton.addActionListener(e -> {
            changeRequestStatusPresenter.changeRequestStatus(
                    Integer.parseInt(userIDDField.getText()),
                    (String)changeUserRequestsComboBox.getSelectedItem(),
                    newStatusTextField.getText());
            changeRequestStatusPresenter.createMessagePopUp("Status Changed");
        });

        JButton backButton = new JButton("Back");
        backButton.setBounds(10, 230, 100, 25);
        additionalRequests.add(backButton);
        backButton.addActionListener(e -> mainView.toPanel("Menu"));

        JButton signoutButton = new JButton("Sign Out");
        signoutButton.setBounds(10, 260, 100, 25);
        additionalRequests.add(signoutButton);
        signoutButton.addActionListener(e -> SignoutPresenter.signOut());

        return additionalRequests;
    }
}
