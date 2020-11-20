package controllers;

import java.util.*;
import entities.*;
import useCases.UserManager;

/** A login system allowing user logins if credentials match an existing user class */
public class LoginSystem {


    /** Check username and password with all the Users usernames and passwords
     *
     * @param username The username of the user being checked
     * @param password The username of the user being checked
     * @return Return the user being logged in if their login information is correct otherwise returns null
     */
    private static User loginCheck(String username, String password){
        ArrayList<User> users = UserManager.getAllUsers();
        if (users.isEmpty()){
            return null;
        }
        for (User u: users){
            if ((username.equals(u.getUsername())) && (password.equals(u.getPassword()))){
                return u;
            }
        }
        return null;
    }


    /** Keeps checking the username and password until it matches an existing User*
     *
     * @param username The username of the user being checked
     * @param password The username of the user being checked
     * @return Returns the User being logged in
     */
    public static User login(String username, String password){
        User loggedInUser = null;
        while (loggedInUser == null){
            loggedInUser = loginCheck(username, password);
            if (loggedInUser == null){
                System.out.println("Your username or password is incorrect. Please enter them again.");
            }
        }
        return loggedInUser;
    }
}