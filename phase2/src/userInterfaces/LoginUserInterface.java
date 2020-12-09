package userInterfaces;

import controllers.LoginSystem;
import useCases.AuthManager;

import java.util.Scanner;

public class LoginUserInterface {

    public static void login(){
        Scanner s = new Scanner(System.in);

        while(AuthManager.getLoggedInUser() == null) {
            System.out.println("Please enter your Username:");
            String username = s.nextLine();
            System.out.println("Please enter your Password:");
            String password = s.nextLine();
            boolean result = LoginSystem.loginCheck(username, password);
            if (!result) {
                System.out.println("Your username or password is incorrect. Please enter them again.");
            }
        }
    }
}
