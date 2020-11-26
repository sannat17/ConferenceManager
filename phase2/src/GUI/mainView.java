package GUI;

import javax.swing.*;
import java.awt.*;

public class mainView {
    private JFrame mainFrame;
    private JPanel mainContainer;
    private CardLayout mainCL;
    private JPanel loginPanel;

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
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.add(mainContainer);

        mainFrame.setVisible(true);
        mainCL.show(loginPanel, "Login");

    }

    public static void main(String[] args) {
        new mainView();
    }
}
