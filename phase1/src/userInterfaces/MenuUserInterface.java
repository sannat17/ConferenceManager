package userInterfaces;

//import controllers.MenuInput;
import entities.User;
import gateways.EventIO;
import gateways.MessageIO;
import gateways.UserIO;
import presenters.MenuPresenter;

import java.util.Scanner;

/** A user interface for interacting with the menu */
public class MenuUserInterface {

    /**
     * Load the menu interface
     *
     * @param user the user of which the menu is displayed for
     */
    public static void loadMenu(User user) {

        boolean running = true;

        while (running) {
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
                    case "view events":
                        EventUserInterface.loadEvents(user);
                        break;
                    case "create user":
                        UserCreationUserInterface.loadUserCreation(user);
                        break;
                    case "organize event":
                        EventOrganizationUserInterface.loadEventOrganization(user);
                    case "sign out":
                        running = false;
                        break;

                    case "close program":
                        UserIO.writeFile("./phase1/src/data/users.txt");
                        MessageIO.writeFile("./phase1/src/data/messages.txt");
                        EventIO.writeFile("./phase1/src/data/events.txt");
                        running = false;
                        System.exit(0);
                        break;
                }
            } else {
                System.out.println("Menu option was invalid, please try again");
            }
        }

    }

}
