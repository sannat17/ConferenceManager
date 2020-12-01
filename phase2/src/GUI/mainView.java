package GUI;

import GUIPresenters.SignoutPresenter;
import entities.User;
import gateways.UserIO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class mainView {
    private static JFrame mainFrame;
    private static JPanel mainContainer;
    private static CardLayout mainCL;
    private JPanel loginPanel;
    private static JPanel MenuPanel;
    private static JPanel createUserPanel;
    private static JPanel eventPanel;
    private static JPanel yourEventsPanel;

    public mainView(){
        createUI();
    }

    private void createUI(){
        loginPanel = loginView.getLoginPanel();
        mainFrame = new JFrame();
        mainCL = new CardLayout(5,5);
        mainContainer = new JPanel(mainCL);
        mainContainer.add(loginPanel, "Login");
        mainFrame.setSize(500, 350);
        mainFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                SignoutPresenter.writeFiles();
                System.exit(0);
            }
        });
        mainFrame.add(mainContainer);

        mainFrame.setVisible(true);
        mainCL.show(mainContainer, "Login");

    }

    public static void createPopUp(String message) {
        JOptionPane.showMessageDialog(mainFrame, message);
    }

    public static void toMenuPanel(User u){
        MenuPanel = menuView.getMenuPanel(u);
        mainContainer.add(MenuPanel, "Menu");
        mainCL.show(mainContainer, "Menu");
    }

    public static void toLoginPanel(){
        mainCL.show(mainContainer, "Login");
    }

    public static void toCreateUserPanel(User u){
        createUserPanel = createUserView.getCreateUserPanel(u);
        mainContainer.add(createUserPanel, "Create User");
        mainCL.show(mainContainer, "Create User");
    }

    public static void toEventsPanel(User u){
        eventPanel = eventView.getEventView(u);
        mainContainer.add(eventPanel, "Events");
        mainCL.show(mainContainer, "Events");
    }

    public static void toYourEventsPanel(User u){
        yourEventsPanel = yourEventsView.getYourEventsPanel(u);
        mainContainer.add(yourEventsPanel, "Your Events");
        mainCL.show(mainContainer, "Your Events");
    }

    public static void main(String[] args) {
        UserIO.readFile();
        new mainView();
    }
}
