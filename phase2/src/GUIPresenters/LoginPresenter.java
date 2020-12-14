package GUIPresenters;


import GUI.mainView;
import gateways.EventIO;
import gateways.MessageIO;
import gateways.UserIO;
import useCases.AuthManager;


public class LoginPresenter {

    /**
     * Checks if the users credentials are correct and goes to the next panel
     * @param username Username of the user wanting to login
     * @param password Password of the user wanting to login
     */
    public static void loginCheck(String username, String password) {
        boolean loggedIn = AuthManager.login(username, password);
        if (loggedIn){
            mainView.addPanels();
            mainView.toPanel("Menu");
        }
        else{
            mainView.createPopUp("Your username or password is incorrect. Please enter them again.");
        }
    }

    /**
     * Reads the files
     */
    public static void readFiles(){
        UserIO.readFile();
        MessageIO.readFile();
        EventIO.readFile();
    }
}
