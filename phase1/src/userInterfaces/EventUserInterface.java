package userInterfaces;

import entities.User;
import presenters.EventPresenter;
import presenters.MenuPresenter;

import java.util.Scanner;

/** The user interface for events */
public class EventUserInterface {

    /**
     * Load the event interface
     */
    public static void loadEventChoices(User user) {
        System.out.println("View events by title \n View events by time \n View events by speaker \n");

        Scanner s = new Scanner(System.in);
        System.out.println("Enter sorting option (title, time, speaker):");

        System.out.println(EventPresenter.formatEvents(s.nextLine(), user.getUserID()));

        System.out.println("signup \n cancel signup \n main menu");
        String t = s.nextLine();

        switch (t) {
            case "signup":
//                EventController.signUp();
                System.out.println("FUNCTIONALITY IN PROGRESS");
                break;
            case "cancel signup":
//                EventController.cancelSignUp();
                System.out.println("FUNCTIONALITY IN PROGRESS");
                break;
            case "main menu":
                MenuUserInterface.loadMenu(user);
                break;
        }

    }

}