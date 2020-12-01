package GUIPresenters;

import GUI.mainView;
import entities.User;
import useCases.UserManager;

public class MessagePresenter {

    public static void nextMessagePanel(String messagePanelChoice, User u){
        System.out.println(messagePanelChoice);
        switch (messagePanelChoice){
            case "View Your Events":
                mainView.toYourEventsPanel(u);
                break;

        }
    }

    public static String[] messageOptions(User u){
        return UserManager.getMessageOptionsList(u);
    }
}
