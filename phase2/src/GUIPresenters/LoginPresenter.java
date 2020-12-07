package GUIPresenters;


import GUI.mainView;
import entities.User;
import gateways.EventIO;
import gateways.MessageIO;
import gateways.UserIO;
import useCases.AuthManager;
import useCases.UserManager;

import java.util.ArrayList;

public class LoginPresenter {

    public static void loginCheck(String username, String password) {
        boolean loggedIn = AuthManager.login(username, password);
        if (loggedIn == true){
            mainView.toMenuPanel(UserManager.getUserFromUsername(username));
        }
        else{
            mainView.createPopUp("Your username or password is incorrect. Please enter them again.");
        }
    }

    public static void readFiles(){
        UserIO.readFile();
        MessageIO.readFile();
        EventIO.readFile();
    }
}
