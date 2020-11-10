package controllers;

import java.util.*;
import entities.*;
import useCases.UserManager;

/** Allows a user to login if their credentials match an existing User */
public class LoginSystem {

    /** Gets a users username and password that they input
     *
     * @return Returns an array with the inputted username and password*/
    public static String[] getLoginInformation(){
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter your Username:");
        String username = s.nextLine();
        System.out.println("Please enter your Password:");
        String password = s.nextLine();
        return new String[]{username, password};
    }

    /** Checks the inputted username and password with all the Users usernames and passwords
     *
     * @return Returns the user being logged in if their login information is correct otherwise returns null
     */
    public static User login(){
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
}