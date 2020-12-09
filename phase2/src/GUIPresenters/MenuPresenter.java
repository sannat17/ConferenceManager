package GUIPresenters;

import GUI.mainView;
import entities.User;
import useCases.AuthManager;
import useCases.UserManager;

public class MenuPresenter {
    public static void nextPanel(String panelChoice){
        switch(panelChoice){
            case "Events":
                mainView.toPanel("Events");
                break;
            case "create a new user account":
                mainView.toPanel("Create User");
                break;
            case "Messages":
                mainView.toPanel("Messages");
                break;
        }
    }

    public static String[] menuOptions(){
        return UserManager.getMenuOptionsList(AuthManager.getLoggedInUser());
    }
}
