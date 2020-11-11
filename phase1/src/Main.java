import controllers.*;
import entities.*;
import gateways.*;
import useCases.*;

public class Main {
    public static void main(String[] args) {
        //need to get all users and messages from files
        User loggedInUser = LoginSystem.login();
    }
}
