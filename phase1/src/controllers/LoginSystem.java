package controllers;

import java.util.*;
import entities.*;
import useCases.UserManager;

/** A login system allowing user logins if credentials match an existing user class */
public class LoginSystem {
    /**
     * Check username and password with all the Users usernames and passwords
     *
     * @param username The username of the user being checked
     * @param password The username of the user being checked
     * @return Return the user being logged in if their login information is correct otherwise returns null
     */
    public static User loginCheck(String username, String password) {
        ArrayList<User> users = UserManager.getAllUsers();
        if (users.isEmpty()) {
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