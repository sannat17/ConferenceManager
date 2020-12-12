package GUIPresenters;

import GUI.mainView;
import entities.User;
import useCases.AuthManager;
import useCases.UserManager;


public class MenuPresenter {
    /**
     * Goes to the next panel depending on the choice
     * @param panelChoice The name of the next panel
     */
    public static void nextPanel(String panelChoice){
        switch(panelChoice){
            case "Events":
                mainView.toPanel("Events");
                break;
            case "Create a new user account":
                mainView.toPanel("Create User");
                break;
            case "Messages":
                mainView.toPanel("Messages");
                break;
            case "Additional Requests":
                mainView.toPanel("Additional Requests");
                break;

        }
    }

    /**
     * Gets the options for the menu
     * @return The options for the menu
     */
    public static String[] menuOptions(){
        return UserManager.getMenuOptionsList(AuthManager.getLoggedInUserID());
    }
}
