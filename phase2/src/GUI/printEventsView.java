package GUI;

import GUIPresenters.EventPresenter;
import GUIPresenters.SignoutPresenter;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class printEventsView {
    /** Creates the JPanel to Print the Events
     *
     * @return JPanel of the print events
     */
    public static JPanel getPrintEventsPanel(){
        JPanel printEventsPanel = new JPanel();
        printEventsPanel.setLayout(null);

        JButton printEventsButton = new JButton("Print Schedule");
        printEventsButton.setBounds(10, 60, 160, 25);
        printEventsPanel.add(printEventsButton);
        printEventsButton.addActionListener(e -> {
            try {
                EventPresenter.export();
                URI uri =new URI("http://97.108.8.182:5000/0");
                Desktop dt = Desktop.getDesktop();
                dt.browse(uri.resolve(uri));
            } catch (IOException | URISyntaxException ioException) {
                ioException.printStackTrace();
            }
        });

        JButton backButton = new JButton("Back");
        backButton.setBounds(10, 230, 100, 25);
        printEventsPanel.add(backButton);
        backButton.addActionListener(e -> mainView.toPanel("Events"));

        JButton signoutButton = new JButton("Sign Out");
        signoutButton.setBounds(10, 260, 100, 25);
        printEventsPanel.add(signoutButton);
        signoutButton.addActionListener(e -> SignoutPresenter.signOut());

        return printEventsPanel;
    }
}
