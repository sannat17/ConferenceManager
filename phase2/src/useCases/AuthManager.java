package useCases;

import entities.User;
import gateways.EventIO;
import gateways.MessageIO;
import gateways.UserIO;

import java.util.ArrayList;

public class AuthManager {

    private static User loggedInUser = null;

    /**
     * Checks the users credentials
     * @param username The username of the user
     * @param password The password of the user
     * @return true if the user successfully logs in and false if it doesn't
     */
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

    /**
     * Changes the logged in user to null
     */
    public static void logout(){
        loggedInUser = null;
    }

    /**
     * Gets the ID of the logged in user
     * @return The user ID
     */
    public static int getLoggedInUserID() {
        return loggedInUser.getUserID();
    }
}
