package GUIPresenters;

import GUI.mainView;
import entities.User;
import useCases.UserManager;

public class MenuPresenter {
    public static void nextPanel(String panelChoice, User u){
        switch(panelChoice){
            case "Events":
                mainView.toEventsPanel(u);
                break;
            case "create a new user account":
                mainView.toCreateUserPanel(u);
                break;
            case "Messages":
                mainView.toMessagesPanel(u);
                break;
        }
    }

    public static String[] menuOptions(User u){
        return UserManager.getMenuOptionsList(u);
    }
}
