package GUIPresenters;

import GUI.mainView;
import useCases.UserManager;

public class CreateUserPresenter {
    public static void createNewUser(String username, String password, String name, String type){
        boolean userBool = UserManager.makeNewUser(username, password, name, type);
        if (userBool == false){
            mainView.createPopUp("Could not create this user");
        }
        else{
            mainView.createPopUp("User Created!");
            mainView.toPanel("Menu");
        }
    }
}
