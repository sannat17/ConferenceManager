package GUIPresenters;

import GUI.mainView;
import gateways.EventIO;
import gateways.MessageIO;
import gateways.UserIO;

public class SignoutPresenter {

    public static void signOut() {
        UserIO.writeFile();
        MessageIO.writeFile();
        EventIO.writeFile();
        mainView.toNextPanel("Login");
    }
}
