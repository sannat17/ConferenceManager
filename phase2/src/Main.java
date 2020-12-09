import GUI.mainView;
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
        new mainView();
    }
}
