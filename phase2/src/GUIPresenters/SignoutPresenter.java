package GUIPresenters;

import GUI.mainView;
import gateways.EventIO;
import gateways.MessageIO;
import gateways.UserIO;

public class SignoutPresenter {

    public static void signOut() {
        writeFiles();
        mainView.toLoginPanel();
    }

    public static void writeFiles(){
        UserIO.writeFile();
        MessageIO.writeFile();
        EventIO.writeFile();
    }
}
