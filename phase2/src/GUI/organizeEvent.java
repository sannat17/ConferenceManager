package GUI;

import GUIPresenters.EventPresenter;
import GUIPresenters.SignoutPresenter;

import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

public class organizeEvent {
    /** Creates the JPanel to Organize Event
     *
     * @return JPanel of the Organize Event
     */
    public static JPanel getOrganizeEventPanel(){
        JPanel organizeEventPanel = new JPanel();
        organizeEventPanel.setLayout(null);

        JLabel titleLabel = new JLabel("Event Title:");
        titleLabel.setBounds(10, 20, 80, 25);
        organizeEventPanel.add(titleLabel);

        JTextField titleTextField = new JTextField();
        titleTextField.setBounds(290, 20, 165, 25);
        organizeEventPanel.add(titleTextField);

        //Check date and time is in correct format
        JLabel timeLabel = new JLabel("Date and time (dd-MMM-yyyy HH:mm:ss):");
        timeLabel.setBounds(10, 50, 280, 25);
        organizeEventPanel.add(timeLabel);

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
        Date date = new Date();
        JTextField timeTextField = new JTextField(sdf.format(date));
        timeTextField.setBounds(290, 50, 165, 25);
        organizeEventPanel.add(timeTextField);

        //Check room number and create a pop up box if its not correct
        JLabel roomLabel = new JLabel("Room Number");
        roomLabel.setBounds(10,80, 100, 25);
        organizeEventPanel.add(roomLabel);

        NumberFormat roomFormat = NumberFormat.getInstance();
        NumberFormatter roomFormatter = new NumberFormatter(roomFormat);
        roomFormatter.setValueClass(Integer.class);
        roomFormatter.setMinimum(0);
        roomFormatter.setMaximum(Integer.MAX_VALUE);
        roomFormatter.setAllowsInvalid(false);
        roomFormatter.setCommitsOnValidEdit(true);
        JFormattedTextField roomTextField = new JFormattedTextField(roomFormatter);
        roomTextField.setBounds(290, 80, 165, 25);
        organizeEventPanel.add(roomTextField);

        //Check speakers etc...
        JLabel speakersLabel = new JLabel("Select Speaker(s)");
        speakersLabel.setBounds(10, 110, 150, 25);
        organizeEventPanel.add(speakersLabel);

        DefaultListModel<String> speakers = EventPresenter.getSpeakers();
        DefaultListModel<String> selectedSpeaker = new DefaultListModel<>();

        JList<String> speakersList = new JList(speakers);
        speakersList.setSelectedIndex(0);
        JScrollPane speakersScrollPane = new JScrollPane(speakersList);
        speakersScrollPane.setBounds(180, 110, 110, 60);
        organizeEventPanel.add(speakersScrollPane);

        JList<String> selectedSpeakersList = new JList(selectedSpeaker);
        JScrollPane selectedSpeakersScrollPane = new JScrollPane(selectedSpeakersList);
        selectedSpeakersScrollPane.setBounds(300, 110, 110, 60);
        organizeEventPanel.add(selectedSpeakersScrollPane);

        JButton speakerButton = new JButton("Select Speaker");
        speakerButton.setBounds(10, 140, 150, 25);
        organizeEventPanel.add(speakerButton);
        speakerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = speakersList.getSelectedIndex();
                selectedSpeaker.addElement(speakers.get(selectedIndex));
                speakers.remove(selectedIndex);
            }
        });

        //Make boolean
        JLabel vip = new JLabel("VIP Event?:");
        vip.setBounds(10, 170, 100, 25);
        organizeEventPanel.add(vip);

        JComboBox vipComboBox = new JComboBox(new String[]{"false", "true"});
        vipComboBox.setBounds(290, 170, 165, 25);
        organizeEventPanel.add(vipComboBox);

        //Check if it is a number
        JLabel maxCapacityLabel = new JLabel("Max Capacity:");
        maxCapacityLabel.setBounds(10, 200, 100, 25);
        organizeEventPanel.add(maxCapacityLabel);

        NumberFormat maxCapacityFormat = NumberFormat.getInstance();
        NumberFormatter maxCapacityFormatter = new NumberFormatter(maxCapacityFormat);
        maxCapacityFormatter.setValueClass(Integer.class);
        maxCapacityFormatter.setMinimum(0);
        maxCapacityFormatter.setMaximum(Integer.MAX_VALUE);
        maxCapacityFormatter.setAllowsInvalid(false);
        maxCapacityFormatter.setCommitsOnValidEdit(true);
        JFormattedTextField maxCapacityTextField = new JFormattedTextField(maxCapacityFormatter);
        maxCapacityTextField.setBounds(290, 200, 165, 25);
        organizeEventPanel.add(maxCapacityTextField);

        JButton confirmButton = new JButton("Confirm");
        confirmButton.setBounds(290, 230, 100, 25);
        organizeEventPanel.add(confirmButton);
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String dateTime = timeTextField.getText();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy HH:mm:ss");
                    LocalDateTime eventDate = LocalDateTime.parse(dateTime, formatter);
                    EventPresenter.makeEvent(titleTextField.getText(), eventDate,
                            Integer.parseInt(roomTextField.getText()), selectedSpeaker,
                            Boolean.parseBoolean((String)vipComboBox.getSelectedItem()),
                            Integer.parseInt(maxCapacityTextField.getText()));

                }
                catch (DateTimeParseException a){
                    mainView.createPopUp("Please enter a valid format, For Example, November 20th 2020 at 6:35:05PM " +
                            "will be written as 20-Nov-2020 18:35:05:");
                }
            }
        });

        JButton backButton = new JButton("Back");
        backButton.setBounds(10, 230, 100, 25);
        organizeEventPanel.add(backButton);
        backButton.addActionListener(e -> mainView.toPanel("Events"));

        JButton signoutButton = new JButton("Sign Out");
        signoutButton.setBounds(10, 260, 100, 25);
        organizeEventPanel.add(signoutButton);
        signoutButton.addActionListener(e -> SignoutPresenter.signOut());

        return organizeEventPanel;
    }
}
