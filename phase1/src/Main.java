import controllers.*;
import entities.*;
import gateways.*;
import useCases.*;

public class Main {
    public static void main(String[] args) {
        //need to get all users and messages from files
        UserIO.readFile("/data.users.txt");
        EventIO.readFile("/data.events.txt");
        MessageIO.readFile("/data.messages.txt");
        User loggedInUser = LoginSystem.login();
    }
}
