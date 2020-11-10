package controllers;
import java.util.*;

public class LoginSystem {
    public static String[] getLoginInformation(){ //retrieves username and password from a user
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter your Username:");
        String userName = s.nextLine();
        System.out.println("Please enter your Password:");
        String password = s.nextLine();
        return new String[]{userName, password};
    }
}