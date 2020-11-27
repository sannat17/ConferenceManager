package userInterfaces;

import controllers.EventController;
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
        System.out.println("View events by title\nView events by time\nView events by speaker\n");

        Scanner s = new Scanner(System.in);
        System.out.println("Enter sorting option (title, time, speaker):");

        System.out.println(EventPresenter.formatEvents(s.nextLine(), user.getUserID()));

        System.out.println("signup \ncancel signup \nmain menu");
        String t = s.nextLine();

        switch (t) {
            case "signup":
                System.out.println("Please enter the event ID of the event you would like to sign up for");
                if (EventController.signUp(user, new Integer(s.nextLine()))) {
                    System.out.println("Sign up successful!");
                } else {
                    System.out.println("Sign up failed");
                }
                break;
            case "cancel signup":
                System.out.println("Please enter the event ID of the event you would like to cancel from");
                if (EventController.cancelSignUp(user, new Integer(s.nextLine()))) {
                    System.out.println("Cancellation successful!");
                } else {
                    System.out.println("Cancellation failed");
                }
                break;
            case "main menu":
                break;

            default:
                System.out.println("Menu option was invalid, please try again");
                loadEventChoices(user);
        }

    }

    public static void loadEvents(User user) {
        System.out.println("View events by title\nView events by time\nView events by speaker\n");

        Scanner s = new Scanner(System.in);
        System.out.println("Enter sorting option (title, time, speaker):");

        System.out.println(EventPresenter.formatEvents(s.nextLine(), user.getUserID()));

        System.out.println("main menu");
        String t = s.nextLine();

        switch (t){
            case "main menu":
                break;
        }
    }

    public static void cancelEvent(User user){
        System.out.println("Enter the title of the event that you want to cancel\n");

        Scanner s = new Scanner(System.in);

        if (EventController.cancelEvent(user, s.nextLine())) {
            System.out.println("Cancellation successful!");
        } else {
            System.out.println("Cancellation failed please recheck the title");
        }
        String t = s.nextLine();
        switch (t){
            case "main menu":
                break;
        }
    }

}