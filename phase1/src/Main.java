import controllers.*;
import entities.*;
import gateways.*;
import useCases.*;
import userInterfaces.MenuUserInterface;

public class Main {
    public static void main(String[] args) {
        //need to get all users and messages from files
        UserIO.readFile("/data.users.txt");
        EventIO.readFile("/data.events.txt");
        MessageIO.readFile("/data.messages.txt");
        User loggedInUser = LoginSystem.login();
        MenuUserInterface.loadMenu(loggedInUser);
        MenuController.handleMenuChoice(MenuUserInterface.getMenuChoice(), loggedInUser);
    }
}
