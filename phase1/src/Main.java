import controllers.*;
import entities.*;
import gateways.*;
import useCases.*;
import userInterfaces.MenuInterface;

public class Main {
    public static void main(String[] args) {
        //need to get all users and messages from files
        User loggedInUser = LoginSystem.login();
        MenuInterface.loadMenu(loggedInUser);
        MenuController.handleMenuChoice(MenuInterface.getMenuChoice(), loggedInUser);
    }
}
