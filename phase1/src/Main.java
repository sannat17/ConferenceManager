import controllers.*;
import entities.*;
import gateways.*;
import useCases.*;

public class Main {
    public static void main(String[] args) {
        //need to get all users and messages from files
        User loggedInUser = null;
        while (loggedInUser == null){
            loggedInUser = LoginSystem.login();
            if (loggedInUser == null){
                System.out.println("Your username or password is incorrect. Please enter them again.");
            }
        }
    }
}
