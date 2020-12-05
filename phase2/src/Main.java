import gateways.*;
import userInterfaces.*;
import useCases.AuthManager;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserIO.readFile();
        EventIO.readFile();
        MessageIO.readFile();

        while (true) {
            LoginUserInterface.login();
            MenuUserInterface.loadMenu(AuthManager.getLoggedInUser());
            AuthManager.logout();

            UserIO.writeFile();
            MessageIO.writeFile();
            EventIO.writeFile();
        }
    }
}
