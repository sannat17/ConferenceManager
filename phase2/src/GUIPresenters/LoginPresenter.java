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
        for (User u : users) {
            if ((username.equals(u.getUsername())) && (password.equals(u.getPassword()))) {
                mainView.toMenu();
            }
        }
        mainView.createPopUp("Your username or password is incorrect. Please enter them again.");
    }
}
