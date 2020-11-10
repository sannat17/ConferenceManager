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
     * @return Returns true if the inputted username and password match an existing username and password from a user
     * and returns false if it does not
     */
    public static boolean login(){
        String[] loginDetails = getLoginInformation();
        ArrayList<User> users = UserManager.getAllUsers();
        if (users.isEmpty()){
            return false;
        }
        for (User u: users){
            if ((loginDetails[0].equals(u.getUsername())) && (loginDetails[1].equals(u.getPassword()))){
                return true;
            }
        }
        return false;
    }
}