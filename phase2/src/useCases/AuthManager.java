package useCases;

import entities.User;
import gateways.EventIO;
import gateways.MessageIO;
import gateways.UserIO;

import java.util.ArrayList;

public class AuthManager {

    private static User loggedInUser = null;

    public static boolean login(String username, String password) {
        ArrayList<User> users = UserManager.getAllUsers();
        if (users.isEmpty()) {
            return false;
        }
        for (User u : users) {
            if ((username.equals(u.getUsername())) && (password.equals(u.getPassword()))) {
                loggedInUser = u;
                return true;
            }
        }
        return false;
    }

    public static void logout(){
        loggedInUser = null;
    }

    public static User getLoggedInUser(){
        return loggedInUser;
    }
}
