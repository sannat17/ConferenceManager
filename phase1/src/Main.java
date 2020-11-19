import controllers.*;
import entities.*;
import gateways.*;
import useCases.*;
import userInterfaces.MenuUserInterface;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //need to get all users and messages from files
        UserIO.readFile("./phase1/src/data/users.txt");
        EventIO.readFile("./phase1/src/data/events.txt");
        MessageIO.readFile("./phase1/src/data/messages.txt");
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter your Username:");
        String username = s.nextLine();
        System.out.println("Please enter your Password:");
        String password = s.nextLine();
        s.close();
        User loggedInUser = LoginSystem.login(username, password);
        MenuUserInterface.loadMenu(loggedInUser);
    }
}
