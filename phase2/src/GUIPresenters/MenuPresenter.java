package GUIPresenters;

import GUI.mainView;
import entities.User;

public class MenuPresenter {
    public static void nextPanel(String panelChoice, User u){
        switch(panelChoice){
            case "create a new user account":
                mainView.toCreateUserPanel(u);
                break;
        }
    }

    public static String[] menuOptions(User u){
        return u.getMenuOptions().toArray(new String[0]);
    }
}
