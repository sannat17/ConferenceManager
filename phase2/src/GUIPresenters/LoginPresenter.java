package GUIPresenters;


import GUI.mainView;
import entities.User;
import useCases.UserManager;

import java.util.ArrayList;

public class LoginPresenter {

    public static void loginCheck(String username, String password) {
        ArrayList<User> users = UserManager.getAllUsers();
        if (users.isEmpty()) {
            mainView.createPopUp("No users found");
        }
        else{
            for (User u : users) {
                if ((username.toLowerCase().equals(u.getUsername().toLowerCase())) && (password.equals(u.getPassword()))) {
                    mainView.toNextPanel("Organizer Menu");
                    return;
                }
            }
            mainView.createPopUp("Your username or password is incorrect. Please enter them again.");
        }
    }
}
