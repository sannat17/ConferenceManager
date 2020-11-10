package userInterfaces;

//import controllers.MenuInput;
import controllers.MenuController;
import presenters.MenuPresenter;

import java.util.ArrayList;
import java.util.Scanner;

/** A user interface for interacting with the menu */
public class MenuInterface {

    /**
     * Retrieve a menu choice from the user and return true if valid
     *
     * @param choice the menu decision that the user makes
     */
    public static String getMenuChoice(String choice) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter menu option:");

        return s.nextLine();
    }

    public static void main(String[] args) {
        System.out.println(MenuPresenter.getOptions(new ArrayList<>())); //retrieve menu options from current user

        MenuController.handleMenuChoice(getMenuChoice("messages"));
    }

    //messages - 1:1 messaging, contacts, schedule, events - sign up/cancel
    //messages - 1:1 messaging, 1:many messaging, contacts,
    //           schedule, events - organize event, sign up/cancel
}
