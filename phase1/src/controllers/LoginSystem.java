package controllers;
import java.util.*;
import entities.*;
import useCases.UserManager;

public class LoginSystem {
    public static String[] getLoginInformation(){ //retreives username and password from a user
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter your Username:");
        String username = s.nextLine();
        System.out.println("Please enter your Password:");
        String password = s.nextLine();
        return new String[]{username, password};
    }

    public static boolean login(){
        String[] loginDetails = getLoginInformation();
        ArrayList<User> users = UserManager.getAllUsers();
        for (User u: users){
            if ((loginDetails[0].equals(u.getUsername())) && (loginDetails[1].equals(u.getPassword()))){
                return true;
            }
        }
        return false;
    }
}