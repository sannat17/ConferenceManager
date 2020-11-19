package userInterfaces;

//import controllers.MenuInput;
import controllers.MenuController;
import entities.User;
import presenters.MenuPresenter;

import java.util.ArrayList;
import java.util.Scanner;

/** A user interface for interacting with the menu */
public class MenuUserInterface {

    /**
     * Load the menu interface
     */
    public static void loadMenu(User user) {
        System.out.println(MenuPresenter.formatOptions(user.getMenuOptions())); //retrieve menu options from current user

        Scanner s = new Scanner(System.in);
        System.out.println("Enter menu option:");

        String menuChoice = s.nextLine();

        if (user.getMenuOptions().contains(menuChoice)) {
            switch (menuChoice) {
                case "messages":
                    MessageUserInterface.loadMessageMenu(user);
                    break;
                case "events":
                    EventUserInterface.loadEventChoices(user);
                    break;
                case "create user":
//                UserCreationUserInterface.loadUserCreation();
                    System.out.println("FUNCTIONALITY IN PROGRESS");
                    break;
                case "sign out":
                    System.out.println("FUNCTIONALITY IN PROGRESS");
                    break;
            }
        } else {
            System.out.println("Menu option was invalid, please try again");
            loadMenu(user);
        }
    }

}
