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
            System.out.println(MenuPresenter.formatOptions(MenuPresenter.getOptionsDict(user.getMenuOptions())));
            Scanner s = new Scanner(System.in);
            System.out.println("Enter menu option:");

            try {
                Integer menuChoice = Integer.parseInt(s.nextLine());
                switch (MenuPresenter.getOptionsDict(user.getMenuOptions()).get(menuChoice)) {
                    case "Messages":
                        MessageUserInterface.loadMessageMenu(user);
                        break;
                    case "Events":
                        EventUserInterface.loadEventChoices(user);
                        break;
//                    case "view events":
//                        EventUserInterface.loadEvents(user);
//                        break;
//                    case "cancel an event":
//                        EventUserInterface.cancelEvent(user);
//                        break;
                    case "create a new user account":
                        UserCreationUserInterface.loadUserCreation(user);
                        break;
                    case "organize event":
                        EventOrganizationUserInterface.loadEventOrganization(user);
                    case "Sign out":
                        running = false;
                        break;
                    case "Close program":
                        UserIO.writeFile();
                        MessageIO.writeFile();
                        EventIO.writeFile();
                        running = false;
                        System.exit(0);
                        break;
                }
            } catch (Exception e) {
                System.out.println("Menu option was invalid, please try again");
            }
        }

    }

}
