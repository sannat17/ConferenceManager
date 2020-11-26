package GUIPresenters;


import entities.User;
import useCases.UserManager;

import java.util.ArrayList;

public class LoginPresenter {

    public static User loginCheck(String username, String password) {
        ArrayList<User> users = UserManager.getAllUsers();
        if (users.isEmpty()) {;
            return null;
        }
        for (User u : users) {
            if ((username.equals(u.getUsername())) && (password.equals(u.getPassword()))) {
                return u;
            }
        }
        return null;
    }
}
