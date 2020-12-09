package GUI;

import GUIPresenters.LoginPresenter;
import GUIPresenters.SignoutPresenter;
import entities.User;
import gateways.EventIO;
import gateways.MessageIO;
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

    public mainView(){
        createUI();
    }

    private void createUI(){
        LoginPresenter.readFiles();
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

    public static void addPanels(){
        mainContainer.add(menuView.getMenuPanel(), "Menu");
        mainContainer.add(createUserView.getCreateUserPanel(), "Create User");
        mainContainer.add(eventView.getEventView(), "Events");
        mainContainer.add(yourEventsView.getYourEventsPanel(), "Your Events");
        mainContainer.add(signUpEventView.getSignUpEventPanel(), "Sign Up for Event");
        mainContainer.add(cancelSignUpEventView.getCancelSignUpEventPanel(), "Cancel Sign Up for Event");
        mainContainer.add(organizeEvent.getOrganizeEventPanel(), "Organize event");
        mainContainer.add(messageView.getMessageView(), "Messages");
        mainContainer.add(displayMessagesView.getDisplayMessagesPanel(), "Display Messages");
        mainContainer.add(cancelEventView.getCancelEventPanel(), "Cancel Event");
        mainContainer.add(additionalUserRequestsView.getAdditionalUserRequestsPanel(), "Additional Requests");
    }

    public static void createPopUp(String message) {
        JOptionPane.showMessageDialog(mainFrame, message);
    }

    public static void toPanel(String name){
        addPanels();
        mainCL.show(mainContainer, name);
    }

    public static void toLoginPanel(){
        mainContainer.add(loginView.getLoginPanel(), "Login");
        mainCL.show(mainContainer, "Login");
    }

    public static void toMessageUserPanel(String type){
        mainContainer.add(messageUserView.getMessageUserView(type), "Message User");
        mainCL.show(mainContainer, "Message User");
    }

}
