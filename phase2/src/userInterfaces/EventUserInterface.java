package userInterfaces;

import controllers.EventController;
import controllers.MessageController;
import entities.User;
import presenters.EventPresenter;
import presenters.MenuPresenter;
import useCases.EventManager;

import java.util.Scanner;

/** The user interface for events */
public class EventUserInterface {

    /**
     * Load the event interface
     */
    public static void loadEventChoices(User user) {
        System.out.println(EventPresenter.formatOptions(EventPresenter.getSortingOptionsDict(user.getEventOptions())));

        Scanner s = new Scanner(System.in);
        System.out.println("Please choose from the following:");

        try {
            System.out.println(EventPresenter.formatSchedule(s.nextLine(), user.getUserID()));
        } catch (Exception e) {
            System.out.println("Option was invalid, please try again");
            loadEventChoices(user);
        }

        System.out.println(EventPresenter.formatOptions(EventPresenter.getEventInteractionDict()));

        try {
            Integer choice = Integer.parseInt(s.nextLine());
            switch (EventPresenter.getEventInteractionDict().get(choice)) {
                case "Sign up for an event":
                    System.out.println("Please enter the event ID of the event you would like to sign up for");
                    if (EventController.signUp(user, new Integer(s.nextLine()))) {
                        System.out.println("Sign up successful!");
                    } else {
                        System.out.println("Sign up failed");
                    }
                    break;
                case "Cancel sign up for an event":
                    System.out.println("Please enter the event ID of the event you would like to cancel from");
                    if (EventController.cancelSignUp(user, new Integer(s.nextLine()))) {
                        System.out.println("Cancellation successful!");
                    } else {
                        System.out.println("Cancellation failed");
                    }
                    break;
                case "Return to main menu":
                    break;
            }
        } catch (Exception e) {
            System.out.println("Option was invalid, please try again");
        }
    }
}