package GUI;

import gateways.UserIO;

import javax.swing.*;
import java.awt.*;

public class mainView {
    private static JFrame mainFrame;
    private static JPanel mainContainer;
    private static CardLayout mainCL;
    private JPanel loginPanel;
    private static JPanel organizerMenuPanel;

    public mainView(){
        createUI();
    }

    private void createUI(){
        loginPanel = loginView.getLoginPanel();
        organizerMenuPanel =menuOrganizerView.getOrganizerMenuPanel();
        mainFrame = new JFrame();
        mainCL = new CardLayout(5,5);
        mainContainer = new JPanel(mainCL);
        mainContainer.add(loginPanel, "Login");
        mainContainer.add(organizerMenuPanel, "Organizer Menu");
        mainFrame.setSize(500, 350);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.add(mainContainer);

        mainFrame.setVisible(true);
        mainCL.show(mainContainer, "Login");

    }

    public static void createPopUp(String message) {
        JOptionPane.showMessageDialog(mainFrame, message);
    }

    public static void toNextPanel(String panelName){
        mainCL.show(mainContainer, panelName);
    }

    public static void main(String[] args) {
        UserIO.readFile();
        new mainView();
    }
}
