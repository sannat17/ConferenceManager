package GUI;

import GUIPresenters.LoginPresenter;
import GUIPresenters.SignoutPresenter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class mainView {
    private static JFrame mainFrame;
    private static JPanel mainContainer;
    private static CardLayout mainCL;
    private JPanel loginPanel;

    /**
     * Calls the createUI() and creates an instance of it
     */
    public mainView(){
        createUI();
    }

    /**
     * Creates the GUI for the program
     */
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

    /**
     * Adds all the panels to the Frame
     */
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
        mainContainer.add(printEventsView.getPrintEventsPanel(), "Print Events");
        mainContainer.add(additionalUserRequestsView.getAdditionalUserRequestsPanel(), "Additional Requests");
        mainContainer.add(messageAllAttendeesOfTalkView.getMessageAllAttendeesOfTalkView(), "Message Attendees of A Talk");
        mainContainer.add(messageAllAttendeesOfEventView.getMessageAllAttendeesOfTalkView(), "Message Attendees of An Event");
    }

    /**
     * Creates a pop up with a message
     * @param message The message that will be put on the pop up
     */
    public static void createPopUp(String message) {
        JOptionPane.showMessageDialog(mainFrame, message);
    }

    /**
     * Goes to the next panel
     * @param name The name of the panel you want to go to
     */
    public static void toPanel(String name){
        addPanels();
        mainCL.show(mainContainer, name);
    }

    /**
     * Goes to the login panel
     */
    public static void toLoginPanel(){
        mainContainer.add(loginView.getLoginPanel(), "Login");
        mainCL.show(mainContainer, "Login");
    }

    /**
     * Goes to the MessageUserPanel
     * @param type The type of user
     */
    public static void toMessageUserPanel(String type){
        mainContainer.add(messageUserView.getMessageUserView(type), "Message User");
        mainCL.show(mainContainer, "Message User");
    }

    public static void toMessageAllUsersPanel(String type){
        mainContainer.add(messageAllUsersView.getMessageAllUserView(type), "Message all Users");
        mainCL.show(mainContainer, "Message all Users");
    }

    public static void toReplyPanel(String content, int replyID, String recipientName){
        mainContainer.add(replyView.getReplyPanel(content, replyID, recipientName), "Reply");
        mainCL.show(mainContainer, "Reply");
    }

}
