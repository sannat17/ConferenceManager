import controllers.*;
import entities.*;
import gateways.*;
import useCases.*;

public class Main {
    public static void main(String[] args) {
        //need to get all users and messages from files
        boolean loggedIn = false;
        while (loggedIn == false){
            loggedIn = LoginSystem.login();
            if (loggedIn == false){
                System.out.println("Your username or password is incorrect. Please enter them again.");
            }
        }
    }
}
