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
        System.out.println(EventPresenter.formatOptions(EventPresenter.getSortingOptionsDict()));

        Scanner s = new Scanner(System.in);
        System.out.println("Please enter sorting option:");

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

//        String t = s.nextLine();

//        switch (t) {
//            case "signup":
//                System.out.println("Please enter the event ID of the event you would like to sign up for");
//                if (EventController.signUp(user, new Integer(s.nextLine()))) {
//                    System.out.println("Sign up successful!");
//                } else {
//                    System.out.println("Sign up failed");
//                }
//                break;
//            case "cancel signup":
//                System.out.println("Please enter the event ID of the event you would like to cancel from");
//                if (EventController.cancelSignUp(user, new Integer(s.nextLine()))) {
//                    System.out.println("Cancellation successful!");
//                } else {
//                    System.out.println("Cancellation failed");
//                }
//                break;
//            case "main menu":
//                break;
//
//            default:
//                System.out.println("Menu option was invalid, please try again");
//                loadEventChoices(user);
//        }

    }

//    public static void loadEvents(User user) {
//        System.out.println("View events by title\nView events by time\nView events by speaker\n");
//
//        Scanner s = new Scanner(System.in);
//        System.out.println("Enter sorting option (title, time, speaker):");
//
//        System.out.println(EventPresenter.formatSchedule(s.nextLine(), user.getUserID()));
//
//        System.out.println("main menu");
//        String t = s.nextLine();
//
//        switch (t){
//            case "main menu":
//                break;
//        }
//    }
//
//    public static void cancelEvent(User user){
//        System.out.println("Enter the ID of the event that you want to cancel\n");

//        Scanner s = new Scanner(System.in);
//        String eventTitle = s.nextLine();
//        String content = "Sorry, your event"+ eventTitle +"has been cancelled ";
//        if (EventController.cancelEvent(user, eventTitle)) {
//            MessageController.messageAllAttendeesOfTalk(user.getUsername(), EventManager.giveEventIDOfTitle(eventTitle), content);
//            System.out.println("Cancellation successful!");
//        } else {
//            System.out.println("Cancellation failed please recheck the title; only the organizer of the event can cancel it");
//        }
//        String t = s.nextLine();
//        switch (t){
//            case "main menu":
//                break;
//        }
//    }

}