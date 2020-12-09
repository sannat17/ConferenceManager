package controllers;

import useCases.AuthManager;

/** A login system allowing user logins if credentials match an existing user class */
public class LoginSystem {

    public static String currentUsername = null;

    /**
     * Check username and password with all the Users usernames and passwords
     *
     * @param username The username of the user being checked
     * @param password The username of the user being checked
     * @return Return the user being logged in if their login information is correct otherwise returns null
     */
    public static boolean loginCheck(String username, String password) {
        return AuthManager.login(username, password);
    }
}