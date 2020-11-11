package userInterfaces;

//import controllers.MenuInput;
import controllers.MenuController;
import entities.User;
import presenters.MenuPresenter;

import java.util.ArrayList;
import java.util.Scanner;

/** A user interface for interacting with the menu */
public class MenuInterface {

    /**
     * Retrieve a menu choice from the user and return true if valid
     *
     * @return menu selection string based on user input
     */
    public static String getMenuChoice() {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter menu option:");

        return s.nextLine();
    }

    /**
     * Load the menu interface
     */
    public static void loadMenu(User user) {
        System.out.println(MenuPresenter.formatOptions(user.getMenuOptions())); //retrieve menu options from current user
    }

    //messages - 1:1 messaging, contacts, schedule, events - sign up/cancel
    //messages - 1:1 messaging, 1:many messaging, contacts,
    //           schedule, events - organize event, sign up/cancel
}
