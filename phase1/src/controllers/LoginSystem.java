package controllers;

import java.util.*;
import entities.*;
import useCases.UserManager;

// Due to getLoginInformation() this is also a UI
/** A login system allowing user logins if credentials match an existing user class */
public class LoginSystem {

    /** Get a user's username and password that they input
     *
     * @return Return an array with the inputted username and password*/
    private static String[] getLoginInformation(){    // returns list of login credentials
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter your Username:");
        String username = s.nextLine();
        System.out.println("Please enter your Password:");
        String password = s.nextLine();
        s.close();
        return new String[]{username, password};
    }

    /** Check username and password with all the Users usernames and passwords
     *
     * @return Return the user being logged in if their login information is correct otherwise returns null
     */
    private static User loginCheck(){
        String[] loginDetails = getLoginInformation();
        ArrayList<User> users = UserManager.getAllUsers();
        if (users.isEmpty()){
            return null;
        }
        for (User u: users){
            if ((loginDetails[0].equals(u.getUsername())) && (loginDetails[1].equals(u.getPassword()))){
                return u;
            }
        }
        return null;
    }


    /** Keeps checking the username and password until it matches an existing User*
     *
     * @return Returns the User being logged in
     */
    public static User login(){
        User loggedInUser = null;
        while (loggedInUser == null){
            loggedInUser = loginCheck();
            if (loggedInUser == null){
                System.out.println("Your username or password is incorrect. Please enter them again.");
            }
        }
        return loggedInUser;
    }
}