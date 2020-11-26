package GUI;

import javax.swing.*;
import java.awt.*;

public class mainView {
    private static JFrame mainFrame;
    private JPanel mainContainer;
    private static CardLayout mainCL;
    private JPanel loginPanel;
    private static JPanel menuPanel;

    public mainView(){
        createUI();
    }

    private void createUI(){
        loginPanel = loginView.getLoginPanel();
        menuPanel = new JPanel();
        mainFrame = new JFrame();
        mainCL = new CardLayout(5,5);
        mainContainer = new JPanel(mainCL);
        mainContainer.add(loginPanel, "Login");
        mainContainer.add(menuPanel, "Menu");
        mainFrame.setSize(500, 350);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.add(mainContainer);

        mainFrame.setVisible(true);
        mainCL.show(loginPanel, "Login");

    }

    public static void createPopUp(String message) {
        JOptionPane.showMessageDialog(mainFrame, message);
    }

    public static void toMenu(){
        mainCL.show(menuPanel, "Menu");
    }

    public static void main(String[] args) {
        new mainView();
    }
}
