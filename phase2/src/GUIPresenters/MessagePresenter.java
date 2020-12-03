package GUIPresenters;

import GUI.mainView;
import entities.Speaker;
import entities.User;
import useCases.UserManager;
import useCases.UserTypeManager;

import java.util.ArrayList;

public class MessagePresenter {

    public static void nextMessagePanel(String messagePanelChoice, User u){
        System.out.println(messagePanelChoice);
        switch (messagePanelChoice){
            case "Message a speaker":
                mainView.toMessageUserPanel(u, "speaker");
                break;

        }
    }

    public static String[] messageOptions(User u){
        return UserManager.getMessageOptionsList(u);
    }

    public static String[] usersUsernames(String type) {
        return UserTypeManager.getUsersByType(type).toArray(new String[0]);}
}
