import controllers.*;
import entities.*;
import gateways.*;
import useCases.*;
import userInterfaces.MenuUserInterface;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        UserIO.readFile();
        EventIO.readFile();
        MessageIO.readFile();

        try{
            EventExporter.requestExport(0);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        while (true) {
            User loggedInUser = null;
            Scanner s = new Scanner(System.in);
            while (loggedInUser == null) {
                System.out.println("Please enter your Username:");
                String username = s.nextLine();
                System.out.println("Please enter your Password:");
                String password = s.nextLine();
                loggedInUser = LoginSystem.loginCheck(username, password);
                if (loggedInUser == null) {
                    System.out.println("Your username or password is incorrect. Please enter them again.");
                }
            }
            MenuUserInterface.loadMenu(loggedInUser);
            UserIO.writeFile();
            MessageIO.writeFile();
            EventIO.writeFile();
        }
    }
}
