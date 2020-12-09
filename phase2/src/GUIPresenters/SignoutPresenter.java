package GUIPresenters;

import GUI.mainView;
import gateways.EventIO;
import gateways.MessageIO;
import gateways.UserIO;
import useCases.AuthManager;

public class SignoutPresenter {

    public static void signOut() {
        writeFiles();
        AuthManager.logout();
        mainView.toPanel("Login");
    }

    public static void writeFiles(){
        UserIO.writeFile();
        MessageIO.writeFile();
        EventIO.writeFile();
    }
}
