package GUIPresenters;

import GUI.mainView;
import gateways.EventIO;
import gateways.MessageIO;
import gateways.UserIO;
import useCases.AuthManager;

public class SignoutPresenter {

    /**
     * Signs out the current user
     */
    public static void signOut() {
        writeFiles();
        AuthManager.logout();
        mainView.toLoginPanel();
    }

    /**
     * Writes to the files
     */
    public static void writeFiles(){
        UserIO.writeFile();
        MessageIO.writeFile();
        EventIO.writeFile();
    }
}
