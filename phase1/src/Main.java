import controllers.*;
import entities.*;
import gateways.*;
import useCases.*;
import userInterfaces.MenuUserInterface;

public class Main {
    public static void main(String[] args) {
        //need to get all users and messages from files
        UserIO.readFile("./src/data/users.txt");
        EventIO.readFile("./src/data/events.txt");
        MessageIO.readFile("./src/data/messages.txt");
        User loggedInUser = LoginSystem.login();
        MenuUserInterface.loadMenu(loggedInUser);
    }
}
